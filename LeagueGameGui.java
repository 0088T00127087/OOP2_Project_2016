import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class LeagueGameGui {

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
	JTextArea table;
	
	public LeagueGameGui(PlayerProfile pf){
		
		// Frame instantiation and values
		frame =  new JFrame("GAA League Division One");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150,150);
		
		
		plCounty = pf.getcountyName();
		plName = pf.getName();
		
		cPane = new Container();
		cPane.setLayout(null);
		cPane.setBackground(Color.GREEN);
		cPane.add(nameLbl = new JLabel("Manager: " + plName));
		cPane.add(countyLbl = new JLabel("County: " + plCounty));
		cPane.add(table = new JTextArea());
		cPane.add(nextGameBtn = new JButton("Play Next Game"));
		cPane.add(saveGameBtn = new JButton("Save Game"));
		frame.add(cPane);
		
		System.out.println(pf.toString());
		// Placement of ojects in cPane
		nameLbl.setBounds(25, 10, 100, 100);
		countyLbl.setBounds(25, 20, 100, 100);
		table.setBounds(150, 10, 300, 300);
		saveGameBtn.setBounds(100, 320, 150, 50);
		nextGameBtn.setBounds (300, 320, 150, 50);
		
		// Create an array to hold the counties
		Random rand = new Random();
		County [] county = new County[12];
		
		// Set the first object in the array to the playerprofile created
		county[0] = new County();
		county[0].setcountyName(pf.getcountyName());
		county[0].setGamesPlayed(0);
		county[0].setPoints(0);
	int playerIndex = 0;
		
		// String array of county names
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
				  "Tipparary", "WaterFord", "Limerick", "Galway", 
				  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
				  "WestMeath", "Offily", "Wexford", "Wicklow",
				  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
		
		
		// For loop to initialise the array of county objects
		for(int i = 1; i < county.length; i++){
			county[i] = new County();
			county[i].setcountyName(counties[rand.nextInt(counties.length)]);
			county[i].setGamesPlayed(0);
			county[i].setPoints(0);
				 
		}
		
		table.append("County \t\t            Games  Points");
		table.append("\n--------------------------------------------------------------------------");
		
		for(int i = 0; i < county.length; i++){
			table.append("\n" + county[i].toString());
		}
		
		int gamesNumber = 0;
		int numGames = 1;
		
		nextGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getPlayerIndex(county);
				
				playGame(county[pf.getPlayerIndex()], county[1]);
				
				sortTable(county);
				
				table.setText("");
				table.append("County \t\t            Games  Points");
				table.append("\n--------------------------------------------------------------------------");
				
				for(int i = 0; i < county.length; i++){
					
					table.append("\n" + county[i].toString());
				}
								
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
		
		
		
		
	}
	
	// method to find the players team in the table
	
		public static void getPlayerIndex(County[] table){
			
			County c = new County();
			sortTable(table);
			for(int i = 0 ; i < table.length; i ++){
				
				if(table[i].getcountyName() == plCounty){
					
					playerIndex = i;
					
				}
				
			}
		}
	
	
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
		
		JOptionPane.showMessageDialog(null, countyA.getcountyName() + " V " + countyB.getcountyName() );
		JOptionPane.showMessageDialog(null, "Score" + countyA.getcountyName() + a + ":" + b + "\t" + countyB.getcountyName() + c + ":" + d );
		
		
		
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
