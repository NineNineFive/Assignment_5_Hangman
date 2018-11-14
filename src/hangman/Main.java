package hangman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
        controller.gameSetup();
        controller.draw();

        // Check for input on KeyPressed
        controller.scene.setOnKeyPressed(e -> {
                String code = e.getCode().toString();

                // Make an action in the game
                controller.updateGame(e);

                // prevent duplicates
                if ( !controller.input.contains(code) ) {
                    controller.input.add(code);
                }
        });

        // Check for input on KeyReleased
        controller.scene.setOnKeyReleased(e -> {
                String code = e.getCode().toString();
                controller.input.remove( code );
        });

    }
}
