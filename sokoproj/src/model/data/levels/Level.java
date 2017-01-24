package model.data.levels;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import common.Position;
import model.data.levels.gameObj.GameObject;
import model.data.levels.gameObj.Player;



public class Level  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Player player;
	private Map<Position, GameObject> orederedLvlObjs;
	private Map<Position, GameObject> targets;
	private int numOfTargets;

	//default c'tor
	public Level(){
		this.orederedLvlObjs = new TreeMap<Position, GameObject>();
		this.targets = new HashMap<Position, GameObject>();
		this.player = null;
		this.setNumOfTargets(0);
	}

	// c'tor
	public Level(TreeMap <Position, GameObject> level){
		this.setLevel(level);
	}

	public Map<Position, GameObject> getLevel() {
		return orederedLvlObjs;
	}

	public void setLevel(Map<Position, GameObject> m) {
		this.orederedLvlObjs = m;
		this.targets = new HashMap<Position, GameObject>();
		for(GameObject obj : m.values())
		{
			if(obj.getSymbol().equals("A"))
			{
				this.player = (Player)obj;
			}
			else if(obj.getSymbol().equals("o"))
			{
				this.targets.put(obj.getPosition(), obj);
			}
		}
		this.numOfTargets = this.targets.size();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Map<Position, GameObject> getTargets() {
		return targets;
	}

	public void setTargets(Map<Position, GameObject> targets) {
		this.targets = targets;
	}

	public void addTargets(Position pos, GameObject target) {
		this.targets.put(pos, target);
	}

	public boolean isWin()
	{
		if(numOfTargets == 0)
		{
			return true;
		}
		return false;
	}

	public int getNumOfTargets() {
		return numOfTargets;
	}

	public void setNumOfTargets(int numOfTargets) {
		this.numOfTargets = numOfTargets;
	}

}






