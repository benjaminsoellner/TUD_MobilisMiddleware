/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MXA\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\IXMPPService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ;
import de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback;
import de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback;
import de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService;
import de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService;
import de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService;
import de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService;
public interface IXMPPService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.IXMPPService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.IXMPPService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IXMPPService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.IXMPPService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.IXMPPService))) {
return ((de.tudresden.inf.rn.mobilis.mxa.IXMPPService)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.IXMPPService.Stub.Proxy(obj);
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
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.connect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.disconnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isConnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isConnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getUsername:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getUsername();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_sendMessage:
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
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage _arg2;
if ((0!=data.readInt())) {
_arg2 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.sendMessage(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_sendIQ:
{
data.enforceInterface(DESCRIPTOR);
android.os.Messenger _arg0;
if ((0!=data.readInt())) {
_arg0 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
android.os.Messenger _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ _arg3;
if ((0!=data.readInt())) {
_arg3 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.sendIQ(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_sendPresence:
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
de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence _arg2;
if ((0!=data.readInt())) {
_arg2 = de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
this.sendPresence(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_registerConnectionCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback.Stub.asInterface(data.readStrongBinder());
this.registerConnectionCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterConnectionCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterConnectionCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_registerDataMessageCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.registerDataMessageCallback(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterDataMessageCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.unregisterDataMessageCallback(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_registerIQCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.registerIQCallback(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterIQCallback:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.unregisterIQCallback(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getServiceDiscoveryService:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService _result = this.getServiceDiscoveryService();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getFileTransferService:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService _result = this.getFileTransferService();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getMultiUserChatService:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService _result = this.getMultiUserChatService();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getPubSubService:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService _result = this.getPubSubService();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.IXMPPService
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
     * Connect to the XMPP server.
     */
public void connect(android.os.Messenger acknowledgement) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Only disconnects if all binders have been removed.
	 */
public void disconnect(android.os.Messenger acknowledgement) throws android.os.RemoteException
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
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
	 * Returns whether the service is connected or not.
	 */
public boolean isConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isConnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * Returns the JID of the logged in XMPP user.
	 */
public java.lang.String getUsername() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getUsername, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * param requestCode: Reply request code. < 0 if reply is not requested.
	 */
public void sendMessage(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException
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
if ((message!=null)) {
_data.writeInt(1);
message.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     *
     */
public void sendIQ(android.os.Messenger acknowledgement, android.os.Messenger result, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ iq) throws android.os.RemoteException
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
if ((result!=null)) {
_data.writeInt(1);
result.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(requestCode);
if ((iq!=null)) {
_data.writeInt(1);
iq.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendIQ, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Sends a Presence stanza to the XMPP server including Presence mode (e.g. 'online' or 'do not
     * disturb' and status (e.g. 'on the beach').
     */
public void sendPresence(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence presence) throws android.os.RemoteException
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
if ((presence!=null)) {
_data.writeInt(1);
presence.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendPresence, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Registers a callback interface with the service that will be notified
     * upon connection changes.
     */
public void registerConnectionCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerConnectionCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Remove a previously registered connection callback interface.
     */
public void unregisterConnectionCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterConnectionCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Registers a callback interface with the service that will be notified
     * upon new data messages (i.e. those who have an mxa-ident packet extension).
     */
public void registerDataMessageCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback cb, java.lang.String namespace, java.lang.String token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(namespace);
_data.writeString(token);
mRemote.transact(Stub.TRANSACTION_registerDataMessageCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Removes a previously registered data message callback interface.
     */
public void unregisterDataMessageCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback cb, java.lang.String namespace, java.lang.String token) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(namespace);
_data.writeString(token);
mRemote.transact(Stub.TRANSACTION_unregisterDataMessageCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Registers a callback interface with the service that will be notified
     * upon new IQ messages.
     *
     * @param namespace: The namespace for filtering incoming IQ.
     * @param token: The token for filtering incoming IQ.
     */
public void registerIQCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback cb, java.lang.String elementName, java.lang.String namespace) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(elementName);
_data.writeString(namespace);
mRemote.transact(Stub.TRANSACTION_registerIQCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Removes a previously registered IQ callback interface.
     */
public void unregisterIQCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback cb, java.lang.String elementName, java.lang.String namespace) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(elementName);
_data.writeString(namespace);
mRemote.transact(Stub.TRANSACTION_unregisterIQCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// ==========================================================
// Additional Services
// ==========================================================
/**
    * A service used for XMPP Service Discovery.
    */
public de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService getServiceDiscoveryService() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getServiceDiscoveryService, _data, _reply, 0);
_reply.readException();
_result = de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * A basic File-Transfer service based on XMPP.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService getFileTransferService() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getFileTransferService, _data, _reply, 0);
_reply.readException();
_result = de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * The MultiUserChat service conforms to XEP-0045.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService getMultiUserChatService() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMultiUserChatService, _data, _reply, 0);
_reply.readException();
_result = de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * A basic publish-subscribe service for general purposes.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService getPubSubService() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPubSubService, _data, _reply, 0);
_reply.readException();
_result = de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_connect = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_disconnect = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_isConnected = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getUsername = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_sendMessage = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_sendIQ = (IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_sendPresence = (IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_registerConnectionCallback = (IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_unregisterConnectionCallback = (IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_registerDataMessageCallback = (IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_unregisterDataMessageCallback = (IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_registerIQCallback = (IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_unregisterIQCallback = (IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_getServiceDiscoveryService = (IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_getFileTransferService = (IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getMultiUserChatService = (IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_getPubSubService = (IBinder.FIRST_CALL_TRANSACTION + 16);
}
/**
     * Connect to the XMPP server.
     */
public void connect(android.os.Messenger acknowledgement) throws android.os.RemoteException;
/**
	 * Only disconnects if all binders have been removed.
	 */
public void disconnect(android.os.Messenger acknowledgement) throws android.os.RemoteException;
/**
	 * Returns whether the service is connected or not.
	 */
public boolean isConnected() throws android.os.RemoteException;
/**
	 * Returns the JID of the logged in XMPP user.
	 */
public java.lang.String getUsername() throws android.os.RemoteException;
/**
	 * param requestCode: Reply request code. < 0 if reply is not requested.
	 */
public void sendMessage(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPMessage message) throws android.os.RemoteException;
/**
     *
     */
public void sendIQ(android.os.Messenger acknowledgement, android.os.Messenger result, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPIQ iq) throws android.os.RemoteException;
/**
     * Sends a Presence stanza to the XMPP server including Presence mode (e.g. 'online' or 'do not
     * disturb' and status (e.g. 'on the beach').
     */
public void sendPresence(android.os.Messenger acknowledgement, int requestCode, de.tudresden.inf.rn.mobilis.mxa.parcelable.XMPPPresence presence) throws android.os.RemoteException;
/**
     * Registers a callback interface with the service that will be notified
     * upon connection changes.
     */
public void registerConnectionCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback cb) throws android.os.RemoteException;
/**
     * Remove a previously registered connection callback interface.
     */
public void unregisterConnectionCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IConnectionCallback cb) throws android.os.RemoteException;
/**
     * Registers a callback interface with the service that will be notified
     * upon new data messages (i.e. those who have an mxa-ident packet extension).
     */
public void registerDataMessageCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback cb, java.lang.String namespace, java.lang.String token) throws android.os.RemoteException;
/**
     * Removes a previously registered data message callback interface.
     */
public void unregisterDataMessageCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPMessageCallback cb, java.lang.String namespace, java.lang.String token) throws android.os.RemoteException;
/**
     * Registers a callback interface with the service that will be notified
     * upon new IQ messages.
     *
     * @param namespace: The namespace for filtering incoming IQ.
     * @param token: The token for filtering incoming IQ.
     */
public void registerIQCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback cb, java.lang.String elementName, java.lang.String namespace) throws android.os.RemoteException;
/**
     * Removes a previously registered IQ callback interface.
     */
public void unregisterIQCallback(de.tudresden.inf.rn.mobilis.mxa.callbacks.IXMPPIQCallback cb, java.lang.String elementName, java.lang.String namespace) throws android.os.RemoteException;
// ==========================================================
// Additional Services
// ==========================================================
/**
    * A service used for XMPP Service Discovery.
    */
public de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService getServiceDiscoveryService() throws android.os.RemoteException;
/**
	 * A basic File-Transfer service based on XMPP.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.filetransfer.IFileTransferService getFileTransferService() throws android.os.RemoteException;
/**
	 * The MultiUserChat service conforms to XEP-0045.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.multiuserchat.IMultiUserChatService getMultiUserChatService() throws android.os.RemoteException;
/**
	 * A basic publish-subscribe service for general purposes.
	 */
public de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService getPubSubService() throws android.os.RemoteException;
}
