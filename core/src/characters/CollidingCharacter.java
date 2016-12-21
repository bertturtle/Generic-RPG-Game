package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import abilities.SimpleAbility;

public class CollidingCharacter extends SimpleCharacter {

	Rectangle collisionSquare;

	public CollidingCharacter(Texture texture, float startingX, float startingY, int speed, int width, int height) {
		super(texture, startingX, startingY, speed);
		
		collisionSquare = new Rectangle(startingX, startingY, width, height);
	}
	
	public CollidingCharacter(Texture texture, float startingX, float startingY, int speed) {
		super(texture, startingX, startingY, speed);
		
		collisionSquare = new Rectangle(startingX, startingY, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void showCharacter(SpriteBatch batch) {
		super.showCharacter(batch);
		collisionSquare.setX(this.xPos);
		collisionSquare.setY(this.yPos);
	}

	public Rectangle getBounds() {
		return collisionSquare;
	}

	public boolean checkCollision(Rectangle collider) {
		return collisionSquare.overlaps(collider);
	}
}
