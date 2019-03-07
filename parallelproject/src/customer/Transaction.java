package customer;

public class Transaction {

	private String mobile;
	private String type;
	private double amount, balance;
	
	
	public String getMobile() {
		return mobile;
	}
	public String getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	public double getBalance() {
		return balance;
	}
	public Transaction(String mobile, String type, double amount,
			double balance) {
		super();
		this.mobile = mobile;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [mobile=" + mobile + ", type=" + type
				+ ", amount=" + amount + ", balance=" + balance + "]";
	}
	
	
}
	
	