package fr.unilim.iut.latice_.model.play;

import java.util.ArrayList;
import java.util.List;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;

public class Arbitre {
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
	
	public void addPoints(Gameboard gameboard,Player player,ArrayList<Tile> tilesNextTo,Tile tile) {

		if(tilesNextTo.size()==2) {
			player.points+=1;
			System.out.print("2");
		}
		else if(tilesNextTo.size()==3) {
			player.points+=2;
			System.out.print("3");
		}
		else if(tilesNextTo.size()==4) {
			player.points+=4;
			System.out.print("4");
		}
		else if(gameboard.isSunCase(tile.position.getX(),tile.position.getY())) {
			player.points+=2;
		}
	}


}
