/**
 * This program determines whether a given year is a leap year—NOTE: compile LeapYearTester to run this.
 * 
 * @author: <Sean Kelso>
 * @date: <Sep 17, 2017>
 */
import java.util.Scanner;

public class LeapYear
{
 int year;
    
        public LeapYear() //LeapYear constructor
        {
            Scanner input = new Scanner(System.in);  // asks user for input
            System.out.print("Hi, what year would you like to check for leapyear-hood? "); 
            year =  input.nextInt(); //gets input for leapYear  
        }
        
        public boolean isLeapYear() //isLeapYear method
        {
            if   ( ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ) // input is a leap year: modulus = 0 means no remainder
            {return true;
            }   
            else // input is NOT a leap year
            {return false;
            } 
        } //closes boolean isLeapYear

} //closes class LeapYear
    
