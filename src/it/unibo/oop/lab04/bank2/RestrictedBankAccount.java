package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;
	
	public RestrictedBankAccount(final int usrID, final int balance) {
		super(usrID, balance);
	}


	protected double computeFee() {
		return RestrictedBankAccount.MANAGEMENT_FEE + 
				(this.getNTransactions() * RestrictedBankAccount.TRANSACTION_FEE);
	}


	protected boolean isWithDrawAllowed(final double amount) {
		return this.getBalance() > amount;
	}

}
