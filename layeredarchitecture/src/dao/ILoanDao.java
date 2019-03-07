package dao;

import customer.Customer;
import customer.Loan;

public interface ILoanDao {
	void insertCust(Customer customer);
	public void applyLoan (Loan loan);

}
