  /* Joe Enright
   * Club Class
   */



public class Club {

	
	public String name;
	public String home_Ground;
	public String county;
	public String level;
	
	
	// Constructor method
	public Club(){
		
		setName(name);
		setHome_Ground(home_Ground);
		setCounty(county);
		setLevel(level);
	}
	
	
	// Getter and Setter Methods
	
	/*
	 * @return name of the the club
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * @param name sets the name of the club
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getHome_Ground() {
		return home_Ground;
	}
	
	
	public void setHome_Ground(String home_Ground) {
		this.home_Ground = home_Ground;
	}
	
	
	public String getCounty() {
		return county;
	}
	
	
	public void setCounty(String county) {
		this.county = county;
	}
	
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	
	
	
}
