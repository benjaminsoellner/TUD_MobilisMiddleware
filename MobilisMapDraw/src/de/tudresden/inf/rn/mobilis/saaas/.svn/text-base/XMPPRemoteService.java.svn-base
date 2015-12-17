/**
 * 
 */
package de.tudresden.inf.rn.mobilis.saaas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketIDFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.Presence.Mode;
import org.jivesoftware.smack.provider.PrivacyProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.jivesoftware.smackx.PrivateDataManager;
import org.jivesoftware.smackx.packet.ChatStateExtension;
import org.jivesoftware.smackx.packet.LastActivity;
import org.jivesoftware.smackx.packet.OfflineMessageInfo;
import org.jivesoftware.smackx.packet.OfflineMessageRequest;
import org.jivesoftware.smackx.packet.SharedGroupsInfo;
import org.jivesoftware.smackx.provider.BytestreamsProvider;
import org.jivesoftware.smackx.provider.DataFormProvider;
import org.jivesoftware.smackx.provider.DelayInformationProvider;
import org.jivesoftware.smackx.provider.DiscoverInfoProvider;
import org.jivesoftware.smackx.provider.DiscoverItemsProvider;
import org.jivesoftware.smackx.provider.IBBProviders;
import org.jivesoftware.smackx.provider.MUCAdminProvider;
import org.jivesoftware.smackx.provider.MUCOwnerProvider;
import org.jivesoftware.smackx.provider.MUCUserProvider;
import org.jivesoftware.smackx.provider.MessageEventProvider;
import org.jivesoftware.smackx.provider.MultipleAddressesProvider;
import org.jivesoftware.smackx.provider.RosterExchangeProvider;
import org.jivesoftware.smackx.provider.StreamInitiationProvider;
import org.jivesoftware.smackx.provider.VCardProvider;
import org.jivesoftware.smackx.provider.XHTMLExtensionProvider;
import org.jivesoftware.smackx.search.UserSearch;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.saaas.parcelable.XMPPPresence;
import de.tudresden.inf.rn.mobilis.saaas.xmpp.IQImpl;

/**
 * @author koren
 * 
 */
public class XMPPRemoteService extends Service {

	private static final String TAG = "XMPPRemoteService";
	
	//private SharedPreferences mPreferences;
	private XMPPConnection mConn;
	private WriterThread xmppWriteWorker;
	private ReaderThread xmppReadWorker;
	ExecutorService mExecutorIQ;

	// remote callback list for message listeners
	final RemoteCallbackList<IXMPPMessageCallback> mCallbacks = new RemoteCallbackList<IXMPPMessageCallback>();

	// the enum values sent as action to the worker thread
	public static final int MSG_CONNECT = 0;
	public static final int MSG_DISCONNECT = 1;
	public static final int MSG_SEND_MESSAGE = 2;
	public static final int MSG_SEND_IQ = 3;
	public static final int MSG_SEND_PRESENCE = 4;
	// the enum values for status
	public static final int MSG_STATUS_REQUEST = 0;
	public static final int MSG_STATUS_SUCCESS = 1;
	public static final int MSG_STATUS_DELIVERED = 2;
	public static final int MSG_STATUS_ERROR = 3;
	// the additional enum values for IQ status
	public static final int MSG_STATUS_IQ_RESULT = 4;
	public static final int MSG_STATUS_IQ_ERROR = 5;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// initialize and start worker threads
		xmppWriteWorker = new WriterThread();
		xmppWriteWorker.start();
		xmppReadWorker = new ReaderThread();
		xmppReadWorker.start();

		/*
		// read in preferences
		mPreferences = getSharedPreferences(
				"de.tudresden.inf.rn.mobilis.saaas_preferences",
				Context.MODE_PRIVATE);*/

		// initialize IQ executor
		mExecutorIQ = Executors.newCachedThreadPool();

		return mBinder;
	}

	// TODO what's the issue with MessageQueue? Do we have to use it here?
	private class WriterThread extends Thread {
		public Handler mHandler;

		public void run() {
			Looper.prepare();

			mHandler = new Handler() {
				public void handleMessage(Message msg) {
					// initialize response Message, as Messages cannot be reused
					// get a Message from the Message pool and copy values of
					// msg
					Message msg2 = Message.obtain(msg);
					switch (msg.what) {
					case MSG_CONNECT:
						// initialize XMPP Connection
						// check if already connected
						if (mConn != null && mConn.isConnected()) {
							msg2.arg1 = MSG_STATUS_SUCCESS;
							xmppResults.sendMessage(msg2);
							break;
						}
						
						// read bundled connection params
						Bundle connectionParams = msg.getData();
						String host = connectionParams.getString("xmpp_host");
						int port = connectionParams.getInt("xmpp_port", 5222);
						String serviceName = connectionParams.getString("xmpp_service");
						String userName = connectionParams.getString("xmpp_user");
						String password = connectionParams.getString("xmpp_password");
						String resource = connectionParams.getString("xmpp_resource");
						
						Log.i(TAG, "Connecting to XMPP with: " + userName + "@" + host + ":" + port + "/" + resource + "service: " + serviceName);
						
						//set up xmpp connection
						ConnectionConfiguration config = new ConnectionConfiguration(
								host, port, serviceName);
						mConn = new XMPPConnection(config);

						// connect and login to XMPP server
						try {
							mConn.connect();
							//mConn.login(username, password, resource);
							mConn.login(userName, password);

							ProviderManager pm = ProviderManager.getInstance();
							configureProviderManager(pm);

							// register PacketListener
							mConn
									.addPacketListener(
											xmppReadWorker,
											new MessageTypeFilter(
													org.jivesoftware.smack.packet.Message.Type.chat));

							msg2.arg1 = MSG_STATUS_SUCCESS;
						} catch (XMPPException e) {
							Log.e(TAG, e.getMessage());
							msg2.arg1 = MSG_STATUS_ERROR;
						}

						xmppResults.sendMessage(msg2);
						break;
					case MSG_DISCONNECT:
						if (mConn == null || !mConn.isConnected()) {
							msg2.arg1 = MSG_STATUS_SUCCESS;
							xmppResults.sendMessage(msg2);
							break;
						}
						// disconnect() deletes all listeners, use shutdown() to
						// retain
						// listeners
						// TODO online disconnect from XMPP server if all
						// service consumers disconnected before
						mConn.disconnect();
						msg2.arg1 = MSG_STATUS_SUCCESS;
						xmppResults.sendMessage(msg2);
						break;
					case MSG_SEND_MESSAGE:
						Bundle dataMsg = msg.getData();
						XMPPMessage payloadMsg = dataMsg
								.getParcelable("PAYLOAD");
						org.jivesoftware.smack.packet.Message xmppMsg = new org.jivesoftware.smack.packet.Message();
						xmppMsg.setTo(payloadMsg.to);
						xmppMsg.setBody(payloadMsg.body);
						switch (payloadMsg.type) {
						case XMPPMessage.TYPE_CHAT:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.chat);
							break;
						case XMPPMessage.TYPE_ERROR:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.error);
							break;
						case XMPPMessage.TYPE_GROUPCHAT:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.groupchat);
							break;
						case XMPPMessage.TYPE_HEADLINE:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.headline);
							break;
						case XMPPMessage.TYPE_NORMAL:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.normal);
							break;
						default:
							xmppMsg
									.setType(org.jivesoftware.smack.packet.Message.Type.chat);
						}

						// send Message over XMPP
						mConn.sendPacket(xmppMsg);

						// send result ack
						msg2.arg1 = MSG_STATUS_DELIVERED;
						xmppResults.sendMessage(msg2);
						break;
					case MSG_SEND_IQ:
						Bundle data = msg.getData();
						XMPPIQ payloadIQ = data.getParcelable("PAYLOAD");
						IQImpl iq = new IQImpl(payloadIQ.payload);
						iq.setTo(payloadIQ.to);
						switch (payloadIQ.type) {
						case XMPPIQ.TYPE_GET:
							iq.setType(Type.GET);
							break;
						case XMPPIQ.TYPE_SET:
							iq.setType(Type.SET);
							break;
						case XMPPIQ.TYPE_RESULT:
							iq.setType(Type.RESULT);
							break;
						case XMPPIQ.TYPE_ERROR:
							iq.setType(Type.ERROR);
							break;
						default:
							iq.setType(Type.GET);
						}

						mConn.sendPacket(iq);

						break;
					case MSG_SEND_PRESENCE:
						Bundle dataPresence = msg.getData();
						XMPPPresence payloadPresence = dataPresence
								.getParcelable("PAYLOAD");
						Presence presence = new Presence(
								Presence.Type.available);
						presence.setStatus(payloadPresence.status);
						presence.setPriority(payloadPresence.priority);
						switch (payloadPresence.mode) {
						case XMPPPresence.MODE_AVAILABLE:
							presence.setMode(Mode.available);
							break;
						case XMPPPresence.MODE_AWAY:
							presence.setMode(Mode.away);
							break;
						case XMPPPresence.MODE_CHAT:
							presence.setMode(Mode.chat);
							break;
						case XMPPPresence.MODE_DND:
							presence.setMode(Mode.dnd);
							break;
						case XMPPPresence.MODE_XA:
							presence.setMode(Mode.xa);
							break;
						default:
							presence.setMode(Mode.available);
						}

						// send Presence over XMPP
						mConn.sendPacket(presence);

						// send result ack
						msg2.arg1 = MSG_STATUS_DELIVERED;
						xmppResults.sendMessage(msg2);
						break;
					}
				}
			};

			Looper.loop();
		}
	}

	/**
	 * An IQ runner thread sends a GET or SET IQ Message to the XMPP server,
	 * constructs a PacketListener for the result with the specific packet ID
	 * and notifies a handler.
	 * 
	 * @author koren
	 * 
	 */
	private class IQRunner implements Runnable {
		private Messenger result;
		private int requestCode;
		private XMPPIQ iq;
		private long timeout = 4000;

		/**
		 * Constructs a new IQ runner.
		 * 
		 * @param result
		 *            the handler to be notified upon IQ result
		 * @param iq
		 *            the iq to be sent, must be of type GET or SET, as RESULT
		 *            and ERROR don't expect results.
		 */
		public IQRunner(Messenger result, int requestCode, XMPPIQ iq) {
			this.result = result;
			this.requestCode = requestCode;
			this.iq = iq;
		}

		/**
		 * 
		 */
		@Override
		public void run() {
			IQImpl iqPacket = new IQImpl(iq.payload);
			iqPacket.setTo(iq.to);
			Log.i(TAG, "sent IQ to: " + iqPacket.getTo());
			switch (iq.type) {
			case XMPPIQ.TYPE_GET:
				iqPacket.setType(Type.GET);
				break;
			case XMPPIQ.TYPE_SET:
				iqPacket.setType(Type.SET);
				break;
			case XMPPIQ.TYPE_RESULT:
				iqPacket.setType(Type.RESULT);
				break;
			case XMPPIQ.TYPE_ERROR:
				iqPacket.setType(Type.ERROR);
				break;
			default:
				iqPacket.setType(Type.GET);
			}
			// create PacketCollector
			PacketCollector coll = mConn
					.createPacketCollector(new PacketIDFilter(iqPacket
							.getPacketID()));
			iqPacket.setFrom(mConn.getUser());
			mConn.sendPacket(iqPacket);
			Log.i(TAG, "IQ: " + iqPacket.toXML());

			Packet resultIQ = coll.nextResult(timeout);
			coll.cancel();

			// construct result Message
			Message resultMsg = Message.obtain();
			resultMsg.what = MSG_SEND_IQ;
			resultMsg.arg2 = requestCode;
			if (resultIQ == null) {
				// timeout
				resultMsg.arg1 = MSG_STATUS_ERROR;
			} else {
				Log.i(TAG, "Success IQ: " + resultIQ.toXML());
				// attach result
				// TODO construct PacketCreator for IQ messages
				resultMsg.arg1 = MSG_STATUS_SUCCESS;
			}

			// notify result handler
			try {
				result.send(resultMsg);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private Handler xmppResults = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// handle response of worker thread
			Message msg2 = Message.obtain(msg);
			try {
				Bundle data = msg.getData();
				Messenger ack = data.getParcelable("MSN_ACK");
				ack.send(msg2);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	private class ReaderThread extends Thread implements PacketListener {

		public void run() {
			Looper.prepare();
			Looper.loop();
		}

		@Override
		public void processPacket(Packet packet) {
			if (packet instanceof org.jivesoftware.smack.packet.Message) {
				org.jivesoftware.smack.packet.Message m = (org.jivesoftware.smack.packet.Message) packet;
				XMPPMessage xMsg = new XMPPMessage(m.getFrom(), m.getTo(), m
						.getBody(), m.getType().ordinal());
				// notify all message callback listeners
				// Broadcast to all clients the new value.
				final int N = mCallbacks.beginBroadcast();
				for (int i = 0; i < N; i++) {
					try {
						mCallbacks.getBroadcastItem(i).processMessage(xMsg);
					} catch (RemoteException e) {
						// The RemoteCallbackList will take care of removing
						// the dead object for us.
					}
				}
				mCallbacks.finishBroadcast();
			}
		}
	}

	private final IXMPPService.Stub mBinder = new IXMPPService.Stub() {

		@Override
		public void connect(Messenger acknowledgement, Bundle connectionParams) throws RemoteException {
			Log.i(TAG, "connect to XMPP server");
			
			// construct the message to initiate the XMPP connection from the XMPP service
			Message msg = new Message();
			msg.what = MSG_CONNECT;

			// set ack target
			Bundle data = new Bundle();
			data.putAll(connectionParams);
			data.putParcelable("MSN_ACK", acknowledgement);
			msg.setData(data);

			xmppWriteWorker.mHandler.sendMessage(msg);
		}

		@Override
		public void disconnect(Messenger acknowledgement)
				throws RemoteException {
			Log.i(TAG, "disconnect from XMPP server");
			Message msg = new Message();
			msg.what = MSG_DISCONNECT;

			// set ack target
			Bundle data = new Bundle();
			data.putParcelable("MSN_ACK", acknowledgement);
			msg.setData(data);

			xmppWriteWorker.mHandler.sendMessage(msg);
		}

		@Override
		public void sendMessage(Messenger acknowledgement, int requestCode,
				XMPPMessage message) throws RemoteException {
			Message msg = new Message();
			// send packet
			msg.what = MSG_SEND_MESSAGE;
			msg.arg2 = requestCode;
			// create new Bundle and supply the Acknowledgement Messenger
			Bundle data = new Bundle();
			data.putParcelable("MSN_ACK", acknowledgement);
			data.putParcelable("PAYLOAD", message);
			msg.setData(data);

			// send message to worker thread
			xmppWriteWorker.mHandler.sendMessage(msg);
		}

		@Override
		public void sendIQ(Messenger acknowledgement, Messenger result,
				int requestCode, XMPPIQ iq) throws RemoteException {
			// if iq type is GET or SET, send iq to ThreadPool for result
			// waiting. if iq type is RESULT or ERROR, send iq to worker thread
			// TODO send acknowledgement, not just result
			if (iq.type == XMPPIQ.TYPE_GET || iq.type == XMPPIQ.TYPE_SET) {
				IQRunner iqRunJob = new IQRunner(result, requestCode, iq);
				mExecutorIQ.execute(iqRunJob);
			} else {
				Message msg = new Message();
				msg.what = MSG_SEND_IQ;
				msg.arg1 = MSG_STATUS_REQUEST;
				msg.arg2 = requestCode;
				Bundle data = new Bundle();
				data.putParcelable("MSN_ACK", acknowledgement);
				data.putParcelable("MSN_RESULT", result);
				data.putParcelable("PAYLOAD", iq);
				msg.setData(data);

				// send iq to worker thread
				xmppWriteWorker.mHandler.sendMessage(msg);
			}
		}

		@Override
		public void sendPresence(Messenger acknowledgement, int requestCode,
				XMPPPresence presence) throws RemoteException {
			Message msg = new Message();
			// send packet
			msg.what = MSG_SEND_PRESENCE;
			msg.arg2 = requestCode;
			// create new Bundle and supply the Acknowledgement Messenger
			Bundle data = new Bundle();
			data.putParcelable("MSN_ACK", acknowledgement);
			data.putParcelable("PAYLOAD", presence);
			msg.setData(data);

			// send message to worker thread
			xmppWriteWorker.mHandler.sendMessage(msg);
		}

		@Override
		public void registerMessageCallback(IXMPPMessageCallback cb)
				throws RemoteException {
			if (cb != null)
				mCallbacks.register(cb);
		}

		@Override
		public void unregisterMessageCallback(IXMPPMessageCallback cb)
				throws RemoteException {
			if (cb != null)
				mCallbacks.unregister(cb);
		}

	};

	/**
	 * WORKAROUND for Android only! The necessary configuration files for Smack
	 * library are not included in Android's apk-Package.
	 * 
	 * @param pm
	 *            A ProviderManager instance.
	 */
	private void configureProviderManager(ProviderManager pm) {

		// Private Data Storage
		pm.addIQProvider("query", "jabber:iq:private",
				new PrivateDataManager.PrivateDataIQProvider());

		// Time
		try {
			pm.addIQProvider("query", "jabber:iq:time", Class
					.forName("org.jivesoftware.smackx.packet.Time"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Roster Exchange
		pm.addExtensionProvider("x", "jabber:x:roster",
				new RosterExchangeProvider());

		// Message Events
		pm.addExtensionProvider("x", "jabber:x:event",
				new MessageEventProvider());

		// Chat State
		pm.addExtensionProvider("active",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("composing",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("paused",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("inactive",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());
		pm.addExtensionProvider("gone",
				"http://jabber.org/protocol/chatstates",
				new ChatStateExtension.Provider());

		// XHTML
		pm.addExtensionProvider("html", "http://jabber.org/protocol/xhtml-im",
				new XHTMLExtensionProvider());

		// Group Chat Invitations
		pm.addExtensionProvider("x", "jabber:x:conference",
				new GroupChatInvitation.Provider());

		// Service Discovery # Items
		pm.addIQProvider("query", "http://jabber.org/protocol/disco#items",
				new DiscoverItemsProvider());

		// Service Discovery # Info
		pm.addIQProvider("query", "http://jabber.org/protocol/disco#info",
				new DiscoverInfoProvider());

		// Data Forms
		pm.addExtensionProvider("x", "jabber:x:data", new DataFormProvider());

		// MUC User
		pm.addExtensionProvider("x", "http://jabber.org/protocol/muc#user",
				new MUCUserProvider());

		// MUC Admin
		pm.addIQProvider("query", "http://jabber.org/protocol/muc#admin",
				new MUCAdminProvider());

		// MUC Owner
		pm.addIQProvider("query", "http://jabber.org/protocol/muc#owner",
				new MUCOwnerProvider());

		// Delayed Delivery
		pm.addExtensionProvider("x", "jabber:x:delay",
				new DelayInformationProvider());

		// Version
		try {
			pm.addIQProvider("query", "jabber:iq:version", Class
					.forName("org.jivesoftware.smackx.packet.Version"));
		} catch (ClassNotFoundException e) {
			// Not sure what's happening here.
		}

		// VCard
		pm.addIQProvider("vCard", "vcard-temp", new VCardProvider());

		// Offline Message Requests
		pm.addIQProvider("offline", "http://jabber.org/protocol/offline",
				new OfflineMessageRequest.Provider());

		// Offline Message Indicator
		pm.addExtensionProvider("offline",
				"http://jabber.org/protocol/offline",
				new OfflineMessageInfo.Provider());

		// Last Activity
		pm
				.addIQProvider("query", "jabber:iq:last",
						new LastActivity.Provider());

		// User Search
		pm
				.addIQProvider("query", "jabber:iq:search",
						new UserSearch.Provider());

		// SharedGroupsInfo
		pm.addIQProvider("sharedgroup",
				"http://www.jivesoftware.org/protocol/sharedgroup",
				new SharedGroupsInfo.Provider());

		// JEP-33: Extended Stanza Addressing
		pm.addExtensionProvider("addresses",
				"http://jabber.org/protocol/address",
				new MultipleAddressesProvider());

		// FileTransfer
		pm.addIQProvider("si", "http://jabber.org/protocol/si",
				new StreamInitiationProvider());
		pm.addIQProvider("query", "http://jabber.org/protocol/bytestreams",
				new BytestreamsProvider());
		pm.addIQProvider("open", "http://jabber.org/protocol/ibb",
				new IBBProviders.Open());
		pm.addIQProvider("close", "http://jabber.org/protocol/ibb",
				new IBBProviders.Close());
		pm.addExtensionProvider("data", "http://jabber.org/protocol/ibb",
				new IBBProviders.Data());

		// Privacy
		pm.addIQProvider("query", "jabber:iq:privacy", new PrivacyProvider());
	}

}
