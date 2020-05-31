package undercooked.game;

import org.newdawn.slick.Image;

public class Food {
	
	private int foodId;
	private Image sprite, icon;
	private String name;
	private boolean needsDish;
	private boolean bowl;
	private int renderPrio;
	
	public Food(int id, String name, Image sprite, Image icon, boolean needsDish, boolean bowl) {
		foodId = id;
		this.setSprite(sprite);
		this.setIcon(icon);
		this.name = name;
		this.needsDish = needsDish;
		this.bowl = bowl;
	}

	public String getName() {
		return name;
	}

	public int getRenderPriority() {
		return renderPrio;
	}

	public void setRenderPriority(int rp) {
		this.renderPrio = rp;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

}
