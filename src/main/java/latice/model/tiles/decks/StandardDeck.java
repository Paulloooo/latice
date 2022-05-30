package latice.model.tiles.decks;

import java.util.Collections;

import latice.model.tiles.Color;
import latice.model.tiles.Position;
import latice.model.tiles.Shape;
import latice.model.tiles.Tile;

public class StandardDeck extends Stack{
	public StandardDeck() {
		super();
		this.putAllCardsTogether();
	}

	private void putAllCardsTogether() {
		for(int k=0;k<2;k++) {
			for(int i=0;i<6;i++) {
				for (int j=0;j<6;j++) {
					tiles.add(new Tile(Color.values()[i], Shape.values()[j],new Position(0,0)));
				}	
			}
		}
		Collections.shuffle(tiles);
	}

}
