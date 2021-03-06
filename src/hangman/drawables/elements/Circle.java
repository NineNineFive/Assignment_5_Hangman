package hangman.drawables.elements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import hangman.Drawable;

public class Circle implements Drawable {

    int x, y, radius, borderSize;
    Color bgColor, borderColor;


    public Circle(int x, int y, int radius, Color bgColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bgColor = bgColor;
    }

    public Circle (int x, int y, int radius, Color bgColor, Color borderColor, int borderSize) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.bgColor = bgColor;
        this.borderSize = borderSize;
    }

    @Override
    public void draw(GraphicsContext gc) {
        // draw oval/circle
        if(this.bgColor != null){
            gc.setFill(bgColor);
            gc.fillOval(x, y, radius, radius);
        }

        if(this.borderSize != 0){
            gc.setLineWidth(borderSize);
            gc.strokeOval(x,y,radius,radius);
            gc.setStroke(borderColor);
        }

    }
}
