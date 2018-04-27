import javax.swing.*;
import javax.swing.Box.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.io.IOException;
import java.util.Map;

public class NumberOfPlayers extends JFrame implements ActionListener{
	private SpaceImage spaceImage;
	private JLayeredPane finalPanel = getLayeredPane();
	private JPanel mainPanel = new JPanel();
	private JTextField input = new JTextField (2);
	private JButton enterButton = new JButton("ENTER");
	
	private int numberOfPlayers;
	
	private static final int defaultWidth = 1200;
    private static final int defaultHeight = 800;
	
	public NumberOfPlayers() {
		setSize(defaultWidth, defaultHeight);
		createBackgroundImage(); 
		createMainPanel();

	}
	
	public int getPlayerNumber() {
		return numberOfPlayers;
	}
	
	private void createMainPanel() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(new java.awt.Color(40,23,35));
        mainPanel.setPreferredSize(new Dimension(defaultWidth,defaultHeight - 120));
        
     	//define a blank space for formatting purposes
        Filler space = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 180));
        //make the space 'see through'
  	    space.setOpaque(false);
  	    mainPanel.add(space);
        
        JLabel getNumber = new JLabel("Please Enter Number of Players:");
        getNumber.setFont(new Font("Krungthep",1,35));
  	  	Font font = getNumber.getFont();
  	  	Map attributes = font.getAttributes();
  	  	attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
  	  	getNumber.setFont(font.deriveFont(attributes));
        getNumber.setForeground(Color.white);
        getNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
  	  	mainPanel.add(getNumber);
  	  	
  	  	Filler newSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 20));
	    newSpace.setOpaque(false);
	    mainPanel.add(newSpace);
  	  	
  	  	input.setMaximumSize(new Dimension(50, 30));
  	  	mainPanel.add(input);
  	  	
  	  	setUpEnterButton();
  	  	mainPanel.add(enterButton);
  	  
  	    Filler blankSpace = new Filler(new Dimension(0, 80), new Dimension(0, 80), new Dimension(Short.MAX_VALUE, 80));
  	    blankSpace.setOpaque(false);
  	    mainPanel.add(blankSpace);
  	    
	  	//this is so the background image can been seen
	  	mainPanel.setOpaque(false);
	  	//this is for the JLayeredPane
	  	mainPanel.setBounds(0, 0, defaultWidth, defaultHeight);
	  	finalPanel.add(mainPanel, JLayeredPane.PALETTE_LAYER);
	}
	
	private void setUpEnterButton() {
		enterButton.setOpaque(true);
        enterButton.setFont(new Font("Krungthep",Font.BOLD,20));
        enterButton.setBackground(new Color(67,39,59));
        enterButton.setForeground(Color.WHITE);
        enterButton.setFocusPainted(false);
        enterButton.setBorderPainted(false);
        enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        enterButton.addActionListener(this); 
	}
	
	 public void actionPerformed(ActionEvent e) {
       	 String userInput = input.getText();
       	 numberOfPlayers = Integer.parseInt(userInput);
       	 System.out.println(numberOfPlayers);
       	 this.setVisible(false);
     }
	
	private void createBackgroundImage() {
		try {
    		spaceImage = new SpaceImage("/Users/kategibson/eclipse-workspace/gameGUI/components/fancyStars.jpg");
    		spaceImage.setPreferredSize(new Dimension(defaultWidth,defaultHeight));
    		spaceImage.setBackground(new java.awt.Color(40,23,35));
    		spaceImage.setBounds(0, 0, defaultWidth, defaultHeight); 
    	} catch (IOException e) {
    		JLabel oops = new JLabel("oops");
    		this.add(oops);
    	}
		
		finalPanel.add(spaceImage, JLayeredPane.DEFAULT_LAYER);
	}
}