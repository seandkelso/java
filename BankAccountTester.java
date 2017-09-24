//****************************************
//  BankAccountTester.java
//  
//  This class constructs a bank account, deposits $1,000, withdraws $500, withdraws another $400,
//  and prints the remaining balance and expected result. 
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class BankAccountTester
{
    public static void main(String[] args) 
    {
        
    BankAccount Tester = new BankAccount("Sean", 1234);
        Tester.deposit(1000);
        Tester.withdraw(500);
        Tester.withdraw(400);
        double balance = Tester.getBalance();
       System.out.println("Your balance is: " +balance); 
       System.out.println("Expected balance is: 100.00");
                                                                    
    } //closes main
                                                              
} //closes BankAccountTester
