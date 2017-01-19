package levels;

import java.util.Map;

import levels.gameObj.GameObject;

public class PrintLevel implements Print {

	@Override
	public void print(Object obj) {
		int currRow = 0;
		for(Map.Entry<Position, GameObject> e :  ((Level)obj).getLevel().entrySet())
		{
			if(currRow != e.getKey().getCol())
		{
			System.out.println();
			currRow = e.getKey().getCol();
		}
			
			e.getValue().name();
		}
		System.out.println();
	}
	
}
