package com.bankApplication;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;

public class BankAccount implements Serializable
{
	private long mobNumber;
	private String user;
	private double balance;
	
	public BankAccount(long mob, String user, double balance) {
		super();
		this.mobNumber = mob;
		this.user = user;
		this.balance = balance;
	}
	
	public void deposit(double amount)
	{
		if(amount>0)
		{
			DecimalFormat df = new DecimalFormat("#.00");
	        String formattedBalance = df.format(amount);
		     balance=balance+amount;
			System.out.println("Amount deposited..."+formattedBalance+" Rs");
		}
		
		else
		{
			System.out.println("Invalid deposit Amount.");
		}
	}
	
	public void withdraw(double amount)
	{
		if(amount >0)
		{
			if(balance>=amount)
			{
				balance=balance-amount;
				DecimalFormat df = new DecimalFormat("#.00");
		        String formattedBalance = df.format(amount);
				System.out.println("Amount withdrawn :"+formattedBalance +" Rs");
			}
			else
			{
				System.out.println("Insufficiet bucks...");
			}
		}
	else
		{
			System.out.println("Invalid withdrawl amount");
		}
	   	
	}

	public void check()
	{
		DecimalFormat df = new DecimalFormat("#.00");
        String formattedBalance = df.format(balance);
	System.out.println("Account balane for :"+user +" "+formattedBalance+" Rs");	
	}

	public void display()
	{
		DecimalFormat df = new DecimalFormat("#.00");
        String formattedBalance = df.format(balance);
		System.out.println("Mobile number :" +mobNumber);
		System.out.println("User name :"+user);
		
			System.out.println("Amount :"+formattedBalance +"Rs");

			
			}

}
