package controllers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import classes.Project;
import classes.ProjectList;
import classes.Task;
import creators.Creator;
import creators.FileReaderWriter;


public class Test {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
	
	
	ProjectList prList = new ProjectList();
	Scanner scan = new Scanner(System.in);
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bread = new BufferedReader(isr);
	Parser pars = new Parser(scan, bread, isr);
	Controller controller = new Controller(prList, scan);
	Creator creator = new Creator(scan, prList, controller);
	FileReaderWriter fileReader = new FileReaderWriter(bread, isr, creator, controller);
	Loops loop = new Loops(scan, controller, creator, fileReader);
	Game newGame = new Game(scan, loop, fileReader, controller);
	
	
	
	
	
	newGame.play();
	
	}
	
	

}
