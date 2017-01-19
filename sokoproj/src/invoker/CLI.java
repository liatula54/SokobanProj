package invoker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

import MyException.MoveException;
import commands.Command;
import commands.DisplayLevelCommand;
import commands.ExitCommand;
import commands.LoadFileNameCommand;
import commands.MoveCommand;
import commands.SaveFileNameCommand;
import levels.Level;

public class CLI {
	private PriorityQueue<Command> command;
	private Level l;


	private static boolean gameOn = true;
	
	public CLI(){
		this.command = new PriorityQueue<>();
		this.l = null;
	}
	 
	public void commandFactory(String whichCommand){
		String[] commandParts =whichCommand.split(" ", 2);
		
		if(commandParts.length < 2 && !whichCommand.equals("Exit") && !whichCommand.equals("Display"))
		{
			System.out.println("Invalid input: " + whichCommand);
			return;
		}
		
		if(l == null && !commandParts[0].equals("Load"))
		{
			command.clear();
			command.add(new LoadFileNameCommand(""));
			return;
		}
		
		switch (commandParts[0]){
		case ("Load"):
			if(l != null)
			{
				command.clear();
				l = null;
			}
			command.add(new LoadFileNameCommand(commandParts[1]));
			break;
		case("Display"):
			command.add(new DisplayLevelCommand(l));
			break;
		case("Move"):
			command.add(new MoveCommand(l, commandParts[1]));
			break;
		case("Save"):
			command.add(new SaveFileNameCommand(l, commandParts[1]));
			break;
		case ("Exit"):
			command.add(new ExitCommand());
		
		}
			
		
	}
	
	
	public static void main(String[] args){
		CLI cli = new CLI();
		Scanner userInput = new Scanner(System.in);
		String input;
		Command currCommand;
		while(gameOn)
		{
			if(cli.getL() != null)
			{
				if(cli.getL().isWin())
				{
					System.out.println("Winner!!!");
					System.exit(0);
				}
			}

			input = userInput.nextLine();
			cli.commandFactory(input);

			while(cli.getL() == null && !input.equals("Exit"))
			{
				currCommand = cli.getCommand().poll();
				try {
					currCommand.execute();
				} catch (FileNotFoundException e) {
					String filename = ((LoadFileNameCommand)currCommand).getFileName();
					System.out.println(filename + "\nFile not found try another file");
					System.out.println("Please load a level file: Load filename");
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (MoveException e) {
					e.printStackTrace();
					System.exit(1);
				}
				cli.setL(((LoadFileNameCommand)currCommand).getLevel());
			}
			
			while((currCommand = cli.getCommand().poll()) != null)
			{
				try {
					currCommand.execute();
				} catch (FileNotFoundException e) {
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				} catch (MoveException e) {
					cli.setCommand(new PriorityQueue<Command>());
					System.out.println(e.getMessage());
					System.out.println("Please enter your command:");
				}
			}
		}
		
		userInput.close();
	}

	public static boolean isGameOn() {
		return gameOn;
	}

	public static void setGameOn(boolean gameOn) {
		CLI.gameOn = gameOn;
	}
	
	public PriorityQueue<Command> getCommand() {
		return command;
	}

	public void setCommand(PriorityQueue<Command> command) {
		this.command = command;
	}

	public Level getL() {
		return l;
	}

	public void setL(Level l) {
		this.l = l;
	}
	
	
		
	}

