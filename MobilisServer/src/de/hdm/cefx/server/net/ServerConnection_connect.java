/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server.net;

import java.io.Serializable;

import de.hdm.cefx.client.CEFXClient;

public class ServerConnection_connect implements Serializable {
	public CEFXClient client;
	public String documentUri;
}
