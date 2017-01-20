package model.data.levels;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LevelSaver {
	 public void saveLevel(Level l,String fileName) throws FileNotFoundException, IOException;
	
	

}
