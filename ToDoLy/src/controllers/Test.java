package controllers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;
import creators.Creator;


public class Test {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	Task task = new Task();
	Project tskList = new Project("1");
	ProjectList prList = new ProjectList();
	Scanner scan = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bread = new BufferedReader(isr);
	Parser pars = new Parser(scan, bread, isr);
	Creator creator = new Creator(scan, tskList, prList, task);
	Controller controller = new Controller(tskList, prList, scan);
	Loops loop = new Loops(scan, controller, creator);
	Game newGame = new Game(scan, loop);
	prList.addProject(tskList);
	
	
	
	newGame.play();
	}
	
	public void init() {
		
	}

}
