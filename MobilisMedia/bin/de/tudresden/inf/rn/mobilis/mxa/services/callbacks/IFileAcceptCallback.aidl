package de.tudresden.inf.rn.mobilis.mxa.services.callbacks;

import android.os.Messenger;

oneway interface IFileAcceptCallback {

    void acceptFile(in Messenger acknowledgement, in int requestCode, in String streamID, in String path, in int blockSize);
    
    void denyFileTransferRequest(in Messenger acknowledgement, in int requestCode, in String streamID);
}