/*
 * Joe Enright
 * In Game menu to Select and Generate A Team
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameSelectTeam extends JFrame implements ActionListener {
	
	// Constructor for Selecting a Team 
	public GameSelectTeam(){
		
		setTitle ("Select County");
		setSize (300, 300);
		setLocation(150, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create Container
		Container cPane = getContentPane();
		cPane.setBackground(Color.green);
		
		// Select Team Items
		JLabel msg = new JLabel("Select County");
		JTextField jt = new JTextField("Enter Your name here");
		
		// Add Jlabel to container
		cPane.setLayout(new FlowLayout());
		cPane.add(jt);
		cPane.add(msg);
		
		// Create an Array to hold the County Names
		
		String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
										  "Tipparary", "WaterFord", "Limerick", "Galway", 
										  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
										  "WestMeath", "Offily", "Wexford", "Wicklow",
										  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
