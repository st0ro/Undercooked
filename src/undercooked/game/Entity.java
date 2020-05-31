package undercooked.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class Entity {

	protected Shape hitbox;
	protected float xVel, yVel, zPos;
	protected Entity parent;
	
	public abstract void update(int delta);
	
	public abstract void render(Graphics g);
	public abstract void renderHitbox(Graphics g);
	
	public abstract float getX();
	public abstract float getY();
	public float getZ() {
		return zPos;
	}
	public abstract void setX(float x);
	public abstract void setY(float y);
	public void setZ(float z) {
		zPos = z;
	}
	public abstract void setLocation(float x, float y);
	
	public Entity getParent() {
		return parent;
	}
	
	public void setParent(Entity parent) {
		this.parent = parent;
	}
}
