/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package jabberSrpc;


public class Stub {

	long         timeOut=300000;
	String       target;
	String       className;
	String       threadID;
	JabberClient jabberClient;

	public Stub(JabberClient client,String cName) {
		jabberClient=client;
		className=cName;
		threadID=null;
	}

	protected Object sendRPC(String methodName,Object o,String targetJID,boolean waitForResponse) {
		if (targetJID==null) return null;
		Object resultObject=null;

		if (!jabberClient.isConnected()) return null;
		String call=className+"."+methodName;
		if (threadID!=null) {
			call=call+'@'+threadID;
		}
		if (waitForResponse) {
			resultObject=jabberClient.callB(call, o, targetJID, timeOut);
		} else {
			jabberClient.callNB(call, o, targetJID);
		}

		return resultObject;
	}

	protected Object sendRPC(String methodName,Object o,boolean waitForResponse) {
		return sendRPC(methodName,o, target,waitForResponse);
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public String getThreadID() {
		return threadID;
	}

	public void setThreadID(String threadID) {
		this.threadID = threadID;
	}

}
