/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MXA\\src\\de\\tudresden\\inf\\rn\\mobilis\\mxa\\services\\pubsub\\IPubSubService.aidl
 */
package de.tudresden.inf.rn.mobilis.mxa.services.pubsub;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback;
public interface IPubSubService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IPubSubService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService))) {
return ((de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService)iin);
}
return new de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService.Stub.Proxy(obj);
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
case TRANSACTION_subscribe:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.subscribe(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_unsubscribe:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback _arg0;
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.unsubscribe(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.mxa.services.pubsub.IPubSubService
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
     * Subscribes to the given node on the given target. The callback will be
     * called as soon as a new event has been received.
     */
public void subscribe(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback callback, java.lang.String target, java.lang.String node) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeString(target);
_data.writeString(node);
mRemote.transact(Stub.TRANSACTION_subscribe, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Removes the subscription to the given node on the given target.
     */
public void unsubscribe(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback callback, java.lang.String target, java.lang.String node) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
_data.writeString(target);
_data.writeString(node);
mRemote.transact(Stub.TRANSACTION_unsubscribe, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_subscribe = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unsubscribe = (IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * Subscribes to the given node on the given target. The callback will be
     * called as soon as a new event has been received.
     */
public void subscribe(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback callback, java.lang.String target, java.lang.String node) throws android.os.RemoteException;
/**
     * Removes the subscription to the given node on the given target.
     */
public void unsubscribe(de.tudresden.inf.rn.mobilis.mxa.services.callbacks.ISubscribeCallback callback, java.lang.String target, java.lang.String node) throws android.os.RemoteException;
}
