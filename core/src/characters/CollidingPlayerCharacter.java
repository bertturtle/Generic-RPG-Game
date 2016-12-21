package characters;

import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

import abilities.SimpleAbility;

public class CollidingPlayerCharacter extends CollidingGenericCharacter {
	
	boolean rightMovementEnabled;
	boolean leftMovementEnabled;
	boolean downMovementEnabled;
	boolean upMovementEnabled;
	
	public CollidingPlayerCharacter(Texture texture, float startingX, float startingY, int speed, int width,
			int height, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed, width, height, abilities, health);
		
		rightMovementEnabled = true;
		leftMovementEnabled = true;
		downMovementEnabled = true;
		upMovementEnabled = true;
	}
	
	public CollidingPlayerCharacter(Texture texture, float startingX, float startingY, int speed, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed, abilities, health);
		
		rightMovementEnabled = true;
		leftMovementEnabled = true;
		downMovementEnabled = true;
		upMovementEnabled = true;
	}
	
	public void updateMovement() {
		if(MyGdxGame.input.aPressed && leftMovementEnabled)
		{
			this.moveLeft();
		}
		if(MyGdxGame.input.dPressed && rightMovementEnabled)
		{
			this.moveRight();
		}
		if(MyGdxGame.input.wPressed && upMovementEnabled)
		{
			this.moveUp();
		}
		if(MyGdxGame.input.sPressed && downMovementEnabled)
		{
			this.moveDown();
		}
	}
	
	public void setMovementEnabledness(boolean enabled) {
		setUpMovementEnableness(enabled);
		setDownMovementEnableness(enabled);
		setLeftMovementEnableness(enabled);
		setRightMovementEnableness(enabled);
	}
	
	public void setUpMovementEnableness(boolean enabled) {
		upMovementEnabled = enabled;
	}
	
	public void setDownMovementEnableness(boolean enabled) {
		downMovementEnabled = enabled;
	}
	
	public void setLeftMovementEnableness(boolean enabled) {
		leftMovementEnabled = enabled;
	}
	
	public void setRightMovementEnableness(boolean enabled) {
		rightMovementEnabled = enabled;
	}
	
	public CollidingCharacter checkEnemyCollision(List<CollidingCharacter> enemies) {
		//TODO add stuff here
		for (CollidingCharacter enemy : enemies) {
			if (this.checkCollision(enemy.getBounds())) {
				return enemy;
			}
		}
		return null;
	}
}
