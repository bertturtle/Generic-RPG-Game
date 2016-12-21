package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import abilities.SimpleAbility;
import characters.CollidingAICharacter;
import characters.CollidingObstacleCharacter;
import characters.CollidingPlayerCharacter;
import controllers.KeyboardInputDetector;
import stages.EnemyStage;
import stages.SimpleStage;

public class MyGdxGame extends ApplicationAdapter {
	static Texture img;
	float playerX;
	float playerY;
	int playerSpeed;
	static List<CollidingAICharacter> enemies;
	static List<CollidingObstacleCharacter> obstacles;
	static CollidingPlayerCharacter player;
	CollidingAICharacter enemy;
	static SpriteBatch batch;
	static SimpleStage testStage;
	public static KeyboardInputDetector input;
	public static Random rand;
	public static int screenHeight;
	public static int screenWidth;

	@Override
	public void create() {
		input = new KeyboardInputDetector();
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();
		
		startGame();
	}
	
	public static void startGame() {
		enemies = new ArrayList<CollidingAICharacter>();
		obstacles = new ArrayList<CollidingObstacleCharacter>();
		batch = new SpriteBatch();
		
		SimpleAbility[] abilities = new SimpleAbility[2];
		abilities[0] = new SimpleAbility(200, 30, 2, 2);
		abilities[1] = new SimpleAbility(100, 50, 5, 3);
		
		rand = new Random();
		
		img = new Texture("player.png");
		
		player = new CollidingPlayerCharacter(img, 0, 0, 70, abilities, 10);
		
		SimpleAbility[] enemyAbilities = new SimpleAbility[2];
		enemyAbilities[0] = new SimpleAbility(200, 30, 2, 2);
		enemyAbilities[1] = new SimpleAbility(100, 50, 5, 4);
		
		img = new Texture("enemy.png");
		//TODO add abilities
		enemies.add(new CollidingAICharacter(img, 350, 150, 40, 3, enemyAbilities, 12));
		
		img = new Texture("obstacle.png");
		obstacles.add(new CollidingObstacleCharacter(img, 250, 100));
		
		testStage = new EnemyStage(player, enemies, obstacles, batch);
	}

	@Override
	public void render() {
		testStage.updateStage();
	}
	
	@Override
	public void dispose() {
		img.dispose();
		testStage.dispose();
	}
}
