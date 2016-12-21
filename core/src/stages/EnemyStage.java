package stages;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import characters.CollidingAICharacter;
import characters.CollidingObstacleCharacter;
import characters.CollidingPlayerCharacter;

public class EnemyStage extends SimpleStage {

	List<CollidingAICharacter> enemies;
	SimpleBattleStage battleStage;
	CollidingAICharacter removedEnemy;
	boolean isBattling;
	float savedPlayerX;
	float savedPlayerY;

	public EnemyStage(CollidingPlayerCharacter player, List<CollidingAICharacter> enemies,
			List<CollidingObstacleCharacter> obstacles, SpriteBatch spriteBatch) {
		super(player, obstacles, spriteBatch);

		this.enemies = enemies;
		isBattling = false;
	}

	@Override
	public void updateStage() {
		if (!isBattling) {
			for (CollidingAICharacter enemy : enemies) {
				enemy.updateAIMovement();
				
				if(enemy.checkCollision(player.getBounds())) {
					savedPlayerX = player.getXPos();
					savedPlayerY = player.getYPos();
					
					battleStage = new SimpleBattleStage(player, enemy, batch);
					isBattling = true;
					removedEnemy = enemy;
				}
			}
			if (removedEnemy != null) {
				enemies.remove(removedEnemy);
			}

			super.updateStage();
		}
		else {
			isBattling = battleStage.getBattlingStatus();
			battleStage.update();
			if(!isBattling) {
				player.setPosition(savedPlayerX, savedPlayerY);
			}
			
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		for (CollidingAICharacter enemy : enemies) {
			enemy.dispose();
		}
	}

	@Override
	public void addSpritesToBatch() {
		super.addSpritesToBatch();
		for (CollidingAICharacter enemy : enemies) {
			enemy.showCharacter(batch);
		}
	}
}
