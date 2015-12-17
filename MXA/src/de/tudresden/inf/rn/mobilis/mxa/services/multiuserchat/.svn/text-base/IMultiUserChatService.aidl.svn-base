/**
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

import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback;

interface IMultiUserChatService {

    /**
     * Sends a message to the whole group.
     */
    void sendGroupMessage(in String roomID, in XMPPMessage msg);
    
    /**
     * Gets all members of the provided group.
     */
    void getMembers(in String roomID);
    
    /**
     * Registers a callback for invitations.
     */
    void registerInvitationCallback(IInvitationCallback cb);
    
    /**
     * Unregisters a previously registered invitation callback.
     */
    void unregisterInvitationCallback(IInvitationCallback cb);
    
    /**
     * Changes the nickname within the room.
     */
    void changeNickname(String roomID, String nickname);
    
    /**
     * Declines a previously received invitation.
     */
    void declineInvitation(String roomID, String inviter, String reason);
}