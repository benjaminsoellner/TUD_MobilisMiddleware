/*
 * mg_server.java
 */

package de.tudresden.inf.rn.mobilis.server;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.jivesoftware.smack.XMPPConnection;

/**
 * The main class of the application.
 */
public class MG_Server extends SingleFrameApplication {
	
	protected MG_ServerView parentView;

    /**
     * At startup create and show the main frame of the application.
     * Also startup Mobilis Manager and associate with main frame.
     */
    @Override protected void startup() {
    	parentView = new MG_ServerView(this);
    	XMPPConnection.DEBUG_ENABLED = true;
    	MobilisManager.getInstance().registerServerView(parentView);
    	show(parentView);
    }

    /**
     * Shutdown Mobilis Manager and unregister with main frame.
     */
    @Override protected void shutdown() {
    	MobilisManager.getInstance().shutdown();
    	MobilisManager.getInstance().unregisterServerView(parentView);
    	super.shutdown();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of mg_server
     */
    public static MG_Server getApplication() {
        return Application.getInstance(MG_Server.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(MG_Server.class, args);
    }
}
