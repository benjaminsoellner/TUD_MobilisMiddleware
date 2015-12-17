/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * Copyright 2007 Ansgar Gerlicher.
 * @author Ansgar Gerlicher
 */
package de.hdm.cefx.client;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * Generated helper class to retrieve information from a properties file.
 *
 * @author Ansgar Gerlicher
 */
public class ClientGeneralSettings {
	// private static final String BUNDLE_NAME =
	// "de.hdm.cefx.dom.adapter.client"; //$NON-NLS-1$
	private static final String BUNDLE_NAME = "client"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ClientGeneralSettings() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
