package de.tudresden.inf.rn.mobilis.media.core.repository;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.services.RepositoryService;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;

public abstract class Task extends IXMPPIQCallback.Stub {

	protected int id;
	protected int requestCode;
	protected Messenger resultMessenger = null;
	protected RepositoryService service = null; 
	
	public void initialize(RepositoryService service, int id,
			Messenger resultMessenger, int requestCode) {
		this.service = service;
		this.id = id;
		this.resultMessenger = resultMessenger;
		this.requestCode = requestCode;
	}
	
	public abstract void onRun();
	
	public void onResult() {
		this.service.removeTask(this.id);
	}
	
	public void onError() {
		this.service.removeTask(this.id);
	}
	
	public abstract void handleMessage(Message msg);
	public abstract void processIQ(XMPPIQ iq) throws RemoteException;
}
