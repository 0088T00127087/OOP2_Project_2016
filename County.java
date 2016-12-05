
public class County {

	public String countyName;
	public int points;
	public int gamesPlayed;
	
	public County(){
		countyName = "unknown";
		points = 0;
		gamesPlayed = 0;
	}
	
	
	public County(String name, int points, int gamesPlayed){
		this.countyName = name;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
	}
	
	
	public void setcountyName(String name){
		this.countyName = name;
	}
	
	public String getcountyName(){
		return countyName;
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
		return getcountyName() + " \t\t " + getGamesPlayed() + "\t\t   "+ getPoints();
	}
	
	
}
