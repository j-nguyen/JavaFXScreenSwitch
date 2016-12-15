# JavaFXScreenSwitch
A small framework designed to help you switch between screens.

# Example
```Java
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screenmanager.SceneManager;

public class Example extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Creates Scene
		SceneManager scene = SceneManager.getInstance(800, 600);
		// random Button to show-case switching screens
		Button btn1 = new Button("Switch Screen");
		btn1.setOnAction(e -> scene.getScreenManager().switchScreen("Pane 2"));
		Button btn2 = new Button("Switch Screen");
		btn2.setOnAction(e -> scene.getScreenManager().switchScreen("Pane 1"));
		// Random Pane
		VBox pane = new VBox();
		VBox pane2 = new VBox();
		pane.setStyle("-fx-background-color: blue;");
		pane2.setStyle("-fx-background-color: yellow;");
		pane.getChildren().addAll(new Text("Pane 1"), btn1);
		pane2.getChildren().addAll(new Text("Pane 2"), btn2);
		pane.setAlignment(Pos.CENTER);
		pane2.setAlignment(Pos.CENTER);
		// add screen
		scene.getScreenManager().addScreen("Pane 1", pane);
		scene.getScreenManager().addScreen("Pane 2", pane2);
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

```
