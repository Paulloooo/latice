package fr.unilim.iut.latice_.model.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import fr.unilim.iut.latice_.model.Gameboard;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;
import fr.unilim.iut.latice_.tools.TileGameTools;

public class TileTest {
	@Test
	void showGreenFeatherTile() {
		Tile tileTest = new Tile(Color.RED,Shape.FEATHER, null);
		String test = tileTest.toString();
		assertEquals(test,"RP");
	}
	
	@Test
	void checkIfTileIsPutAtPosition1and7OnGameboard() {
		Gameboard plateau = new Gameboard();
		Tile tile = new Tile(Color.MAGENTA,Shape.TURTLE, new Position(0,0));
		tile.position.setX(1);
		tile.position.setY(7);
		plateau.setTileAtPosition(tile, tile.position.getX(),tile.position.getY());
		assertEquals(plateau.isEmpty(1, 7),false);
	}
	
	@Test
	void generateMagentaTurtleTileImagePath() throws FileNotFoundException {
		String pathImage;
		pathImage = TileGameTools.generateTilePath(new Tile(Color.MAGENTA,Shape.TURTLE, new Position(0,0)));
		assertEquals(pathImage,"src/main/java/fr/unilim/iut/latice_/images/turtle_m.png");
	}
}
