public class Rocket {
    private final double velocity;
    private final double angle;
    private final double GRAVITY = 9.8;

    public Rocket(double velocity, double angle)
    {
        this.velocity = velocity;
        this.angle = Math.toRadians(angle);
    }

    public double getX(double time)
    {
        double xVelocity = Math.cos(angle) * velocity;
        double x = xVelocity * time;
        return x;
    }

    public double getY(double time)
    {
        double yVelocity = Math.sin(angle) * velocity;
        double y = yVelocity * time - .5 * GRAVITY * time * time;
        return y;
    }

    public double getFlightTime()
    {
        double yVelocity = Math.sin(angle) * velocity;
        double time = yVelocity / (.5 * GRAVITY);
        return time;
    }

}
