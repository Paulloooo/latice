package fr.unilim.iut.latice_.view;

import java.io.FileNotFoundException;

import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import fr.unilim.iut.latice_.tools.TileGameTools;
import javafx.scene.image.Image;

public class TileGameView {
	
	//return imageView of the tile selected to show in JavaFX interface
	public static Image generateImageFromTile(Rack rack, Integer indice) throws FileNotFoundException {
		System.out.println("rack apres remplissage : "+rack.getRack());
		Tile tile1 = (Tile) rack.getRack().get(indice);
		String path = TileGameTools.generateTilePath(tile1);
		Image imageChargee = TileGameTools.loadCardImage(path);
		return imageChargee;
	}
}
