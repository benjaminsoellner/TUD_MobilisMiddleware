/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server;


import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import de.hdm.cefx.util.XMLHelper;

public class ServerConnection_uploadDocument implements Serializable {
	private String   document;
	public  String   name;

	public Document getDocument() {
		System.out.println(document);
		Document doc=null;
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			ByteArrayInputStream is=new ByteArrayInputStream(document.getBytes());
			doc = builder.parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public void setDocument(Document doc) {
//		try {
//			Transformer trans;
//			trans = TransformerFactory.newInstance().newTransformer();
//			ByteArrayOutputStream ba=new ByteArrayOutputStream();
//			StreamResult sr=new StreamResult(ba);
//			trans.transform(new DOMSource(doc), sr);
//			try {
//				ba.flush();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			document=ba.toString();
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
		document = XMLHelper.getDocumentString(doc, false);
		//System.out.println("Document to upload: " + System.getProperty("line.separator") + document);
	}

}
