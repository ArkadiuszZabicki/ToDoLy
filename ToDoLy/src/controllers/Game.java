package controllers;
import java.io.IOException;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;
import creators.FileReaderWriter;



public class Game {
	
	
	
	private Scanner scan;
	private Loops loop;
	private FileReaderWriter fread;
	private Controller controller;
	
	
	public Game(Scanner scan, Loops loop, FileReaderWriter fread, Controller controller) {
		this.scan = scan;
		this.loop = loop;
		this.fread = fread;
		this.controller = controller;
		
	}
	
	private void printWelcome() {
		
		System.out.println(">> Welcome to ToDoLy5000");
		System.out.println(">> You have " + controller.getUndoneTasks() + " tasks to do and " + controller.getDoneTasks() +  " tasks are done!");
		System.out.println(controller.expiredTasksMenu());
		System.out.println(">> You have " + controller.tasksForToday() + " tasks to finish today!");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.println(">>");
		
	}
	
public void init() {
		
	}
	
	public void play() throws IOException {
		
		fread.readFromFile();
		
		boolean finished = false;
		
		while(finished == false) {
		
			printWelcome();
			int choice = Parser.getInput(scan, 4);
			loop.menuLoop(choice);
			finished = loop.getStatus();
			
			
		}
		
	}
	
	

}











