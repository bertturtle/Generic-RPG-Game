package abilities;

import java.util.Random;

import com.mygdx.game.MyGdxGame;

import characters.SimpleCharacter;
import controllers.Timer;

public class SimpleAbility {
	
	int abilityMovementSpeed;
	int attackDirectionMultiplier;
	int damage;
	float attackMoveDistance;
	boolean isHalfwayDone;
	SimpleCharacter user;
	float startingX;
	int maxCooldown;
	int currentCooldown;
	
	
	public SimpleAbility(int attackMovementSpeed, float attackMoveDistance, int abilityDamage, int cooldown) {
		this.abilityMovementSpeed = attackMovementSpeed;
		this.damage = abilityDamage;
		this.attackMoveDistance = attackMoveDistance;
		attackDirectionMultiplier = 1;
		maxCooldown = cooldown;
		currentCooldown = cooldown;
		
		isHalfwayDone = false;
	}
	
	public int getCurrentCooldown() {
		return currentCooldown;
	}
	
	public void decreaseCooldown(int cooldownDecrease) {
		currentCooldown -= cooldownDecrease;
		//Hi
	}
	
	public int getStaticDamage() {
		return damage;
	}
	
	public int getAdjustedDamage() {
		
		int damageAdjuster = (int) Math.round(damage * 0.1);
		
		return damage + MyGdxGame.rand.nextInt(damageAdjuster * 2) - damageAdjuster;
	}
	
	public void initializeAbility(boolean isAttackingRight, int startingXPos, SimpleCharacter user) {
		System.out.println(user.getClass());
		if(!isAttackingRight) {
			attackDirectionMultiplier = -1;
		}
		this.user = user;
		startingX = startingXPos;
	}
	
	public boolean updateAbilityAndCheckIfFinished() {
		updateAbility();
		
		return abilityIsFinished();
	}
	
	public void updateAbility() {
		user.moveRightAtSpeed(abilityMovementSpeed * attackDirectionMultiplier);
		
		if((startingX - attackMoveDistance > user.getXPos() || attackMoveDistance + startingX < user.getXPos()) && !isHalfwayDone) {
			attackDirectionMultiplier = -attackDirectionMultiplier;
			isHalfwayDone = true;
		}
	}
	
	public boolean abilityIsFinished() {
		if ((user.getXPos() < startingX && isHalfwayDone && attackDirectionMultiplier == -1) || (user.getXPos() > startingX && isHalfwayDone && attackDirectionMultiplier == 1)) {
			attackDirectionMultiplier = -attackDirectionMultiplier;
			isHalfwayDone = false;
			return true;
		}
		
		return false;
	}
}
