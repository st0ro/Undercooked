package undercooked.input;

import org.newdawn.slick.Input;

import undercooked.PlayState;
import undercooked.Undercooked;
import undercooked.gui.GuiGroup;

public abstract class PlayerInput {
	
	public static final int INTERACT = 0, ACTION = 1, THROW = 2, PAUSE = 3, UP = 4, DOWN = 5, LEFT = 6, RIGHT = 7;
	
	protected float xMove, yMove;
	protected Undercooked game;
	protected int icon, id;
	public GuiGroup inputLabel;
	protected Input input;
	protected boolean levelStarted;
	protected PlayState playState;
	
	public PlayerInput(Undercooked game) {
		this.game = game;
		setInput(game.getContainer().getInput());
	}
	
	public abstract int getXMove();
	public abstract int getYMove();
	public abstract boolean getAction();
	
	public void setInput(Input input) {
		this.input = input;
	}
	
	public void setIcon(int i) {
		icon = i;
	}
	
	public int getIcon() {
		return icon;
	}
	
	public void startLevel(PlayState state, int id) {
		playState = state;
		levelStarted = true;
		this.id = id;
	}
}
