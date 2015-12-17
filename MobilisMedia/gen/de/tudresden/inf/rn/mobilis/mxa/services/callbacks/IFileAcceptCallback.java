/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\callbacks\\IFileAcceptCallback.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.callbacks;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
public interface IFileAcceptCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IFileAcceptCallback interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback.Stub.Proxy(obj);
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
case TRANSACTION_acceptFile:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
int _arg4;
_arg4 = data.readInt();
this.acceptFile(_arg0, _arg1, _arg2, _arg3, _arg4);
return true;
}
case TRANSACTION_denyFileTransferRequest:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.denyFileTransferRequest(_arg0, _arg1, _arg2);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileAcceptCallback
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
public void acceptFile(android.os.Messenger acknowledgement, int requestCode, java.lang.String streamID, java.lang.String path, int blockSize) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((acknowledgement!=null)) {
_data.writeInt(1);
acknowledgement.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(requestCode);
_data.writeString(streamID);
_data.writeString(path);
_data.writeInt(blockSize);
mRemote.transact(Stub.TRANSACTION_acceptFile, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
public void denyFileTransferRequest(android.os.Messenger acknowledgement, int requestCode, java.lang.String streamID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((acknowledgement!=null)) {
_data.writeInt(1);
acknowledgement.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(requestCode);
_data.writeString(streamID);
mRemote.transact(Stub.TRANSACTION_denyFileTransferRequest, _data, null, IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_acceptFile = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_denyFileTransferRequest = (IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void acceptFile(android.os.Messenger acknowledgement, int requestCode, java.lang.String streamID, java.lang.String path, int blockSize) throws android.os.RemoteException;
public void denyFileTransferRequest(android.os.Messenger acknowledgement, int requestCode, java.lang.String streamID) throws android.os.RemoteException;
}
