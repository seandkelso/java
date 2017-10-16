import java.util.Scanner;

public class Nim{
    public static void main(String[] args){
        
        System.out.println("Welcome to Nim death match!");
        
        Scanner input = new Scanner(System.in);
        System.out.println("What difficulty level do you want to play at 1/2?");
        int level = input.nextInt();
        Game g = new Game(level);
        g.play();
        System.out.println("Thanks for playing!");
    }
}

public class Game
{
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    public Game(int difficulty)
    {
        humanPlayer = new Human();
        computerPlayer = new Computer(difficulty);
        
        marbles = (int)(( (Math.random())*91 )+10); //num btwn 10 and 100
                
    } //end of Game constructor
     
    public void play()
    {
        int firstMove = (int)(Math.random()*2); //rounds a random value between 0 and 1 to determine who goes first
        System.out.println("Marbles left is: " +marbles); //prints initial number of marbles
        int result = firstMove; 
        
        while( marbles > 1)
        {
            
            if(result == 0) //human player goes
            { 
                humanPlayer.move(marbles);
                marbles -= humanPlayer.getChoice();
                result = 1;
                System.out.println("Marbles left is: " +marbles); //prints remaining marbles after human move
                
            } //end of human's turn
            
            else //computer player goes (firstMove = 1)
            {   
                computerPlayer.move(marbles);
                marbles -= computerPlayer.getChoice();
                result = 0; // switches to next player
                System.out.println(". Marbles left is: " +marbles); //prints remaining marbles after computer move
            } //end of computer's turn    
            
        } //end of while loop
        
        if(marbles <= 1) //last turn
        {
            if(result == 1) //computer has the last pick
                System.out.println("YOU WIN!"); //human wins
            else
                System.out.println("YOU LOSE!"); //computer wins
        }
    } //end of Play constructor
   
} //end of Game class

public class Computer
{ 
    private int mode;
    private int choice;
    
    public Computer(int m)
    {
        mode = m;
        choice = -1;
    }
 
    
    public void move(int marblesLeft)
    {
        System.out.println("It is the computer's turn! ");
        int compDiff = (int)(Math.random()*2); //rounds a random value between 0 and 1 to determine computer difficulty
            if(compDiff == 0)
                mode = 0; //stupid mode
            else
                mode = 1; //smart mode
        
        if(mode == 1) //smart mode
        {   
            int goal = (int)(Math.pow((Math.log(marblesLeft) / Math.log(2)), 2) -1); //(logbase2 of marblesLeft)^2 -1 = goal
            if( goal != marblesLeft) //
            {
                choice = marblesLeft - goal; 
                System.out.print("The computer chose " +choice);
            }
            else //power of 2 - marbles left = 1
            {
                choice = (int)(( (Math.random())*1 )+ marblesLeft/2);  
                System.out.print("The computer chose " +choice);
            }
        }
        else //stupid mode
        {
            choice = (int)(( (Math.random())*1 )+ marblesLeft/2); //random num btwn 1 and n/2  
            System.out.print("The computer chose " +choice);
        }
    } //ends constructor Move
    
    public int getChoice()
    {
        return choice;
    } //ends getChoice      
} //ends class Computer

import java.util.Scanner;

public class Human
{
    Scanner input = new Scanner(System.in);
    private int choice;
    
    public Human()
    {
        choice = -1;
    }
    
    public void move(int marbles)
    {
        System.out.println("Select a valid number of marbles from 1 to marbles/2.");  
        choice = input.nextInt(); 
        
        while((choice<1) || (choice>(marbles/2))) //human pick >1 and <= half of marbles  
        {
            System.out.println("Select a valid number of marbles from 1 to marbles/2.");  
            choice = input.nextInt(); 
        }           
    } //closes move
    
    public int getChoice()
    {
        return choice;
    }   
}
