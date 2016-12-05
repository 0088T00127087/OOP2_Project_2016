/*
 * Joe Enright
 */
public class PlayerProfile extends County {
	
	public String playerName;
	public String county;
	
	
	public PlayerProfile(){
		super();
		this.playerName = "unknown";
		
		
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
	
	
	public String toString(){
		return "Player Name: " + getName() + super.toString();
	}

}
