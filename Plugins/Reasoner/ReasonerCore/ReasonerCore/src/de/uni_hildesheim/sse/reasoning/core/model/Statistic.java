package de.uni_hildesheim.sse.reasoning.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class contains statistic methods for measuring and displaying reasoning performance.
 * @author Sizonenko
 *
 */
public class Statistic {
    
    private static final Map<String, List<Double>> PERFORMANCE = new HashMap<String, List<Double>>();

    /**
     * Creates a new ID for an individual reasoning task.
     * @param projectName Name of the project that is reasoned on.
     * @return unique reasoning ID composed from the name of the project and a time when reasoning was started.
     */
    public static synchronized String createNewReasoningID(String projectName) {        
        String reasoningID = projectName + System.currentTimeMillis(); 
        List<Double> timeStamps = PERFORMANCE.get(reasoningID);
        if (null != timeStamps) {
            int randomdigit = (int) (System.nanoTime() % 10);
            // Recursive call
            reasoningID = createNewReasoningID(projectName + randomdigit);
        } 
        return reasoningID;
    }    
    
    /**
     * Create a list for storing timestamps for measuring reasoning performance.
     * @param reasoningID ID of the unique reasoning process.
     */
    public static void createTimePerformanceMeasurement(String reasoningID) {
        PERFORMANCE.put(reasoningID, new ArrayList<Double>());
    }
    
    /**
     * Method to add a timestamp to the measurements.
     * @param reasoningID ID of the unique reasoning process.
     * @param timestamp Time in milliseconds of a point in the reasoning that needs to be recorded.
     */
    public static void addTimestamp(String reasoningID, double timestamp) {
        List<Double> timeStamps = PERFORMANCE.get(reasoningID);
        int timeStampCount = timeStamps.size();
        if (timeStampCount == 0) {
            timeStamps.add(timestamp);
        } else {
            timestamp = timestamp - timeStamps.get(timeStampCount - 1);
            timeStamps.add(timestamp);
        }
    }
    
    /**
     * Method for retrieving statistics for a specific reasoning process.
     * @param reasoningID ID of the unique reasoning process.
     */
    public static void getStats(String reasoningID) {
        List<Double> timeStamps = PERFORMANCE.get(reasoningID);
        for (int i = 1; i < timeStamps.size(); i++) {
            System.out.print(timeStamps.get(i).toString() + ";");
        }
        System.out.println();
    }
}
