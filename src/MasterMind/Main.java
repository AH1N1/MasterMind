package MasterMind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woj on 2017-04-29.
 */
public class Main extends Application {
    Stage window;
    private List<PinsRow> activePins;
    private List<PinsRow> matches;
    private List<PinsRow> pins;
    private GridPane grid;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        grid = FXMLLoader.load(getClass().getResource("style.fxml"));
        //grid.setGridLinesVisible(true);
        grid.setHgap(0);
        grid.setVgap(0);
        initializeGame();
        window.setTitle("MasterMind");
        window.setScene(new Scene(grid, 300, 275));
        window.show();
    }

    private void initializeGame() {
        initializePins(0, 10, 0, 4, Type.PIN, 25, pins, grid, Color.web("Lightgray"),new Insets(3,0,3,0));
        initializePins(0, 10, 4, 8, Type.MATCH, 25, matches, grid, Color.web("Indigo"),new Insets(2,2,2,2));
        initializePins(10, 11, 0, 4, Type.ACTIVE, 40, activePins, grid, Color.web("Cyan"),new Insets(0,2,0,2));

    }

    private void initializePins(int rowFrom, int rowTo, int columnFrom, int columnTo, Type type, int size, List<PinsRow> list, GridPane grid, Color color, Insets insets) {
        list = new ArrayList<>();
        for (int i = rowFrom; i < rowTo; i++) {
            PinsRow tmpRow = new PinsRow(i);
            for (int j = columnFrom; j < columnTo; j++) {
                Pin tmpPin = new Pin(type,size,color,insets);
                tmpRow.addPin(tmpPin);
                GridPane.setConstraints(tmpPin, j, i);
                grid.getChildren().add(tmpPin);
            }
            list.add(tmpRow);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
