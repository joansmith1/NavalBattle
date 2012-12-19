/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpii.navalbattle.data;

import java.util.*;
import javax.swing.*;

import com.jpii.navalbattle.gui.*;
import com.jpii.navalbattle.util.toaster.ToasterTest;

public class WindowHandler {
	
	private ArrayList<Window> windows;
	private static ToasterTest toasterManager;
	
	public WindowHandler(){
		toasterManager = new ToasterTest();
		windows = new ArrayList<Window>();
		initArray();
		windows.get(0).setVisible(true);
	}
	
	private void initArray(){
		windows.add(new LoginWindow());
		windows.add(new LoggingInWindow());
		windows.add(new LoginOptionsWindow());
		windows.add(new MainMenuWindow());
		windows.add(new SPOptions());
		windows.add(new HelpWindow());
		windows.add(new CreditsWindow());
	}
	
	public void setNewWindow(String a){
		for(int index = 0; index<windows.size(); index++){
			JFrame temp = (Window) windows.get(index);
			if(a.toLowerCase().equals( temp.getClass().toString().substring((getClass().toString().lastIndexOf("."))).toLowerCase() )){
				temp.setVisible(true);
			}
			else{
				temp.setVisible(false);
			}
		}
	}
	
	public void add(Window w){
		windows.add(w);
		w.setVisible(true);
	}
	
	/**
	 * Returns current instance of Toaster. Used to send desktop notifications.
	 * 
	 * @return toasterManager
	 */
	public ToasterTest getToasterManager() {
		return toasterManager;
	}
}
