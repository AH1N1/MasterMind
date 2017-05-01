package MasterMind;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * Created by Woj on 2017-04-30.
 */
public class ColorButton extends StackPane{
    private Button button;

    public ColorButton(Button button) {
        this.button = button;
    }

    public ColorButton() {
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
