import java.util.Scanner;
import mypack.AccountManagement.*;
import mypack.CustomerEmployeeManagement.*;
import mypack.TransactionManagement.*;

public class Start
{
	public static void main(String arg[])
	{	
		try
		{
			Bank bank=new Bank();
			Employee currentEmployee=new Employee();
			Customer currentCustomer=new Customer();
			System.out.println("...Welcome...\n");
			
			Scanner num = new Scanner(System.in);
			String number;
			
			
			do
			{
				
			
				
				System.out.println("1. Employee Management");
				System.out.println("2. Customer Management");
				System.out.println("3. Customer Account Management");
				System.out.println("4. Account Transaction");
				System.out.println("5. Exit \n");
	
				System.out.println("Enter any operation number...\n");
				number= num.nextLine();
		
		
				switch (number) 
				{
					case "1":
					String name;
					String empId;
					double salary;
					Employee newEmployee=new Employee();
					System.out.println("Employee Management...\n");
					System.out.println("1. Insert New Employee");
					System.out.println("2. Remove Existing Employee");
					System.out.println("3. Show All Employees\n");
			
					System.out.println("Enter any operation Number...\n");
					number= num.nextLine();
					
			
						switch (number)
						{
							case "1":
							System.out.println("Insert New Employee...\n");
							System.out.println("Name of employee:");
							name=num.nextLine();
							newEmployee.setName(name);
							System.out.println("Employee's ID:");
							empId=num.nextLine();
							newEmployee.setEmpId(empId);
							System.out.println("Salary:");
							salary=num.nextDouble();
							newEmployee.setSalary(salary);
							bank.insertEmployee(newEmployee);
							break;
				
							case "2":
							System.out.println("Remove Existing Employee\n");
							System.out.println("Enter employee's ID");
							empId=num.nextLine();
							bank.removeEmployee(bank.getEmployee(empId));
							break;
				
							case "3":
							System.out.println("Show All Employees\n");
							bank.showAllEmployees();
							break;
				
							default:
							System.out.println("You entered wrong number.\n");
				
						}
					break;
		
					case "2":
					int nid;
					Customer newCustomer=new Customer();
					System.out.println("Customer Management\n");
					System.out.println("1. Insert New Customer");
					System.out.println("2. Remove Existing Customer");
					System.out.println("3. Show All Customer\n");
			
					System.out.println("Enter any operation Number...\n");
					number= num.nextLine();
					
				
			
						switch (number)
						{
							case "1":
							System.out.println("Insert New Customer\n");
							System.out.println("Enter the name of customer");
							name=num.nextLine();
							newCustomer.setName(name);
							System.out.println("Enter customer's NID");
							nid=num.nextInt();
							newCustomer.setNid(nid);
							bank.insertCustomer(newCustomer);
							break;
				
							case "2":
							System.out.println("Remove Existing Customer");
							System.out.println("Enter customer's NID");
							nid=num.nextInt();
							bank.removeCustomer(bank.getCustomer(nid));
							break;
				
							case "3":
							System.out.println("Show All Customer");
							bank.showAllCustomers();
							break;
				
							default:
							System.out.println("You entered wrong number.\n");
				
						}
					break;
			
					case "3":
					int accountNumber;
					double balance;
					double interestRate;
					int tenureYear;
					System.out.println("Customer Account Management\n");
					System.out.println("1. Insert New Account");
					System.out.println("2. Remove Existing Account");
					System.out.println("3. Show All Account\n");
			
					System.out.println("Enter any operation Number...\n");
					number= num.nextLine();
					
			
						switch (number)
						{
							case "1":
							System.out.println("Insert New Account");
							System.out.println("1. Savings Account");
							System.out.println("2. Fixed Account");
							number=num.nextLine();
								switch(number)
								{
									case "1":
									System.out.println("Savings Account");
									SavingsAccount s=new SavingsAccount();
									System.out.println("Enter account number");
									accountNumber=num.nextInt();
									s.setAccountNumber(accountNumber);
									System.out.println("Enter the balance");
									balance=num.nextDouble();
									s.setBalance(balance);
									System.out.println("Enter the interest rate");
									interestRate=num.nextDouble();
									s.setInterestRate(interestRate);
									currentCustomer.insertAccount(s);
									break;
									
									case "2":
									System.out.println("Fixed Account");
									FixedAccount f=new FixedAccount();
									System.out.println("Enter account number");
									accountNumber=num.nextInt();
									f.setAccountNumber(accountNumber);
									System.out.println("Enter the balance");
									balance=num.nextDouble();
									f.setBalance(balance);
									System.out.println("Enter the tenure year");
									tenureYear=num.nextInt();
									f.setTenureYear(tenureYear);
									currentCustomer.insertAccount(f);
									break;
								}
							break;
				
							case "2":
							System.out.println("Remove Existing Account");
							System.out.println("Enter account number");
							accountNumber=num.nextInt();
							currentCustomer.removeAccount(currentCustomer.getAccount(accountNumber));
							break;
				
							case "3":
							System.out.println("Show All Accounts");
							currentCustomer.showAllAccounts();
							break;
				
							default:
							System.out.println("You entered wrong number.\n");
				
						}
					break;
			
					case "4":
					double amount;
					System.out.println("Account Transaction\n");
					System.out.println("1. Deposit Money");
					System.out.println("2. Withdraw Money");
					System.out.println("3. Transfer Money\n");
			
					System.out.println("Enter any operation Number...\n");
					number= num.nextLine();
					
			
						switch (number)
						{
							case "1":
							System.out.println("Deposit Money");
							System.out.println("Enter account number in which you want to deposit money");
							accountNumber=num.nextInt();
							System.out.println("Enter amount of money to deposit");
							amount=num.nextDouble();
							(currentCustomer.getAccount(accountNumber)).deposit(amount);
							break;
				
							case "2":
							System.out.println("Withdraw Money");
							System.out.println("Enter account number from which you want to withdraw money");
							accountNumber=num.nextInt();
							System.out.println("Enter amount of money to withdraw");
							amount=num.nextDouble();
							(currentCustomer.getAccount(accountNumber)).withdraw(amount);
							break;
				
							case "3":
							System.out.println("Transfer Money");
							int transferTo, transferFrom;
							System.out.println("Enter account number from which you want to transfer money");
							transferFrom=num.nextInt();
							System.out.println("Enter account number to which you want to transfer money");
							transferTo=num.nextInt();
							System.out.println("Enter amount of money to transfer");
							amount=num.nextDouble();
							(currentCustomer.getAccount(transferFrom)).createDirectory();
							(currentCustomer.getAccount(transferFrom)).transfer(currentCustomer.getAccount(transferTo), amount);
							break;
				
							default:
							System.out.println("You entered wrong number.\n");
				
						}
					break;
			
					case "5":
					System.out.println("Exit");
					break;
			
				}
			}while(!number.equals("5"));
				
		}
				
				
		catch(Exception i)
		{
			System.out.println("You entered wrong number");
		}
	
	}
}
