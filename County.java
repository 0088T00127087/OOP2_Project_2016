import java.io.Serializable;
/*
 * Joe Enright
 * County Class
 */
public class County implements Serializable{

	
	// Instance Variable
	public String countyName;
	public int points;
	public int gamesPlayed;
	
	// Constructor
	public County() {
		countyName = "unknown";
		points = 0;
		gamesPlayed = 0;
	}
	
	// Constructor with three parameters
	public County(String name, int points, int gamesPlayed){
		this.countyName = name;
		this.points = points;
		this.gamesPlayed = gamesPlayed;
	}
	
	/*
	 * This method to set the county name
	 * @param String name
	 */
	public void setcountyName(String name){
		this.countyName = name;
	}
	
	/*
	 * This method returns the county name
	 * @return string county name
	 */
	public String getcountyName(){
		return countyName;
	}
	
	/*
	 * This method sets the points for the county
	 * @param int points
	 */
	public void setPoints(int points){
		this.points = points;
	}
	/*
	 * This method returns the county points
	 * @return int points
	 */
	public int getPoints(){
		return points;
	}
	
	/*
	 * This method sets the number of games played
	 * @param int gamesPlayed
	 */
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;
	}
	
	/*
	 * This method returns the number of Games played
	 * @return int gamesPlayed
	 */
	public int getGamesPlayed(){
		return gamesPlayed;
	}
	
	/*
	 * To String method, this displays the data of a county object
	 * @return string Name, int gamesPlayed, int points.
	 */
	
	public String toString(){
		return getcountyName() + "\t\t               | " + getGamesPlayed() + "    |   "+ getPoints();
	}
	
	
}
