package mdaefsm.state;

import static constant.StateEnum.IDLE;
import static constant.StateEnum.LOCKED;
import static constant.StateEnum.OVERDRAWN;
import static constant.StateEnum.READY;
import static constant.StateEnum.SUSPENDED;
import static constant.StateEnum.S1;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;

/**
 * This class is used for representing Ready state
 */
public class ReadyState extends State {

	public ReadyState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void deposit() {
		outputProcessor.makeDeposit();
		model.changeState(S1);
	}

	@Override
	public void withdraw() {
		outputProcessor.makeWithdraw();
		model.changeState(S1);
	}

	@Override
	public void balance() {
		outputProcessor.displayBalance();
	}

	@Override
	public void lock() {
		model.changeState(LOCKED);
	}

	@Override
	public void suspend() {
		model.changeState(SUSPENDED);
	}

	@Override
	public void incorrectLock() {
		outputProcessor.displayIncorrectPin();
	}

	@Override
	public void logout() {
		model.changeState(IDLE);
	}

	@Override
	public void belowMinBalance() {
		model.changeState(OVERDRAWN);
	}

	@Override
	public void aboveMinBalance() {
		model.changeState(READY);
	}

}
