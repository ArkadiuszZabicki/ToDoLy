/**
 * Class loops holds all the loops used in app.
 * Loops are organized in a form of menu and built with switch:case statements.
 * Choosing one option from a menu activates another loop with more options.
 * Actions in loops (or menus) are handled by invoking methods from classes: Controller, Creator and FileReader.
 */

package controllers;
import java.io.IOException;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import controllers.Controller;
import creators.Creator;
import creators.FileReaderWriter;


public class Loops {
	
	
	
	private boolean status = false;
	Scanner scan = new Scanner(System.in);
	private Controller controller;
	private Creator creator;
	private FileReaderWriter fileReader;
	
	/**
	 * 
	 * Initialize a loop Object
	 * @param scan
	 * @param controller
	 * @param creator
	 * @param fileReader
	 */
	
	public Loops(Scanner scan, Controller controller, Creator creator, FileReaderWriter fileReader) {
		this.scan = scan;
		this.controller = controller;
		this.creator = creator;
		this.fileReader = fileReader;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Initialize the first menu in the app.
	 * @param choice holds a user input that is used to initialize other sub-menus.
	 * @throws IOException
	 */
	
	public void menuLoop(int choice) throws IOException {
		
		
		boolean status = false;
		
		
		
		switch(choice) {
		
		case 1:
			System.out.println("Show tasks by date: press 1" + "\n" + "Show tasks by project: press 2" + "\n" + 
								"Show all tasks sorted by date: press 3" + "\n" + "Show all tasks sorted by project: press 4" + "\n" + 
								"Show today's tasks: press 5" + "\n" + "Show expired tasks: press 6");
			int choiceTwo = Parser.getInput(scan, 6);
			this.showTaskListMenu(choiceTwo);
			status = false;
			break;
		case 2:
			System.out.println("Add to existing project: press 1. Add to new project: press 2.");
			int choiceThree = Parser.getInput(scan, 2);
			this.addTaskMenu(choiceThree);
			status = false;
			break;
		case 3:
			System.out.println("Choose a project you want to edit. Available projects: " + "\n" + controller.allProjects());
			String chooseProject = Parser.getStringInput(scan);
			if(controller.findProject(chooseProject) == null) {
				
				break;
			}
			else {
				System.out.println("Update task: press 1. Mark as done: press 2. Remove task: press 3");
				int choiceFour = Parser.getInput(scan, 4);
				this.updateTaskMenu(choiceFour, chooseProject);
				status = false;
				break;
			}
			
			
		case 4:
			System.out.println("Changes saved. Thank you for using ToDoLy5000. See ya in da future");
			fileReader.saveToFile(controller.listToSave());
			status = true;
			break;
		
		
		
		}
		this.status = status;
		
	}
	
	/**
	 * Initialize task menu - from here we can check tasks by date or by project
	 * @param choice holds an user input that is used to initialize other sub-menus or actions.
	 * @throws IOException
	 */
	
	public void showTaskListMenu(int choice) throws IOException {
		
		
		
		switch(choice) {
		
		case 1:
			System.out.println("What date are you looking for? (Accepted date format is MM/dd/yyyy)");
			String dateToFind = Parser.getStringInput(scan);
			controller.showTaskListByDate(controller.checkDateFormat(dateToFind));
			break;
		case 2:
			System.out.println("What project you want to display?" + "Available projects: " + "\n" + controller.allProjects());
			String idToFind = Parser.getStringInput(scan);
			controller.showTaskListByProject(idToFind);
			break;
		case 3:
			System.out.println("-----");
			controller.sortByDate();
			System.out.println("-----");
			break;
		case 4:
			System.out.println("-----");
			controller.sortByProject();
			System.out.println("-----");
			break;
		case 5:
			System.out.println("-----");
			System.out.println("Tasks to finish today: " + "\n" + controller.printTasksForToday());
			System.out.println("-----");
			break;
		case 6:
			System.out.println("-----");
			System.out.println("Expired tasks." + "\n" + controller.expiredTasksList());
			System.out.println("-----");
		
		}
		
	}
	
	/**
	 * Initialize menu where user can add tasks.
	 * @param choice
	 * @throws IOException
	 */
	
	public void addTaskMenu(int choice) throws IOException {
		
		switch(choice) {
			
		case 1:
			System.out.println("Choose a project to add to. Available projects: " + "\n" + controller.allProjects());
			String chooseProject = Parser.getStringInput(scan);
			controller.showTaskListByProject(chooseProject);
			creator.addToProject(chooseProject);
			break;
			
		case 2:
			System.out.println("Type an ID for a new project");
			String newProject = Parser.getStringInput(scan);
			creator.addToProject(creator.createNewProject(newProject));
			break;
		
		
		}
	}
	
	/**
	 * Initialize menu where user can update tasks.
	 * @param choice - choice of action to perform.
	 * @param chooseProject - user is asked to choose a project, that contains tasks one want to edit.
	 * @throws IOException
	 */
	
	public void updateTaskMenu(int choice, String chooseProject) throws IOException {
		
			
			
			
			switch(choice) {
			case 1:
				System.out.println("Choose a task you want to update.");
				controller.showTaskListByProject(chooseProject);
				String taskId = Parser.getStringInput(scan);
				
				this.updateTask(taskId, chooseProject);
				controller.showTaskListByProject(chooseProject);
				break;
			case 2:
				System.out.println("Choose a task you want to edit.");
				controller.showTaskListByProject(chooseProject);
				String taskId1 = Parser.getStringInput(scan);
				controller.markAsDone(taskId1, chooseProject);
				controller.showTaskListByProject(chooseProject);
				break;
			case 3: 
				System.out.println("Choose a task you want to remove.");
				controller.showTaskListByProject(chooseProject);
				String taskId2 = Parser.getStringInput(scan);
				controller.removeTask(taskId2, chooseProject);
				controller.showTaskListByProject(chooseProject);
				break;
			
			
		}
		
	}
	
	/**
	 * Menu for update tasks - user can choose between updating task name or task due date
	 * @param id
	 * @param chooseProject
	 * @throws IOException
	 */
	
	public void updateTask(String id, String chooseProject) throws IOException {
		
		if(controller.taskInProject(id, chooseProject)) {
			System.out.println("To edit task name: press 1. To edit date: press 2");
			int choice = Parser.getInput(scan, 2);
			
			switch(choice) {
			case 1:
				controller.changeTaskName(id, chooseProject);
				System.out.println("Changes saved");
				break;
			case 2:
				controller.changeDueDate(id, chooseProject);
				System.out.println("Changes saved");
				break;
			
			}
		}
		else {
			System.out.println("There is no such task. Pick a task from a list");
		}
		
		
		
	}
	
	
	
}
