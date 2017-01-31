package mdaefsm.state;

import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.IDLE;
import static constant.StateEnum.READY;

/**
 * This class is used for representing Check Pin state
 */
public class CheckPinState extends State {

	public CheckPinState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void correctPin() {
		// Go to next step
		outputProcessor.displayMenu();

		// change state
		model.changeState(READY);
	}

	@Override
	public void incorrectPin(int max) {
		int attempts = model.getNumOfAttempts();
		if (attempts < max) {
			model.incrementNumOfAttempts();
			outputProcessor.displayIncorrectPin();
		} else if (attempts == max) {
			model.incrementNumOfAttempts();
			outputProcessor.displayTooManyAttempts();
			model.changeState(IDLE);
		}
	}

	@Override
	public void logout() {
		model.changeState(IDLE);
	}
}
