package fr.unilim.iut.latice_.model.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Deck;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import fr.unilim.iut.latice_.model.tiles.decks.Stack;

public class Turn {
	Scanner keyboard = new Scanner(System.in);
	Referee arbitre = new Referee();
	ArrayList<Tile> tilesPlayed = new ArrayList();
	ArrayList<Tile> tilesNextTo = new ArrayList();
	Integer nbActionBase = 1;

	public void choiceOfTurn(Deck deck, Rack rack, Gameboard plateau,Integer compteurTour,Player player, Integer nbActions) {
		message(rack.getRack().toString());
		message("Que voulez vous faire : - 1 : Jouer une tuile  - 2 : Acheter action supp  - 3 : Echanger tout le rack et passer son tour  - 4 : passer son tour");
		String choix = keyboard.nextLine();
		switch(choix){
	       case "1":
	    	   if(nbActionBase>0) {
		    	   confTileChoisie(rack, plateau, compteurTour,player);	
		    	   nbActionBase--;
		    	   choiceOfTurn(deck,rack, plateau,compteurTour,player, nbActions);
	    	   }else {
	    		   System.out.println("Vous n'avez pas assez d'actions");
	    	   }
	    	   break;
	       case "2":
	    	   if(player.points>=2) {
	    		   nbActionBase++;
	    		   player.points-=2;
	    	   }
    		   System.out.println("Nombre d'actions : "+nbActionBase);
	    	   choiceOfTurn(deck,rack, plateau,compteurTour,player, nbActions);
	           break;
	   
	       case "3":
	    	   if(nbActionBase>0) {
		    	   rack.clear();
		    	   rack.buildRack(deck.getDeck());	    
		    	   choiceOfTurn(deck,rack, plateau,compteurTour,player, nbActions);
	    	   }else {
	    		   System.out.println("Vous n'avez pas assez d'actions");
	    	   }
	           break;
	       case "4":
	    	   for(int i=0;i<5-rack.getRack().size();i++) {
	    		   rack.getRack().add(deck.draw());
	    	   }
	    	   break;
		default:
	           System.out.println("Choix incorrect");
	    	   choiceOfTurn(deck,rack, plateau,compteurTour,player, nbActions);
	           break;
	   }
	}
	public static void message(String text) {
		System.out.println(text);
	}
	
	public Tile choiceOfTile(Rack rack, Gameboard gameboard, Integer tour) {
		message(rack.getRack().toString());
		message("Quelle est la tuile que vous voulez poser ?");
		Tile tile = rack.searchStringTileIntoDeck(keyboard.nextLine());
		return tile;
    }
	
	public Gameboard firstTour(Tile tile, Gameboard gameboard, ArrayList tilesPlayed) {
		Integer pos1=4;
		Integer pos2=4;  
		tile.position.setX(4);
		tile.position.setY(4);
		addTilesPlayed(tilesPlayed, tile);
		gameboard.setTileAtPosition(tile, pos1, pos2);
        gameboard.showGameboard(gameboard);
		return gameboard;
		
	}
	public void choiceOfPosition(Tile tile, Gameboard gameboard) {
		message("A quelle position x voulez-vous placer la tuile ?");
		String x = keyboard.nextLine();
		Integer pos1=Integer.valueOf(x);  
		message("A quelle position y voulez-vous placer la tuile ?");
		String y = keyboard.nextLine();
		Integer pos2=Integer.valueOf(y);
		tile.position.setX(pos1);
		tile.position.setY(pos2);
	}
	
	public Gameboard confirmationOfTilePut(Tile tile, Gameboard gameboard,Player player, ArrayList tilesPlayed) {
		tilesNextTo=arbitre.addTilesNextTo(tilesPlayed,tile);

		if(!arbitre.verifCase(tilesNextTo, tile)) {
			return null;
		}
		arbitre.addPoints(gameboard, player, tilesNextTo, tile);
		addTilesPlayed(tilesPlayed, tile);
		gameboard.setTileAtPosition(tile, tile.position.getX(), tile.position.getY());
		gameboard.showGameboard(gameboard);
		return gameboard;
	}
	
	public Gameboard confTilePoseeConsole(Tile tile, Gameboard gameboard,Player player) {
		choiceOfPosition(tile,gameboard);
		tilesNextTo=arbitre.addTilesNextTo(tilesPlayed,tile);
		if(!arbitre.verifCase(tilesNextTo, tile)) {
			System.out.println("Vous ne pouvez pas jouer ici, veuillez recommencer");
			choiceOfPosition(tile,gameboard);
		}
		arbitre.addPoints(gameboard, player, tilesNextTo, tile);
  	    player.tilesPut+=1;
		addTilesPlayed(tilesPlayed, tile);
		System.out.println(tilesPlayed);
		System.out.println(player.getPoints());
		gameboard.setTileAtPosition(tile, tile.position.getX(), tile.position.getY());
		gameboard.showGameboard(gameboard);
		return gameboard;
	}
	
	public void confTileChoisie(Rack rack,Gameboard gameboard, Integer tour, Player player) {
		Tile tileChoisie = choiceOfTile(rack, gameboard, tour);
		while(tileChoisie==null) {
			message("La tuile n'est pas dans le deck");
			tileChoisie = choiceOfTile(rack,gameboard,tour);
        }
		if (tour==0) {
	        firstTour(tileChoisie,gameboard, tilesPlayed);
     		rack.removeTileOfRack(tileChoisie);
		}else {
			confTilePoseeConsole(tileChoisie,gameboard, player);
			rack.removeTileOfRack(tileChoisie);
		}
	}
	
	public void addTilesPlayed(List<Tile> tilesPlayed,Tile tilePlayed) {
		tilesPlayed.add(tilePlayed);
	}


}
