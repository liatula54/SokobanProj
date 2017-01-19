package levels;



import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import levels.gameObj.Box;
import levels.gameObj.GameObject;
import levels.gameObj.Player;
import levels.gameObj.Space;
import levels.gameObj.Target;
import levels.gameObj.Wall;

/**
 * @author liatu
 *
 */
public class MyTextLevelLoader implements LevelLoader {
	
	//default c'tor
	public MyTextLevelLoader() {
		
	}



	@Override
	public Level loadLevel(InputStream is){		
		
		int rowNumber=-1;
		BufferedInputStream in=new BufferedInputStream(is);
		Scanner myScan = null;
		myScan = new Scanner(in);
		Level l = new Level();
		while(myScan.hasNext()){
			String line = myScan.nextLine();
			rowNumber++;
			parseLine(line, rowNumber,l);
		}
		myScan.close();

		return l;
		
	}
	
	private void parseLine (String line, int row, Level level)
	{
		Map<Position, GameObject> levelMap = new TreeMap<Position, GameObject>();
		for(int col = 0; col < line.length(); col++)
		{
			Position pos = new Position(row, col, 0);
			char ch = line.charAt(col);
			GameObject square = objectFactory(ch, pos, level);
			levelMap.put(pos, square);
		}
		level.getLevel().putAll(levelMap);
	}
	
	private GameObject objectFactory(char ch, Position pos, Level level)
	{
		GameObject square=null;
		
		switch (ch){
		case('#'):
			square = new Wall(pos, level);
		 	break;
		case ('@'):
			square = new Box(pos, level);
	 		break;
		case ('A'):
			square = new Player(pos, level);
			level.setPlayer((Player)square);
	 		break;
		case ('o'):
			square = new Target(pos, level);
			level.addTargets(pos, square);
			level.setNumOfTargets(level.getNumOfTargets() + 1);;
	 		break;
		case (' '):
			square = new Space(pos, level);
		    break;
	
		}
		
		return square;
	}
}


		
		
		

