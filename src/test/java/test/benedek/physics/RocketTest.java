package test.benedek.physics;

import benedek.physics.Rocket;
import org.junit.Assert;
import org.junit.Test;

public class RocketTest {
    @Test
    public void getX()
    {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double x = rocket.getX(3);

        //then
        Assert.assertEquals(174.47, x, 0.01);
    }

    @Test
    public void getY() {
        Rocket rocket = new Rocket(71, 35);
        double y = rocket.getY(3);
        Assert.assertEquals(78.07, y, 0.01);
    }

    @Test
    public void getFlightTime()
    {
        Rocket rocket = new Rocket(71, 35);
        double time = rocket.getFlightTime();
        Assert.assertEquals(8.31, time, 0.01);
    }
}
