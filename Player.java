/*
 * Joe Enright
 * Player Class
 * Defines the Player data and attributes.
 */
public class Player {

	
	// Player data
	
	public String name;
	public int age;
	public String position;
	public int rating;
	public String attribute;
	
	
	
	// Constructor Methods
	
	public Player(String name, int age, String position, int rating, String attribute){
		
		setName(name);
		setAge(age);
		setPosition(position);
		setRating(rating);
		setAttribute(attribute);
		
	}
	
	public Player(){
		
		this("unknown", 0, "Unknown", 0, "unknown");
	}
	
	
	
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public String getPosition() {
		return position;
	}
	
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public int getRating() {
		return rating;
	}
	
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public String getAttribute() {
		return attribute;
	}
	
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
	public String toString(){
		return "Name" + getName() + "Age " + getAge() + "Position " + getPosition() + "Rating" + getRating() + "Attribute " + getAttribute();
	}
	
}
