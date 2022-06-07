package fr.unilim.iut.latice_.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.unilim.iut.latice_.model.Moon;
import fr.unilim.iut.latice_.model.Normal;
import fr.unilim.iut.latice_.model.Sun;
import fr.unilim.iut.latice_.model.play.Referee;
import fr.unilim.iut.latice_.model.tiles.Color;
import fr.unilim.iut.latice_.model.tiles.Position;
import fr.unilim.iut.latice_.model.tiles.Shape;
import fr.unilim.iut.latice_.model.tiles.Tile;

public class GameboardTests {
	@Test
	void showMoonCaseTest() {
		Moon testMoon = new Moon();
		String test = testMoon.apparence();
		assertEquals(test,"M ");
		
	}
	
	@Test
	void showSunCaseTest() {
		Sun testSun = new Sun();
		String test = testSun.apparence();
		assertEquals(test,"S ");
		
	}
	
	@Test
	void showNormalCaseTest() {
		Normal testNormal = new Normal();
		String test = testNormal.apparence();
		assertEquals(test,"  ");
		
	}
	
	@Test
	void verifATilePlacementInGameboard() {
		ArrayList<Tile> tilesPlaced = new ArrayList();
		ArrayList<Tile> tilesNextTo = new ArrayList();
		Referee referee = new Referee();
		Tile tile1 = new Tile(Color.MAGENTA,Shape.TURTLE, new Position(4,4));
		Tile tile2 = new Tile(Color.GREEN,Shape.DOLPHIN, new Position(5,6));
		tilesPlaced.add(tile1);
		tilesPlaced.add(tile2);
		Tile tileToVerif =  new Tile(Color.MAGENTA,Shape.BIRD, new Position(4,5));
		tilesNextTo = referee.addTilesNextTo(tilesPlaced, tileToVerif);
		Boolean verifTest = referee.verifCase(tilesNextTo, tileToVerif);
		assertTrue(verifTest);
	}
}
