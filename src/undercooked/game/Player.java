package undercooked.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;

import undercooked.game.levels.Level;
import undercooked.input.PlayerInput;

public class Player extends Entity{
	
	private double dirRad;
	private int dirInt;
	private int action; // TODO 0 = stand, 1 = walk
	private Entity holding;
	private Animation[][] actionSprites;
	private PlayerInput input;
	private Level level;
	
	private static final float MOVE_SPEED = 0.00025f;
	private static final float PLAYER_RADIUS = 0.25f;

	public Player(SpriteSheet sheet, PlayerInput input, Level level) {
		hitbox = new Circle(0, 0, PLAYER_RADIUS);
		actionSprites = new Animation[2][4];
		for(int i = 0; i < 4; i++) {
			actionSprites[0][i] = new Animation(sheet, 1, i, 1, i, false, 200, false);
			actionSprites[1][i] = new Animation(sheet, 0, i, 2, i, true, 200, true);
			actionSprites[1][i].setPingPong(true);
		}
		this.input = input;
		this.level = level;
		dirRad = Math.PI*0.5d;
		dirInt = 2;
	}
	
	@Override
	public void update(int delta) {
		int x = input.getXMove(), y = input.getYMove();
		if(x == 0) {
			System.out.println();
		}
		if(x != 0 || y != 0) {
			Circle temp = new Circle(getX(), getY(), PLAYER_RADIUS);
			for(int i = 0; i < delta; i++) {
				float cx = temp.getCenterX();
				temp.setCenterX(cx + MOVE_SPEED*x);
				if(!level.isLegalPosition(temp)) {
					temp.setCenterX(cx);
					break;
				}
			}
			for(int i = 0; i < delta; i++) {
				float cy = temp.getCenterY();
				temp.setCenterY(cy + MOVE_SPEED*y);
				if(!level.isLegalPosition(temp)) {
					temp.setCenterY(cy);
					break;
				}
			}
			setLocation(temp.getCenterX(), temp.getCenterY());
			
			dirRad = Math.atan2(y, x);
			if(dirRad > Math.PI/4 && dirRad < Math.PI*3/4) {
				dirInt = 2;
			}
			if(dirRad > Math.PI*-3/4 && dirRad < Math.PI/-4) {
				dirInt = 0;
			}
			if(dirRad >= Math.PI*-1/4 && dirRad <= Math.PI/4) {
				dirInt = 1;
			}
			if(dirRad >= Math.PI*3/4 || dirRad <= Math.PI*-3/4) {
				dirInt = 3;
			}
			if(x == y) {
				if(x < 0) {
					dirInt = 3;
				}
				if(x > 0) {
					dirInt = 1;
				}
			}
			if(holding != null) {
				holding.setLocation((float) (Math.cos(dirRad)*PLAYER_RADIUS), (float) (Math.sin(dirRad)*PLAYER_RADIUS));
			}
			action = 1;
		}
		else {
			action = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		actionSprites[action][dirInt].draw(getX()*96-48, getY()*96-120, 96, 144);
	}
	
	@Override
	public void renderHitbox(Graphics g) {
		Circle c = new Circle(getX()*96, getY()*96, PLAYER_RADIUS*96);
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

	public double getDirRad() {
		return dirRad;
	}

}
