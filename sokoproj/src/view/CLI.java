package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import controller.Controller;
import common.Position;

public class CLI extends Observable implements View {
	private BufferedReader reader;
	private PrintWriter writer;
	private String exitString;
//	private PriorityQueue<Command> command;
//	private Level l;


//	private static boolean gameOn = true;

	public CLI(BufferedReader reader, PrintWriter writer,String exitString){
		this.writer =writer;
		this.setReader(reader);
		this.exitString = exitString;
//		this.command = new PriorityQueue<>();
//		this.l = null;
	}



	/**
	 * Adds new command to the priority queue based on the user input,
	 * parse the user input in order to get only the interesting part which is
	 * for ex. "up", "down", ....
	 * @param whichCommand
	 */
//	public void commandFactory(String whichCommand){
//		String[] commandParts =whichCommand.split(" ", 2);
//
//		if(commandParts.length < 2 && !whichCommand.equals("Exit") && !whichCommand.equals("Display"))
//		{
//			System.out.println("Invalid input: " + whichCommand);
//			return;
//		}
//
//		if(l == null && !commandParts[0].equals("Load"))
//		{
//			command.clear();
//			command.add(new LoadFileNameCommand(""));
//			return;
//		}
//
//		switch (commandParts[0]){
//		case ("Load"):
//			if(l != null)
//			{
//				command.clear();
//				l = null;
//			}
//			command.add(new LoadFileNameCommand(commandParts[1]));
//			break;
//		case("Display"):
//			command.add(new DisplayLevelCommand(l));
//			break;
//		case("Move"):
//			command.add(new MoveCommand( commandParts[1]));
//			break;
//		case("Save"):
//			command.add(new SaveFileNameCommand(l, commandParts[1]));
//			break;
//		case ("Exit"):
//			command.add(new ExitCommand());

	//	}


	//}

//	/**
//	 * The main game runner
//	 * @param args
//	 */
//	public static void main(String[] args){
//
//		Scanner userInput = new Scanner(System.in);
//		String input;
//		CLI cli = new CLI(userInput, B);
//		Command currCommand;
//		//game loop
//		while(gameOn)
//		{
//			//if level is loaded check targets count
//			if(cli.getL() != null)
//			{
//				if(cli.getL().isWin())
//				{
//					System.out.println("Winner!!!");
//					System.exit(0);
//				}
//			}
//
//			input = userInput.nextLine();
//			cli.commandFactory(input);
//
//			while(cli.getL() == null && !input.equals("Exit"))
//			{
//				currCommand = cli.getCommand().poll();
//				try {
//					currCommand.execute();
//				} catch (FileNotFoundException e) {
//					String filename = ((LoadFileNameCommand)currCommand).getFileName();
//					System.out.println(filename + "\nFile not found try another file");
//					System.out.println("Please load a level file: Load filename");
//					break;
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//					System.exit(1);
//				} catch (IOException e) {
//					e.printStackTrace();
//					System.exit(1);
//				} catch (MoveException e) {
//					e.printStackTrace();
//					System.exit(1);
//				}
//				cli.setL(((LoadFileNameCommand)currCommand).getLevel());
//			}
//
//			while((currCommand = cli.getCommand().poll()) != null)
//			{
//				try {
//					currCommand.execute();
//				} catch (FileNotFoundException e) {
//
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//					System.exit(1);
//				} catch (IOException e) {
//					e.printStackTrace();
//					System.exit(1);
//				} catch (MoveException e) {
//					cli.setCommand(new PriorityQueue<Command>());
//					System.out.println(e.getMessage());
//					System.out.println("Please enter your command:");
//				}
//			}
//		}
//
//		userInput.close();
//	}
//
//	public static boolean isGameOn() {
//		return gameOn;
//	}
//
//	public static void setGameOn(boolean gameOn) {
//		CLI.gameOn = gameOn;
//	}
//
//	public PriorityQueue<Command> getCommand() {
//		return command;
//	}
//
//	public void setCommand(PriorityQueue<Command> command) {
//		this.command = command;
//	}
//
//	public Level getL() {
//		return l;
//	}
//
//	public void setL(Level l) {
//		this.l = l;
//	}



	@Override
	public void addObserver(Controller c) {
		// TODO Auto-generated method stub

	}


	public BufferedReader getReader() {
		return reader;
	}


	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}


	@Override
	public void displayMessage(String msg) {
		writer.println(msg);
		writer.flush();

	}

	@Override
	public void display(Position currPlayerPos) {
		writer.println(currPlayerPos);

	}



	@Override
	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				String commandLine = " ";
				boolean exitInput = commandLine.equals(exitString);

				do{
					writer.print("Enter command: ");
					try {
						commandLine = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}while(!exitInput);



			}
		}).start();

	}



	}


