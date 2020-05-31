package undercooked.game;

import org.newdawn.slick.Image;

public class Tile {
	
	protected boolean blocks;
	protected boolean canPlace;
	protected Image sprite;

	public Tile(Image img, boolean blocks, boolean canPlace) {
		this.blocks = blocks;
		this.canPlace = canPlace;
		this.sprite = img;
	}
	
	public void update(int delta) {}
	
	public void step(Player player) {}
	
	public void interact(Player player) {}
	
	public Image getSprite() {
		return sprite;
	}
	
	public boolean getBlocks() {
		return blocks;
	}
	
	public void setBlocks(boolean blocks) {
		this.blocks = blocks;
	}
	
	public boolean getPlace() {
		return canPlace;
	}
	
	public void setPlace(boolean place) {
		this.canPlace = place;
	}
}
