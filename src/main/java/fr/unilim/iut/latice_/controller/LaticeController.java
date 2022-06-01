package fr.unilim.iut.latice_.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.unilim.iut.latice.view.TileGameView;
import fr.unilim.iut.latice_.Application.play.Arbitre;
import fr.unilim.iut.latice_.Application.play.Player;
import fr.unilim.iut.latice_.Application.play.Tour;
import fr.unilim.iut.latice_.tools.TileGameTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
	static Rack rackj1 = new Rack();
	static Rack rackj2 = new Rack();
	static Player actualPlayer;
	Integer compteurTour = 0;
	static Player j1 = new Player("j1", rackj1, 0);
	static Player j2 = new Player("j2", rackj2, 0);
	Gameboard gameboardBack = new Gameboard();
	ArrayList<Tile> listeTilesPlacees = new ArrayList<Tile>();
	

    @FXML
    private VBox idDeck;

    @FXML
    private VBox idDeck2;

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
	private GridPane gameboard;
	
    @FXML
    private Label joueurPlay;
	
	
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
	    DndImageController.manageSourceDragAndDrop(img2deck1);
	    DndImageController.manageSourceDragAndDrop(img3deck1);
	    DndImageController.manageSourceDragAndDrop(img4deck1);
	    DndImageController.manageSourceDragAndDrop(img5deck1);
	    DndImageController.manageSourceDragAndDrop(imgdeck2);
	    DndImageController.manageSourceDragAndDrop(img2deck2);
	    DndImageController.manageSourceDragAndDrop(img3deck2);
	    DndImageController.manageSourceDragAndDrop(img4deck2);
	    DndImageController.manageSourceDragAndDrop(img5deck2);

	    DndImageController.manageSourceTargetAndDrop(gameboard);
	    
	    int firstPick = (int)Math.floor(Math.random()*2);
	    if (firstPick==1){
			actualPlayer = j1;
			idDeck2.setVisible(false);
			joueurPlay.setText("Le joueur 1 joue.");
		}else {
			actualPlayer = j2;
			idDeck.setVisible(false);
			joueurPlay.setText("Le joueur 2 joue.");
		}
	}
	
	public void changerackj1() throws FileNotFoundException {
		rackj1.clear();
		rackj1.buildRack(deckj1.getDeck());
		System.out.println(rackj1.getRack().get(0));
	    imgdeck1.setImage(TileGameView.generateImageFromTile(rackj1, 0));
	    img2deck1.setImage(TileGameView.generateImageFromTile(rackj1, 1));
	    img3deck1.setImage(TileGameView.generateImageFromTile(rackj1, 2));
	    img4deck1.setImage(TileGameView.generateImageFromTile(rackj1, 3));		
	    img5deck1.setImage(TileGameView.generateImageFromTile(rackj1, 4));
	}
	
	public void changerackj2() throws FileNotFoundException {
		rackj2.clear();
		rackj2.buildRack(deckj2.getDeck());
	    imgdeck2.setImage(TileGameView.generateImageFromTile(rackj2, 0));		
	    img2deck2.setImage(TileGameView.generateImageFromTile(rackj2, 1));
	    img3deck2.setImage(TileGameView.generateImageFromTile(rackj2, 2));		
	    img4deck2.setImage(TileGameView.generateImageFromTile(rackj2, 3));
	    img5deck2.setImage(TileGameView.generateImageFromTile(rackj2, 4));	

	    DndImageController.manageSourceDragAndDrop(imgdeck2);
	    DndImageController.manageSourceDragAndDrop(img2deck2);
	    DndImageController.manageSourceDragAndDrop(img3deck2);
	    DndImageController.manageSourceDragAndDrop(img4deck2);
	    DndImageController.manageSourceDragAndDrop(img5deck2);

	    DndImageController.manageSourceTargetAndDrop(gameboard);
 
	}
	
	 boolean actionPoser(String imgViewTile,Integer pos1, Integer pos2) {
		 switch(imgViewTile){
	       case "imgdeck1": 
	    	   System.out.print("J2 :");
	    	   Tile tilePosee = (Tile) rackj1.getRack().get(0);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img2deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(1);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img3deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(2);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img4deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(3);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img5deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(4);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "imgdeck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(0);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };			   compteurTour++;
	    	   break;
	       case "img2deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(1);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   verifTiles(tilePosee, compteurTour);
			   compteurTour++;
	    	   break;
	       case "img3deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(2);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img4deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(3);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       case "img5deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(4);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
			   compteurTour++;
	    	   break;
	       default:
	           System.out.println("Choix incorrect");
	           break;
		 }
		return true;
	 }
	boolean verifTiles(Tile tile, Integer compteur) {
		Tour tour = new Tour();
		if(compteur==0){
			tour.firstTour(tile,gameboardBack, listeTilesPlacees);
		}else {
			if(tour.confTilePosee(tile, gameboardBack, actualPlayer,listeTilesPlacees)==null) {
				return false;
			};
		}
		return true;
	}
    @FXML
    void finTour(ActionEvent event) {
		if (actualPlayer.equals(j1)) {
			idDeck.setVisible(false);
			actualPlayer=j2;
			idDeck2.setVisible(true);
			joueurPlay.setText("Le joueur 2 joue.");
		}else {
			idDeck2.setVisible(false);
			actualPlayer=j1;
			idDeck.setVisible(true);
			joueurPlay.setText("Le joueur 1 joue.");

		}
    }

}
