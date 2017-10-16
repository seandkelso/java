//Sean Kelso

import java.util.Scanner;
public class ZipTest
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
//Convert from ZIP to bar 
codeSystem.out.println("Please enter a ZIP code: ");
int zip = input.nextInt();input.nextLine();
Zipcode code1 = new Zipcode(zip);System.out.println("The corresponding bar code: ");
System.out.println(code1.getBarcode());
//Convert from bar to ZIP 
codeSystem.out.println("Now please provide a bar code: ");
String bar = input.nextLine();
Zipcode code2 = new Zipcode(bar);
System.out.println("The corresponding ZIP code: ");
System.out.println(code2.getZIPcode());
}
}

//Zipcode class — converts: 1) zipcode to barcode, 2) barcode to zipcode

public class Zipcode 
{
    private int intZip; //instantiate intZip
    private String stringZip; //instantiate stringZip
    
// ——— TWO PARTS of Zipcode: 1) zipcode(an int) to barcode(a string); 2) barcode(a string) to zipcode(an int) ——— //  
    
    public Zipcode(int zip) //PART A: ZIPCODE TO BARCODE
    {
        stringZip = ziptoDig(zip); //calls ziptoDig on the given input(zip) and stores in stringZip
        intZip = zip; // intZip is the resulting zipcode, from the given barcode
    } //closes zipcode to barcode
     
    public Zipcode(String barcode) //PART B: BARCODE TO ZIPCODE
    { 
        intZip = barcodetoZip(barcode); //calls barcodetoZip on the given input(barcode) and stores in intZip
        stringZip = barcode; // stringZip is the resulting barcode, from the given zipcode
    } //closes barcode to zipcode
    
// ———— PART A: ZIPCODE TO BARCODE ———— //
        
    public int checkDig(int zip)
    {
        int dig1; int dig2; int dig3; int dig4; int dig5; int sum; int checkDig; //instantiate dig1-dig5, sum, checkDig
        dig1 = (zip / 10000); //leftmost digit
        dig2 = (zip / 1000) - (dig1*10); //2nd leftmost digit
        dig3 = (zip / 100) - (dig1*100 + dig2*10); //middle digit
        dig4 = (zip / 10) - (dig1*1000 + dig2*100 + dig3*10); //second rightmost digit
        dig5 = (zip / 1) - (dig1*10000 + dig2*1000 + dig3*100 + dig4*10); //rightmost digit
        sum = dig1 + dig2 + dig3 + dig4 + dig5;
        checkDig = 10 - (sum % 10);
        return checkDig;
    } //closes checkDig
    
  public String ziptoDig(int zip) //converts a zip code to a digit
  {
     int zipCode = zip; 
     int dividend = 10000; //starts at far left of zip code (10000th place)
     int currDig = 0; //start at leftmost digit in the for loop below
     String resultBarCode = ""; 
     for(int i=0; i<5; i++) //for loop for the 5 digits of the zip code 
     {
         currDig = zipCode / dividend; 
         resultBarCode += digtoBarcode(currDig); //calls digtoBarcode, adds to resultBarCode
         zipCode = zipCode % dividend; //increment right to the next digit
         dividend = dividend / 10; //update dividend so zipCode keeps moving right (ie. 10000 becomes 1000 for next cycle)
     }
     resultBarCode += digtoBarcode(checkDig(zip)); //adds the checkDigit to the resultBarCode
     return "|" + resultBarCode + "|"; //properly formats resultBarCode to include bars before and after the result barcode
  }
    
  public String digtoBarcode(int digit) //convert a digit to its corresponding barcode string
  {
    String result = ""; //instantiate result
    if(digit == 0) 
        result = "||:::";
    if(digit == 1)
        result = ":::||";
    if(digit == 2)
        result = "::|:|";
    if(digit == 3)
        result = "::||:";
    if(digit == 4)
        result = ":|::|";
    if(digit == 5)
        result = ":|:|:";
    if(digit == 6)
        result = ":||::";
    if(digit == 7)
        result = "|:::|";
    if(digit == 8)
        result = "|::|:";
    if(digit == 9)
        result = "|:|::"; 
   return result; 
  } //ends digtoBarcode
    
  public String getBarcode()
  {
    return stringZip; //stringZip is the resulting barcode produced by ziptoDig
  } //ends getBarcode
    
// ———— PART B: BARCODE TO ZIPCODE ———— //
       
 public int barcodetoDig(String barcode) //converts from barcode string to its corresponding digit
 {     
    int codeDig = -1; //initialize codeDig to -1 for testing purposes (since a negative zipcode means something's wrong)
    if(barcode.equals("||:::")) //.equals to compare strings
        codeDig = 0;
    if(barcode.equals(":::||"))
        codeDig = 1;
    if(barcode.equals("::|:|"))
        codeDig = 2;
    if(barcode.equals("::||:"))
        codeDig = 3;
    if(barcode.equals(":|::|"))
        codeDig = 4;
    if(barcode.equals(":|:|:"))
        codeDig = 5;
    if(barcode.equals(":||::"))
        codeDig = 6;
    if(barcode.equals("|:::|"))
        codeDig = 7;
    if(barcode.equals("|::|:"))
        codeDig = 8;
    if(barcode.equals("|:|::"))
        codeDig = 9;
    return codeDig;
 } //ends barcodetoDig

 public int barcodetoZip(String barcode)  //convert from a barcode string to a zipCode int
 {
     int digOne; int digTwo; int digThree; int digFour; int digFive; int digSum; //instantiate digOne-digFive, digSum
     String one = barcode.substring(1,6); //first five bars of barcode --IGNORE the first bar since it is not part of zip
          digOne = barcodetoDig(one); //gets first digit of zipcode
     String two = barcode.substring(6,11); //next five bars of barcode
          digTwo = barcodetoDig(two); //gets second digit of zipcode
     String three = barcode.substring(11,16); //next five bars of barcode
          digThree = barcodetoDig(three); //gets third digit of zipcode
     String four = barcode.substring(16,21); //next five bars of barcode
          digFour = barcodetoDig(four); //gets fourth digit of zipcode
     String five = barcode.substring(21,26); //last five bars of barcode --IGNORE last bar since it is not part of zip
          digFive = barcodetoDig(five); //gets fifth digit of zipcode
     int digSum = (digOne*10000) + (digTwo*1000) + (digThree*100) + (digFour*10) + (digFive*1); //sums digits to be 1 zipcode  
     return digSum;
 } //ends barcodetoZip
     
 public int getZIPcode()
 {
     return intZip; //intZip is the resulting zipcode produced by barcodetoZip
 } //ends getBarcode
    
} //ends class zipCode
