package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import abilities.SimpleAbility;

public class SimpleCharacter {

	float xPos;
	float yPos;
	boolean isShowing;
	boolean movingRight;
	int speed;
	Texture texture;

	public SimpleCharacter(Texture texture, float startingX, float startingY, int speed) {
		this.speed = speed;
		xPos = startingX;
		yPos = startingY;
		this.texture = texture;
	}
	
	public void setSpriteDirection(boolean isMovingRight) {
		movingRight = isMovingRight;
	}
	
	public void moveLeft() {
		xPos -= Gdx.graphics.getDeltaTime() * speed;
		movingRight = false;
	}

	public void moveRight() {
		xPos += Gdx.graphics.getDeltaTime() * speed;
		movingRight = true;
	}

	public void moveUp() {
		yPos += Gdx.graphics.getDeltaTime() * speed;
	}

	public void moveDown() {
		yPos -= Gdx.graphics.getDeltaTime() * speed;
	}

	public void moveLeftAtSpeed(int speed) {
		xPos -= Gdx.graphics.getDeltaTime() * speed;
	}

	public void moveRightAtSpeed(int speed) {
		xPos += Gdx.graphics.getDeltaTime() * speed;
	}

	public void moveUpAtSpeed(int speed) {
		yPos += Gdx.graphics.getDeltaTime() * speed;
	}

	public void moveDownAtSpeed(int speed) {
		yPos -= Gdx.graphics.getDeltaTime() * speed;
	}

	public void changePosition(float deltaX, float deltaY) {
		xPos += deltaX;
		yPos += deltaY;
	}

	public void setPosition(float x, float y) {
		xPos = x;
		yPos = y;
	}

	public float getXPos() {
		return xPos;
	}

	public float getYPos() {
		return yPos;
	}

	public void showCharacter(SpriteBatch batch) {
		batch.draw(texture, !movingRight ? xPos + texture.getWidth() : xPos, yPos,
				!movingRight ? -texture.getWidth() : texture.getWidth(), texture.getHeight());
		// batch.draw(texture, xPos, yPos);
	}

	public void dispose() {
		texture.dispose();
	}
}
