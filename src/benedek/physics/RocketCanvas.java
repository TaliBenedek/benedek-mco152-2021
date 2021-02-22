package benedek.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RocketCanvas extends Canvas {
    /**
     * Draws the path of the Rocket starting from time=0 to the Rocket's flight time with 1 second intervals
     * @param rocket
     */
    public void draw(Rocket rocket)
    {
        GraphicsContext context = getGraphicsContext2D();
        context.setFill(Color.VIOLET);
        context.fillRect(0,0, getWidth(),getHeight());

        context.translate(0,getHeight());

        context.setFill(Color.BLUE);
        context.setLineWidth(1);
        context.beginPath();
        context.moveTo(0,0);
        for(double seconds = 0; seconds <= rocket.getFlightTime(); seconds += 0.5)
        {
            double x = rocket.getX(seconds);
            double y = rocket.getY(seconds);
            context.fillOval(x, -y, 3, 3);
            context.lineTo(x, -y);
        }
        context.lineTo(rocket.getX(rocket.getFlightTime()),rocket.getY(rocket.getFlightTime()));
        context.stroke();
        context.closePath();
        context.translate(0, -getHeight());
    }
}
