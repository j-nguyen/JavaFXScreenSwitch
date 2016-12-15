package screenmanager;

import controller.ScreenController;
import javafx.scene.Scene;

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
	private ScreenController screenController;

	private SceneManager(double width, double height) {
		super(new ScreenController(), width, height);
		this.screenController = (ScreenController) this.getRoot();
	}
	
	public ScreenController getScreenManager() {
		return this.screenController;
	}
	
	public static SceneManager getInstance(double width, double height) {
		if (scene == null) scene = new SceneManager(width, height);
		
		return scene;
	}
	
}
