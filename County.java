
public class County {

	public String name;
	public int points;
	public int gamesPlayed;
	
	public County(){
		name = "unknown";
		points = 0;
		gamesPlayed = 0;
	}
	
	
	public County(String name, int points, int gamesPlayed){
		this.name = name;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
	}
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPoints(int points){
		this.points = points;
	}
	
	public int getPoints(){
		return points;
	}
	
	
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;
	}
	
	public int getGamesPlayed(){
		return gamesPlayed;
	}
	
	
	
	public String toString(){
		return getName() + " \t\t " + getGamesPlayed() + "\t\t   "+ getPoints();
	}
	
	
}
