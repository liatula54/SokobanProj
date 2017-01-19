package levels;

import java.io.FileNotFoundException;
import java.io.IOException;

import Serialization.SerializationUtil;

public class MyObjectLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level l, String fileName) throws FileNotFoundException, IOException {
		SerializationUtil.serialize(l, fileName);
	}

}
