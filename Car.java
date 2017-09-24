//****************************************
//  Car.java
//  
//  This constructor takes a fuelEfficiency and creates methods drive, addGas, getGasInTank for that car
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class Car
{
   private int fuel;
   private int efficiency;
  
    public Car(int mpgEfficiency) //efficiency, in miles per gallon
    {
        fuel = 0; //fuel starts at 0
        efficiency = mpgEfficiency;
    } //closes Car constructor
    
        public void drive(int distance) //method Drive   
        {
            fuel = fuel - (distance / efficiency); //fuel left = fuel before - fuelUsed
        } //closes drive
       
        public void addGas(int amt) //method addGas
        {   
            fuel = fuel + amt; //fuel = fuel before + fuel added
        } //closes addGas
       
        public int getGasInTank() //method getGasInTank
        { 
            return fuel; //gas in tank = fuel
        } //closes getGasInTank
      
} //closes Car
