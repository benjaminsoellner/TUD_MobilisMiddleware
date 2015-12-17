package de.hdm.cefx.concurrency.operations;

import de.hdm.cefx.concurrency.operations.ComplexOperation;
import de.hdm.cefx.concurrency.operations.ComplexOperationHandler;
import de.hdm.cefx.concurrency.operations.Operation;
import de.hdm.cefx.concurrency.operations.OperationHandler;

public class CollabDrawingHandler extends ComplexOperationHandler {

	public CollabDrawingHandler(OperationHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOperation(ComplexOperation complexOp) {
		// TODO handle collaborative drawing complex operation
		
	}

	@Override
	public void handleOperation(Operation op) {
		// TODO check which type of complex operation it is ...
		
	}

}
