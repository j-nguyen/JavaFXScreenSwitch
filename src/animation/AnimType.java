package animation;

import javafx.scene.Node;

/**
 * Strategy pattern using enums, this gives us a selected type of animations we want to use. Any new additions
 * will be added here.
 * @author Johnny Nguyen
 *
 */
public enum AnimType implements IAnim {
	FADE_IN {
		@Override
		public void animate(Node node) {
			
		}
	},
	
	FADE_OUT {
		@Override
		public void animate(Node node) {
			
		}
	}
}
