package de.tudresden.inf.rn.mobilis.media.views;

import de.tudresden.inf.rn.mobilis.commons.views.Command;


public abstract class RepositoryItemCommand implements Command {

	protected String repository;
	protected String uid;

	public RepositoryItemCommand(String repository, String uid) {
		this.repository = repository;
		this.uid = uid;
	}

	public boolean isUndoable() {
		return false;
	}

	public void undoCommand() { }

}
