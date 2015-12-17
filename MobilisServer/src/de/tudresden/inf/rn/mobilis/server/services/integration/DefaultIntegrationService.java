/**
 * 
 */
package de.tudresden.inf.rn.mobilis.server.services.integration;

import java.util.Collection;
import java.util.List;

import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.IQTypeFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.IQ.Type;

import de.tudresden.inf.rn.mobilis.server.MobilisManager;
import de.tudresden.inf.rn.mobilis.xmpp.filter.NetworkFilter;
import de.tudresden.inf.rn.mobilis.xmpp.packet.BuddylistIQ;

/**
* The purpose of DefaultIntegrationService is to keep a buddylist for a network.
 * 
 * @author Christopher
 */
public class DefaultIntegrationService extends MobilisIntegrationService {

	public DefaultIntegrationService(String network) {
		super(network);
    }
	
	// XMPP related functions
	
	@Override
	protected void registerPacketListener() {
		mSNIS.getAgent().getConnection().addPacketListener(this, new AndFilter(
           	new NetworkFilter(getIdent()),
        	new PacketTypeFilter(BuddylistIQ.class),
        	new IQTypeFilter(Type.SET)
        ));
	}

	@Override
	public List<String> getNodeFeatures() {
		List<String> features = super.getNodeFeatures();
		features.add(MobilisManager.discoNamespace + "#buddylist");
		return features;
    }

	@Override
	public void processPacket(Packet p) {
        if (p instanceof BuddylistIQ) {
        	BuddylistIQ iq = (BuddylistIQ) p;
            String requester = iq.getFrom();
            
            try {
				String identity = iq.getIdentity();
				if (identity != null) {
				    setIdentity(requester, identity);
				}
				
				Collection<String> contacts = iq.getBuddies();
				if (contacts != null) {
				    setBuddies(identity, contacts);
				    MobilisManager.getLogger().info(requester + " added " + contacts.size() + " contacts from " + iq.getNetwork() );
				    MobilisManager.getLogger().finest("Buddies: " + contacts);
				}
				
				iq.setType(Type.RESULT);
				
				MobilisManager.getLogger().info(requester + " retrieved " + getIdent() + " buddylist.");
			} catch (Exception e) {
				iq.setType(Type.ERROR);
				
				MobilisManager.getLogger().warning(requester + " tried to retrieve " + getIdent() + " buddylist and FAILED.");
			}
            
			iq.setFrom(mSNIS.getAgent().getConnection().getUser());
			iq.setTo(requester);
			
			mSNIS.getAgent().getConnection().sendPacket(iq);
        }
	}
}
