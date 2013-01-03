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

/**
 * The Pavo Engine
 */
package com.jpii.navalbattle.pavo;

import java.awt.Toolkit;

import maximusvladimir.dagen.Rand;

/**
 * @author MKirkby
 *
 */
public class PavoSettings {
	public PavoSettings() {
		
	}
	public int initialWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
	public int initialHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	public int currentWidth = initialWidth;
	public int currentHeight = initialHeight;
	public long seed = (int)(Math.random() * 256);//(long)(Math.random() * (Long.MAX_VALUE - 1)); 234,162,130 are good seeds.
	public Rand rand = new Rand(seed);
	public boolean OverClock = true;
	public boolean isGameFullscreen = false;
	
	public boolean hasGameBeenModded = false;
}
