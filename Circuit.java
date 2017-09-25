//****************************************
//  Circuit.java
//  
//  This class models a Circuit (off/on of switches and the result on the off/on status of the lamp).
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class Circuit
{
    private int firstSwitchState; private int secondSwitchState; private int lampState;  
    public Circuit(int firstSwitch, int secondSwitch, int lampStatus)
   {
        firstSwitchState = firstSwitch;
        secondSwitchState = secondSwitch;
        lampState = lampStatus;
   } //closes Circuit constructor   
        
        public int getFirstSwitchState() 
        {
            return firstSwitchState; //assigns value to the firstSwitchState variable
        }  //closes getFirstSwitchState
    
        public int getSecondSwitchState() 
        {
            return secondSwitchState; //assigns value to the secondSwitchState variable
        }  //closes getSecondSwitchState
    
        public int getLampState() 
        {
            return lampState;
        } //closes getlampState
    
        public void toggleFirstSwitch() 
        {
            if ( (firstSwitchState == 0) ) //firstSwitch is down
            { 
                firstSwitchState = 1; //switches to up
            
                if (lampState == 0) //lamp is off
                 
                    lampState = 1; //lamp is on
               
                else if (lampState == 1) //lamp is on
                
                    lampState = 0; //lamp is off
                }
            
            else if ( (firstSwitchState == 1) ) //firstSwitch is up
            {
                firstSwitchState = 0; //switches to down
           
                if (lampState == 0) //lamp is off
                  
                    lampState = 1; //lamp is on
                
                else if (lampState == 1) //lamp is on
                
                    lampState = 0; //lamp is off
                }
        } //closes toggleFirstSwitch
    
        public void toggleSecondSwitch() 
        {
            if ( (secondSwitchState == 0) ) //secondSwitch is down
            { 
                secondSwitchState = 1; //switches to up
            
                if (lampState == 0) //lamp is off
                
                    lampState = 1; //lamp is on
                
                else if (lampState == 1) //lamp is on
                
                    lampState = 0; //lamp is off
                }
            
            else if ( (secondSwitchState == 1) ) //secondSwitch is up
            {
                secondSwitchState = 0; //switches to down
             
                if (lampState == 0) //lamp is off
                
                    lampState = 1; //lamp is on
                
                else if (lampState == 1) //lamp is on
                
                    lampState = 0; //lamp is off
                }            
        } //closes toggleSecondSwitch
        
} //closes Circuit
