package dao;

import java.util.HashMap;
import java.util.Map;

import customer.Customer;
import customer.Loan;

public class LoanDao implements ILoanDao {
	//ILoanDao da=new LoanDao();
	private Map<Double,Customer> customers= new HashMap<>();
	private Map<Double,Loan> loanEntry= new HashMap<>();
	
	@Override
	public void insertCust(Customer customer) {
		double temp=Math.random()*100;
		customer.setCustId((long)temp);
		customers.put(temp, customer);
	}

	@Override
	public void applyLoan(Loan loan) {
		double temp2=Math.random()*100;
		loan.setLoanID((long)temp2);
		loanEntry.put(temp2, loan);
	}

}
