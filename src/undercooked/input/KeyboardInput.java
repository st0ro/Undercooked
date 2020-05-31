package undercooked.input;

import org.newdawn.slick.KeyListener;

import undercooked.Undercooked;

public abstract class KeyboardInput extends PlayerInput implements KeyListener{
	
	protected int interactKey, actionKey, throwKey, pauseKey, upKey, rightKey, downKey, leftKey;

	public KeyboardInput(Undercooked game) {
		super(game);
		input.addKeyListener(this);
	}
	
	@Override
	public int getXMove() {
		int x = 0;
		if(input.isKeyDown(rightKey)) {
			x += 100;
		}
		if(input.isKeyDown(leftKey)) {
			x -= 100;
		}
		return x;
	}

	@Override
	public int getYMove() {
		int y = 0;
		if(input.isKeyDown(downKey)) {
			y += 100;
		}
		if(input.isKeyDown(upKey)) {
			y -= 100;
		}
		return y;
	}
	
	@Override
	public boolean getAction() {
		return input.isKeyDown(actionKey);
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(levelStarted) {
			if(key == interactKey) {
				playState.inputMade(INTERACT, id);
			}
			else if(key == throwKey) {
				playState.inputMade(THROW, id);
			}
			else if(key == pauseKey) {
				playState.inputMade(PAUSE, id);
			}
		}
	}
	
	@Override
	public void keyReleased(int key, char c) {}

	@Override
	public boolean isAcceptingInput() {return true;}

	@Override
	public void inputStarted() {}
	
	@Override
	public void inputEnded() {}
}
