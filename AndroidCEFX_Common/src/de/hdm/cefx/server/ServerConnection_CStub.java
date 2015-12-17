/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server;

import jabberSrpc.JabberClient;
import jabberSrpc.Stub;

import java.util.Vector;

import org.w3c.dom.Document;

import de.hdm.cefx.client.CEFXClient;

public class ServerConnection_CStub extends Stub {

	public ServerConnection_CStub(JabberClient client) {
		super(client, "ServerConnection");
	}

	public DocumentData loadDocument(int docID) {
		DocumentData result=null;
		ServerConnection_loadDocument c=new ServerConnection_loadDocument();
		c.docID=docID;

		Object o=sendRPC("loadDocument",c, true);
		if (o!=null) {
		  result=(DocumentData)o;
		}

		return result;
	}

	public boolean uploadDocument(Document doc, String name) {
		boolean result=false;
		ServerConnection_uploadDocument c=new ServerConnection_uploadDocument();
		c.setDocument(doc);
		c.name=name;

		Object o=sendRPC("uploadDocument",c, true);
		if (o!=null) {
		  result=((Boolean)o).booleanValue();
		}

		return result;
	}

	public Vector<ServerObject> listFiles() {
		Vector<ServerObject> result=null;

		Object o=sendRPC("listFiles",null, true);
		if (o!=null) {
		  result=(Vector<ServerObject>)o;
		}

		return result;
	}

	public SessionData openDocument(int docID,CEFXClient client) {
		// TODO obsolete, see joinSession()
		SessionData result=null;

		ServerConnection_openDocument c=new ServerConnection_openDocument();
		c.docID=docID;
		c.client=client;

		Object o=sendRPC("openDocument",c, true);
		if (o!=null) {
		  result=(SessionData)o;
		}
		return result;
	}
	
	public SessionData joinSession(String sessionName, CEFXClient client) {
		SessionData result = null;

		ServerConnection_joinSession c = new ServerConnection_joinSession();
		c.sessionName = sessionName;
		c.client = client;

		Object o = sendRPC("joinSession", c, true);
		if (o != null) {
			result = (SessionData) o;
		}
		return result;
	}

}
