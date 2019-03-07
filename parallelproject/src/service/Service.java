package service;

import java.util.List;

import Exception.CustomerExists;
import Exception.CustomerNotFoundException;
import Exception.IllegalFormatException;
import Exception.InsufficientBalanceException;
import customer.Customer;
import customer.Transaction;
import data.Dao;
import data.IDao;

public class Service implements IService {
	
	IDao dao=new Dao();
	//withdraw amount
			//minimum balance should be 100
			@Override
			public String Widraw(String mobile, double amount) throws InsufficientBalanceException{
				try {
					return dao.Widraw(mobile, amount);
				} catch (InsufficientBalanceException e) {
					throw new InsufficientBalanceException(e.getMessage());
				}
			}

			//deposit amount in wallet
			@Override
			public String deposit(String mobile, double amount) {
				return dao.deposit(mobile, amount);
			}

			//store withdraw result and deposit result in array
			@Override
			public String[] fundTransfer(String fromCust, String toCust, double amount) throws InsufficientBalanceException {
				
				String[] result = new String[2];
				try
				{
					result[0] = dao.Widraw(fromCust, amount);
					result[1] = dao.deposit(toCust, amount);
					return result;
				}catch(InsufficientBalanceException e)
				{
					throw new InsufficientBalanceException(e.getMessage());
				}
			
				
			}

			//returns records in list
			@Override
			public List<Transaction> printTransaction(Customer customer) {
				return dao.printTransaction(customer);
			}

			//create user
			@Override
			public Customer createCustomer(Customer customer) throws CustomerExists{
				try {
					return dao.createCustomer(customer);
				} catch (CustomerExists e) {
					throw new CustomerExists(e.getMessage());
				}
			}

			//login method
			@Override
			public Customer checkUser(String name, String password) throws CustomerNotFoundException{
				try {
					return dao.checkUser(name, password);
				} catch (CustomerNotFoundException e) {
					throw new CustomerNotFoundException(e.getMessage());
				}
			}
			
			@Override
			public double checkBalance(Customer customer) {
				return dao.checkBalance(customer);
			}

			
			//-------validation codes below------------//
			@Override
			public boolean validateName(String name) throws IllegalFormatException{
				if(name.matches(userNamePattern))
					return true;
				else
					throw new IllegalFormatException("name should be between 2 - 9 letters with 1st letter capital");
			}

			@Override
			public boolean validateMobNo(String mobileno)  throws IllegalFormatException{
				if(mobileno.matches(usermobilePattern))
					return true;
				else
					throw new IllegalFormatException("Enter Valid 10 digit mobile number.");
			}

			@Override
			public boolean validateEmail(String email)  throws IllegalFormatException{
				if(email.matches(useremailPattern))
					return true;
				else
					throw new IllegalFormatException("Enter Valid Email");
			}

			@Override
			public boolean validatePassword(String password)  throws IllegalFormatException{
				if(password.matches(userpasswordPattern))
					return true;
				else
					throw new IllegalFormatException("Enter atleast 6-12 character");
			}

			@Override
			public boolean validateChoice(String userChoice)  throws IllegalFormatException{
				if(userChoice.matches(userChoice))
					return true;
				else
					throw new IllegalFormatException("Please choose 1 or 2 or 3");
			}

			@Override
			public boolean validateAmount(String useramt)  throws IllegalFormatException{
				if(useramt.matches(userAmount))
					return true;
				else
					throw new IllegalFormatException("Enter in numbers and should be more than Rs.10");
			}
}