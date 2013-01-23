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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Options extends JFrame
{
	
	GridBagConstraints constraints = new GridBagConstraints();
	JLabel guiOptions = new JLabel("GUI Configs");
	JLabel filesOptions = new JLabel("Files Configs");
	JLabel timerOptions = new JLabel("Timer Configs");
	
	public Options()
	{
		GridBagLayout layout = new GridBagLayout();
		setTitle("EVE Timer V2.0 Configs");
		setLayout(layout);
		int dX = guiOptions.getHeight();
		
		addC(guiOptions,0,0,1,1);
		addC(new Empty(25,dX),1,0,1,1);
		addC(new JLabel("|"),2,0,1,1);
		addC(new Empty(25,dX),3,0,1,1);
		addC(filesOptions,4,0,1,1);
		addC(new Empty(25,dX),5,0,1,1);
		addC(new JLabel("l"),6,0,1,1);
		addC(new Empty(25,dX),7,0,1,1);
		addC(timerOptions,8,0,1,1);
		
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
		guiOptions.setFont(f);
		filesOptions.setFont(f);
		timerOptions.setFont(f);
	}
}
