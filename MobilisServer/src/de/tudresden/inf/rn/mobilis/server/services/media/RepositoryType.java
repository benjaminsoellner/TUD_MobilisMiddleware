/**
 * 
 */
package de.tudresden.inf.rn.mobilis.server.services.media;

public enum RepositoryType {
	
	INTEGER, FLOAT, STRING, DECIMAL, TIMESTAMP;
	
	public String convertXmlToHql(String xml) {
		switch (this) {
		case INTEGER: case FLOAT: case TIMESTAMP: case STRING:
			return xml;
		default:
			return null;
		}
	}
	
	public String convertHqlToXml(String hql) {
		switch (this) {
		case INTEGER: case FLOAT: case TIMESTAMP: case STRING:
			return hql;
		default:
			return null;
		}
	}
	
	public String toHQL() {
		switch (this) {
			case INTEGER: return "cast(%s as integer)";
			case FLOAT: return "%s"; 
			case TIMESTAMP: return "%s";
			case STRING: default: return "%s";
		}
	}
	
	public static RepositoryType fromSettingString(String settingString) {
		if (settingString.equals("integer"))
			return RepositoryType.INTEGER;
		else if (settingString.equals("float"))
			return RepositoryType.FLOAT;
		else if (settingString.equals("timestamp"))
			return RepositoryType.TIMESTAMP;
		else
			return RepositoryType.STRING;
	}
	
	public static interface Resolver {
		public void addSlicing(String key, RepositoryType type);
		public RepositoryType getSlicingType(String key);
	}
	
}