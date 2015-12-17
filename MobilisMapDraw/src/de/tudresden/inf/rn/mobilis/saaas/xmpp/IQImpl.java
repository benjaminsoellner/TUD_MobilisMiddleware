/**
 * 
 */
package de.tudresden.inf.rn.mobilis.saaas.xmpp;

import org.jivesoftware.smack.packet.IQ;

/**
 * @author koren
 *
 */
public class IQImpl extends IQ {

	// members
	private String childElementXML;
	
	public IQImpl (String childElementXML) {
		super();
		this.childElementXML = childElementXML;
	}
	
	/* (non-Javadoc)
	 * @see org.jivesoftware.smack.packet.IQ#getChildElementXML()
	 */
	@Override
	public String getChildElementXML() {
		return childElementXML;
	}

}
