package model.policy;

import model.MyException.MoveException;
import model.data.levels.Level;
import common.Position;
import model.data.levels.gameObj.Player;

public class MySokobanPolicy {


	Level level;
	public MySokobanPolicy()
	{
		level = new Level();

	}

	public void move(String dir) throws MoveException
	{
		Player p = level.getPlayer();
		Position playerPos = p.getPosition();
		Position newPlayerPos = null;

		switch(dir){
			case("left"):
				newPlayerPos = new Position(playerPos.getCol(), playerPos.getRow() - 1, playerPos.getDim());
				break;
			case("right"):
				newPlayerPos = new Position(playerPos.getCol(), playerPos.getRow() + 1, playerPos.getDim());
				break;
			case("up"):
				newPlayerPos = new Position(playerPos.getCol() - 1, playerPos.getRow(), playerPos.getDim());
				break;
			case("down"):
				newPlayerPos = new Position(playerPos.getCol() + 1, playerPos.getRow(), playerPos.getDim());
				break;
			default:
				throw new MoveException("Input move not exsits: " + dir + "try Move up\\down\\left\\right");
		}
		p.move(newPlayerPos);
	}

}
