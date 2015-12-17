/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 * @author Michael Voigt
 * @author Dirk Hering
 */
package de.hdm.cefx.client.net;

import jabberSrpc.JabberClient;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import de.hdm.cefx.client.CEFXClient;

/**
 * Implementation class of the CEFXSession interface.
 *
 * @see de.hdm.cefx.client.net.CEFXSession
 * @author Ansgar Gerlicher
 * @author Michael Voigt
 * @author Dirk Hering
 *
 */
@SuppressWarnings("serial")
public class CEFXSessionImpl implements CEFXSession, Cloneable {

	String                              sessionDocumentURI;
	private HashMap<String, CEFXClient> clients;
	private HashMap<Integer,CEFXClient> idMap;
	private String                      mucRoomName;

	/**
	 * Class constructor.
	 *
	 * @param documentUri
	 *            the document URI of the document that is edited in the current
	 *            session.
	 */
	public CEFXSessionImpl(String documentUri) {
		sessionDocumentURI = documentUri;
		clients = new HashMap<String, CEFXClient>();
		idMap=new HashMap<Integer,CEFXClient>();
	}

	public void updateIdMap() {
		idMap.clear();
		Set<String> set=clients.keySet();

		Iterator<String> it = set.iterator();
		while ( it.hasNext() == true ) {
			String key=it.next();
			idMap.put(clients.get(key).getID(), clients.get(key));
		}
	}

	public CEFXClient getClient(int id) {
		Integer key=new Integer(id);
		if (idMap.containsKey(key)) {
			return idMap.get(key);
		} else  {
			return null;
		}
	}

	public void addClient(CEFXClient client) {
		
		// ONLY CALLED FROM SERVER SIDE!
		// does the client already exist in the session, then do not add it and return
		if (clients.get(client.getName()) != null)
			return;
		clients.put(client.getName(), client);
		
		Collection<CEFXClient> c = clients.values();
		for (CEFXClient cli : c) {
			System.out.println("CEFXSessionImpl.addClient() " + cli);
			if (!cli.getName().equals(client.getName())) {
				
				// notify each client in this session of the new joiner
				ClientConnection_CStub conn=null;
				conn=connectToClient(cli);
				if (conn!=null) {
					conn.notifyOfNewClientInSession(client);
				}

				// notify the new client of each already connected client
				conn=connectToClient(client);
				if (conn!=null) {
					conn.notifyOfNewClientInSession(cli);
				}

			}

		}
		updateIdMap();
	}

	/**
	 * Creates an RPC stub to initiate message calls to a client.
	 * @param client the client to connect to
	 * @return ClientConnection_CStub
	 */
	private ClientConnection_CStub connectToClient(CEFXClient client) {
		ClientConnection_CStub connection = null;
		connection = new ClientConnection_CStub(JabberClient.getInstance());
		connection.setTarget(client.getConnectionString());
		connection.setThreadID(client.getThreadID());
		return connection;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.net.CEFXSession#getDocumentID()
	 */
	public String getDocumentID() {
		return sessionDocumentURI;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.net.CEFXSession#getClientMap()
	 */
	public HashMap<String, CEFXClient> getClientMap() {
		return clients;
	}

	public String getMucRoomName() {
		return mucRoomName;
	}

	public void setMucRoomName(String mucRoomName) {
		this.mucRoomName = mucRoomName;
	}

	public CEFXSessionImpl clone() {
		try {
			return (CEFXSessionImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
