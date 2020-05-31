package undercooked.input;

import org.newdawn.slick.Input;

import undercooked.Undercooked;

public class WasdKeyboardInput extends KeyboardInput {

	public WasdKeyboardInput(Undercooked game) {
		super(game);
		upKey = Input.KEY_W;
		rightKey = Input.KEY_D;
		downKey = Input.KEY_S;
		leftKey = Input.KEY_A;
		interactKey = Input.KEY_O;
		actionKey = Input.KEY_P;
		throwKey = Input.KEY_I;
		pauseKey = Input.KEY_ESCAPE;
	}
}
