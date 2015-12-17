/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server;

import java.io.Serializable;

import de.hdm.cefx.client.CEFXClient;

public class ServerConnection_openDocument implements Serializable {
	public Integer    docID;
	public CEFXClient client;
}
