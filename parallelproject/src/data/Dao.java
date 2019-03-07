package data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exception.CustomerExists;
import Exception.CustomerNotFoundException;
import Exception.InsufficientBalanceException;
import customer.Customer;
import customer.Transaction;

public class Dao implements IDao {
	
//	ArrayList<Customer> database=new ArrayList<>();
//	ArrayList<Transaction> transactionDB=new ArrayList<>();
//	
//
//	
//
//	@Override
//	public void createCustomer(Customer customer) {
//		int random = (int) (Math.random() * 100);
//		customer.setCustomerId(random);
//		database.add(customer);
//		System.out.println("User Created Successfully for ID " + random);
//		
//		Transaction recordTrans = new Transaction(customer.getMobile(),
//				"CR", customer.getBalance(), customer.getBalance());
//		transactionDB.add(recordTrans);
//		
//		
//	}
//
//	@Override
//	public void Widraw(String mobile, double amount) {
//		Customer customer = database.stream().filter(x -> x.getMobile().equals(mobile)).findFirst().get();
//		//refer kavita mam's code on stuff stored on desktop to get this method and object definition		
//				
//		
//		if (amount <= customer.getBalance() - 1000) {
//			customer.setBalance(customer.getBalance() - amount);
//			
//			
//			Transaction recordTrans = new Transaction(mobile, "DB",
//					amount, customer.getBalance());
//			transactionDB.add(recordTrans);
//		} else
//			System.out.println("Insuffient Balance");
//		
//		
//	}
//
//	@Override
//	public void Deposit(String mobile, double amount) {
//		Customer customer = database.stream()
//				.filter(x -> x.getMobile().equals(mobile))
//				.findFirst().get();
//		
//		if (customer != null) {
//			customer.setBalance(customer.getBalance() + amount);
//			Transaction recordTrans = new Transaction(mobile, "CR",
//					amount, customer.getBalance());
//			transactionDB.add(recordTrans);
//		} else
//			System.out.println("No User Found");
//		
//			
//	}
//
//	@Override
//	public void fundTransfer(String fromCust, String toCust, double amount) {
//		Widraw(fromCust, amount);
//		Deposit(toCust, amount);
//		transactionDB.stream().forEach(System.out::println);
//	
//		
//	}
//
//	@Override
//	public void summary(Customer customer) {
//		// System.out.println(customer);
//				transactionDB
//						.stream()
//						.filter(x -> x.getMobile().equals(customer.getMobile()))
//						.forEach(System.out::println);
//		
//	}
//
//	@Override
//	public boolean checkUser(String name, String password) {
//		Customer customer = database
//				.stream()
//				.filter(x -> x.getMobile().equals(name)
//						&& x.getPassword().equals(password)).findFirst().get();
//		if (customer != null)
//			return true;
//		else
//		return false;
//	}
	
	
	
	
	// to store customer data
		ArrayList<Customer> database = new ArrayList<Customer>();

		// to store transaction data
		ArrayList<Transaction> transactionDB = new ArrayList<Transaction>();

		// to generate id of customer
		long newID = ids;

		// withdraw money
		@Override
		public String Widraw(String mobile, double amount)
				throws InsufficientBalanceException {

			// find customer
			Customer customer = database.stream()
					.filter(x -> x.getMobile().equals(mobile))
					.findFirst().get();

			// withdraw logic
			// minimum balance should be atleast Rs.100
			if (amount <= customer.getBalance() - 100) {
				customer.setBalance(customer.getBalance() - amount);

				// store transaction history
				Transaction recordTrans = new Transaction(mobile, "DB",
						amount, customer.getBalance());
				transactionDB.add(recordTrans);

				// return success data in string format
				return "Rs." + amount + " debited from account "
						+ customer.getCustomerId() + " on " + LocalDateTime.now()
						+ "\nNew Balance is Rs." + customer.getBalance();
			} else

				// throws exception if balance is below 1000
				// will be cached by service class
				throw new InsufficientBalanceException("You Have Insufficient Amount.");
		}

		@Override
		public String deposit(String mobile, double amount) {

			// find customer
			Customer customer = database.stream()
					.filter(x -> x.getMobile().equals(mobile))
					.findFirst().get();
			customer.setBalance(customer.getBalance() + amount);

			// store transaction history
			Transaction recordTrans = new Transaction(mobile, "CR", amount,
					customer.getBalance());
			transactionDB.add(recordTrans);

			// return success data in string format
			return "Rs." + amount + " credited on account "
					+ customer.getCustomerId() + " on " + LocalDateTime.now()
					+ "\nNew Balance is Rs." + customer.getBalance();
		}

		@Override
		public List<Transaction> printTransaction(Customer customer) {

			// create a list to return transaction history of a user
			List<Transaction> summaryList = new ArrayList();

			// find summary of the user
			summaryList = transactionDB
					.stream()
					.filter(x -> x.getMobile().equals(customer.getMobile()))
					.collect(Collectors.toList());

			return summaryList;
		}

		@Override
		public Customer createCustomer(Customer customer) throws CustomerExists {

			// check if user exists
			// count should be 0
			long count = database
					.stream()
					.filter(x -> x.getMobile().equals(
							customer.getMobile())).count();
			if (count < 1) {
				// add customer
				customer.setCustomerId(++newID);
				database.add(customer);

				// store its first transaction
				Transaction recordTrans = new Transaction(
						customer.getMobile(), "CR", customer.getBalance(),
						customer.getBalance());
				transactionDB.add(recordTrans);
				return customer;
			} else
				// if customer exists then throw error
				throw new CustomerExists("User Already Exists");
		}

		@Override
		public Customer checkUser(String name, String password)
				throws CustomerNotFoundException {

			// to login
			// check username which is mobile number and password
			try {
				Customer customer = database
						.stream()
						.filter(x -> x.getMobile().equals(name)
								&& x.getPassword().equals(password)).findFirst()
						.get();
				return customer;
			} catch (Exception e) {

				// if invalid credentials
				throw new CustomerNotFoundException("No User Found");
			}
		}

		@Override
		public double checkBalance(Customer customer) {

			// fetch balance of user
			double balance = database
					.stream()
					.filter(x -> x.getMobile().equals(
							customer.getMobile())).map(y -> y.getBalance())
					.findFirst()
					.get();
			return balance;
		}
	
	
}