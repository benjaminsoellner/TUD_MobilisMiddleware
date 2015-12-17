package de.tudresden.inf.rn.mobilis.mxa.services.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class DiscoverItem implements Parcelable {

	public String name;
	public String jid;
	public String node;
	
	public static final Parcelable.Creator<DiscoverItem> CREATOR
			= new Parcelable.Creator<DiscoverItem>() {
		public DiscoverItem createFromParcel(Parcel in) {
			return new DiscoverItem(in);
		};
		public DiscoverItem[] newArray(int size) {
			return new DiscoverItem[size];
		}
	}; 
	
	public DiscoverItem() {}
	
	public DiscoverItem(Parcel in) {
		this.readFromParcel(in);
	}
	
	public DiscoverItem(String name, String jid, String node) {
		this.name = name;
		this.jid = jid;
		this.node = node;
	}
	
	public void readFromParcel(Parcel in) {
		this.name = in.readString();
		this.jid  = in.readString();
		this.node = in.readString();
	}	

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(this.name);
		out.writeString(this.jid);
		out.writeString(this.node);
	}
	
}
