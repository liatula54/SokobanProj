package levels;

import java.io.IOException;
import java.io.InputStream;

import Serialization.SerializationUtil;

public class MyObjectLevelLoader implements LevelLoader {
	
	//default c'tor
	public MyObjectLevelLoader() {
		
	}

	@Override
	public Level loadLevel(InputStream is) throws IOException, ClassNotFoundException {
		
		Level level = null;
		try {
			level = (Level) SerializationUtil.deserialize(is);
		} catch (ClassNotFoundException e) {
			
			System.out.println("error while loading level: "+e.getMessage());
			throw e;
		} catch (IOException e) {
			
			System.out.println("error while loading level: "+e.getMessage());
			throw e;
			
		}

		return level;
	}

}
