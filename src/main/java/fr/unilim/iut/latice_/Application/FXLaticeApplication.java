package fr.unilim.iut.latice_.Application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class FXLaticeApplication extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent content = FXMLLoader.load(getClass().getResource("LaticeApplicationFX.fxml"));
		Scene scene = new Scene(content);



		// rattache la Scene au container Stage 
		primaryStage.setScene(scene);

		// Specifie un titre a la fenetre
	    primaryStage.setTitle("Latice");
	    
		primaryStage.show();
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
