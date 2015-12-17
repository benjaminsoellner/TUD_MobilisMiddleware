/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\callbacks\\IFileCallback.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.callbacks;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer;
public interface IFileCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IFileCallback interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback.Stub.Proxy(obj);
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
case TRANSACTION_processFile:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback.Stub.asInterface(data.readStrongBinder());
de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer _arg1;
if ((0!=data.readInt())) {
_arg1 = de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
java.lang.String _arg2;
_arg2 = data.readString();
this.processFile(_arg0, _arg1, _arg2);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback
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
     * Called when the service has a new message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
public void processFile(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback acceptCallback, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file, java.lang.String streamID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((acceptCallback!=null))?(acceptCallback.asBinder()):(null)));
if ((file!=null)) {
_data.writeInt(1);
file.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(streamID);
mRemote.transact(Stub.TRANSACTION_processFile, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_processFile = (IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Called when the service has a new message.
     * Will be called by the RemoteService in a synchronous (!) way.
     */
public void processFile(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback acceptCallback, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file, java.lang.String streamID) throws android.os.RemoteException;
}
