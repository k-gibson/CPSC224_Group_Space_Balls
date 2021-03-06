/**
* Displays the dice rolled on the screen
* Tells the user what planets they have traveled to and the bonuses scored
* CPSC 224-01, Spring 2018
* Final Project - Race Through Space
* class RolledDiePanel.java
* @author Parker Mooseker
* @version v1.0 5/4/2018
*/

import javax.swing.*;
import javax.swing.Box.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class RolledDiePanel extends JPanel {

	private JPanel mainPanel = new JPanel();
	private JPanel wordsPanel = new JPanel();

	private int numRows = 2;
	private int numCols = 7;
	private Player thisPlayer;

	private JLabel[] rollOutcomes = new JLabel[(numRows * numCols)];
	private PlanetImage[] planetImages = new PlanetImage[7];
	private ImageIcon[] imageIcons = new ImageIcon[7];
	private JLabel[] dieLabels = new JLabel[7];
	private String[] dieNames = new String[]{ "MERCURY" , "VENUS", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE"};
	private ArrayList<String> travelLabel = new ArrayList<String>();
	private String dieName = "";

	/**
  	* RolledDie constructor calls the method to set up the panel and displays it on the screen
 	* @param Player player is the single player who rolled 
	* @param int numberOfTurns is the number of turn the player is on
	* @throws IOException is the planet images aren't found
  	*/
	public RolledDiePanel(Player player, int numberOfTurns) throws IOException {
		try {
			thisPlayer = player;
			setUpPanel();
			loadPlanetImages();
			
			this.setUpPanel();
			this.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	  * Sets up the panel with the dice images in a grid layout
	  * with labels that tell the user what they have scored in this roll
	  * @throws IOException if the planet images are not found
	  */
	private void setUpPanel() throws IOException {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.black);
		mainPanel.setLayout(new GridLayout(numRows, numCols));
		mainPanel.setBackground(new Color(0,0,0));
		mainPanel.setVisible(true);
		
		wordsPanel.setBackground(Color.black);
		this.add(mainPanel);
		
		Filler newSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
		// make the space 'see through'
		newSpace.setOpaque(false);
		this.add(newSpace);
		
		this.add(wordsPanel);
	}

	/**
	  * Loads the planet images in an array depending on the planet that was rolled on the die at the corresponding index
	  * @throws IOException if the planet images are not found
	  */
	private void loadPlanetImages() throws IOException {
		addDieLabels();
		
		for (int i = 0; i < 7; i++) {
			
			int playerHandVal = 0;
			
					
			switch (thisPlayer.getHandValue(i)){
			case ("MERCURY") : { playerHandVal = 0;
				break;}
			case ("VENUS") : { playerHandVal = 1;
				break;}
			case ("MARS") : { playerHandVal = 2;
				break;}
			case ("JUPITER") : { playerHandVal = 3;
				break;}
			case ("SATURN") : { playerHandVal = 4;
				break;}
			case ("URANUS") : { playerHandVal = 5;
				break;}
			case ("NEPTUNE") : { playerHandVal = 6;
				break;}
			}
			
			setTravelValue(i);
			planetImages[i] = new PlanetImage(playerHandVal);
	
			rollOutcomes[i] = new JLabel(imageIcons[i]);
			rollOutcomes[i].setIcon(new ImageIcon(planetImages[i].getImage()));
			rollOutcomes[i].setVerticalAlignment(JLabel.NORTH);
			rollOutcomes[i].setHorizontalAlignment(JLabel.CENTER);
			
			mainPanel.add(rollOutcomes[i]);
		}
		addTravelLabel();
		mainPanel.setVisible(true);	
	}

	/**
	  * Adds planet labels to the dice to tell the user which die is which
	  * sets the font, text size, and text color for the labels
	  */
	private void addDieLabels(){
			for(int i = 0; i <7 ; i++){
				dieLabels[i] = new JLabel(dieNames[i] + " DIE:");
				dieLabels[i].setVerticalAlignment(JLabel.NORTH);
				dieLabels[i].setHorizontalAlignment(JLabel.CENTER);
				dieLabels[i].setFont(new Font("Krungthep", 1, 18));
				dieLabels[i].setForeground(Color.white);
				dieLabels[i].setAlignmentX(Component.CENTER_ALIGNMENT);
				mainPanel.add(dieLabels[i]);
			}
		}
	
	/**
	  * Gets the face value of the dice rolled to set the dice picture to be displayed
	  * @param int index of the die whose face value is being checked
	  */
	public void setTravelValue(int index){
		if(thisPlayer.getHandValue(index)== dieNames[index]){
			dieName = dieNames[index];
			travelLabel.add(dieName);			
		}
	}
	
	/**
	  * Adds labels on the screen to tell the player which planets they have traveled to
	  */
	private void addTravelLabel(){	
		JLabel travelLabelx = new JLabel("You Traveled To: ");
		
		travelLabelx.setFont(new Font("Krungthep", 1, 25));
		travelLabelx.setForeground(Color.white);
		wordsPanel.add(travelLabelx);
		if(travelLabel.size() == 0) {
			JLabel none = new JLabel("0 planets");
			none.setFont(new Font("Krungthep", 1, 25));
			none.setForeground(Color.white);
			wordsPanel.add(none);	
		}
		else {
		for(String s : travelLabel){
			JLabel p = new JLabel(s);
			p.setFont(new Font("Krungthep", 1, 25));
			p.setForeground(Color.white);
			
			wordsPanel.add(p);
			wordsPanel.setVisible(true);
		}
		}
	}	
}
