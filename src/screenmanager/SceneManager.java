package screenmanager;

import java.util.HashMap;
import java.util.Map;

import animation.Anim;
import animation.AnimType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * SceneManager class. This follows a lazy singelton pattern. This enables you to only have 1 scene object at each time.
 * We are not switching 'screens' by scenes, but rather switching out by panes. This is the Manager in which its only purpose
 * is to create the scene, and the screen controller.
 * @author Johnny Nguyen
 * @version 1.0.1
 *
 */
public class SceneManager extends Scene {
	// one instance
	private static SceneManager scene;
	// private variables
	private StackPane mainPane;
	private Map<String, Pane> screens;
	private Anim animEnter, animExit;

	private SceneManager(double width, double height) {
		super(new StackPane(), width, height);
		this.mainPane = (StackPane) this.getRoot();
		// setup hashmap screen, screens.
		this.screens = new HashMap<String, Pane>();
		// set-up animations
		animEnter = new Anim();
		animExit = new Anim();
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
	 * Sets the screen as the main screen. This can be used for switching screens.
	 * @param key value for hashmap
	 * @return true if screen is successful.
	 */
	public boolean setScreen(String key) {
		// tests to see if the key actually exists before beginning
		if (screens.get(key) != null) {
			// make a check if the current children is empty or not.
			if (!mainPane.getChildren().isEmpty()) {
				// here we create an animation for exiting the pane, before clearing				
				mainPane.getChildren().clear();
				// we know this is the default to set primarily.
				mainPane.getChildren().add(screens.get(key));
				// return true
				return true;
			} else {
				// set the enter anim node
				animEnter.setNode(screens.get(key));
				animExit.setNode(mainPane.getChildren().get(0));
				// create animation
				animEnter.animate();
				animExit.animate();
				return true;
			}
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
	
	/**
	 * Creates an animation/transition between two panes, in javafx.
	 * @param enter - An animation to enter into the pane.
	 * @param exit - Animation when exiting the previous pane.
	 */
	public void overrideTransition(AnimType enter, AnimType exit) {
		animEnter.setAnimation(enter);
		animExit.setAnimation(exit);
	}
}
