package animation;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class FadeAnimation implements AnimAdapter {
	@Override
	public void animate(Node node) {
		FadeTransition ft = new FadeTransition(Duration.millis(300));
		ft.setNode(node);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
	}
}
