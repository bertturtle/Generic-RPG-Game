package controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class KeyboardInputDetector implements InputProcessor{
	
	public boolean wPressed;
	public boolean aPressed;
	public boolean sPressed;
	public boolean dPressed;
	public boolean onePressed;
	public boolean twoPressed;
	public boolean threePressed;
	
	public KeyboardInputDetector() {
		// TODO Auto-generated constructor stub
		Gdx.input.setInputProcessor(this);
		wPressed = false;
		aPressed = false;
		sPressed = false;
		dPressed = false;
		onePressed = false;
		twoPressed = false;
		threePressed = false;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.A) {
			System.out.println("A is pressed");
			aPressed = true;
		}
		if (keycode == Keys.D) {
			System.out.println("D is pressed");
			dPressed = true;
		}
		if (keycode == Keys.W) {
			System.out.println("W is pressed");
			wPressed = true;
		}
		if (keycode == Keys.S) {
			System.out.println("S is pressed");
			sPressed = true;
		}
		if (keycode == Keys.NUM_1) {
			System.out.println("1 is pressed");
			onePressed = true;
		}
		if (keycode == Keys.NUM_2) {
			System.out.println("2 is pressed");
			twoPressed = true;
		}
		if (keycode == Keys.NUM_3) {
			System.out.println("3 is pressed");
			threePressed = true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.A) {
			System.out.println("A is done");
			aPressed = false;
		}
		if (keycode == Keys.D) {
			System.out.println("D is done");
			dPressed = false;
		}
		if (keycode == Keys.W) {
			System.out.println("W is done");
			wPressed = false;
		}
		if (keycode == Keys.S) {
			System.out.println("S is done");
			sPressed = false;
		}
		if (keycode == Keys.NUM_1) {
			System.out.println("1 is done");
			onePressed = false;
		}
		if (keycode == Keys.NUM_2) {
			System.out.println("2 is done");
			twoPressed = false;
		}
		if (keycode == Keys.NUM_3) {
			System.out.println("3 is done");
			threePressed = false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
