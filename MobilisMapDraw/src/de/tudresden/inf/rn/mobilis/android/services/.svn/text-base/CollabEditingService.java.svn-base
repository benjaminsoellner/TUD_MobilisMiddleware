package de.tudresden.inf.rn.mobilis.android.services;

import java.io.InputStream;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import android.os.Bundle;
import android.util.Log;
import de.hdm.cefx.CEFXControllerImpl;
import de.hdm.cefx.awareness.AwarenessControllerImpl;
import de.hdm.cefx.client.net.NetworkController;
import de.hdm.cefx.client.net.NetworkControllerImpl;
import de.hdm.cefx.concurrency.AbstractConcurrencyControllerImpl;
import de.hdm.cefx.concurrency.OrderingConcurrencyControllerImpl;
import de.hdm.cefx.dom.adapter.CEFXDOMAdapterImpl;
import de.hdm.cefx.exceptions.NodeNotFoundException;
import de.hdm.cefx.server.ServerObject;
import de.hdm.cefx.util.CEFXUtil;
import de.hdm.cefx.util.XMLHelper;
import de.tudresden.inf.rn.mobilis.mapdraw.DocumentFactory;
import de.tudresden.inf.rn.mobilis.mapdraw.XMPPController;

public class CollabEditingService implements MobilisAndroidService {

	private static final String TAG = "CollabEditingService";
	
	private Document document;
	private CEFXDOMAdapterImpl da;
	private CEFXControllerImpl cefx;
	private AwarenessControllerImpl ac;
	private DocumentFactory docFac;
	private OrderingConcurrencyControllerImpl cc;
	private boolean readyForEditing;
	private boolean connected;

	public CollabEditingService() {
		readyForEditing = false;
		da = new CEFXDOMAdapterImpl();
		docFac = new DocumentFactory();
		da.setDocumentFactory(docFac);
		document = null;
		//xmlDoc=da.createDocument(uri);	  	  	
		cefx = (CEFXControllerImpl) da.getCEFXController();
		//cefx.getClient().setID(id);
		ac = new AwarenessControllerImpl();
		cefx.setAwarenessController(ac);
		NetworkControllerImpl nc = new NetworkControllerImpl();
		cefx.setNetworkController(nc);
		cc = new OrderingConcurrencyControllerImpl();
		cefx.setConcurrencyController(cc);
	}

	public boolean connect() {
		if (connectToXMPP()) {
			// TODO use predefined server / lookup for service name?
			// TODO use Mobilis Server name from settings
			String server = "collabediting@wpc/MobilisServer";
			Log.i(TAG, "Establishing connection to CEFX-Server: " + server);			
			cefx.connect(server);
			connected = true;
			return true;
		} else {
			connected = false;
			return false;
		}
	}
	
	private boolean connectToXMPP() {

		// TODO use xmpp service
		
		// read bundled connection params
		Bundle connectionParams = XMPPController.getInstance().readXMPPPreferences();
		if (connectionParams == null) {
			return false;
		}
		
		String host = connectionParams.getString("xmpp_host");
		int port = connectionParams.getInt("xmpp_port", 5222);
		String serviceName = connectionParams.getString("xmpp_service");
		String username = connectionParams.getString("xmpp_user");
		String password = connectionParams.getString("xmpp_password");
		String resource = connectionParams.getString("xmpp_resource");
		
		cefx.setJabberHost(host);
		cefx.setJabberPort(port);
		cefx.setJabberServiceName(serviceName);
		cefx.setJabberUserName(username);
		cefx.setJabberPassword(password);
		cefx.setJabberResource(resource);
		cefx.setJabberResourceSuffix("");
		
		Log.i(TAG, "Connecting to XMPP with: " + username + "@" + host + ":" + port + "/" + resource + " service: " + serviceName);
		
		cefx.init();
		cefx.jabberConnect();
		
		NetworkController nc = cefx.getNetworkController();
		if (nc!=null) {
			cefx.getConcurrencyController().setSession(nc.getSession());
		}
		
		return true;
	}
	
	public void insertAttributeText(String text,int pos) {
//		da.Element_AttributeInsert(...);
	}

	public void deleteAttributeText(int pos,int length) {
//		da.Element_AttributeDelete(...);
	}

	public void insertAttribute(String text) {
//		da.Element_AttributeSet(...);		
	}

	public void insertText(Element parent, Element fixNode, int before, String text, int textPos) {
		da.Element_TextInsert(parent, fixNode, before, text, textPos);		
	}
	
	public void insertText(String parentNodeID, String fixNodeID, int before, String text, int textPos) {
		Element parentNode = getElementForId(parentNodeID);
		Element fixNode = getElementForId(fixNodeID);
		da.Element_TextInsert(parentNode, fixNode, before, text, textPos);		
	}

	public void deleteText(int pos,int len) {
//			da.Element_TextDelete(....);	
	}	

	public void setText(String text) {
//			da.Element_TextSet(...);
	}	
	
	public void insertNode(Node parentNode, Node newNode, Node fixNode, int before) {
		da.Node_insert(parentNode, newNode, fixNode, before);
	}
	
	public void insertNode(String parentNodeID, Node newNode, String fixNodeID, int before) {
		Element parentNode = getElementForId(parentNodeID);
		Element fixNode = getElementForId(fixNodeID);
		// TODO necessary to check if the new node is an attribute / ...?
		da.Node_insert(parentNode, newNode, fixNode, before);
	}

	public void deleteNode(String id) {		
		Element f;
		try {
			((AbstractConcurrencyControllerImpl)cefx.getConcurrencyController()).refreshNodeMap();
			f = (Element)(((AbstractConcurrencyControllerImpl)cefx.getConcurrencyController()).getNodeForId(id));
			da.Node_removeChild(f);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
		}			
	}

	public boolean uploadDocument(String filePath) {
		return cefx.uploadDocument(filePath);
	}
	
	public boolean uploadDocument(String fileName, InputStream inputStream) {
		return cefx.uploadDocument(fileName, inputStream);
	}

	public CEFXDOMAdapterImpl getDOMAdapter() {
		return da;
	}

	public CEFXControllerImpl getCEFXController() {
		return cefx;
	}
	
	public AwarenessControllerImpl getAwarenessController() {
		return ac;
	}
	
	public Document getDocument() {
		return document;
	}

	/**
	 * Returns the DOM Element matching the given CEFX-UID or null if no such Element could be found.
	 * @param id the CEFX-UID for the Element to retrieve
	 * @return Element
	 */
	public Element getElementForId(String id) {
		try {
			return (Element) cc.getNodeForId(id);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Shows the current XML document in the console, just for debugging.
	 */
	public void showDocument() {
		System.out.println("Current document:");
		XMLHelper.showDocumentContent(da.getDocument());
	}
	
	public void showStateVector() {
		Log.i(TAG, "Client "+cefx.getClient().getID()+" - State Vector: " + 
				cefx.getConcurrencyController().getStateVector().toString());
	}

	public String getDocumentString() {
		return XMLHelper.getDocumentString(da.getDocument(), true);
	}
	
	public boolean loadDocumentFromServer(String uri) {
		Vector<ServerObject> files = cefx.listFiles();
		if (files != null) {
			int docID = cefx.getDocumentID(uri, files);
			cefx.openDocument(docID);
			document = da.getDocument();
			return true;
		} else {
			Log.e(TAG, uri + " could not be found on the server");
			return false;
		}
	}
	
	public boolean joinSession(String sessionName) {
		if (cefx.joinSession(sessionName).booleanValue()) {
			document = da.getDocument();
			readyForEditing = true;
			return true;
		} else {
			Log.e(TAG, "Could not join session: " + sessionName);
			return false;
		}
	}
	
	public Element createElement(String name) {
		return document.createElement(name);
	}
	
	public Text createTextNode(String textContent) {
		return document.createTextNode(textContent);
	}

	@Override
	public void initIntentReceiver() {
		// TODO Auto-generated method stub
	}

	@Override
	public void unregisterIntentReceiver() {
		// TODO Auto-generated method stub
	}
	
	public boolean isReadyForEditing() {
		return readyForEditing;
	}
	
	public String getNodeId(Node node) {
		return CEFXUtil.getNodeId(node);
	}

	public boolean isConnected() {
		return connected;
	}
}
