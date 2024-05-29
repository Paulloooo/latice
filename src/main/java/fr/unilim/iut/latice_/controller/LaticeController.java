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
	static Player j1 = new Player("j1", rackj1, 0, 0, 1);
	static Player j2 = new Player("j2", rackj2, 0, 0, 1);
	Gameboard gameboardBack = new Gameboard();
	ArrayList<Tile> listeTilesPlacees = new ArrayList<Tile>();
	Referee referee = new Referee();
	Integer nbActionBase = 1;

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
	    deck1init();
	    deck2init();	

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
	private void deck2init() throws FileNotFoundException {
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
	}
	private void deck1init() throws FileNotFoundException {
		imgdeck1.setImage(TileGameView.generateImageFromTile(rackj1, 0));
	    img2deck1.setImage(TileGameView.generateImageFromTile(rackj1, 1));
	    img3deck1.setImage(TileGameView.generateImageFromTile(rackj1, 2));
	    img4deck1.setImage(TileGameView.generateImageFromTile(rackj1, 3));		
	    img5deck1.setImage(TileGameView.generateImageFromTile(rackj1, 4));
	    DndImageController.manageSourceDragAndDrop(imgdeck1);
	    DndImageController.manageSourceDragAndDrop(img2deck1);
	    DndImageController.manageSourceDragAndDrop(img3deck1);
	    DndImageController.manageSourceDragAndDrop(img4deck1);
	    DndImageController.manageSourceDragAndDrop(img5deck1);
	}

	public void changerackj1() throws FileNotFoundException {
		if (j1.actions>=1) {
			rackj1.clear();
			rackj1.buildRack(deckj1.getDeck());
			System.out.println(rackj1.getRack().get(0));
		    deck1init();
		    j1.actions-=1;
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erreur");
			alert.setHeaderText("Attention ");
			alert.setContentText("Vous n'avez pas assez d'actions pour changer votre rack");

			alert.showAndWait();
		}

	}
	
	public void changerackj2() throws FileNotFoundException {
		if (j2.actions>=1) {
			rackj2.clear();
			rackj2.buildRack(deckj2.getDeck());
		    deck2init();
		    j2.actions-=1;
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erreur");
			alert.setHeaderText("Attention ");
			alert.setContentText("Vous n'avez pas assez d'actions pour changer votre rack");

			alert.showAndWait();
		}
 
	}
	
	 boolean actionPoser(String imgViewTile, Integer pos1, Integer pos2) {
  	     Integer tileOfRackSelected;
		 if(actualPlayer.actions>0) {
			 switch(imgViewTile){
		       case "imgdeck1": 
		    	   tileOfRackSelected = 0;
		    	   System.out.print("J1 :");
		    	   return(j1TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img2deck1": 
		    	   tileOfRackSelected = 1;
		    	   System.out.print("J1 :");
		    	   return(j1TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img3deck1": 
		    	   tileOfRackSelected = 2;
		    	   System.out.print("J1 :");
		    	   return(j1TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img4deck1": 
		    	   tileOfRackSelected = 3;
		    	   System.out.print("J1 :");
		    	   return(j1TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img5deck1": 
		    	   tileOfRackSelected = 4;
		    	   System.out.print("J1 :");
		    	   return(j1TilePosed(pos1, pos2, tileOfRackSelected));
		       case "imgdeck2": 
		    	   tileOfRackSelected = 0;
		    	   System.out.print("J2 :");
		    	   return(j2TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img2deck2": 
		    	   tileOfRackSelected = 1;
		    	   System.out.print("J2 :");
		    	   return(j2TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img3deck2": 
		    	   tileOfRackSelected = 2;
		    	   System.out.print("J2 :");
		    	   return(j2TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img4deck2": 
		    	   tileOfRackSelected = 3;
		    	   System.out.print("J2 :");
		    	   return(j2TilePosed(pos1, pos2, tileOfRackSelected));
		       case "img5deck2": 
		    	   tileOfRackSelected = 4;
		    	   System.out.print("J2 :");
		    	   return(j2TilePosed(pos1, pos2, tileOfRackSelected));
		       default:
		           System.out.println("Choix incorrect");
		           break;
			 }}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Erreur");
					alert.setHeaderText("Attention ");
					alert.setContentText("Vous n'avez pas assez d'actions pour jouer une tuile");

					alert.showAndWait();
					return false;
			 }
			return true;
		 }
	private boolean j2TilePosed(Integer pos1, Integer pos2, Integer tileSelected) {
		   Tile tilePosee = (Tile) rackj2.getRack().get(tileSelected);
		   tilePosee.position.setX(pos1);
		   tilePosee.position.setY(pos2);
		   if (verifTiles(tilePosee, compteurTour)==false) {
			   return false;
		   };
		   rackj2.removeTileOfRack(tilePosee); 
		   compteurTour++;
		   System.out.println(compteurTour);
		   j2.actions-=1;
		   return true;
	}
	private boolean j1TilePosed(Integer pos1, Integer pos2, Integer tileSelected) {
		Tile tilePosee = (Tile) rackj1.getRack().get(tileSelected);
		tilePosee.position.setX(pos1);
		tilePosee.position.setY(pos2);
		if (verifTiles(tilePosee, compteurTour)==false) {
	       return false;
		};
		   rackj1.removeTileOfRack(tilePosee);
		   compteurTour++;
		   System.out.println(compteurTour);
		   j1.actions-=1;
		return true;
	};
	boolean verifTiles(Tile tile, Integer compteur) {
		Turn tour = new Turn();
		if(compteur==0){
			tour.firstTurn(tile,gameboardBack, listeTilesPlacees);
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
				if(j1.actions==0) {
					j1.actions+=1;
				}
				System.out.println("SCORE : "+actualPlayer.points);
				scorej2.setText(actualPlayer.points.toString());
		    	for(int i=0;i<5-rackj2.getRack().size();i++) {
		    	   this.rackj2.getRack().add(deckj2.draw());
		    	}
			    setImagesVisibleRackJ2();
				joueurPlay.setText("Le joueur 2 joue.");
			}else {
				idDeck2.setVisible(false);
				actualPlayer=j1;
				if(j2.actions==0) {
					j2.actions+=1;
				}
				System.out.println("SCORE : "+actualPlayer.points);
				scorej1.setText(actualPlayer.points.toString());
		    	for(int i=0;i<5-rackj1.getRack().size();i++) {
		    	   this.rackj1.getRack().add(deckj1.draw());
		   	   }
			    setImagesRackJ1Visible();
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
	private void setImagesVisibleRackJ2() throws FileNotFoundException {
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
	}
	private void setImagesRackJ1Visible() throws FileNotFoundException {
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
	}
    
    @FXML
    void buyActionj1(ActionEvent event) throws FileNotFoundException{
    	if(j1.points>=2) {
    		j1.actions+=1;
    		j1.points-=2;
    	}else {			
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erreur");
			alert.setHeaderText("Attention");
			alert.setContentText("Vous n'avez pas assez de points pour acheter una action !");
	
			alert.showAndWait();
    		
    	}
    }

    @FXML
    void buyActionj2(ActionEvent event) throws FileNotFoundException{
    	if(j2.points>=2) {
    		j2.actions+=1;
    		j2.points-=2;
    	}else {			
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Erreur");
			alert.setHeaderText("Attention");
			alert.setContentText("Vous n'avez pas assez de points pour acheter una action !");
	
			alert.showAndWait();
    		
    	}
    }
}
