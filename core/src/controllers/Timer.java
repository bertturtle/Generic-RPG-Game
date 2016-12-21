package controllers;

import com.badlogic.gdx.Gdx;

public class Timer {
	
	float maxDuration;
	float currentDuration;
	
	public Timer(float duration) {
		this.currentDuration = duration;
		maxDuration = duration;
	}
	
	public void updateTimer() {
//		System.out.println(Gdx.graphics.getDeltaTime());
		currentDuration -= Gdx.graphics.getDeltaTime();
//		System.out.println(currentDuration);
	}
	
	public boolean isTimerFinished() {
		if (currentDuration <= 0) {
			System.out.println(currentDuration);
			this.resetTimer();
			return true;
		}
		else {
			return false;
		}
	}
	
	public void resetTimer() {
		currentDuration = maxDuration;
	}
	
	public float getTime() {
		return currentDuration;
	}
	
	public float getMaxTime() {
		return maxDuration;
	}
	
	public boolean updateTimerAndCheckIfFinished() {
		this.updateTimer();
		
		return isTimerFinished();
	}
}
