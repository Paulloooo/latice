package fr.unilim.iut.latice_.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXRulesApplication extends Application{
	public static Stage rulesStage = new Stage();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent content = FXMLLoader.load(getClass().getResource("RulesLaticeFX.fxml"));
		Scene scene = new Scene(content);
		System.out.print(scene);

		primaryStage.setScene(scene);

		primaryStage.setTitle("Rules Latice");
	    
		primaryStage.show();
		rulesStage = primaryStage;
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
