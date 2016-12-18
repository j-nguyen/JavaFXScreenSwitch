package screenmanager;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * SceneManager class. This follows a lazy singelton pattern. This enables you to only have 1 scene object at each time.
 * We are not switching 'screens' by scenes, but rather switching out by panes. This is the Manager in which its only purpose
 * is to create the scene, and the screen controller.
 * @author Johnny Nguyen
 * @version 1.0.0
 *
 */
public class SceneManager extends Scene {
	private static SceneManager scene;
	private StackPane mainPane;
	private Map<String, Pane> screens;
	private String currScreen; 

	private SceneManager(double width, double height) {
		super(new StackPane(), width, height);
		this.mainPane = (StackPane) this.getRoot();
		// setup hashmap screen, screens.
		this.screens = new HashMap<String, Pane>();
		this.currScreen = "";
	}
	
	public static SceneManager getInstance(double width, double height) {
		if (scene == null) scene = new SceneManager(width, height);
		
		return scene;
	}
	
	// functions
	
	/**
	 * Adds a screen, based on string and pane. If there are no current screens, it'll assume this is the current screen. If there are screens,
	 * it will add the screen. If the screen exists, then it'll replace the screen.
	 * @param key - String Value
	 * @param value - Pane Object.
	 * @author Johnny Nguyen
	 */
	public void addScreen(String key, Pane value) {
		// If there are no screens, we are by default setting the added screen as the main screen.
		if (this.screens.isEmpty()) {
			currScreen = key;
			this.screens.put(currScreen, value);
			this.mainPane.getChildren().add(screens.get(currScreen));
		} else {
			// if screens still exist, we just add
			this.screens.put(key, value);
		}
	}
	
	/**
	 * Gets the current screen
	 * @return Pane object
	 */
	public Pane getCurrentScreen() {
		return screens.get(currScreen);
	}
	
	/**
	 * Switches current Screen to new screen specified by the argument.
	 * @param key - String key to get
	 * @author Johnny Nguyen
	 */
	public void switchScreen(String key) {
		// if the current get is not null, then we know it's there
		if (this.screens.get(key) != null) {
			// clear the screen, and show the other one
			this.mainPane.getChildren().clear();
			// set current screen and add 
			currScreen = key;
			this.mainPane.getChildren().add(this.screens.get(currScreen));
		}
	}
	
	/**
	 * Removes a screen based on key value.
	 * @param key String value
	 * @author Johnny Nguyen
	 */
	public void removeScreen(String key) {
		this.screens.remove(key);
	}
}
