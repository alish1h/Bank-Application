package com.bankApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Application implements Serializable
{
	Map<Long, BankAccount> m=new HashMap<>();
	static String data="App.txt";

	public void openAccount(Scanner sc) {
		sc.nextLine();
		long mob;
		while(true) {
			System.out.println("Enter Mobile number :");
			 mob=getInput(sc);
			 if(mob >0 && String.valueOf(mob).length()==10)
			 {
				 break;
			 }
			 else
			 {
				 System.out.println("Invalid Input ...Mobile number should be 10 numbers..");
			 }
		}
		
		if(m.containsKey(mob))
		{
			System.out.println("Account with this number is already available.");
			
		}
		else
		{
			sc.nextLine();
		System.out.println("Enter name:");
		String name=sc.nextLine();
		System.out.println("Enter Initial deposit balance :");
		double b=getDInput(sc);
        BankAccount newAccount=new BankAccount(mob, name, b);
		m.put(mob, newAccount);
		System.out.println("Account created Suuccessfully...");
		
		}
	}
	
	public void checkBalance(Scanner sc)
	{
		sc.nextLine();
		System.out.println("Enter Mobile number :");
		long s=getInput(sc);
		BankAccount b=m.get(s);
		if(b !=null)
		{
			b.check();
		}
		else
		{
			System.out.println("Account linked to mobile not found..");
		}
		
	}
	
	public void withdraw(Scanner sc)
	{
		/////--------
		sc.nextLine();
		System.out.println("Enter Mobile Number :");
		long mob=getInput(sc);
		BankAccount b=m.get(mob);
		if(b !=null)
		{
			System.out.println("Enter amount to withdraw :");
			double inr=getDInput(sc);
			b.withdraw(inr);
		}
		else
	{
		System.out.println("Account not found.");
	}
	
	}

public void deposit(Scanner sc)
{
	sc.nextLine();
	System.out.println("Enter mobile number :");
	long mob=getInput(sc);
	BankAccount b=m.get(mob);
	if(b !=null)
	{
		System.out.println("Enter amount to deposit :");
		double inr=getDInput(sc);
		b.deposit(inr);
	}
	else
	{
		System.out.println("Account not found.");
	}
	
}

//public void deposit(Scanner sc)
//{
//	sc.nextLine();
//	System.out.println("Enter mobile number :");
//	int mob=getInput(sc);
//	BankAccount b=m.get(mob);
//	if(b !=null)
//	{
//System.out.println("Enter amount to deposit :");
//		double dep=getDInput(sc);
//		b.deposit(dep);
//	}
//	else
//	{
//		System.out.println("Account not found.");
//	}
//	
//}
public void display()
{
	if(m.isEmpty())
	{
		System.out.println("No accounts Found.");
	}
	else
	{
		for(BankAccount b :m.values())
		{
			b.display();
			System.out.println("===============");
		}
	}
}

public static void main(String[] args) {
	Application a=new Application();
	System.out.println("Welcome to Tcs Bank.");
	Scanner sc=new Scanner(System.in);
	a.loadData();
	
	
	
	while(true)
	{
		
		System.out.println("1. Open Account");
		System.out.println("2. Check Balance");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Deposit Money");
		System.out.println("5. Display All Accounts");
		System.out.println("6. Exit");
		int a1=sc.nextInt();
		switch (a1) {
		case 1: a.openAccount(sc);
		break;
		
		case 2: a.checkBalance(sc);
		break;
		
		case 3: a.withdraw(sc);
		break;
		
		case 4: a.deposit(sc);
		break;
		
		case 5:a.display();
		break;
		
		case 6:
			a.saveData();
			sc.close();
			System.out.println("Thank you...");
			System.exit(0);
			break;
			
		default: System.out.println("Invalid input.");
}

}
	
	
}

public  void saveData() 
{
	try
	{
		FileOutputStream fos=new FileOutputStream(data);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(m);
	}
	catch(Exception e)
	{
		System.out.println("Error :"+e.getMessage());
	}
}

public  void loadData()
{
	try 
	{
		FileInputStream fis=new FileInputStream(data);
		ObjectInputStream ois=new ObjectInputStream(fis);
		m=(Map<Long, BankAccount>)ois.readObject();
		
	}
	catch (FileNotFoundException e)
	{
		System.out.println("No data at start..");
	}
	catch(Exception e)
	{
		System.out.println("Error loading data :"+e.getMessage());
	}
}

public long getInput(Scanner sc)
{
	try 
	{
		try {
			return sc.nextLong();
		}
		catch(InputMismatchException e)
		{
			sc.next();
			System.out.println("Invalid Input. Please Enter again :");
			return sc.nextInt();
		}
		
	}

catch(InputMismatchException e)
	{
		System.out.println("Invalid input .");
		System.out.println("Sorry...Exiting application.");
		System.out.println("Thank you");
		System.exit(0);
		return 0;
		
	}
}

public double getDInput(Scanner sc)
{
	while(true)
	{
		double d=sc.nextDouble();
		if(d >0)
		{
			return d;
			
		}
		else
		{
			System.out.println("Invalid Amount...Please Enter Amount");
		}
		
	}
}
	
	

}


