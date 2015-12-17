/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency.operations;

public class UpdateSetOperation extends UpdateOperations {

	private String text;

	public UpdateSetOperation() {
		text=null;
	}

	public UpdateSetOperation(String text, int nodeType, NodePosition nodePosition, String attributName) {
		operation=UpdateOperations.SET;
		this.text=text;
		this.nodeType=nodeType;
		this.nodePosition=nodePosition;
		this.attributName=attributName;
	}

	public boolean isReady() {
		if (text==null) return false;
		return super.isReady();
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
