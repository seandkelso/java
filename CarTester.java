//****************************************
//  CarTester.java
//  
//  This class tests all methods from my Car class.
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************
import java.util.Scanner;

public class CarTester
{
    public static void main(String[] args) 
    {
     Scanner input = new Scanner(System.in);  // asks user for input 
     System.out.print("Hi, what is car's fuel efficiency, in miles per gallon? "); 
        int efficiency = input.nextInt(); //gets input for fuel efficiency
     System.out.print("Hi, How much gas would you like to add? "); 
        int gas = input.nextInt(); //gets input for gas added
     System.out.print("Hi, what is the distance you would like to drive? "); 
        int distance = input.nextInt(); //gets input for distance user would like to drive car
      
     Car Driver = new Car(efficiency);
     Driver.addGas(gas);
     Driver.drive(distance);
     int gasLeft = Driver.getGasInTank();
        
       System.out.print("You have " +gasLeft);
       System.out.println(" miles left in your car!"); 
                                                                    
    } //closes main
                                                              
} //closes CarTester
