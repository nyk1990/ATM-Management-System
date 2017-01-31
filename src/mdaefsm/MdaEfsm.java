package mdaefsm;

import static constant.StateEnum.CHECK_PIN;
import static constant.StateEnum.IDLE;
import static constant.StateEnum.LOCKED;
import static constant.StateEnum.OVERDRAWN;
import static constant.StateEnum.READY;
import static constant.StateEnum.S1;
import static constant.StateEnum.START;
import static constant.StateEnum.SUSPENDED;

import constant.StateEnum;
import mdaefsm.state.CheckPinState;
import mdaefsm.state.IdleState;
import mdaefsm.state.LockedState;
import mdaefsm.state.OverdrawnState;
import mdaefsm.state.ReadyState;
import mdaefsm.state.S1State;
import mdaefsm.state.StartState;
import mdaefsm.state.State;
import mdaefsm.state.SuspendedState;
import outputproc.OutputProcessor;

/**
 * This class is used for implementing the MDA-EFSM platform independent class.
 */
public class MdaEfsm {

	/* Contains the states of MDA-EFSM */
	private State states[];

	/* Current state of the system */
	private State currentState;

	private OutputProcessor outputProcessor;

	private int numOfAttempts;

	public MdaEfsm(OutputProcessor op) {
		outputProcessor = op;
		initializeStates();
	}

	/**
	 * Initializes the states of MDA-EFSM
	 */
	public void initializeStates() {
		states = new State[StateEnum.getTotalStates()];
		states[START.getId()] = new StartState(this, outputProcessor);
		states[IDLE.getId()] = new IdleState(this, outputProcessor);
		states[CHECK_PIN.getId()] = new CheckPinState(this, outputProcessor);
		states[READY.getId()] = new ReadyState(this, outputProcessor);
		states[S1.getId()] = new S1State(this, outputProcessor);
		states[LOCKED.getId()] = new LockedState(this, outputProcessor);
		states[OVERDRAWN.getId()] = new OverdrawnState(this, outputProcessor);
		states[SUSPENDED.getId()] = new SuspendedState(this, outputProcessor);
		changeState(START);
	}

	public void changeState(StateEnum stateEnum) {
		if (stateEnum != null) {
			currentState = states[stateEnum.getId()];
		}
	}

	public int getNumOfAttempts() {
		return numOfAttempts;
	}

	public void resetNumOfAttempts() {
		this.numOfAttempts = 0;
	}

	public void incrementNumOfAttempts() {
		this.numOfAttempts++;
	}

	public void open() {
		currentState.open();
	}

	public void login() {
		currentState.correctLogin();
	}

	public void invalidLogin() {
		currentState.invalidLogin();
	}

	public void correctPin() {
		currentState.correctPin();
	}

	public void incorrectPin(int max) {
		currentState.incorrectPin(max);
	}

	public void aboveMinBalance() {
		currentState.aboveMinBalance();
	}

	public void belowMinBalance() {
		currentState.belowMinBalance();
	}

	public void belowMinBalanceWithPenalty() {
		currentState.belowMinBalanceWithPenalty();
	}

	public void deposit() {
		currentState.deposit();
	}

	public void withdraw() {
		currentState.withdraw();
	}

	public void balance() {
		currentState.balance();
	}

	public void lock() {
		currentState.lock();
	}

	public void incorrectLock() {
		currentState.incorrectLock();
	}

	public void unlock() {
		currentState.unlock();
	}

	public void incorrectUnlock() {
		currentState.incorrectUnlock();
	}

	public void suspend() {
		currentState.suspend();
	}

	public void activate() {
		currentState.activate();
	}

	public void close() {
		currentState.close();
	}

	public void logout() {
		currentState.logout();
	}

	public State getCurrentState() {
		return currentState;
	}

	public OutputProcessor getOutputProcessor() {
		return outputProcessor;
	}
}
