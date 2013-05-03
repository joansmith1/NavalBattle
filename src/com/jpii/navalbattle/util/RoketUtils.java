package com.jpii.navalbattle.util;

import javax.swing.ImageIcon;

import com.jpii.navalbattle.NavalBattle;
import com.roketgamer.achievement.Achievement;
import com.roketgamer.leaderboard.Leaderboard;

public class RoketUtils {
	
	/**
	 * Quickly submit a <code>Leader-board</code> to the server. Checks if off-line or if game is out-dated.
	 * @param leaderboard
	 * @param score
	 */
	public static void submitLeaderboard(Leaderboard leaderboard, int score) {
		if(!NavalBattle.getGameState().isOffline()) {
			if(!NavalBattle.getBroadcastService().needsUpdate()) {
				leaderboard.submit(score);
				NavalBattle.getWindowHandler().getToasterManager().showToaster(
						new ImageIcon(RoketUtils.class.getResource("/com/roketgamer/res/logo_100px.png")),
						"Submitted score of " + score + " to server");
			} else {
				NavalBattle.getDebugWindow().printWarning("NavalBattle is outdated. Score cannot be submitted.");
			}
		} else {
			NavalBattle.getDebugWindow().printWarning("NavalBattle is offline. Score cannot be submitted.");
		}
	}
	
	/**
	 * Quickly submit an <code>Achievement</code> to the server. Checks if off-line or if game is out-dated.
	 * @param achievement
	 * @param score
	 */
	public static void submitAchievement(Achievement achievement, int score) {
		if(!NavalBattle.getGameState().isOffline()) {
			if(!NavalBattle.getBroadcastService().needsUpdate()) {
				achievement.submit();
				NavalBattle.getWindowHandler().getToasterManager().showToaster(
						new ImageIcon(NavalBattle.class.getResource("/com/roketgamer/res/logo_100px.png")), 
						"Achievement Unlocked!\n" + achievement.getName());
				
				NavalBattle.getDebugWindow().printInfo("Achievement \"" + achievement.getName() + "\" submitted.");
			} else {
				NavalBattle.getDebugWindow().printWarning("NavalBattle is outdated. Acheivement cannot be submitted.");
			}
		} else {
			NavalBattle.getDebugWindow().printWarning("NavalBattle is offline. Achievement cannot be submitted.");
		}
	}
}
