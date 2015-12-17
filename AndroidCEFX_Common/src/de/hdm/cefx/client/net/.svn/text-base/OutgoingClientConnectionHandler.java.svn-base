/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 * @author Michael Voigt
 */
package de.hdm.cefx.client.net;

import jabberSrpc.JabberClient;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.hdm.cefx.awareness.AwarenessEvent;
import de.hdm.cefx.client.CEFXClient;
import de.hdm.cefx.concurrency.operations.Operation;

/**
 * The OutgoingClientConnectionHandler stores a reference to each client's
 * ClientConnection interface and uses the java.rmi.Naming interface to lookup
 * the remote interface (ClientConnection) of the new joined client.
 *
 * @author Ansgar Gerlicher
 *
 */
public class OutgoingClientConnectionHandler {
	private HashMap<CEFXClient, ClientConnection_CStub> clientConnections;

	ExecutorService tpe;

	/**
	 * Class constructor. This class is aware of all connections to clients
	 * within a session. If any message is to be send to a client, it is done
	 * via this class.
	 */
	public OutgoingClientConnectionHandler() {
		clientConnections = new HashMap<CEFXClient, ClientConnection_CStub>();
		// Ansgar Test
		// tpe = Executors.newCachedThreadPool();
		tpe = Executors.newSingleThreadExecutor();
	}

	/**
	 * Delegates the execution of operations to the other clients in the
	 * session.
	 *
	 * @param operation
	 *            the operation to be executed.
	 */
	public void executeOperation(final Operation operation) {

		Collection<ClientConnection_CStub> clients = clientConnections.values();
		for (final ClientConnection_CStub client : clients) {

			Runnable runner = new Runnable() {
				public void run() {
					Thread.yield();
					client.executeOperation(operation);
					Thread.yield();
				}
			};

			tpe.execute(runner);

		}

	}

	/**
	 * Adding the connection of a new client to the
	 * OutgoingClientConnectionHandler.
	 *
	 * @param client
	 *            the client that will be added.
	 */
	public void addClientConnection(CEFXClient client) {
		ClientConnection_CStub connection = new ClientConnection_CStub(JabberClient.getInstance());
		connection.setTarget(client.getConnectionString());
		connection.setThreadID(client.getThreadID());
		clientConnections.put(client, connection);
	}

	/**
	 * Propagates the awareness event to all clients in the session.
	 *
	 * @param event
	 *            the awareness event object.
	 */
	public void awarenessEvent(final AwarenessEvent event) {
		Collection<ClientConnection_CStub> clients = clientConnections.values();
		for (final ClientConnection_CStub client : clients) {

			Runnable runner = new Runnable() {
				public void run() {
					client.awarenessEvent(event);
					Thread.yield();
				}
			};
			tpe.execute(runner);

		}

	}

}
