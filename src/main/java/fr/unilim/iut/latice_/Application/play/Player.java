package fr.unilim.iut.latice_.Application.play;

import java.util.ArrayList;
import java.util.Scanner;

import latice.model.tiles.decks.Stack;

public class Player {
	String pseudo;
	Stack rack;
	Integer points = 0;
	
	public Player(String pseudo, Stack rack) {
		this.pseudo = pseudo;
		this.rack = rack;
		this.points = points;
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
	

}
