  /* Joe Enright
   * County Class
   */



public class County {

	
	public String name;
	public int level;
	
	
	// Constructor method
	public County(){
		this("unknown", 0);
	}
	
	public County(String name, int x){
		
		setName(name);
		setLevel(x);
	}
	
	
	
	
	// Getter and Setter Methods
	
	/*
	 * @return name of the the County
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * @param name sets the name of the County
	 */
	public void setName(String name) {
		this.name = name;
	}
	
			
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public String toString(){
		return "Name" + getName() +  "Level" + getLevel();
	}
	
	
	
}
