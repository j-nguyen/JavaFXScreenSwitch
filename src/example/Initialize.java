package example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screenmanager.SceneManager;

/*
 * This class is supposed to show an example screen for you
 */

public class Initialize extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Creates Scene
		SceneManager scene = SceneManager.getInstance(800, 600);
		// random Button to show-case switching screens
		Button btn1 = new Button("Switch Screen");
		btn1.setOnAction(e -> scene.setScreen("Pane 2"));
		Button btn2 = new Button("Switch Screen");
		btn2.setOnAction(e -> scene.setScreen("Pane 1"));
		// Random Pane
		VBox pane = new VBox();
		VBox pane2 = new VBox();
		pane.setStyle("-fx-background-color: lightblue;");
		pane2.setStyle("-fx-background-color: yellow;");
		pane.getChildren().addAll(new Text("Pane 1"), btn1);
		pane2.getChildren().addAll(new Text("Pane 2"), btn2);
		pane.setAlignment(Pos.CENTER);
		pane2.setAlignment(Pos.CENTER);
		// add screen
		scene.addScreen("Pane 1", pane);
		scene.addScreen("Pane 2", pane2);
		// we now have to manually set which screen we want
		scene.setScreen("Pane 1");
		// create stage
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("JavaFX Screen Switch");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
