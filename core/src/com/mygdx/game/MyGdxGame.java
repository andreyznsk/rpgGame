package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Hero hero;
	private Monster monster;

	public Hero getHero() {
		return hero;
	}

	public Monster getMonster() {
		return monster;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		hero = new Hero();
		monster = new Monster(this);

	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(0, 0.5f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		hero.render(batch);
		monster.render(batch);
		batch.end();
	}

	public void update(float dt){
		hero.update(dt);
		monster.update(dt);
		float dst = (float) Math.sqrt(Math.pow((monster.getX()-hero.getX()),2) + Math.pow((monster.getY()-hero.getY()),2));
		if(dst <= 40 ) hero.takeDamage(dt*20f);


	}

	@Override
	public void dispose(){
		batch.dispose();

	}
}
