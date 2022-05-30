package fr.unilim.iut.latice_.Application.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import latice.model.Gameboard;
import latice.model.tiles.Tile;
import latice.model.tiles.decks.Rack;
import latice.model.tiles.decks.Stack;

public class Tour {
	Scanner keyboard = new Scanner(System.in);
	Arbitre arbitre = new Arbitre();
	ArrayList<Tile> tilesPlayed = new ArrayList();
	
	public static void message(String text) {
		System.out.println(text);
	}
	
	public void choixTuile(Rack deck, Gameboard gameboard) {
		message(deck.getRack().toString());
		message("Quelle est la tuile que vous voulez poser ?");
		Tile tile = deck.searchStringTileIntoDeck(keyboard.nextLine());
		while (tile==null) {
			message("La tuile n'est pas dans le deck");
			choixTuile(deck,gameboard);
        }
        choixPosition(tile,gameboard);
        
    }
	
	public Gameboard choixPosition(Tile tile, Gameboard gameboard) {
		message("A quelle position x voulez-vous placer la tuile ?");
		String x = keyboard.nextLine();
		Integer pos1=Integer.valueOf(x);  
		message("A quelle position y voulez-vous placer la tuile ?");
		String y = keyboard.nextLine();
		Integer pos2=Integer.valueOf(y);
		addTilesPlayed(tilesPlayed, tile);
		tile.position.setX(pos1);
		tile.position.setY(pos2);	
		arbitre.addTilesNextTo(tilesPlayed, tile);
		if (arbitre.verifCase(tilesPlayed, tile)) {
			gameboard.setTileAtPosition(tile, pos1, pos2);
		}else {
			System.out.println("Vous ne pouvez pas jouer ici, veuillez recommencer");
		};
		return gameboard;
	}
	
	public void addTilesPlayed(List<Tile> tilesPlayed,Tile tilePlayed) {
		tilesPlayed.add(tilePlayed);
	}	
}
