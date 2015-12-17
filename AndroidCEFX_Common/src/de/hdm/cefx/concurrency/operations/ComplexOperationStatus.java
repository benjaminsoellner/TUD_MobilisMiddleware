package de.hdm.cefx.concurrency.operations;

public enum ComplexOperationStatus {

	/**
	 * This Operation is an atomic operation (UPDATE, INSERT or DELETE) and not a ComplexOperation.
	 */
	ATOMIC, 
	
	/**
	 * This is an ComplexOperation, consisting of only one single atomic operation.
	 * In other words, this only lets a client distinguish from several atomic operations more easily
	 * (e.g. inserting an application-specific node)
	 */
	COMPLEX_SINGLE, 
	
	/**
	 * This Operation is the first one in a series of atomic operations constituting a ComplexOperation.
	 */
	COMPLEX_BEGIN, 
	
	/**
	 * This Operation is in a series of atomic operations constituting a ComplexOperation and its not the first or last one.
	 */
	COMPLEX_INSIDE, 
	
	/**
	 * This Operation is the last one in a series of atomic operations constituting a ComplexOperation.
	 */
	COMPLEX_END
	
}
