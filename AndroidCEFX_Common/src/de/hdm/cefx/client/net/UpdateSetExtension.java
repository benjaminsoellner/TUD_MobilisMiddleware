/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.client.net;

public class UpdateSetExtension extends OperationExtension {

	public String getNamespace() {
		return super.getNamespace()+OperationExtension.UPDATE_SET;
	}

	public String toXML() {
		return super.toXML();
	}

	public void setParameterValue(String parameter,String val) {
		super.setParameterValue(parameter, val);
	}
}
