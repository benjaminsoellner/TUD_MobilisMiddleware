/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\callbacks\\IInvitationCallback.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.callbacks;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
public interface IInvitationCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IInvitationCallback interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_onInvitationReceived:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage _arg4;
if ((0!=data.readInt())) {
_arg4 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage.CREATOR.createFromParcel(data);
}
else {
_arg4 = null;
}
this.onInvitationReceived(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Called on a received invitation.
     */
public void onInvitationReceived(java.lang.String room, java.lang.String inviter, java.lang.String reason, java.lang.String password, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(room);
_data.writeString(inviter);
_data.writeString(reason);
_data.writeString(password);
if ((message!=null)) {
_data.writeInt(1);
message.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onInvitationReceived, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onInvitationReceived = (IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Called on a received invitation.
     */
public void onInvitationReceived(java.lang.String room, java.lang.String inviter, java.lang.String reason, java.lang.String password, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException;
}
