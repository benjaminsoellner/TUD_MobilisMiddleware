package de.tudresden.inf.rn.mobilis.mxa.services.filetransfer;

import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback;

interface IFileTransferService {

    /**
     * Sends a file to an XMPP entity.
     */
    void sendFile(in Messenger acknowledgement, in int requestCode, in FileTransfer file);
    
    /**
     * Registers a callback for incoming file transfers.
     */
    void registerFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb);
    
    /**
     * Unregisters a previously registered callback for incoming file transfers.
     */
    void unregisterFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb);
    
    /**
     * Accepts a previously received file transfer.
     */
	//void acceptFileTransferRequest(in Messenger acknowledgement, in int requestCode, in String path, in int blockSize, in int requestKey);
	
	/**
	 * Denies a previously received file transfer.
	 */
	//void denyFileTransferRequest(in int requestCode); 
}