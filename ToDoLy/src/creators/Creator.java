/**
 * Creator Class handles all cases when new object is created.
 * It creates new tasks and new projects, using user input or
 * data read from external file.
 */

package creators;

import controllers.Controller;
import controllers.Parser;

import java.io.IOException;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;


public class Creator {
	
	private Scanner scan;
	
	private ProjectList projectList;
	
	private Controller controller;

	public Creator(Scanner scan, ProjectList projectList, Controller controller) {
		this.scan = scan;
		
		this.projectList = projectList;
		
		this.controller = controller;
	}
	
	/**
	 * Method adds newly created task to project of given id.
	 * @param id
	 * @throws IOException
	 */
	
	public void addToProject(String id) throws IOException {
		
		if(projectList.getProjectList().containsKey(id)) {
			
			Task tmpTask;
			tmpTask = this.addTask(id);
			projectList.findProject(id).addTask(tmpTask);
			System.out.println("Task added");
			System.out.println("-----");
		}
		
		else {
			System.out.println("There is no project with that key");
			System.out.println("Choose a project to add to");
			String chooseProject = Parser.getStringInput(scan);
			this.addToProject(chooseProject);
		}
		
		
		
		
	}
	
	/**
	 * Method creates new task using user input.
	 * Input is used to create parameters for a new task.
	 * @return
	 * @throws IOException
	 */
	
	public Task addTask(String projectId) throws IOException {
		
		Task tmpTask;
		String id;
		String task;
		String date;
		
		
		id = Integer.toString(controller.nextId(projectId));
		System.out.println("Enter new task name");
		task = Parser.getStringInput(scan);
		System.out.println("Enter new due date (Accepted date format is MM/dd/yyyy)");
		date = Parser.getStringInput(scan);
		
		tmpTask = new Task(id, task, controller.checkDateFormat(date));
		
		return tmpTask;
		
	}
	
	/**
	 * Method creates new project and adds it to a project list.
	 * @param id parameter comes from an user input.
	 * @return
	 * @throws IOException
	 */
	
	public String createNewProject(String id) throws IOException {
		
		Project tmpProj;
		String newId;
		
		
		while(projectList.getProjectList().containsKey(id)) {
			System.out.println("A project with that key already exists. Choose a new one");
			id = Parser.getStringInput(scan);
		}
		
		tmpProj = new Project(id);
		projectList.addProject(tmpProj);
		
		newId = id;
		return newId;
		
		
		
	}
	
	/**
	 * Method creates a new project and adds it to project list.
	 * 
	 * @param id parameter comes from an external source, in this case a file.
	 */
	
	public void addProjectFromFile(String id) {
		
		Project tmpProject = new Project(id);
		projectList.addProject(tmpProject);
		
	}
	
	/**
	 * Method creates a new task and adds it to selected project.
	 * All parameters come from an external source, in this case a file.
	 * @param id
	 * @param task
	 * @param date
	 * @param status
	 * @param projectId
	 */
	
	public void addTaskFromFile(String id, String task, String date, String status, String projectId) {
		
		Task tmpTask = new Task(id, task, date, status);
		projectList.findProject(projectId).addTask(tmpTask);
		
	}
	
	
	
	

}
