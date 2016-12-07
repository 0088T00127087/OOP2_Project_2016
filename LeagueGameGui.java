import java.awt.Color;
import java.awt.Container;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * Joe Enright
 * The league game type gui
 * This page will hold the table for the counties
 * 
 */
public class LeagueGameGui implements Serializable {

	// instance Variables
	JFrame frame;
	Container cPane;
	JButton nextGameBtn;
	JButton saveGameBtn;
	JLabel nameLbl;
	JLabel countyLbl;
	public static String plName;
	public static String plCounty;
	public static int playerIndex = 0;
	public static int numGames = 1;
	JTextArea table;
	
	public LeagueGameGui(PlayerProfile pf) throws IOException, FileNotFoundException{
		
		// Frame instantiation and values
		frame =  new JFrame("GAA League Division One");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(150,150);
		
		
		plCounty = pf.getcountyName();
		plName = pf.getName();
		
		cPane = new Container();
		cPane.setLayout(null);
		cPane.setBackground(Color.GREEN);
		cPane.add(nameLbl = new JLabel("Manager: " + plName));
		cPane.add(countyLbl = new JLabel("County: " + plCounty));
		cPane.add(table = new JTextArea());
		cPane.add(nextGameBtn = new JButton("Generate League Results"));
		cPane.add(saveGameBtn = new JButton("Save Game"));
		frame.add(cPane);
		
		//System.out.println(pf.toString());
		// Placement of ojects in cPane
		nameLbl.setBounds(25, 10, 100, 100);
		countyLbl.setBounds(25, 20, 100, 100);
		table.setBounds(150, 10, 300, 300);
		saveGameBtn.setBounds(100, 320, 150, 50);
		nextGameBtn.setBounds (300, 320, 200, 50);
		
		// Create an array to hold the counties
		Random rand = new Random();
		County [] county = new County[16];
		
		// Set the first object in the array to the playerprofile created
		county[0] = new County();
		county[0].setcountyName(pf.getcountyName());
		county[0].setGamesPlayed(0);
		county[0].setPoints(0);
	
		
		// String array of county names
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
				  						  "Tipparary", "WaterFord", "Limerick", "Galway", 
				  						  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
				  						  "WestMeath", "Offily", "Wexford", "Wicklow",
				  						  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh",
				  						  "Louth", "Cavan", "Longford", "Carlow", "Armagh","Kildare","Down"};
	
		
		// For loop to initialise the array of county objects
		for(int i = 1; i < county.length; i++){
			county[i] = new County();
			county[i].setcountyName(counties[rand.nextInt(counties.length)]);
			for(int j = 0; j <= county.length; j++ ){
				// Check to see if 
				if(county[0].getcountyName() == county[i].getcountyName()){
					county[i].setcountyName(counties[rand.nextInt(counties.length)]);
				}
			}
			county[i].setGamesPlayed(0);
			county[i].setPoints(0);
				 
		}
		
		
		// Saving the array of county objects 
		saveGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						try {
							saveGame(county, pf);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			
				
				
			}
		});
		
		
		table.append("County \t\t            Games  Points");
		table.append("\n--------------------------------------------------------------------------");
		
		for(int i = 0; i < county.length; i++){
			table.append("\n" + county[i].toString());
		}
		
		//getPlayerIndex(county);
		
		
		
		nextGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			for(int i = 0; i < county.length - 1; i++) {
				     for(int j = i+1; j < county.length; j++) {
				         playGame(county[i], county[j]);
				     }
				}
				
				
				
				
				table.setText("");
				table.append("County \t\t            Games  Points");
				table.append("\n--------------------------------------------------------------------------");
				
				for(int i = 0; i < county.length; i++){
					sortTable(county);
					table.append("\n" + county[i].toString());
					
					
				}
				
				if(pf.getGamesPlayed() == 11) {
					JOptionPane.showMessageDialog(null, "No More games to play this season");
		
				}
				
				
				
				
				//}
				
		
				
			}
		});
		
		
		
		// Create a JList to hold the list of county objects
		/*String updateTable = "";
		
		for(int i = 1 ; i < county.length;i ++){
			
				
				playGame(county[0], county[i]);
				
				}
				for (int i = 0; i < county.length; i ++){
					sortTable(county);
				updateTable += "\n" + county[i].toString();
					//table.cut();
						
		}*/
		//table.append(updateTable);
		
		
	
		
	for(int i = 0; i < county.length; i++){
		System.out.println(county[i].toString() + "Index: " + i);
	}
		
	}// End of Constructor
	
	
	
	
	
		// method to find the players team in the table
		public static void getPlayerIndex(County[] table){
			
			for(int i = 0 ; i < table.length; i ++){
				sortTable(table);
				if(table[i].getcountyName() == plCounty){
					
					playerIndex = i;
					
				}
				
			}
		}
		
		// Method to save the table and player profile
		
		public static void saveGame(County [] county, PlayerProfile pf)throws IOException, FileNotFoundException{
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("league.dat"));
			out.writeObject(county);
			out.writeObject(pf);
			JOptionPane.showMessageDialog(null, "Game Saved");
			
		}
		
		

		
	
		// Method for sorting the table according to highest points
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
		
		int gamesPlayed = 0;
		int a, b, c, d;
		
		countyA.setGamesPlayed(countyA.gamesPlayed + 1);
		countyB.setGamesPlayed(countyB.gamesPlayed + 1);
		
		a = goalGenerator();
		b = pointGenerator();
		c = goalGenerator();
		d = pointGenerator();
		
		//JOptionPane.showMessageDialog(null, countyA.getcountyName() + " V " + countyB.getcountyName() );
		//JOptionPane.showMessageDialog(null, "Score" + countyA.getcountyName() + a + ":" + b + "\t" + countyB.getcountyName() + c + ":" + d );
		
		
		
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
