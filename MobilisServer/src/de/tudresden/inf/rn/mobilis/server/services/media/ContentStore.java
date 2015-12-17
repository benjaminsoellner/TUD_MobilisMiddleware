package de.tudresden.inf.rn.mobilis.server.services.media;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import de.tudresden.inf.rn.mobilis.server.HibernateUtil;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPUtil;


public class ContentStore {
	
	private Set<String> registeredRepositories
			= Collections.synchronizedSet(new HashSet<String>());
	private String storageFolder;
	private Map<ContentItem.Identifier,String> expectedItems
			= Collections.synchronizedMap(new HashMap<ContentItem.Identifier,String>());
	
	public ContentStore(String storageFolder) {
		this.storageFolder = storageFolder;
	}
		
	public boolean isRepositoryRegistered(String repository) {
		return this.registeredRepositories.contains(repository);
	}
	
	public void register(String repository) {
		this.registeredRepositories.add(repository);
	}
	
	public void unregister(String repository) {
		this.registeredRepositories.remove(repository);
	}
		
	public void expectItem(String repository, String uid, String source) {
		ContentItem.Identifier identifier = new ContentItem.Identifier(repository, uid);
		this.expectItem(identifier, source);
	}
	
	public void expectItem(ContentItem.Identifier identifier, String source) {
		this.expectedItems.put(identifier, source);
	}
		
	public ContentItem findItem(ContentItem.Identifier identifier) {
		Session session = HibernateUtil.getSession();
		Object o = session.get(ContentItem.class, identifier);
		if (o != null && (o instanceof ContentItem))
			return (ContentItem)o;
		else
			return null;
	}
	
	public ContentItem acceptExpectedItem(ContentItem.Identifier identifier, String source,
			String filename, String mimetype, String description) {
		if (this.expectedItems.containsKey(identifier)
				&& XMPPUtil.similarJid(this.expectedItems.get(identifier), source)) {
			Session session = HibernateUtil.getSession();
			ContentItem item = this.findItem(identifier);
			if (item == null) {
				item = new ContentItem();
				item.identifier = identifier;
			}
			this.expectedItems.remove(identifier);
			item.filename = filename;
			item.mimetype = mimetype;
			item.description = description;
			item.source = source;
			session.save(item);
			session.flush();
			return item;
		} else
			return null;
	}
	
	public File getItemFile(ContentItem.Identifier key) {
		return new File(
				this.storageFolder + File.separatorChar + key.toString().replace('/', '$')
			); 
	}
			
	public void deleteItem(ContentItem.Identifier identifier) {
		ContentItem item = this.findItem(identifier);
		this.deleteItem(item);
	}
	
	public void deleteItem(ContentItem item) {
		Session session = HibernateUtil.getSession();
		this.getItemFile(item.identifier).delete();
		session.delete(item);
		session.flush();
	}

}
