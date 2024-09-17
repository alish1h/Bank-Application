package com.bankApplication;

import java.io.Serializable;

public class BankAccount implements Serializable
{
	private int mobNumber;
	private String user;
	private double balance;
	
	public BankAccount(int mobNumber, String user, double balance) {
		super();
		this.mobNumber = mobNumber;
		this.user = user;
		this.balance = balance;
	}
	
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance=balance+amount;
			System.out.println("Amount deposited..."+amount);
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
				System.out.println("Amount withdrawn :"+amount);
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
	System.out.println("Account balane for :"+user +" $"+balance);	
	}

	public void display()
	{
		System.out.println("Mobile number :" +mobNumber);
		System.out.println("User name :"+user);
		System.out.println("Amount :"+balance +"Rs");
	}

}
