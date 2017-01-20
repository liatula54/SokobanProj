package commands;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import model.data.levels.Level;
import model.data.levels.LevelSaver;
import model.data.levels.MyObjectLevelSaver;
import model.data.levels.MyTextLevelSaver;
import model.data.levels.MyXMLLevelSaver;

public class SaveFileNameCommand implements Command {

	private Level level;
	private HashMap<String, LevelSaver> suffixToSaveFile;
	private String fileName;
	
	public SaveFileNameCommand(Level l,String fileName) {
		this.fileName = fileName;
		this.setLevel(l);
		suffixToSaveFile = new HashMap<>();
		suffixToSaveFile.put("txt", new MyTextLevelSaver());
		suffixToSaveFile.put("xml", new MyXMLLevelSaver());
		suffixToSaveFile.put("obj", new MyObjectLevelSaver());
		
	}

	@Override
	public void execute() throws FileNotFoundException, IOException  {
		String suffix =fileName.split("\\.")[1];
		LevelSaver lS = suffixToSaveFile.get(suffix);
		lS.saveLevel(level, fileName);
	}

	public HashMap<String, LevelSaver> getSuffixToSaveFile() {
		return suffixToSaveFile;
	}

	public void setSuffixToSaveFile(HashMap<String, LevelSaver> suffixToSaveFile) {
		this.suffixToSaveFile = suffixToSaveFile;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
