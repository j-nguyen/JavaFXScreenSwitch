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

	private SceneManager(double width, double height) {
		super(new StackPane(), width, height);
		this.mainPane = (StackPane) this.getRoot();
		// setup hashmap screen, screens.
		this.screens = new HashMap<String, Pane>();
	}
	
	/**
	 * Gets the provided instance. Create a singleton instance, however, there are future looks to making
	 * the scenemanager an abstract factory pattern, or have the ability to create multiple instances of
	 * the Scene.
	 * @param width
	 * @param height
	 * @return
	 */
	public static SceneManager getInstance(double width, double height) {
		if (scene == null) scene = new SceneManager(width, height);
		
		return scene;
	}
	
	// functions
	
	/**
	 * Adds a screen, based on the parameters given. Note that if the current screen already exists, it 
	 * will replace the existing one with a new one! So please be careful.
	 * @param key - String Value
	 * @param value - Pane Object.
	 * @author Johnny Nguyen
	 */
	public void addScreen(String key, Pane value) {
		this.screens.put(key, value);
	}
	
	/**
	 * Sets the screen as the main screen.
	 * @param key value for hashmap
	 * @return true if screen is successful.
	 */
	public boolean setScreen(String key) {
		// tests to see if the key actually exists before beginning
		if (screens.get(key) != null) {
			// make a check if the current children is empty or not.
			if (!mainPane.getChildren().isEmpty()) mainPane.getChildren().clear();
			// now set this as the screen.
			mainPane.getChildren().add(screens.get(key));
		}
		return false;
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
