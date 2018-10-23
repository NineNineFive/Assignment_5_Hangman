package hangman.drawables.elements;

import hangman.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class Text implements Drawable {

    public String text;
    public int x,y,size;
    public Color color;
    public FontWeight weight;


    public Text (String text, int x, int y, int size, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public Text (String text, int x, int y, int size, Color color, FontWeight weight) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.weight = weight;
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        if(weight!=null) {
            gc.setFont(Font.font("Verdana", weight, size));
        } else {
            gc.setFont(Font.font("Verdana", FontWeight.NORMAL, size));
        }
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(text, x, y);


    }
}