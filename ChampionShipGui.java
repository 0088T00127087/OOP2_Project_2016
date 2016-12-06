import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * Joe Enright
 * Class for Championship game
 */
public class ChampionShipGui {

	JFrame frame;
	Container cPane;
	JButton nextGameBtn;
	JButton saveGameBtn;
	
	public static String plName;
	public static String plCounty;
	public static int playerIndex = 0;
	
	private static int countyIndex;
	
	JLabel nameLbl;
	JLabel countyLbl;
	JLabel group1Lbl, group2Lbl, group3Lbl, group4Lbl; 
	JTextArea group1TA, group2TA, group3TA, group4TA;
	
	
	
	// Constructor method
	public ChampionShipGui(PlayerProfile pf){
		
		Random rand = new Random();
		//Instantiation of JFrame and data
		frame =  new JFrame("GAA Championship");
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150,150);
		
		// Get the player name and County
		plCounty = pf.getcountyName();
		plName = pf.getName();
		
		// container for components of the GUI
		cPane = new Container();
		cPane.setLayout(null);
		cPane.setBackground(Color.GREEN);
		cPane.add(nameLbl = new JLabel("Manager: " + plName));
		cPane.add(countyLbl = new JLabel("County: " + plCounty));
		
		// The Four Groups
		cPane.add(group1TA = new JTextArea());
		cPane.add(group2TA = new JTextArea());
		cPane.add(group3TA = new JTextArea());
		cPane.add(group4TA = new JTextArea());
		// Buttons
		cPane.add(nextGameBtn = new JButton("Play Next Game"));
		cPane.add(saveGameBtn = new JButton("Save Game"));
		frame.add(cPane);
		
		// Positioning of components
		nameLbl.setBounds(30, 10, 100, 100);
		countyLbl.setBounds(30, 20, 100, 100);
		group1TA.setBounds(150, 20, 300, 250);
		group2TA.setBounds(150, 300, 300, 250);
		group3TA.setBounds(470, 20, 300, 250);
		group4TA.setBounds(470, 300, 300, 250);
		saveGameBtn.setBounds(150, 600, 150, 50);
		nextGameBtn.setBounds (500, 600, 150, 50);
		
		
		
		// Create four groups of eight for the championship format
		County [] group1Counties = new County[8];
		County [] group2Counties = new County[8];
		County [] group3Counties = new County[8];
		County [] group4Counties = new County[8];
		
		// Pool for Quarter Finals
		County [] poolA = new County[1];
		County [] poolB = new County[1];
		County [] poolC = new County[1];
		County [] poolD = new County[1];
		
		// Put the player county in group1
		group1Counties[0] = new County();
		group1Counties[0].setcountyName(pf.getcountyName());
		group1Counties[0].setGamesPlayed(0);
		group1Counties[0].setPoints(0);
		
		
		
		// String array of the county name
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
				  						  "Tipparary", "WaterFord", "Limerick", "Galway", 
				  						  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
				  						  "WestMeath", "Offily", "Wexford", "Wicklow",
				  						  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh",
				  						  "Louth", "Cavan", "Longford", "Carlow", "Armagh","Kildare","Down"};
		
		
				// Initialise Group1 position 0 is initialised to the player county
				for(int i = 1; i < group1Counties.length; i++){
					group1Counties[i] = new County();
					group1Counties[i].setcountyName(counties[rand.nextInt(counties.length)]);
					for(int j = 0; j <= group1Counties.length; j++ ){
						// Check to see if 
						if(group1Counties[0].getcountyName() == group1Counties[i].getcountyName()){
							group1Counties[i].setcountyName(counties[rand.nextInt(counties.length)]);
						}
					}
					group1Counties[i].setGamesPlayed(0);
					group1Counties[i].setPoints(0);
				 
				}
				group1TA.append("County\t\tGames  Points");
				group1TA.append("\n-----------------------------------------------------------------");
				
		
				// Initialise Group2
				for(int i = 0; i < group2Counties.length; i++){
					group2Counties[i] = new County();
					group2Counties[i].setcountyName(counties[rand.nextInt(counties.length)]);
					for(int j = 0; j <= group2Counties.length; j++ ){
						
						if(group2Counties[0].getcountyName() == group2Counties[i].getcountyName()){
							group2Counties[i].setcountyName(counties[rand.nextInt(counties.length)]);
						}
					}
					group2Counties[i].setGamesPlayed(0);
					group2Counties[i].setPoints(0);
					
				}
				group2TA.append("County\t\tGames  Points");
				group2TA.append("\n-----------------------------------------------------------------");	 
				
				
				// Initialise Group3
				for(int i1 = 0; i1 < group3Counties.length; i1++){
					group3Counties[i1] = new County();
					group3Counties[i1].setcountyName(counties[rand.nextInt(counties.length)]);
					for(int j = 0; j <= group3Counties.length; j++ ){
						// Check to see if 
						if(group3Counties[0].getcountyName() == group3Counties[i1].getcountyName()){
							group3Counties[i1].setcountyName(counties[rand.nextInt(counties.length)]);
						}
					}
					group3Counties[i1].setGamesPlayed(0);
					group3Counties[i1].setPoints(0);
						 
				}
				group3TA.append("County\t\tGames  Points");
				group3TA.append("\n-----------------------------------------------------------------");
				
				// Initialise Group4
				for(int i11 = 0; i11 < group4Counties.length; i11++){
					group4Counties[i11] = new County();
					group4Counties[i11].setcountyName(counties[rand.nextInt(counties.length)]);
					for(int j = 0; j <= group4Counties.length; j++ ){
						// Check to see if 
						if(group4Counties[0].getcountyName() == group4Counties[i11].getcountyName()){
							group4Counties[i11].setcountyName(counties[rand.nextInt(counties.length)]);
						}
					}
					group4Counties[i11].setGamesPlayed(0);
					group4Counties[i11].setPoints(0);
						 
				}
				group4TA.append("County\t\tGames  Points");
				group4TA.append("\n-----------------------------------------------------------------");
		
		
				// Display the Counties in each group
				for(int ia = 0; ia < 8; ia++){
					group1TA.append("\n" + group1Counties[ia].toString());
					group2TA.append("\n" + group2Counties[ia].toString());
					group3TA.append("\n" + group3Counties[ia].toString());
					group4TA.append("\n" + group4Counties[ia].toString());
				}
		
		
				
				// Group One *****************************************************************************
			
				// Game generation in each group
				
				playGroupGame(group2Counties, group2TA);
				playGroupGame(group2Counties, group2TA);
				playGroupGame(group3Counties, group3TA);
				playGroupGame(group4Counties, group4TA);
				
				
				
				
				nextGameBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
							
						
						for(int i = 0; i < group1Counties.length - 1; i++) {
								for(int j = i+1; j < group1Counties.length; j++) {
											playGame(group1Counties[i], group1Counties[j]);
	
											
							}
	
					}
							
						
						group1TA.setText("");
						group1TA.append("County\t\tGames  Points");
						group1TA.append("\n-----------------------------------------------------------------");
						
						for(int j = 0; j < group1Counties.length; j++){
							sortTable(group1Counties);
							//getCountyIndex(group1Counties);
							group1TA.append("\n" + group1Counties[j].toString());
						}
						
					
					}
			
					
				});// End of ActionListener
		
				// Quaterfinals
				// Initialization of Pools
				poolA[0]= group1Counties[0];
				poolA[1]= group2Counties[0];
				poolB[0]= group1Counties[1];
				poolB[1]= group2Counties[1];
				poolC[0] = group3Counties[0];
				poolC[1] = group4Counties[0];
				poolD[0] = group3Counties[1];
				poolD[0] = group4Counties[1];
				

				playGame(poolA[0],poolA[1]);
				playGame(poolB[0],poolB[1]);
				playGame(poolC[0],poolC[1]);
				playGame(poolD[0],poolD[1]);
				
				
				
		
		
				
		
		
	}// End of Constructor
	
	
		
		// method to find the players team in the table
		public static void getPlayerIndex(County[] table){
				
				County c = new County();
				
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
			
			//int gamesPlayed = 0;
			int a, b, c, d;
			
			
			
			countyA.setGamesPlayed(countyA.gamesPlayed + 1);
			countyB.setGamesPlayed(countyB.gamesPlayed + 1);
			
			a = goalGenerator();
			b = pointGenerator();
			c = goalGenerator();
			d = pointGenerator();
			
			// Display the player Games
			if(countyA.getcountyName() == plCounty){
			
			JOptionPane.showMessageDialog(null, countyA.getcountyName() + " V " + countyB.getcountyName() );
			JOptionPane.showMessageDialog(null, "Score: " + countyA.getcountyName() +" "+ a + ":" + " " + b + "\t " + countyB.getcountyName() + c + ":" + d );
			
			}
			
			
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
				
			
				
			
		}
	
		}// End of Method playGame
			
			
			
			// Method for group games
		
			private static void playGroupGame(County [] group, JTextArea table){
	
					
						table.setText("");
						table.append("County\t\tGames  Points");
						table.append("\n-----------------------------------------------------------------");
						
					
						
						for(int i = 0; i < group.length - 1; i++) {
						     for(int j = i+1; j < group.length; j++) {
						         playGame(group[i], group[j]);
						     }
						}
						
						for(int e = 0; e < group.length; e++){
						sortTable(group);
						table.append("\n" + group[e].toString());
				
				}// End of outer for loop
		
				
			}// End of Method playGame
			
			
			//Method to sort counties by number of games played
			public static void getCountyIndex(County [] group){
				County temp = new County();
				int size = group.length;
				
				for(int pass = 1; pass < size; pass++){
					for(int i = 0; i < size-pass; i++){
						if(group[i].getGamesPlayed() < group[i+1].getGamesPlayed()){
							temp = group[i];
							group[i] = group[i+1];
							group[i+1] = temp;
							
							
						
						}
					}
				}
				
			}
	
	
}// End of Class


