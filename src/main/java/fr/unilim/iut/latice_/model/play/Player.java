package fr.unilim.iut.latice_.model.play;

import java.util.ArrayList;
import java.util.Scanner;

import fr.unilim.iut.latice_.model.tiles.decks.Stack;

public class Player {
	String pseudo;
	Stack rack;
	public Integer points;
	Integer tilesPut;
	public Integer actions;
	

	public Player(String pseudo, Stack rack, Integer points, Integer tilesPut, Integer actions) {
		this.pseudo = pseudo;
		this.rack = rack;
		this.points = points;
		this.tilesPut = tilesPut;
		this.actions = actions;
	}

	public String getPseudo() {
		return pseudo;
	}

	public Stack getRack() {
		return rack;
	}

	public Integer getPoints() {
		return points;
	}
	
	public Integer getTilesPut() {
		return points;
	}
	
	public Integer getActions() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public void setActions(Integer actions) {
		this.actions = actions;
	}

}
