package model.data.levels;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import model.data.levels.gameObj.GameObject;

public class MyTextLevelSaver implements LevelSaver {

	@Override
	public void saveLevel(Level l, String fileName) throws FileNotFoundException, IOException {
		PrintWriter out = new PrintWriter(fileName);
		int currRow = 0;
		for(Map.Entry<Position, GameObject> e :  l.getLevel().entrySet())
		{
			if(currRow != e.getKey().getRow())
			{
				out.println();
				currRow = e.getKey().getRow();
			}

			out.print(e.getValue().getSymbol());
		}

		out.close();
	}

}