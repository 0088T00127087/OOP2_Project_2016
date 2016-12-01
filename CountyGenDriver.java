import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CountyGenDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		County [] county = new County[12];
		
		
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
										  "Tipparary", "WaterFord", "Limerick", "Galway", 
										  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
										  "WestMeath", "Offily", "Wexford", "Wicklow",
										  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
		
		
	
	// This loop is to initialise the County objects for the league table	
		for(int i = 0; i < county.length; i++){
			
			county[i] = new County();
			county[i].setName(counties[rand.nextInt(counties.length)]);
			county[i].setPoints(0);
			
			 
		}
		
		JFrame frame = new JFrame("League One");
		JTextArea  jt = new JTextArea();
		
		frame.setSize(300, 300);
		jt.setBackground(Color.green);
		frame.setVisible(true);
		
		String table = " ";
		
	// To display the counties in the text area
		jt.append("County \t\t Points");
		jt.append("\n*******************************************");
		//System.out.println("County \t \t Points");
		for(int i =0; i < county.length; i++){
			table += (String.format("\n" +county[i].getName() + "\t\t " + county[i].getPoints()));
		}
		
		frame.add(jt);
		jt.append(table);
		
		int goals ;
		
		System.out.println("Team A Score " + "Goals: " + goalGenerator() + "\tPoints: " + pointGenerator()   );
		System.out.println("Team B Score " + "Goals: " + goalGenerator() + "\tPoints: " + pointGenerator()   );
		
		
		playGame(county[0], county[1]);
	}
	
	public static int goalGenerator(){
		
		int teamGoals;
		
		Random score = new Random();
		teamGoals = score.nextInt(5);
		return teamGoals;
		
	}
	
	
	public static int pointGenerator(){
		
		int teampoints;
		
		Random score = new Random();
		teampoints = score.nextInt(25);
		return teampoints;
		
	}
	
	
	
	private static void playGame(County countyA, County countyB){
		
		int a, b, c, d;
		
		a = goalGenerator();
		b = pointGenerator();
		c = goalGenerator();
		d = pointGenerator();
		
		JOptionPane.showMessageDialog(null, countyA.getName() + " V " + countyB.getName() );
		
		if(a+b > c+d){
			countyA.setPoints(countyA.points + 3);
			JOptionPane.showMessageDialog(null, countyA.getName()+ " is the Winnner!!");
		}
		if(a + b < c + d) {
			countyB.setPoints(countyB.points + 3);
			JOptionPane.showMessageDialog(null, countyB.getName() + " is the Winner!!");
		}
		else if (a+b == c+d){
			countyA.setPoints(countyA.points + 1);
			countyB.setPoints(countyB.points + 1);
			JOptionPane.showMessageDialog(null, "The Game was a Draw!!");
		
	}
	
	
	}
}
