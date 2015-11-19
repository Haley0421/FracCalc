package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner scan = new Scanner(System.in);
    	String scanned=scan.nextLine();
    	System.out.print(produceAnswer(scanned));
    
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String scanned)
    { 
    
    	String second = scanned.substring(scanned.lastIndexOf(" ")+1);
    	String whole=second.substring(0,second.indexOf("_"));
    	String num2=second.substring(second.indexOf("_")+1,second.indexOf("/"));
    	String den2=second.substring(second.indexOf("/")+1);
    	

        return "Whole: "+ whole + "\n" + "Numerator: "+ num2 + "\n" + "Denominator: " + den2 ;
        
		// TODO Auto-generated method stub
	}

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
