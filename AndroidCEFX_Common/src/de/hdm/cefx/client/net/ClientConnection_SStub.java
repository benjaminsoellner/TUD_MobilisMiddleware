/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */

package de.hdm.cefx.client.net;

import jabberSrpc.JabberClient;
import jabberSrpc.Stub;

import java.util.logging.Logger;

import de.hdm.cefx.awareness.AwarenessEvent;
import de.hdm.cefx.client.CEFXClient;
import de.hdm.cefx.concurrency.operations.Operation;

public class ClientConnection_SStub extends Stub {

	private final Logger LOG = Logger.getLogger(ClientConnection_SStub.class.getName());
	private NetworkController controller;

	public ClientConnection_SStub(JabberClient client,CEFXClient cefxclient) {
		super(client, "ClientConnection");
		client.registerMethod("ClientConnection", "executeOperation", this,cefxclient.getThreadID());
		client.registerMethod("ClientConnection", "notifyOfNewClientInSession", this,cefxclient.getThreadID());
		client.registerMethod("ClientConnection", "awarenessEvent", this,cefxclient.getThreadID());
	}

	public void setNetworkController(NetworkController impl) {
		controller = impl;
		System.out.println("ClientConnectionImpl.setNetworkController() " + controller);
	}

	public void executeOperation(Object o) {
		Operation operation=(Operation)o;
		System.out.println("ClientConnectionImpl.executeOperation() " + operation);
		controller.executeAndPropagateRemoteOperation(operation);
	}

	public void notifyOfNewClientInSession(Object o)  {
		CEFXClient client=(CEFXClient)o;
		controller.notifyOfNewClientInSession(client);
	}

	public void awarenessEvent(Object o) {
		AwarenessEvent event=(AwarenessEvent)o;
		LOG.info("Received Awareness Event: " + event);
		controller.awarenessEvent(event);
	}

}
