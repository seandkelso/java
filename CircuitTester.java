//****************************************
//  CircuitTester.java
//  
//  This class tests all Circuit combinations.
//
//  Author: Sean Kelso
//  Date: 9/23/17
//*****************************************

public class CircuitTester
{
    public static void main(String[] args) 
    {
        
    Circuit testerOne = new Circuit(0, 0, 0); //First Case -- toggle first, then second
       System.out.println("\n FIRST CASE: toggle first switch state, then second switch state.");
       testerOne.toggleFirstSwitch();
       testerOne.toggleSecondSwitch();
       System.out.println("Actual first switch state: " +(testerOne.getFirstSwitchState()) ); 
       System.out.println("Actual second switch state: " +(testerOne.getSecondSwitchState()) );
       System.out.println("Actual lamp state: " +(testerOne.getLampState()) );                 
       System.out.println("Expected first switch state: 1"); 
       System.out.println("Expected second switch state: 1"); 
       System.out.println("Expected lamp state: 0"); 
        
    Circuit testerTwo = new Circuit(0, 0, 0); //Second Case -- toggle second, then first
       System.out.println("\n SECOND CASE: toggle second switch state, then first switch state.");
       testerTwo.toggleSecondSwitch();
       testerTwo.toggleFirstSwitch();
       System.out.println("Actual first switch state: " +(testerTwo.getFirstSwitchState()) ); 
       System.out.println("Actual second switch state: " +(testerTwo.getSecondSwitchState()) );
       System.out.println("Actual lamp state: " +(testerOne.getLampState()) );                 
       System.out.println("Expected first switch state: 1"); 
       System.out.println("Expected second switch state: 1"); 
       System.out.println("Expected lamp state: 0"); 
        
     Circuit testerThree = new Circuit(0, 0, 0); //Third Case -- toggle first, then first
       System.out.println("\n THIRD CASE: toggle first switch state, then first switch state.");
       testerThree.toggleFirstSwitch();
       testerThree.toggleFirstSwitch();
       System.out.println("Actual first switch state: " +(testerThree.getFirstSwitchState()) ); 
       System.out.println("Actual second switch state: " +(testerThree.getSecondSwitchState()) );
       System.out.println("Actual lamp state: " +(testerOne.getLampState()) );                 
       System.out.println("Expected first switch state: 0"); 
       System.out.println("Expected second switch state: 0"); 
       System.out.println("Expected lamp state: 0"); 
        
      Circuit testerFour = new Circuit(0, 0, 0); //Fourth Case -- toggle second, then second
       System.out.println("\n FOURTH CASE: toggle second switch state, then second switch state.");
       testerFour.toggleSecondSwitch();
       testerFour.toggleSecondSwitch();
       System.out.println("Actual first switch state: " +(testerFour.getFirstSwitchState()) ); 
       System.out.println("Actual second switch state: " +(testerFour.getSecondSwitchState()) );
       System.out.println("Actual lamp state: " +(testerOne.getLampState()) );                 
       System.out.println("Expected first switch state: 0"); 
       System.out.println("Expected second switch state: 0"); 
       System.out.println("Expected lamp state: 0"); 
                                                                      
    } //closes main                                                              
} //closes CircuitTester
