package controllers;
import java.io.IOException;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import controllers.Controller;
import creators.Creator;


public class Loops {
	
	
	
	private boolean status = false;
	Scanner scan = new Scanner(System.in);
	private Controller controller;
	private Creator creator;
	
	
	
	public Loops(Scanner scan, Controller controller, Creator creator) {
		this.scan = scan;
		this.controller = controller;
		this.creator = creator;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void menuLoop(int choice) throws IOException {
		
		
		boolean status = false;
		
		
		
		switch(choice) {
		
		case 1:
			System.out.println("Show tasks by date: press 1" + "\n" + "Show tasks by project: press 2");
			int choiceTwo = Parser.getInput(scan, 2);
			this.showTaskListMenu(choiceTwo);
			status = false;
			break;
		case 2:
			System.out.println("Add to existing project: press 1. Add to new project: press 2");
			int choiceThree = Parser.getInput(scan, 2);
			this.addTaskMenu(choiceThree);
			status = false;
			break;
		case 3:
			System.out.println("Choose a project you want to edit");
			String chooseProject = Parser.getStringInput(scan);
			if(controller.findProject(chooseProject) == null) {
				
				break;
			}
			else {
				System.out.println("Update task: press 1. Mark as done: press 2. Remove task: press 3. Move task to different project: press 4.");
				int choiceFour = Parser.getInput(scan, 4);
				this.updateTaskMenu(choiceFour, chooseProject);
				status = false;
				break;
			}
			
			
		case 4:
			System.out.println("Changes saved. Thank you for using ToDoLy5000. See ya in da future");
			status = true;
			break;
		
		
		
		}
		this.status = status;
		
	}
	
	public void showTaskListMenu(int choice) throws IOException {
		
		
		
		switch(choice) {
		
		case 1:
			System.out.println("What date are you looking for?");
			String dateToFind = Parser.getStringInput(scan);
			System.out.println(controller.showTaskListByDate(dateToFind));
			break;
		case 2:
			System.out.println("What project are you looking for?");
			String idToFind = Parser.getStringInput(scan);
			controller.showTaskListByProject(idToFind);
			break;
		
		}
		
	}
	
	public void addTaskMenu(int choice) throws IOException {
		
		switch(choice) {
			
		case 1:
			System.out.println("Choose a project to add to");
			String chooseProject = Parser.getStringInput(scan);
			creator.addToProject(chooseProject);
			break;
			
		case 2:
			System.out.println("Type an ID for a new project");
			String newProject = Parser.getStringInput(scan);
			creator.addToProject(creator.createNewProject(newProject));
			break;
		
		
		}
	}
	
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
			case 4: 
				System.out.println(choice);
				break;
			
			
		}
		
	}
	
	public void updateTask(String id, String chooseProject) throws IOException {
		
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
	
	
}
