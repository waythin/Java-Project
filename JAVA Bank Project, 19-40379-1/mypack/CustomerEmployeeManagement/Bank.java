package mypack.CustomerEmployeeManagement;
import mypack.AccountManagement.Customer;

public class Bank implements EmployeeOperations,CustomerOperations
{
	private Employee[] employees=new Employee[100];
	private Customer[] customers=new Customer[100];
	
	
	static int i=0,j=0;
	
	
	public void insertEmployee(Employee e)
	{
		try
		{
			employees[i]=e;
			i++;
			System.out.println("Employee inserted...\n");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Employee insertion failed");
		}
	}

	public void removeEmployee(Employee e)
	{
		int count=0;
		if(e!=null)
		{
			for(i=0;i<employees.length;i++)
			{
				if(employees[i]==e)
				{
					if(i==(employees.length-1))
					{
						employees[i]=null;
						count++;
					}
					else
					{
						for(int k=i;k<(employees.length-1);k++)
							{
								employees[k]=employees[k+1];
								if((k+1)==(employees.length-1))
								{
									employees[k+1]=null;
								}
							}
							count++;
							break;			
					}
				}
			}
			if(count==0)
			{
				System.out.println("ID not found...");
			}
			else
			{
				System.out.println("Employee removed...");
			}
		}
	}
	public Employee getEmployee(String empId)
	{
		try
		{	
			for(i=0;i<employees.length;i++)
			{
				if((employees[i].getEmpId()).equals(empId)==true)
				{
					return employees[i];
				}
			}
		}
		catch(NullPointerException ex)
		{
			System.out.println("ID not found");
		}
		return null;
	}
	public void showAllEmployees()
	{
		for(i=0;i<employees.length;i++)
		{
			if(employees[i]!=null)
			{
				System.out.println("Details of Employee "+(i+1)+"...");
				System.out.println("Name: "+employees[i].getName());
				System.out.println("ID: "+employees[i].getEmpId());
				System.out.println("Salary: "+employees[j].getSalary());
				System.out.println("--------------------------------");
				
			}
			else
			{
				break;
			}
		}
	}

	public void insertCustomer(Customer c)
	{
		try
		{
			customers[j]=c;
			j++;
			System.out.println("Customer inserted...\n");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Customer insertion failed...");
		}
	}
	public void removeCustomer(Customer c)
	{
		int count=0;
		if(c!=null)
		{		
			for(j=0;j<customers.length;j++)
			{
				if(customers[j]==c)
				{
					if(j==(customers.length-1))
					{
						customers[j]=null;
						count++;
					}
					else
					{
						for(int k=j;k<(customers.length-1);k++)
							{
								customers[k]=customers[k+1];
								if((k+1)==(customers.length-1))
								{
									customers[k+1]=null;
								}
							}
							count++;
							break;			
					}
				}
			}	
			if(count==0)
			{
				System.out.println("NID not found...");
			}
			else
			{
				System.out.println("Customer removed...");
			}
		}
	}
	public Customer getCustomer(int nid)
	{
		try
		{	
			for(j=0;j<customers.length;j++)
			{
				if(customers[j].getNid()==nid)
				{
					return customers[j];
				}
			}
		}
		catch(NullPointerException ex)
		{
			System.out.println("NID not found");
		}
		return null;
	}
	public void showAllCustomers()
	{
		for(j=0;j<customers.length;j++)
		{
			if(customers[j]!=null)
			{
				System.out.println("Details of Customer "+(j+1)+"...");
				System.out.println("Name: "+customers[j].getName());
				System.out.println("NID: "+customers[j].getNid());
				System.out.println("--------------------------------");
			}
			else
			{
				break;
			}
		}
	}

	
}