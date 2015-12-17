package de.tudresden.inf.rn.mobilis.xmpp.beans;

public class XMPPUtil {

	private XMPPUtil() {}
	
	public static boolean isFullyQualified(String jid) {
		return !XMPPUtil.jidWithoutRessource(jid).equals(jid);
	}
	
	public static boolean similarJid(String first, String second) {
		String firstTrimmed  = XMPPUtil.jidWithoutRessource(first);
		String secondTrimmed = XMPPUtil.jidWithoutRessource(second);
		return firstTrimmed.equals(secondTrimmed);
	}
	
	public static String jidWithoutRessource(String jid) {
		int slashIndex = jid.indexOf('/');
		if (slashIndex == -1)
			return jid;
		else
			return jid.substring(0, slashIndex);
	}
	
}
