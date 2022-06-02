package latice.model.tiles.decks;

import java.util.ArrayList;
import java.util.Collections;

import latice.model.tiles.Tile;

public class Deck extends StandardDeck{
	ArrayList deck = new ArrayList();
	Integer test = 0;
	public Deck() {
		super();
	}

	public void buildDeck(ArrayList standard) {
		if(standard.size()>36){
			for (int i=0;i<36;i++) {
			    int random_int = (int)Math.floor(Math.random()*standard.size());
				while(deck.contains(standard.get(random_int))) {
				    random_int = (int)Math.floor(Math.random()*73);
				}
				this.deck.add(standard.get(random_int));
				standard.remove(standard.get(random_int));
			}
		}else {
			this.deck.addAll(standard);
		}
	}

	public ArrayList getDeck() {
		return deck;
	}	
	
	public Tile draw() {
		Tile drawnCard;
		if(deck.isEmpty()) {
			drawnCard=null;
		}else {
			drawnCard = (Tile) deck.get(0);
			deck.remove(0);
		}
		return(drawnCard);
	}
}
