/*
 * Joe Enright
 * This is the main menu class
 */

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainMenu extends JFrame  implements ActionListener {
	
	
	   
	//Constructor for the Main Menu of the game
	public MainMenu(){
		
		// Give initial Values to the JFrame for the Main menu
		
		setTitle ("Fantasy Football");
		setSize (300, 300);
		setLocation(150, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// Container for main menu items
		Container cPane = getContentPane();
		cPane.setBackground(Color.green);
		
		
		// Main Menu Items
		JButton nGame = new JButton("New Game");
		JButton lGame = new JButton("Load Game");
		JButton exitGame = new JButton("Exit Game");
		JLabel  msg = new JLabel("Welcome to Fantasy Football");
		
		
		// Add Action listener for the buttons
		
		
		nGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				nGame(evt);
			}
		});
		
		// Exit Game button action listener
		exitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitGame(evt);
            }
        });
		
		
		
		// Define the Flow of the Menu using Grid Layout
		cPane.setLayout(new FlowLayout());
		
		// Add the elements to the Container Pane
		cPane.add(msg);
		cPane.add(nGame);
		cPane.add(lGame);
		cPane.add(exitGame);
		
	}

	// Method for loading new game Gui
	public void nGame(ActionEvent e) {
		
		GameSelectTeam ng = new GameSelectTeam();
				ng.setVisible(true);
		
	}
	
	// Method for closing the game
	private void exitGame(ActionEvent evt) {                                         
       
        this.setVisible(false);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}    

}
