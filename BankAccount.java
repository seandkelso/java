//****************************************
//
//  BankAccount.java
//
//  This class models a BankAccount
//
//  from Cay Horstmann (modified by Cannon)
//
//*****************************************




public class BankAccount {


  private double balance;
  private String name;
  private long acctNumber;

  public BankAccount(String initName, long acct)
  {
	name=initName;
	acctNumber=acct;
	balance=0.0;
  }

  public void deposit(double amt)
  {
	balance=balance+amt;
  }

  public void withdraw(double amt)
  {
	   balance=balance-amt;
  }


  public double getBalance()
  {
	return balance;
  }

} //end of the class
