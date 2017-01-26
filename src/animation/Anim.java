package animation;

import javafx.scene.Node;

/**
 * Animation class to start the animating process or transition between panes
 * @author Johnny Nguyen
 *
 */
public class Anim {
	// instantiate variables
	private AnimAdapter anim;
	private Node node;
	
	public Anim() {}
	
	public void setNode(Node node) {
		this.node = node;
	}
	
	public void setAnimation(AnimAdapter anim) {
		this.anim = anim;
	}
	
	public void animate() {
		anim.animate(node);
		// we set the animation back to null again, along with the nodes
		anim = null;
		node = null;
	}

	public boolean isAnimation() {
		return anim != null;
	}
}
