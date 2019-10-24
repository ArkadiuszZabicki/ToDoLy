package creators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import classes.ProjectList;
import controllers.Controller;
import controllers.Game;
import controllers.Loops;
import controllers.Parser;

public class Initializer {
	
	public void intit() throws IOException {
		
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
