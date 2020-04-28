package undercooked.game;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public abstract class Entity {

	protected Shape hitbox;
	protected Vector2f velocity;
	protected Image sprite;
	
	public Entity() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void update(int delta) {}

}
