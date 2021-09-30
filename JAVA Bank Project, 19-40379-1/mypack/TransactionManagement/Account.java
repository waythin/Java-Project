package mypack.TransactionManagement;
import java.io.*;
import java.lang.*;

public abstract class Account implements ITransactions
{
	private int accountNumber;
	private double balance;
	
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	public double getBalance()
	{
		return this.balance;
	}
	abstract public void showInfo();

	
	File folder;
	File file;
	private FileWriter writer;
	private FileReader reader;
	private BufferedReader buffer;

	public void createDirectory() 
	{
		try
		{
			folder=new File("C:/Users/Lenovo/Desktop/java project/Transaction Info");
			folder.mkdir();
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	}
	public void writeInFile(String s)
	{
		try
		{
			file = new File("Transaction.txt");
			file.createNewFile();
			writer = new FileWriter(file, true);
			writer.write(s+"\r\n");
			writer.flush();
			writer.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace() ;
		}
	}
	public void readFromFile()
	{
		try
		{
			reader = new FileReader(file);
			buffer = new BufferedReader(reader);
			String text="", temp;
			
			while((temp=buffer.readLine())!=null)
			{
				
				text=text+temp+"\r"+"\n";
			}
			System.out.print(text);
			reader.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}	
	}
	
	public void deposit(double amount)
	{
		this.balance=balance+amount;
		
	}
	
	public void withdraw(double amount)
	{
		if(amount<=balance)
		{
			this.balance=balance-amount;
		}
		else
		{
			System.out.println("Transaction cancelled due to insufficient balance");
		}
	}
	
	public void transfer(Account a, double amount)
	{
		if(amount<=balance)
		{
			writeInFile("--------------------\nBefore transfer");
			writeInFile("The account number "+accountNumber+" has : "+balance);
			writeInFile("The account number "+a.accountNumber+" has : "+a.balance);
			this.balance=balance-amount;
			a.balance=a.balance+amount;
			writeInFile(amount+" has been transfered from account number "+accountNumber+" to "+a.accountNumber);
			writeInFile("Current balance of the account number "+accountNumber+" has: "+balance);
			writeInFile("Current balance of the account number "+a.accountNumber+" has: "+a.balance);
			writeInFile("--------------------");
			readFromFile();
		}
		else
		{
			System.out.println("Transaction cancelled due to insufficient balance");
		}
	}
}