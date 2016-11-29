/*
 * Random Name Generator
 * This code was take from 
 * Author MrPork
 * Owner  MrPork
 * Date   28/11/2016
 * Source http://www.java-gaming.org/index.php?topic=35802.0
 * 
 */



import java.util.Random;



/*
 * This is the original code snippit
 * I will modify this just using a beggining and end name to generate players names for teams.
public class RandomNames {

	

		   private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
		         "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
		         "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
		         "Mar", "Luk" };
		   private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
		         "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
		         "marac", "zoir", "slamar", "salmar", "urak" };
		   private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
		         "tron", "med", "ure", "zur", "cred", "mur" };
		   
		   private static Random rand = new Random();

		   public static String generateName() {

		      return Beginning[rand.nextInt(Beginning.length)] + 
		            Middle[rand.nextInt(Middle.length)]+
		            End[rand.nextInt(End.length)];

		   }
	
}

*/

/*
 * I have modified the code above using first and last names to generate Player names. 
 */

public class RandomNames {
	
	public String[] Beginning = { "Joe", "John", "Mike", "Patrick", "Eoin", "Luke", "Tommy", "James",  "Brendan", "Maurice", "Ogie", 
			"David", "Neil", "Philip"};
	
	public String[] End = {"Enright", "Walsh", "O Shea", "Cooper", "Rock", "Fitzgerald", "O Riordan",
			"Dillane", "McCarthy", "Moran", "Donaghy", "Spillane", "Flaharty" };
	
	public Random rand = new Random();
	
	public String generateName() {

	      return Beginning[rand.nextInt(Beginning.length)] + " "+
	            End[rand.nextInt(End.length)];

	   }
}



