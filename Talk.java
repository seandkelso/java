//Sean Kelso(sdk2146) — CS1004 — Talks.java
public class Talk implements Comparable<Talk> 
{ //models a talk, can give title/speaker for a talk + start/stop times of talk
	private String speaker; //speaker title (ie. ironman)
	private int startTime; //startTime of the talk
    private int endTime; //endTime of the talk
	
	public Talk(String s, int t, int e)
    {
		speaker = s;
        startTime = t;
        endTime = e;
	} //ends card 
	
	public int compareTo(Talk other)
    { // compare by endTimes
		int compareResult = -2; //initialize compareResult to a number not used
        if(this.endTime > other.endTime) //earlier endTime
            compareResult = 1; //result is 1
        if(this.endTime < other.endTime) //later endTime
            compareResult = -1; //result is -1
        if(this.endTime == other.endTime)//equal endTime->compare startTimes
            compareResult = 0;
            
        return compareResult;        
	} //ends compareTo
    
    public String toString()
    { //nicely formats my resulting talk schedules
        String stringResult = String.format("%15s", speaker); //add speaker
        stringResult += String.format("%5d", startTime); //add startTime
        stringResult += String.format("%5d", endTime); //add endTime
        
        return stringResult; //return speaker, startTime, endTime          
	} //ends toString

    public int getStart()
    {
        return startTime;
    }
    
    public int getEnd()
    {
        return endTime;
    }
         
} //ends Talks
