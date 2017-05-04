package MasterMind;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woj on 2017-04-29.
 */


//------------------colors------------------------------
//- 0 #ff1a1a red
//-1 #0080ff blue
//-2 #ffff00 yellow
//-3 #33cc00 green
//-4  #ff8000 orange
//-5 #8c1aff purple
//-6 #ffffff white
//-7 #808080 gray


public class Main extends Application {
    private Color placeOk= Color.web("black");
    private Color colorOk= Color.web("white");
    private Stage window;
    private List<PinsRow> matches = new ArrayList<>();
    private List<PinsRow> pins = new ArrayList<>();
    public static List<ColorButton> buttons;
    private GridPane grid;
    public static final List<Color> colors = new ArrayList<Color>() {{
        add(Color.web("#ff1a1a"));
        add(Color.web("#0080ff"));
        add(Color.web("#ffff00"));
        add(Color.web("#33cc00"));
        add(Color.web("#ff8000"));
        add(Color.web("#8c1aff"));
        add(Color.web("#ffffff"));
        add(Color.web("#808080"));
    }};
    //new Color[]{Color.web("#ff1a1a"), Color.web("#0080ff"), Color.web("#ffff00"), Color.web("#33cc00"), Color.web("#ff8000"), Color.web("#8c1aff"), Color.web("#ffffff"), Color.web("#808080")};
    private List<Integer> code;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        grid = FXMLLoader.load(getClass().getResource("style.fxml"));
        //  grid.setGridLinesVisible(true);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.TOP_CENTER);
        initializeGame();

        window.setTitle("MasterMind");
        Scene scene = new Scene(grid, 255, 500);
        scene.setFill(Color.web("#595959"));
        grid.setId("pane");
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    private void initializeGame() {
        code = initializeCode();
        initializePins(0, 11, 0, 4, Type.PIN, 12, pins, grid, Color.web("Lightgray"), new Insets(3, 0, 3, 0));
        System.out.println(pins.size());
        setRowActive(pins.get(10));
        initializePins(0, 10, 4, 8, Type.MATCH, 7, matches, grid, Color.web("Indigo"), new Insets(2, 2, 2, 2));
        matches.get(0).setType(Type.ACTIVE);
        initializeButtons(11, 13, 0, 4, 40, grid, new Insets(2, 0, 2, 0), 25);
        initializeOKButton();
    }

    private List<Integer> initializeCode() {

        List<Integer> result = new ArrayList<>();

        int maximum = 7;
        int minimum = 0;
        for (int i = 0; i < 4; i++) {
            result.add((minimum + (int) (Math.random() * ((maximum - minimum) + 1))));
            System.out.println("code----------------- " + result.get(i));
        }
        return result;
    }


    private void initializeOKButton() {
        OKButton OK = new OKButton();
        GridPane.setConstraints(OK, 4, 11, 4, 2);
        grid.getChildren().add(OK);

        OK.setOnMousePressed(event -> {
            OK.getFill().setScaleX(0.9);
            OK.getFill().setScaleY(0.9);
            OK.getBord().setScaleX(0.9);
            OK.getBord().setScaleY(0.9);
            OK.getText().setScaleX(0.9);
            OK.getText().setScaleY(0.9);
        });
        OK.setOnMouseReleased(event -> {
            OK.getFill().setScaleX(1);
            OK.getFill().setScaleY(1);
            OK.getBord().setScaleX(1);
            OK.getBord().setScaleY(1);
            OK.getText().setScaleX(1);
            OK.getText().setScaleY(1);
            if (isReady()) {
                moveMatches();
                check();
                movePins();
            }
        });
    }

    private boolean isReady() {
        boolean ready = true;
        for (PinsRow row :
                pins) {
            if (row.getType() == Type.ACTIVE) {
                for (Pin pin :
                        row.getPins()) {
                    if (pin.getType() != Type.READY) {
                        ready = false;
                    }
                }
            }
        }
        return ready;
    }

    private void check() {

        ArrayList<Integer> possibleColors = new ArrayList<Integer>(4);
        int[] tmpMatches = new int[]{-1,-1,-1,-1};
        List<Pin> activePins = null;
        for (PinsRow row :
                pins) {
            if (row.getType() == Type.ACTIVE)
                activePins = row.getPins();
        }
        int correct = 0;
        int color = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(activePins.get(i).getColor() + "a");
            System.out.println(code.get(i) + "c");
//            System.out.println((activePins.get(i).getColor().equals(code.get(i))));
            if (activePins.get(i).getColor() == (code.get(i))) {
                tmpMatches[i] = activePins.get(i).getColor();
                correct++;
                continue;
            } else {
                possibleColors.add(activePins.get(i).getColor());
            }
        }
        System.out.println("  possiblecolors size " + possibleColors.size() + " correct:   " + correct);
        for (int i = 0; i < 4; i++) {
//            System.out.println("null " + (null == tmpMatches[i]));
//            System.out.println("coint " + possibleColors.contains(code.get(i)));
            if (-1 == tmpMatches[i] && possibleColors.contains(code.get(i))) { //lub odwrotnie
                possibleColors.remove(code.get(i));
                color++;
            }
        }
        PinsRow tmpRow=null;
        for (PinsRow row :
                matches) {
            if (row.getType().equals(Type.ACTIVE)) tmpRow=row;
        }
        for (int i = 0; i < correct; i++) {
            tmpRow.getPin(i).getPin().setFill(placeOk);
        }
        for (int i = correct; i < correct + color; i++) {
            tmpRow.getPin(i).getPin().setFill(colorOk);
        }

        if (correct == 4) {
            movePins();  // uzaleznic move pins od trials
            System.out.println("wygrana");
            // resetPins();
            //gameWon();
        }

    }

    private void moveMatches() {
        if (matches.size() > 0) {
            matches.forEach(row -> {
                if (row.getRow() == 0) {
                    row.setRow(9);
                    row.setType(Type.ACTIVE);
                } else {
                    row.setRow((row.getRow() - 1));
                    row.setType(Type.MATCH);
                }
            });
            matches.forEach(row -> {
                row.setAtRow(4, 8);
            });
        }
    }


    private void movePins() {
        if (pins.size() > 0) {
            pins.forEach(row -> {
                if (row.getRow() == 0) {
                    row.setRow(10);
                    setRowActive(row);
                } else {
                    row.setRow((row.getRow() - 1));
                    setRowInactive(row);
                }
            });
            pins.forEach(row -> {
                row.setAtRow(0, 4);
            });
        }
    }

    private void setRowActive(PinsRow row) {
        row.setType(Type.ACTIVE);
        row.getPins().forEach(pin -> {
            pin.setType(Type.ACTIVE);
            pin.getPin().setFill(Color.web("Cyan"));
            pin.setPadding(new Insets(5, 2, 5, 2));
            pin.setSize(20);
        });

    }

    private void setRowInactive(PinsRow row) {
        row.setType(Type.INACTIVE);
        row.getPins().forEach(pin -> {
            pin.setType(Type.INACTIVE);
            pin.setPadding(new Insets(3, 0, 3, 0));
            pin.setSize(12);
        });

    }


    private void initializePins(int rowFrom, int rowTo, int columnFrom, int columnTo, Type type, int size, List<PinsRow> list, GridPane grid, Color color, Insets insets) {

        for (int i = rowFrom; i < rowTo; i++) {
            PinsRow tmpRow = new PinsRow(i);
            for (int j = columnFrom; j < columnTo; j++) {
                Pin tmpPin = new Pin(type, size, color, insets);
                addActivePinListener(tmpPin);
                tmpRow.addPin(tmpPin);
                tmpRow.setRow(i);
                GridPane.setConstraints(tmpPin, j, i);
                grid.getChildren().add(tmpPin);
            }
            list.add(tmpRow);
        }
    }

    private void initializeButtons(int rowFrom, int rowTo, int columnFrom, int columnTo, int size, GridPane grid, Insets insets, double arc) {
        buttons = new ArrayList<>();
        int color = 0;
        for (int i = rowFrom; i < rowTo; i++) {
            for (int j = columnFrom; j < columnTo; j++) {
                ColorButton button = new ColorButton(size, color, insets, arc);
                GridPane.setConstraints(button, j, i);
                grid.getChildren().add(button);
                buttons.add(button);
                addButtonListener(button);
                color++;
            }
        }

    }

    private void addButtonListener(ColorButton button) {

        button.setOnMousePressed(e -> {
            buttons.forEach(but -> but.setType(Type.INACTIVE));
            button.setType(Type.ACTIVE);
            checkElements();
        });
    }

    private void addActivePinListener(Pin pin) {
        pin.setOnMousePressed(e -> {
            buttons.forEach(button -> {
                if (button.getType() == Type.ACTIVE && (pin.getType() == Type.ACTIVE || pin.getType() == Type.READY)) {
                    pin.setColor(button.getColor());
                    pin.getPin().setFill(colors.get(button.getColor()));
                    pin.setType(Type.READY);
                }
            });
            checkElements();
        });

    }

    private void checkElements() {
        buttons.forEach(button -> {
            if (button.getType() == Type.ACTIVE) {
                button.setScaleX(0.8);
                button.setScaleY(0.8);
            }
            if (button.getType() == Type.INACTIVE) {
                button.setScaleX(1);
                button.setScaleY(1);
            }
        });
        pins.forEach(pinsRow -> {
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
