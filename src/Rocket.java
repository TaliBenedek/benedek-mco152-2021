public class Rocket {
    private final double velocity;
    private final double angle;
    private final double GRAVITY = 9.8;

    public Rocket(double velocity, double angle)
    {
        this.velocity = velocity;
        this.angle = Math.toRadians(angle);
    }

    /**
    * @param time in seconds
    * @return x position of rocket at the specified time
    */
    public double getX(double time)
    {
        double xVelocity = Math.cos(angle) * velocity;
        double x = xVelocity * time;
        return x;
    }

    /**
     * @param time in seconds
     * @return y position of rocket at the specified time
     */
    public double getY(double time)
    {
        double yVelocity = Math.sin(angle) * velocity;
        double y = yVelocity * time - .5 * GRAVITY * time * time;
        return y;
    }

    /**
     *
     * @return the flight time of the rocket in seconds
     * */
    public double getFlightTime()
    {
        double yVelocity = Math.sin(angle) * velocity;
        double time = yVelocity / (.5 * GRAVITY);
        return time;
    }

}
