/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency;

import java.util.Collection;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import de.hdm.cefx.client.net.CEFXSession;
import de.hdm.cefx.concurrency.operations.Operation;
import de.hdm.cefx.concurrency.operations.OperationExecutor;
import de.hdm.cefx.concurrency.operations.StateVector;
import de.hdm.cefx.server.DocumentData;

/**
 * The ConcurrencyController interface defines the basic methods of the
 * concurrency controller.
 *
 * @author Ansgar Gerlicher
 *
 */
public interface ConcurrencyController {
	/**
	 * The methods <code>executeLocalOperation(Operation operation)</code> and
	 * <code>executeRemoteOperation(Operation operation)</code> are called by
	 * the CEFXController if either the user issued a local operation, or a new
	 * remote operation was received over the network from another site.
	 *
	 * @param operation
	 *            the operation to be executed.
	 * @return true if the execution was successful.
	 */
	public boolean executeLocalOperation(Operation operation);

	/**
	 * The methods <code>executeLocalOperation(Operation operation)</code> and
	 * <code>executeRemoteOperation(Operation operation)</code> are called by
	 * the CEFXController if either the user issued a local operation, or a new
	 * remote operation was received over the network from another site.
	 *
	 * @param operation
	 *            the operation to be executed.
	 * @return true if the execution was successful.
	 */
	public boolean executeRemoteOperation(Operation operation);

	/**
	 * The method <code>getStateVector()</code> is used for retrieving the
	 * current local state vector and setting the value of the state vector of a
	 * new operation to the current state vector value.
	 *
	 * @return the state vector of the site.
	 */
	public StateVector getStateVector();

	public void setStateVector(StateVector sv);

	/**
	 * The method <code>getHistoryBuffer()</code> is used for clearing the
	 * history buffer after loading a document and initialising a new editing
	 * session.
	 *
	 * @return the history buffer of executed operations.
	 */
	public Collection<Operation> getHistoryBuffer();

	/**
	 * The method <code>setDocument(Document localDoc)</code> provides the
	 * concurrency controller with a reference to the new document which is to
	 * be taken under concurrency control. After setting the document reference,
	 * the concurrency controller analyses the document and starts to index
	 * every node by adding each node in the document to the controller's map of
	 * nodes (nodeMap).
	 *
	 * @param doc
	 *            the document that is to be edited.
	 */
	public void setDocument(Document doc);

	/**
	 * The method <code>setOperationExecuter(OperationExecutor impl)</code>
	 * provides the ConcurrencyController with a reference to the
	 * OperationExecutor object. This method is called by the CEFXController
	 * when initialising the ConcurrencyController.
	 *
	 * @param impl
	 *            a reference to the OperationExecutor.
	 */
	public void setOperationExecutor(OperationExecutor impl);

	public void setSession(CEFXSession session);

	public HashMap<Operation, Node> getDeletedNodesMap();

	/**
	 * The method <code>setCollaborationReady(...)</code> is used to set the
	 * state of the framework to either �ready for collaboration� or �not ready
	 * for collaboration�. The framework is set to �ready for collaboration�
	 * when all necessary initialisation has been performed and the
	 * collaboration can begin.
	 *
	 * @return true if the framework is ready for collaboration.
	 */
	public boolean isCollaborationReady();

	/**
	 * Sets the framework to either "ready for collaboration" or not.
	 *
	 * @param readyState
	 *            true for setting the framework to "ready for collaboration".
	 */
	public void setCollaborationReady(boolean collaborationReady);

	public void reset();

	public Document setDocumentData(DocumentData data);
}
