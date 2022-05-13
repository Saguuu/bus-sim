/**
 * Created by kobi on 11/30/2016.
 */      // Tremb032
public class Bus {
    private int length; // Bus variables.
    private Passenger[] busPassengers;
    private int currentStop;
    private String direction;

    public Bus(int length, int currentStop, String direction) {
        this.length = length;
        this.currentStop = currentStop;
        this.direction = direction;
        busPassengers = new Passenger[length];
    }

    public int getLength() { // Buss getters and add / subtract methods.
        return length;
    }

    public Passenger[] getBusPassengers() {
        return busPassengers;
    }

    public void addCurrentStop() {
        currentStop += 1;
    }

    public void subCurrentStop() {
        currentStop -= 1;
    }

    public int getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(int n) { // These methods used to traverse the route.
        currentStop = n;
    }

    public void setDirection(String dir) {
        direction = dir;
    }

    public String getDirection() {
        return direction;
    }
}
