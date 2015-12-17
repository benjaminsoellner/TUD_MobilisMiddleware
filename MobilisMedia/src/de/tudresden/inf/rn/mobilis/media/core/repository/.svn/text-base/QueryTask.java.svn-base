package de.tudresden.inf.rn.mobilis.media.core.repository;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel;
import de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel;
import de.tudresden.inf.rn.mobilis.mxa.IXMPPService;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.xmpp.android.Parceller;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryItemInfo;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryQueryBean;

public class QueryTask extends Task {
	
	protected String packetId;
	protected String repository;
	protected ConditionParcel condition;
	
	public QueryTask(String repository, ConditionParcel condition) {
		this.repository = repository;
		this.condition = condition;
	}

	@Override
	public void onRun() {
		final Messenger xmppMessenger  = this.service.getXmppMessenger();
		final IXMPPService xmppService = this.service.getXmppService(); 
		RepositoryQueryBean queryBean = new RepositoryQueryBean();
		queryBean.setTo(this.repository);
		queryBean.setCondition(Parceller.getInstance().convertConditionParcelToInfo(this.condition));
		queryBean.setType(XMPPBean.TYPE_GET);
		Parceller.getInstance().registerXMPPBean(queryBean);
		this.packetId = queryBean.getId();
		try {
			xmppService.registerIQCallback(this,
					queryBean.getChildElement(),
					queryBean.getNamespace()
				);
			xmppService.sendIQ(
					xmppMessenger, null,
					this.id,
					Parceller.getInstance().convertXMPPBeanToIQ(queryBean, true)
				);
		} catch (RemoteException e) { }
	}
	
	@Override
	public void handleMessage(Message msg) { }
	
	@Override
	public void processIQ(XMPPIQ iq) throws RemoteException {
		final IXMPPService xmppService = this.service.getXmppService(); 
		XMPPBean b = Parceller.getInstance().convertXMPPIQToBean(iq);
		if (b instanceof RepositoryQueryBean
				&& b.getId().equals(this.packetId)) {
			xmppService.unregisterIQCallback( this,
					b.getChildElement(), b.getNamespace() );
			if (b.getType() == XMPPBean.TYPE_RESULT) {
				RepositoryQueryBean bb = (RepositoryQueryBean) b;
				RepositoryItemParcel[] parcels = new RepositoryItemParcel[bb.getItems().size()];
				int i = 0; for (RepositoryItemInfo info: bb.getItems())
					parcels[i++] = Parceller.getInstance().convertRepositoryItemInfoToParcel(info);
				this.onResult(parcels);
			} else {
				this.onError();
			}
		}
	}
	
	public void onResult(RepositoryItemParcel[] parcels) {
		super.onResult();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_QUERY;
		m.arg1 = ConstMMedia.message.ARG1_SUCCESS;
		m.arg2 = this.requestCode;
		m.getData().putParcelableArray(ConstMMedia.message.data.PARA_REPOSITORYITEM, parcels);
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}
	
	public void onError()  {
		super.onError();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_QUERY;
		m.arg1 = ConstMMedia.message.ARG1_ERROR;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}

}
