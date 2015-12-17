package de.tudresden.inf.rn.mobilis.xmpp.beans.media;

import java.util.LinkedList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import de.tudresden.inf.rn.mobilis.xmpp.beans.ConditionInfo;
import de.tudresden.inf.rn.mobilis.xmpp.beans.Mobilis;
import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class RepositoryQueryBean extends XMPPBean {

	private static final long serialVersionUID = 1L;
	public static final String NAMESPACE = Mobilis.NAMESPACE + "#services/RepositoryService";
	public static final String CHILD_ELEMENT = "repository-query";

	protected ConditionInfo condition = null; // for get 
	protected List<RepositoryItemInfo> items = new LinkedList<RepositoryItemInfo>(); // for result / set
	
	public ConditionInfo getCondition() { return this.condition; }
	public List<RepositoryItemInfo> getItems() { return this.items; }
	
	public void setCondition(ConditionInfo condition) { this.condition = condition; }
	
	@Override
	public RepositoryQueryBean clone() {
		RepositoryQueryBean twin = new RepositoryQueryBean();
		twin.id   = this.id;
		twin.from = this.from;
		twin.to   = this.to;
		twin.type = this.type;
		if (this.condition != null)
			twin.condition = this.condition.clone();
		twin.items.clear();
		for (RepositoryItemInfo ri: this.items)
			twin.items.add(ri.clone());
		return twin;
	}

	@Override
	public void fromXML(XmlPullParser parser) throws Exception {
		String childElement = RepositoryQueryBean.CHILD_ELEMENT;
		boolean done = false;
		this.items.clear();
		do {
			switch (parser.getEventType()) {
			case XmlPullParser.START_TAG:
				String tagName = parser.getName();
				if (tagName.equals(childElement)) {
					parser.next();
				} else if (tagName.equals(ConditionInfo.CHILD_ELEMENT)) {
					ConditionInfo ci = new ConditionInfo();
					ci.fromXML(parser);
					this.condition = ci;
				} else if (tagName.equals(RepositoryItemInfo.CHILD_ELEMENT)) {
					RepositoryItemInfo ri = new RepositoryItemInfo();
					ri.fromXML(parser);
					this.items.add(ri);
				} else
					parser.next();
				break;
			case XmlPullParser.END_TAG:
				if (parser.getName().equals(childElement))
					done = true;
				else
					parser.next();
				break;
			case XmlPullParser.END_DOCUMENT:
				done = true;
				break;
			default:
				parser.next();
			}
		} while (!done);
	}

	@Override
	public String getChildElement() {
		return RepositoryQueryBean.CHILD_ELEMENT;
	}

	@Override
	public String getNamespace() {
		return RepositoryQueryBean.NAMESPACE;
	}

	@Override
	public String payloadToXML() {
		StringBuilder sb = new StringBuilder();
		if (this.condition != null)
			sb.append(this.condition.toXML());
		for (RepositoryItemInfo ri: this.items)
			sb.append(ri.toXML());
		return sb.toString();
	}

}
