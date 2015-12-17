package de.hdm.cefx;

import org.w3c.dom.Node;

/**
 * Abstract observer class, which can be registered at the DataModelAbstraction to
 * get notified if the data model got altered by remote operations.
 * @author Dirk Hering
 */
public abstract class DataModelObserver {

	/**
	 * Called by the DataModelAbstraction to notify this observer of changes.
	 * @param changedNode the Node which got affected by a change, more precisely the node which got 
	 * inserted, updated or deleted (in case of an atomic operation on the xml document)
	 * @param modification
	 * @param complex
	 */
//	public abstract void update(Node changedNode, ModelModificationType modification, ComplexOperationEvent complex);
	
}
