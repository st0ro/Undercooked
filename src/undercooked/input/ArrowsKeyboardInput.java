package undercooked.input;

import org.newdawn.slick.Input;

import undercooked.Undercooked;

public class ArrowsKeyboardInput extends KeyboardInput{

	public ArrowsKeyboardInput(Undercooked game) {
		super(game);
		upKey = Input.KEY_UP;
		rightKey = Input.KEY_RIGHT;
		downKey = Input.KEY_DOWN;
		leftKey = Input.KEY_LEFT;
		interactKey = 83;
		actionKey = 28;
		throwKey = Input.KEY_NUMPAD0;
		pauseKey = Input.KEY_NUMPAD9;
	}
}
