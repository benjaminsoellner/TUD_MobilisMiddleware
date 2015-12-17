/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.awareness;

import de.hdm.cefx.CEFXController;

/**
 * 
 * The AwarenessController is initialised by the CEFXController. The
 * CEFXController also initialises the AwarnessWidgets and registers them with
 * the AwarenessController.
 * 
 * @author Ansgar Gerlicher
 */
public interface AwarenessController {

	/**
	 * The CEFXController also initialises the AwarnessWidgets and registers
	 * them with the AwarenessController. This is done by using the
	 * <code>registerWidget(...)</code> method.
	 * 
	 * @param widget
	 *            the widget to be registered with the AwarnessController.
	 */
	public void registerWidget(AwarenessWidget widget);

	/**
	 * The CEFXController provides the AwarenessController with a reference to
	 * it by calling the <code>setCEFXController(...)</code> method. The
	 * AwarnessController uses this reference to retrieve a reference to the
	 * NetworkController in order to send awareness events over the network.
	 * 
	 * @param impl
	 *            a reference to the CEFXController.
	 */
	public void setCEFXController(CEFXController impl);

	/**
	 * The <code>getController(...)</code> method returns the reference to the
	 * CEFXController.
	 * 
	 * @return a reference to the CEFXController.
	 */
	public CEFXController getCEFXController();

	/**
	 * When an event is to be forwarded to an awareness widget, the
	 * <code>awarenessEvent(...)</code> method of the AwarenessController must
	 * be called.
	 * 
	 * @param event
	 *            the AwarenessEvent to forward to an awareness widget.
	 */
	public void awarenessEvent(AwarenessEvent event);

	/**
	 * The method <code>propagateAwarenessEvent(...)</code> propagates an
	 * event to the other clients in a session. Before an event is visualised or
	 * propagated, it is checked, if any widget exists that is interested in
	 * such an event. If no widget is interested, the event is dropped.
	 * 
	 * @param event
	 *            the AwarnessEvent to be propagated to the other clients.
	 */
	public void propagateAwarenessEvent(AwarenessEvent event);

}
