package de.tudresden.inf.rn.mobilis.saaas;

import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPPresence;
import de.tudresden.inf.rn.mobilis.saaas.IXMPPMessageCallback;

interface IXMPPService {

    /**
     * Connect to the XMPP server.
     */
	void connect(in Messenger acknowledgement, in Bundle connectionParams);
	
	/**
	 * Only disconnects if all binders have been removed.
	 */
	void disconnect(in Messenger acknowledgement);
	
	/**
	 * param requestCode: Reply request code. < 0 if reply is not requested.
	 */
	void sendMessage(in Messenger acknowledgement, in int requestCode, in XMPPMessage message);

    /**
     *
     */
    void sendIQ(in Messenger acknowledgement, in Messenger result, in int requestCode, in XMPPIQ iq);
    
    /**
     *
     */
    void sendPresence(in Messenger acknowledgement, in int requestCode, in XMPPPresence presence);
    
    /**
     * Registers a callback interface with the service that will be notified
     * upon new messages.
     */
    void registerMessageCallback(de.tudresden.inf.rn.mobilis.saaas.IXMPPMessageCallback cb);
    
    /**
     * Removes a previously registered callback interface.
     */
    void unregisterMessageCallback(de.tudresden.inf.rn.mobilis.saaas.IXMPPMessageCallback cb);
}