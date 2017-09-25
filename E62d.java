//****************************************
//  E62d.java
//  
//  This class sums odd numbers between a and b, two user input values
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

import java.util.Scanner;

public class E62d
{
  public static void main(String[] args) 
   { 
   Scanner input = new Scanner(System.in);
   System.out.print("What is your input for a? "); // asks user for input a
      int a = input.nextInt(); //gets input a
   System.out.print("What is your input for b? "); //asks user for input b
      int b = input.nextInt(); //gets input b
   
      int smallNum = Math.min(a, b); //finds small number from inputs
      int bigNum = Math.max(a, b); //finds big number from inputs   
      int sum = 0;
   for (int i = smallNum; i<= bigNum; i++) //for loop from smallNum through bigNum, inclusive, adding by 1 each time   
     {
       if (i%2 != 0) //modulus function to determine if number is odd -- ie. 3mod2 != 0, since 3/2 = 1, remainder 5.
       {
          sum = sum + i;      
       } //closes if statement                   
     } //closes for loop
   System.out.println("The sum is " +sum);
   } //closes main       
} //closes E62d    
