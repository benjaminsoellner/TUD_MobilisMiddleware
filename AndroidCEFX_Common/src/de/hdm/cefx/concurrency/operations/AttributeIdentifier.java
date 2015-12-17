/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.concurrency.operations;

import java.io.Serializable;

/**
 * Class to identify attributes.
 * @author Ansgar Gerlicher
 *
 */
@SuppressWarnings("serial")
public class AttributeIdentifier implements Serializable {

	private String localName;

	private String namespaceURI;

	/**
	 * Class constructor.
	 *
	 * @param localname
	 *            the name of the attribute.
	 * @param nsUri
	 *            the namespace URI of the attribute.
	 */
	public AttributeIdentifier(String localname, String nsUri) {
		localName = localname;
		namespaceURI = nsUri;
	}

	/**
	 * Property retrieval method.
	 *
	 * @return the local name of the attribute
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * Property set method.
	 *
	 * @param localName
	 *            the local name of the attribute.
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * Property retrieval method.
	 *
	 * @return the namespace URI name of the attribute
	 */
	public String getNamespaceURI() {
		return namespaceURI;
	}

	/**
	 * Property set method.
	 *
	 * @param namespaceURI
	 *            the namespace URI of the attribute.
	 */
	public void setNamespaceURI(String namespaceURI) {
		this.namespaceURI = namespaceURI;
	}
}
