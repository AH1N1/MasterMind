package MasterMind;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * Created by wojciech.misiak on 5/4/2017.
 */
public class OKButton extends StackPane{
    private  Rectangle border;
    private Rectangle fill;
    private Text text;
    public OKButton() {
        border = new Rectangle(50,50);
        border.setFill(Color.web("#e60000"));
        border.setArcHeight(25);
        border.setArcWidth(25);
        fill = new Rectangle(40,40);
        fill.setFill(Color.web("#cc0000"));
        fill.setArcWidth(20);
        fill.setArcHeight(20);
        text = new Text("OK");
        text.setFont(new Font(25));
        setAlignment(Pos.CENTER);
        getChildren().addAll(border,fill,text);

    }


    public Rectangle getBord() {
        return border;
    }

    public void setBord(Rectangle border) {
        this.border = border;
    }

    public Rectangle getFill() {
        return fill;
    }

    public void setFill(Rectangle fill) {
        this.fill = fill;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
