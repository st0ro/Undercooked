package undercooked;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import undercooked.game.levels.TestLevel;
import undercooked.gui.Button;

public class LevelSelectState extends EventBasedState {
	
	private Undercooked game;
	
	public LevelSelectState(Undercooked game) {
		this.game = game;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Button btnPlay = new Button(container, 960, 600, 248, 132, new Image("assets/gui/btnPlay.png")) {
			@Override
			public void onLeftClick() {
				PlayState ps = (PlayState)(LevelSelectState.this.game.states[2]);
				try {
					ps.startLevel(LevelSelectState.this.game, new TestLevel(LevelSelectState.this.game));
				} catch (SlickException e) {
					e.printStackTrace();
				}
				game.enterState(2);
			}
		};
		btnPlay.setHeld(new Image("assets/gui/btnPlayClick.png"));
		components.add(btnPlay);
	}
	
	@Override
	public int getID() {
		return 1;
	}
}
