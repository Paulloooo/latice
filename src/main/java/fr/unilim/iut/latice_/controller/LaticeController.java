package fr.unilim.iut.latice_.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.unilim.iut.latice_.Application.play.Player;
import fr.unilim.iut.latice_.tools.TileGameTools;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import latice.model.tiles.Tile;
import latice.model.tiles.decks.Deck;
import latice.model.tiles.decks.Rack;
import latice.model.tiles.decks.Stack;
import latice.model.tiles.decks.StandardDeck;
import latice.model.Gameboard;
import latice.model.tiles.Color;
import latice.model.tiles.Position;
import latice.model.tiles.Shape;

public class LaticeController {
	Stack StdDeck = new StandardDeck();
	Deck deckj1 = new Deck();
	Deck deckj2 = new Deck();
	Rack rackj1 = new Rack();
	Rack rackj2 = new Rack();

	@FXML
	private ImageView imgdeck1;
	
	public void initDecks() {
		deckj1.buildDeck(StdDeck.tiles);
		deckj2.buildDeck(StdDeck.tiles);
		rackj1.buildRack(deckj1.getDeck());
		rackj2.buildRack(deckj2.getDeck());
		
	}
	
	public void initialize() throws FileNotFoundException {

		Tile tile = new Tile(Color.NIGHTBLUE,Shape.BIRD,null);
		String path = TileGameTools.generateTilePath(tile);
		Image imageChargee = TileGameTools.loadCardImage(path);
	    imgdeck1.setImage(imageChargee);		
	}
}
