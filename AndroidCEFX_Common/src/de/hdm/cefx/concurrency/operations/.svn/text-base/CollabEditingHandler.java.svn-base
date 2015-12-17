package de.hdm.cefx.concurrency.operations;

import jabberSrpc.MucRoomListener;
import de.hdm.cefx.client.net.CEFXSession;
import de.hdm.cefx.client.net.RemoteOperationExecutor;

public abstract class CollabEditingHandler implements OperationHandler, MucRoomListener {
	
	protected RemoteOperationExecutor executor;
	protected CEFXSession session;
	protected int clientID;
	
	public CollabEditingHandler(RemoteOperationExecutor executor, CEFXSession currentSession, int clientID) {
		this.executor = executor;
		this.session = currentSession;
		this.clientID = clientID;
	}
	
	public void setCurrentSession(CEFXSession currentSession) {
		session = currentSession;
	}

}
