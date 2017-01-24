package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import model.data.levels.Level;
import model.data.levels.LevelLoader;
import model.data.levels.MyObjectLevelLoader;
import model.data.levels.MyTextLevelLoader;
import model.data.levels.MyXMLLevelLoader;
public class LoadFileNameCommand extends Command{


		private String fileName = null;
		private HashMap<String, LevelLoader> suffixToLoader;
		private Level level;

	//c'tor
		public LoadFileNameCommand(String fName)  {
			this.fileName = fName;
			suffixToLoader = new HashMap<>();
			suffixToLoader.put("txt", new MyTextLevelLoader());
			suffixToLoader.put("xml", new MyXMLLevelLoader());
			suffixToLoader.put("obj", new MyObjectLevelLoader());
			level = null;
		}

	@Override
	public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
		String[] suffixArr = fileName.split("\\.");
		String suffix = suffixArr[suffixArr.length - 1];
		LevelLoader lL = suffixToLoader.get(suffix);
		FileInputStream fis;
		fis = new FileInputStream(fileName);
		level = lL.loadLevel(fis);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HashMap<String, LevelLoader> getSuffixToLoader() {
		return suffixToLoader;
	}

	public void setSuffixToLoader(HashMap<String, LevelLoader> suffixToLoader) {
		this.suffixToLoader = suffixToLoader;
	}

	public Level getLevel(){
		return level;
	}

	public void setLevel(Level level){
		this.level = level;
	}

}