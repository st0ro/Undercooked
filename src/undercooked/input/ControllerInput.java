package undercooked.input;

import org.newdawn.slick.ControllerListener;
import undercooked.Undercooked;

public class ControllerInput extends PlayerInput implements ControllerListener{
	
	private int controllerId;
	private static final float CONTROLLER_DEAD_ZONE = 0.3f;

	public ControllerInput(Undercooked game, int id) {
		super(game);
		controllerId = id;
		input.addControllerListener(this);
		//TODO technically should find "X axis" and "Y axis" named axis instead of presuming 0 and 1
	}

	public int getControllerId() {
		return controllerId;
	}

	@Override
	public int getXMove() {
		float x = input.getAxisValue(controllerId, 1);
		if(x < CONTROLLER_DEAD_ZONE && x > -CONTROLLER_DEAD_ZONE) {
			return 0;
		}
		return Math.round(x*100);
	}

	@Override
	public int getYMove() {
		float y = input.getAxisValue(controllerId, 0);
		if(y < CONTROLLER_DEAD_ZONE && y > -CONTROLLER_DEAD_ZONE) {
			return 0;
		}
		return Math.round(y*100);
	}

	@Override
	public boolean getAction() {
		return input.isButton2Pressed(controllerId);
	}
	
	@Override
	public void controllerButtonPressed(int controller, int button) {
		if(levelStarted && controllerId == controller) {
			if(button == 1) {
				playState.inputMade(INTERACT, id);
			}
			else if(button == 3) {
				playState.inputMade(THROW, id);
			}
			else if(button == 8) {
				playState.inputMade(PAUSE, id);
			}
		}
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {}

	@Override
	public void inputStarted() {}

	@Override
	public void controllerLeftPressed(int controller) {}

	@Override
	public void controllerLeftReleased(int controller) {}

	@Override
	public void controllerRightPressed(int controller) {}

	@Override
	public void controllerRightReleased(int controller) {}

	@Override
	public void controllerUpPressed(int controller) {}

	@Override
	public void controllerUpReleased(int controller) {}

	@Override
	public void controllerDownPressed(int controller) {}

	@Override
	public void controllerDownReleased(int controller) {}

	@Override
	public void controllerButtonReleased(int controller, int button) {}

}
