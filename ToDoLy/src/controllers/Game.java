package controllers;
import java.io.IOException;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;



public class Game {
	
	
	
	private Scanner scan;
	private Loops loop;
	
	
	
	public Game(Scanner scan, Loops loop) {
		this.scan = scan;
		this.loop = loop;
		
	}
	
	private void printWelcome() {
		
		System.out.println(">> Welcome to ToDoLy5000");
		System.out.println(">> You have X tasks todo and Y tasks are done!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.println(">>");
		
	}
	
	public void play() throws IOException {
		
		
		boolean finished = false;
		
		while(finished == false) {
		
			printWelcome();
			int choice = Parser.getInput(scan, 4);
			loop.menuLoop(choice);
			finished = loop.getStatus();
			
			
		}
		
	}
	
	

}











