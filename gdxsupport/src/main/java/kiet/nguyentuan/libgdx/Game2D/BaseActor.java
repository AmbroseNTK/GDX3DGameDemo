package kiet.nguyentuan.libgdx.Game2D;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.compression.lzma.Base;

import kiet.nguyentuan.libgdx.UI.Font;

public class BaseActor extends Actor {
    public TextureRegion region;
    public Rectangle boundary;
    public float velocityX;
    public float velocityY;

    public BaseActor() {
        super();
        region = new TextureRegion();
        boundary = new Rectangle();
        velocityX = 0;
        velocityY = 0;
    }

    public void setTexture(Texture texture){
        int w=texture.getWidth();
        int h=texture.getHeight();
        setWidth(w);
        setHeight(h);
        region.setRegion(texture);
    }

    public Rectangle getBounding(){
        boundary.set(getX(),getY(),getWidth(),getHeight());
        return boundary;
    }

    public void act(float dT){
        super.act(dT);
        moveBy(velocityX*dT,velocityY*dT);
    }

    public void draw(Batch batch, float parentAlpha){
        Color c =getColor();
        batch.setColor(c.r,c.g,c.b,c.a);
        if(isVisible())
            batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
