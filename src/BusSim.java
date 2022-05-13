/**
 * Created by kobi on 11/30/2016.
 */        // Tremb032
public class BusSim {
    static Agenda agenda = new Agenda();         // Creating various global variables.
    public static Stop[] stops = new Stop[10]; // List of stops.
    public static double load; // Load.
    private static Stop stop1 = new Stop("University Ave and 27th Street SE", 0); // Creating all stop objects.
    private static Stop stop2 = new Stop("Raymond Ave Station", 1);
    private static Stop stop3 = new Stop("University Ave and Fairview Ave", 2);
    private static Stop stop4 = new Stop("University Ave and Snelling Ave", 3);
    private static Stop stop5 = new Stop("University Ave and Lexington Parkway", 4);
    private static Stop stop6 = new Stop("University Ave and Dale Street", 5);
    private static Stop stop7 = new Stop("University Ave and Marion Street", 6);
    private static Stop stop8 = new Stop("Cedar Street and 5th Street", 7);
    private static Stop stop9 = new Stop("Minnesota Street and 4th Street", 8);
    private static Stop stop10 = new Stop("Union Depot", 9);
    public static int passengerCountOn = 0; // +1 when passenger gets on bus.
    public static int passengerCountOff = 0; // +1 when passenger gets off bus.
    public static int totalWait = 0; // Total waiting time.
    public static int totalBusCap = 0; // Total amount of people inside buses.
    public static int busesThatLeft = 0; // How many buses left a station.
    public static int totalTravelTime = 0; // Total wait time + riding time.
    public static int maxLineLength = 0; // Max line length.
    public static int averageLineLength = 0; // Average line length.
    public static int PMPG = 0;

    public static void reset() { // Reset simulation to prepare for new trial.
        agenda = new Agenda();
        stops = new Stop[10];
        load = 0;
        stop1 = new Stop("University Ave and 27th Street SE", 0);
        stop2 = new Stop("Raymond Ave Station", 1);
        stop3 = new Stop("University Ave and Fairview Ave", 2);
        stop4 = new Stop("University Ave and Snelling Ave", 3);
        stop5 = new Stop("University Ave and Lexington Parkway", 4);
        stop6 = new Stop("University Ave and Dale Street", 5);
        stop7 = new Stop("University Ave and Marion Street", 6);
        stop8 = new Stop("Cedar Street and 5th Street", 7);
        stop9 = new Stop("Minnesota Street and 4th Street", 8);
        stop10 = new Stop("Union Depot", 9);
        passengerCountOn = 0;
        passengerCountOff = 0;
        totalWait = 0;
        totalBusCap = 0;
        busesThatLeft = 0;
        totalTravelTime = 0;
        maxLineLength = 0;
        averageLineLength = 0;
        PMPG = 0;
    }

    public static void setLoad(int n) { // Set load for each trial.
        load = n;
    }


    public static void main(String[]args) { // Main for program.
        System.out.println("To show eq.:");
        stops[0] = stop1;    // Creating constant variable list of all stops.
        stops[1] = stop2;
        stops[2] = stop3;
        stops[3] = stop4;
        stops[4] = stop5;
        stops[5] = stop6;
        stops[6] = stop7;
        stops[7] = stop8;
        stops[8] = stop9;
        stops[9] = stop10;
        Bus bus1 = new Bus(40, 0, "east");   // Creating all buses and direction they start in.
        Bus bus2 = new Bus(40, 1, "east");
        Bus bus3 = new Bus(40, 2, "east");
        Bus bus4 = new Bus(40, 3, "east");
        Bus bus5 = new Bus(40, 4, "east");
        Bus bus6 = new Bus(40, 5, "west");
        Bus bus7 = new Bus(40, 6, "west");
        Bus bus8 = new Bus(40, 7, "west");
        Bus bus9 = new Bus(40, 8, "west");
        Bus bus10 = new Bus(40, 0, "west");
        Bus bus11 = new Bus(40, 1, "west");
        Bus bus12 = new Bus(40, 2, "west");
        Bus bus13 = new Bus(60, 3, "west");
        Bus bus14 = new Bus(60, 4, "west");
        Bus bus15 = new Bus(60, 5, "east");
        Bus bus16 = new Bus(60, 6, "east");
        Bus bus17 = new Bus(60, 7, "east");
        Bus bus18 = new Bus(60, 8, "east");
        BusEvent newBus1 = new BusEvent(bus1, stop1); // Creating all bus events for all buses.
        BusEvent newBus2 = new BusEvent(bus2, stop2);
        BusEvent newBus3 = new BusEvent(bus3, stop3);
        BusEvent newBus4 = new BusEvent(bus4, stop4);
        BusEvent newBus5 = new BusEvent(bus5, stop5);
        BusEvent newBus6 = new BusEvent(bus6, stop6);
        BusEvent newBus7 = new BusEvent(bus7, stop7);
        BusEvent newBus8 = new BusEvent(bus8, stop8);
        BusEvent newBus9 = new BusEvent(bus9, stop9);
        BusEvent newBus10 = new BusEvent(bus10, stop1);
        BusEvent newBus11 = new BusEvent(bus11, stop2);
        BusEvent newBus12 = new BusEvent(bus12, stop3);
        BusEvent newBus13 = new BusEvent(bus13, stop4);
        BusEvent newBus14 = new BusEvent(bus14, stop5);
        BusEvent newBus15 = new BusEvent(bus15, stop6);
        BusEvent newBus16 = new BusEvent(bus16, stop7);
        BusEvent newBus17 = new BusEvent(bus17, stop8);
        BusEvent newBus18 = new BusEvent(bus18, stop9);
        PassengerEvent stop1Event = new PassengerEvent(stop1); // Instantiating all PassengerEvents.
        PassengerEvent stop2Event = new PassengerEvent(stop2);
        PassengerEvent stop3Event = new PassengerEvent(stop3);
        PassengerEvent stop4Event = new PassengerEvent(stop4);
        PassengerEvent stop5Event = new PassengerEvent(stop5);
        PassengerEvent stop6Event = new PassengerEvent(stop6);
        PassengerEvent stop7Event = new PassengerEvent(stop7);
        PassengerEvent stop8Event = new PassengerEvent(stop8);
        PassengerEvent stop9Event = new PassengerEvent(stop9);
        PassengerEvent stop10Event = new PassengerEvent(stop10);
        agenda.add(newBus1, 0); // Adding all events to the agenda.
        agenda.add(newBus2, 0);
        agenda.add(newBus3, 0);
        agenda.add(newBus4, 0);
        agenda.add(newBus5, 0);
        agenda.add(newBus6, 0);
        agenda.add(newBus7, 0);
        agenda.add(newBus8, 0);
        agenda.add(newBus9, 0);
        agenda.add(stop1Event, 0);
        agenda.add(stop2Event, 0);
        agenda.add(stop3Event, 0);
        agenda.add(stop4Event, 0);
        agenda.add(stop5Event, 0);
        agenda.add(stop6Event, 0);
        agenda.add(stop7Event, 0);
        agenda.add(stop8Event, 0);
        agenda.add(stop9Event, 0);
        agenda.add(stop10Event, 0);
        BusSim.setLoad(120); // Normal load = 120, // heavy load = 45.
        while (agenda.getCurrentTime() < 39600) { // Agenda. Numbers are at eq. if you change times.
            agenda.remove().run();
        }
        System.out.println("9 buses of size 40, normal load over a 4 hour period:" );
        System.out.println("Passengers served: " + BusSim.passengerCountOn); // Statistics.
        System.out.println("Average line wait time: " + BusSim.totalWait / BusSim.passengerCountOn);
        System.out.println("Average bus capacity: " + BusSim.totalBusCap / BusSim.busesThatLeft);
        System.out.println("Average travel time (wait + ride): " + BusSim.totalTravelTime / BusSim.passengerCountOff);
        System.out.println("Maximum line length: " + BusSim.maxLineLength);
        System.out.println("PMPG: " + 6 * (BusSim.totalBusCap / BusSim.busesThatLeft));
        BusSim.reset();
        System.out.println(); // For reason consequent simulations average line wait time is incorrect,
        // but all other data points are spot on. So I am running tests individual and writing them up.
        // The code seems to be in equilibrium and posts good data, but I cannot get the test to run multiple
        // times under one call correctly. If you change the parameters of the first version it works just fine every time.
        // Please if you can/ are able test a heavier load to see that it matches the data in the paper at least for that case.
        // (Set load above to 45 and then run), it should closely match a few results I had recorded for bus size 40
        // at normal for 4 hours.
        // If the program is run as is, the Equilibrium tests can be observed if the total sim time is changed
        // to the times specified in Figure 3.
    }
}
