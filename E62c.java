//****************************************
//  E62c.java
//  
//  This class prints all powers of 2 from (2^0) to (2^20)
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class E62c
{
  public static void main(String[] args) 
   { 
   int i = 0; //start at 0
    while (i<= 20) //while loop: since 20 is the max power, go up to 20 
    {
        i++; //keeps incrementing i by 1
        System.out.println(Math.pow(2, i)); //prints each result
    } //closes while loop           
   } //closes main
       
} //closes E62c
