package fr.unilim.iut.latice_.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.play.Referee;
import fr.unilim.iut.latice_.model.play.Player;
import fr.unilim.iut.latice_.model.play.Turn;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Deck;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import fr.unilim.iut.latice_.model.tiles.decks.Stack;
import fr.unilim.iut.latice_.model.tiles.decks.StandardDeck;
import fr.unilim.iut.latice_.tools.TileGameTools;
import fr.unilim.iut.latice_.view.TileGameView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LaticeController {
	Stack StdDeck = new StandardDeck();
	Deck deckj1 = new Deck();
	Deck deckj2 = new Deck();
	static Rack rackj1 = new Rack();
	static Rack rackj2 = new Rack();
	static Player actualPlayer;
    static Integer compteurTour = 0;
	static Player j1 = new Player("j1", rackj1, 0, 0);
	static Player j2 = new Player("j2", rackj2, 0, 0);
	Gameboard gameboardBack = new Gameboard();
	ArrayList<Tile> listeTilesPlacees = new ArrayList<Tile>();
	Referee referee = new Referee();
	

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
	
    @FXML
    private Label scorej1;

    @FXML
    private Label scorej2;
	
	public static Integer getCompteurTour() {
		return compteurTour;
	}
	public static void setCompteurTour(Integer compteurTour) {
		LaticeController.compteurTour = compteurTour;
	}
	
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
	public void initTiles(Rack rack) throws FileNotFoundException {
	    imgdeck1.setImage(TileGameView.generateImageFromTile(rackj1, 0));
	    img2deck1.setImage(TileGameView.generateImageFromTile(rackj1, 1));
	    img3deck1.setImage(TileGameView.generateImageFromTile(rackj1, 2));
	    img4deck1.setImage(TileGameView.generateImageFromTile(rackj1, 3));		
	    img5deck1.setImage(TileGameView.generateImageFromTile(rackj1, 4));
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
	
	 boolean actionPoser(String imgViewTile, Integer pos1, Integer pos2) {
		 switch(imgViewTile){
	       case "imgdeck1": 
	    	   System.out.print("J2 :");
	    	   Tile tilePosee = (Tile) rackj1.getRack().get(0);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj1.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img2deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(1);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj1.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img3deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(2);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj1.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img4deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(3);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj1.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img5deck1": 
	    	   System.out.print("J1 :");
	    	   tilePosee = (Tile) rackj1.getRack().get(4);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj1.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "imgdeck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(0);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj2.removeTileOfRack(tilePosee); 
	    	   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img2deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(1);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   verifTiles(tilePosee, compteurTour);
	    	   rackj2.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img3deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(2);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj2.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
	    	   break;
	       case "img4deck2": 
	    	   System.out.print("J2 :");
	    	   tilePosee = (Tile) rackj2.getRack().get(3);
	    	   tilePosee.position.setX(pos1);
	    	   tilePosee.position.setY(pos2);
	    	   if (verifTiles(tilePosee, compteurTour)==false) {
	    		   return false;
	    	   };
	    	   rackj2.removeTileOfRack(tilePosee);
			   compteurTour++;
			   System.out.println(compteurTour);
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
			   System.out.println(compteurTour);
	    	   break;
	       default:
	           System.out.println("Choix incorrect");
	           break;
		 }
		return true;
	 }
	boolean verifTiles(Tile tile, Integer compteur) {
		Turn tour = new Turn();
		if(compteur==0){
			tour.firstTour(tile,gameboardBack, listeTilesPlacees);
		}else {
			if(tour.confirmationOfTilePut(tile, gameboardBack, actualPlayer,listeTilesPlacees)==null) {
				return false;
			};
		}
		return true;
	}
    @FXML
    void finTour(ActionEvent event) throws FileNotFoundException {
		System.out.println(compteurTour);
    	gameboard.setDisable(false);
		if(referee.isEndGame(20,deckj1, deckj2, rackj1, rackj2, compteurTour)) {
			if (actualPlayer.equals(j1)) {
				idDeck.setVisible(false);
				actualPlayer=j2;
				System.out.println("SCORE : "+actualPlayer.getPoints());
		    	for(int i=0;i<5-rackj2.getRack().size();i++) {
		    	   this.rackj2.getRack().add(deckj2.draw());
		    	}
			    imgdeck2.setImage(TileGameView.generateImageFromTile(rackj2, 0));
			    imgdeck2.setVisible(true);
			    img2deck2.setImage(TileGameView.generateImageFromTile(rackj2, 1));
			    img2deck2.setVisible(true);
			    img3deck2.setImage(TileGameView.generateImageFromTile(rackj2, 2));	
			    img3deck2.setVisible(true);
			    img4deck2.setImage(TileGameView.generateImageFromTile(rackj2, 3));
			    img4deck2.setVisible(true);
			    img5deck2.setImage(TileGameView.generateImageFromTile(rackj2, 4));	
			    img5deck2.setVisible(true);
				idDeck2.setVisible(true);
				joueurPlay.setText("Le joueur 2 joue.");
			}else {
				idDeck2.setVisible(false);
				actualPlayer=j1;
				System.out.println("SCORE : "+actualPlayer.getPoints());
				scorej1.setText(actualPlayer.getPoints().toString());
		    	for(int i=0;i<5-rackj1.getRack().size();i++) {
		    	   this.rackj1.getRack().add(deckj1.draw());
		   	   }
			    imgdeck1.setImage(TileGameView.generateImageFromTile(rackj1, 0));
			    imgdeck1.setVisible(true);
			    img2deck1.setImage(TileGameView.generateImageFromTile(rackj1, 1));
			    img2deck1.setVisible(true);
			    img3deck1.setImage(TileGameView.generateImageFromTile(rackj1, 2));
			    img3deck1.setVisible(true);
			    img4deck1.setImage(TileGameView.generateImageFromTile(rackj1, 3));	
			    img4deck1.setVisible(true);
			    img5deck1.setImage(TileGameView.generateImageFromTile(rackj1, 4));
			    img5deck1.setVisible(true);
				idDeck.setVisible(true);
				joueurPlay.setText("Le joueur 1 joue.");
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fin de partie");
			alert.setHeaderText("Resultats : ");
			alert.setContentText(actualPlayer.getPseudo()+" a gagné !");

			alert.showAndWait();
		}
		compteurTour++;
    }


}
