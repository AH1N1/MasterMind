package MasterMind;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Created by Woj on 2017-04-30.
 */
public class ColorButton extends StackPane{
    private Rectangle button;
    private int color;
    private Type type;

    public ColorButton(int size, int color, Insets insets,double arc) {
        this.color=color;
        this.button = new Rectangle();
        type=Type.INACTIVE;
        button.setFill(Main.colors.get(color));
        button.setWidth(size);
        button.setHeight(size);
        button.setArcWidth(arc);
        button.setArcHeight(arc);
        getChildren().addAll(button);
        setAlignment(Pos.CENTER);
        setPadding(insets);

    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ColorButton() {
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Rectangle getButton() {
        return button;
    }

    public void setButton(Rectangle button) {
        this.button = button;
    }

    public void setSize(int size){
        button.setWidth(size);
        button.setHeight(size);

    }
}
