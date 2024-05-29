package fr.unilim.iut.latice_.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.model.tiles.decks.Rack;
import javafx.scene.image.Image;

public class TileGameTools {
	
	//return path of the image which refer to the tile selected
	public static String generateTilePath(Tile tile) {
		String color = tile.color().toString();
		String shape = tile.shape().toString();
	    String name = "src/main/java/fr/unilim/iut/latice_/images/"+(shape+"_"+color.substring(0, 1)).toLowerCase()+".png";
	    return name;
	}
	
	//generate the image with the path of the file
	public static Image loadCardImage(String path) throws FileNotFoundException {
		File file = new File(path);
		Image image = new Image(new FileInputStream(file));
		return image;
	}
}
