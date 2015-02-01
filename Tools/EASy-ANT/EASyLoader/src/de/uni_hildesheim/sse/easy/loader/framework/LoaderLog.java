package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * A simple Logger class that is supposed to log the generator.
 * @author pastuschek
 *
 */
public class LoaderLog {

    private static Writer writer;
    
    /**
     * Sets up the LoaderLogger.
     * @param path Target for the log file.
     */
    public static void init(String path) {
        
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(path), "utf-8"));
        } catch (IOException ex) {
          // report
        }
        
    }
    
    /**
     * Writes a line into the log file.
     * @param text The text for the log.
     */
    public static void writeLn(String text) {
        
        try {
            writer.write(text);
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
          // report
        }
        
    }
    
    /**
     * Writes a warning into the log file.
     * @param text Text along the error.
     */
    public static void warn(String text) {
        
        stars();
        
        try {
            writer.write(text);
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
            
        }
        
        stars();
        
    }
    
    /**
     * Writes a warning into the log file.
     * @param text Text along the error.
     * @param error The exception that caused the error.
     */
    public static void warn(String text, Exception error) {
        
        stars();
        
        try {
            writer.write(text);
            writer.write(System.getProperty("line.separator"));
            writer.write(error.getMessage());
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
            
        }
        
        stars();
        
    }
    
    /**
     * Writes a line of stars.
     */
    public static void stars() {
        
        try {
            writer.write("*************************************************************************");
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
            
        }
        
    }
    
    /**
     * Writes a line into the log file, can add an indent.
     * @param text The text for the log.
     * @param indent The indent depth (steps of 4 are recommended).
     */
    public static void writeLn(String text, int indent) {
        
        String sIndent = "";
        for (int i = 1; i <= indent; i++) {
            sIndent =  sIndent + " ";
        }
        
        try {
            writer.write(sIndent + text);
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
          // report
        }
        
    }
    
    /**
     * Closes the LoaderLog and its log file.
     * Has to be called for the file to be actually written.
     */
    public static void close() {
        try {
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Writes a line separator into the log file.
     */
    public static void skipLine() {
        
        try {
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
          // report
        }
        
    }
    
    /**
     * Writes a (more complex) line separator into the log file.
     * Use this to create visual lines in the log.
     */
    public static void line() {
        
        try {
            writer.write(System.getProperty("line.separator"));
            writer.write("----------------------------------------------------------------");
            writer.write(System.getProperty("line.separator"));
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
          // report
        }
        
    }
    
}
