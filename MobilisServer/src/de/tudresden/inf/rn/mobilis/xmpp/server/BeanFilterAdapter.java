package de.tudresden.inf.rn.mobilis.xmpp.server;

import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;

import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class BeanFilterAdapter implements PacketFilter {

	private XMPPBean prototype;
	
	public BeanFilterAdapter(XMPPBean prototype) {
		this.prototype = prototype;
	}

	@Override
	public boolean accept(Packet p) {
		if (p instanceof BeanIQAdapter) {
			BeanIQAdapter biq = (BeanIQAdapter) p;
			return this.prototype.getNamespace().equals( biq.getNamespace() );
		} else
			return false;
	}
	
}
