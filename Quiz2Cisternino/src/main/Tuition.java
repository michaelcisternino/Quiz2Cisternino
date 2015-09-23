/** @Author Michael Cisternino
 * Quiz 2
 * September 22, 2015
 */
package main;

import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;
/* Tuition uses Scanner to accept input from the user and then calculates 
 * the user's tuition after four years in school, and the monthly 
 * payments the user must make to repay student loans in a given
 * number of years.
 */
public class Tuition {
	
	private static double initTuit;
	private static double APR;
	private static double percentInc;
	private static double term;
	
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("What is your initial tuition cost?");
	initTuit = scan.nextDouble();
	System.out.println("What is the yearly percentage increase of tuition?");
	/**
	 * Enter percentages as decimals (15% = .15)
	 */
	percentInc = scan.nextDouble();	
	System.out.println("What is the repayment APR?");
	APR = scan.nextDouble();
	System.out.println("What is the loan repayment term in years?");
	term = scan.nextDouble();
	
	double totalTuition = totalTuition(initTuit, percentInc);
	System.out.printf("Your total tuition is $%.2f%n", totalTuition);
	double monthlyPayment = payment(APR, term, totalTuition);
	System.out.printf("\nYour monthly payment will be $%.2f%n", monthlyPayment);
	
	
	}
	/** totalTuition calculates tuition after 4 years by compounding interest by same amount every year
	 * @param tuition is initial tuition
	 * @param rate is rate at which tuition is increasing each year
	 */
	public static double totalTuition (double tuition, double rate) {
		double total = 0;
		rate = rate + 1;
		for (int i = 0; i < 4; i++) {
			total = tuition+Math.pow(tuition, rate)+Math.pow(tuition, rate*rate)+Math.pow(tuition, rate*rate*rate);
		}
		return total;
	}
	/** payment calculates monthly payment of the total loan after four years
	 * @param avgperc is APR of loan
	 * @param yrs is term of loan in years
	 * @param pv is present value of loan
	 */
	public static double payment(double avgperc, double yrs, double pv) {
		double PMT;
		double r = (avgperc / 12);
		double n = yrs * 12;
		double p = pv;
		double f = 0;
		boolean t = false;
		// pmt is a loan formula from FinanceLib
		PMT = FinanceLib.pmt(r, n, p, f, t);
		return PMT;
	}
}