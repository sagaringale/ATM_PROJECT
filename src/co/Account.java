package co;

public class Account {
	private int accountNumber;
	private int accountPin;
	private int currentAmount = 54;
	private String accounttype;

	public Account() {
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountPin() {
		return accountPin;
	}

	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountPin=" + accountPin + ", currentAmount="
				+ currentAmount + ", accounttype=" + accounttype + "]";
	}
}
