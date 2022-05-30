package fr.unilim.iut.latice_.Application.play;

import java.util.ArrayList;
import java.util.List;

import latice.model.Gameboard;
import latice.model.tiles.Color;
import latice.model.tiles.Shape;
import latice.model.tiles.Tile;

public class Arbitre {
	public List<Tile> addTilesNextTo (ArrayList<Tile> tilesPlacees,Tile tile){
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
	public boolean verifCase(ArrayList<Tile> tilesPlacees,Tile tile) {
		for (int i=0;i<tilesPlacees.size();i++) {
			Tile tileAVerif = tilesPlacees.get(i);
			Color CouleurTileAVerif = tileAVerif.color();
			Shape FormeTileAVerif = tileAVerif.shape();
			if((CouleurTileAVerif!=tile.color()&&FormeTileAVerif!=tile.shape())){
				return false;
			}
		}
		return true;
	}
}
