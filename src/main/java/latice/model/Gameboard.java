package latice.model;

import java.util.Arrays;

import latice.model.Moon;
import latice.model.Normal;
import latice.model.Sun;
import latice.model.tiles.Tile;



public class Gameboard {
	public String[][] test;
	
	public Gameboard(){
	this.test = new String[9][9];
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			Normal testcase = new Normal();
			test[i][j]=testcase.apparence();
			if (i==4&j==4){
				test[i][j]="";
				Moon testcasemoon = new Moon();
				test[i][j]=testcasemoon.apparence();
			}
		}
		if(i==0) {
			Sun testcaseSun = new Sun();
			test[i][0]=testcaseSun.apparence();
			test[i][4]=testcaseSun.apparence();
			test[i][8]=testcaseSun.apparence();
		}
		if(i==1) {
			Sun testcaseSun = new Sun();
			test[i][1]=testcaseSun.apparence();
			test[i][7]=testcaseSun.apparence();		
		}
		if(i==2) {
			Sun testcaseSun = new Sun();
			test[i][2]=testcaseSun.apparence();
			test[i][6]=testcaseSun.apparence();		
		}
		if(i==6) {
			Sun testcaseSun = new Sun();
			test[i][2]=testcaseSun.apparence();
			test[i][6]=testcaseSun.apparence();		
		}
		if(i==7) {
			Sun testcaseSun = new Sun();
			test[i][1]=testcaseSun.apparence();
			test[i][7]=testcaseSun.apparence();		
		}
		if(i==8) {
			Sun testcaseSun = new Sun();
			test[i][0]=testcaseSun.apparence();
			test[i][4]=testcaseSun.apparence();
			test[i][8]=testcaseSun.apparence();
		}
}
}
	public void showGameboard(Gameboard gameboard) {
		for(int i=0;i<9;i++){
			System.out.println(Arrays.toString(gameboard.test[i])+"\n");
		}
	}
	public void setTileAtPosition(Tile tile, int i, int j) {
		test[i][j] = tile.toString();	
	}
	
	public String getTileAtPosition(int i, int j) {
		String tileAtPositionStr = test[i][j];
		return tileAtPositionStr;
	}
	
	public boolean isEmpty(int i, int j) {
		return (test[i][j]=="  " || test[i][j]=="M " || test[i][j]=="S " );
	}
	

}