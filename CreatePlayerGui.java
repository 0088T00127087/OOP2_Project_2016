import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/*
 * Joe Enright
 * Gui to create a player profile
 */
public class CreatePlayerGui implements ActionListener {
	
	// Instance Variables
	JFrame frame;
	Container cPane;
	JLabel nameLbl;
	JLabel countyLbl;
	JTextArea nameTxtBox;
	JScrollPane scPane;
	JTextArea countyTxtBox;
	JButton clrBtn;
	JButton startBtn;
	int index;
	String countyName;
	
	PlayerProfile pf = new PlayerProfile();
	
	
	// Array of County Names
	String [] counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
			  "Tipparary", "WaterFord", "Limerick", "Galway", 
			  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
			  "WestMeath", "Offily", "Wexford", "Wicklow",
			  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
	
	JList listCounties = new JList(counties);
	
	public CreatePlayerGui(){
		
	
	frame =  new JFrame("Create Player");
	frame.setSize(300, 300);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	frame.setLocation(150,150);
	
	// Container for Gui components
	cPane = new Container();
	cPane.setLayout(null);
	cPane.setBackground(Color.GREEN);
	cPane.add(nameLbl = new JLabel("Player Name"));
	cPane.add(countyLbl = new JLabel("Select County"));
	cPane.add(nameTxtBox = new JTextArea()); 
	//cPane.add(countyTxtBox = new JTextArea());
	cPane.add(scPane = new JScrollPane(listCounties));
	cPane.add(clrBtn = new JButton("Clear"));
	cPane.add(startBtn = new JButton("Start Game"));
	
	
	frame.add(cPane);
	
	    //Dimensions and positions
		nameLbl.setBounds(25, 5, 100, 25);
		nameTxtBox.setBounds(150, 5, 100, 25);
		
		countyLbl.setBounds(25, 80, 100, 25);
		scPane.setBounds(150,80, 100, 25);
		
		clrBtn.setBounds(25, 150, 100, 25);
		startBtn.setBounds(150, 150, 100, 25);
	
		
	
		// ActionsListener for buttons
		
		clrBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nameTxtBox.setText("");
				countyTxtBox.setText("");
			}
		});
		
		listCounties.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCounties.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			  index = listCounties.getSelectedIndex();
			  pf.setcountyName(counties[index]);
				
			}
		});
	
		
		// To Start the game and create a new player profile
		startBtn.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				
				if(nameTxtBox.getText() == ""){
					JOptionPane.showMessageDialog(null, "Please enter a name");
					nameTxtBox.getFocusListeners();
				}
				
				pf.setName(nameTxtBox.getText());
				pf.setGamesPlayed(0);
				System.out.println(pf.toString());
				// Passing into the constructor by reference to the instance of the object created above
				GameTypeGui ng = new GameTypeGui(pf);
				
			}
		});
	
	
	// code for position of J components was taken from https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
	
	

	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
