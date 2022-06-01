package fr.unilim.iut.latice_.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMenuApplication extends Application{
		public static Stage menuStage;
		@Override
		public void start(Stage primaryStage) throws Exception {
			Parent content = FXMLLoader.load(getClass().getResource("MenuLaticeFX.fxml"));
			Scene scene = new Scene(content);

			primaryStage.setScene(scene);

			primaryStage.setTitle("Latice");
		    
			primaryStage.show();
			menuStage = primaryStage;
		}
		
	    public static void main(String[] args) {
	        launch(args);
	    }
}
