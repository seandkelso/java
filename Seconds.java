/**
 * This program converts a number of hours, days, and years into seconds.
 * 
 * @author: <Sean Kelso>
 * @date: <Sep 17, 2017>
 */
import java.util.Scanner;

public class Seconds
{   
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);  // asks user for input
        System.out.print("Hi, how many hours would you like me to calculate? "); 
            int numHours =  input.nextInt(); //gets input for numHours
        System.out.print("Hi, how many days would you like me to calculate? "); 
            int numDays =  input.nextInt(); //gets input for numDays
        System.out.print("Hi, how many years would you like me to calculate? "); 
            int numYears =  input.nextInt(); //gets input for numYears
        
        int totalSecs = (numHours*3600) + (numDays*86400) + (numYears*31536000) ; //computes the totalSecs by summing numHours, numDays, numYears
            System.out.printf("Your input is %d seconds! ", totalSecs) ; //prints the total amount of seconds that the user input   
    }   
}
