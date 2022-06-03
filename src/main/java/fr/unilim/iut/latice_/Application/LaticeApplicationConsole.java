package fr.unilim.iut.latice_.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.play.Player;
import fr.unilim.iut.latice_.model.play.Referee;
import fr.unilim.iut.latice_.model.play.Turn;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Deck;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import fr.unilim.iut.latice_.model.tiles.decks.Stack;
import fr.unilim.iut.latice_.model.tiles.decks.StandardDeck;


public class LaticeApplicationConsole {

	public static void main(String[] args) {
		ArrayList<Player> listePlayers = new ArrayList<Player>();
		ArrayList<Tile> listeTilesPlacees = new ArrayList<Tile>();
		Gameboard gameboard = new Gameboard();
		gameboard.showGameboard(gameboard);
		Stack stdDeck = new StandardDeck();
		Deck deckj1 = new Deck();
		Deck deckj2 = new Deck();
		Rack rackj1 = new Rack();
		Rack rackj2 = new Rack();
		deckj1.buildDeck(stdDeck.tiles);
		deckj2.buildDeck(stdDeck.tiles);
		rackj1.buildRack(deckj1.getDeck());
		rackj2.buildRack(deckj2.getDeck());
		Turn tour = new Turn();
		Player j1 = new Player("j1", rackj1, 0, 0, 1);
		Player j2 = new Player("j2", rackj2, 0, 0, 1);
		Integer compteurTour = 0;
		Referee referee = new Referee();


		
	    int firstPick = (int)Math.floor(Math.random()*2);
		while(referee.isEndGame(10,deckj1,deckj2,rackj1, rackj2, compteurTour)) {
			if (firstPick==1){
				System.out.println("J1 - Rack : "+rackj1.getRack());
				tour.choiceOfTurn(deckj1, rackj1, gameboard, compteurTour, j1, j1.points);
				System.out.println(j1.points+" points");
				System.out.println("Nombre de tuiles posées : "+(36-(deckj1.getDeck().size()+rackj1.getRack().size())));
				compteurTour++;
				System.out.println("J2 - Rack : "+rackj2.getRack());
				tour.choiceOfTurn(deckj2,rackj2, gameboard,compteurTour, j2, j2.points);
				System.out.println(j2.points+" points");
				System.out.println("Nombre de tuiles posées : "+(36-(deckj2.getDeck().size()+rackj2.getRack().size())));
				System.out.println("Nombre de tours :"+compteurTour);
			}else {
				System.out.println("J2 - Rack : "+rackj2.getRack());
				tour.choiceOfTurn(deckj2,rackj2, gameboard,compteurTour,j2,j2.points);
				System.out.println(j2.points+" points");
				System.out.println("Nombre de tuiles posées : "+(36-(deckj2.getDeck().size()+rackj2.getRack().size())));
				compteurTour++;
				System.out.print("J1 - Rack : "+rackj1.getRack());
				tour.choiceOfTurn(deckj1, rackj1, gameboard, compteurTour,j1,j1.points);
				System.out.println(j1.points+" points");
				System.out.println("Nombre de tuiles posées : "+(36-(deckj1.getDeck().size()+rackj1.getRack().size())));
				System.out.println("Nombre de tours :"+compteurTour);

			}
		}
		
		
	}

}
