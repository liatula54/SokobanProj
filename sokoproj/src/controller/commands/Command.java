package controller.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.MyException.MoveException;

public abstract class Command {

	protected List <String> params;

	 public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public abstract void execute() throws FileNotFoundException, IOException, MoveException, ClassNotFoundException ;
 }
