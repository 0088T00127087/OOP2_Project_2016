import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * Joe Enright
 * League Class
 * This will create the league table
 */


// This will be a constructor for generic type where the list of county will be stored in the league table

public class League extends County{
	
	String[]  counties = new String[]{"Antrim", "Cork", "Kerry", "Dublin", "Mayo", "Clare",
			  "Tipparary", "WaterFord", "Limerick", "Galway", 
			  "Rosscommon", "Sligo", "Leitrim", "Killkenny", "Meath",
			  "WestMeath", "Offily", "Wexford", "Wicklow",
			  "Tyrone", "Derry", "Monaghan", "Donegal", "Farmanagh"};
	

		public League(){
			
			JFrame jf = new JFrame();
			
			jf.setSize(500, 500);
			jf.setTitle("League");
			jf.setVisible(true);
			
			JTextField table = new JTextField();
			
			String msg= "";
			
			for(int i = 0; i < counties.length; i++){
				counties[i] += msg + "\n";
				table.append(msg);
			}
				
			jf.add(table);
			
			
			
			
		}

	
	

}
