/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */

package de.hdm.cefx.awareness;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import de.hdm.cefx.CEFXController;
import de.hdm.cefx.awareness.events.EventPropagator;

/**
 * 
 * Implementation of AwarenessController.
 * 
 * @author Ansgar Gerlicher
 */
public class AwarenessControllerImpl implements AwarenessController {
	private final Logger LOG = Logger.getLogger(AwarenessControllerImpl.class.getName());

	/**
	 * Set of registered AwarenessWidgets.
	 */
	protected Set<AwarenessWidget> widgets;

	/**
	 * Reference to the CEFXController.
	 */
	protected CEFXController cefx;

	/**
	 * Set of awareness event types the registered widgets are interested in.
	 */
	private Set<String> interestingEvents;

	/**
	 * Constructor.
	 */
	public AwarenessControllerImpl() {
		// listeners = new ArrayList<AwarenessListener>();
		widgets = new HashSet<AwarenessWidget>();
		interestingEvents = new HashSet<String>();
		EventPropagator.setAwarenessController(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessController#registerWidget(de.hdm.cefx.awareness.AwarenessWidget)
	 */
	public void registerWidget(AwarenessWidget widget) {
		widgets.add(widget);
		widget.setAwarenessController(this);
		widget.init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessController#setCEFXController(de.hdm.cefx.CEFXController)
	 */
	public void setCEFXController(CEFXController impl) {
		cefx = impl;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessController#awarenessEvent(de.hdm.cefx.awareness.AwarenessEvent)
	 */
	public void awarenessEvent(AwarenessEvent event) {
		LOG.info("AwarenessController received Awareness Event: " + event);
		for (AwarenessWidget widget : widgets) {

			if (widget.hasInterestIn(event)) {
				widget.notifyOfAwarenessEvent(event);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessController#propagateAwarenessEvent(de.hdm.cefx.awareness.AwarenessEvent)
	 */
	public void propagateAwarenessEvent(AwarenessEvent event) {

		// see if a widget exists, that is interested in the event.
		// If there is one, then propagate the event

		if (event.getEventSource() == null) {
			// if the source was not given, the set the source to the client
			// name
			event.setEventSource(cefx.getClient().getName());
		}

		if (interestingEvents.contains(event.getType())) {
			cefx.getNetworkController().propagateAwarenessEvent(event);
			return;
		}

		boolean interestedWidgetExists = false;
		for (AwarenessWidget widget : widgets) {

			if (widget.hasInterestIn(event)) {
				interestedWidgetExists = true;
				interestingEvents.add(event.getType());
			}
		}
		if (interestedWidgetExists) {
			cefx.getNetworkController().propagateAwarenessEvent(event);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hdm.cefx.awareness.AwarenessController#getCEFXController()
	 */
	public CEFXController getCEFXController() {

		return cefx;
	}

}
