/**
 * Nascar
 *
 * A class that models a Nascar.
 */
public class Nascar extends Thread implements Car {
    private String make;
    private String driver;
    private double speed;
    private long lapTime;
    
    public Nascar(String make, String driver, double speed, double trackLength) {
        this.make = make;
        this.driver = driver;
        this.speed = speed;
        lapTime = this.calculateLapTime(trackLength);
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(lapTime * 1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver + " has finished!");
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Driver: " + driver);
        System.out.println("Make: " + make);
        System.out.printf("MPH: %.2f MPH%n", speed);
    }

    @Override
    public long calculateLapTime(double trackLength) {
        double time = (speed / trackLength) / 60;
        return Double.valueOf(time).longValue();
    }

    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setLapTime(long lapTime) {
        this.lapTime = lapTime;
    }

    @Override
    public long getLapTime() {
        return lapTime;
    }
}
