/**
 * Created by andre on 5/2/2016.
 */
public class SortTimer {
    private long startTime;
    private long stopTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        stopTime = System.currentTimeMillis();
    }
    //get elapsed time in seconds
    public double getTime() {
        return (double)(stopTime - startTime) / 1000;
    }

}
