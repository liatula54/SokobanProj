package model.data.levels;

import java.io.InputStream;

import model.data.Xmlcoder.XMLUtil;

public class MyXMLLevelLoader implements LevelLoader {
	
	//default c'tor
	public MyXMLLevelLoader() {
		
	}
	
	@Override
	public Level loadLevel(InputStream is){
		Level l = (Level)XMLUtil.decoder(is);
		return l;
	}

}


