package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import org.junit.Assert;

/**
 * Some utility methods. It would be better to use Apache Commons, but I did not want to
 * affect the dependencies of this project.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Prevents external creation.
     */
    private Utils() {
    }
    
    /**
     * Copies a file.
     *  
     * @param source the source file
     * @param dest the destination file
     * @throws IOException in case of read/write problems
     */
    static void copyFile(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            if (null != sourceChannel) {
                sourceChannel.close();
            }
            if (null != destChannel) {
                destChannel.close();
            }
        }
    }
    
    /**
     * Reads a file into a string.
     * 
     * @param file the file to be read
     * @return the file as string
     * @throws IOException in case of read/write problems
     */
    static String readFileToString(File file) throws IOException {
        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while (scanner.hasNextLine()) {        
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Asserts file equality.
     * 
     * @param msg a text message if assertion fails
     * @param expected the file containing the expected contents
     * @param actual the file containing the present contents
     * @param ignoreWhitespace whether whitespaces shall be ignored, i.e., removed
     * 
     * @throws IOException in case of read/write problems
     */
    static void assertEquals(String msg, File expected, File actual, boolean ignoreWhitespace) throws IOException {
        String sExpected = readFileToString(expected).trim();
        String sActual = readFileToString(actual).trim();
        if (ignoreWhitespace) {
            sExpected = sExpected.replaceAll("\\s", "");
            sActual = sActual.replaceAll("\\s", "");
        }
        Assert.assertEquals(msg, sExpected, sActual);
    }

    /**
     * Delete a file or folder including contained files or folders.
     * 
     * @param file the file/folder to be deleted
     */
    static void delete(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] contained = file.listFiles();
            for (int f = 0; f < contained.length; f++) {
                delete(contained[f]);
            }
            file.delete();
        }
    }

}
