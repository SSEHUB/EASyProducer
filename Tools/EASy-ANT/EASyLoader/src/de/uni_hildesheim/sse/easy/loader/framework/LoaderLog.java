package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * A simple Logger class that is supposed to log the generator.
 * @author pastuschek
 *
 */
public class LoaderLog {

    private static Writer writer = new OutputStreamWriter(System.out); 
    // actually this shall be a PrintWriter - this simplifies the entire class
    
    /**
     * Sets up the LoaderLogger.
     * @param path Target for the log file.
     */
    public static void init(String path) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream(path), "utf-8"));
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Writes a line into the log file.
     * @param text The text for the log.
     */
    public static void writeLn(String text) {
        try {
            writer.write(text);
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
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
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
        }
        stars();
    }
    
    /**
     * Writes an information text.
     * 
     * @param text the text
     */
    public static void info(String text) {
        try {
            writer.write(text);
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Prints a throwable.
     * 
     * @param throwable the throwable
     */
    public static void writeLn(Throwable throwable) {
        throwable.printStackTrace(new PrintWriter(writer));
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
            skipLine();
            writer.write(error.getMessage());
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
        }
        stars();
    }

    /**
     * Writes an error into the log file.
     * @param text Text along the error.
     */
    public static void error(String text) {
        error(text, null);
    }
    
    /**
     * Writes an error into the log file.
     * @param text Text along the error.
     * @param cause The exception that caused the error.
     */
    public static void error(String text, Exception cause) {
        stars();
        try {
            writer.write(text);
            skipLine();
            if (null != cause) {
                writer.write(cause.getMessage());
                skipLine();
            }
        } catch (IOException ex) {
            reportException(ex);
        }
        stars();
    }
    
    /**
     * Writes a line of stars.
     */
    public static void stars() {
        try {
            writer.write("*************************************************************************");
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
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
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Closes the LoaderLog and its log file.
     * Has to be called for the file to be actually written.
     */
    public static void close() {
        try {
            writer.close();
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Writes a line separator into the log file.
     */
    public static void skipLine() {
        try {
            writer.write(System.getProperty("line.separator"));
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Writes a (more complex) line separator into the log file.
     * Use this to create visual lines in the log.
     */
    public static void line() {
        try {
            skipLine();
            writer.write("----------------------------------------------------------------");
            skipLine();
            skipLine();
        } catch (IOException ex) {
            reportException(ex);
        }
    }
    
    /**
     * Reports an exception.
     * 
     * @param ex the exception
     */
    private static void reportException(Exception ex) {
        System.out.println(ex.getMessage()); // preliminary
    }
    
}
