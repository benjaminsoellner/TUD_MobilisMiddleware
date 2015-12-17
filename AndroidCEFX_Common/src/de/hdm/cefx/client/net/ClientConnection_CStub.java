/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */

package de.hdm.cefx.client.net;

import jabberSrpc.JabberClient;
import jabberSrpc.Stub;
import de.hdm.cefx.awareness.AwarenessEvent;
import de.hdm.cefx.client.CEFXClient;
import de.hdm.cefx.concurrency.operations.Operation;

public class ClientConnection_CStub extends Stub {

	public ClientConnection_CStub(JabberClient client) {
		super(client, "ClientConnection");
	}

	public void executeOperation(Operation operation)  {
		sendRPC("executeOperation",operation, false);
	}

	public void notifyOfNewClientInSession(CEFXClient client) {
		sendRPC("notifyOfNewClientInSession",client, false);
	}

	public void awarenessEvent(AwarenessEvent event) {
		sendRPC("awarenessEvent",event, false);
	}
}
