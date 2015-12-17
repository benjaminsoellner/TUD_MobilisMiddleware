package de.tudresden.inf.rn.mobilis.server.services.media;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name="mobilis_contentitem")
public class ContentItem implements Serializable {		

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
		public ContentItem.Identifier identifier;
	@Column(name="source")
		public String source;
	@Column(name="description")
		public String description;
	@Column(name="mimetype")
		public String mimetype;
	@Column(name="filename")
		public String filename;

	
	public static class Identifier implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		public Identifier() {}
		public Identifier(String repository, String uid) {
			this.repository = repository; this.uid = uid;
		}
		
		@Column(name="repository")
			public String repository;
		@Column(name="uid")
			public String uid;
		
		@Override
		public int hashCode() {
			return this.toString().hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			return (obj instanceof Identifier)
					&& ((ContentItem.Identifier)obj).repository.equals(this.repository)
					&& ((ContentItem.Identifier)obj).uid.equals(this.uid);
		}
		@Override
		public String toString() {
			return this.repository + "#" + this.uid;
		}
		
	}

	
}