package de.hdm.cefx.concurrency.operations;

import java.io.Serializable;

public class OperationID implements Serializable {

	private int       SVSum; //StateVectorSum
	private int       DOMLevel;
	private Operation op;

	public OperationID(Operation o) {
		op=o;
		SVSum=o.getStateVector().getSumOfStates();
		DOMLevel=0;
	}

	public int getSVSum() {
		return SVSum;
	}

	public void setSVSum(int sum) {
		SVSum = sum;
	}

	public int getDOMLevel() {
		return DOMLevel;
	}

	public void setDOMLevel(int level) {
		DOMLevel = level;
	}

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}

	public int getClientID() {
		return op.getClientId();
	}

	public int getOperationPriority() {
		int val=0;
		switch (op.getType()) {
			case Operation.UPDATE:
				val=1;
				break;
			case Operation.INSERT:
				val=2;
				break;
			case Operation.DELETE:
				val=3;
				break;
		}
		return val;
	}

	public int getUpdateOperationPriority() {
		if (op.getType()==Operation.UPDATE) {
			UpdateOperationImpl uo=(UpdateOperationImpl)op;
			return uo.getDISOperation().getOperation();
		}
		return 0;
	}
}
