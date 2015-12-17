package de.tudresden.inf.rn.mobilis.saaas;

import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPIQ;

oneway interface IXMPPIQCallback {

    /**
     * Called when the service has a new message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
    void processIQ(in XMPPIQ iq);
}