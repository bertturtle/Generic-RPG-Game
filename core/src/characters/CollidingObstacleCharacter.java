package characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CollidingObstacleCharacter extends CollidingCharacter {

	float playerXPos;
	float playerYPos;
	
	public CollidingObstacleCharacter(Texture texture, float startingX, float startingY, int width,
			int height) {
		super(texture, startingX, startingY, 0, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public CollidingObstacleCharacter(Texture texture, float startingX, float startingY) {
		super(texture, startingX, startingY, 0);
		// TODO Auto-generated constructor stub
	}
	
	public int getCollisionDirection(Rectangle collider) {
		float colliderXPos = collider.getX();
		float colliderYPos = collider.getY();
		
		float xPosDelta;
		float yPosDelta;
		
		boolean xInverted = false;
		boolean yInverted = false;
		
		playerXPos = this.getBounds().getX();
		playerYPos = this.getBounds().getY();
		
		if (super.checkCollision(collider)) {
			colliderXPos += collider.getWidth() / 2;
			colliderYPos += collider.getHeight() / 2;
			
			playerXPos += this.getBounds().getWidth() / 2;
			playerYPos += this.getBounds().getHeight() / 2;
			
			xPosDelta = playerXPos - colliderXPos;
			yPosDelta = playerYPos - colliderYPos;
			
			if(xPosDelta < 0) {
				xInverted = true;
				xPosDelta = -xPosDelta;
			}
			if(yPosDelta < 0) {
				yInverted = true;
				yPosDelta = -yPosDelta;
			}
			
			xPosDelta -= this.getBounds().getWidth() / 2;
			yPosDelta -= this.getBounds().getHeight() / 2;
			
			xPosDelta = xPosDelta / collider.getWidth();
			yPosDelta = yPosDelta / collider.getHeight();
			
			if (xPosDelta > yPosDelta) {
				if (xInverted) {
					return 4;
				}
				else {
					return 2;
				}
			}
			else {
				if (yInverted) {
					return 3;
				}
				else {
					return 1;
				}
			}
		}
		else {
			return 0;
		}
	}
}
