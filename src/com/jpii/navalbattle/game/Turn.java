package com.jpii.navalbattle.game;

import com.jpii.navalbattle.pavo.grid.Entity;

public class Turn {
	private Player player;
	
	public Turn(Player player) {
		this.player = player;
	}
	
	public boolean canmoveEntity(Entity entity) {
		boolean flag=false;
		if(!flag)
			flag = player.myEntity(entity);
		if(!flag)
			flag = (entity.getMoved()>entity.getMaxMovement());
		return flag;
	}
}
