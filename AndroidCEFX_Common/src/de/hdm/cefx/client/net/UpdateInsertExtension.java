/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.client.net;

public class UpdateInsertExtension extends OperationExtension {

	private int               pos;

	public String getNamespace() {
		return super.getNamespace()+OperationExtension.UPDATE_INSERT;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String toXML() {
		attr.put(ATTRNAME_POSITION, Integer.toHexString(pos));
		return super.toXML();
	}

	public void setParameterValue(String parameter,String val) {
		if (parameter.equals(ATTRNAME_POSITION)) {
			setPos(Integer.parseInt(val,16));
		}
		super.setParameterValue(parameter, val);
	}
}
