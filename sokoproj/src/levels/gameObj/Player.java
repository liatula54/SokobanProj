package levels.gameObj;

import java.util.Map;

import levels.Level;
import levels.Position;

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
		Map<Position,GameObject> m = l.getLevel();
		GameObject obj = m.get(toP);
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
				m.put(p, new Target(p, l));
			}
			else{
				m.put(p, new Space(p, l));
			}
			//update this to the new position
			p = toP;
			m.put(p, this);
			l.setLevel(m);
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
