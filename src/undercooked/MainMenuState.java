package undercooked;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import undercooked.gui.Button;
import undercooked.gui.GuiGroup;
import undercooked.gui.ImageComponent;
import undercooked.input.WasdKeyboardInput;
import undercooked.input.PlayerInput;
import undercooked.input.ArrowsKeyboardInput;
import undercooked.input.ControllerInput;

public class MainMenuState extends EventBasedState {
	
	private Undercooked game;
	private SpriteSheet iconSheet, inputSheet;
	
	public MainMenuState(Undercooked game) {
		this.game = game;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Button btnPlay = new Button(container, 960, 600, 248, 132, new Image("assets/gui/btnPlay.png")) {
			@Override
			public void onLeftClick() {
				if(MainMenuState.this.game.inputs.size() > 0) {
					game.enterState(1);
				}
			}
		};
		btnPlay.setHeld(new Image("assets/gui/btnPlayClick.png"));
		components.add(btnPlay);
		components.add(new ImageComponent(container, "assets/gui/titlePixelated.png", 960, 100, 1068, 136));
		
		iconSheet = new SpriteSheet("assets/sprites/heads.png", 16, 12);
		inputSheet = new SpriteSheet("assets/gui/inputiconsheet.png", 33, 33);
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_O) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof WasdKeyboardInput) {
					return;
				}
			}
			if(game.inputs.size() < 4) {
				addPlayer(new WasdKeyboardInput(game), 0);
			}
		}
		if(key == Input.KEY_P) {
			PlayerInput remove = null;
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof WasdKeyboardInput) {
					remove = pi;
					break;
				}
			}
			if(remove != null) {
				game.inputs.remove(remove);
				refreshPlayers();
			}
		}
		if(key == Input.KEY_A) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof WasdKeyboardInput) {
					int icon = pi.getIcon() - 1;
					if(icon < 0) {
						icon += 4;
					}
					pi.setIcon(icon);
					refreshPlayers();
				}
			}
		}
		if(key == Input.KEY_D) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof WasdKeyboardInput) {
					int icon = pi.getIcon() + 1;
					if(icon > 3) {
						icon -= 4;
					}
					pi.setIcon(icon);
					refreshPlayers();
				}
			}
		}
		if(key == 83) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ArrowsKeyboardInput) {
					return;
				}
			}
			if(game.inputs.size() < 4) {
				addPlayer(new ArrowsKeyboardInput(game), 1);
			}
		}
		if(key == 28) {
			PlayerInput remove = null;
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ArrowsKeyboardInput) {
					remove = pi;
					break;
				}
			}
			if(remove != null) {
				game.inputs.remove(remove);
				refreshPlayers();
			}
		}
		if(key == Input.KEY_LEFT) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ArrowsKeyboardInput) {
					int icon = pi.getIcon() - 1;
					if(icon < 0) {
						icon += 4;
					}
					pi.setIcon(icon);
					refreshPlayers();
				}
			}
		}
		if(key == Input.KEY_RIGHT) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ArrowsKeyboardInput) {
					int icon = pi.getIcon() + 1;
					if(icon > 3) {
						icon -= 4;
					}
					pi.setIcon(icon);
					refreshPlayers();
				}
			}
		}
	}
	
	@Override
	public void controllerButtonPressed(int controller, int button) {
		if(button == 1) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ControllerInput) {
					ControllerInput ci = (ControllerInput)pi;
					if(ci.getControllerId() == controller) {
						return;
					}
				}
			}
			if(game.inputs.size() < 4) {
				addPlayer(new ControllerInput(game, controller), 2);
			}
		}
		if(button == 2) {
			PlayerInput remove = null;
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ControllerInput) {
					ControllerInput ci = (ControllerInput)pi;
					if(ci.getControllerId() == controller) {
						remove = pi;
						break;
					}
				}
			}
			if(remove != null) {
				game.inputs.remove(remove);
				refreshPlayers();
			}
		}
		if(button == 3) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ControllerInput) {
					ControllerInput ci = (ControllerInput)pi;
					if(ci.getControllerId() == controller) {
						int icon = pi.getIcon() + 1;
						if(icon > 3) {
							icon -= 4;
						}
						pi.setIcon(icon);
						refreshPlayers();
					}
				}
			}
		}
		if(button == 4) {
			for(PlayerInput pi:game.inputs) {
				if(pi instanceof ControllerInput) {
					ControllerInput ci = (ControllerInput)pi;
					if(ci.getControllerId() == controller) {
						int icon = pi.getIcon() - 1;
						if(icon < 0) {
							icon += 4;
						}
						pi.setIcon(icon);
						refreshPlayers();
					}
				}
			}
		}
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		super.render(container, game, g);
		for(PlayerInput pi:this.game.inputs) {
			pi.inputLabel.render(container, g);
		}
	}
	
	private void addPlayer(PlayerInput pi, int type) {
		game.inputs.add(pi);
		GuiGroup gg = new GuiGroup(game.getContainer());
		int index = game.inputs.indexOf(pi);
		gg.addComponent(new ImageComponent(game.getContainer(), "assets/gui/inputPanel.png", 1750, 400+index*86, 180, 66));
		gg.addComponent(new ImageComponent(game.getContainer(), iconSheet.getSprite(0, 0), 1705, 400+index*86, 64, 48));
		gg.addComponent(new ImageComponent(game.getContainer(), inputSheet.getSprite(type, 0), 1785, 400+index*86, 66, 66));
		pi.inputLabel = gg;
	}
	
	private void refreshPlayers() {
		for(int i = 0; i < game.inputs.size(); i ++) {
			GuiGroup label = game.inputs.get(i).inputLabel;
			label.getComponent(0).setLocation(1750, 400+86*i);
			ImageComponent img = (ImageComponent)(label.getComponent(1));
			img.setImage(iconSheet.getSprite(game.inputs.get(i).getIcon(), 0));
			label.getComponent(1).setLocation(1705, 400+86*i);
			label.getComponent(2).setLocation(1785, 400+86*i);
		}
	}
	
	@Override
	public int getID() {
		return 0;
	}
}
