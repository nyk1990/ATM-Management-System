package factory;

import data.Account2Data;
import data.AccountData;
import inputproc.impl.Account2InputProcessor;
import inputproc.InputProcessor;
import mdaefsm.MdaEfsm;
import outputproc.action.impl.*;
import outputproc.action.Balance;
import outputproc.action.BelowMinBalance;
import outputproc.action.Deposit;
import outputproc.action.EnterPin;
import outputproc.action.IncorrectId;
import outputproc.action.IncorrectPin;
import outputproc.action.Menu;
import outputproc.action.Penalty;
import outputproc.action.StoreData;
import outputproc.action.TooManyAttempts;
import outputproc.action.Withdraw;

/**
 * This is a Abstract Factory class for Account 2 Component
 */
public class Account2Factory extends AbstractAccountFactory {

	public AccountData createAccountData() {
		return new Account2Data();
	}

	public InputProcessor createInputProcessor(AccountData data, MdaEfsm mdaefsm) {
		return new Account2InputProcessor((Account2Data) data, mdaefsm);
	}

	public Balance createBalance(AccountData data) {
		return new Balance2((Account2Data) data);
	}

	public BelowMinBalance createBelowMinBalance(AccountData data) {
		return new BelowMinBalance2((Account2Data) data);
	}

	public Deposit createDeposit(AccountData data) {
		return new Deposit2((Account2Data) data);
	}

	public EnterPin createDisplayEnterPin(AccountData data) {
		return new EnterPin2((Account2Data) data);
	}

	public IncorrectId createIncorrectId(AccountData data) {
		return new IncorrectId2((Account2Data) data);
	}

	public IncorrectPin createIncorrectPin(AccountData data) {
		return new IncorrectPin2((Account2Data) data);
	}

	public Menu createMenu(AccountData data) {
		return new Menu2((Account2Data) data);
	}

	public Penalty createPenalty(AccountData data) {
		return new Penalty2((Account2Data) data);
	}

	public StoreData createStoreData(AccountData data) {
		return new StoreData2((Account2Data) data);
	}

	public TooManyAttempts createTooManyAttempts(AccountData data) {
		return new TooManyAttempts2((Account2Data) data);
	}

	public Withdraw createWithdraw(AccountData data) {
		return new Withdraw2((Account2Data) data);
	}

}
