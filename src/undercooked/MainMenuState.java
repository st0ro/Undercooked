package undercooked;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import undercooked.gui.ImageComponent;
import undercooked.gui.Label;
import undercooked.gui.ShapeComponent;

public class MainMenuState extends EventBasedState {

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		components.add(new ShapeComponent(container, 600, 400, 50, 200, Color.magenta, Color.lightGray));
		components.add(new ImageComponent(container, "assets/knight.png", 200, 300, 350, 200));
		components.add(new Label(container, "uwu", 400, 200));
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
