/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package jabberSrpc;

import org.jivesoftware.smack.packet.Packet;

public interface MucRoomListener {

	public void processMessage(Packet packet);

	public void processPresencePacket(Packet packet);

}
