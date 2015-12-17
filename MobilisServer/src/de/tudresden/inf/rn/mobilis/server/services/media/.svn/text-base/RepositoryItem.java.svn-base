package de.tudresden.inf.rn.mobilis.server.services.media;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.MapKey;

import de.tudresden.inf.rn.mobilis.xmpp.beans.media.RepositoryItemInfo;

@Entity @Table(name="mobilis_repositoryitem")
public class RepositoryItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="uid")
	public String uid;
	
	@Column(name="content")
	public String content;
	
	@Column(name="owner")
	public String owner;

	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name="mobilis_repositoryitem_slice",
			joinColumns={@JoinColumn(name="uid", updatable=false, insertable=false, nullable=false)} /*"=false"s needed?*/ )
	@Enumerated(value=EnumType.STRING)
	@MapKey(columns={@Column(name="slice_key")})
	@Column(name="slice_value")
	@Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	public Map<String, String> slices = new TreeMap<String, String>();
	
	public void fromInfo(RepositoryItemInfo rii, RepositoryType.Resolver resolver, boolean modifyContent) {
		if (modifyContent) this.content = rii.getContent();
		this.owner = rii.getOwner();
		this.uid = rii.getUid();
		this.slices.clear();
		for (String key: rii.getSlices().keySet()) {
			RepositoryType type = resolver.getSlicingType(key);
			if (type != null)
				this.slices.put(key, type.convertXmlToHql( rii.getSlices().get(key)	));
		}
	}
	
	public RepositoryItemInfo toInfo(RepositoryType.Resolver resolver) {
		RepositoryItemInfo rii = new RepositoryItemInfo();
		rii.setContent(this.content);
		rii.setUid(this.uid);
		rii.setOwner(this.owner);
		rii.getSlices().clear();
		for (String key: this.slices.keySet()) {
			RepositoryType type = resolver.getSlicingType(key);
			if (type != null)
				rii.getSlices().put(key, type.convertHqlToXml( this.slices.get(key) ));
		}
		return rii;
	}
	
	/*@OneToMany
	@OrderBy(value="key.key")
	@JoinColumn(name="uid")
	@Cascade(value={CascadeType.DELETE_ORPHAN})
	public List<RepositoryItemSlice> slices = new LinkedList<RepositoryItemSlice>();*/
	
	/*@OneToMany(mappedBy="uid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OrderBy(value="key")
	public List<Slice> slices;*/
}
