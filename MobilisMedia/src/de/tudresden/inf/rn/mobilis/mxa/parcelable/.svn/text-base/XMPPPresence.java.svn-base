/**
 * 
 */
package de.tudresden.inf.rn.mobilis.mxa.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author koren
 * 
 */
public class XMPPPresence implements Parcelable {

	// members
	public int mode;
	/**
	 * The status text for additional information, e.g. "having dinner".
	 */
	public String status;
	public int priority;

	// mode enums
	public static final int MODE_AVAILABLE = 0;
	public static final int MODE_AWAY = 1;
	public static final int MODE_CHAT = 2;
	public static final int MODE_DND = 3;
	public static final int MODE_XA = 4;

	public static final Parcelable.Creator<XMPPPresence> CREATOR = new Parcelable.Creator<XMPPPresence>() {
		public XMPPPresence createFromParcel(Parcel in) {
			return new XMPPPresence(in);
		}

		public XMPPPresence[] newArray(int size) {
			return new XMPPPresence[size];
		}
	};

	public XMPPPresence() {
	}

	public XMPPPresence(int mode, String status, int priority) {
		this.mode = mode;
		this.status = status;
		this.priority = priority;
	}

	private XMPPPresence(Parcel in) {
		readFromParcel(in);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#describeContents()
	 */
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mode);
		dest.writeString(status);
		dest.writeInt(priority);
	}

	public void readFromParcel(Parcel in) {
		mode = in.readInt();
		status = in.readString();
		priority = in.readInt();
	}

}
