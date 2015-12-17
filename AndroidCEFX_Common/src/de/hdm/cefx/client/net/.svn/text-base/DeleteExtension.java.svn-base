/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */

package de.hdm.cefx.client.net;

public class DeleteExtension extends OperationExtension {

	private int DOMLevel;

	public String getNamespace() {
		return super.getNamespace()+OperationExtension.DELETE;
	}

	public String toXML() {
		attr.put(ATTRNAME_DOMLEVEL, Integer.toHexString(DOMLevel));
		return super.toXML();
	}

	public void setParameterValue(String parameter,String val) {
		if (parameter.equals(ATTRNAME_DOMLEVEL)) {
			setDOMLevel(Integer.parseInt(val,16));
		}
		super.setParameterValue(parameter, val);
	}

	public int getDOMLevel() {
		return DOMLevel;
	}

	public void setDOMLevel(int level) {
		DOMLevel = level;
	}

}
