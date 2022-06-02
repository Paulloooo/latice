package fr.unilim.iut.latice.view;

import java.io.FileNotFoundException;

import fr.unilim.iut.latice_.tools.TileGameTools;
import javafx.scene.image.Image;
import latice.model.tiles.Tile;
import latice.model.tiles.decks.Rack;

public class TileGameView {
	public static Image generateImageFromTile(Rack rack, Integer indice) throws FileNotFoundException {
		System.out.println("rack apres remplissage : "+rack.getRack());
		Tile tile1 = (Tile) rack.getRack().get(indice);
		String path = TileGameTools.generateTilePath(tile1);
		Image imageChargee = TileGameTools.loadCardImage(path);
		return imageChargee;
	}
}
