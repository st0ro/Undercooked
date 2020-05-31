package undercooked.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class FoodStack extends Entity {
	
	private static final int MAX_RECIPE_SIZE = 5;
	private static final float FOODSTACK_RADIUS = 0.25f;
	
	private Food[] foods;
	
	public FoodStack(Food base, int x, int y) {
		foods = new Food[MAX_RECIPE_SIZE];
		foods[0] = base;
		hitbox = new Circle(x, y, FOODSTACK_RADIUS);
	}
	
	public boolean attemptMerge(FoodStack other) {
		return false;
	}

	@Override
	public void update(int delta) {
		
	}

	@Override
	public void render(Graphics g) {
		for(int i = 0; i < MAX_RECIPE_SIZE; i++) {
			if(foods[i] != null) {
				foods[i].getSprite().draw(getX()*96 - 48, getY()*96 - 48, 96, 96);
			}
			else break;
		}
	}
	
	@Override
	public void renderHitbox(Graphics g) {
		Circle c = new Circle(getX()*96, getY()*96, FOODSTACK_RADIUS*96);
		g.setColor(Color.red);
		g.draw(c);
	}

	@Override
	public float getX() {
		return hitbox.getCenterX();
	}

	@Override
	public float getY() {
		return hitbox.getCenterY();
	}

	@Override
	public void setX(float x) {
		hitbox.setCenterX(x);
	}

	@Override
	public void setY(float y) {
		hitbox.setCenterY(y);
	}

	@Override
	public void setLocation(float x, float y) {
		setX(x);
		setY(y);
	}
}
