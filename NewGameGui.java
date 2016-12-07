import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Joe Enright
 * First Gui to open.. 
 * Gives the player the option to create a new player or load existing player
 * 
 */
public class NewGameGui  {
	JFrame frame;
	Container cPane;
	JButton createBtn;
	JButton loadLeagueBtn;
	JButton loadChamBtn;
	
	public NewGameGui(){
		
	frame =  new JFrame("Fantasy Football");
	frame.setSize(600, 400);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(150,150);
	
	// Container for Gui components
	cPane = new Container();
	cPane.setLayout(null);
	cPane.setBackground(Color.GREEN);
	cPane.add(createBtn = new JButton("Create Player Profile"));
	cPane.add(loadLeagueBtn = new JButton("Load Previous League"));
	cPane.add(loadChamBtn = new JButton("Load Championship"));
	frame.add(cPane);
	// code for position of J components was taken from https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
	
	//Dimension size = leagueBtn.getPreferredSize();

	createBtn.setBounds(25, 20, 200, 50);
	loadLeagueBtn.setBounds(25, 100,200, 50);
	loadChamBtn.setBounds(250, 100, 200, 50);
	
	
	
	// Create event handler for buttons
	createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			CreatePlayerGui cpGui = new CreatePlayerGui();
			
		}
	});
	
	// Load save league game
	loadLeagueBtn.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				loadGame();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	
	// Load saved chapianship game
	
	loadChamBtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try{
				loadChampGame();
			}
			catch(ClassNotFoundException et){
				JOptionPane.showMessageDialog(null, et.toString());
			}
			
		}
	});
	
	
	

}// End of Constructor


	
	public static void loadGame() throws ClassNotFoundException{
		
		County [] c;
		PlayerProfile pf;
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream("league.dat"));
			c = (County[]) in.readObject();
			pf = (PlayerProfile) in.readObject();
			LeagueGameGui leagueGame = new LeagueGameGui(pf);
			JOptionPane.showMessageDialog(null, pf.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}// End of Load Game
	
	
	public static void loadChampGame()throws ClassNotFoundException {
		County [] g1, g2, g3, g4;
		PlayerProfile pf;
		ObjectInputStream in;
		
		try{
			in = new ObjectInputStream(new FileInputStream("champianship.dat"));
			g1 = (County[]) in.readObject();
			g2 = (County[]) in.readObject();
			g3 = (County[]) in.readObject();
			g4 = (County[]) in.readObject();
			pf = (PlayerProfile) in.readObject();
			
			ChampionShipGui chamGui = new ChampionShipGui(g1, g2, g3, g4,pf);
			
			for(int i = 0; i < g1.length; i++){
				System.out.println(g1[i].toString() + "\n");
			}
			}
			
		catch(IOException e){
			
			}
			
			
		}
		

	
}// End of Class
