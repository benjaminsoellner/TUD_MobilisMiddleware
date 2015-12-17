package de.tudresden.inf.rn.mobilis.xmpp.server;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.xmlpull.v1.XmlPullParser;

import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class BeanProviderAdapter implements IQProvider {
	
	private XMPPBean prototype;
	
	public BeanProviderAdapter(XMPPBean prototype) {
		this.prototype = prototype;
	}
	
	@Override
	public IQ parseIQ(XmlPullParser parser) throws Exception {
		XMPPBean bean = this.prototype.clone();
		bean.fromXML(parser);
		return new BeanIQAdapter(bean);
	}

	public void addToProviderManager() {
		ProviderManager.getInstance().addIQProvider(
				this.prototype.getChildElement(),
				this.prototype.getNamespace(),
				this);
	}
	
	
}
