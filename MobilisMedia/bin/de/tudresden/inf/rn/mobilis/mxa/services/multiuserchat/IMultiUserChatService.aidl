package de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat;

interface IMultiUserChatService {

    /**
     * Sends a message to the whole group.
     */
    void sendGroupMessage();
    
    /**
     * Gets all members of the provided group.
     */
    void getMembers();
    
    /**
     * Register a callback for invitations.
     */
    void registerConnectionCallback();
}