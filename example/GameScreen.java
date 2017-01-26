package example;

import animation.AnimAdapter;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import screenmanager.SceneManager;

/**
 * Showcasing an example, here we can have a gamescreen that can extend to a Pane.
 * Using this, we can separate screens into different classes for a better orgianzation
 * @author Johnny Nguyen
 *
 */
public class GameScreen extends Pane {
	public GameScreen(SceneManager scene) {
		
		
		Button btn = new Button("Switch Screen");
		btn.setOnAction(e -> {
			// this is showing an example of how you'd create your own custom animation
			scene.setAnimation(new AnimAdapter() {
				public void animate(Node node) {
					
				}
			});
			
			scene.setScreen("Pane 2");
		});	
		
		// add btn
		getChildren().add(btn);
		
		setStyle("-fx-background-color: lightblue;");
	}
}
