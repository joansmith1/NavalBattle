package com.jpii.navalbattle.turn;

import com.jpii.navalbattle.pavo.grid.Entity;

public class TurnManager {
	
	Turn currentTurn;
	public int turnnumber;
	public byte playernumber;
	PlayerManager players;
	
	public TurnManager(PlayerManager pm){
		players = pm;
		turnnumber=0;
		currentTurn = new Turn(players.getPlayer(turnnumber));
	}
	
	public void nextTurn(){
		currentTurn.endTurn();
		turnnumber++;
		currentTurn = new Turn(players.getPlayer(turnnumber));
		currentTurn.takeTurn();
		if(currentTurn.isDone()){
			nextTurn();
		}
	}
	
	public Turn getTurn(){
		return currentTurn;
	}

	public int getTurnNumber(){
		return turnnumber;
	}
	
	public void addEntity(Entity e,Player p){
		p.addEntity(e);
	}
	
	public Player getPlayer(int pos){
		return players.getPlayer(pos-1);
	}
	
}
