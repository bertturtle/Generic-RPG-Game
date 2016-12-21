package characters;

import com.badlogic.gdx.graphics.Texture;

import abilities.SimpleAbility;

public class CollidingGenericCharacter extends CollidingCharacter {
	
	SimpleAbility[] abilities;
	int maxHealth;
	int currentHealth;
	
	public CollidingGenericCharacter(Texture texture, float startingX, float startingY, int speed, int width,
			int height, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed, width, height);
		this.abilities = abilities;
		maxHealth = health;
		currentHealth = health;
	}

	public CollidingGenericCharacter(Texture texture, float startingX, float startingY, int speed, SimpleAbility[] abilities, int health) {
		super(texture, startingX, startingY, speed);
		this.abilities = abilities;
		maxHealth = health;
		currentHealth = health;
	}
	
	public SimpleAbility getAbility(int index) {
		if(abilities.length < index + 1) {
			return null;
		}
		else {
			return abilities[index];
		}
	}
	
	public void initializeAbility(int index, boolean isAttackingRight, int startingXPos) {
		abilities[index].initializeAbility(isAttackingRight, startingXPos, this);
	}
	
	public boolean updateAttackAndCheckIfFinished(int index) {
		return abilities[index].updateAbilityAndCheckIfFinished();
	}
	
	public int getAbilityCount() {
		return abilities.length;
	}
	
	public void loseHealth(int deltaHealth) {
		currentHealth -= deltaHealth;
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void resetHealth() {
		currentHealth = maxHealth;
	}
}
