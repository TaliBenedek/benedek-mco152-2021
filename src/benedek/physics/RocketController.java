package benedek.physics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RocketController {
    @FXML
    TextField velocityField;
    @FXML
    TextField angleField;
    @FXML
    TextField secondsField;
    @FXML
    Label xLabel;
    @FXML
    Label yLabel;
    @FXML
    Label flightTimeLabel;

    public void calculateRocket(ActionEvent actionEvent) throws IOException{
        double velocity = Double.parseDouble(velocityField.getText());
        double angle = Double.parseDouble(angleField.getText());
        double seconds = Double.parseDouble(secondsField.getText());

        Rocket rocket = new Rocket(velocity, angle);
        xLabel.setText(String.format("X value: %.2f", rocket.getX(seconds)));
        yLabel.setText(String.format("Y value: %.2f", rocket.getY(seconds)));
        flightTimeLabel.setText(String.format("Total flight time: %.2f", rocket.getFlightTime()));
    }
}
