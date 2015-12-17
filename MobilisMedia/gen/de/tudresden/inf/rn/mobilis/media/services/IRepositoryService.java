/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: P:\\Eigene Dateien\\(S) Studien\\[SH2] Hauptstudium 2\\Groﬂer Beleg\\Repository Public\\trunk\\MobilisMedia\\src\\de\\tudresden\\inf\\rn\\mobilis\\media\\services\\IRepositoryService.aidl
 */
package de.tudresden.inf.rn.mobilis.media.services;
import java.lang.String;
import android.os.RemoteException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Binder;
import android.os.Parcel;
import android.os.Messenger;
import de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel;
public interface IRepositoryService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements de.tudresden.inf.rn.mobilis.media.services.IRepositoryService
{
private static final java.lang.String DESCRIPTOR = "de.tudresden.inf.rn.mobilis.media.services.IRepositoryService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an IRepositoryService interface,
 * generating a proxy if needed.
 */
public static de.tudresden.inf.rn.mobilis.media.services.IRepositoryService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof de.tudresden.inf.rn.mobilis.media.services.IRepositoryService))) {
return ((de.tudresden.inf.rn.mobilis.media.services.IRepositoryService)iin);
}
return new de.tudresden.inf.rn.mobilis.media.services.IRepositoryService.Stub.Proxy(obj);
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
case TRANSACTION_query:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel _arg1;
if ((0!=data.readInt())) {
_arg1 = de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
android.os.Messenger _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
this.query(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_delete:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String[] _arg1;
_arg1 = data.createStringArray();
android.os.Messenger _arg2;
if ((0!=data.readInt())) {
_arg2 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
int _arg3;
_arg3 = data.readInt();
this.delete(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_discover:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
android.os.Messenger _arg1;
if ((0!=data.readInt())) {
_arg1 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
int _arg2;
_arg2 = data.readInt();
this.discover(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_transfer:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
android.os.Messenger _arg3;
if ((0!=data.readInt())) {
_arg3 = android.os.Messenger.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
int _arg4;
_arg4 = data.readInt();
this.transfer(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements de.tudresden.inf.rn.mobilis.media.services.IRepositoryService
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
public void query(java.lang.String repository, de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel condition, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(repository);
if ((condition!=null)) {
_data.writeInt(1);
condition.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((resultMessenger!=null)) {
_data.writeInt(1);
resultMessenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(resultCode);
mRemote.transact(Stub.TRANSACTION_query, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void delete(java.lang.String repository, java.lang.String[] uids, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(repository);
_data.writeStringArray(uids);
if ((resultMessenger!=null)) {
_data.writeInt(1);
resultMessenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(resultCode);
mRemote.transact(Stub.TRANSACTION_delete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void discover(java.lang.String serverJid, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(serverJid);
if ((resultMessenger!=null)) {
_data.writeInt(1);
resultMessenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(resultCode);
mRemote.transact(Stub.TRANSACTION_discover, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void transfer(java.lang.String repository, java.lang.String content, java.lang.String uid, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(repository);
_data.writeString(content);
_data.writeString(uid);
if ((resultMessenger!=null)) {
_data.writeInt(1);
resultMessenger.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(resultCode);
mRemote.transact(Stub.TRANSACTION_transfer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_query = (IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_delete = (IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_discover = (IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_transfer = (IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void query(java.lang.String repository, de.tudresden.inf.rn.mobilis.media.parcelables.ConditionParcel condition, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException;
public void delete(java.lang.String repository, java.lang.String[] uids, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException;
public void discover(java.lang.String serverJid, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException;
public void transfer(java.lang.String repository, java.lang.String content, java.lang.String uid, android.os.Messenger resultMessenger, int resultCode) throws android.os.RemoteException;
}
