package de.tudresden.inf.rn.mobilis.xmpp.beans.media;

import org.xmlpull.v1.XmlPullParser;

import de.tudresden.inf.rn.mobilis.xmpp.beans.Mobilis;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;


public class ContentRegisterBean extends XMPPBean {

	private static final long serialVersionUID = 1L;
	public static final String NAMESPACE = Mobilis.NAMESPACE + "#services/ContentService";
	public static final String CHILD_ELEMENT = "repository-register";

	@Override
	public ContentRegisterBean clone() {
		ContentRegisterBean twin = new ContentRegisterBean();
		twin.id = this.id;
		twin.from = this.from;
		twin.to = this.to;
		twin.type = this.type;
		return twin;
	}

	@Override
	public void fromXML(XmlPullParser parser) throws Exception {
		int eventType = parser.getEventType();
		String childElement = this.getChildElement();
		do {
			eventType = parser.next();
		} while ( ( eventType != XmlPullParser.END_TAG
					|| !parser.getName().equals(childElement) ) 
				 && eventType != XmlPullParser.END_DOCUMENT );
	}
	
	@Override
	public String payloadToXML() {
		return "";
	}
	
	@Override
	public String getChildElement() {
		return ContentRegisterBean.CHILD_ELEMENT;
	}

	@Override
	public String getNamespace() {
		return ContentRegisterBean.NAMESPACE;
	}

}
