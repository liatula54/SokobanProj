package commands;


import invoker.CLI;


public class ExitCommand implements Command {
	CLI cli;

	public ExitCommand() {
	}

	@Override
	public void execute(){
		CLI.setGameOn(false);
	}

}
