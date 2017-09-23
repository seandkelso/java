/**
 * This program determines how to provide change, given the amount received
 * and the amount due (total cost).
 * 
 * @author: <Sean Kelso>
 * @date: <Sep 17, 2017>
 */
import java.util.Scanner;

public class Change
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);  // asks user for input
        System.out.print("Hi, what is the total cost? "); 
        int amountDue = input.nextInt(); //gets input for amountDue
        System.out.print("Hi, what is the amount received? "); 
        int amountReceived = input.nextInt(); //gets input for amountReceived
        
        if (amountReceived > amountDue) // so that the customer receives change
        { 
            int change = amountReceived - amountDue;
            int dollarsDue = (change / 100); //100 pennies in one dollar
                change = change - (dollarsDue*100);
            int quartersDue = (change) / 25; //25 pennies in one quarter
                change = change - (quartersDue*25);
            int dimesDue = (change) / 10; //10 pennies in one dime
                change = change - (dimesDue*10);
            int nickelsDue = (change) / 5; //5 pennies in one nickel
                change = change - (nickelsDue*5);
            int penniesDue = (change);
           System.out.printf("Your change is %d dollars, %d quarters, %d dimes, %d nickels, %d pennies! ", dollarsDue, quartersDue, dimesDue, nickelsDue, penniesDue);
        }

        else //(amountReceived < amountDue)
            {
            System.out.printf("Sorry, the cashier needs more money than what you currently have given them! ");
            }   
    }	
}
