/**
 * Created by kobi on 11/30/2016.
 */   // Tremb032
public class Passenger {
    private double pickuptime; // Passenger variables.
    private Stop dropoff;
    private String direction;

    public String getDropoff() { // Passenger getters.
        return dropoff.getName();
    }

    public double getPickupTime() {
        return pickuptime;
    }

    public String getDirection() {
        return direction;
    }

    public Passenger(double pickuptime, Stop pickup) {
        this.pickuptime = pickuptime;
        dropoff = pickup;
        while (dropoff == pickup) { // Determining the dropoff of the passenger.
            int number = (int) (Math.random() * 13);
            if (number == 10) {
                number = 7;
            }
            if (number == 11) {
                number = 8;
            }
            if (number == 12) {
                number = 9;
            }
            dropoff = BusSim.stops[number];
        }
        if (dropoff.getStopNum() > pickup.getStopNum()) {
            direction = "east";
        }
        else {
            direction = "west";
        }
    }
}
