/*
 * Joe Enright
 */
public class PlayerProfile extends County {
	
	public String name;
	public String county;
	
	
	public PlayerProfile(){
	
		setName(name);
		setCounty(county);
		
	}
	
	public PlayerProfile(String name, String county){
		
		this.name = name;
		this.county = county;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCounty(String county){
		this.county = county;
	}
	
	public String getCounty(){
		return county;
	}
	
	
	public String toString(){
		return "Player Name: " + getName() + "\nCounty: " + getCounty();
	}

}
