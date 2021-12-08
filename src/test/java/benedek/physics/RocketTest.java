package benedek.physics;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RocketTest {
    @Test
    public void getX()
    {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double x = rocket.getX(3);

        //then
        Assertions.assertEquals(174.47, x, 0.01);
    }

    @Test
    public void getY() {
        Rocket rocket = new Rocket(71, 35);
        double y = rocket.getY(3);
        Assertions.assertEquals(78.07, y, 0.01);
    }

    @Test
    public void getFlightTime()
    {
        Rocket rocket = new Rocket(71, 35);
        double time = rocket.getFlightTime();
        Assertions.assertEquals(8.31, time, 0.01);
    }
}
