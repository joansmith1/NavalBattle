/**
 * 
 */
package com.jpii.navalbattle.pavo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.jpii.navalbattle.renderer.Helper;

/**
 * @author MKirkby
 *
 */
public class MessageBox extends com.jpii.navalbattle.pavo.GameWindow {
	String message = "no msg";
	MessageBoxIcon icon;
	private MessageBox(String title, String message,MessageBoxIcon icon) {
		super();
		this.icon = icon;
		setTitle(title);
		this.message = message;
		String[] lines = message.split("\n");
		int lg = 0;
		for (int v = 0; v < lines.length; v++) {
			if (lines[v].length() > lg) {
				lg = lines[v].length();
			}
		}
		int w = lg * 10;
		int h = 125 + (16 * lines.length);
		setSize(w,h);
		setLoc((DynamicConstants.WND_WDTH/2)-(w/2),(DynamicConstants.WND_HGHT/2)-(h/2));
		render();
	}
	/**
	 * Shows a message box on the active Game window, with a title and message.
	 * @param title The title that the message box should have.
	 * @param message The message that the message box should have.
	 */
	public static void show(String title, String message) {
		show(title,message,MessageBoxIcon.None);
	}
	/**
	 * Shows a message box on the active Game window, with a title, special icon, and message.
	 * @param title The title that the message box should have.
	 * @param message The message that the message box should have.
	 * @param iconifier The icon to show on the message box.
	 */
	public static void show(String title, String message, MessageBoxIcon iconifier) {
		show(title,message,iconifier,false);
	}
	/**
	 * Shows a message box on the active Game window, with a title, special icon, gives the option of hiding the backrouns, and message.
	 * @param title The title that the message box should have.
	 * @param message The message that the message box should have.
	 * @param iconifier The icon to show on the message box.
	 * @param blotchBackground If set to true, the background will be blocked from user interaction, and blurred out.
	 */
	public static void show(String title, String message, MessageBoxIcon iconifier, boolean blotchBackground) {
		//WindowManager.Inst.add(new MessageBox(title,message));
		MessageBox handle = new MessageBox(title,message,iconifier);
		if (blotchBackground) {
			WindowManager.Inst.ianOwjej10nJAnin345soaKOEe9201LIQUICK(handle);
		}
		else
			WindowManager.Inst.add(handle);
	}
	public void render() {
		super.render();
		Graphics2D g = PavoHelper.createGraphics(getBuffer());
		if (icon == MessageBoxIcon.Error) {
			g.setColor(Color.red);
			int size = (getHeight()/2);
			g.setStroke(new BasicStroke(9));
			g.drawOval(getWidth()-(size+8), ((size+13)/2), size,size);
			g.setStroke(new BasicStroke(4));
			g.drawLine(getWidth()-(size+8)+15, ((size+13)/2)+15, getWidth()-(size+8)+size-15, ((size+13)/2)+size-15);
			g.setStroke(new BasicStroke(1));
		}
		g.setColor(Color.black);
		g.setFont(Helper.GUI_GAME_FONT);
		String[] lines = message.split("\n");
		for (int v = 0; v < lines.length; v++) {
			g.drawString(lines[v], 5, 40 + (v*14));
		}
		g.setColor(getBackgroundColor().darker().darker());
		g.fillRoundRect((getWidth()/2)-30, (getHeight()-36), 60, 24, 5,5);
		g.setColor(Color.black);
		g.drawRoundRect((getWidth()/2)-30, (getHeight()-36), 60, 24, 5,5);
		g.drawString("OK",(getWidth()/2)-8, (getHeight()-18));
	}
	public boolean checkOtherDown(MouseEvent me) {
		int mx = me.getX();
		int my = me.getY();
		if (mx >= (getWidth()/2)-30+getX() && mx <= (getWidth()/2)+30+getX() && my >= (getHeight()-36)+getY() && my <= (getHeight()-18)+getY()) {
			onCloseCalled();
			return true;
		}
		return false;
	}
	public void onCloseCalled() {
		getWinMan().remove(this);
	}
}
