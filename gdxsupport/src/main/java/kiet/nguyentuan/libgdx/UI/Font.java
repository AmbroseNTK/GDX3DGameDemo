package kiet.nguyentuan.libgdx.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {
    private BitmapFont bitmapFont;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    /**
     * Create a new font with basic properties such as name, size, color.
     * @param fontName directory of font file (.ttf)
     * @param size size of font
     * @param color color of font
     */
    public Font(String fontName,int size,Color color){
        parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=size;
        parameter.color=color;
        init(fontName,parameter);
    }

    /**
     * Create a new font with all properties.
     * @param fontName directory of font file (.ttf)
     * @param parameter font's parameter
     */
    public Font(String fontName, FreeTypeFontGenerator.FreeTypeFontParameter parameter){
      init(fontName,parameter);
    }
    private void init(String fontName, FreeTypeFontGenerator.FreeTypeFontParameter parameter){
        setParameter(parameter);
        generator=new FreeTypeFontGenerator(Gdx.files.internal(fontName));
        bitmapFont=generator.generateFont(parameter);
    }

    /**
     * Generate a new bitmap font with current parameter
     * @return bitmap font
     */
    public BitmapFont getBitmapFont(){
        bitmapFont=generator.generateFont(parameter);
        return bitmapFont;
    }

    /**
     * Change current font's parameter
     * @param parameter new font's parameter
     */
    public void setParameter(FreeTypeFontGenerator.FreeTypeFontParameter parameter){
        this.parameter=parameter;
    }
}
