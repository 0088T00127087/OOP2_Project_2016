import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Joe Enright
 * First Gui to open.. 
 * Gives the player the option to create a new player or load existing player
 * 
 */
public class NewGameGui implements ActionListener {
	JFrame frame;
	Container cPane;
	JButton createBtn;
	JButton loadBtn;
	
	public NewGameGui(){
		
	frame =  new JFrame("Fantasy Football");
	frame.setSize(500, 500);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(150,150);
	
	// Container for Gui components
	cPane = new Container();
	cPane.setLayout(null);
	cPane.setBackground(Color.GREEN);
	cPane.add(createBtn = new JButton("Create Player Profile"));
	cPane.add(loadBtn = new JButton("Load Game"));
	frame.add(cPane);
	// code for position of J components was taken from https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
	
	//Dimension size = leagueBtn.getPreferredSize();
	Dimension size = new Dimension(200, 100);
	createBtn.setBounds(25, 5, size.width, size.height);
	loadBtn.setBounds(250, 5, size.width, size.height);
	
	
	
	// Create event handler for buttons

	createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			CreatePlayerGui cpGui = new CreatePlayerGui();
			
		}
	});
	
	
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
