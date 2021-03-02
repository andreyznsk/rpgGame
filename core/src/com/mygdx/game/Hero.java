package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
    private Texture texture;
    private Texture hpBar;
    private float x;
    private float y;
    private float speed;
    private float hp,hpMax;
    private boolean die;

    public Hero() {
        this.texture = new Texture("kn.png");
        this.hpBar = new Texture("bar.png");
        x = 200.0f;
        y = 200.0f;
        speed = 100f;
        hpMax = 100f;
        hp = hpMax;
        die = false;


    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);

       if(!die) {
           batch.setColor(0,0,0,1);
           batch.draw(hpBar, x - 20-3, y + 110-3, 106,16);

           batch.setColor(1,0,0,1);
           batch.draw(hpBar, x - 20, y + 110, 0, 0, hp, 10, 1, 1, 0, 0, 0, 80, 20, false, false);
           batch.setColor(1,1,1,1);
       }

    }

    public void takeDamage(float amount){
        hp -= amount;
    }

    public void update(float dt){
        if(hp < 5f){
            texture.dispose();
            texture = new Texture("scull.png");
            die = true;
        }

       if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x+= speed* dt;
      if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x-=speed*dt;
      if(Gdx.input.isKeyPressed(Input.Keys.UP)) y+=speed*dt;
      if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) y-=speed*dt;



    }
}
