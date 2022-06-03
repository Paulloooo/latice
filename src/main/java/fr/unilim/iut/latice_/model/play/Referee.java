package fr.unilim.iut.latice_.model.play;

import java.util.ArrayList;
import java.util.List;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Deck;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;

public class Referee {
	public ArrayList<Tile> addTilesNextTo (ArrayList<Tile> tilesPlacees,Tile tile){
		ArrayList<Tile> listTiles = new ArrayList();
		Integer pos1Tile = tile.position.getX();
		Integer pos2Tile = tile.position.getY();
		for (int i=0;i<tilesPlacees.size();i++) {
			Integer pos1TileList = tilesPlacees.get(i).position.getX();
			Integer pos2TileList = tilesPlacees.get(i).position.getY();
			if((pos1TileList==pos1Tile&&(pos2Tile==pos2TileList+1 || pos2Tile==pos2TileList-1))||(pos2TileList==pos2Tile&&(pos1Tile==pos1TileList+1 || pos1Tile==pos1TileList-1)))
				listTiles.add(tilesPlacees.get(i));
		}
		return listTiles;
	}
	public boolean verifCase(ArrayList<Tile> tilesNextTo,Tile tile) {
		if(tilesNextTo.isEmpty()){
			return false;
		}else {
		for (int i=0;i<tilesNextTo.size();i++) {
			Tile tileAVerif = tilesNextTo.get(i);
			Color CouleurTileAVerif = tileAVerif.color();
			Shape FormeTileAVerif = tileAVerif.shape();
			if((CouleurTileAVerif!=tile.color()&&FormeTileAVerif!=tile.shape())){
				return false;
			}
		}
		}
		return true;
	}
	
	public boolean isEndGame(int nbMaxOfTurns, Deck deckPlayer1, Deck deckPlayer2,Rack rackPlayer1, Rack rackPlayer2, Integer numberOfTurns) {
		if(!deckPlayer1.isEmpty()&&!deckPlayer2.isEmpty()&&numberOfTurns!=nbMaxOfTurns) {
			return true;
		}else {
			if (((36-(deckPlayer1.getDeck().size()+rackPlayer1.getRack().size()))>(36-(deckPlayer2.getDeck().size()+rackPlayer2.getRack().size()))&&numberOfTurns==nbMaxOfTurns)||deckPlayer1.isEmpty()) {
				System.out.println("Le joueur 1 a gagné !");
			}else {
				System.out.println("Le joueur 2 a gagné !");
			}
			return false;
		}
		
	}
	
	public void addPoints(Gameboard gameboard,Player player,ArrayList<Tile> tilesNextTo,Tile tile) {

		if(tilesNextTo.size()==2) {
			player.points+=1;
		}
		else if(tilesNextTo.size()==3) {
			player.points+=2;
		}
		else if(tilesNextTo.size()==4) {
			player.points+=4;
		}
		else if(gameboard.isSunCase(tile.position.getX(),tile.position.getY())) {
			player.points+=2;
		}
	}
	

}
