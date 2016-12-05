import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Joe Enright
 * Gui for league game type
 * 
 */
public class GameTypeGui extends CreatePlayerGui implements ActionListener {

	JFrame frame;
	Container cPane;
	JButton leagueBtn;
	JButton champBtn;
	JLabel nameLbl;
	JLabel countyLbl;
	
	public GameTypeGui(PlayerProfile pf){
		
	//PlayerProfile pf1 = new PlayerProfile();	
	
	frame =  new JFrame("Choose a Game Type");
	frame.setSize(500, 500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(150,150);
	
	
	String pltitle = "Manager: ";
	String plCounty = "County: ";
	
	// Container for Gui components
	cPane = new Container();
	cPane.setLayout(null);
	cPane.setBackground(Color.green);
	cPane.add(nameLbl = new JLabel(pltitle + pf.getName()));
	cPane.add(countyLbl = new JLabel(plCounty + pf.getcountyName()));
	cPane.add(leagueBtn = new JButton("League"));
	cPane.add(champBtn = new JButton("Championship"));
	
	frame.add(cPane);
	// code for position of J components was taken from https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
	
	//Dimension size = leagueBtn.getPreferredSize();
	Dimension size = new Dimension(200, 100);
	//int width = 30;
	//int height = 20;
	
	leagueBtn.setBounds(25, 50, size.width, size.height);
	champBtn.setBounds(250, 50, size.width, size.height);
	nameLbl.setBounds(10, 1, 500, 25);
	countyLbl.setBounds(10,20, 500, 25);
	
	
	
	
	
	
	
		
	}
	
	
	public void playerProfile(PlayerProfile pf){
		
		pf.toString();
	}
	
	
	
	
	
}
