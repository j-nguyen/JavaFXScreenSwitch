package animation;

import javafx.scene.Node;

/**
 * Animation class to start the animating process or transition between panes
 * @author Johnny Nguyen
 *
 */
public class Anim {
	// others
	private IAnim anim;
	private Node node;
	
	public Anim() {}
	
	public void setNode(Node node) {
		this.node = node;
	}
	
	public void setAnimation(IAnim anim) {
		this.anim = anim;
	}
	
	public void animate() {
		anim.animate(node);
		// we set the animation back to null again, along with the nodes
		anim = null;
		node = null;
	}
}
