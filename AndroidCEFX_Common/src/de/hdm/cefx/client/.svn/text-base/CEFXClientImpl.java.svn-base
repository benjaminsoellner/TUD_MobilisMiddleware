/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 * @author Michael Voigt
 */
package de.hdm.cefx.client;

import jabberSrpc.JabberClient;

/**
 *
 * The implementing class of the CEFXClient interface.
 *
 * @author Ansgar Gerlicher
 */
@SuppressWarnings("serial")
public class CEFXClientImpl implements CEFXClient {

	// The Object name as it is registered with the RMIRegistry
	private String connectionName = null;

	// The ID of the client
	private int clientID = -1;

	// The complete connectionString - saves the JID
	private String connectionString = null;

	// The name of the client
	private String name = null;

	// The connection port
	private String port = null;

	// The hostname where the client run on
	private String host = null;

	private String threadID;

	private int    counter;

	/**
	 * Constructor. Loads the required information from the corresponding
	 * network.properties file.
	 */
	public CEFXClientImpl() {
		counter=0;
		clientID=-1;
		threadID=""+JabberClient.getInstance().getUniqueThreadID();
	}

	public void init() {
		connectionName = JabberClient.getInstance().getJID();
		connectionString=connectionName;
		name=connectionName;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "CEFX ID: " + clientID + " JID: " + connectionName;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getConnectionString()
	 */
	public String getConnectionString() {
		return connectionString;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getConnectionName()
	 */
	public String getConnectionName() {

		return connectionName;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getName()
	 */
	public String getName() {

		return name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getPort()
	 */
	public String getPort() {

		return port;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getHostName()
	 */
	public String getHostName() {

		return host;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hdm.cefx.client.CEFXClient#getID()
	 */
	public int getID() {

		return this.clientID;
	}

	public void setID(int id) {
		this.clientID=id;
//		name=name+' - ID:'+id;
	}

	public String getThreadID() {
		return threadID;
	}

	public int getCounter() {
		counter=counter+1;
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
}
