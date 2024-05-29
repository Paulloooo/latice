package fr.unilim.iut.latice_.model.tiles.decks;

import java.util.ArrayList;

import fr.unilim.iut.latice_.model.tiles.Tile;

public class Rack extends Deck{
	ArrayList rack = new ArrayList();
	
	public Rack() {
		super();
	}

	public void buildRack(ArrayList<Tile> deck) {
		for(int i=0;i<5;i++) {
		    int random_int = (int)Math.floor(Math.random()*deck.size());
			while(rack.contains(deck.get(random_int))) {
			    random_int = (int)Math.floor(Math.random()*73);
			}
			this.rack.add(deck.get(random_int));
			deck.remove(deck.get(random_int));
		}
	}

	public ArrayList getRack() {
		return rack;
	}
	
	public void removeTileOfRack(Tile tile) {
		for (int i=0;i<rack.size();i++) {
			if (rack.get(i).toString().equals(tile.toString())) {
				rack.remove(i);
			}
		}
	}

	public void clear() {
		rack.clear();
	}
	
	
	public Tile searchStringTileIntoDeck(String tile) {
		Tile tileSearched = null;
		for (int i=0;i<rack.size();i++) {
			if (rack.get(i).toString().equals(tile)) {
				tileSearched = (Tile) rack.get(i);
			}
		}
		return tileSearched;
	}
	
	public void addRemainingTiles() {
		for (int i=0;i<rack.size();i++) {
			deck.add(rack.get(i));
			deck.remove(i);
		}
	}

	
	

}
