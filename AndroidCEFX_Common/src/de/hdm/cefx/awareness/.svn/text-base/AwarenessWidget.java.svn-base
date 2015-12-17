/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */

package de.hdm.cefx.awareness;

/**
 * The AwarenessWidget interface defines the methods that must be implemented by
 * an awareness widget.
 * 
 * @author Ansgar Gerlicher
 * 
 */
public interface AwarenessWidget {
	/**
	 * The <code>notifyOfAwarenessEvent(...)</code> method is called by the
	 * framework when the corresponding event (e.g. key event) has occurred and
	 * should contain the code that presents the event in some way to the user.
	 * 
	 * @param event
	 *            the AwarenessEvent that this widget is interested in.
	 */
	public void notifyOfAwarenessEvent(AwarenessEvent event);

	/**
	 * The method <code>hasInterestIn</code> is called just before the widget
	 * is notified of an event and should contain code that checks if the given
	 * event is relevant to the widget. For example a widget that will notify
	 * the user of key strokes may not be interested in mouse events or vice
	 * versa.
	 * 
	 * @param event 
	 *            the AwarenessEvent that may be of interest.
	 * @return true if the AwarenessWidget is interested in the event.
	 */
	public boolean hasInterestIn(AwarenessEvent event);

	/**
	 * When a widget is registered with the AC, it is provided with a reference
	 * to it by a call to the <code>setAwarenessController(...)</code> method.
	 * 
	 * @param ac 
	 *            a reference to the AwarenessController.
	 */
	public void setAwarenessController(AwarenessController ac);

	/**
	 * The AwarenessController initialises the widget by calling its
	 * <code>init()</code> method. When initialised, a widget usually displays
	 * some sort of window or dialogue to the user.
	 */
	public void init();
}
