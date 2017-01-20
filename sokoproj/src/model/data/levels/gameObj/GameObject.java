package model.data.levels.gameObj;

import java.io.Serializable;

import model.data.levels.Level;
import model.data.levels.Position;

abstract public class GameObject implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Position p;
	 protected Level l;
	 
	 //default c'tor
	 public GameObject()
	 {	 
	 }
	 
	 // c'tor
	 public GameObject(Position p, Level l)
	 {
		 	this.p=p;
		 	this.setL(l);
	 }

	 abstract public boolean move (Position p);
	 abstract public void name();

	
	protected Position getDirection(Position newPos)
	{
		int xDir = newPos.getCol() - p.getCol();
		int yDir = newPos.getRow() - p.getRow();
		
		return new Position(xDir, yDir, 0);
	}
	
	 public Position getPosition()
		{
		 	return p;
		}
	 
	 public void setPosition(Position p)
		{
		 	this.p = p;
		}
	abstract public String getSymbol();
	
	public Level getL() {
		return l;
	}
	public void setL(Level l) {
		this.l = l;
	}
		

}
