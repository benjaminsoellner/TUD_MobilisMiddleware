/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.exceptions;

/**
 * The Exception that is thrown if a position within the document does not exist.
 * @author Ansgar Gerlicher
 *
 */
@SuppressWarnings("serial")
public class NodePositionException extends Exception {

	/**
	 * Class constructor.
	 * @param string the exception description.
	 */
	public NodePositionException(String string) {
		super(string);
	}



}
