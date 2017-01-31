package mdaefsm.state;

import static constant.StateEnum.READY;
import static constant.StateEnum.START;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

/**
 * This class is used for representing Suspended state
 */
public class SuspendedState extends State {

	public SuspendedState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	public void activate() {
		model.changeState(READY);
	}

	public void close() {
		model.changeState(START);
	}

}
