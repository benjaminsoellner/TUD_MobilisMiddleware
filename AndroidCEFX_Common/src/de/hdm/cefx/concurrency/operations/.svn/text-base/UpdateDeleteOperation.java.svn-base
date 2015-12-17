/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency.operations;

public class UpdateDeleteOperation extends UpdateOperations {

	private int textPos;
	private int length;
	private int undoTextPos;
	private int undoLength;

	public UpdateDeleteOperation() {
		textPos=0;
		length=0;
	}

	public UpdateDeleteOperation(int textPos,int length, int nodeType, NodePosition nodePosition, String attributName) {
		operation=UpdateOperations.DELETE;
		this.length=length;
		this.undoLength=length;
		this.textPos=textPos;
		this.undoTextPos=textPos;
		this.nodeType=nodeType;
		this.nodePosition=nodePosition;
		this.attributName=attributName;
	}

	public void undoTransformation() {
		textPos=undoTextPos;
		length=undoLength;
	}

	public boolean isReady() {
		if (textPos<0) return false;
		if (length<0) return false;
		return super.isReady();
	}

	public int getTextPos() {
		return textPos;
	}

	public void setTextPos(int textPos) {
		this.textPos = textPos;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}


}
