/***
* A Credit Card class that tests six requirements for a credit card to determine valid/not valid.
* author: <Sean Kelso>
* date: 9/29/17
***/

public class CreditCard
{
private String number;
private boolean valid;
int errorCode = 0;
String input;
    
 public CreditCard(String i) 
 {
   valid = true;
   input = i;
 }  

   private void check1() //first digit must be a four
   {
     int digOne = Integer.parseInt(input.substring(0,1)); //gets first digit in input
     if(digOne != 4)
     {
       valid = false;
       errorCode = 1;  
     }  
   } //ends check1()
 
   private void check2() //fourth digit must be one greater than the fifth digit  
   {
     int numOne = Integer.parseInt(input.substring(4,5)); //gets fifth digit in input
     int numTwo = Integer.parseInt(input.substring(3,4)); //gets fourth digit in input
     if(numTwo - numOne != 1)
     {
       valid = false;
       errorCode = 2;  
     }  
   } //ends check2()
 
   private void check3() //product of the first, fifth, and ninth digits must = 24
   {
     int prodOne = Integer.parseInt(input.substring(0,1)); //gets first digit in input
     int prodTwo = Integer.parseInt(input.substring(4,5)); //gets fifth digit in input
     int prodThree = Integer.parseInt(input.substring(8,9)); //gets ninth digit in input        
     if((prodOne*prodTwo*prodThree) != 24)
     {
       valid = false;
       errorCode = 3;  
     }  
   } //ends check3()

   private void check4() //sum of all digits must be evenly divisible by 4  
   {
     //int digSum = Integer.parseInt(input.substring(0,12)); //gets all 12 digits
     int iSum = 0; int j;
       for(j=0; j<12; j++) //sums all twelve digits
         {
             iSum += Integer.parseInt(input.substring(j, j+1)); 
         }
       
         if((iSum % 4)!=0) //divides sum of twelve digits by four 
         {
             valid = false;
             errorCode = 4;  
         }          
   } //ends check4()

   private void check5() //sum of the first four digits must be one less than the sum of the last four digits  
   {
     int setOne = Integer.parseInt(input.substring(0,3)); //gets first four digits in input
     int setTwo = Integer.parseInt(input.substring(8,11)); //gets last four digits in input
     int iSumOne = 0; int iSumTwo = 0; int j;
     for(j=0; j<4; j++) //sums first four digits
       {
           iSumOne += Integer.parseInt(input.substring(j, j+1)); 
       }
     for(j=8; j<12; j++) //sums last four digits
       {
           iSumTwo += Integer.parseInt(input.substring(j, j+1)); 
       }
         
       if((iSumTwo - iSumOne)!=1)
         {
            valid = false;
            errorCode = 5;  
         }  
   } //ends check5()

   private void check6() //first two digits = two-digit number, seventh and eight digits = two digit number --> their sum = 100
   {
     //int twodigOne = Integer.parseInt(number.substring(0,2)); //gets first two digits in input
     //int twodigTwo = Integer.parseInt(number.substring(6,8)); //gets seventh and eighth digits in input
     int sumOne = 0; int sumTwo = 0; int j; int y;
     
         sumOne += Integer.parseInt(input.substring(0,2));
         sumTwo += Integer.parseInt(input.substring(6,8));
     
        if((sumOne + sumTwo)!= 100)
        {
            valid = false;
            errorCode = 6;  
        }  
   } //ends check6()
    
      public void check()
     {
       check6();
       check5();
       check4();
       check3();
       check2();
       check1();
     } 
 
   public boolean isValid() //returns value of valid, after all six checks
    {
      return valid;
    } //ends boolean isValid
            
   public int getErrorCode()
    {
       return errorCode;
    } //ends getErrorCode
    
} //closes class CreditCard       
