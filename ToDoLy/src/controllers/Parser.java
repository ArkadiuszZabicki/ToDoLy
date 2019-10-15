package controllers;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {

	private Scanner scan;
	private static BufferedReader bread;
	private InputStreamReader isr;
	
	public Parser(Scanner scan, BufferedReader bread, InputStreamReader isr) {
		this.scan = scan;
		this.bread = bread;
		this.isr = isr;
	}
	
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
	
	public static String getStringInput(Scanner scan) throws IOException {
		
		String choice = bread.readLine();
		
		return choice;
		
	}
	
}
