package MasterMind;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Woj on 2017-04-29.
 */
public class PinsRow  {
    private List<Pin> pins;
    private int row;

    public PinsRow(List<Pin> pins, int row) {
        this.pins = pins;
        this.row = row;
    }

    public PinsRow() {
        pins=new ArrayList<>();
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

    public void addPin(Pin pin){
        pins.add(pin);
    }

    public Pin getPin(int index){
        return pins.get(index);
    }

    public void setAtRow(int from, int to){
                    for (int i = from; i < to; i++) {
                GridPane.setConstraints(pins.get(i),i,row);
            }




    }
}
