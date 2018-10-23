package hangman;

import hangman.drawables.Gallow;
import hangman.drawables.GameGUI;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

/*************
 **************  MADE BY LARS MORTEN BEK | Assignment 5 | Hangman
 *************/

public class Controller {
    Stage stage;
    Group root;
    Scene scene;
    Canvas canvas;
    GraphicsContext gc;
    ArrayList<String> input = new ArrayList<String>();

    ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    GameGUI gameGUI = new GameGUI(50,50, drawables);




    Random random = new Random();

    String[] words = new String[]{"Citron", "Æble", "Pære", "Banan", "Melon", "Appelsin", "Blomme", "Fersken", "Ananas","Kiwi"};

    int n =  random.nextInt(words.length);

    String[] word = words[n].split("");

    boolean[] guessed = new boolean[word.length];

    Gallow gallow;


    int state = 0;

    public Controller(Stage stage, Group root, Scene scene, Canvas canvas) {
        this.stage = stage;
        this.root = root;
        this.scene = scene;

        // Scene
        stage.setScene( scene );

        // Canvas
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        // Finish stage, open window and take inputs
        stage.show();


    }

    public void draw() {
        drawables.clear();
        drawables.add(gameGUI);

        gallow = nygalje();

        drawables.add(gallow);


        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(gc);
            System.out.println(drawables.get(i).getClass());;
        }

    }

    public Gallow nygalje(){
        String s = "";
        for(int i = 0; word.length>i;i++){
            if(guessed[i]) {
                s +=word[i];
            } else {

                s += "*";

            }
        }
        return new Gallow(200, 200, s, state, drawables);
    }

    public void game(KeyEvent keyEvent){

        gallow = nygalje();
        gallow.text.text = "";
        System.out.print("Du gættede på ");
        for(int i = 0; i < word.length; i++) {

            if(word[i].toLowerCase().contains(keyEvent.getText())||guessed[i]) {
                System.out.print(word[i]);
                gallow.text.text += word[i];
                guessed[i] = true;
            } else {
                gallow.text.text += "*";
                System.out.print("*");
                guessed[i] = false;
            }
        }


        System.out.println();



        if(keyEvent.getCode() == KeyCode.A){
            state++;
        }

        draw();


    }
}
    /***
    void input(KeyEvent keyEvent) {
        if (keyEvent.getCharacter().matches("[^\\e\t\r\\d+$]")) {

            if (keyEvent.getCode() == KeyCode.BACK_SPACE) {

            } else {

                keyEvent.consume();
            }
        }
    }

        theScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                System.out.println("A key was pressed");
            }
        });

****/

