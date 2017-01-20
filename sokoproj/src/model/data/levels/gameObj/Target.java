package model.data.levels.gameObj;

import model.data.levels.Level;
import model.data.levels.Position;

public class Target extends GameObject {

	private static final long serialVersionUID = 1L;
	//default c'tor
	public Target(){}
	
	// c'tor
	public Target(Position p, Level l) {
		super(p, l);
		
	}

	

	@Override
	public boolean move(Position toP) {
		return true;
	}
	
	public void name()
	{
		System.out.print("o");
	}

	@Override
	public String getSymbol() {
		
		return "o";
	}


}
