package fr.unilim.iut.latice_.model;

import java.util.Arrays;

import fr.unilim.iut.latice_.model.Moon;
import fr.unilim.iut.latice_.model.Normal;
import fr.unilim.iut.latice_.model.Sun;
import fr.unilim.iut.latice_.model.tiles.Tile;



public class Gameboard {
	public String[][] gameboard;
	
	public Gameboard(){
	this.gameboard = new String[9][9];
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			Normal testcase = new Normal();
			gameboard[i][j]=testcase.apparence();
			if (i==4&j==4){
				gameboard[i][j]="";
				Moon testcasemoon = new Moon();
				gameboard[i][j]=testcasemoon.apparence();
			}
		}
		if(i==0) {
			Sun testcaseSun = new Sun();
			gameboard[i][0]=testcaseSun.apparence();
			gameboard[i][4]=testcaseSun.apparence();
			gameboard[i][8]=testcaseSun.apparence();
		}
		if(i==1) {
			Sun testcaseSun = new Sun();
			gameboard[i][1]=testcaseSun.apparence();
			gameboard[i][7]=testcaseSun.apparence();		
		}
		if(i==2) {
			Sun testcaseSun = new Sun();
			gameboard[i][2]=testcaseSun.apparence();
			gameboard[i][6]=testcaseSun.apparence();		
		}
		if(i==6) {
			Sun testcaseSun = new Sun();
			gameboard[i][2]=testcaseSun.apparence();
			gameboard[i][6]=testcaseSun.apparence();		
		}
		if(i==7) {
			Sun testcaseSun = new Sun();
			gameboard[i][1]=testcaseSun.apparence();
			gameboard[i][7]=testcaseSun.apparence();		
		}
		if(i==8) {
			Sun testcaseSun = new Sun();
			gameboard[i][0]=testcaseSun.apparence();
			gameboard[i][4]=testcaseSun.apparence();
			gameboard[i][8]=testcaseSun.apparence();
		}
}
}
	public void showGameboard(Gameboard gameboard) {
		for(int i=0;i<9;i++){
			System.out.println(Arrays.toString(gameboard.gameboard[i])+"\n");
		}
	}
	public void setTileAtPosition(Tile tile, int i, int j) {
		gameboard[i][j] = tile.toString();	
	}
	
	public String getTileAtPosition(int i, int j) {
		return gameboard[i][j];
	}
	
	public boolean isEmpty(int i, int j) {
		return (gameboard[i][j]=="  " || gameboard[i][j]=="M " || gameboard[i][j]=="S " );
	}
	
	public boolean isSunCase(int i, int j) {
		return (gameboard[i][j]=="S " );
	}
	

}