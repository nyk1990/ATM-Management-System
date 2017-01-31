package mdaefsm.state;

import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import static constant.StateEnum.IDLE;
import static constant.StateEnum.LOCKED;
import static constant.StateEnum.OVERDRAWN;
import static constant.StateEnum.READY;

/**
 * This class is used for representing intermediate state called S1
 */
public class S1State extends State {

	public S1State(MdaEfsm model, OutputProcessor outputProcessor) {
		super(model, outputProcessor);
	}

	@Override
	public void aboveMinBalance() {
		model.changeState(READY);
	}

	@Override
	public void belowMinBalance() {
		model.changeState(OVERDRAWN);
	}

	@Override
	public void belowMinBalanceWithPenalty() {
		outputProcessor.chargePenalty();
		model.changeState(OVERDRAWN);
	}

	@Override
	public void balance() {
		outputProcessor.displayBalance();
	}

	@Override
	public void logout() {
		model.changeState(IDLE);
	}

	public void lock() {
		model.changeState(LOCKED);
	}

}
