package controller.commands;

import common.Position;
import model.Model;
import view.View;

public class DisplayLevelCommand extends Command {
	private Model model;
	private View view;


	//private Level level;

	//c'tor
	public DisplayLevelCommand(Model model,View view) {
		this.model = model;
		this.view = view;
	}


	@Override
	public void execute() {
		Position playerPos = model.getCurrPlayerPos();
		view.display(playerPos);
//		Print p = new PrintLevel();
//		p.print(level);
	}

}
