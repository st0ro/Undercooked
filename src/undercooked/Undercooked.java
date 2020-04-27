package undercooked;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Undercooked extends StateBasedGame {

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 500;

	public Undercooked() {
		super("Undercooked!");
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Add game states here

	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Undercooked()); //create game in container
			app.setDisplayMode(WIDTH, HEIGHT, false); //set window size and if fullscreen
			app.start();
		} catch (SlickException e) {
			e.printStackTrace(); //in case of failure to start game, will print error
		}
	}

}
