package example;

import javafx.application.Application;
import javafx.stage.Stage;
import screenmanager.SceneManager;

/*
 * This class is supposed to show an example screen for you
 */

public class Initialize extends Application {
	// Creates Scene
	SceneManager scene = SceneManager.getInstance(800, 600);
	// Here we can create our game screens, and then reference the scene as a guideline.
	GameScreen gScreen = new GameScreen(scene);
	MenuScreen mScreen = new MenuScreen(scene);

	@Override
	public void start(Stage primaryStage) {
		// add screen
		scene.addScreen("Pane 1", gScreen);
		scene.addScreen("Pane 2", mScreen);
		
		// This is at the start, we can set the main screen.
		scene.setScreen("Pane 1");
		
		// create stage
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("JavaFX Screen Switch Example");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
