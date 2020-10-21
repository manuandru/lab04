package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	
    private static final double ATM_TRANSACTION_FEE = 1;
	
	private final int usrID;
	private double balance;
    private int nTransactions;
    
    public AbstractBankAccount(final int usrID, final int balance) {
		this.usrID = usrID;
		this.balance = balance;
        this.nTransactions = 0;
	}
    
    private boolean checkUser(int usrID) {
		return this.usrID == usrID;
	}
    
    public void computeManagementFees(final int usrID) {
        final double feeAmount = this.computeFee();
        if (this.isWithDrawAllowed(feeAmount)) {
        	this.transactionOp(usrID, -feeAmount);
            this.resetTransactions();
        }
    }
    
    private void incTransactions() {
        this.nTransactions++;
	}
    
    private void resetTransactions() {
        this.nTransactions = 0;
	}
    
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

	
	public void deposit(final int usrID, final double amount) {
		this.transactionOp(usrID, amount);
	}

	
	public void depositFromATM(final int usrID, final double amount) {
		this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	

	public void withdraw(final int usrID, final double amount) {
		if (this.isWithDrawAllowed(amount)) {
            this.transactionOp(usrID, -amount);
        }
	}


	public void withdrawFromATM(final int usrID, final double amount) {
		this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	
	public double getBalance() {
		return this.balance;
	}
	
	
	public int getNTransactions() {
		return this.nTransactions;
	}

	
	
	protected abstract double computeFee();
	
	
	protected abstract boolean isWithDrawAllowed(final double amount);

}
