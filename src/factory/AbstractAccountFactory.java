package factory;

import data.AccountData;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.OutputProcessor;
import outputproc.action.*;

/**
 * This is an Abstract Factory class for different Account Components
 *
 */
public abstract class AbstractAccountFactory {

	public abstract AccountData createAccountData();

	public abstract InputProcessor createInputProcessor(AccountData data, MdaEfsm mdaefsm);

	public OutputProcessor createOutputProcessor(AccountData data) {
		final OutputProcessor op = new OutputProcessor();
		op.setBalance(createBalance(data));
		op.setBelowMinBalance(createBelowMinBalance(data));
		op.setDeposit(createDeposit(data));
		op.setBelowMinBalance(createBelowMinBalance(data));
		op.setEnterPin(createDisplayEnterPin(data));
		op.setIncorrectId(createIncorrectId(data));
		op.setIncorrectPin(createIncorrectPin(data));
		op.setMenu(createMenu(data));
		op.setPenalty(createPenalty(data));
		op.setStoreData(createStoreData(data));
		op.setTooManyAttempts(createTooManyAttempts(data));
		op.setWithdraw(createWithdraw(data));
		return op;
	}

	public abstract Balance createBalance(AccountData data);

	public abstract BelowMinBalance createBelowMinBalance(AccountData data);

	public abstract Deposit createDeposit(AccountData data);

	public abstract EnterPin createDisplayEnterPin(AccountData data);

	public abstract IncorrectId createIncorrectId(AccountData data);

	public abstract IncorrectPin createIncorrectPin(AccountData data);

	public abstract Menu createMenu(AccountData data);

	public abstract Penalty createPenalty(AccountData data);

	public abstract StoreData createStoreData(AccountData data);

	public abstract TooManyAttempts createTooManyAttempts(AccountData data);

	public abstract Withdraw createWithdraw(AccountData data);
}
