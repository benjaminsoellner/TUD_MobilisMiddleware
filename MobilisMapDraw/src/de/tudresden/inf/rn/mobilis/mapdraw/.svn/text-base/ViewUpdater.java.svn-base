package de.tudresden.inf.rn.mobilis.mapdraw;

import de.hdm.cefx.awareness.AwarenessController;
import de.hdm.cefx.awareness.AwarenessEvent;
import de.hdm.cefx.awareness.AwarenessWidget;
import de.hdm.cefx.concurrency.operations.Operation;
import de.hdm.cefx.concurrency.operations.OperationData;

public abstract class ViewUpdater implements AwarenessWidget {

	protected Operation operation;
	private AwarenessController ac;

	@Override
	public boolean hasInterestIn(AwarenessEvent event) {
		Object eventData = event.getEvent();
		if (eventData instanceof OperationData) {
			operation = ((OperationData) eventData).getOperation();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void init() {
		// possible to add / override code for initialization of this awareness widget ...
	}

	@Override
	public void setAwarenessController(AwarenessController ac) {
		this.ac = ac;
	}

	@Override
	public abstract void notifyOfAwarenessEvent(AwarenessEvent event);
}
