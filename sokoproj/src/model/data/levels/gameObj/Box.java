package model.data.levels.gameObj;


import java.util.Map;
import common.Position;
import model.data.levels.Level;


public class Box extends GameObject {


	private static final long serialVersionUID = 1L;
	//default c'tor
	public Box(){}

	//c'tor
	public Box(Position p, Level l) {
		super(p, l);
	}

	@Override
	public boolean move(Position toP) {
		Map<Position, GameObject> m = l.getLevel();
		GameObject obj = m.get(toP);
		if(obj == null)
		{
			return false;
		}
		String  objSymbol = obj.getSymbol();
		if(objSymbol.equals("@"))
		{
			return false;
		}
		Position dir = getDirection(toP);
		Position objToP = new Position(toP.getCol() + dir.getCol(),
									   toP.getRow() + dir.getRow(),
									   toP.getDim() + dir.getDim());
		boolean ret = obj.move(objToP);
		if(ret)
		{
			//replace my object with space
			if(l.getTargets().containsKey(p))
			{
				m.put(p, new Target(p, l));
				l.setNumOfTargets(l.getNumOfTargets() + 1);
			}
			else{
				m.put(p,new Space(p,l));
			}
			//update this to the new position
			p = toP;
			m.put(p, this);
			l.setLevel(m);

			if((l.getTargets().containsKey(toP)))
			{
				l.setNumOfTargets(l.getNumOfTargets() - 1);
				System.out.println("Targets left:" + l.getNumOfTargets());
			}

		}
		return ret;
	}

	public void name()
	{
		System.out.print("@");
	}

	@Override
	public String getSymbol() {

		return "@";
	}
}
