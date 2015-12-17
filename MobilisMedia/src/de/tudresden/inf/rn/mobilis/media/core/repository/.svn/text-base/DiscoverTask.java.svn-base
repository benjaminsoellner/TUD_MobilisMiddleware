package de.tudresden.inf.rn.mobilis.media.core.repository;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import de.tudresden.inf.rn.mobilis.media.ConstMMedia;
import de.tudresden.inf.rn.mobilis.media.core.ApplicationManager;
import de.tudresden.inf.rn.mobilis.mxa.ConstMXA;
import de.tudresden.inf.rn.mobilis.mxa.IXMPPService;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.DiscoverItem;
import de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService;

public class DiscoverTask extends Task {

	protected String serverJid;
	protected int expectedBrokers = 0;
	protected ArrayList<String> repositoryBrokers = new ArrayList<String>();
	protected IServiceDiscoveryService serviceDiscoveryService;
	
	public DiscoverTask(String serverJid) {
		this.serverJid = serverJid;
	}

	@Override
	public void onRun() {
		final Messenger xmppMessenger  = this.service.getXmppMessenger();
		final IXMPPService xmppService = this.service.getXmppService(); 
		try {
			xmppService.getServiceDiscoveryService().discoverItem(
					xmppMessenger, xmppMessenger, this.id, this.serverJid, null);
		} catch (RemoteException e) {
			this.onError();
		}
	}
	
	public void onRun(String broker) {
		final Messenger xmppMessenger  = this.service.getXmppMessenger();
		final IXMPPService xmppService = this.service.getXmppService(); 
		try {
			xmppService.getServiceDiscoveryService().discoverItem(
					xmppMessenger, xmppMessenger, this.id, broker, ConstMMedia.namespace.SERVICES);
		} catch (RemoteException e) {
			this.onError();
		}
	}

	@Override
	public void handleMessage(Message msg) {
		if (msg.what == ConstMXA.MSG_DISCOVER_ITEMS)
			if (msg.arg1 == ConstMXA.MSG_STATUS_SUCCESS) {
				Bundle d = msg.getData();
				d.setClassLoader(ApplicationManager.getInstance().getClassLoader());
				String                  jid   = d.getString("JID"); 
				ArrayList<DiscoverItem> items = d.getParcelableArrayList("DISCOVER_ITEMS");
				if (jid.equals(serverJid)) {
					this.expectedBrokers = items.size();
					this.repositoryBrokers = new ArrayList<String>(items.size());
					for (DiscoverItem item: items)
						this.onRun(item.jid);
					if (this.expectedBrokers == 0) this.onResult();
				} else {
					final String repositoryService = ConstMMedia.namespace.REPOSITORY_SERVICE;
					for (DiscoverItem item: items)
						if (item.node.equals(repositoryService)) {
							this.repositoryBrokers.add(jid);
							break;
						}
					this.expectedBrokers--;
					if (this.expectedBrokers <= 0)
						this.onResult();
				}
			} else if (msg.arg1 != ConstMXA.MSG_STATUS_DELIVERED)
				this.onError();
	}


	@Override
	public void processIQ(XMPPIQ iq) throws RemoteException {}
	
	@Override
	public void onResult() {
		super.onResult();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_DISCOVER;
		m.arg1 = ConstMMedia.message.ARG1_SUCCESS;
		m.arg2 = this.requestCode;
		m.getData().putStringArrayList(
				ConstMMedia.message.data.STRL_REPOSITORIES,
				this.repositoryBrokers
			);
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}
	
	@Override
	public void onError() {
		super.onError();
		Message m = Message.obtain();
		m.what = ConstMMedia.message.WHAT_REPOSITORY_DISCOVER;
		m.arg1 = ConstMMedia.message.ARG1_ERROR;
		m.arg2 = this.requestCode;
		try { this.resultMessenger.send(m); } catch (RemoteException e) {}
	}

}
