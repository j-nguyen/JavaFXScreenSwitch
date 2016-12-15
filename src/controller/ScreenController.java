package controller;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * ScreenController handles all the screen switching, adding, and removing screens. This extends the StackPane class, 
 * as a Manager to set for now.
 * @author Johnny Nguyen
 * 
 */
public class ScreenController extends StackPane {
	private Map<String, Pane> screens;
	private String currScreen;
	
	public ScreenController() {
		// initialize the screen
		screens = new HashMap<String, Pane>();
		// set screen. there is none at the start.
		currScreen = "";
	}
	
	/**
	 * Returns a map, of all screens.
	 * @return HashMap<String, Pane>
	 * @author Johnny Nguyen
	 */
	public Map<String, Pane> getAllScreen() {
		return this.screens;
	}
	
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
			this.getChildren().add(screens.get(currScreen));
		} else {
			// if screens still exist, we just add
			this.screens.put(key, value);
		}
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
			this.getChildren().clear();
			// set current screen and add 
			currScreen = key;
			this.getChildren().add(this.screens.get(currScreen));
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
