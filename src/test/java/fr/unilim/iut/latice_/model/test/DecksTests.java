package fr.unilim.iut.latice_.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Deck;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import fr.unilim.iut.latice_.model.tiles.decks.Stack;
import fr.unilim.iut.latice_.model.tiles.decks.StandardDeck;

public class DecksTests {
	@Test
	void checkIfTheTwoDecksFormStandardDeck() {
		Stack testDeck = new Stack();
		Deck deckj1 = new Deck();
		Deck deckj2 = new Deck();
		StandardDeck stdDeck = new StandardDeck();
		deckj1.buildDeck(stdDeck.tiles);
		deckj2.buildDeck(stdDeck.tiles);
		testDeck.put(deckj1.getDeck());
		testDeck.put(deckj2.getDeck());
		assertTrue(testDeck.tiles.containsAll(stdDeck.cards()));
	}
	
	@Test
	void testIfTileDrawnIsMagentaTurtleTile() {
		Rack rack = new Rack();
		Tile tile1 = new Tile(Color.MAGENTA,Shape.TURTLE, new Position(0,0));
		Tile tile2 = new Tile(Color.GREEN,Shape.GECKO, new Position(0,0));
		rack.getRack().add(tile1);
		rack.getRack().add(tile2);
		assertEquals(rack.getRack().get(0).toString(),"MT");
	}
	
	@Test
	void checkIfRackIsCleared() {
		Deck deck = new Deck();
		StandardDeck stdDeck = new StandardDeck();
		Rack rack = new Rack();
		deck.buildDeck(stdDeck.tiles);
		rack.buildRack(deck.getDeck());
		
		rack.clear();


		assertTrue(rack.getRack().size()==0);
	}
	
	@Test
	void checkIfTileDrawnIsAtFirstPositionInStandardDeck() {
		StandardDeck stdDeck = new StandardDeck();
		String tileAtFirstPosition = stdDeck.tiles.get(0).toString();
		Tile tileTiree = stdDeck.draw();
		assertEquals(tileTiree.toString(),tileAtFirstPosition);
	}
	
	
	@Test
	void checkIfTileDrawnIsAtFirstPositionInDeck() {
		StandardDeck stdDeck = new StandardDeck();
		Deck deck = new Deck();
		deck.buildDeck(stdDeck.tiles);
		String tileAtFirstPosition = deck.getDeck().get(0).toString();
		Tile tileTiree = deck.draw();
		assertEquals(tileTiree.toString(),tileAtFirstPosition);
	}
	
	@Test
	void testMethodRemoveTileOfRack() {
		Rack rack = new Rack();
		Tile tile1 = new Tile(Color.MAGENTA,Shape.TURTLE, new Position(0,0));
		rack.getRack().add(tile1);
		rack.removeTileOfRack(tile1);
		assertTrue(rack.getRack().size()==0);
	}
	
	@Test
	void testMethodSearchingStringTileInRack() {
		StandardDeck stdDeck = new StandardDeck();
		Boolean isEmptyStdDeck = stdDeck.isEmpty();
		assertFalse(isEmptyStdDeck);
	}
	
	@Test
	void testStdDeckIsNotEmptyAfterInitialization() {
		Rack rack = new Rack();
		Tile tile1 = new Tile(Color.MAGENTA,Shape.TURTLE, new Position(0,0));
		rack.getRack().add(tile1);
		Tile tileSearched = rack.searchStringTileIntoDeck("MT");
		assertEquals(rack.getRack().get(0).toString(),tileSearched.toString());
	}
	
	@Test
	void test72TilesInStdDeckAfterBuiltIt() {
		StandardDeck stdDeck = new StandardDeck();
		int remainingTilesStdDeck = stdDeck.remainingTiles();
		assertEquals(72,remainingTilesStdDeck);
	}
}
