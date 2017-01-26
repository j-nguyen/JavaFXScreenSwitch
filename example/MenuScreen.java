package example;

import animation.AnimType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import screenmanager.SceneManager;

public class MenuScreen extends Pane {
	public MenuScreen(SceneManager scene) {
		
		Button btn = new Button("Switch Screen");
		btn.setOnAction(e -> {
			scene.setAnimation(AnimType.FADE);
			scene.setScreen("Pane 1");
		});
		
		getChildren().add(btn);
		
		setStyle("-fx-background-color: yellow;");
	}
}
