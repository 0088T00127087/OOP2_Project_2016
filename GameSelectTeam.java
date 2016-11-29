/*
 * Joe Enright
 * In Game menu to Select and Generate A Team
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GameSelectTeam extends JFrame implements ActionListener , ListSelectionListener {
		
	PlayerProfile pf = new PlayerProfile();
	
	JLabel playerName = new JLabel();
	JLabel nameLabel = new JLabel("Please Enter Your Name:");
	JTextField jt = new JTextField(20);
	JLabel msg = new JLabel("Please Select A County");
	JButton startGame = new JButton("Start Game");	
	
	
	
	// Create an Array to hold the County Names
		
	String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
										  "Tipparary", "WaterFord", "Limerick", "Galway", 
										  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
										  "WestMeath", "Offily", "Wexford", "Wicklow",
										  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
	
	JList listCounties = new JList(counties);
	
	
	
	// Constructor for Selecting a Team 
	public GameSelectTeam(){
		
		setTitle ("Select County");
		setSize (500, 500);
		setLocation(150, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create Container
		Container cPane = getContentPane();
		cPane.setBackground(Color.green);
		
		// Select Team Items
		listCounties.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCounties.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listCounties.getSelectedIndex();
				pf.setCounty(counties[index]);
				
			}
		});
		
		
		jt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jt(evt);
			}
		});
		
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pf.setName(jt.getText());
				JOptionPane.showMessageDialog(null, pf.toString());
				
			}
		});
		
		
		
		
		//pf.setCounty(county);
		
		// Add JLabel to container
		cPane.setLayout(new FlowLayout());
		cPane.add(playerName);
		cPane.add(nameLabel);
		cPane.add(jt);
		cPane.add(msg);
		cPane.add(listCounties);
		cPane.add(startGame);
		
	} // End of Constructor

	
	
	
	
	public void jt(ActionEvent e) {
		
		playerName.setText(jt.getText());
		nameLabel.setVisible(false);
		jt.setVisible(false);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		
	}

}
