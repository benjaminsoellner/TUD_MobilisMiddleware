/**
 * 
 */
package de.tudresden.inf.rn.mobilis.saaas.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author koren
 *
 */
public class XMPPIQ implements Parcelable {

	// members
	private String packetID;
	public String to;
	private String from;
	public int type;
	public String payload;
	
	// type enums
	public static final int TYPE_GET = 0;
	public static final int TYPE_SET = 1;
	public static final int TYPE_RESULT = 2;
	public static final int TYPE_ERROR = 3;


	public static final Parcelable.Creator<XMPPIQ> CREATOR = new Parcelable.Creator<XMPPIQ>() {
		public XMPPIQ createFromParcel(Parcel in) {
			return new XMPPIQ(in);
		}

		public XMPPIQ[] newArray(int size) {
			return new XMPPIQ[size];
		}
	};

	public XMPPIQ() {
	}
	
	public XMPPIQ(String from, String to, int type, String payload) {
		this.from = from;
		this.to = to;
		this.type = type;
		this.payload = payload;
	}

	private XMPPIQ(Parcel in) {
		readFromParcel(in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(packetID);
		dest.writeString(to);
		dest.writeString(from);
		dest.writeInt(type);
		dest.writeString(payload);
	}

	public void readFromParcel(Parcel in) {
		packetID = in.readString();
		to = in.readString();
		from = in.readString();
		type = in.readInt();
		payload = in.readString();
	}

}
