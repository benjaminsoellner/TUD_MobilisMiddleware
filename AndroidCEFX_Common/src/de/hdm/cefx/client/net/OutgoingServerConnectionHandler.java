/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 * @author Michael Voigt
  */
package de.hdm.cefx.client.net;

import jabberSrpc.JabberClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.hdm.cefx.server.ServerConnection_CStub;

/**
 * The OutgoingServerConnectionHandler then uses the java.rmi.Naming interface
 * to lookup the server interface and open a connection to it using the server
 * connection URI. The server connection URI identifies the server resource in
 * the network. If the connection to the server was established, the
 * NetworkController retrieves a ServerConnection object from the
 * OutgoingServerConnectionHandler and calls its
 * <code>connect(CEFXClient client,
 * String documentURI)</code> method.
 *
 * @author Ansgar Gerlicher
 *
 */
public class OutgoingServerConnectionHandler {
	private ServerConnection_CStub serverConnection = null;

	private boolean isConnected = false;

	ExecutorService tpe;

	/**
	 * Class constructor.
	 */
	public OutgoingServerConnectionHandler() {
		tpe = Executors.newSingleThreadExecutor();
	}

	/**
	 * Establishes a connection to the CEFX server.
	 *
	 * @param connectionString
	 *            the URI that identifies the server within the network.
	 * @return true if a connection was successfully established.
	 */
	public boolean connectToServer(String connectionString) {
		serverConnection=new ServerConnection_CStub(JabberClient.getInstance());
		serverConnection.setTarget(connectionString);

		//prüfen ob der CEFXServer bei Jabber angemeldet ist
//		boolean online=JabberClient.getInstance().isUserAvailable(connectionString);
		return true;
	}

	/**
	 * Allows to retrieve the server connection interface.
	 *
	 * @return the ServerConnection interface.
	 */
	public ServerConnection_CStub getServerConnection() {
		return serverConnection;
	}

	/**
	 * Propagates the operation that is to be executed to the server.
	 *
	 * @param operation
	 *            the operation that is to be executed.
	 */
/*	public void executeOperation(final Operation operation) {
		System.out.println("OutgoingServerConnectionHandler.executeOperation()");

		Runnable runner = new Runnable() {
			public void run() {
				Thread.yield();
				boolean executed = serverConnection.executeOperation(operation);
				System.out.println("OutgoingServerConnectionHandler.executeOperation() execution successfull? " + executed);
				Thread.yield();
			}
		};

		tpe.execute(runner);

	}*/
}
