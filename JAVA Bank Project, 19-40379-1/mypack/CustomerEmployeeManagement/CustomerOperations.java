package mypack.CustomerEmployeeManagement;
import mypack.AccountManagement.Customer;

interface CustomerOperations
{
	void insertCustomer(Customer c);
	void removeCustomer(Customer c);
	Customer getCustomer(int nid);
	void showAllCustomers();
}