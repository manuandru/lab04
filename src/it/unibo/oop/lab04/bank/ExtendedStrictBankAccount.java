package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

	private static final double TRANSACTION_FEE = 0.1;
	
	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}

	public void computeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + (this.getNTransactions() * ExtendedStrictBankAccount.TRANSACTION_FEE);
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            this.setBalance(this.getBalance() - feeAmount); 
            this.resetTransactions();
        }
    }
	
	public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
        	//Better super.withdraw
            this.transactionOp(usrID, -amount);
        }
    }

	//Useless
    public void withdrawFromATM(final int usrID, final double amount) {
        this.withdraw(usrID, amount + ExtendedStrictBankAccount.ATM_TRANSACTION_FEE);
    }
    
    //I could use the super.transactionOp, according to the solutions
    private void transactionOp(final int usrID, final double amount) {
        if (checkUser(usrID)) {
        	this.setBalance(this.getBalance() + amount); 
            this.incTransactions();
        }
    }
	
	
	private boolean isWithdrawAllowed(final double amount) {
        return getBalance() > amount;
    }
}
