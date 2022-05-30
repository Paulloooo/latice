package latice.model.tiles.decks;

import java.util.ArrayList;

public class Rack extends Deck{
	ArrayList rack = new ArrayList();
	Integer test = 0;
	public Rack() {
		super();
	}

	public void buildRack(ArrayList deck) {
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

}
