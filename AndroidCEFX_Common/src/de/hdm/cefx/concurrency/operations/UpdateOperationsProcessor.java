/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency.operations;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class UpdateOperationsProcessor {

	private static String executeOP(UpdateOperations op, String text) {
		int pos;

		switch (op.getOperation()) {
			case UpdateOperations.INSERT:
				UpdateInsertOperation iop=(UpdateInsertOperation) op;
				pos=iop.getTextPos();
				text=text.substring(0, pos)+iop.getText()+text.substring(pos, text.length());
					break;
			case UpdateOperations.DELETE:
				UpdateDeleteOperation dop=(UpdateDeleteOperation) op;
				pos=dop.getTextPos();
				text=text.substring(0,pos)+text.substring(pos+dop.getLength(), text.length());
					break;
			case UpdateOperations.SET:
				text=((UpdateSetOperation)op).getText();
				break;
			}
		return text;
	}

	private static UpdateInsertOperation transformOP(UpdateInsertOperation first, UpdateInsertOperation second) {
		if (second.getTextPos()>first.getTextPos()) {
			second.setTextPos(second.getTextPos()+first.getText().length());
		}
		return second;
	}

	private static UpdateInsertOperation transformOP(UpdateDeleteOperation first, UpdateInsertOperation second) {
		if (second.getTextPos()<=first.getTextPos()) { //Einfügeoperations links von Löschoperation => keine Änderung
			return second;
		}
		if (second.getTextPos()>first.getTextPos()+first.getLength()) { //Einfügeoperation rechts von Löschoperation und nicht innerhalb des Löschbereiches => nacht links verschieben
			second.setTextPos(second.getTextPos()-first.getLength());
		} else { //Einfügeoperation innerhalb des Löschbereiches => Einfügeposition auf Anfang der Löschoperation setzen
			second.setTextPos(first.getTextPos());
		}
		return second;
	}

	private static UpdateDeleteOperation transformOP(UpdateDeleteOperation first, UpdateDeleteOperation second) {
		if ((first.getLength()==0) || (second.getLength()==0)) {
			return second;
		}
		if (first.getTextPos()>second.getTextPos()+second.getLength()) {
			return second;
		}
		if (second.getTextPos()>first.getTextPos()+first.getLength()) { //keine Überschneidung
			second.setTextPos(second.getTextPos()-first.getLength());
		} else {
			if (second.getTextPos()>=first.getTextPos()) { //2. Löschoperation rechts oder auf gleicher Position wie 1. - Überschneidung
				int endpos=second.getTextPos()+second.getLength();
				second.setLength(endpos-(first.getTextPos()+first.getLength()));
				second.setTextPos(first.getTextPos());
			} else { //2. Löschoperation ist links von 1. - Überschneidung
				int endpos=second.getTextPos()+second.getLength();
				second.setLength(second.getLength()-(endpos-first.getTextPos()));
			}
		}


		return second;
	}

	public static boolean isTransformationNeeded(StateVector first, StateVector second) {
		Set<Integer> keys=first.keySet();

		for (Iterator<Integer> it=keys.iterator(); it.hasNext();) {
			Integer key=it.next();
			if (!second.containsKey(key)) {
				return true;
			}
			if (first.getState(key)>second.getState(key)) {
				return true;
			}
		}

		return false;
	}

	private static UpdateOperations transformOP(UpdateOperations first, UpdateOperations second) {
		if (second.getOperation()==UpdateOperations.SET) {
			return second;
		}
		if (first.getOperation()==UpdateOperations.INSERT) {
			if (second.getOperation()==UpdateOperations.INSERT) {
				second=transformOP((UpdateInsertOperation)first, (UpdateInsertOperation)second);
			}
			if (second.getOperation()==UpdateOperations.DELETE) {
			}
		}
		if (first.getOperation()==UpdateOperations.DELETE) {
			if (second.getOperation()==UpdateOperations.INSERT) {
				second=transformOP((UpdateDeleteOperation)first, (UpdateInsertOperation)second);
			}
			if (second.getOperation()==UpdateOperations.DELETE) {
				second=transformOP((UpdateDeleteOperation)first, (UpdateDeleteOperation)second);
			}
		}
		return second;
	}

	public static String process(Vector<UpdateOperations> ops,final UpdateOperationImpl op,String text) {

		UpdateOperations dis=op.getDISOperation();
		if (ops!=null) {
			int ii;
			for (ii=0; ii<ops.size(); ii++) {
				if (isTransformationNeeded(ops.elementAt(ii).getParent().getStateVector(),op.getStateVector())) {
					dis=transformOP(ops.elementAt(ii),dis);
				}
			}
			ops.add(dis); //transformierte Operation anhängen
		}
		text=executeOP(dis,text);

		return text;
	}
}
