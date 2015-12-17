package de.tudresden.inf.rn.mobilis.saaas;

import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPMessage;

oneway interface IXMPPMessageCallback {

    /**
     * Called when the service has a new message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
    void processMessage(in XMPPMessage message);
}