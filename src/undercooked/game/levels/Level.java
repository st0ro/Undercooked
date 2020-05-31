package undercooked.game.levels;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Shape;

import undercooked.Undercooked;
import undercooked.game.Entity;
import undercooked.game.Player;
import undercooked.game.Tile;

public abstract class Level {
	
	public static final int MAP_WIDTH = 20;
	public static final int MAP_HEIGHT = 11;

	protected Tile[][] tiles;
	protected SpriteSheet sheet;
	protected List<Player> players;
	protected List<Entity> entities;
	
	private static String[] playerSheets = {"assets/sprites/purpleguy.png", "assets/sprites/midnight.png",
			"assets/sprites/rocker.png", "assets/sprites/girl.png"};
	
	public Level(Undercooked game) throws SlickException {
		tiles = new Tile[MAP_WIDTH][MAP_HEIGHT];
		entities = new ArrayList<Entity>();
		int playerCount = game.inputs.size();
		players = new ArrayList<Player>(playerCount);
		for(int i = 0; i < playerCount; i++) {
			SpriteSheet sheet = new SpriteSheet(playerSheets[game.inputs.get(i).getIcon()], 16, 24);
			sheet.setFilter(Image.FILTER_NEAREST);
			players.add(new Player(sheet, game.inputs.get(i), this));
		}
	}

	public void render(Graphics g) {
		for(int y = 0; y < MAP_HEIGHT; y++) {
			for(int x = 0; x < MAP_WIDTH; x++) {
				tiles[x][y].getSprite().draw(x*96, y*96-36, 96, 144);
			}
			for(Player p:players) {
				//TODO entities to render in correct order
				float pY = p.getY() + 0.2f;
				if(pY >= y && pY < y + 1) {
					p.render(g);
				}
			}
			for(Entity e:entities) {
				float pY = e.getY() + 0.2f;
				if(pY >= y && pY < y + 1) {
					e.render(g);
				}
			}
		}
		if(Undercooked.DEBUG_MODE) {
			for(Player p:players) {
				p.renderHitbox(g);
			}
			for(Entity e:entities) {
				e.renderHitbox(g);
			}
		}
	}
	
	public void update(int delta) {
		for(Player p:players) {
			p.update(delta);
		}
		for(Entity e:entities) {
			e.update(delta);
		}
	}
	
	public abstract  boolean isLegalPosition(Shape space);
}