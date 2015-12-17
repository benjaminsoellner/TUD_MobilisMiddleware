/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.concurrency.operations;

import java.io.Serializable;

import de.hdm.cefx.exceptions.NodePositionException;

/**
 * A TextUpdate contains the UUID of a text node's parent node (the target
 * node), the UUIDs of its left and right siblings (if existing) and the text
 * content.
 *
 * @author Ansgar Gerlicher
 *
 */
public class TextUpdate implements Serializable {

	String leftSiblingId = null;

	String rightSiblingId = null;

	String textValue = null;

	String parentId = null;

	/**
	 * Class constructor.
	 *
	 * @param parentId
	 *            the UUID of the parent node.
	 * @param left
	 *            the UUID of the left sibling.
	 * @param text
	 *            the text between the siblings.
	 * @param right
	 *            the UUID of the right sibling.
	 */
	public TextUpdate(String parentId, String left, String text, String right) {
		this.parentId = parentId;
		leftSiblingId = left;
		rightSiblingId = right;
		textValue = text;
		System.out.println("TextUpdate.TextUpdate()");
	}

	/**
	 * Retrieves the left sibling's UUID.
	 *
	 * @return UUID of the left sibling.
	 */
	public String getLeftSiblingId() {
		return leftSiblingId;
	}

	/**
	 * Sets the left sibling UUID.
	 *
	 * @param leftSiblingId
	 *            UUID of the left sibling.
	 */
	public void setLeftSiblingId(String leftSiblingId) {
		this.leftSiblingId = leftSiblingId;
	}

	/**
	 * Retrieves the UUID of the right sibling.
	 *
	 * @return the UUID of the right sibling.
	 */
	public String getRightSiblingId() {
		return rightSiblingId;
	}

	/**
	 * Sets the UUID of the right sibling.
	 *
	 * @param rightSiblingId
	 *            the UUID of the right sibling.
	 */
	public void setRightSiblingId(String rightSiblingId) {
		this.rightSiblingId = rightSiblingId;
	}

	/**
	 * Retrieves the text value.
	 *
	 * @return the text value.
	 */
	public String getTextValue() {
		return textValue;
	}

	/**
	 * Sets the text value.
	 *
	 * @param textValue
	 *            the text value.
	 */
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	/**
	 * Retrieves the node position.
	 *
	 * @return the position of the node.
	 */
	public NodePosition getNodePosition() {
		System.out.println("TextUpdate.getNodePosition()");
		if (leftSiblingId == null || leftSiblingId.equals("")) {
			if (rightSiblingId == null || rightSiblingId.equals("")) {
				try {
					return new NodePosition(parentId, null, NodePosition.INSERT_AFTER);
				} catch (NodePositionException e) {
					e.printStackTrace();
				}
			} else {
				try {
					return new NodePosition(parentId, rightSiblingId, NodePosition.INSERT_BEFORE);
				} catch (NodePositionException e) {
					e.printStackTrace();
				}
			}
		} else {
			if (rightSiblingId == null || rightSiblingId.equals("")) {
				try {
					return new NodePosition(parentId, leftSiblingId, NodePosition.INSERT_AFTER);
				} catch (NodePositionException e) {
					e.printStackTrace();
				}
			} else {
				try {
					return new NodePosition(parentId, rightSiblingId, NodePosition.INSERT_BEFORE);
				} catch (NodePositionException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + leftSiblingId + ")[" + textValue + "](" + rightSiblingId + ")";
	}
}
