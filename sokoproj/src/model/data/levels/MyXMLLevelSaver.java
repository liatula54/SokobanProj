package model.data.levels;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.data.Xmlcoder.XMLUtil;

public class MyXMLLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level l, String fileName) throws FileNotFoundException, IOException {
		XMLUtil.encoder(l, fileName);
	}

}
