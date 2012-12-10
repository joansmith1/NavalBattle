/*
 * Copyright (C) 2012 RoketGamer <http://roketgamer.com> and contributors.
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

package com.roketgamer.achievement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.roketgamer.Player;
import com.roketgamer.RoketGamer;

public class Achievement {
	private int id;
	
	/**
	 * Create a new <code>Achievement</code>.
	 * @param id
	 */
	public Achievement(int id) {
		this.id = id;
	}
	
	/**
	 * Get <code>Achievement</code> ID.
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Returns if current user has achieved achievement.
	 * @param player
	 */
	public boolean hasAchieved(Player player) {
		// TODO: Implement
		return false;
	}
	
	/**
	 * Submit an achievement. Returns if operation is successful.
	 * @param achievement
	 * @param id
	 * @return
	 */
	public boolean submit(Achievement achievement, int id) {
		try {
			URL url = new URL(RoketGamer.SERVER_LOCATION + "/api/" + RoketGamer.VERSION + "/achievement/submit.php?id=" + achievement.getID() + "?session=" + RoketGamer.getInstance().getSession().getSessionID().trim() + "&id=" + id);

			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String result = in.readLine();
			if (result.contains("true")) {
				in.close();
				return true;
				
			} else {
				in.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Returns the number of users who have completed the achievement.
	 * @return
	 */
	public int numberAchieved() {
		// TODO: Implement
		return 0;
	}
}