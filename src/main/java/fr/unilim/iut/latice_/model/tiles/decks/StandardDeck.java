package fr.unilim.iut.latice_.model.tiles.decks;

import java.util.Collections;

import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;

public class StandardDeck extends Stack{
	public StandardDeck() {
		super();
		this.putAllCardsTogether();
	}

	private void putAllCardsTogether() {
			for(int i=0;i<6;i++) {
				for (int j=0;j<6;j++) {
					for(int k=0;k<2;k++) { 
						tiles.add(new Tile(Color.values()[i], Shape.values()[j],new Position(0,0)));
						
					}
				}	
			}
		Collections.shuffle(tiles);
	}

}
