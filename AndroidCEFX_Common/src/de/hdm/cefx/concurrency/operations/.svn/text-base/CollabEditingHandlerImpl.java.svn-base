package de.hdm.cefx.concurrency.operations;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

import de.hdm.cefx.client.net.CEFXSession;
import de.hdm.cefx.client.net.CEFXSessionImpl;
import de.hdm.cefx.client.net.OperationXMLTransformer;
import de.hdm.cefx.client.net.RemoteOperationExecutor;

public class CollabEditingHandlerImpl extends CollabEditingHandler {
	
	public CollabEditingHandlerImpl(RemoteOperationExecutor executor, CEFXSession currentSession, int clientID) {
		super(executor, currentSession, clientID);
	}

	@Override
	public void processMessage(Packet packet) {
		Message msg = (Message) packet;
//		System.out.println("Received Remote Operation Message via Multi-User-Chat, from: " + msg.getFrom());
		Operation o = OperationXMLTransformer.transformMessage2Operation(msg,
				(CEFXSessionImpl) session, clientID);
		if (o != null) {
			handleOperation(o);
		}
	}

	@Override
	public void processPresencePacket(Packet packet) {}

	@Override
	public void handleOperation(Operation operation) {
		// TODO insert check if this operation is remote or local
		executor.executeRemoteOperation(operation);
	}

}
