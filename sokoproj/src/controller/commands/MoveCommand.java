package controller.commands;


import model.Model;
import model.MyException.MoveException;

public class MoveCommand extends Command{

	private Model model;


	public MoveCommand(Model model) {
		this.model = model;
	}

	@Override
	public void execute() throws MoveException{
		String dir = params.get(0);
		model.move(dir);

	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
