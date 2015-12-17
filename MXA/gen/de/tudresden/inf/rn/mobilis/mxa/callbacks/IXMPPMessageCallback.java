/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MXA\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\callbacks\\IXMPPMessageCallback.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.callbacks;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
public interface IXMPPMessageCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IXMPPMessageCallback interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback))) {
return ((de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback.Stub.Proxy(obj);
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
case TRANSACTION_processMessage:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage _arg0;
if ((0!=data.readInt())) {
_arg0 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.processMessage(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback
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
     * Called when the service has a new data message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
public void processMessage(de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((message!=null)) {
_data.writeInt(1);
message.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_processMessage, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_processMessage = (IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Called when the service has a new data message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
public void processMessage(de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException;
}
