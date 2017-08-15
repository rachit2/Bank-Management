import java.util.Scanner;
import java.text.NumberFormat;  // imports the NumberFormat class so that outputs may be diplayed in currency format
 
public class BankLoan
{
   //-----------------------------------------------------------------
   //  A comment that must be replaced by comment(s) describing the    //  program's main method.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
     
    float StartBal,     //the initial loan balance
        APR,            //the annual percentage rate
        monthlyRate,    //the monthly percentage rate
        monthlyPmt,     //the amount of the monthly payment
        remainingBal;   //the remaining balance after "x" (curMonth) number of payments have been made
    int NumMonths,      //the total number of months payments
        curMonth = 0;
     Scanner in=new Scanner(System.in);
    System.out.println ("Bank Loan Calculator");    //Prints program title
    System.out.println ();
     
    System.out.print ("Enter initial loan balance in dollars and cents, e.g., 10575.50: "); // prompts user for initial loan balance
    StartBal = in.nextFloat();    //inputs user response to variable StartBal for the initial loan balance
     
    System.out.print ("Enter annual interest rate as a percent value (with decimal but no % sign): "); // prompts user for annual interest rate
    APR = in.nextFloat(); // inputs user response to variable APR for the annual percentage rate
     
    monthlyRate = ((APR / 100) / 12); // computes the monthly interest rate to variable monthlyRate
     
    System.out.print ("Enter total number of months for the loan: "); //prompts user for total number of months (payments) for the loan
    NumMonths = in.nextInt(); //inputes user response to variable NumMonths for the number of payments
     
    monthlyPmt = (float)((monthlyRate * StartBal) / (1.0-(Math.pow((1.0 + monthlyRate),(curMonth-NumMonths)))));    //calculates the monthly payment
     
    NumberFormat currency = NumberFormat.getCurrencyInstance(); //defines the variable currency as a format of converting text to currency format
     
    System.out.print ("Monthly Payment : " + currency.format(monthlyPmt) );  //outputs the monthly payment on the screen in currency format
     
    System.out.println ();  //prints extra blank line
    System.out.println ();  //prints extra blank line
     
    System.out.print ("Enter payment number of 1st month to be calculated: "); //prompts user for the payment number of the first month to be calculated
    curMonth = in.nextInt();  //stores user input into the integer variable curMonth
 
    remainingBal=monthlyPmt * ((float)(1.0-((Math.pow((1.0+monthlyRate),(curMonth - NumMonths)))))/monthlyRate);    //calculates the remaining balance and stores it in the float variable remainingBal
    System.out.println ("Balance remaining after month " + curMonth + " payment = " + currency.format(remainingBal));   //prints the remaining balance after the 1st number of months have been paid
     
    System.out.println ();  //prints extra blank line
     
    System.out.print ("Enter payment number of 2nd month to be calculated: "); //prompts user for the payment number of the 2nd month to be calculated
    curMonth = in.nextInt();  //stores user input into the integer variable curMonth
 
    remainingBal=monthlyPmt * ((float)(1.0-((Math.pow((1.0+monthlyRate),(curMonth - NumMonths)))))/monthlyRate);    //calculates the remaining balance and stores it in the float variable remainingBal
    System.out.println ("Balance remaining after month " + curMonth + " payment = " + currency.format(remainingBal));   //prints the remaining balance after the 2nd number of months have been paid
     
    System.out.println ();  //prints extra blank line
     
    System.out.print ("Enter payment number of 3rd month to be calculated: "); //prompts user for the payment number of the third month to be calculated
    curMonth = in.nextInt();  //stores user input into the integer variable curMonth
 
    remainingBal=monthlyPmt * ((float)(1.0-((Math.pow((1.0+monthlyRate),(curMonth - NumMonths)))))/monthlyRate);    //calculates the remaining balance and stores it in the float variable remainingBal
    System.out.println ("Balance remaining after month " + curMonth + " payment = " + currency.format(remainingBal));   //prints the remaining balance after the 3rd number of months have been paid
     
    System.out.println ();  //prints extra blank line
     
    System.out.print ("Enter payment number of 4th month to be calculated: "); //prompts user for the payment number of the fourth month to be calculated
    curMonth = in.nextInt();  //stores user input into the integer variable curMonth
 
    remainingBal=monthlyPmt * ((float)(1.0-((Math.pow((1.0+monthlyRate),(curMonth - NumMonths)))))/monthlyRate);    //calculates the remaining balance and stores it in the float variable remainingBal
    System.out.println ("Balance remaining after month " + curMonth + " payment = " + currency.format(remainingBal));  //prints the remaining balance after the 4th number of months have been paid
     
    System.out.println ();  //prints extra blank line
     
    
   } //end main
 
} // end class BankLoan