//****************************************
//  E62e.java
//  
//  This class sums odd digits in a user's input integer
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

import java.util.Scanner;

public class E62e
{
  public static void main(String[] args) 
   { 
   Scanner input = new Scanner(System.in);
   System.out.print("What is your input? "); // asks user for input number
   int num = input.nextInt(); //gets input number   
   int sum = 0;
   while (num > 0)         
    {
       int dig = num%10;
       if (dig%2 != 0) 
       {
          sum = sum + dig; // sums odd digits     
       } //closes if statement               
       num = num / 10;    
     } //closes while loop
   System.out.println("The sum is " +sum); 
   } //closes main
       
} //closes E62e
