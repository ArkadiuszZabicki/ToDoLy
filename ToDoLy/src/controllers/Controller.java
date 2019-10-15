package controllers;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;


//Recursion?


public class Controller {
	
	
	private Project tasklist;
	private ProjectList projectList;
	private Scanner scan;
	
	
	public Controller(Project tasklist, ProjectList projectList, Scanner scan) {
		this.tasklist = tasklist;
		this.projectList = projectList;
		this.scan = scan;
		
	}
	
	public void showTaskListByProject(String idToFind) {
		
		
		
		if(projectList.getProjectList().isEmpty()) {
			System.out.println("List is empty");
		}
		
		
		else {
			
			if(projectList.getProjectList().containsKey(idToFind)) {
				System.out.println("-----");
				projectList.findProject(idToFind).printTaskList();
				System.out.println("-----");
			}
			else {
				System.out.println("Project not found");
		}
		}
		
		
	}
	
	public String showTaskListByDate(String dateToFind) {
		
		String taskList = "";
		String toReturn = "";
		
		if(projectList.getProjectList().isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			
			
			
			for(Task i : tasklist.getTaskList().values()) {
				
				if(i.getDate().equals(dateToFind)) {
					taskList += (i.getId() + " " + i.getTask() + " " + i.getDate() + " " + i.getStatus() + "\n");
				}
				
			}
			if(taskList.length() > 0) {
				toReturn = taskList;
			}
			else {
				toReturn = "Date not found";
			}
		}
		return toReturn;
	}
	
	public Project findProject(String id) {
		
		Project tmpProject;
		
		if(projectList.getProjectList().containsKey(id)) {
			
			tmpProject = projectList.findProject(id);
			
		}
		
		else {
			
			System.out.println("Project not found");
			tmpProject = null;
			
		}
		
		return tmpProject;
		
		
	}
	
	public void markAsDone(String id, String chooseProject) {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		Task tmpTask = tmpProj.findTask(id);
		
		tmpTask.setStatus("Done");
		System.out.println("Task " + id + " marked as done");
	}
	
	public void removeTask(String id, String chooseProject) {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		tmpProj.removeTask(id);
		
		System.out.println("Task removed");
		
		
		
	}
	
	public void changeTaskName(String id, String chooseProject) throws IOException {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		Task tmpTask = tmpProj.findTask(id);
		System.out.println("Type a new task name");
		String newTask = Parser.getStringInput(scan);
		
		tmpTask.setTask(newTask);
	}
	
	
	public void changeDueDate(String id, String chooseProject) throws IOException {
		
		Project tmpProj = projectList.getProjectList().get(chooseProject);
		Task tmpTask = tmpProj.findTask(id);
		System.out.println("Type a new due date");
		String newDate = Parser.getStringInput(scan);
		
		tmpTask.setDate(newDate);
	}

}

