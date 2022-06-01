package fr.unilim.iut.latice_.controller;

import fr.unilim.iut.latice_.Application.FXLaticeApplication;
import fr.unilim.iut.latice_.Application.FXMenuApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button btnNewGame;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRules;

    @FXML
    void launchLaticeGame(ActionEvent event) throws Exception {
    	FXLaticeApplication jeu = new FXLaticeApplication();
    	jeu.start(FXLaticeApplication.jeuStage);
    }
    
    @FXML
    void quitLaticeGame(ActionEvent event) throws Exception {
    	FXLaticeApplication jeu = new FXLaticeApplication();
    	FXLaticeApplication.jeuStage.close();
    	FXMenuApplication menu = new FXMenuApplication();
    	FXMenuApplication.menuStage.close();
    }
}