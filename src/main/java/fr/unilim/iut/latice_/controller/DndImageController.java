package fr.unilim.iut.latice_.controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

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
	public static void manageSourceTargetAndDrop(ImageView target) {
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
		        boolean success = false;
		         if (event.getGestureSource() != target) {
		             target.setImage(source.getImage());
		         }
		        /* let the source know whether the string was successfully 
		         * transferred and used */
		        event.setDropCompleted(success);
		        
		        event.consume();
		     }
		});
		
	}


}
