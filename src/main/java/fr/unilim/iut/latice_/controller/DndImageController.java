package fr.unilim.iut.latice_.controller;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class DndImageController {
	public static void manageSourceDragAndDrop(ImageView source) {
		source.setOnDragDetected(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		    	
		        /* drag was detected, start a drag-and-drop gesture*/
		        /* allow any transfer mode */
		        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
		        
		        /* Put a string on a dragboard */
		        ClipboardContent content = new ClipboardContent();
		        content.putImage(source.getImage());
		        db.setContent(content);
		        event.consume();
		    }
		}); 
	}

	public static void manageSourceTargetAndDrop(GridPane target) {
		target.setOnDragOver(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        /* data is dragged over the target */
		        /* accept it only if it is not dragged from the same node 
		         * and if it has a string data */
		        if (event.getDragboard().hasImage()) {
		            /* allow for both copying and moving, whatever user chooses */
		            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		        }
		        
		        event.consume();
		    }
		});
		
		
		target.setOnDragDropped(new EventHandler<DragEvent>() {
		    public void handle(DragEvent event) {
		        ImageView source = (ImageView) event.getGestureSource();

		        Dragboard db = event.getDragboard();
		        Node node = event.getPickResult().getIntersectedNode();
		        boolean success = false;
		        
		        Integer cIndex = GridPane.getColumnIndex(node);
		        Integer rIndex = GridPane.getRowIndex(node);
		        int x = cIndex == null ? 0 : cIndex;
		        int y = rIndex == null ? 0 : rIndex;
		        
		        if (db.hasImage()) {
		        	ImageView image = new ImageView(db.getImage());
		        	image.setFitHeight(40);
		        	image.setFitWidth(40);
		        	
		        	target.add(image, x, y);
		        	target.setValignment(image, VPos.CENTER);
		        	target.setHalignment(image, HPos.CENTER);	
		        	source.setVisible(false);
		        	success = true;
		        }

		        event.setDropCompleted(success);
		        
		        event.consume();
		     }
		});
		
	}
}
