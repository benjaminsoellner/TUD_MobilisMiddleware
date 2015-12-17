package de.tudresden.inf.rn.mobilis.mxa.callbacks;

oneway interface IConnectionCallback {

    /**
     * Called when the connection changed.
     */
    void onConnectionChanged(boolean connected);
}