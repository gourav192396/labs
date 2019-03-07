package data;

import java.util.List;

import Exception.CustomerExists;
import Exception.CustomerNotFoundException;
import Exception.InsufficientBalanceException;
import customer.Customer;
import customer.Transaction;

public interface IDao {
	Customer createCustomer(Customer customer) throws CustomerExists;

	String Widraw(String mobile, double amount)	throws InsufficientBalanceException;

	String deposit(String mobile, double amount);

	Customer checkUser(String name, String password) throws CustomerNotFoundException;

	List<Transaction> printTransaction(Customer customer);

	double checkBalance(Customer customer);

	long ids = 10002;

}
