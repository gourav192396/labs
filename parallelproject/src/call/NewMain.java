package call;

import java.util.Scanner;

import customer.Customer;
import service.IService;
import service.Service;

public class NewMain {
	
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String choice, password, email;
			boolean isValid;
			String mobile;
			IService service = new Service();
			Customer customer = new Customer();
			Customer customer2 = new Customer("Tushar","t@g.c","8286703935","password",45000);
			Customer customer3 = new Customer("Mayur","m@g.c","9892622745","password",46000);

			service.createCustomer(customer2);
			service.createCustomer(customer3);
			for (;;) {
				System.out.println("Welcome to DTM wallet");
				System.out.println("1) Register");
				System.out.println("2) Login");
				choice = scan.next();
				if (choice.equals("1")) {
					while (true) {
						System.out.println("Enter Name: ");
						String name = scan.next();
						isValid = service.validateUsername(name);
						if (isValid) {
							customer.setName(name);
							break;
						}
						System.out
								.println("Name should contain only alphabets & first letter should be capital");
					}
					while (true) {
						System.out.println("Enter Mobile Number: ");
						mobile = scan.next();
						isValid = service.validateMobNo(mobile);
						if (isValid) {
							customer.setMobile(mobile);;
							break;
						}
						System.out
								.println("Mobile number should be 10 digits and start with 7/8/9");
					}
					while (true) {
						System.out.println("Enter password: ");
						password = scan.next();
						isValid = service.validatePassword(password);
						if (isValid) {
							customer.setPassword(password);
							break;
						}
						System.out
								.println("Password should be 8 characters, should contain at least one special character, digit and one uppercase letter");
					}
					while (true) {
						System.out.println("Enter Email Id: ");
						email = scan.next();
						isValid = service.validateEmail(email);
						if (isValid) {
							customer.setEmail(email);
							customer.setBalance(50000);
							service.createCustomer(customer);
							break;
						}
						System.out.println("Invalid email");
					}

				} else {
					while (true) {
						System.out.println("Enter Mobile Number: ");
						mobile = scan.next();
						isValid = service.validateMobNo(mobile);
						if (isValid) {
							break;
						}
					}
					while (true) {
						System.out.println("Enter password: ");
						password = scan.next();
						isValid = service.validatePassword(password);
						if (isValid) {
							break;
						}
					}
					
					boolean userValidate = service.checkUser(mobile, password);
					while(true)
					{
					if (userValidate) {
						System.out.println("Welcome");
						System.out.println("1) Show Balance");
						System.out.println("2) Deposit");
						System.out.println("3) Withdraw");
						System.out.println("4) Fund Transfer");
						System.out.println("5) Print Transactions");
						choice = scan.next();

						switch (choice) {

						case "1":
							service.summary(customer);
							break;

						case "2":
							System.out.println("How much amount you want to deposit?");
							double amount = scan.nextDouble();
							service.deposit(mobile, amount);
							System.out.println("Money deposited successfully");
							System.out.println("Money deposited successfully");
							break;

						case "3":
							System.out
									.println("How much amount you want to withdraw?");
							amount = scan.nextDouble();
							service.Widraw(mobile, amount);
							System.out.println("Money withdrawn successfully");
							break;

						case "4":
							System.out
									.println("Enter the mobile number of receiver: ");
							String toCustomer = scan.next();
							boolean isValidInput = service.validateMobNo(toCustomer);
							if (isValidInput == true) {
								System.out.println("Enter the amount: ");
								double transferAmount = scan.nextDouble();
								service.fundTransfer(mobile, toCustomer, transferAmount);
								System.out.println("Fund transfer successfull");
							} else {
								System.out.println("Invalid Account Number");
							}
							break;

						case "5":service.summary(customer);
							break;

							default:System.out.println("Enter valid Input");
						}

					} else {
						System.out.println("Invalid username or password");
					}
					
					System.out.println("Do you wish to continue?");
					if(scan.next().equals("n"))break;
					}//while loop ends
				}
			}
		}
	}

