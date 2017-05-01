package MasterMind;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Woj on 2017-04-29.
 */
public class Pin extends StackPane {
    private Rectangle pin;
    private int color;
    private Type type;

    public Pin(Rectangle pin, int color, Type type) {
        this.pin = pin;
        this.color = color;
        this.type = type;
    }

    public Pin() {
        this.pin = new Rectangle();
    }

    public Pin(Rectangle pin) {
        this.pin = pin;
    }

}
