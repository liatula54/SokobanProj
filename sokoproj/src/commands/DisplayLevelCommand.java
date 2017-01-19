package commands;

import levels.Level;
import levels.Print;
import levels.PrintLevel;

public class DisplayLevelCommand implements Command {

	
	private Level level;
	
	//c'tor
	public DisplayLevelCommand(Level l) {
		this.level = l;
	}


	@Override
	public void execute() {
		Print p = new PrintLevel();
		p.print(level);
	}

}
