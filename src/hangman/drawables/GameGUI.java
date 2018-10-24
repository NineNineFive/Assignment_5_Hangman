package hangman.drawables;

import hangman.Drawable;
import hangman.drawables.elements.Rectangle;
import hangman.drawables.elements.Text;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class GameGUI implements Drawable {
    public int x,y;
    public ArrayList<Drawable> drawables;
    public ArrayList<String> guessedLetters = new ArrayList<String>();
    public int incorrect = 0;
    public boolean gameEnded = false;
    public boolean won = false;

    public GameGUI (int x, int y, ArrayList<Drawable> drawables){
        this.drawables = drawables;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext gc){
        int canvasWidth = (int)gc.getCanvas().getWidth();
        int canvasHeight = (int)gc.getCanvas().getHeight();

        drawables.add(new Rectangle(x,y,canvasWidth-(x*2),canvasHeight-(x*2),Color.WHITE,Color.BLACK,2));
        drawables.add(new Text("Hangman spil",canvasWidth/2,y+50,28,Color.BLACK, FontWeight.BOLD));
        drawables.add(new Text("Lavet af Lars Bek",canvasWidth/2,y+75,20,Color.BLACK));
        drawables.add(new Text("Forkerte: "+incorrect+"/8",x+100,y+50,20,Color.BLACK));

        if(guessedLetters.size()>0) {
            drawables.add(new Text("Gæt:", x + 100, y + 100, 20, Color.BLACK));
        }

        for(int i=0; i<guessedLetters.size();i++){
            drawables.add(new Text(guessedLetters.get(i),x+100,y+130+i*20,14,Color.BLACK, FontWeight.BOLD));
        }

        if(incorrect>=8){
            System.out.println("gameEnded");
            drawables.add(new Text("Du døde!", 450, 450, 50, Color.RED, FontWeight.BOLD));
            gameEnded = true;
        } else if(won){
            drawables.add(new Text("Du overlevede!", 450, 450, 50, Color.GREEN, FontWeight.BOLD));
        }
    }
}
