/**
 * Parser contains methods to handle user input.
 * To get user input Scanner and BufferedReader libraries are imported
 * Also, two methods allow to handle Date objects.
 * All methods in Parser class are static.
 */

package controllers;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;


public class Parser {
	
	
	private Scanner scan;
	private static BufferedReader bread;
	private InputStreamReader isr;
	
	public Parser(Scanner scan, BufferedReader bread, InputStreamReader isr) {
		this.scan = scan;
		this.bread = bread;
		this.isr = isr;
	}
	
	/**
	 * Method gets user input via Scanner class.
	 * Input is checked then, if it's within certain range.
	 * Method is used in Loops class to make sure, that user will type correct value
	 * while, f.ex. choosing an option from a menu.
	 * @param scan
	 * @param range
	 * @return
	 */
	
	public static int getInput(Scanner scan, int range) {
		
		
		
		while(!scan.hasNextInt()) {
			System.out.println("Invalid input. Type an integer.");
			scan.next();
		}
		
		int choice = scan.nextInt();
		
		while(choice < 1 || choice > range) {
			
			System.out.println("Enter value between 1 and " + range);
			System.out.println("-----");
		
			choice = scan.nextInt();
		}
		
		return choice;
	}
	
	/**
	 * Method gets user input and, using BufferedReader built in method readLine(),
	 * returns string value, used as a parameter in other methods.
	 * @param scan
	 * @return
	 * @throws IOException
	 */
	
	public static String getStringInput(Scanner scan) throws IOException {
		
		String choice = bread.readLine();
		
		return choice;
		
	}
	
	/**
	 * Method gets String input and checks, if it's match with regex pattern.
	 * Used with date handling methods from controller class to make sure, that date 
	 * is in right format.
	 * @param date
	 * @return
	 */
	
	public static boolean checkDate(String date) {
		
		boolean status;
		
		Pattern p = Pattern.compile("^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|(([2468][048]|[3579][26])00)))$");
		Matcher m = p.matcher(date);
		if(m.matches() == false) {
			status = false;
		}
		else {
			status = true;
		}
		
		return status;
		
	}
	
	/**
	 * Method checks if date passed as a parameter is equal or before today.
	 * Used with controller class methods to handle dates.
	 * @param date
	 * @return
	 */
	
	public static boolean isBeforeNow(ChronoLocalDate date) {
		
		boolean status;
		
		LocalDate now = LocalDate.now();
		if(now.isBefore(date) || now.isEqual(date)) {
			status = true;
		}
		else {
			status = false;
		}
		return status;
	}
	
	
}
