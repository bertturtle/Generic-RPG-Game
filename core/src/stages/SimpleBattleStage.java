package stages;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.MyGdxGame;

import abilities.SimpleAbility;
import apple.laf.JRSUIConstants.State;
import characters.CollidingAICharacter;
import characters.CollidingGenericCharacter;
import characters.CollidingPlayerCharacter;

public class SimpleBattleStage {

	CollidingPlayerCharacter player;
	CollidingAICharacter enemy;
	SpriteBatch batch;
	int currentAbilityIndex;

	boolean isAttacking;
	boolean playerAttacking;
	boolean isBattling;
	ShapeRenderer shapeRenderer;
	final int healthBarWidth = 150;

	public SimpleBattleStage(CollidingPlayerCharacter player, CollidingAICharacter enemy, SpriteBatch batch) {
		this.player = player;
		this.enemy = enemy;
		this.batch = batch;

		this.player.setPosition(100, 100);
		this.player.setMovementEnabledness(false);
		enemy.setPosition(400, 150);
		enemy.setSpriteDirection(false);
		this.player.setSpriteDirection(true);
		shapeRenderer = new ShapeRenderer();

		isBattling = true;
		isAttacking = false;
		playerAttacking = true;
	}

	public void update() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		player.showCharacter(batch);

		enemy.showCharacter(batch);
		
		batch.end();
		
		displayHealth(player);
		
		displayHealth(enemy);

		if (isAttacking) {
			updateAttack();
		} else {
			if (playerAttacking) {
				if (MyGdxGame.input.onePressed) {
					// TODO add this so it makes the person attack with the move
					// they have
					if (player.getAbility(0) != null) {
						isAttacking = true;
						currentAbilityIndex = 0;
						player.initializeAbility(currentAbilityIndex, true, 100);
					}
				} else if (MyGdxGame.input.twoPressed) {
					System.out.println("Strong Attack");
					if (player.getAbility(1) != null) {
						isAttacking = true;
						currentAbilityIndex = 1;
						player.initializeAbility(currentAbilityIndex, true, 100);
					}
					// TODO make this be an actual attack and not end the battle
					// isBattling = false;
				} else if (MyGdxGame.input.threePressed) {
					System.out.println("Strong Attack");
					if (player.getAbility(2) != null) {
						isAttacking = true;
						currentAbilityIndex = 2;
						player.initializeAbility(currentAbilityIndex, true, 100);
					}
				} else if (MyGdxGame.input.wPressed) {
					isBattling = false;
				}
			} else {
				currentAbilityIndex = MyGdxGame.rand.nextInt(enemy.getAbilityCount());
				isAttacking = true;
				System.out.println("Enemy Ability Index: " + currentAbilityIndex);
				enemy.getAbility(currentAbilityIndex);
				enemy.initializeAbility(currentAbilityIndex, false, 400);
			}
		}
	}

	private void displayHealth(CollidingGenericCharacter character) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(255, 0, 0, 100);
		shapeRenderer.rect((float) (character.getXPos() + character.getBounds().getWidth() / 2 - 0.5 * healthBarWidth), character.getYPos() + (character.getBounds().getHeight()), healthBarWidth * (Float.valueOf(character.getHealth()) / Float.valueOf(character.getMaxHealth())), 10);
		shapeRenderer.end();
	}

	private void updateAttack() {
		if (playerAttacking) {
			if (player.updateAttackAndCheckIfFinished(currentAbilityIndex)) {
				enemy.loseHealth(player.getAbility(currentAbilityIndex).getStaticDamage());
				if (enemy.getHealth() <= 0) {
					System.out.println("Enemy Dead");
					isBattling = false;
				}
				System.out.println("Enemy Health: " + enemy.getHealth());
				isAttacking = false;
				playerAttacking = false;
			}
		} else {
			if (enemy.updateAttackAndCheckIfFinished(currentAbilityIndex)) {
				player.loseHealth(enemy.getAbility(currentAbilityIndex).getStaticDamage());
				if (player.getHealth() <= 0) {
					System.out.println("Player dead");
					MyGdxGame.startGame();
				}
				System.out.println("Player Health: " + player.getHealth());
				isAttacking = false;
				playerAttacking = true;
			}
		}
	}

	public boolean getBattlingStatus() {
		return isBattling;
	}
}
