package net.ssehub.easy.reasoning.core.performance;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Class contains statistic methods for measuring and displaying reasoning performance.
 * @author Sizonenko
 *
 */
public class PerformanceStatistics {
    
    private static final Map<String, List<Long>> PERFORMANCE = new HashMap<String, List<Long>>();
    private static final Map<String, String> DESCRIPTION = new HashMap<String, String>();
    private static final Map<String, String> PROJECT = new HashMap<String, String>();
    
    private static final String FOLDER_PATH = "C:/Sizonenko/ReasoningOutput/";
    private static final String LINEBREAK = "\r\n";

    /**
     * Creates a new ID for an individual reasoning task.
     * @param projectName Name of the project that is reasoned on.
     * @param description What is measured.
     * @return unique reasoning ID composed from the name of the project and a time when reasoning was started.
     */
    public static synchronized String createReasoningID(String projectName, String description) {        
        String reasoningID = projectName;
//        String reasoningID = projectName + "_" + System.currentTimeMillis();
        DESCRIPTION.put(reasoningID, description);        
        PROJECT.put(reasoningID, projectName);        
        return reasoningID;
    }    
    
    /**
     * Clears a specific reasoningID from the map.
     * @param reasoningID ID to clear.
     */
    public static void clearReasoningID(String reasoningID) {
        PERFORMANCE.remove(reasoningID);
        DESCRIPTION.remove(reasoningID);
        PROJECT.remove(reasoningID);
    }
    
    /**
     * Create a list for storing timestamps for measuring reasoning performance.
     * @param reasoningID ID of the unique reasoning process.
     */
    public static void createPerformanceMeasurement(String reasoningID) {
        PERFORMANCE.put(reasoningID, new ArrayList<Long>());        
    }
    
    /**
     * Method to add a timestamp to the measurements.
     * @param reasoningID ID of the unique reasoning process.
     */
    public static void addTimestamp(String reasoningID) {
        List<Long> timeStamps = PERFORMANCE.get(reasoningID);        
        timeStamps.add(System.currentTimeMillis());
    }
    
    /**
     * Method for retrieving statistics for a specific reasoning process.
     * @param reasoningID ID of the unique reasoning process.
     */
    public static void getStats(String reasoningID) {
        List<Long> timeStamps = PERFORMANCE.get(reasoningID);
        if (timeStamps.size() > 0) {            
//            String fileName = FOLDER_PATH + PROJECT.get(reasoningID) 
//                    + "_" + DESCRIPTION.get(reasoningID) + ".txt";
            String fileName = FOLDER_PATH + "Stats.txt";
            FileWriter writer = null;
            try {
                writer = new FileWriter(fileName, true);
                Long generalTime = timeStamps.get(timeStamps.size() - 1) - timeStamps.get(0);
                writer.write(reasoningID + ";" + DESCRIPTION.get(reasoningID) + ";" 
                        + generalTime + ";");                
                for (int i = 1; i < timeStamps.size(); i++) {
                    Long calculatedTime = timeStamps.get(i) - timeStamps.get(i - 1);
                    writer.write(calculatedTime + ";");
                }
                writer.write(LINEBREAK);
                writer.close();
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
    }
    
    /**
     * Method for printing all variables from a configuration to a file.
     * @param reasoningID ID of the unique reasoning process.
     * @param config Configuration used.
     */
    public static void printConfigVariables(String reasoningID, Configuration config) {
        String fileName = FOLDER_PATH + reasoningID + "_" + DESCRIPTION.get(reasoningID) + ".txt";
        int linecounter = 0;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            for (IDecisionVariable variable : config) {
                writer.write(variable.getDeclaration().getName().toString() 
                        + ";" 
                        + variable.getState().toString()
                        + ";");
                if (variable.hasValue()) {
                    writer.write(variable.getValue().getValue().toString());
                }
                linecounter++;
                if (linecounter < config.getDecisionCount()) {
                    writer.write(LINEBREAK);
                }
            }
            writer.close();                
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
    }
}
