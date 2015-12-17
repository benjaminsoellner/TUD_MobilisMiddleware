/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.awareness;

import java.io.Serializable;

/**
 * 
 * The AwarenessEvent class carries awareness event information such as the type
 * of an event, the event description, the source of the event (for example the
 * clients name) and an event object. The event object can be of any type, it is
 * only required that the awareness widget that is interested in that event
 * knows how to deal with it.
 * 
 * @author Ansgar Gerlicher
 */
@SuppressWarnings("serial")
public class AwarenessEvent implements Serializable {

	String description;

	String type;

	String eventSource;

	Object event;

	/**
	 * Constructor. Used to create a new AwarenessEvent object.
	 * 
	 * @param type
	 *            the type of awareness event such as events defined in
	 *            <code>AwarenessEventTypes</code> for example:
	 *            AwarenessEventTypes.MOUSE_EVENT.
	 * @param name
	 *            the individual desciption of the event. This is could be used
	 *            to display information about the event to the user.
	 * @param obj
	 *            the event object. The AwarenessWidget should know how to
	 *            handle this object.
	 * @param source
	 *            the source that issued the event. For example, the clients
	 *            name.
	 */
	public AwarenessEvent(String type, String name, Object obj, String source) {
		this.type = type;
		this.description = name;
		this.event = obj;
		this.eventSource = source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Awareness Event: " + description + " object: " + event;
	}

	/**
	 * @return returns the type of event.
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return returns the event's description.
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * @return returns the event object.
	 */
	public Object getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            used to set the event object to this event.
	 */
	public void setEvent(Object event) {
		this.event = event;
	}

	/**
	 * @return returns the description of the event source.
	 */
	public String getEventSource() {
		return eventSource;
	}

	/**
	 * @param eventSource
	 *            used to set the event source description.
	 */
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	/**
	 * @param description
	 *            used to set the event description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param type
	 *            used to set the type of event.
	 */
	public void setType(String type) {
		this.type = type;
	}
}
