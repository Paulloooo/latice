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
	//read the choice of the player and launch an the action selected (4 choices)
	Scanner keyboard = new Scanner(System.in);
	Referee referee = new Referee();
	ArrayList<Tile> tilesPlayed = new ArrayList();
	ArrayList<Tile> tilesNextTo = new ArrayList();
	
	public static void message(Object content) {
		System.out.println(content);
	}
	
	public void choiceOfTurn(Deck deck, Rack rack, Gameboard gameboard,Integer counterOfTurn,Player player, Integer nbActions, Integer nbActionsBeginning) {
		message("Que voulez vous faire : - 1 : Jouer une tuile  - 2 : Acheter action supp  - 3 : Echanger tout le rack et passer son tour  - 4 : passer son tour");
		String choix = keyboard.nextLine();
		switch(choix){
		   //to put a tile on gameboard
	       case "1":
	    	   if(nbActionsBeginning>0) {
		    	   confTileChoisie(rack, gameboard, counterOfTurn,player);	
		    	   nbActionsBeginning--;
		    	   choiceOfTurn(deck,rack, gameboard,counterOfTurn,player, nbActions, nbActionsBeginning);
	    	   }else {
	    		   message("Vous n'avez pas assez d'actions");
		    	   choiceOfTurn(deck,rack, gameboard,counterOfTurn,player, nbActions, nbActionsBeginning);
	    	   }
	    	   break;
	       //to buy an action
	       case "2":
	    	   if(player.points>=2) {
	    		   nbActionsBeginning++;
	    		   player.points-=2;
	    	   }
    		   message("Nombre d'actions : "+nbActionsBeginning);
	    	   choiceOfTurn(deck,rack, gameboard,counterOfTurn,player, nbActions, nbActionsBeginning);
	           break;
	       //exchange tiles from rack to deck
	       case "3":
	    	   if(nbActionsBeginning>0) {
		    	   rack.addRemainingTiles();
		    	   rack.buildRack(deck.getDeck());	    
		    	   nbActionsBeginning--;
		    	   choiceOfTurn(deck,rack, gameboard,counterOfTurn,player, nbActions, nbActionsBeginning);
	    	   }else {
	    		   message("Vous n'avez pas assez d'actions");
	    	   }
	           break;
		   //pass to other player 
	       case "4":
	    	   for(int indiceTilesOfRack=0;indiceTilesOfRack<5-rack.getRack().size();indiceTilesOfRack++) {
	    		   rack.getRack().add(deck.draw());
	    	   }
	    	   break;
		default:
	           message("Choix incorrect");
	    	   choiceOfTurn(deck,rack, gameboard,counterOfTurn,player, nbActions, nbActionsBeginning);
	           break;
	   }
	}
	
	//read the tile the player choice of tile with a scanner
	public Tile choiceOfTile(Rack rack) {
		message(rack.getRack().toString());
		message("Quelle est la tuile que vous voulez poser ?");
		return rack.searchStringTileIntoDeck(keyboard.nextLine());
    }
	
	//method for beginning of the game
	public Gameboard firstTurn(Tile tile, Gameboard gameboard, ArrayList<Tile> tilesPlayed) {
		Integer pos1=4;
		Integer pos2=4;  
		tile.position.setX(4);
		tile.position.setY(4);
		addTilesPlayed(tilesPlayed, tile);
		gameboard.setTileAtPosition(tile, pos1, pos2);
        gameboard.showGameboard(gameboard);
		return gameboard;
	}
	
	//read the player choice of position to place his/her tile 
	public void choiceOfPosition(Tile tile) {
		message("A quelle position x voulez-vous placer la tuile ?");
		String x = keyboard.nextLine();
		Integer pos1=Integer.valueOf(x);  
		message("A quelle position y voulez-vous placer la tuile ?");
		String y = keyboard.nextLine();
		Integer pos2=Integer.valueOf(y);
		tile.position.setX(pos1);
		tile.position.setY(pos2);
	}
	
	//put the tile on the gameboard after verification (method for Java FX)
	public Gameboard confirmationOfTilePut(Tile tile, Gameboard gameboard,Player player, ArrayList<Tile> tilesPlayed) {
		tilesNextTo=referee.addTilesNextTo(tilesPlayed,tile);
		if(!referee.verifCase(tilesNextTo, tile)) {
			return null;
		}
		referee.addPoints(gameboard, player, tilesNextTo, tile);
		addTilesPlayed(tilesPlayed, tile);
		gameboard.setTileAtPosition(tile, tile.position.getX(), tile.position.getY());
		gameboard.showGameboard(gameboard);
		return gameboard;
	}
	
	//put the tile on console gameboard after verification (exclusively for console)
	public Gameboard confTilePoseeConsole(Tile tile, Gameboard gameboard,Player player) {
		choiceOfPosition(tile);
		tilesNextTo=referee.addTilesNextTo(tilesPlayed,tile);
		if(!referee.verifCase(tilesNextTo, tile)) {
			message("Vous ne pouvez pas jouer ici, veuillez recommencer");
			choiceOfPosition(tile);
		}
		referee.addPoints(gameboard, player, tilesNextTo, tile);
  	    player.tilesPut+=1;
		addTilesPlayed(tilesPlayed, tile);
		message(tilesPlayed);
		message(player.getPoints());
		gameboard.setTileAtPosition(tile, tile.position.getX(), tile.position.getY());
		gameboard.showGameboard(gameboard);
		return gameboard;
	}
	
	//make the turn (check of turn if it is the first, call precedent methods)
	public void confTileChoisie(Rack rack,Gameboard gameboard, Integer tour, Player player) {
		Tile tileChoisie = choiceOfTile(rack);
		while(tileChoisie==null) {
			message("La tuile n'est pas dans le deck");
			tileChoisie = choiceOfTile(rack);
        }
		if (tour==0) {
	        firstTurn(tileChoisie,gameboard, tilesPlayed);
     		rack.removeTileOfRack(tileChoisie);
		}else {
			confTilePoseeConsole(tileChoisie,gameboard, player);
			rack.removeTileOfRack(tileChoisie);
		}
	}
	
	//add tiles played all over the game
	public void addTilesPlayed(List<Tile> tilesPlayed,Tile tilePlayed) {
		tilesPlayed.add(tilePlayed);
	}


}
