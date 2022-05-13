/**
 * Created by kobi on 11/30/2016.
 */        // Tremb032
public class Stop { // Class for each stop.
    private static Q2 eastQueue = new Q2(); // Queues, both are not used for all.
    private static Q2 westQueue = new Q2();
    private String name; // These methods hold identity of the stop object.
    private int stopNum;

    public Stop(String name, int stopNum) {
        this.name = name;
        this.stopNum = stopNum;
    }


    public String getName() { // Stop class getter methods.
        return name;
    }

    public int getStopNum() {
        return stopNum;
    }

    public Q2 getEastQueue() {
        return eastQueue;
    }

    public Q2 getWestQueue() {
        return westQueue;
    }
}
