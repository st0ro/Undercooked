package undercooked.game.levels;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import undercooked.Undercooked;
import undercooked.game.FoodStack;
import undercooked.game.Tile;

public class TestLevel extends StaticLevel {

	public TestLevel(Undercooked game) throws SlickException {
		super(game);
		sheet = new SpriteSheet("assets/tiles/emerald sheet.png", 16, 24);
		
		for(int x = 0; x < MAP_WIDTH; x++) {
			tiles[x][0] = new Tile(sheet.getSubImage(1, 0), false, false);
			tiles[x][1] = new Tile(sheet.getSubImage(1, 1), true, false);
			for(int y = 2; y < MAP_HEIGHT; y++) {
				tiles[x][y] = new Tile(sheet.getSubImage(0, 0), false, false);
			}
		}
		tiles[1][2] = new Tile(sheet.getSubImage(4, 0), true, true);
		tiles[6][6] = new Tile(sheet.getSubImage(5, 2), true, true);
		tiles[7][6] = new Tile(sheet.getSubImage(1, 2), true, true);
		tiles[8][6] = new Tile(sheet.getSubImage(6, 2), true, true);
		tiles[6][7] = new Tile(sheet.getSubImage(3, 2), true, true);
		tiles[8][7] = new Tile(sheet.getSubImage(3, 2), true, true);
		tiles[6][8] = new Tile(sheet.getSubImage(5, 3), true, true);
		tiles[7][8] = new Tile(sheet.getSubImage(1, 2), true, true);
		tiles[8][8] = new Tile(sheet.getSubImage(6, 3), true, true);
		
		players.get(0).setLocation(3, 3);
		if(players.size() >= 2) {
			players.get(1).setLocation(6, 3);
		}
		if(players.size() >= 3) {
			players.get(2).setLocation(9, 3);
		}
		if(players.size() >= 4) {
			players.get(3).setLocation(12, 3);
		}
		
		updateCollisionBoxes();
		
		entities.add(new FoodStack(game.foodReg.getFood(5), 10, 10));
	}

}
