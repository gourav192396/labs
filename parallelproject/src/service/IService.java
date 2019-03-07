package service;

import java.util.List;

import Exception.CustomerExists;
import Exception.CustomerNotFoundException;
import Exception.IllegalFormatException;
import Exception.InsufficientBalanceException;
import customer.Customer;
import customer.Transaction;

public interface IService {

	String userNamePattern="[A-Z][a-z]{2,9}";
	String usermobilePattern=("(0/91)?[7-9][0-9]{9}");
	String useremailPattern="[a-zA-Z0-9+_.-]+@(.+)$";
	String userpasswordPattern="[a-zA-Z0-9,.@_]{6,12}";
	String userChoice="[1-3]{1}";
	String userAmount="[0-9]{2,10}";
	
	 boolean validateName(String name) throws IllegalFormatException;
	 boolean validateMobNo(String mobile) throws IllegalFormatException;
	 boolean validateEmail(String email) throws IllegalFormatException;
	 boolean validatePassword(String password) throws IllegalFormatException;
	 boolean validateChoice(String userchoice) throws IllegalFormatException;
	 boolean validateAmount(String useramt) throws IllegalFormatException;
	 
	String Widraw(String mobile,double amount) throws InsufficientBalanceException;
	
	String deposit(String mobile,double amount);
	
	String[] fundTransfer(String fromCust,String toCust,double amount) throws InsufficientBalanceException;
	
	List<Transaction> printTransaction(Customer customer);
	
	Customer createCustomer(Customer customer) throws CustomerExists;
	
	Customer checkUser(String username, String password) throws CustomerNotFoundException;
	
	double checkBalance(Customer customer);
	

	
	   
	 
//		void Widraw(String mobile,double amount);
//		void deposit(String mobileNumber,double amount);
//		void fundTransfer(String fromCust,String toCust,double amount);
//		void summary(Customer customer);
//		void createCustomer(Customer customer);
//		boolean checkUser(String name, String password);
	
}
