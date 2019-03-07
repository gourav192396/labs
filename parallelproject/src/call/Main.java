package call;

import java.util.List;
import java.util.Scanner;

import Exception.CustomerExists;
import Exception.CustomerNotFoundException;
import Exception.IllegalFormatException;
import Exception.InsufficientBalanceException;
import customer.Customer;
import customer.Transaction;
import service.IService;
import service.Service;

public class Main {

	public static void main(String[] args) {
//		Scanner scan=new Scanner(System.in);
//		String choice;
//		String name;
//		String mobile;
//		String email;
//		String password;
		 

		
		Customer newCustomer=new Customer();
		Customer loggedCustomer = new Customer();
		IService service=new Service();
		
		
		Customer customer=new Customer("Gourav","gourav@gmail","8888888888","password",31000);
		Customer customer2=new Customer("Mayur","mayur@gmail","7777777777","password",45000);

		try {
			service.createCustomer(customer);
			service.createCustomer(customer2);
		} catch (CustomerExists e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner scan=new Scanner(System.in);
		
		
		for(;;){
		System.out.println("welcome to Citi Bank Mobile");
		System.out.println("1.Create account \2.Login \n 2.Exit");
//		choice=scan.next();
//				if(choice.equals("1"))
		String choice="";
		while (true) {
			choice = scan.next();
			try {
				//validate if input between 1-3
				if (service.validateChoice(choice))
					break;
			} catch (IllegalFormatException e) {
				System.out.println(e.getMessage());
			}
		}
     if(choice.equals("1"))
     {
			while(true){
				System.out.println("Enter Name as Registered in Bank");
				String temp = scan.next();
				try {
					//validate name
					if (service.validateName(temp)) {
						newCustomer.setName(temp);
						break;
					}
				} catch (IllegalFormatException e) {
					System.out.println(e.getMessage());
				}
			}
			while (true)// take mobile
			{
				System.out.println("Enter Mobile No");
				String temp = scan.next();
				try {
					//validate mobile number
					if (service.validateMobNo(temp)) {
						newCustomer.setMobile(temp);
						break;
					}
				} catch (IllegalFormatException e) {
					System.out.println(e.getMessage());
				}
			}
//			while(true){
//				System.out.println("Enter Customer EmailId");
//				System.out.println("-------enter user email");
//				email=scan.next();
//				boolean isValid=service.validateEmail(email);
//				if(isValid){
//					customer.setEmail(email);
//				
//					break;
//				}
//				else
//					System.out.println("Enter valid Email Id");
//			 }
			while (true)// set password
			{
				System.out.println("Set Password");
				String temp = scan.next();
				try {
					//validate password
					if (service.validatePassword(temp)) {
						newCustomer.setPassword(temp);
						break;
					}
				} catch (IllegalFormatException e) {
					System.out.println(e.getMessage());
				}
			}
			// set balance
			newCustomer.setBalance(5000);

			// try to create new user and also checks if user exists
			try {
				Customer cust = service.createCustomer(newCustomer);
				System.out.println("New Customer Created");
				System.out.println(cust);
			} catch (CustomerExists e) {
				System.out.println(e.getMessage());
			}

		}// end of register
		
     else if (choice.equals("2"))// login code
		{
			while (true) {
				System.out.println("Enter Mobile no");
				String temp = scan.next();
				System.out.println("Enter Password");
				String pass = scan.next();
				try {
					//get customer from login
					loggedCustomer = service.checkUser(temp, pass);
					break;
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}	
			
//			Customer customer =new Customer();
//			customer.setName(name);
//			customer.setEmail(email);
//			customer.setMobile(mobile));
//			
          
//            System.out.println("--------Customer information saved successgfully");
//            System.out.println();
			
			
//		}else{
//				while(true){
//					System.out.println("Enter Mobile");
//					System.out.println("-----------enter numeric digits of 10 numbers-------");
//					mobile=scan.next();
//					boolean isValid=service.validateMobNo(mobile);
//					if(isValid){
//						
//						break;
//				}
//				}
//				
//				while(true){
//
//					System.out.println("Enter Password");
//					System.out.println("-----------should contain atleast one alpha numeric characters and one sign-------");
//					password=scan.next();
//					boolean isValid=service.validateMobNo(password);
//					if(isValid){
//						
//					
//						break;
//					}
//				}
				//boolean userValidate = service.checkUser(mobile, password);
			while (true)// start submenu
			{
				System.out.println("Welcome");
				System.out.println("1) Show Balance");
				System.out.println("2) Deposit");
				System.out.println("3) Withdraw");
				System.out.println("4) Fund Transfer");
				System.out.println("5) Print Transactions");
				System.out.println("6) Exit");
				String newchoice = scan.next();
				boolean isExited = false;

					switch (newchoice) {
					case "1":
						System.out.println("Balance is Rs."+ service.checkBalance(loggedCustomer));
						break;

					case "2":
						while (true) {
							System.out.println("Enter amount to deposit");
							choice = scan.next();
							try {
								//validate if amount input is valid
								if (service.validateAmount(choice))
									break;
							} catch (IllegalFormatException e) {
								System.out.println(e.getMessage());
							}
						}

						String depositResult = 
								service.deposit(
								loggedCustomer.getMobile(),
								Double.parseDouble(choice));
						//print result from server
						System.out.println(depositResult);
						break;

					case "3":
						while (true) {
							System.out.println("Enter amount to withdraw");
							choice = scan.next();
							try {
								//validate if amount input is valid
								if (service.validateAmount(choice))
									break;
							} catch (IllegalFormatException e) {
								System.out.println(e.getMessage());
							}
						}//end of while

						try {
							String withdrawResult = service.Widraw(
									loggedCustomer.getMobile(),
									Double.parseDouble(choice));
							System.out.println(withdrawResult);
						} catch (NumberFormatException
								| InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						}
						break;

					case "4":
						System.out.println("Enter mobile number of other user");
						String mob = scan.next();
						System.out.println("Enter the amount");
						String amt = scan.next();

						//store fund transfer results
						try {
							String[] data = service.fundTransfer(
									loggedCustomer.getMobile(), mob,
									Double.parseDouble(amt));
							for (String result : data) {
								System.out.println(result);
							}
						} catch (NumberFormatException
								| InsufficientBalanceException e) {
							System.out.println(e.getMessage());
						}
						break;

					case "5":
						List<Transaction> list = 
							service.printTransaction(loggedCustomer);
						list.stream().forEach(System.out::println);
						break;

					case "6":
						isExited = true;
					default:
						break;
					}

					if (isExited) {
						isExited = false;
						break;
					} else
						continue;
				}
			}// end of login code
			else { //if choice is 3 ie exit
				break;
			}
		}// end of eternal loop
	}
}


					
				

					