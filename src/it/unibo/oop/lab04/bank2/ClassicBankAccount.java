package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {

    private static final double MANAGEMENT_FEE = 5;
	
	public ClassicBankAccount(int usrID, int balance) {
		super(usrID, balance);
	}


	protected double computeFee() {
		return ClassicBankAccount.MANAGEMENT_FEE;
	}


	protected boolean isWithDrawAllowed(final double amount) {
		return true;
	}

}
