package undercooked;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import undercooked.game.FoodRegistry;
import undercooked.input.PlayerInput;

public class Undercooked extends StateBasedGame {

	public static final int WIDTH = 1920;
	public static final int HEIGHT = 1080;
	public static final boolean DEBUG_MODE = false;
	
	public GameState[] states;
	public List<PlayerInput> inputs;
	public FoodRegistry foodReg;

	public Undercooked() {
		super("Undercooked!");
		states = new GameState[3];
		inputs = new ArrayList<PlayerInput>(4);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		states[0] = new MainMenuState(this);
		addState(states[0]);
		states[1] = new LevelSelectState(this);
		addState(states[1]);
		states[2] = new PlayState(this);
		addState(states[2]);
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Undercooked()); //create game in container
			app.setDisplayMode(WIDTH, HEIGHT, false); //set window size and if fullscreen
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace(); //in case of failure to start game, will print error
		}
	}

}
