package de.hdm.cefx.concurrency.operations;

/**
 * Bundles an operation with its type and if it is a part of a complex operation indicated by the
 * ComplexOperationStatus.
 * @author Dirk Hering
 */
public class OperationData {

	/**
	 * The executed operation.
	 */
	private Operation operation;
	
	/**
	 * Additional information on the operation type.
	 */
	private String operationType;
	
	/**
	 * Indicates whether this operation is a part of a complex operation.
	 */
	private ComplexOperationStatus complexOperationStatus;
	
	public OperationData(Operation operation) {
		this.operation = operation;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public String getOperationType() {
		return operationType;
	}
	
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	public ComplexOperationStatus getComplexOperationStatus() {
		return complexOperationStatus;
	}
	
	public void setComplexOperationStatus(
			ComplexOperationStatus complexOperationStatus) {
		this.complexOperationStatus = complexOperationStatus;
	}
}
