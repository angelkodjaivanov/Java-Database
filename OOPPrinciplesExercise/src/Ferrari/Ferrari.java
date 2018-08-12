package Ferrari;

public class Ferrari implements Functionality{
    public static String model = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gasPedal() {
        return "Zadu6avam sA!";
    }
}
