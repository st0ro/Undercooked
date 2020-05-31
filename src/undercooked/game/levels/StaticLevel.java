package undercooked.game.levels;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import undercooked.Undercooked;

public abstract class StaticLevel extends Level {
	
	protected List<Rectangle> collisionBoxes;

	public StaticLevel(Undercooked game) throws SlickException {
		super(game);
		collisionBoxes = new ArrayList<Rectangle>();
	}
	
	public void updateCollisionBoxes() {
		collisionBoxes.clear();
		for(int y = 0; y < MAP_HEIGHT; y++) {
			for(int x = 0; x < MAP_WIDTH; x++) {
				if(tiles[x][y].getBlocks()) {
					collisionBoxes.add(new Rectangle(x, y, 1, 1));
				}
			}
		}
	}

	@Override
	public boolean isLegalPosition(Shape space) {
		for(Rectangle r:collisionBoxes) {
			if(r.intersects(space)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if(Undercooked.DEBUG_MODE) {
			for(Rectangle r:collisionBoxes) {
				Rectangle rr = new Rectangle(r.getX()*96, r.getY()*96, 96, 96);
				g.draw(rr);
			}
		}
	}

}
