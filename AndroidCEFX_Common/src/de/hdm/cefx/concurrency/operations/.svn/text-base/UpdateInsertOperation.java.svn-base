/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency.operations;

public class UpdateInsertOperation extends UpdateOperations {

	private int     textPos;
	private int     undoTextPos;
	private String  text;

	public UpdateInsertOperation() {
		textPos=0;
		text="";
	}

	public UpdateInsertOperation(String text,int textPos, int nodeType, NodePosition nodePosition, String attributName) {
		operation=UpdateOperations.INSERT;
		this.text=text;
		this.textPos=textPos;
		this.undoTextPos=textPos;
		this.nodeType=nodeType;
		this.nodePosition=nodePosition;
		this.attributName=attributName;
	}

	public void undoTransformation() {
		textPos=undoTextPos;
	}

	public boolean isReady() {
		if (textPos<0) return false;
		if (nodePosition==null) return false;
		return super.isReady();
	}

	public int getTextPos() {
		return textPos;
	}

	public void setTextPos(int textPos) {
		this.textPos = textPos;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
