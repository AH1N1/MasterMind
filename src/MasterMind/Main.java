package MasterMind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woj on 2017-04-29.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = FXMLLoader.load(getClass().getResource("style.fxml"));
        initializeGame();
    }

    private void initializeGame() {
        initializePins()

    }

    private void initializePins(int amount, int rowFrom, int rowTo, int columnFrom, int columnTo, Type type) {
        for (int i = 0; i < 10; i++) {
            List<Pin> tmp = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Pin tmpPin = new Pin();
                tmpPin.setColorsAndBorder(tmpPin.getColor(), 1, "black");
                //tmpPin.getLabel().setStyle("-fx-background-color:" + tmpPin.getColor() + "; -fx-border: 4px solid; -fx-border-color: black;");
                tmpPin.getLabel().setMinSize(30, 30);
                tmpPin.getLabel().setMaxSize(30, 30);
                tmp.add(tmpPin);
                GridPane.setConstraints(tmpPin.getLabel(), j, i);
                grid.getChildren().add(tmpPin.getLabel());
            }
        pins.add(tmp);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
