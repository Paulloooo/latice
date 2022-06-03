package fr.unilim.iut.latice_.model.tiles.decks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import fr.unilim.iut.latice_.model.tiles.Tile;

public class Stack {

	private Tile tile;
	public ArrayList tiles;
	
	@Override
	public int hashCode() {
		return Objects.hash(tiles, tile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stack other = (Stack) obj;
		return Objects.equals(tiles, other.tiles) && Objects.equals(tile, other.tile);
	}

	public Stack() {
        this.tiles = new ArrayList<>();
    }
	    
    public boolean isEmpty() {
    	return tiles.isEmpty();
	}
	    
	    
    public boolean put(Tile...otherTiles) {
    	if (otherTiles.length==0) {
	   		return false;
	   	}
	   	for(Tile tile : otherTiles) {
	   		if(tile!=null) {
    			this.tiles.add(tile);	    		
    		}
	   	}
			return true;
    }
	    
	    
	public Integer remainingTiles() {
    	return(tiles.size());
    }
	    
	public Collection<Tile> cards() {
		return(tiles);
	}
		
	public void clear() {
		tiles.clear();
	}
	
	public Boolean put(Collection<Tile> newTiles) {
		if(newTiles.isEmpty()) {
			return false;
		}
		for (Tile tile : newTiles) {
			tiles.add(tile);
		}
		return true;
	};
	
	public Tile draw() {
		Tile drawnCard;
		if(tiles.isEmpty()) {
			drawnCard=null;
		}else {
			drawnCard = (Tile) tiles.get(0);
			tiles.remove(0);
		}
		return(drawnCard);
	}
	
	public Tile searchStringTileIntoDeck(String tile) {
		Tile tileSearched = null;
		for (int i=0;i<tiles.size();i++) {
			if (tiles.get(i).toString().equals(tile)) {
				tileSearched = (Tile) tiles.get(i);
			}
		}
		return tileSearched;
	}
	
}

