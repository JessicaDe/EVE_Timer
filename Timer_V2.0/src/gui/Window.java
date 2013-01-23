/* «Copyright 2013 Joaquin Lugo, Jessica Denisse» */
/*  This file is part of EVE_Timer

    EVE_Timer is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    EVE_Timer is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with EVE_Timer.  If not, see <http://www.gnu.org/licenses/>.  */

package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSpinner;



public class Window extends JFrame 
{
	
	private JMenu options;
	private JMenu about;
	private JLabel timeLabel;
	private JLabel hoursLabel;
	private JLabel minutesLabel;
	private JLabel secondsLabel;
	private JLabel remainingLabel;
	private JLabel remainingHoursLabel;
	private JLabel remainingMinutesLabel;
	private JLabel remainingSecondsLabel;
	private JSpinner spinHours;
	private JSpinner spinMinutes;
	private JSpinner spinSeconds;
	private JCheckBox alwaysAtTopCheckbox;
	GridBagConstraints constraints;
	private JButton startButton;
	private JButton pauseButton;
	private JButton resetButton;
	int eX = 0;
	int eY = 0;
	
	public Window()
	{
	//----------GUI Declarations-----------------------------------
		//Declare the Layout that the gui will use
		GridBagLayout layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		
		//Declare the Menu Bar
		JMenuBar menu = new JMenuBar();
		//Declare the Menu "Options"
		options = new JMenu("Options");
		//Declare the Menu "About"
		about = new JMenu("About");
		//Container for the top labels (Time: Hours, Minutes, Seconds)
		Container labels1 = new Container();
		//Container for the time spinners
		Container spinners = new Container();
		//Container for the Remaining Label
		Container label2 = new Container();
		//Container for the remaining time labels
		Container countlabels = new Container();
		//Container for the always at top checkbox
		Container checkbox = new Container();
		//Container for the control buttons
		Container buttons = new Container();
		//JLabel for the set time
		timeLabel = new JLabel("Time:");
		//JLabel for the set hours
		hoursLabel = new JLabel("Hours");
		//JLabel for the set minutes
		minutesLabel = new JLabel("Minutes");
		//JLabel for the set seconds
		secondsLabel = new JLabel("Seconds");
		//JLabel for the remaining time
		remainingLabel = new JLabel("Remaining:");
		//JLabel for the remaining Hours
		remainingHoursLabel = new JLabel("00");
		//JLabel for the remaining minutes
		remainingMinutesLabel = new JLabel("00");
		//JLabel for the remaining seconds
		remainingSecondsLabel = new JLabel("00");
		//JSpinner for hours input
		spinHours = new JSpinner();
		//JSpiner for mintues input
		spinMinutes = new JSpinner();
		//JSpiner for seconds input
		spinSeconds = new JSpinner();
		//JCheckbox for the always at top
		alwaysAtTopCheckbox = new JCheckBox("Always at top?");
		//JButton for start the count
		startButton = new JButton("Start");
		//JButton for pause the count
		pauseButton = new JButton("Pause");
		//JButton for reset the count
		resetButton = new JButton("Reset");
	//----------Font Declarations------------------------------
		//Set the default font
		Font font = new Font("Arial",Font.PLAIN,11);
		//set a GraphicsEnviroment so it can get the available fonts
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//Save the available fonts to a Strings Array
		String[] fonts = ge.getAvailableFontFamilyNames();
	//-----------GUI Configurations----------------------------
		//Set the window Layout
		setLayout(layout);
		//Set the window Name
		setTitle("EVE Timer V2.0");
		//Make the window Visible
		setVisible(true);
		//Set the window Size
		setSize(260,130);
		//Make the Application to exit when the main window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set the window menu bar
		setJMenuBar(menu);
		//Adds the Menu "Options" to the menu bar
		menu.add(options);
		//Adds the Menu "about" to the menu bar
		menu.add(about);
		//Set the components default font
		setFonts(font);
		//Calculate the default height and width for the empty components (spaces) between the gui components
		eX = getWidth()/20;
		eY = getHeight()/20;
	//------Add the components to the gui-------------
		//----------First Line---------------
		//Add the "Time:" Label to the gui
		addC(timeLabel,0,0,1,1);
		//Add the separator between the "Time:" Label and the "Hours" Label to the gui
		addC(new Empty(eX,eY),1,0,1,1);
		//Add the "Hours" Label to the gui
		addC(hoursLabel,2,0,1,1);
		//Add the separator between the "Hours" Label and the "Minutes" Label to the gui
		addC(new Empty(eX,eY),3,0,1,1);
		//Add the "Minutes" Label to the gui
		addC(minutesLabel,4,0,1,1);
		//Add the separator between the "Minutes" Label and the "Seconds" Label to the gui
		addC(new Empty(eX,eY),5,0,1,1);
		//Add the "Seconds" Label to the gui
		addC(secondsLabel,6,0,1,1);
		//Adds the separator between the "Seconds" Label and the "Start" Buton to the gui
		addC(new Empty(eX,eY),7,0,1,1);
		//Set the layout manager for put the next components in the center of the cell (Height of 2)
		constraints.anchor = GridBagConstraints.CENTER;
		//Get the dimensions of the pause button
		Dimension db = pauseButton.getPreferredSize();
		//Set the size of the pause button to the start button so they are of the same size
		startButton.setPreferredSize(db);
		//Add the start button to the gui
		addC(startButton,8,0,1,2);
		//------------Second Line---------------
		//Add an empty space in the "Time" Label zone
		addC(new Empty(timeLabel.getSize()),0,1,1,1);
		//Add the separator between the "Time" Label and the hours spinner
		addC(new Empty(eX,eY),1,1,1,1);
		//Add the hours spinner to the gui
		addC(spinHours,2,1,1,1);
		//Get the minimum size of the hours spinner
		Dimension ds = spinHours.getMinimumSize();
		//Set the width of the spinner at 1.25 times the default size (so it can show up to 2 numbers)
		spinHours.setPreferredSize(new Dimension((int)(ds.width*1.25),ds.height));
		//Add an empty space between the hours spinner and the minutes spinner
		addC(new Empty(eX,eY),3,1,1,1);
		//Set the width of the spinner at 1.25 times the default size (so it can show up to 2 numbers)
		spinMinutes.setPreferredSize(new Dimension((int)(ds.width*1.25),ds.height));
		//Add the minutes spiner to the gui
		addC(spinMinutes,4,1,1,1);
		//Add an empty space between the minutes spinner and the seconds spinner
		addC(new Empty(eX,eY),5,1,1,1);
		//Add the seconds spinner to the gui
		addC(spinSeconds,6,1,1,1);
		//Set the width of the spinner at 1.25 times the default size (so it can show up to 2 numbers)
		spinSeconds.setPreferredSize(new Dimension((int)(ds.width*1.25),ds.height));
		//------------------Third Line-----------------------
		//Set the layout manager to put the next components at the west of the cell
		constraints.anchor = GridBagConstraints.WEST;
		//Add the "Remaining:" Label to the gui
		addC(remainingLabel,0,2,1,3);
		//Set the layout manager to put the next components at the center of the cell
		constraints.anchor = GridBagConstraints.CENTER;
		//Add the "Pause" Button to the gui
		addC(pauseButton,8,2,1,2);
		//----------Fourth Line-----------------
		//Add an empty space in the "Time" Label zone
		addC(new Empty(timeLabel.getSize()),0,3,1,1);
		//Add an empty space between the "Time" Label zone and the remaining time label
		addC(new Empty(eX,eY),1,3,1,1);
		//Add the remaining hours label to the gui
		addC(remainingHoursLabel,2,3,1,1);
		//Add an empty space between the hours label and the minutes label
		addC(new Empty(eX,eY),3,3,1,1);
		//Add the remaining minutes label to the gui
		addC(remainingMinutesLabel,4,3,1,1);
		//Add an empty space between the minutes label and the seconds label
		addC(new Empty(eX,eY),5,3,1,1);
		//Add the remaining seconds label
		addC(remainingSecondsLabel,6,3,1,1);
		//-----------Fifth Line-------------
		//Set the layout manager to put the next components at the west of the cell
		constraints.anchor = GridBagConstraints.WEST;
		//Add the "Always at top?" Checkbox to the gui
		addC(alwaysAtTopCheckbox,0,4,1,5);
		//Add an empty space between the "Always at top?" Checkbox and the "Reset" Button
		addC(new Empty(eX,eY),7,3,1,1);
		//Set the layout manager to put the next components at the center of the cell
		constraints.anchor = GridBagConstraints.CENTER;
		//Set the "Pause" button size to the "Reset" Button
		resetButton.setPreferredSize(db);
		//Add the "Reset" Button to the gui
		addC(resetButton,8,4,1,2);
		//Make the window size fit the components size
		pack();
	//------------------Actions-------------------------------
		//Adds an action Listener to the Options Menu
		options.addActionListener(new ActionListener()
		{
				//actionPerformed method is called when the user press the menu options
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					//create an object of the class Options
					new Options();
				}
		});
		//Adds an action Listener to the About Menu
		about.addActionListener(new ActionListener()
		{
			//actionPerformed method is called when the user press the menu about
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//Create an object of the class About
				new About();
			}
		});
	}
	//---------------------Methods-----------------------
	private void setFonts(Font font)
	{
		//Set the Menu Bar font
		options.setFont(font);
		//Set the About Menu Font
		about.setFont(font);
		//Set the time label font
		timeLabel.setFont(font);
		//set the hours label font
		hoursLabel.setFont(font);
		//set the minutes label font
		minutesLabel.setFont(font);
		//Set the seconds label font
		secondsLabel.setFont(font);
		//Set the remaining label font
		remainingLabel.setFont(font);
		//Set the always at top checkbox font
		alwaysAtTopCheckbox.setFont(font);
		//Set the start button font
		startButton.setFont(font);
		//Set the pause button font
		pauseButton.setFont(font);
		//Set the reset button font
		resetButton.setFont(font);
	}
	private void addC(Component obj,int x, int y, int al, int an)
	{
		//Set the column of the component
		constraints.gridx = x;
		//Set the row of the component
		constraints.gridy = y;
		//Set the number of rows of the component
		constraints.gridheight = al;
		//Set the number of columns of the component
		constraints.gridwidth = an;
		//Add the object to the gui in the specified position
		add(obj,constraints);

	}
}
