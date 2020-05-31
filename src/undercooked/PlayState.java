package undercooked;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.FontUtils;

import undercooked.game.FoodRegistry;
import undercooked.game.levels.Level;
import undercooked.input.PlayerInput;

public class PlayState extends BasicGameState {
	
	private Undercooked game;
	private Level currentLevel;
	
	private boolean paused;
	private Color boxFill;
	private int tickReducer;
	
	public PlayState(Undercooked game) {
		this.game = game;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		
		this.game.foodReg = new FoodRegistry();
		
		boxFill = new Color(100, 100, 100, 150);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		currentLevel.render(g);
		
		if(paused) {
			g.setColor(boxFill);
			g.fillRect(0, 0, Undercooked.WIDTH, Undercooked.HEIGHT);
			FontUtils.drawString(g.getFont(), "PAUSED", FontUtils.Alignment.CENTER, Undercooked.WIDTH/2, Undercooked.HEIGHT/2, 0, Color.white);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		tickReducer += delta;
		int updates = tickReducer/10;
		if(!paused && updates > 0) {
			currentLevel.update(updates);
		}
		tickReducer %= 10;
	}
	
	public void startLevel(Undercooked game, Level level) {
		this.game = game;
		currentLevel = level;
		for(int i = 0; i < game.inputs.size(); i++) {
			game.inputs.get(i).startLevel(this, i);
		}
	}
	
	public void inputMade(int inputType, int id) {
		switch(inputType) {
		case PlayerInput.INTERACT:
			
			break;
		case PlayerInput.THROW:
			
			break;
		case PlayerInput.PAUSE:
			paused ^= true;
			break;
		}
	}

	@Override
	public int getID() {
		return 2;
	}

}
