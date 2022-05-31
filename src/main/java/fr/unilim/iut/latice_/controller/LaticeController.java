package fr.unilim.iut.latice_.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.unilim.iut.latice.view.TileGameView;
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
	
	@FXML
	private ImageView img2deck1;

	@FXML
	private ImageView img3deck1;
	
	@FXML
	private ImageView img4deck1;
	
	@FXML
	private ImageView img5deck1;
	
	@FXML
	private ImageView imgdeck2;
	
	@FXML
	private ImageView img2deck2;
	
	@FXML
	private ImageView img3deck2;
	
	@FXML
	private ImageView img4deck2;
	
	@FXML
	private ImageView img5deck2;
	
	
	@FXML
	private ImageView case44gb;
	
	
	public void initialize() throws FileNotFoundException {
		deckj1.buildDeck(StdDeck.tiles);
		deckj2.buildDeck(StdDeck.tiles);
		rackj1.buildRack(deckj1.getDeck());
		rackj2.buildRack(deckj2.getDeck());
	    imgdeck1.setImage(TileGameView.generateImageFromTile(rackj1, 0));
	    img2deck1.setImage(TileGameView.generateImageFromTile(rackj1, 1));
	    img3deck1.setImage(TileGameView.generateImageFromTile(rackj1, 2));
	    img4deck1.setImage(TileGameView.generateImageFromTile(rackj1, 3));		
	    img5deck1.setImage(TileGameView.generateImageFromTile(rackj1, 4));
	    imgdeck2.setImage(TileGameView.generateImageFromTile(rackj2, 0));		
	    img2deck2.setImage(TileGameView.generateImageFromTile(rackj2, 1));
	    img3deck2.setImage(TileGameView.generateImageFromTile(rackj2, 2));		
	    img4deck2.setImage(TileGameView.generateImageFromTile(rackj2, 3));
	    img5deck2.setImage(TileGameView.generateImageFromTile(rackj2, 4));	
	    DndImageController.manageSourceDragAndDrop(imgdeck1);
	    DndImageController.manageSourceTargetAndDrop(case44gb);


	}
}
