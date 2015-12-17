/**
 * This sourcecode is part of the Collaborative Editing Framework for XML (CEFX).
 * @author Michael Voigt
 */
package de.hdm.cefx.concurrency.operations;

import java.util.Comparator;

public class OperationIDComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		OperationID o1=((Operation)arg0).getOperationID();
		OperationID o2=((Operation)arg1).getOperationID();
		StateVector s1=((Operation)arg0).getStateVector();
		StateVector s2=((Operation)arg1).getStateVector();

		boolean b1=UpdateOperationsProcessor.isTransformationNeeded(s1, s2);
		boolean b2=UpdateOperationsProcessor.isTransformationNeeded(s2, s1);
		if ((b1==true) && (b2==false)) {
			return 1;
		}
		if ((b1==false) && (b2==true)) {
			return -1;
		}

		int tmp;
		tmp=o1.getOperationPriority()-o2.getOperationPriority();
		if (tmp!=0) {
			return tmp;
		}
		if (o1.getOp().getType()==Operation.UPDATE) {
			tmp=o1.getUpdateOperationPriority()-o2.getUpdateOperationPriority();
			if (tmp!=0) {
				return tmp;
			}
		} else if (o1.getOp().getType()==Operation.DELETE) {
			tmp=o2.getDOMLevel()-o1.getDOMLevel();
			if (tmp!=0) {
				return tmp;
			}
		}
		tmp=o1.getSVSum()-o2.getSVSum();
		if (tmp!=0) {
			return tmp;
		}
		return o1.getClientID()-o2.getClientID();
	}

}
