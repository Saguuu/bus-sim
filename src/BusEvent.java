/**
 * Created by kobi on 11/30/2016.
 */      // Tremb032
public class BusEvent implements Event { // Bus event class.
    private Bus newBus;
    private Stop newStop;


    public BusEvent(Bus bus, Stop stop) {
        newBus = bus;
        newStop = stop;
    }

    public void run() {
        int i = 0;
        int extratime = 0;          // Variable that adds time to reschedule depending on passenger changes.
        while (i < newBus.getLength()) {  // Checking if any passengers need to be let off, removing them if so.
            if (newBus.getBusPassengers()[i] != null) {
                if (newBus.getBusPassengers()[i].getDropoff().equals(newStop.getName())) {
                    BusSim.passengerCountOff ++;
                    Passenger travelDone = newBus.getBusPassengers()[i];
                    BusSim.totalTravelTime += BusSim.agenda.getCurrentTime() - travelDone.getPickupTime();
                    newBus.getBusPassengers()[i] = null;
                    extratime += 2;
                    i += 1;
                }
                else {
                    i += 1;
                }
            }
            else {
                i += 1;
            }
        }
        if (newBus.getDirection().equals("east")) { // Algorithm to move bus and to switch it's direction.
            newBus.addCurrentStop();
            if (newBus.getCurrentStop() == 10) {
                newBus.setDirection("west");
                newBus.setCurrentStop(8);
            }
        }
        else {
            newBus.subCurrentStop();
            if (newBus.getCurrentStop() == -1) {
                newBus.setDirection("east");
                newBus.setCurrentStop(1);
            }
        }
        if (newBus.getDirection().equals("east")) { // Adding passengers to bus depending on passenger direction.
            int j = 0;
            while (j < newBus.getLength() && newStop.getEastQueue().length() != 0) {
                if (newBus.getBusPassengers()[j] == null) {
                    Passenger remove1 = (Passenger) newStop.getEastQueue().remove();
                    newBus.getBusPassengers()[j] = remove1;
                    BusSim.passengerCountOn ++;
                    BusSim.totalWait += BusSim.agenda.getCurrentTime() - remove1.getPickupTime();
                    j += 1;
                    extratime += 3;
                }
                else {
                    j += 1;
                }
            }
        }
        else {
            int k = 0;
            while (k < newBus.getLength() && newStop.getWestQueue().length() != 0) {
                if (newBus.getBusPassengers()[k] == null) {
                    Passenger remove2 = (Passenger) newStop.getWestQueue().remove();
                    newBus.getBusPassengers()[k] = remove2;
                    BusSim.passengerCountOn ++;
                    BusSim.totalWait += BusSim.agenda.getCurrentTime() - remove2.getPickupTime();
                    k += 1;
                    extratime += 3;
                }
                else {
                    k += 1;
                }
            }
        }
        int count = 0;
        int z = 0;
        while (z < newBus.getLength()) { // Checking the occupancy of the current bus.
            if (newBus.getBusPassengers()[z] != null) {
                count += 1;
                z += 1;
            }
            else {
                z += 1;
            }
        }
        BusSim.totalBusCap += count; // Incrementing bus passenger population total.
        BusSim.busesThatLeft ++; // Bus that has left a station +1.
        int reschedtime = 195; // Default 3 mins 15 seconds interval.
        if (extratime > 15) { // If more than 15 seconds was used for passengers, add total extratime - 15 to reschedtime.
            reschedtime += extratime - 15;
        }
        Stop nextStop = BusSim.stops[newBus.getCurrentStop()]; // Rescheduling the bus event.
        BusEvent newEvent = new BusEvent(newBus, nextStop);
        BusSim.agenda.add(newEvent, reschedtime);
    }
}
