/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MXA\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\multiuserchat\\IMultiUserChatService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback;
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
java.lang.String _arg0;
_arg0 = data.readString();
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage _arg1;
if ((0!=data.readInt())) {
_arg1 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.sendGroupMessage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getMembers:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.getMembers(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerInvitationCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback.Stub.asInterface(data.readStrongBinder());
this.registerInvitationCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterInvitationCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterInvitationCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_changeNickname:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.changeNickname(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_declineInvitation:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.declineInvitation(_arg0, _arg1, _arg2);
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
public void sendGroupMessage(java.lang.String roomID, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(roomID);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
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
public void getMembers(java.lang.String roomID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(roomID);
mRemote.transact(Stub.TRANSACTION_getMembers, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Registers a callback for invitations.
     */
public void registerInvitationCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerInvitationCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Unregisters a previously registered invitation callback.
     */
public void unregisterInvitationCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterInvitationCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Changes the nickname within the room.
     */
public void changeNickname(java.lang.String roomID, java.lang.String nickname) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(roomID);
_data.writeString(nickname);
mRemote.transact(Stub.TRANSACTION_changeNickname, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Declines a previously received invitation.
     */
public void declineInvitation(java.lang.String roomID, java.lang.String inviter, java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(roomID);
_data.writeString(inviter);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_declineInvitation, _data, _reply, 0);
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
static final int TRANSACTION_registerInvitationCallback = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_unregisterInvitationCallback = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_changeNickname = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_declineInvitation = (IBinder.FIRST_CALL_TRANSACTION + 5);
}
/**
     * Sends a message to the whole group.
     */
public void sendGroupMessage(java.lang.String roomID, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage msg) throws android.os.RemoteException;
/**
     * Gets all members of the provided group.
     */
public void getMembers(java.lang.String roomID) throws android.os.RemoteException;
/**
     * Registers a callback for invitations.
     */
public void registerInvitationCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback cb) throws android.os.RemoteException;
/**
     * Unregisters a previously registered invitation callback.
     */
public void unregisterInvitationCallback(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.IInvitationCallback cb) throws android.os.RemoteException;
/**
     * Changes the nickname within the room.
     */
public void changeNickname(java.lang.String roomID, java.lang.String nickname) throws android.os.RemoteException;
/**
     * Declines a previously received invitation.
     */
public void declineInvitation(java.lang.String roomID, java.lang.String inviter, java.lang.String reason) throws android.os.RemoteException;
}
