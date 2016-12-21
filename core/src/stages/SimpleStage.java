package stages;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import characters.CollidingAICharacter;
import characters.CollidingCharacter;
import characters.CollidingObstacleCharacter;
import characters.CollidingPlayerCharacter;

public class SimpleStage {

	List<CollidingObstacleCharacter> obstacles;
	CollidingPlayerCharacter player;
	SpriteBatch batch;
	int collisionNumber;

	public SimpleStage(CollidingPlayerCharacter player,
			List<CollidingObstacleCharacter> obstacles, SpriteBatch spriteBatch) {
		this.player = player;
		this.obstacles = obstacles;
		batch = spriteBatch;
	}

	public void updateStage() {
		updatePlayerCollisionMovement();

		player.updateMovement();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		addSpritesToBatch();
		batch.end();
	}
	
	public void addSpritesToBatch() {
		player.showCharacter(batch);
		
		for (CollidingObstacleCharacter obstacle : obstacles) {
			obstacle.showCharacter(batch);
		}
	}
	
	private void updatePlayerCollisionMovement() {
		player.setMovementEnabledness(true);
		for (CollidingObstacleCharacter obstacle : obstacles) {
			collisionNumber = obstacle.getCollisionDirection(player.getBounds());

			if (collisionNumber == 1) {
				player.setUpMovementEnableness(false);
			} else if (collisionNumber == 2) {
				player.setRightMovementEnableness(false);
			} else if (collisionNumber == 3) {
				player.setDownMovementEnableness(false);
			} else if (collisionNumber == 4) {
				player.setLeftMovementEnableness(false);
			}
		}
	}
	
	public void dispose() {
		player.dispose();
		
		for(CollidingObstacleCharacter obstacle : obstacles) {
			obstacle.dispose();
		}
	}
}
