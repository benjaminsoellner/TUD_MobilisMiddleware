/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\servicediscovery\\IServiceDiscoveryService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
public interface IServiceDiscoveryService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IServiceDiscoveryService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService.Stub.Proxy(obj);
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
case TRANSACTION_discoverItem:
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
java.lang.String _arg3;
_arg3 = data.readString();
java.lang.String _arg4;
_arg4 = data.readString();
this.discoverItem(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.servicediscovery.IServiceDiscoveryService
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
	 *
	 */
public void discoverItem(android.os.Messenger acknowledgement, android.os.Messenger result, int requestCode, java.lang.String jid, java.lang.String node) throws android.os.RemoteException
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
_data.writeString(jid);
_data.writeString(node);
mRemote.transact(Stub.TRANSACTION_discoverItem, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_discoverItem = (IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
	 *
	 */
public void discoverItem(android.os.Messenger acknowledgement, android.os.Messenger result, int requestCode, java.lang.String jid, java.lang.String node) throws android.os.RemoteException;
}
