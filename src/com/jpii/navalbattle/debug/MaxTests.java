package com.jpii.navalbattle.debug;

import com.jpii.navalbattle.pavo.FastMath;
import com.jpii.navalbattle.util.GrammarManager;

import maximusvladimir.dagen.Rand;

/**
 * Added to prevent conflicting diffs in NavalBattle.java. This is Max's file to play with.
 * @author MKirkby
 *
 */
public class MaxTests {
	public static void run() {
		/*ArrayList<SettingsAttribute> attrs = new ArrayList<SettingsAttribute>();
		SettingsAttribute a = new SettingsAttribute("lastGoodUserName");
		attrs.add(a);
		a = new SettingsAttribute("lastGoodPassword");
		attrs.add(a);
		a = new SettingsAttribute("gameWindowWidth");
		attrs.add(a);
		a = new SettingsAttribute("gameWindowHeight");
		attrs.add(a);
		java.net.URL url = null;
		try {
			url = new java.net.URL("C:\\navalbattle\\settings.ini");
		} catch (Exception e) { 
			e.printStackTrace();
		}
		if (url != null && new File(url.getPath()).exists()) {
		SettingsReader reader = new SettingsReader(url.getPath(),attrs);
		reader.read();
		}*/
		Rand r = new Rand();
		for (int c = 0; c < 3; c++) {
			System.out.println(GrammarManager.generateFullName(r.nextInt()));
		}
		System.out.println("Fast Math calc: " + FastMath.sin(0.14235));
		System.out.println("Java Math calc: " + Math.sin(0.14235*(Math.PI/2)));
	}
	public static boolean isFirstRun() {
		return true;
	}
}
