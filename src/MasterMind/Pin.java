package MasterMind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Woj on 2017-04-29.
 */
public class Pin extends StackPane {
    private Rectangle pin;
    private int color;
    private Type type;

    public Pin(Type type, int size, Color color,Insets insets) {
        this.pin = new Rectangle();
        this.type=type;
        pin.setWidth(size);
        pin.setHeight(size);
        pin.setFill(color);
        getChildren().add(pin);
        setAlignment(Pos.BASELINE_CENTER);
        setPadding(insets);
    }


    public Rectangle getPin() {
        return pin;
    }

    public void setPin(Rectangle pin) {
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
}
