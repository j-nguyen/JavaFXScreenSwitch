package animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Strategy pattern using enums, this gives us a selected type of animations we want to use. Any new additions
 * will be added here.
 * @author Johnny Nguyen
 *
 */
public enum AnimType implements IAnim {
	FADE {
		@Override
		public void animate(Node node) {
			FadeTransition ft = new FadeTransition(Duration.millis(300));
			ft.setNode(node);
			ft.setFromValue(0.0);
			ft.setToValue(1.0);
			ft.play();
		}
	}
}
