package service;

import customer.Customer;
import customer.Loan;
import dao.ILoanDao;
import dao.LoanDao;

public class LoanService implements ILoanService {
	double emi;
	ILoanDao daoi = new LoanDao();

	@Override
	public boolean validateUsername(String userName) {

		if (userName.matches(userNamePattern)) {
			return true;
		} else
			return false;
	}

	@Override
	public void insertCust(Customer customer) {

		daoi.insertCust(customer);
	}

	@Override
	public boolean validateEmail(String email) {
		if (email.matches(emailPattern)) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean validateMobNo(String mobno) {
		if (mobno.matches(mobNoPattern)) {
			return true;
		} else
			return false;
	}

	@Override
	public void applyLoan(Loan loan) {
		daoi.applyLoan(loan);
	}

	@Override
	public double calculateEMI(double amount, int duration) {
//		= P * r *(1 + r) n/ ((1 + r) n - 1)
		emi= amount*FixInterestRate*(1+FixInterestRate)/((1+FixInterestRate)*duration-1);
		return emi;
	}

}
