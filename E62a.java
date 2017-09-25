//****************************************
//  E62a.java
//  
//  This class sums all even numbers from 2 through 100, inclusive
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class E62a 
{
  public static void main(String[] args) 
   { 
   int sum = 0;
   for (int i=2; i<=100; i++) //for loop from 2 through 100, inclusive, adding by 1 each time   
     {if (i%2 == 0) //modulus function to determine if number is even -- ie. 4mod2 = 0, since 4/2 = 2, remainder 0.
       {
          sum = sum + i;      
       } //closes if statement               
           
     } //closes for loop
   System.out.println("The sum is " +sum);
   } //closes main
       
} //closes E62a                  
