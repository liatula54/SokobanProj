package commands;


import model.MyException.MoveException;
import model.data.levels.Level;
import model.policy.MySokobanPolicy;

public class MoveCommand implements Command{

	Level level;
	String dir;
	public MoveCommand(Level l, String dir) {
		this.level = l;
		this.dir = dir;
	}

	@Override
	public void execute() throws MoveException{
		MySokobanPolicy pol = new MySokobanPolicy();
		pol.move(dir, level);
	}

}
