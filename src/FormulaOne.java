/**
 * FormulaOne
 *
 * A class that models a Formula One.
 */
public class FormulaOne extends Thread implements Car {
    private String team;
    private String driver;
    private double speed;
    private long lapTime;
    
    public FormulaOne(String team, String driver, double speed, double trackLength) {
        this.team = team;
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
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Driver: " + driver);
        System.out.println("Team: " + team);
        System.out.printf("MPH: %.2f KPH%n", speed);
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
