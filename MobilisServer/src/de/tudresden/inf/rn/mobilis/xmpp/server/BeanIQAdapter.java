package de.tudresden.inf.rn.mobilis.xmpp.server;

import org.jivesoftware.smack.packet.IQ;

import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class BeanIQAdapter extends IQ {

	private XMPPBean adaptee;

	public BeanIQAdapter(XMPPBean adaptee) {
		super();
		this.adaptee = adaptee;
	}
	
	public XMPPBean getBean() {
		return this.adaptee;
	}
	
	public String getChildElement() {
		return this.adaptee.getChildElement();
	}
	
	public String getNamespace() {
		return this.adaptee.getNamespace();
	}
	
	@Override
	public String getChildElementXML() {
		return this.adaptee.toXML();
	}
	
	@Override
	public String getFrom() {
		return this.adaptee.getFrom();
	}
	
	@Override
	public void setFrom(String from) {
		super.setFrom(from);
		this.adaptee.setFrom(from);
	}
	
	@Override
	public String getTo() {
		return this.adaptee.getTo();
	}
	
	@Override
	public void setTo(String to) {
		super.setTo(to);
		this.adaptee.setTo(to);
	}
	
	
	public Type getType() {
		switch (this.adaptee.getType()) {
		case XMPPBean.TYPE_GET:
			return IQ.Type.GET;
		case XMPPBean.TYPE_SET:
			return IQ.Type.SET;
		case XMPPBean.TYPE_ERROR:
			return IQ.Type.ERROR;
		case XMPPBean.TYPE_RESULT:
			return IQ.Type.RESULT;
		default:
			return IQ.Type.GET;
		}
	}
	
	@Override
	public void setType(IQ.Type type) {
		super.setType(type);
		if (type == IQ.Type.ERROR)
			this.adaptee.setType(XMPPBean.TYPE_ERROR);
		else if (type == IQ.Type.RESULT)
			this.adaptee.setType(XMPPBean.TYPE_RESULT);
		else if (type == IQ.Type.GET)
			this.adaptee.setType(XMPPBean.TYPE_GET);
		else if (type == IQ.Type.SET)
			this.adaptee.setType(XMPPBean.TYPE_SET);
		else 
			this.adaptee.setType(XMPPBean.TYPE_GET);
	}
	
	@Override
	public String getPacketID() {
		return this.adaptee.getId();
	}
	
	@Override
	public void setPacketID(String packetID) {
		super.setPacketID(packetID);
		this.adaptee.setId(packetID);
	}
	
}
