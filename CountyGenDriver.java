import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CountyGenDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		County [] county = new County[12];
		int size = county.length;
		JFrame frame = new JFrame("League One");
		JTextArea  jt = new JTextArea();
		String table = " ";
		
		
		
		
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
										  "Tipparary", "WaterFord", "Limerick", "Galway", 
										  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
										  "WestMeath", "Offily", "Wexford", "Wicklow",
										  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
		
		
	
	// This loop is to initialise the County objects for the league table	
		for(int i = 0; i < county.length; i++){
			
			
			county[i] = new County();
			county[i].setName(counties[rand.nextInt(counties.length)]);
			county[i].setGamesPlayed(0);
			county[i].setPoints(0);
			
			 
		}
		
		
	
		
		
		//JFrame frame = new JFrame("League One");
		//JTextArea  jt = new JTextArea();
		
		frame.setSize(600, 600);
		jt.setBackground(Color.green);
		frame.setVisible(true);
		
		//String table = " ";
		
	// To display the counties in the text area
		jt.append("County \t\t Games \t\t Points");
		jt.append("\n***************************************************************************");
		
		//for(int j =0; j < county.length; j++){
		//	table += (String.format("\n" +county[j].getName() + "\t\t " + county[j].getGamesPlayed() + "\t\t" + county[j].getPoints()));
		//}
		
		frame.add(jt);
		jt.append(table);
	
		
		
		JTextArea tab = new JTextArea();
		String updateTable = "";
		
		for(int i = 1 ; i < county.length;i ++){
			
				playGame(county[0], county[i]);
				
				}
				for (int i = 0; i < county.length; i ++){
					sortTable(county);
					updateTable += "\n" + county[i].toString() + "\n";
					jt.cut();
						
		}
		
		jt.append(updateTable);
		JOptionPane.showMessageDialog(null, updateTable);
		
		
		
		// For Testing
		for (int i = 0; i < county.length; i ++){
			
			System.out.println(String.format(county[i].getName() + "\t\t\t" + county[i].getGamesPlayed() + "\t\t\t" + county[i].getPoints()));
		}
		
		
		
		
		
	}
	
	// Simple sorting algorithim to sort the table
	// bubble sort algorithim
	public static void sortTable(County[] table){
		County temp = new County();
		int size = table.length;
		for(int pass = 1; pass < size; pass++){
			for(int i = 0; i < size-pass; i++){
				if(table[i].getPoints() < table[i+1].getPoints()){
					temp = table[i];
					table[i] = table[i+1];
					table[i+1] = temp;
				}
			}
		}
		
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
		
		countyA.setGamesPlayed(countyA.gamesPlayed + 1);
		countyB.setGamesPlayed(countyB.gamesPlayed + 1);
		
		a = goalGenerator();
		b = pointGenerator();
		c = goalGenerator();
		d = pointGenerator();
		
		JOptionPane.showMessageDialog(null, countyA.getName() + " V " + countyB.getName() );
		JOptionPane.showMessageDialog(null, "Score" + countyA.getName() + a + ":" + b + "\t" + countyB.getName() + c + ":" + d );
		
		
		
		if(a+b > c+d){
			countyA.setPoints(countyA.points + 3);
			
			//JOptionPane.showMessageDialog(null, countyA.getName()+ " is the Winnner!!");
			//JOptionPane.showMessageDialog(null, countyA.toString());
			
		}
		if(a + b < c + d) {
			countyB.setPoints(countyB.points + 3);
			//JOptionPane.showMessageDialog(null, countyB.getName() + " is the Winner!!");
			//JOptionPane.showMessageDialog(null, countyB.toString());
		}
		else if (a+b == c+d){
			countyA.setPoints(countyA.points + 1);
			countyB.setPoints(countyB.points + 1);
			//JOptionPane.showMessageDialog(null, "The Game was a Draw!!");
			//JOptionPane.showMessageDialog(null, countyA.toString() + "\n" + countyB.toString());
			
		//System.out.println(countyA.toString());
		//System.out.println(countyB.toString());
			
		
	}
		
		
		
		
		
	
	
	}
}
