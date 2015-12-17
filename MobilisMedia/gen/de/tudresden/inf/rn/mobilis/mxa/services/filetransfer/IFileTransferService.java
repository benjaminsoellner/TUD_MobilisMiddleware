/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\filetransfer\\IFileTransferService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.filetransfer;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback;
public interface IFileTransferService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IFileTransferService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService.Stub.Proxy(obj);
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
case TRANSACTION_sendFile:
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
de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer _arg2;
if ((0!=data.readInt())) {
_arg2 = de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.sendFile(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_registerFileCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback.Stub.asInterface(data.readStrongBinder());
this.registerFileCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterFileCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterFileCallback(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService
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
     * Sends a file to an XMPP entity.
     */
public void sendFile(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
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
if ((file!=null)) {
_data.writeInt(1);
file.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Registers a callback for incoming file transfers.
     */
public void registerFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerFileCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Unregisters a previously registered callback for incoming file transfers.
     */
public void unregisterFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterFileCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_sendFile = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_registerFileCallback = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_unregisterFileCallback = (IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
     * Sends a file to an XMPP entity.
     */
public void sendFile(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException;
/**
     * Registers a callback for incoming file transfers.
     */
public void registerFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb) throws android.os.RemoteException;
/**
     * Unregisters a previously registered callback for incoming file transfers.
     */
public void unregisterFileCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IFileCallback cb) throws android.os.RemoteException;
}
