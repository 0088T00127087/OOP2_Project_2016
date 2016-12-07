import java.io.Serializable;

/*
 * Joe Enright
 * Create a Player Profile
 * Player Name
 * Player County
 * Player Index
 */
public class PlayerProfile extends County implements Serializable {
	
	public String playerName;
	public String county;
	public int playerIndex;
	
	
	public PlayerProfile(){
		super();
		this.playerName = "unknown";
		this.playerIndex = 0;
		
		
	}
	
	public PlayerProfile(String name, String county){
		
		this.playerName = name;
		this.county = county;
	}
	
	
	public void setName(String name){
		this.playerName = name;
	}
	
	public String getName(){
		return playerName;
	}
	
	public void setCounty(String county){
		this.county = county;
	}
	
	public String getCounty(){
		return county;
	}
	
	
	public void setPlayerIndex(int index){
		this.playerIndex = index;
	}
	
	
	public int getPlayerIndex(){
		return playerIndex;
	}
	
	
	public String toString(){
		return "Player Name: " + getName() + super.toString() + getPlayerIndex();
	}

}
