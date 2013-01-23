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

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame
{
	//declare a GridBagConstraints for the gui cells configuration
	GridBagConstraints constraints;
	//declare the jlabel for the first line
	JLabel label1;
	//declare the jlabel for the first line (the second name)
	JLabel label2;
	//declare the jlabel for the second line
	JLabel label3;
	//declare the jlabel for the third line
	JLabel label4;
	
	public About()
	{
		//Set the about window title
		setTitle("About EVE Timer V2.0");
		//make the window to be closed when the close button is pressed
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//declare the window layout
		GridBagLayout layout = new GridBagLayout();
		//declare the layout constraints
		constraints = new GridBagConstraints();
		//Set the window layout
		setLayout(layout);
		
		//Set the default font
		Font font = new Font("Arial",Font.PLAIN,11);
		//set a GraphicsEnviroment so it can get the available fonts
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//Save the available fonts to a Strings Array
		String[] fonts = ge.getAvailableFontFamilyNames();
		//if the Comic Sans MS font is available uses it
		if(Arrays.asList(fonts).contains("Comic Sans MS")==true)
		{
			font = new Font("Comic Sans MS",Font.BOLD,12);
		}
		//set label1 to "Developed By Joaquin Lugo & "
		label1 = new JLabel("Developed By Joaquin Lugo & ");
		//Set the label1 font color for label1
		label1.setForeground(Color.BLUE);
		//set label2 to "Jessica Denisse"
		label2 = new JLabel("Jessica Denisse");
		//set the label2 font color to pink
		label2.setForeground(Color.PINK);
		//set label3 to "Released for be distributed for free"
		label3 = new JLabel("Released for be distributed for free");
		//Set label3 font color to black
		label3.setForeground(Color.BLACK);
		//Set the label4 to "and under the GNU General Public License"
		label4 = new JLabel("and under the GNU General Public License");
		//set the label4 font color to black
		label4.setForeground(Color.BLACK);
		//Set the components font to the font in variable font
		setFonts(font);
		//Add the label1 in the first line of the window
		addC(label1,0,0,1,1);
		//Add the label2 in the second part of the first line
		addC(label2,1,0,1,1);
		//Add the label3 en the second line of the window
		addC(label3,0,1,1,2);
		//Add the label4 in the third line of the window
		addC(label4,0,2,1,2);
		//make the window to fit the labels size
		pack();
		
		
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
	private void setFonts(Font f)
	{
		//Set the label1 font
		label1.setFont(f);
		//Set the label2 font
		label2.setFont(f);
		//Set the label3 font
		label3.setFont(f);
		//Set the label4 font
		label4.setFont(f);
	}
}
