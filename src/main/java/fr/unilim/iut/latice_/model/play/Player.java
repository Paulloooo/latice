package fr.unilim.iut.latice_.model.play;

import java.util.ArrayList;
import java.util.Scanner;

import fr.unilim.iut.latice_.model.tiles.decks.Stack;

public class Player {
	String pseudo;
	Stack rack;
	Integer points;
	Integer tilesPut;
	

	public Player(String pseudo, Stack rack, Integer points, Integer tilesPut) {
		this.pseudo = pseudo;
		this.rack = rack;
		this.points = points;
		this.tilesPut = tilesPut;
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

	public void setPoints(Integer points) {
		this.points = points;
	}

}
