import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	JLabel nameLbl;
	JLabel countyLbl;
	JLabel group1Lbl, group2Lbl, group3Lbl, group4Lbl; 
	JTextArea group1TA, group2TA, group3TA, group4TA;
	
	
	
	// Constructor method
	public ChampionShipGui(PlayerProfile pf){
		
		//Instantiation of JFrame and data
		frame =  new JFrame("GAA Championship");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150,150);
		
		plName = pf.getcountyName();
		plCounty = pf.getName();
		
		// container for components of the GUI
		cPane = new Container();
		cPane.setLayout(null);
		cPane.setBackground(Color.GREEN);
		cPane.add(nameLbl = new JLabel("Manager: " + plName));
		cPane.add(countyLbl = new JLabel("County: " + plCounty));
		// The Four Groups
		cPane.add(group1TA = new JTextArea("Group 1"));
		cPane.add(group2TA = new JTextArea("Group 2"));
		cPane.add(group3TA = new JTextArea("Group 3"));
		cPane.add(group4TA = new JTextArea("Group 4"));
		// Buttons
		cPane.add(nextGameBtn = new JButton("Play Next Game"));
		cPane.add(saveGameBtn = new JButton("Save Game"));
		frame.add(cPane);
		
		// Positioning of components
		nameLbl.setBounds(25, 10, 100, 100);
		countyLbl.setBounds(25, 20, 100, 100);
		group1TA.setBounds(150, 10, 150, 150);
		group2TA.setBounds(150, 200, 150, 150);
		group3TA.setBounds(350, 10, 150, 150);
		group4TA.setBounds(350, 200, 150, 150);
		saveGameBtn.setBounds(100, 400, 150, 50);
		nextGameBtn.setBounds (300, 400, 150, 50);
		
		
		
		
		
	}// End of Constructor
	
}// End of Class


