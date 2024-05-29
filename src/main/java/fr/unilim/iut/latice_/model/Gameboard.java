package fr.unilim.iut.latice_.model;

import java.util.Arrays;

import fr.unilim.iut.latice_.model.Moon;
import fr.unilim.iut.latice_.model.Normal;
import fr.unilim.iut.latice_.model.Sun;
import fr.unilim.iut.latice_.model.tiles.Tile;



public class Gameboard {
	public String[][] gameboard;
	
	public static void message(String text) {
		System.out.println(text);
	}
	//generate a latice gameboard in console
	public Gameboard(){
	this.gameboard = new String[9][9];
	for (int caseIndice = 0; caseIndice < 9; caseIndice++) {
		for (int j = 0; j < 9; j++) {
			Normal gameboardCase = new Normal();
			gameboard[caseIndice][j]=gameboardCase.apparence();
			if (caseIndice==4&j==4){
				gameboard[caseIndice][j]="";
				Moon caseMoon = new Moon();
				gameboard[caseIndice][j]=caseMoon.apparence();
			}
		}
		if(caseIndice==0||caseIndice==8) {
			Sun caseSun = new Sun();
			gameboard[caseIndice][0]=caseSun.apparence();
			gameboard[caseIndice][4]=caseSun.apparence();
			gameboard[caseIndice][8]=caseSun.apparence();
		}
		if(caseIndice==1||caseIndice==7) {
			Sun caseSun = new Sun();
			gameboard[caseIndice][1]=caseSun.apparence();
			gameboard[caseIndice][7]=caseSun.apparence();		
		}
		if(caseIndice==2||caseIndice==6) {
			Sun caseSun = new Sun();
			gameboard[caseIndice][2]=caseSun.apparence();
			gameboard[caseIndice][6]=caseSun.apparence();		
		}
}
}
	public void showGameboard(Gameboard gameboard) {
		for(int i=0;i<9;i++){
			message(Arrays.toString(gameboard.gameboard[i])+"\n");
		}
	}
	public void setTileAtPosition(Tile tile, int pos1, int pos2) {
		gameboard[pos1][pos2] = tile.toString();	
	}
	
	public String getTileAtPosition(int pos1, int pos2) {
		return gameboard[pos1][pos2];
	}
	
	public boolean isEmpty(int pos1, int pos2) {
		return (gameboard[pos1][pos2]=="  " || gameboard[pos1][pos2]=="M " || gameboard[pos1][pos2]=="S " );
	}
	
	public boolean isSunCase(int pos1, int pos2) {
		return (gameboard[pos1][pos2]=="S " );
	}
	

}