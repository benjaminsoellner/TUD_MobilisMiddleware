package de.tudresden.inf.rn.mobilis.mxa.services.callbacks;

import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback;

oneway interface IFileCallback {

    /**
     * Called when the service has a new message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
    void processFile(IFileAcceptCallback acceptCallback, in FileTransfer file, String streamID);
}