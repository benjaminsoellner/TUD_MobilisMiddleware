package de.tudresden.inf.rn.mobilis.server.services.media;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.hibernate.Session;

import de.tudresden.inf.rn.mobilis.server.HibernateUtil;
import de.tudresden.inf.rn.mobilis.xmpp.beans.ConditionInfo;
import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryItemInfo;

public class RepositoryCube implements RepositoryType.Resolver {

	private SortedMap<String, RepositoryType> slicings
			= new TreeMap<String, RepositoryType>();

	public void addSlicing(String key, RepositoryType type) {
		this.slicings.put(key, type);
	}
	
	public RepositoryType getSlicingType(String key) {
		return this.slicings.get(key);
	}
	
	private Map<String, RepositoryType> generateNeededSlicings(ConditionInfo condition) {
		SortedSet<String> neededKeys = new TreeSet<String>();
		SortedMap<String, RepositoryType> neededSlicings = new TreeMap<String, RepositoryType>(); 
		if (condition == null) return neededSlicings;
		condition.getKeys(neededKeys);
		Set<String> keys = this.slicings.keySet();
		for (String key: neededKeys)
			if (keys.contains(key))
				neededSlicings.put(key, this.slicings.get(key));
		return neededSlicings;
	}
	
	private Map<String,String> generateKeyLookup(ConditionInfo condition) {
		Map<String, RepositoryType> neededSlicings = this.generateNeededSlicings(condition);
		Map<String, String> keyLookup = new TreeMap<String,String>();
		for (String key: neededSlicings.keySet()) {
			keyLookup.put( key, String.format(neededSlicings.get(key).toHQL(), "it.slices['"+key+"']") );
		}
		return keyLookup;
	}
	
	private String generateHQLStatement(ConditionInfo condition) {
		Map<String, String> keyLookup = this.generateKeyLookup(condition);
		StringBuilder sb = new StringBuilder()
				.append("from ").append(RepositoryItem.class.getCanonicalName()).append(" it");
		if (condition != null)
			sb.append(" where ").append(condition.toHQL(keyLookup));
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<RepositoryItem> getItems(ConditionInfo condition) {
		String q = this.generateHQLStatement(condition);
		Session s = (Session) HibernateUtil.getSession();
		return (Collection<RepositoryItem>) s.createQuery(q).list();
	}
	
	public RepositoryItem getItem(RepositoryItemInfo itemInfo) {
		String uid = itemInfo.getUid();
		return this.getItem(uid);
	}
	
	public RepositoryItem getItem(String uid) {
		if (uid == null)
			return null;
		else
			return (RepositoryItem) HibernateUtil.getSession().get(RepositoryItem.class, uid);
	}
	
	
}
