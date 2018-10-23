package hangman.drawables;

import hangman.Drawable;
import hangman.drawables.elements.Circle;
import hangman.drawables.elements.Line;
import hangman.drawables.elements.Text;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class Gallow implements Drawable {
    public int x,y, state;
    public Text text = new Text("", 400, 400, 30, Color.BLACK, FontWeight.NORMAL);
    public ArrayList<Drawable> drawables;

    public Gallow (int x, int y, String word ,int state, ArrayList<Drawable> drawables){
        this.drawables = drawables;
        this.x = x;
        this.y = y;


        this.text.text = word;
        this.state = state;
    }

    @Override
    public void draw(GraphicsContext gc){
        int canvasWidth = (int)gc.getCanvas().getWidth();
        int canvasHeight = (int)gc.getCanvas().getHeight();




        System.out.println("las er femf");
        drawables.add(text);

        if(state>=1) {
            // 1 (wood)
            drawables.add(new Line(canvasWidth - x - 200, canvasHeight - y + 50, canvasWidth - x - 200, canvasHeight - y - 200));
        }

        if(state>=2) {
            // 2 (wood)
            drawables.add(new Line(canvasWidth - x - 200, canvasHeight - y - 200, canvasWidth - x - 50, canvasHeight - y - 200));
        }

        if(state>=3) {
            // 3 (ropes)
            drawables.add(new Line(canvasWidth - x - 200, canvasHeight - y - 150, canvasWidth - x - 150, canvasHeight - y - 200));
            drawables.add(new Line(canvasWidth - x - 50, canvasHeight - y - 200, canvasWidth - x - 50, canvasHeight - y - 150));
        }

        if(state>=4) {
            // 4 (head)
            drawables.add(new Circle(canvasWidth - x - 75, canvasHeight - y - 150, 50, Color.WHITE, Color.BLACK, 3));
        }

        if(state>=5) {
            // 5 (body)
            drawables.add(new Line(canvasWidth - x - 50, canvasHeight - y - 100, canvasWidth - x - 50, canvasHeight - y - 90));
            drawables.add(new Circle(canvasWidth - x - 90, canvasHeight - y - 90, 80, Color.WHITE, Color.BLACK, 3));
        }

        if(state>=6) {
            // 6 (arms)
            drawables.add(new Line(canvasWidth - x - 19, canvasHeight - y - 75, canvasWidth - x + 16, canvasHeight - y - 40));
            drawables.add(new Line(canvasWidth - x - 81, canvasHeight - y - 75, canvasWidth - x - 116, canvasHeight - y - 40));
        }

        if(state>=7) {
            // 7 (legs)
            drawables.add(new Line(canvasWidth - x - 66, canvasHeight - y - 12, canvasWidth - x - 64, canvasHeight - y + 50));
            drawables.add(new Line(canvasWidth - x - 34, canvasHeight - y - 12, canvasWidth - x - 36, canvasHeight - y + 50));
        }

        if(state>=8) {
            // 8 (eyes and mouth)
            drawables.add(new Circle(canvasWidth - x - 46, canvasHeight - y - 136, 8, Color.WHITE, Color.BLACK, 3));
            drawables.add(new Circle(canvasWidth - x - 62, canvasHeight - y - 136, 8, Color.WHITE, Color.BLACK, 3));
            drawables.add(new Line(canvasWidth - x - 45, canvasHeight - y - 110, canvasWidth - x - 60, canvasHeight - y - 110));
        }
    }

}
