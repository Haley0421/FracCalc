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
if (!frac.contains("_") && !frac.contains("/")){
	whole=frac;
}
else
	whole="0";
if (frac.contains("_"))
{ whole=frac.substring(0,frac.indexOf("_"));}
String num="";
String den="";
if (frac.contains("/"))
	{num=frac.substring(frac.indexOf("_")+1,frac.indexOf("/"));
	den=frac.substring(frac.indexOf("/")+1);}
	 else {
	    	num="0";
			den="0";}
    String[] splitfraction = {whole,num,den};
   
    return splitfraction;
    }

    public static int greatestcommon (int num,int den){
    	while (den > 0){
    		int x = den;
    		den = num % den;
    		num = x;
    	}
    	return num;
    }
    public static int[] reduce(int top, int den){
    	 int gcf = greatestcommon(top, den);
    	 int [] rf = {top/gcf, den/gcf};
    	   
		return rf;}
    
		
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
    	int top1 = 0;
    	int top2 = 0;
    	int top=0;
    	int den=0;
    	String second = scanned.substring(scanned.lastIndexOf(" ")+1);
    	String first = scanned.substring(0,(scanned.indexOf(" ")));
    	String sign = scanned.substring(scanned.indexOf(" ")+1,scanned.lastIndexOf(" "));
    	String[] secondsplit = splitfraction(second);
    	String[] firstsplit = splitfraction(first); 
    	if ((sign.equals("+") || sign.equals("-")) && (Integer.valueOf(firstsplit[2])==0 || Integer.valueOf(firstsplit[1])==0)){
    	top=Integer.valueOf(secondsplit[1]);
    	den=Integer.valueOf(secondsplit[2]);}
    	else{
    	den = Integer.valueOf(firstsplit[2])*Integer.valueOf(secondsplit[2]);
    	if (Integer.valueOf(firstsplit[1])!=0 || Integer.valueOf(secondsplit[2])!=0){
    		top1 = Integer.valueOf(firstsplit[1])*Integer.valueOf(secondsplit[2]);}
    	
    	if (Integer.valueOf(firstsplit[2])!=0 || Integer.valueOf(secondsplit[1])!=0){
    		top2 = Integer.valueOf(firstsplit[2])*Integer.valueOf(secondsplit[1]);}}
        System.out.println(top1);
        System.out.println(top2);
        System.out.println(den);
        
        int div=0;
    	
    	int whole = 0;
    	int temp1;
    	
        if (sign.equals("+"))
        	if(top!=0)
        	{whole = Integer.valueOf(firstsplit[0])+Integer.valueOf(secondsplit[0]);
        	System.out.println(whole);}
        	else
    			{top = top1 + top2;
    	    	 whole = Integer.valueOf(firstsplit[0])+Integer.valueOf(secondsplit[0]);
    	    	 System.out.println(whole);
    	    	 }
        
        
        
    	if (sign.equals("*")){
        	 whole = Integer.valueOf(firstsplit[0])*Integer.valueOf(secondsplit[0]);   
        	 den = den*den;
       		top = top1*top2;
       		System.out.println("after");
       		System.out.println(top);
        	System.out.println(whole);
        	System.out.println(den);
       		
       		}
    	
    
    	
    	
    	if (sign.equals("/")){
    		if(Integer.valueOf(firstsplit[0])!=0  ||  Integer.valueOf(secondsplit[0])!=0)
    		{ whole = Integer.valueOf(firstsplit[0])/Integer.valueOf(secondsplit[0]);}
    		den*=top1;
    		top=top2*den;
    		}
    	
    	
    	
    	if (sign.equals("-")){
    		if(top!=0)
    	{}
    	else{
        	whole = Integer.valueOf(firstsplit[0])-Integer.valueOf(secondsplit[0]);
        	top = top1-top2;}}
    	
        	
    	int temp = 0;
    	
    	if (top!=0 && den!=0){
    		if (top % den==0) {
    		temp = top/den;
    		whole += temp;
    
    		top=0;
    		den=0;}
    	else{
    		if (sign.equals("*")){
        		top=whole*top;
        	}}
    	}
    	System.out.println(top);
    	System.out.println(whole);
    	System.out.println(den);
    	if(top != 0 && den != 0) {
    		int[] reduce = reduce(top,den);  
    		top = reduce[0];
    		den = reduce[1];
    		System.out.println("here");
    		System.out.println(top);
    		System.out.println(den);
    	}
    if(top>0){
    	while (top>den){
    		top=top-den;
    		whole++;
    	}}
    if(top<0){
    	while(top<den){
    		top=top+den;
    		whole--;
    	}
    }
    	String fract = "";
    	if (top==0){
    		fract = "" + whole;}
    	if (whole == 0 && top!=0)
    		fract = top + "/" + den;
    	if (whole==0 && top==0){
    		fract="0";}
    	if (whole != 0 && top!=0){
    		fract= whole + "_" + top + "/" + den;
		// TODO Auto-generated method stu
		}
		return fract;}}


    // TODO: Fill in the space below with any helper methods that you think you will need
    

