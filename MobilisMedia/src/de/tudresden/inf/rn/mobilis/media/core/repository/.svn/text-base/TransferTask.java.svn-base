package de.tudresden.inf.rn.mobilis.media.core.repository;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.mxa.IXMPPService;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.xmpp.android.Parceller;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.ContentTransferBean;

public class TransferTask extends Task {

	private String repository;
	private String uid;
	private String content;
	private String packetId;

	public TransferTask(String content, String repository, String uid) {
		this.repository = repository;
		this.content = content;
		this.uid = uid;
	}

	@Override
	public void onRun() {
		final Messenger xmppMessenger  = this.service.getXmppMessenger();
		final IXMPPService xmppService = this.service.getXmppService();
		String me;
		try {
			me = xmppService.getUsername();
			ContentTransferBean transferBean = new ContentTransferBean();
			transferBean.setType(XMPPBean.TYPE_GET);
			transferBean.setTo(this.repository);
			transferBean.setRetrieveFrom(this.content);
			transferBean.setSendTo(me);
			transferBean.setUid(uid);
			this.packetId = transferBean.getId();
			Parceller.getInstance().registerXMPPBean(transferBean);
			xmppService.registerIQCallback(this,
					transferBean.getChildElement(), transferBean.getNamespace());
			xmppService.sendIQ(xmppMessenger, xmppMessenger, this.id,
					Parceller.getInstance().convertXMPPBeanToIQ(transferBean, true));
		} catch (RemoteException e) {
			this.onError();
		}
	}
	
	@Override
	public void handleMessage(Message msg) {}

	@Override
	public void processIQ(XMPPIQ iq) throws RemoteException {
		XMPPBean b = Parceller.getInstance().convertXMPPIQToBean(iq);
		if (b.getId().equals(this.packetId)) {
			if (b.getType() == XMPPBean.TYPE_RESULT)
				this.onResult();
			else if (b.getType() == XMPPBean.TYPE_ERROR)
				this.onError();
		}
	}
	
	public void onResult() {
		super.onResult();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_TRANSFER;
		m.arg1 = ConstMMedia.message.ARG1_SUCCESS;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}
	
	public void onError()  {
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_TRANSFER;
		m.arg1 = ConstMMedia.message.ARG1_ERROR;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}

}
