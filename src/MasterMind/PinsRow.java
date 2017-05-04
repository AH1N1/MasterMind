package MasterMind;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woj on 2017-04-29.
 */
public class PinsRow {
    private List<Pin> pins;
    private int row;
    private Type type;

    public PinsRow(List<Pin> pins, int row) {
        this.pins = pins;
        this.row = row;
    }

    public PinsRow() {
        pins = new ArrayList<>();
    }

    public PinsRow(int row) {
        this.row = row;
        pins = new ArrayList<>();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Pin> getPins() {
        return pins;
    }

    public void setPins(List<Pin> pins) {
        this.pins = pins;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void addPin(Pin pin) {
        pins.add(pin);
    }

    public Pin getPin(int index) {
        return pins.get(index);
    }

    public void setAtRow(int from, int to) {
        int index = 0;
        for (int i = from; i < to; i++) {
            GridPane.setConstraints(pins.get(index), i, row);
            index++;
        }
    }

    public void setTypeAndPins(Type type) {
        this.type = type;
        pins.forEach(pin -> pin.setType(type));
    }
}
