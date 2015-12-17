package de.hdm.cefx.concurrency.operations;

import de.hdm.cefx.concurrency.operations.ComplexOperation;
import de.hdm.cefx.concurrency.operations.OperationHandler;

// currently not used!

public abstract class ComplexOperationHandler implements OperationHandler {

	protected OperationHandler nextHandler;
	
	public ComplexOperationHandler(OperationHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public abstract void handleOperation(ComplexOperation complexOp);
}
