//****************************************
//  E62b.java
//  
//  This class calculates the sum of all squares between 1 and 100, inclusive
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class E62b 
{
  public static void main(String[] args) 
   { 
   double sum = 0;
   int i = 1; //start at 1
    while (i<= 100) //while loop: since 100 is the max for the squares, 10 is the last number (10 squared = 100) 
    {
        sum = sum + (Math.pow(i, 2)); //sums the squared values of i
        i++; //increments i by 1
    } //closes while loop           
    System.out.println("The sum of all squares between 1 and 100 is " +sum);     
   } //closes main
       
} //closes E62b 
