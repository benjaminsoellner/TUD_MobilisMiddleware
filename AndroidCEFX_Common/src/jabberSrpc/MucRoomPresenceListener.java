/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package jabberSrpc;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.packet.Packet;

public class MucRoomPresenceListener implements PacketListener {
	private MucRoomListener handler=null;

    public void processPacket(Packet packet) {
    	if (packet==null) return;
		if (handler!=null) {
			handler.processPresencePacket(packet);
		}
    }

    public void setHandler(MucRoomListener h) {
    	handler=h;
    }
}
