/*
 * Copyright (C) 2009 Technische Universität Dresden
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat;

import java.util.HashMap;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.muc.InvitationListener;
import org.jivesoftware.smackx.muc.MultiUserChat;

import de.tudresden.inf.rn.mobilis.mxa.XMPPRemoteService;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * The MultiUserChat service is based on XEP-0045.
 * 
 * @author Istvan Koren
 * 
 */
public class MultiUserChatService extends Service {

	private static final String TAG = "MultiUserChatService";

	private final XMPPRemoteService mXMPPService;
	private ReaderThread mXMPPReadWorker;
	/**
	 * HashMap with key roomID and value the associated MultiUserChat object.
	 */
	private HashMap<String, MultiUserChat> mMUCRooms;

	public MultiUserChatService(XMPPRemoteService service) {
		mXMPPService = service;

		mXMPPReadWorker = new ReaderThread();
		mMUCRooms = new HashMap<String, MultiUserChat>();

		MultiUserChat.addInvitationListener(mXMPPService.getXMPPConnection(),
				mXMPPReadWorker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent i) {
		return mBinder;
	}

	private final IMultiUserChatService.Stub mBinder = new IMultiUserChatService.Stub() {

		@Override
		public void changeNickname(String roomID, String nickname)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void declineInvitation(String roomID, String inviter,
				String reason) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void getMembers(String roomID) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void registerInvitationCallback(IInvitationCallback cb)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void sendGroupMessage(String roomID, XMPPMessage msg)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unregisterInvitationCallback(IInvitationCallback cb)
				throws RemoteException {
			// TODO Auto-generated method stub
			
		}

	};

	// ==========================================================
	// Private methods
	// ==========================================================

	// ==========================================================
	// Inner classes
	// ==========================================================

	private class ReaderThread extends Thread implements InvitationListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.jivesoftware.smackx.muc.InvitationListener#invitationReceived
		 * (org.jivesoftware.smack.XMPPConnection, java.lang.String,
		 * java.lang.String, java.lang.String, java.lang.String,
		 * org.jivesoftware.smack.packet.Message)
		 */
		@Override
		public void invitationReceived(XMPPConnection conn, String room,
				String inviter, String reason, String password, Message message) {

		}
	}
}
