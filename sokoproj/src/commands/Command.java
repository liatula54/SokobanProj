package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import MyException.MoveException;

public interface Command {	

	 public void execute() throws FileNotFoundException, IOException, MoveException, ClassNotFoundException ;
 }
