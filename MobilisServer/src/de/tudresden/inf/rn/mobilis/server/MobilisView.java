package de.tudresden.inf.rn.mobilis.server;

import java.util.logging.Level;

public interface MobilisView {

	public void showLogMessage(Level level, String message);
	
	public void setStarted(Boolean started);
	
}
