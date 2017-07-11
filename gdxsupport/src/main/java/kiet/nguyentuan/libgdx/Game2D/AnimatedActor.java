package kiet.nguyentuan.libgdx.Game2D;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;


public class AnimatedActor extends BaseActor {
    public float elapseTime;
    public Animation animation;
    public AnimatedActor(){
        super();
        elapseTime=0;
    }
    public void setAnimation(Animation animation){
        Texture t=(Texture)(animation.getKeyFrame(0));
        setTexture(t);
        this.animation=animation;
    }
    public void act(float dT){
        super.act(dT);
        elapseTime+=dT;
        if(velocityX!=0||velocityY!=0)
            setRotation(MathUtils.atan2(velocityX,velocityY)*MathUtils.radiansToDegrees);
    }
    public void draw(Batch batch, float parentAlpha){
        region.setRegion((Texture)(animation.getKeyFrame(elapseTime)));
        super.draw(batch,parentAlpha);
    }
}
