package fr.unilim.iut.latice_.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import latice.model.tiles.Tile;

public class TileGameTools {
	public static String generateTilePath(Tile tile) {
		String color = tile.color().toString();
		String shape = tile.shape().toString();
	    String name = "src/main/java/fr/unilim/iut/latice_/images/"+(shape+"_"+color.substring(0, 1)).toLowerCase()+".png";
	    return name;
	}
	public static Image loadCardImage(String path) throws FileNotFoundException {
		File file = new File(path);
		Image image = new Image(new FileInputStream(file));
		System.out.println(image);
		return image;
	}
}
