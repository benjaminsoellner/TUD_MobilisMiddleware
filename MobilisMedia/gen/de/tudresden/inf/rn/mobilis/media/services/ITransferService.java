/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\media\\services\\ITransferService.aidl
 */
package de.tudresden.inf.rn.mobilis.media.services;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel;
import de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel;
import de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer;
public interface ITransferService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.media.services.ITransferService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.media.services.ITransferService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an ITransferService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.media.services.ITransferService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.media.services.ITransferService))) {
return ((de.tudresden.inf.rn.mobilis.media.services.ITransferService)iin);
}
return new de.tudresden.inf.rn.mobilis.media.services.ITransferService.Stub.Proxy(obj);
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
case TRANSACTION_startTransferToJid:
{
data.enforceInterface(DESCRIPTOR);
de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer _arg0;
if ((0!=data.readInt())) {
_arg0 = de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _result = this.startTransferToJid(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_startTransferToRep:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel _arg1;
if ((0!=data.readInt())) {
_arg1 = de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer _arg2;
if ((0!=data.readInt())) {
_arg2 = de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _result = this.startTransferToRep(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_acceptTransferFromJid:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
boolean _result = this.acceptTransferFromJid(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_denyTransferFromJid:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
boolean _result = this.denyTransferFromJid(_arg0);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getIds:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int[] _result = this.getIds(_arg0);
reply.writeNoException();
reply.writeIntArray(_result);
return true;
}
case TRANSACTION_getTransferParcel:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel _result = this.getTransferParcel(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_registerMediaTransferMessenger:
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
this.registerMediaTransferMessenger(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterMediaTransferMessenger:
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
this.unregisterMediaTransferMessenger(_arg0, _arg1);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.media.services.ITransferService
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
public int startTransferToJid(de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((file!=null)) {
_data.writeInt(1);
file.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startTransferToJid, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public int startTransferToRep(java.lang.String repository, de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel item, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(repository);
if ((item!=null)) {
_data.writeInt(1);
item.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((file!=null)) {
_data.writeInt(1);
file.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_startTransferToRep, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public boolean acceptTransferFromJid(java.lang.String filename, int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(filename);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_acceptTransferFromJid, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public boolean denyTransferFromJid(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_denyTransferFromJid, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public int[] getIds(int direction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(direction);
mRemote.transact(Stub.TRANSACTION_getIds, _data, _reply, 0);
_reply.readException();
_result = _reply.createIntArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel getTransferParcel(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_getTransferParcel, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public void registerMediaTransferMessenger(android.os.Messenger messenger, int direction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((messenger!=null)) {
_data.writeInt(1);
messenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(direction);
mRemote.transact(Stub.TRANSACTION_registerMediaTransferMessenger, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void unregisterMediaTransferMessenger(android.os.Messenger messenger, int direction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((messenger!=null)) {
_data.writeInt(1);
messenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(direction);
mRemote.transact(Stub.TRANSACTION_unregisterMediaTransferMessenger, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_startTransferToJid = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_startTransferToRep = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_acceptTransferFromJid = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_denyTransferFromJid = (IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getIds = (IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getTransferParcel = (IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_registerMediaTransferMessenger = (IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_unregisterMediaTransferMessenger = (IBinder.FIRST_CALL_TRANSACTION + 7);
}
public int startTransferToJid(de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException;
public int startTransferToRep(java.lang.String repository, de.tudresden.inf.rn.mobilis.media.parcelables.RepositoryItemParcel item, de.tudresden.inf.rn.mobilis.mxa.services.parcelable.FileTransfer file) throws android.os.RemoteException;
public boolean acceptTransferFromJid(java.lang.String filename, int id) throws android.os.RemoteException;
public boolean denyTransferFromJid(int id) throws android.os.RemoteException;
public int[] getIds(int direction) throws android.os.RemoteException;
public de.tudresden.inf.rn.mobilis.media.parcelables.TransferParcel getTransferParcel(int id) throws android.os.RemoteException;
public void registerMediaTransferMessenger(android.os.Messenger messenger, int direction) throws android.os.RemoteException;
public void unregisterMediaTransferMessenger(android.os.Messenger messenger, int direction) throws android.os.RemoteException;
}
