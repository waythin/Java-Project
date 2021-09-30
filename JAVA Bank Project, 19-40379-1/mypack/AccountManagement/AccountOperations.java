package mypack.AccountManagement;
import mypack.TransactionManagement.Account;

interface AccountOperations
{
	void insertAccount(Account a);
	void removeAccount(Account a);
	Account getAccount(int accountNumber);
	void showAllAccounts();
}