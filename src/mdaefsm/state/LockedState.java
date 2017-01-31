package mdaefsm.state;

import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.OVERDRAWN;
import static constant.StateEnum.READY;
import static constant.StateEnum.S1;

/**
 * This class is used for representing Locked state
 */
public class LockedState extends State {

	public LockedState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void unlock() {
		model.changeState(S1);
	}

	@Override
	public void incorrectUnlock() {
		outputProcessor.displayIncorrectPin();
	}

	public void aboveMinBalance() {
		model.changeState(READY);
	}

	@Override
	public void belowMinBalance() {
		model.changeState(OVERDRAWN);
	}
}
