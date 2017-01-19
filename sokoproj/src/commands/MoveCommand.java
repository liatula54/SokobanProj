package commands;


import MyException.MoveException;
import levels.Level;
import levels.MySokobanPolicy;

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
