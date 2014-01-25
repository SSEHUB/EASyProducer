package de.uni_hildesheim.sse;

import java.io.File;


/**
 * Class for implementing SPOT read and write specifications.<br/>
 * @author Phani S
 * @since 09.05.2012
 */
public class SPOT {

    private String fName;
    private String fTrans;
    private File file;
    
    /**
     * Class Constructor.<br/>
     * @param filename name of the file
     * @param transSpec output format
     * @param filePassed File
     */
    public SPOT(String filename, String transSpec, File filePassed) {
        this.fName = filename;
        this.fTrans = transSpec;
        this.file = filePassed;
    }
    
    /**
     * Method for reading the HIS files.<br/>
     */
    public void readSPOT(){
        
    }
}
