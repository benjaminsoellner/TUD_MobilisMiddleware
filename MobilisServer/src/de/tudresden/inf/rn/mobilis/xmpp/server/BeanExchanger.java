package de.tudresden.inf.rn.mobilis.xmpp.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPConnection;

import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class BeanExchanger<B extends XMPPBean> {

	private static final int TIMEOUT = 2000; 
	private XMPPConnection connection;
	private B beanOut;
	private B beanIn;
	private PacketCollector beanCollector;

	static private ExecutorService threads = Executors.newSingleThreadExecutor();
	
	public BeanExchanger(XMPPConnection connection) {
		this.connection = connection;
	}
	
	public B exchange(B bean) {
		synchronized (this) {
			BeanExchanger<B> owner = BeanExchanger.this;
			this.beanOut = bean;
			this.beanIn  = null;
			this.beanCollector = owner.connection.createPacketCollector(
					new BeanFilterAdapter(bean));
			Thread t = new Thread(new BeanWaiter());
			t.setName("Mobilis BeanExchanger");
			BeanExchanger.threads.execute(t);
			this.connection.sendPacket(new BeanIQAdapter(bean));
			try {
				if (this.beanIn == null) this.wait();
			} catch (InterruptedException e) {}
			return this.beanIn;
		}
	}
	
	private class BeanWaiter implements Runnable {
		@SuppressWarnings("unchecked")
		@Override public void run() {
			BeanExchanger<B> owner = BeanExchanger.this;
			synchronized (BeanExchanger.this) {
				BeanIQAdapter adapter = (BeanIQAdapter)(owner.beanCollector.nextResult());
				owner.beanIn = (B)(adapter.getBean());
				owner.notify();
			}
		}
	}
	
}
