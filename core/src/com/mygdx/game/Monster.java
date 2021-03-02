package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Monster {
    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private MyGdxGame game;
    private float activityRadius;

    public Monster(MyGdxGame game) {
        activityRadius = 200;
        this.game = game;
        this.texture = new Texture("Sceleton.png");
        x = 50.0f;
        y = 50.0f;
        speed = 50f;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }

    public void update(float dt){

        float dst = (float) Math.sqrt(Math.pow((game.getHero().getX()-this.x),2) + Math.pow((game.getHero().getY()-this.y),2));
        if(dst < activityRadius){
            if(x<game.getHero().getX()) x+=speed*dt;
            if(x>game.getHero().getX()) x-=speed*dt;
            if(y<game.getHero().getY()) y+=speed*dt;
            if(y>game.getHero().getY()) y-=speed*dt;

        } else {
            x+=speed*dt;
            if (x>1280.0f) x = 0.0f;
        }




    }
}
