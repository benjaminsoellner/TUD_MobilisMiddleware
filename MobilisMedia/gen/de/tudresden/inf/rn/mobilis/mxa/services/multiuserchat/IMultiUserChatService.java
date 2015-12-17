/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\multiuserchat\\IMultiUserChatService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
public interface IMultiUserChatService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IMultiUserChatService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService.Stub.Proxy(obj);
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
case TRANSACTION_sendGroupMessage:
{
data.enforceInterface(DESCRIPTOR);
this.sendGroupMessage();
reply.writeNoException();
return true;
}
case TRANSACTION_getMembers:
{
data.enforceInterface(DESCRIPTOR);
this.getMembers();
reply.writeNoException();
return true;
}
case TRANSACTION_registerConnectionCallback:
{
data.enforceInterface(DESCRIPTOR);
this.registerConnectionCallback();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService
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
     * Sends a message to the whole group.
     */
public void sendGroupMessage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_sendGroupMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Gets all members of the provided group.
     */
public void getMembers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMembers, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Register a callback for invitations.
     */
public void registerConnectionCallback() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_registerConnectionCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_sendGroupMessage = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getMembers = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_registerConnectionCallback = (IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
     * Sends a message to the whole group.
     */
public void sendGroupMessage() throws android.os.RemoteException;
/**
     * Gets all members of the provided group.
     */
public void getMembers() throws android.os.RemoteException;
/**
     * Register a callback for invitations.
     */
public void registerConnectionCallback() throws android.os.RemoteException;
}
