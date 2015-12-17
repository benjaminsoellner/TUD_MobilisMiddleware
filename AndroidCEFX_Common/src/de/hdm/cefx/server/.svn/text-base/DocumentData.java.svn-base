/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server;


import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import de.hdm.cefx.concurrency.operations.Operation;
import de.hdm.cefx.concurrency.operations.StateVector;
import de.hdm.cefx.util.XMLHelper;

public class DocumentData implements Serializable {

	//Document                 document;
	String                   document;
	Stack<Operation>         historyBuffer;
	HashMap<Operation, Node> deletedNodesMap;
	StateVector              stateVector;

	public Document getDocument() {

		Document doc=null;
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			ByteArrayInputStream is=new ByteArrayInputStream(document.getBytes());
			doc = builder.parse(is);

			/*Document tmpdoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new DOMResult(tmpdoc));
			doc=tmpdoc;*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public void setDocument(Document doc) {
		/*
		try {
			Transformer trans;
			trans = TransformerFactory.newInstance().newTransformer();
			ByteArrayOutputStream ba=new ByteArrayOutputStream();
			StreamResult sr=new StreamResult(ba);
			trans.transform(new DOMSource(doc), sr);
			try {
				ba.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			document=ba.toString();
		} catch (TransformerException e) {
			e.printStackTrace();
		}*/
		document = XMLHelper.getDocumentString(doc, false);
	}

	public Stack<Operation> getHistoryBuffer() {
		return historyBuffer;
	}

	public void setHistoryBuffer(Stack<Operation> historyBuffer) {
		this.historyBuffer = historyBuffer;
	}

	public HashMap<Operation, Node> getDeletedNodesMap() {
		return deletedNodesMap;
	}

	public void setDeletedNodesMap(HashMap<Operation, Node> deletedNodesMap) {
		this.deletedNodesMap = deletedNodesMap;
	}

	public StateVector getStateVector() {
		return stateVector;
	}

	public void setStateVector(StateVector stateVector) {
		this.stateVector = stateVector;
	}
}
