/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.server;

import java.io.Serializable;

public class ServerObject implements Serializable {

	//file types
	public static final int XML_FILE=0;

	//not used yet
/*	public static final int META_XML_FILE=1;
	public static final int BINARY_FILE=2;

	public static final int DIR=100+0;
	public static final int COMPRESSED_DIR=100+1;*/

	protected int type;
	protected int id;
	protected String name;

	public ServerObject(int type, int id,String name) {
		this.type=type;
		this.id=id;
		this.name=name;
	}

	public int getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
