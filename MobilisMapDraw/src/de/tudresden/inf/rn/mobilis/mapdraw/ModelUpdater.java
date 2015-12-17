package de.tudresden.inf.rn.mobilis.mapdraw;

import org.w3c.dom.Document;

import de.tudresden.inf.rn.mobilis.android.services.CollabEditingService;
import de.tudresden.inf.rn.mobilis.android.services.SessionService;

public class ModelUpdater {
	
	protected CollabEditingService collabEditingService;
	protected Document doc;
	
	public ModelUpdater() {
		collabEditingService = SessionService.getInstance().getCollabEditingService();
	}
	
	public boolean prepareEditing() {
		if (collabEditingService.isReadyForEditing()) {
			doc = collabEditingService.getDocument();
			return true;
		} else return false;
	}

}
