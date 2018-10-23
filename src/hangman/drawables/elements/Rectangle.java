package hangman.drawables.elements;

import hangman.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle implements Drawable {

    public int x,y,width,height;
    public int borderSize = 0;
    public Color borderColor;
    public Color bgColor;


    public Rectangle (int x, int y, int width, int height, Color bgColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
    }

    public Rectangle (int x, int y, int width, int height, Color bgColor, Color borderColor, int borderSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.bgColor = bgColor;
        this.borderSize = borderSize;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if(bgColor!=null) {
            gc.setFill(bgColor);
        }

        gc.fillRect(x, y, width, height);

        if (borderSize!=0){
            gc.setLineWidth(borderSize);
            gc.strokeRect(x,y,width,height);
            gc.setStroke(borderColor);
        }

    }
}