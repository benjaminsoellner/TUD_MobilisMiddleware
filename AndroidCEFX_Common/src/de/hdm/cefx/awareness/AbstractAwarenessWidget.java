/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */

package de.hdm.cefx.awareness;

/**
 * 
 * The base class for implementing AwarenessWidgets.
 * 
 * @author Ansgar Gerlicher
 */
public abstract class AbstractAwarenessWidget implements AwarenessWidget {

	/**
	 * Reference to the AwarenessController
	 */
	protected AwarenessController ac;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessWidget#notifyOfAwarenessEvent(de.hdm.cefx.awareness.AwarenessEvent)
	 */
	public abstract void notifyOfAwarenessEvent(AwarenessEvent event);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessWidget#hasInterestIn(de.hdm.cefx.awareness.AwarenessEvent)
	 */
	public abstract boolean hasInterestIn(AwarenessEvent event);

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessWidget#setAwarenessController(de.hdm.cefx.awareness.AwarenessController)
	 */
	public void setAwarenessController(AwarenessController ac) {
		this.ac = ac;
	}
}
