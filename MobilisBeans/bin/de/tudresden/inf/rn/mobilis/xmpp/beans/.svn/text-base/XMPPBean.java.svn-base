package de.tudresden.inf.rn.mobilis.xmpp.beans;


public abstract class XMPPBean implements Cloneable, XMPPInfo {
	
	private static final long serialVersionUID = 1L;
	public static final int TYPE_SET = 0;
	public static final int TYPE_GET = 1;
	public static final int TYPE_RESULT = 2;
	public static final int TYPE_ERROR  = 3;
	
	public static int currentId = 0;
	
	protected int type;
	protected String id;
	protected String from;
	protected String to;
	
	public void setType(int type) { this.type = type; }
	public void setId(String id) { this.id = id; }
	public void setFrom(String from) { this.from = from; }
	public void setTo(String to) { this.to = to; }
	
	public int getType() { return this.type; }
	public String getId() { return this.id; }
	public String getFrom() { return this.from; }
	public String getTo() { return this.to; }

	public XMPPBean() {
		this.id = "mobilis_"+XMPPBean.currentId; 
		XMPPBean.currentId++; 
	}
	
	public String toXML() {
		String childElement = this.getChildElement();
		String namespace = this.getNamespace(); 
		return new StringBuilder()
				.append("<")
				.append(childElement)
				.append(" xmlns=\"")
				.append(namespace)
				.append("\">")
				.append(this.payloadToXML())
				.append("</")
				.append(childElement)
				.append(">")
				.toString();
	}
	
	public abstract XMPPBean clone();
	public abstract String payloadToXML();
}
