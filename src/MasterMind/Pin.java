package MasterMind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by Woj on 2017-04-29.
 */
public class Pin extends StackPane {
    private Circle pin;
    private int color;
    private Type type;

    public Pin(Type type, int size, Color color,Insets insets) {
        this.pin = new Circle(size);
        this.type=type;
        pin.setFill(color);
        getChildren().add(pin);
        setAlignment(Pos.CENTER);
        setPadding(insets);
    }


    public Circle getPin() {
        return pin;
    }

    public void setPin(Circle pin) {
        this.pin = pin;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSize(int size){
        pin.setRadius(size);

    }
}
