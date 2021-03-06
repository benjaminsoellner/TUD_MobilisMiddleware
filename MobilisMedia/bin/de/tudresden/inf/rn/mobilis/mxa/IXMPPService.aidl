/**
 * Copyright (C) 2009 Technische Universitšt Dresden
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

package de.tudresden.inf.rn.mobilis.mxa;

import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback;
import de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService;
import de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService;
import de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService;

interface IXMPPService {

    /**
     * Connect to the XMPP server.
     */
	void connect(in Messenger acknowledgement);
	
	/**
	 * Only disconnects if all binders have been removed.
	 */
	void disconnect(in Messenger acknowledgement);
	
	/**
	 * Returns whether the service is connected or not.
	 */
	boolean isConnected();
	
	/**
	 * Returns the JID of the logged in XMPP user.
	 */
	String getUsername();
	
	/**
	 * param requestCode: Reply request code. < 0 if reply is not requested.
	 */
	void sendMessage(in Messenger acknowledgement, in int requestCode, in XMPPMessage message);

    /**
     *
     */
    void sendIQ(in Messenger acknowledgement, in Messenger result, in int requestCode, in XMPPIQ iq);
    
    /**
     *
     */
    void sendPresence(in Messenger acknowledgement, in int requestCode, in XMPPPresence presence);

    /**
     * Registers a callback interface with the service that will be notified
     * upon connection changes.
     */
    void registerConnectionCallback(IConnectionCallback cb);
    
    /**
     * Remove a previously registered connection callback interface.
     */
    void unregisterConnectionCallback(IConnectionCallback cb);
    
    /**
     * Registers a callback interface with the service that will be notified
     * upon new data messages (i.e. those who have an mxa-ident packet extension).
     */
    void registerDataMessageCallback(IXMPPMessageCallback cb, in String namespace, in String token);
    
    /**
     * Removes a previously registered data message callback interface.
     */
    void unregisterDataMessageCallback(IXMPPMessageCallback cb, in String namespace, in String token);
    
    /**
     * Registers a callback interface with the service that will be notified
     * upon new IQ messages.
     *
     * @param namespace: The namespace for filtering incoming IQ.
     * @param token: The token for filtering incoming IQ.
     */
    void registerIQCallback(IXMPPIQCallback cb, in String elementName, in String namespace);
    
    /**
     * Removes a previously registered IQ callback interface.
     */
    void unregisterIQCallback(IXMPPIQCallback cb, in String elementName, in String namespace);
    
    // ==========================================================
	// Additional Services
	// ==========================================================
	
	/**
    * A service used for XMPP Service Discovery
    */
    IServiceDiscoveryService getServiceDiscoveryService();
	
	/**
	 * A basic File-Transfer service based on XMPP.
	 */
	IFileTransferService getFileTransferService();
	
	/**
	 * A basic publish-subscribe service for general purposes.
	 */
	IPubSubService getPubSubService();
}
