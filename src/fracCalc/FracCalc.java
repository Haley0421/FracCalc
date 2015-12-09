package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner scan = new Scanner(System.in);    			
    	String scanned=scan.nextLine();
    	if (scanned != "quit"){
       	System.out.print(produceAnswer(scanned));}
    
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    public static String[] splitfraction(String input)
    {String frac=input;
	String whole="";
if (frac.contains("_"))
	{ whole=frac.substring(0,frac.indexOf("_"));}
else{
	  whole="0";}
String num="";
String den="";
if (frac.contains("/"))
	{num=frac.substring(frac.indexOf("_")+1,frac.indexOf("/"));
	den=frac.substring(frac.indexOf("/")+1);}
    String[]splitfraction = {whole,num,den};
    return splitfraction;}

    public static int greatestcommon (int num,int den1){
    	while (den1 > 0){
    		int x = den1;
    		den1 = num % den1;
    		num = x;
    	}
    	return num;
    }
    public static int[] reduce(int num, int den){
    	int greatest = greatestcommon(num, den);
    	int[]reduced = {num/greatest, den/greatest};
    	return reduced;
    }
		
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String scanned)
    { 
    	int num = 0;
    	String second = scanned.substring(scanned.lastIndexOf(" ")+1);
    	String first = scanned.substring(0,(scanned.indexOf(" ")));
    	String sign = scanned.substring(scanned.indexOf(" ")+1,scanned.lastIndexOf(" "));
    	String[] secondsplit = splitfraction(second);
    	String[] firstsplit = splitfraction(first);
    	Integer whole = Integer.valueOf(firstsplit[0])+Integer.valueOf(secondsplit[0]);
    	Integer den = Integer.valueOf(firstsplit[2])*Integer.valueOf(secondsplit[2]);
        Integer top1 = Integer.valueOf(firstsplit[1])*Integer.valueOf(secondsplit[2]);
        Integer top2 = Integer.valueOf(firstsplit[2])*Integer.valueOf(secondsplit[1]);
    	int div=0;
    	int top = 0;
        if (sign == "+")
    			top = top1+top2;
    	if (sign == "*")
    		top = top1*top2;
    	if (sign == "/"){
    		top = top1;
    		den = top2;}
    	if (sign == "-")
    		top = top1-top2;
    	if (top % den==0) {
    		whole += top/den;
    		top=0;
    		den=0;
    	}
    		
   
    	int[] reduce = reduce(top,den);  	
    	String fract = "";
    	if (reduce[0]==0)
    		fract = "" + whole;
    	if (whole == 0)
    		fract = reduce[0] + "/" + reduce[1];
    	if (whole==0 & reduce[0]==0)
    		fract="0";
    	if (whole != 0 & reduce[0]!=0){
    		fract= whole + "_" + reduce[0] + "/" + reduce[1];
		// TODO Auto-generated method stu
		}
		return fract;}}

    // TODO: Fill in the space below with any helper methods that you think you will need
    

