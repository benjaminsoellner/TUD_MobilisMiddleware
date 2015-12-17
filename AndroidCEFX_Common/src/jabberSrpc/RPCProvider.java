/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package jabberSrpc;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.xmlpull.v1.XmlPullParser;

public class RPCProvider implements IQProvider {

	String   methodName;
	String   data;
	boolean  request;
	boolean  response;

	public IQ parseIQ(XmlPullParser parser) throws Exception {
		RPCPacket packet=null;
		boolean   run=true;
		String    text="";
		String    name;

		methodName=null;
		data=null;
		request=false;
		response=false;

        while(run) {
            int eventType;
            eventType = parser.next();

            switch(eventType) {
                case XmlPullParser.START_TAG:
                	text="";
                	name=parser.getName();
                	if ("methodCall".equals(name)) {
                		request=true;
                	}
                	if ("methodResponse".equals(name)) {
                		request=true;
                	}
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if("query".equals(name)) {
                        run = false;
                    } else {
                        endElement(name,text);
                    }
                    break;
                case XmlPullParser.TEXT:
                	String s=parser.getText();

                	if (s.length()>13) {
                		if (s.startsWith("<![CDATA[")) {
                			s=s.substring(9, s.length()-3);
                		}
                	}

                    text=text+s;
                    break;
            }
        }

        if (request || response) {
        	packet=new RPCPacket();
        	packet.setStringData(data);
        	packet.setMethodName(methodName);
        	if (request) { packet.setPacketType(RPCPacket.REQUEST); }
        	if (response) { packet.setPacketType(RPCPacket.RESPONSE); }
        }

        return packet;
	}

	private void endElement(String tag,String text) {
		if ("methodName".equals(tag)) {
			methodName=text.trim();
		}
		if ("base64".equals(tag)) {
			data=text;
		}
	}

}
