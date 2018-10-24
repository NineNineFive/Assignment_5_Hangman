package hangman;

import hangman.drawables.Gallow;
import hangman.drawables.GameGUI;
import hangman.drawables.elements.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

/*************
 **************  MADE BY LARS MORTEN BEK | Assignment 5 | Hangman
 *  This script is all written by me, i'm an experienced programmer ;-)
 *  Look forward to my miniproject
 *************/

public class Controller {
    // Scene and Graphics
    private Stage stage;
    private Group root;
    public Scene scene;
    private Canvas canvas;
    private GraphicsContext gc;
    public ArrayList<String> input = new ArrayList<String>();
    private ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    // Game
    private String[] words = new String[]{"Citron", "Æble", "Pære", "Banan", "Melon", "Appelsin", "Blomme", "Fersken", "Ananas","Kiwi"};
    private Random random = new Random();
    private int n =  random.nextInt(words.length);
    private ArrayList<String> word = new ArrayList<String>(); // the reason why word is an arraylist, is because we want to use the contain method
    private boolean[] guessed;
    private Gallow gallow;
    private int state = 0;

    // GameGUI
    private GameGUI gameGUI = new GameGUI(50,50, drawables);

    // Controller Constructor
    public Controller(Stage stage, Group root, Scene scene, Canvas canvas) {
        // Stage & Group(root)
        this.stage = stage;
        this.root = root;

        // Scene
        this.scene = scene;
        stage.setScene(scene);

        // Canvas
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        // Finish stage, open window and take inputs
        stage.show();
    }

    public void gameSetup(){
        String[] l = words[n].split("");
        for(int i = 0; i<l.length;i++) {
            word.add(l[i].toLowerCase());
        }
        guessed = new boolean[word.size()];
    }

    public void draw() {
        // Graphics
        drawables.clear(); // Reset
        drawables.add(gameGUI); // Add GameGUI

        // Gallow
        gallow = new Gallow(200, 200, state, drawables, guessed, word);
        drawables.add(gallow); // Add gallow to graphics

        for (int i = 0; i < drawables.size(); i++) {
            drawables.get(i).draw(gc); // Draw all the graphics
        }
    }

    // Game is updated when input is sent from the keyboard
    public void updateGame(KeyEvent keyEvent){

        if(!gameGUI.gameEnded&&keyEvent.getText().matches("^(?:([a-ø])(?!.*\\1))+$")){
            guess(keyEvent.getText()); // make a guess
        }

        if(!gallow.word.text.contains("*")) {
            drawables.add(new Text("You Won", 400, 300, 30, Color.BLACK, FontWeight.BOLD));
            gameGUI.won = true;
            gameGUI.gameEnded = true;
        }

        draw(); // clear and draw the scene again
    }

    public void guess(String letter) {
        if (!word.contains(letter)&&!gameGUI.guessedLetters.contains(letter)) {
            gameGUI.guessedLetters.add(letter);
            gameGUI.incorrect++;
            state++;
        }

        // reset word, then create new word from letters in for-loop
        gallow.word.text = "";
        for(int i = 0; i < word.size(); i++) {
            if(word.get(i).contains(letter)||guessed[i]) {
                gallow.word.text += word.get(i);
                guessed[i] = true;
            } else {
                gallow.word.text += "*";
                guessed[i] = false;
            }
        }

    }
}

