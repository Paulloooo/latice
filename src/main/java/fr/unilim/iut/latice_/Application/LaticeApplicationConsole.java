package fr.unilim.iut.latice_.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.unilim.iut.latice_.Application.play.Player;
import fr.unilim.iut.latice_.Application.play.Tour;
import latice.model.Gameboard;
import latice.model.tiles.Color;
import latice.model.tiles.Shape;
import latice.model.tiles.Tile;
import latice.model.tiles.decks.Deck;
import latice.model.tiles.decks.Rack;
import latice.model.tiles.decks.Stack;
import latice.model.tiles.decks.StandardDeck;


public class LaticeApplicationConsole {

	public static void main(String[] args) {
		ArrayList<Player> listePlayers = new ArrayList<Player>();
		ArrayList<Tile> listeTilesPlacees = new ArrayList<Tile>();
		Gameboard plateau = new Gameboard();
		Stack rack = new StandardDeck();
		Deck deckj1 = new Deck();
		Deck deckj2 = new Deck();
		Rack rackj1 = new Rack();
		Rack rackj2 = new Rack();
		deckj1.buildDeck(rack.tiles);
		deckj2.buildDeck(rack.tiles);
		rackj1.buildRack(deckj1.getDeck());
		rackj2.buildRack(deckj2.getDeck());
		plateau.showGameboard(plateau);
		Tour tour = new Tour();
		Player j1 = new Player("j1", rackj1, 0);
		Player j2 = new Player("j2", rackj2, 0);
		Integer compteurTour = 0;
		
	    int firstPick = (int)Math.floor(Math.random()*2);
		while(compteurTour<10&&(deckj1.isEmpty()==false&&deckj2.isEmpty()==false)) {
			if (firstPick==1){
				System.out.print("J1 ");
				tour.choixTour(deckj1, rackj1, plateau, compteurTour, j1);
				System.out.println(j1.getPoints()+" points");
				compteurTour++;
				System.out.print("J2 ");
				tour.choixTour(deckj2,rackj2, plateau,compteurTour, j2);
				System.out.println(j2.getPoints()+" points");
			}else {
				System.out.print("J2 ");
				tour.choixTour(deckj2,rackj2, plateau,compteurTour,j2);
				System.out.println(j2.getPoints()+" points");
				compteurTour++;
				System.out.print("J1 ");
				tour.choixTour(deckj1, rackj1, plateau, compteurTour,j1);
				System.out.println(j1.getPoints()+" points");

			}
		}
	}

}
