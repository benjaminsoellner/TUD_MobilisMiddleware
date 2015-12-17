package de.tudresden.inf.rn.mobilis.media.core.repository;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.mxa.IXMPPService;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.xmpp.android.Parceller;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryDeleteBean;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryItemInfo;

public class DeleteTask extends Task {

	protected String packetId;
	protected String[] uids;
	protected String repository;
	
	public DeleteTask(String repository, String[] uids) {
		this.repository = repository;
		this.uids = uids;
	}

	@Override
	public void onRun() {
		final Messenger xmppMessenger  = this.service.getXmppMessenger();
		final IXMPPService xmppService = this.service.getXmppService(); 
		RepositoryDeleteBean deleteBean = new RepositoryDeleteBean();
		deleteBean.setTo(this.repository);
		deleteBean.setType(XMPPBean.TYPE_SET);
		for (int i = 0; i < uids.length; i++) {
			RepositoryItemInfo info = new RepositoryItemInfo();
			info.setUid(uids[i]);
			deleteBean.getItems().add(info);
		}
		Parceller.getInstance().registerXMPPBean(deleteBean);
		this.packetId = deleteBean.getId();
		try {
			xmppService.registerIQCallback(this,
					deleteBean.getChildElement(),
					deleteBean.getNamespace()
				);
			xmppService.sendIQ(
					xmppMessenger, null,
					this.id,
					Parceller.getInstance().convertXMPPBeanToIQ(deleteBean, true)
				);
		} catch (RemoteException e) { }
	}

	@Override
	public void processIQ(XMPPIQ iq) throws RemoteException {
		final IXMPPService xmppService = this.service.getXmppService(); 
		XMPPBean b = Parceller.getInstance().convertXMPPIQToBean(iq);
		if (b instanceof RepositoryDeleteBean
				&& b.getId().equals(this.packetId)) {
			xmppService.unregisterIQCallback( this,
					b.getChildElement(), b.getNamespace() );
			if (b.getType() == XMPPBean.TYPE_RESULT)
				this.onResult();
			else
				this.onError();
		}
	}
	
	@Override
	public void handleMessage(Message msg) { }
	
	public void onResult() {
		super.onResult();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_DELETE;
		m.arg1 = ConstMMedia.message.ARG1_SUCCESS;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}
	
	public void onError()  {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_DELETE;
		m.arg1 = ConstMMedia.message.ARG1_ERROR;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}

}
