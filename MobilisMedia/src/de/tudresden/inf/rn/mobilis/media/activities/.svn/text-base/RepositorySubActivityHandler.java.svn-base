package de.tudresden.inf.rn.mobilis.media.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel;
import de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel;

public class RepositorySubActivityHandler extends Handler {
	
	private int arg2;
	private Messenger toParentMessenger;
	private Messenger fromParentMessenger;
	private SubActivityListener subActivityListener;

	public RepositorySubActivityHandler(Intent startingIntent) {
		this.fromParentMessenger = new Messenger( this ); 
		this.toParentMessenger   = (Messenger) startingIntent.getParcelableExtra(
				ConstMMedia.intent.extra.PAR_PARENTMESSENGER );
		this.arg2 = startingIntent.getIntExtra( ConstMMedia.intent.extra.INT_CHILDARG2, 0 );
	}
	
	public void setSubActivityListener(RepositorySubActivityHandler.SubActivityListener l) {
		this.subActivityListener = l;
	}
		
	protected void trySendToParent(Message m) {
		try {
			this.toParentMessenger.send(m);
		} catch (RemoteException e) { }
	}
	
	public void subActivityRegister() {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_SUBACTIVITY_REGISTER;
		m.arg1 = ConstMMedia.message.ARG1_INFO;
		m.arg2 = this.arg2;
		m.getData().putParcelable(ConstMMedia.message.data.PAR_CHILDMESSENGER, this.fromParentMessenger);
		this.trySendToParent(m);
	}
	
	public void subActivityUnregister() {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_SUBACTIVITY_UNREGISTER;
		m.arg1 = ConstMMedia.message.ARG1_INFO;
		m.arg2 = this.arg2;
		this.trySendToParent(m);
	}
	
	public void subActivityUpdate(ConditionParcel condition) {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_SUBACTIVITY_UPDATE;
		m.arg1 = ConstMMedia.message.ARG1_INFO;
		m.arg2 = this.arg2;
		m.getData().putParcelable(ConstMMedia.message.data.PAR_CONDITION, condition);
		this.trySendToParent(m);
	}
	
	public void subActivityDisplay(RepositoryItemParcel repositoryItem) {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_SUBACTIVITY_DISPLAY;
		m.arg1 = ConstMMedia.message.ARG1_INFO;
		m.arg2 = this.arg2;
		m.getData().putParcelable(ConstMMedia.message.data.PAR_REPOSITORYITEM, repositoryItem);
		this.trySendToParent(m);
	}
	
	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		if (this.subActivityListener == null) return;
		switch (msg.what) {
		case ConstMMedia.message.WHAT_SUBACTIVITY_HIDE:
			this.subActivityListener.onSubActivityHide();
			break;
		case ConstMMedia.message.WHAT_SUBACTIVITY_SHOW:
			this.subActivityListener.onSubActivityShow();
			break;
		case ConstMMedia.message.WHAT_SUBACTIVITY_OUTDATE:
			this.subActivityListener.onSubActivityOutdate();
			break;
		case ConstMMedia.message.WHAT_SUBACTIVITY_UPDATE:
			if (msg.arg1 == ConstMMedia.message.ARG1_SUCCESS)
				this.subActivityListener.onSubActivityUpdate(
						(RepositoryItemParcel[])
							msg.getData().getParcelableArray(ConstMMedia.message.data.PARA_REPOSITORYITEM)
					);
			else
				this.subActivityListener.onSubActivityUpdateError();
		}
	}
	
	public static interface SubActivityListener {
		public void onSubActivityHide();
		public void onSubActivityShow();
		public void onSubActivityOutdate();
		public void onSubActivityUpdate(RepositoryItemParcel[] items);
		public void onSubActivityUpdateError();
	}
}
