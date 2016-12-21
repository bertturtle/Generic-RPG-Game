package characters;

import com.badlogic.gdx.graphics.Texture;

import abilities.SimpleAbility;
import controllers.Timer;

public class CollidingAICharacter extends CollidingGenericCharacter {
	
	boolean movingRight;
	Timer movementTimer;
	
	public CollidingAICharacter(Texture texture, float startingX, float startingY, int speed, int width, int height, float movementDuration, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed, width, height, abilities, health);
		movingRight = true;
		movementTimer = new Timer(movementDuration);
	}
	
	public CollidingAICharacter(Texture texture, float startingX, float startingY, int speed, float movementDuration, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed, abilities, health);
		movingRight = true;
		movementTimer = new Timer(movementDuration);
	}
	//TODO add abilities
	public void updateAIMovement() {
		if (movementTimer.updateTimerAndCheckIfFinished())
		{
			movingRight = !movingRight;
		}
		if (movingRight)
		{
			this.moveRight();
		}
		else
		{
			this.moveLeft();
		}
	}
}
