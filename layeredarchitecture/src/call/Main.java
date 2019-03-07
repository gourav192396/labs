package call;

import java.util.Scanner;

import customer.Customer;
import customer.Loan;
import dao.LoanDao;
import service.ILoanService;
import service.LoanService;

public class Main {
	public static void main(String[] args) {
		int choice;
		String userName, address, email, mobno;
		double loanAmount;
		int duration;
		double emi;
		boolean isvalid;
		Scanner sc = new Scanner(System.in);

		ILoanService si = new LoanService();
		LoanDao daoi = new LoanDao();

		for(;;){
		System.out.println("XYZ Finance Company welcomes you");
		System.out.println("1.	Register Customer");
		System.out.println("2.	Exit");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			while (true) {
				 System.out.println("Enter name: ");
				userName = sc.next();
				isvalid = si.validateUsername(userName);
				if (isvalid) {
					break;
				}
				System.out.println("Invalid User Name, Reenter Details ");
			}
			while (true) {
				System.out.println("Enter Mobile no: ");
				mobno = sc.next();
				isvalid = si.validateMobNo(mobno);
				if (isvalid) {
					break;
				}
				System.out.println("Invalid Mobile no, Reenter Details ");
			}
			System.out.println("Enter address: ");
			address = sc.next();

			while (true) {
				System.out.println("Enter email: ");
				email = sc.next();
				isvalid = si.validateEmail(email);
				if (isvalid) {
					break;
				}
				System.out.println("Invalid Email, Reenter Details");
			}
			Customer customer = new Customer();
			customer.setCustName(userName);
			customer.setAddress(address);
			customer.setEmail(email);
			customer.setMobile(Long.parseLong(mobno));
			si.insertCust(customer);
			System.out
					.println("Customer information saved successfully. Your Customer Id is "
							+ customer.getCustId());

			// for(Double key: daoi.customers.keySet())
			// System.out.println("Cust id: "+key+" Customer1 :"+daoi.customers.get(key));
			System.out.println("Do you wish to aplly for loan? y/n");
			String choice2 = sc.next();
			if (choice2.equalsIgnoreCase("y")) {
				System.out.println("Enter the loan amount: ");
				loanAmount = sc.nextDouble();
				System.out.println("Enter the loan duration: ");
				duration = sc.nextInt();
				Loan loan = new Loan();
				loan.setLoanAmount(loanAmount);
				loan.setDuration(duration);
				emi = si.calculateEMI(loanAmount, duration);
				System.out.println("For loan amount " + loanAmount + " and "
						+ duration
						+ " Years duration. Your EMI per month will be" + emi
						+ " Do you want to apply for loan now? (y/n)");
				choice2 = sc.next();
				if (choice2.equalsIgnoreCase("y")) {
					si.applyLoan(loan);
					System.out
							.println("Your Loan request is generated.Your Loan ID is "
									+ loan.getLoanID());
				} else
					System.out.println("Thanks for visiting");
			} else {
				System.out.println(customer);
			}
			break;

		case 2:System.exit(1);

			break;

		default:
			System.out.println("Please enter valid choice");
			break;
		}

		// System.out.println("success");
		}
	}

}
