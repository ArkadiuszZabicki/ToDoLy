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
	private Project project;
	private ProjectList projectList;
	private Task task;

	public Creator(Scanner scan, Project project, ProjectList projectList, Task task) {
		this.scan = scan;
		this.project = project;
		this.projectList = projectList;
		this.task = task;
	}
	
	
	public void addToProject(String id) throws IOException {
		
		if(projectList.getProjectList().containsKey(id)) {
			
			Task tmpTask;
			tmpTask = this.addTask();
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
	
	public Task addTask() throws IOException {
		
		Task tmpTask;
		String id;
		String task;
		String date;
		
		System.out.println("Enter task ID");
		id = Parser.getStringInput(scan);
		System.out.println("Enter task name");
		task = Parser.getStringInput(scan);
		System.out.println("Enter due date");
		date = Parser.getStringInput(scan);
		
		tmpTask = new Task(id, task, date);
		
		return tmpTask;
		
	}
	
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

}
