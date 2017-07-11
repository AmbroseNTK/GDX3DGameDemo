package kiet.nguyentuan.libgdx.Game2D;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public abstract class BaseScreen implements Screen,InputProcessor {
    protected Game game;
    protected Stage mainStage;
    protected Stage uiStage;

    public int viewWidth=640;
    public int viewHeight=480;
    private boolean paused;

    public BaseScreen(Game game){
        this.game=game;
        mainStage=new Stage(new FitViewport(viewWidth,viewHeight));
        uiStage=new Stage(new FitViewport(viewWidth,viewHeight));
        setPaused(false);
        InputMultiplexer inputMultiplexer=new InputMultiplexer(this,uiStage,mainStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        create();
    }

    /**
     * Implement create() method on your class to init everything you want to use.
     */
    public abstract void create();

    /**
     * Update what you want to change.
     * @param dT from Gdx.graphics.getDeltaTime()
     */
    public abstract void update(float dT);

    @Override
    public void show() {

    }

    public void render(float dT){
        uiStage.act(dT);
        if(!isPaused()){
            mainStage.act(dT);
            update(dT);
        }

        //Render
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        uiStage.draw();
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Change pause state from on to off, or from off to on.
     */
    public void togglePaused() {
        paused = !paused;
    }

    /**
     * Resize your game screen, so that it is suitable for every device's screen.
     * @param width The width of screen
     * @param height The height of screen
     */
    public void resize(int width,int height) {
        mainStage.getViewport().update(width, height, true);
        uiStage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
