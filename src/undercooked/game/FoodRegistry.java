package undercooked.game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import undercooked.game.FoodRegistry.ProcessType;

public class FoodRegistry {
	
	public static enum ProcessType {
		CHOP,
		FRY,
		DEEP_FRY,
		BOIL
	}
	
	private List<Food> foodList;
	private List<Recipe> recipeList;
	public Image imagePlate, imageBowl;

	public FoodRegistry() throws SlickException {
		foodList = new ArrayList<Food>();
		recipeList = new ArrayList<Recipe>();
		SpriteSheet foodSheet = new SpriteSheet("assets/food/food sheet.png", 32, 32);
		imagePlate = foodSheet.getSprite(0, 5);
		imageBowl = foodSheet.getSprite(1, 5);
		
		addFood("fishRaw", foodSheet.getSprite(0, 0), null, false, false);		//0
		addFood("fishChopped", foodSheet.getSprite(1, 0), null, false, false);	//1
		addFood("noriRaw", foodSheet.getSprite(2, 0), null, false, false);		//2
		addFood("riceRaw", foodSheet.getSprite(3, 0), null, false, false);		//3
		addFood("riceCooked", foodSheet.getSprite(3, 0), null, true, false);	//4
		addFood("nigiriFish", foodSheet.getSprite(4, 0), null, false, false);	//5
		addFood("nigiriShrimp", foodSheet.getSprite(5, 0), null, false, false);	//6
		addFood("nigiriEgg", foodSheet.getSprite(0, 1), null, false, false);	//7
		addFood("misoSoup", foodSheet.getSprite(1, 1), null, true, true);		//8
		
		addRecipe(0, ProcessType.CHOP, 1); //fishRaw -> fishChopped
	}
	
	public void addFood(String name, Image sprite, Image icon, boolean dish, boolean bowl) {
		foodList.add(new Food(foodList.size(), name, sprite, icon, dish, bowl));
	}
	
	public void addRecipe(int input, ProcessType process, int output) {
		Food[] in = {getFood(input)}, out = {getFood(output)};
		recipeList.add(new Recipe(in, process, out));
	}
	
	public void addRecipe(int[] inputs, ProcessType process, int[] outputs) {
		Food[] in = new Food[inputs.length], out = new Food[outputs.length];
		for(int i = 0; i < inputs.length; i++) {
			in[i] = getFood(inputs[i]);
		}
		for(int j = 0; j < outputs.length; j++) {
			out[j] = getFood(outputs[j]);
		}
		recipeList.add(new Recipe(in, process, out));
	}
	
	public Food getFood(int id) {
		return foodList.get(id);
	}
	
	public Food getFood(String name) {
		for(Food f:foodList) {
			if(f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

}

class Recipe {
	private ProcessType process;
	private Food[] input, output;
	
	public Recipe(Food[] in, ProcessType pro, Food[] out) {
		process = pro;
		input = in;
		output = out;
	}
	
	public ProcessType getProcess() {
		return process;
	}
	public void setProcess(ProcessType process) {
		this.process = process;
	}
	public Food[] getInput() {
		return input;
	}
	public void setInput(Food[] input) {
		this.input = input;
	}
	public Food[] getOutput() {
		return output;
	}
	public void setOutput(Food[] output) {
		this.output = output;
	}
}
