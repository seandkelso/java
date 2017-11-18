//Sean Kelso(sdk2146) — CS1004 — Scheduler.java
import java.util.*; 
import java.io.*;

public class Scheduler 
{ //repository for static methods used to schedule the talks
  public static String fileName;  
  public static ArrayList<Talk> makeTalks(String fileName) throws IOException //creating talks, not scheduling them 
  {     
     ArrayList<Talk> talkList = new ArrayList<Talk>(); 
     try
     {
         File inFile = new File("talks.txt");
         Scanner input = new Scanner(inFile);
         String line;    
         while (input.hasNext())
         { 
             line = input.nextLine();         
          String[] temp = line.split("\\s+"); 
          //splits temp based on whitespace
          String listName = temp[0]; //accesses the name of the talk           
          int startTime = Integer.parseInt(temp[1]); //accesses startTime
          int endTime = Integer.parseInt(temp[2]); //accesses endTime 
          Talk t = new Talk(listName, startTime, endTime); //new Talk object 
          talkList.add(t); //adds talk object t to the talkList
      }  
     input.close(); //closes input file        
     } //ends Try
     catch(FileNotFoundException e)
     {
           System.out.println(e);
     }
      
   return talkList;
 } //ends makeTalks
    
  public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talkList) 
  {
      Collections.sort(talkList); //sort the array of talks
      //System.out.println(talkList); 
      ArrayList<Talk> resultList = new ArrayList<Talk>();     
      int i=0; //earliest endTime
      resultList.add(talkList.get(i));

      for(int j=1; j<talkList.size(); j++)
      {
          if(talkList.get(i).getEnd() <= talkList.get(j).getStart())
          { //if endTime of one talk < startTime of next talk, ADD next
              resultList.add(talkList.get(j));
              i = j; //increment
          }          
      }
  
      return resultList;
  } //ends scheduleTalks
     
} //ends Scheduler
