/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.client.net;

import org.jivesoftware.smack.packet.PacketExtension;
import org.jivesoftware.smack.provider.PacketExtensionProvider;
import org.xmlpull.v1.XmlPullParser;

public class UpdateInsertExtensionProvider implements PacketExtensionProvider {

	public PacketExtension parseExtension(XmlPullParser parser) throws Exception {
		UpdateInsertExtension pe=new UpdateInsertExtension();

		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_TAG) {
			if (eventType == XmlPullParser.START_TAG) {
				int count=parser.getAttributeCount();
				int ii;
				for (ii=0; ii<count; ii++) {
					String name=parser.getAttributeName(ii);
					String val=parser.getAttributeValue(ii);
					pe.setParameterValue(name, val);
				}
			} else if (eventType == XmlPullParser.TEXT) {
				pe.setContent(parser.getText());
			}
			eventType = parser.next();
		}

		return pe;
	}

}
