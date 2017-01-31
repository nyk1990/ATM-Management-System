package mdaefsm.state;

import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.CHECK_PIN;

/**
 * This class is used for representing Idle state
 */
public class IdleState extends State {

	public IdleState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void correctLogin() {
		model.resetNumOfAttempts();

		// Go to next step
		outputProcessor.displayEnterPin();

		// change state
		model.changeState(CHECK_PIN);
	}

	@Override
	public void invalidLogin() {
		outputProcessor.displayIncorrectId();
	}
}
