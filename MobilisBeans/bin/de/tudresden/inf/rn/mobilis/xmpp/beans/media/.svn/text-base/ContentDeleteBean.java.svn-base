package de.tudresden.inf.rn.mobilis.xmpp.beans.media;

import org.xmlpull.v1.XmlPullParser;

import de.tudresden.inf.rn.mobilis.xmpp.beans.Mobilis;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;


public class ContentDeleteBean extends XMPPBean {

	private static final long serialVersionUID = 1L;
	public static final String NAMESPACE = Mobilis.NAMESPACE + "#services/ContentService";
	public static final String CHILD_ELEMENT = "content-delete";
	
	protected String uid;
	
	public void setUid(String uid) { this.uid = uid; }
	
	public String getUid() { return this.uid; }

	@Override
	public ContentDeleteBean clone() {
		ContentDeleteBean twin = new ContentDeleteBean();
		twin.id = this.id;
		twin.uid = this.uid;
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
			switch (eventType) {
			case XmlPullParser.START_TAG:
				if (parser.getName().equals("uid"))
					this.uid = parser.nextText();
				else
					parser.next();
				break;
			default:
				parser.next();
			}
			eventType = parser.getEventType(); 
		} while ( ( eventType != XmlPullParser.END_TAG
					|| !parser.getName().equals(childElement) ) 
				 && eventType != XmlPullParser.END_DOCUMENT );
	}
		
	@Override
	public String payloadToXML() {
		return new StringBuilder()
				.append("<uid>").append(this.uid).append("</uid>")
				.toString();
	}
	
	@Override
	public String getChildElement() {
		return ContentDeleteBean.CHILD_ELEMENT;
	}

	@Override
	public String getNamespace() {
		return ContentDeleteBean.NAMESPACE;
	}

}
