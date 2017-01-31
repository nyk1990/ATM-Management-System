package mdaefsm.state;

import exception.AccountException;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.IDLE;
import static constant.StateEnum.LOCKED;
import static constant.StateEnum.S1;
import static constant.StateEnum.SUSPENDED;

/**
 * This class is used for representing Overdrawn State
 */
public class OverdrawnState extends State {

	public OverdrawnState(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void deposit() {
		outputProcessor.makeDeposit();
		model.changeState(S1);
	}

	@Override
	public void withdraw() {
		outputProcessor.displayBelowMinBalance();
		throw new AccountException("displayBelowMinBalance");
	}

	@Override
	public void balance() {
		outputProcessor.displayBalance();
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
	public void lock() {
		model.changeState(LOCKED);
	}

	@Override
	public void suspend() {
		model.changeState(SUSPENDED);
	}

}
