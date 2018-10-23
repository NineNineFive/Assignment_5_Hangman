package hangman;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/*************
**************  MADE BY LARS MORTEN BEK | Assignment 5 | Hangman
*************/

public class Main extends Application {
    public void start(Stage stage){
        // Make javafx group and set title on the app
        stage.setTitle("Hangman Game | Lars Morten Bek | Assignment 5");
        Group root = new Group();

        int width = 1000;
        int height = 800;

        // Construct the controller
        Controller controller = new Controller(
                stage,
                root,
                new Scene(root, width, height),
                new Canvas(width,height)
        );

        // Run methods
        controller.draw();

        // Check for input on KeyPressed
        controller.scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();

                // action
                controller.game(e);

                // print input in console
                System.out.println(code);




                // prevent duplicates
                if ( !controller.input.contains(code) ) {
                    controller.input.add(code);
                }
            }
        });

        // Check for input on KeyReleased
        controller.scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                controller.input.remove( code );
            }
        });

    }
}
