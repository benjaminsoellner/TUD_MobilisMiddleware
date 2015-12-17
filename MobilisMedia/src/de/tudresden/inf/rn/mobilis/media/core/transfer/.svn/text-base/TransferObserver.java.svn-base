package de.tudresden.inf.rn.mobilis.media.core.transfer;


public interface TransferObserver {

	public void negotiation(Transfer sender);
	public void blockTransferred(Transfer sender, long block);
	public void finished(Transfer sender);
	public void failed(Transfer sender, int reason, String message);
	public void initiated(Transfer sender);
	
}
