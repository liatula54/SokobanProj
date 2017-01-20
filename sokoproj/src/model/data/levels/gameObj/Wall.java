package model.data.levels.gameObj;

import model.data.levels.Level;
import model.data.levels.Position;

public class Wall extends GameObject {

	private static final long serialVersionUID = 1L;

	//default c'tor
	public Wall(){}
	
	
	// c'tor
	public Wall(Position p, Level l){
		super(p, l);
	}

	@Override
	public boolean move(Position p) {
		return false;
	}
	

	public void name()
	{
		System.out.print("#");
	}

	@Override
	public String getSymbol() {
		
		return "#";
	}

}
