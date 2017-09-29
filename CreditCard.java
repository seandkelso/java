/***
*  A Credit Card class that tests six requirements for a credit card to determine valid/not valid.
* author: <Sean Kelso>
* date: 9/29/17
***/

public class CreditCard
{
private String number;
private boolean valid;
int ErrorCode = 0;

 public CreditCard(String i) 
 {
   input = i;
   valid = true;
 }  
    
   public void check()
     {
       check1();
       check2();
       check3();
       check4();
       check5();
       check6();
     }

   private void check1(); //first digit must be a four
   {
     int digOne = Integer.parseInt(number.substring(0)) //gets first digit in input
     if(digOne != 4)
     {
       valid = false;
       errorCode = 1;  
     }  
   } //ends check1()
 
   private void check2(); //fourth digit must be one greater than the fifth digit  
   {
     int numOne = Integer.parseInt(number.substring(4)) //gets fifth digit in input
     int numTwo = Integer.parseInt(number.substring(3)) //gets fourth digit in input
     if(numTwo - numOne != 1)
     {
       valid = false;
       errorCode = 2;  
     }  
   } //ends check2()
 
   private void check3(); //product of the first, fifth, and ninth digits must = 24
   {
     int prodOne = Integer.parseInt(number.substring(0)) //gets first digit in input
     int prodTwo = Integer.parseInt(number.substring(4)) //gets fifth digit in input
     int prodThree = Integer.parseInt(number.substring(8)) //gets ninth digit in input        
     if(prodOne*prodTwo*prodThree != 24)
     {
       valid = false;
       errorCode = 3;  
     }  
   } //ends check3()

   private void check4(); //sum of all digits must be evenly divisible by 4  
   {
     int digSum = Integer.parseInt(number.substring(0,12)) //gets all 12 digits
     if((sum(digSum)%4)!=0) 
     {
       valid = false;
       errorCode = 4;  
     }  
        
   } //ends check4()

   private void check5(); //sum of the first four digits must be one less than the sum of the last four digits  
   {
     int setOne = Integer.parseInt(number.substring(0,3)) //gets first four digits in input
     int setTwo = Integer.parseInt(number.substring(9,12)) //gets last four digits in input
     if((sum(setTwo) - sum(setOne))!=1)
     {
       valid = false;
       errorCode = 5;  
     }  
   } //ends check5()

   private void check6(); //first two digits = two-digit number, seventh and eight digits = two digit number --> their sum = 100
   {
     int twodigOne = Integer.parseInt(number.substring(0,1)) //gets first two digits in input
     int twodigTwo = Integer.parseInt(number.substring(6,7)) //gets seventh and eighth digits in input
     if((sum(twodigOne) + sum(twodigTwo)) != 100)
     {
       valid = false;
       errorCode = 6;  
     }  
   } //ends check6()
 
   public boolean isValid() //returns value of boolean check
    {
      return check();
    } //ends boolean isValid
            
   public boolean getErrorCode()
    {
       return errorCode;
    } //ends getErrorCode
    
} //closes class CreditCard                        
