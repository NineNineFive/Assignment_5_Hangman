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
        drawables.add(new Text("Forkerte: 0/8",x+100,y+50,20,Color.BLACK));
        drawables.add(new Text("Gæt:",x+100,y+100,20,Color.BLACK));

        drawables.add(new Text("A",x+100,y+130,12,Color.BLACK));
        /*
        drawables.add(new Text("B",x+100,y+150,12,Color.BLACK));
        drawables.add(new Text("C",x+100,y+170,12,Color.BLACK));
        drawables.add(new Text("D",x+100,y+190,12,Color.BLACK));
        drawables.add(new Text("E",x+100,y+210,12,Color.BLACK));
        drawables.add(new Text("F",x+100,y+230,12,Color.BLACK));
        drawables.add(new Text("G",x+100,y+250,12,Color.BLACK));
        drawables.add(new Text("H",x+100,y+270,12,Color.BLACK));
        drawables.add(new Text("I",x+100,y+290,12,Color.BLACK));
        drawables.add(new Text("J",x+100,y+310,12,Color.BLACK));
        drawables.add(new Text("K",x+100,y+330,12,Color.BLACK));
        drawables.add(new Text("L",x+100,y+350,12,Color.BLACK));
        drawables.add(new Text("M",x+100,y+370,12,Color.BLACK));
        drawables.add(new Text("N",x+100,y+390,12,Color.BLACK));
        drawables.add(new Text("O",x+100,y+410,12,Color.BLACK));
        drawables.add(new Text("P",x+100,y+430,12,Color.BLACK));
        drawables.add(new Text("Q",x+100,y+450,12,Color.BLACK));
        drawables.add(new Text("R",x+100,y+470,12,Color.BLACK));
        drawables.add(new Text("S",x+100,y+490,12,Color.BLACK));
        drawables.add(new Text("T",x+100,y+510,12,Color.BLACK));
        drawables.add(new Text("U",x+100,y+530,12,Color.BLACK));
        drawables.add(new Text("V",x+100,y+550,12,Color.BLACK));
        drawables.add(new Text("X",x+100,y+570,12,Color.BLACK));
        drawables.add(new Text("Y",x+100,y+590,12,Color.BLACK));
        drawables.add(new Text("Z",x+100,y+610,12,Color.BLACK));
        drawables.add(new Text("Æ",x+100,y+630,12,Color.BLACK));
        drawables.add(new Text("Ø",x+100,y+650,12,Color.BLACK));
        drawables.add(new Text("Å",x+100,y+670,12,Color.BLACK));
        */

    }
}
