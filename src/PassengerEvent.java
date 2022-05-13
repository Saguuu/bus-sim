/**
 * Created by kobi on 11/30/2016.
 */       // Tremb032
public class PassengerEvent implements Event {
    private Stop stop;

    public PassengerEvent(Stop stop) {
        this.stop = stop;
    }

    public void run() { // PassengerEvent run method
        Passenger passenger = new Passenger(BusSim.agenda.getCurrentTime(), stop); // Create new passenger.
        if (stop.getEastQueue() != null) { // This code checks to see if it a side station. then checks it's length of one or both lines.
            if (stop.getEastQueue().length() > BusSim.maxLineLength) {
                BusSim.maxLineLength = stop.getEastQueue().length();
            }
        }
        if (stop.getWestQueue() != null) {
            if (stop.getWestQueue().length() > BusSim.maxLineLength) {
                BusSim.maxLineLength = stop.getWestQueue().length();
            }
            if (passenger.getDirection().equals("east")) { // Adding passenger to queue depending on dropoff.
                stop.getEastQueue().add(passenger);
            } else {
                stop.getWestQueue().add(passenger);
            }
            double[] randomTime = new double[20];
            int i;
            for (i = 0; i < 2; i++) {                // Algorithm to decide arrival times.
                randomTime[i] = BusSim.load + BusSim.load * 0.75;
                randomTime[19 - i] = BusSim.load - BusSim.load * 0.75;
            }
            for (i = 2; i < 5; i++) {
                randomTime[i] = BusSim.load + BusSim.load * 0.50;
                randomTime[19 - i] = BusSim.load - BusSim.load * 0.50;
            }
            for (i = 5; i < 9; i++) {
                randomTime[i] = BusSim.load + BusSim.load * 0.20;
                randomTime[19 - i] = BusSim.load - BusSim.load * 0.20;
            }
            randomTime[9] = BusSim.load;
            randomTime[10] = BusSim.load;
            double passengerArrivalTime = randomTime[(int) (Math.random() * 20)];
            if (stop.getStopNum() == 7 || stop.getStopNum() == 8 || stop.getStopNum() == 9) { // Increasing rate for downtown stops.
                passengerArrivalTime -= 30;
            }
            if (passengerArrivalTime < 0) {
                passengerArrivalTime = 0;
            }
            BusSim.agenda.add(this, passengerArrivalTime); // Re-scheduling.
        }
    }
}
