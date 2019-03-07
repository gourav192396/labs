package service;

import customer.Customer;
import customer.Loan;

public interface ILoanService {

	String userNamePattern="[a-zA-Z]{2,30}";
//	String emailPattern= "/\\S+@\\S+\\.\\S+/";
	String emailPattern= "[a-zA-Z @. 0-9]{3,10}";
	String mobNoPattern="[0-9]{0,10}";
	float FixInterestRate= 9.5f;
	boolean validateUsername(String userName);
	boolean validateEmail(String email);
	boolean validateMobNo(String mobno);
	public void applyLoan (Loan loan);
	void insertCust(Customer customer);
	public double calculateEMI(double amount, int duration);

}
