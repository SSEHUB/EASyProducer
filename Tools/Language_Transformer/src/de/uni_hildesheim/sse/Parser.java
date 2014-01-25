package de.uni_hildesheim.sse;

import java.util.Scanner;
import java.io.*;

/**
 * Main class that takes input file, native specification and output specification.<br/>
 * @author Phani S
 * @since 02.05.2012
 */


public class Parser {

   /**
    * This attribute is to check if the file in the native format exists.<br/>
    * 
    */
    private File f = null;
   
    /**
     * Method returns the file, used mainly for testing.<br/>
     * @return The file.
     */
    public File getF() {
        return f;
    }

    /**
     * The main class of the program.<br/>
     * Takes filename, native specification type and output specification type from Command line.<br/>
     * The filename should in the format "filename.type". 
     * @param args m.
     */
    
    public static void main(String[] args) {
      
        Parser ml = new Parser();
        Scanner inputfile = new Scanner(System.in);
        System.out.println("Please enter the filename");
        String filename = inputfile.nextLine();

        while (!filename.contains(".")) {
            System.out.println("Invalid filename, please include filetype also");
            filename = inputfile.nextLine();
        }

        System.out.println("Please enter the modeling specification");
        // System.out.println("convention: .filetype");

        String modSpec = inputfile.nextLine();

        System.out.println("Please enter the the mod. lang. you'd like to convert");

        String transSpec = inputfile.nextLine();

        if (modSpec.compareToIgnoreCase("his") == 0) {
            System.out.println("Sure");
            ml.getFile(filename, modSpec, transSpec);
        } else {
            System.out.println("We're sorry, we do not currently support this!");
        }

    }

    /**
     * Method gets the filename, native specification format and the output format, if file exists.<br/>
     * Depending on the native format, class constructor is created and method called.<br/>
     * @param filename The filename.
     * @param modSpec  The native specification
     * @param transSpec The output format.
     */
    public void getFile(String filename, String modSpec, String transSpec) {
       
        System.out.println("The file you'd like to transform is " + filename);

        f = new File("Sources" + File.separator + filename);
        
        boolean exists = f.exists();

        if (!exists) {
            System.out.println("The file you are searching for does not exist");
        } else {
            System.out.println("Hang on, more code coming");
            if (modSpec.compareToIgnoreCase("his") == 0) {
              

                ReadHIS alg = new ReadHIS(filename, modSpec, transSpec, f);

                alg.readSpec();
                
            }
            if (modSpec.compareTo("spot") == 0) {
                //SPOT spotAlg = new SPOT(filename, modSpec, transSpec, f);
                System.out.println(" ");
            }
            
            this.f = f;
        }

       

    }

}
