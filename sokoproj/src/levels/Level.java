package levels;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import levels.gameObj.GameObject;
import levels.gameObj.Player;



public class Level  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Player player;
	private Map<Position, GameObject> levelCreators;
	private Map<Position, GameObject> targets;
	private int numOfTargets;
	
	//default c'tor
	public Level(){
		this.levelCreators = new TreeMap<Position, GameObject>();
		this.targets = new HashMap<Position, GameObject>();
		this.player = null;
		this.setNumOfTargets(0);
	}

	// c'tor
	public Level(Map <Position, GameObject> level){
		this.levelCreators= level;
		for(GameObject obj : level.values())
		{
			if(obj.getSymbol().equals("A"))
			{
				this.player = (Player)obj;
			}
		}
	}
	
	public Map<Position, GameObject> getLevel() {
		return levelCreators;
	}
	
	public void setLevel(Map<Position, GameObject> level) {
		this.levelCreators = level;
		for(GameObject obj : level.values())
		{
			if(obj.getSymbol().equals("A"))
			{
				this.player = (Player)obj;
			}
		}
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
	

	
	


