package de.uni_hildesheim.sse.reasoner.jess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**Class for writing output in Jess.<br/>
 * @since 31.05.2012
 * @author Phani
 */
public class JessFileWriter  {

    private String content;
    private File outputFile;
    
    /**
     * Method to create and IVML project.<br/> 
     * @param projName Name of the project.
     */
    
    public void openProject(String projName) {
//        outputFile = null;
//        outputFile = new File(projName + ".clp");

        
        try {
            outputFile = File.createTempFile(projName, ".clp");
            outputFile.deleteOnExit();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        try {
            FileWriter fstream = new FileWriter(outputFile);
            BufferedWriter out = new BufferedWriter(fstream);
            
            out.write("\n");
            out.write("\n"); 
            out.close(); 
            
        } catch (IOException e) { 
            
        }
        
    }
    
    /**
     * Method to create and IVML project.<br/> 
     * @param  stringToAppend String to write
     * @throws Exception
     */
    public void append(String stringToAppend) {
        this.content = stringToAppend;
        
        try {
            FileWriter fstream = new FileWriter(outputFile, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(content);
            out.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
         
    }
    
    
    
    /**
     * Method for closing the project writing.
     */
    public void closeProject() {
        System.out.println("The project has been closed for writing");      
    }
    
    /**
     * Writer method to copy & paste imported project.
     * @param projName Name of the imported project.
     */
    public void appendProject(String projName) {
        
        try {
            String path = "Files" + File.separator + projName + ".clp" + File.separator;
            BufferedReader in = new BufferedReader(new FileReader(path));
            
            String stringToCopy = in.readLine();
            
            while (stringToCopy != null) {
                this.append(stringToCopy);
                this.append("\n");
                stringToCopy = in.readLine(); 
                
            }
           
            
        } catch (IOException e) {
            
        }
        
    }
    
    /**
     * Returns the jess configuration file temporarily created for reasoning via the jess engine.
     * @return A temp file created for the current reasoning
     */
    File getJessCLPFile() {
        return outputFile;
    }
    
}
