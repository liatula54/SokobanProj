package levels.gameObj;

import levels.Level;
import levels.Position;

public class Space extends GameObject {


	private static final long serialVersionUID = 1L;

	//default c'tor
	public Space(){}
	
	// c'tor
	public Space(Position p, Level l) {
		super(p, l);
		
	}

	@Override
	public boolean move(Position toP) {
		return true;
	}

	@Override
	public void name() {
		System.out.print(" ");

	}

	@Override
	public String getSymbol() {
		
		return " ";
	}

}
