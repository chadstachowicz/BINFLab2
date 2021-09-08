package lab;

import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class quiz {
	
	/**
	* Application quizzes the user on Amino Acids
	* @param  seconds  first param - amount of seconds to run quiz for
	* @return      voice
	*/
	public static void main(String args[])
	{
		//get current system time
		long startTime = System.currentTimeMillis();
		//set starting variables and values
		long elapsedTime = 0L;
		boolean wrongAnswer = false;
		int correctAnswers = 0;
		int time = 30;
		
		//create a scanner for input
	    @SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
	    
	    //check if I have an argument - if so it's the time (seconds)
	    if (args.length > 0) {
	    	//set time to arg instead of 30
	    	time = Integer.parseInt(args[0]);
	    }
	    //do a while loop chekcing time and for a wrong answer
		while (elapsedTime < time*1000 && wrongAnswer==false) {
			
			//create a random number 0-19 for working with the arrays
			Random random = new Random();
			int num = random.nextInt(20);
			
			//retrieve our full name and short code from array
			String testAmino = FULL_NAMES[num];
			String shortAmino = SHORT_NAMES[num];
			
			//present the amino acid to the user
		    System.out.println(testAmino);
		    String aminoAcid = myObj.nextLine();  // Read user input
		    //check if they entered the word quit
		    if (aminoAcid.toLowerCase().equals("quit"))
		    {
		    	//quit and return
		    	System.out.println("User chose to quit the quiz.");
		    	return;
		    }
		    //check if the amino acid entered is correct (downcase them both so case doesn't matter)
		    if(!(aminoAcid.toLowerCase()).equals(shortAmino.toLowerCase()))
		    {
		    	//notify the user they are wrong an exit the loop
		    	System.out.println("You entered a wrong answer. The correct answer was " + shortAmino.toLowerCase());
		    	wrongAnswer = true;
		    } else {
		    	//increment our correct answer total
		    	correctAnswers++;
		    }
		    //check how much time has been elapsed
		    elapsedTime = (new Date()).getTime() - startTime;
		    System.out.println("");
		}
		//close the scanned object
	    myObj.close();
	    
	    //print out results to our users
		System.out.println("The quiz is over. You either entered a wrong answer or your " + time + " seconds is up.");
		System.out.println("");
		System.out.println("Your score was: " + correctAnswers);
	}
	
	public static String[] SHORT_NAMES = 
		{ "A","R", "N", "D", "C", "Q", "E", 
		"G",  "H", "I", "L", "K", "M", "F", 
		"P", "S", "T", "W", "Y", "V" 
		};

	public static String[] FULL_NAMES = 
		{
		"alanine","arginine", "asparagine", 
		"aspartic acid", "cysteine",
		"glutamine",  "glutamic acid",
		"glycine" ,"histidine","isoleucine",
		"leucine",  "lysine", "methionine", 
		"phenylalanine", "proline", 
		"serine","threonine","tryptophan", 
		"tyrosine", "valine"
		};
	


}
