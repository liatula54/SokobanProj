package model.data.levels.gameObj;

import java.util.Map;
import common.Position;
import model.data.levels.Level;


public class Player extends GameObject {

	private static final long serialVersionUID = 1L;
	//default c'tor
	public Player(){}

	//c'tor
	public Player(Position p, Level l) {
		super(p, l);
	}

	@Override
	public boolean move(Position toP) {
		Map<Position,GameObject> gameObjMap = l.getLevel();
		GameObject obj = gameObjMap.get(toP);
		if(obj == null)
		{
			System.out.println("Can't move there!!!");
			return false;
		}
		Position dir = getDirection(toP);
		Position objToPos = new Position(toP.getCol() + dir.getCol(),
										 toP.getRow() + dir.getRow(),
										 toP.getDim() + dir.getDim());
		boolean ret = obj.move(objToPos);
		if(ret)
		{
			//replace my object with space
			if(l.getTargets().containsKey(p))
			{
				gameObjMap.put(p, new Target(p, l));
			}
			else{
				gameObjMap.put(p, new Space(p, l));
			}
			//update this to the new position
			p = toP;
			gameObjMap.put(p, this);
			l.setLevel(gameObjMap);
		}
		else
		{
			System.out.println("Can't move there!!!");
		}
		return ret;
	}


	public void name()
	{
		System.out.print("A");
	}

	@Override
	public String getSymbol() {

		return "A";
	}

}
