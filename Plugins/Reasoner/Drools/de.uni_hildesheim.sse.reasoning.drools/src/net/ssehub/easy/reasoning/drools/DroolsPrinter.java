package net.ssehub.easy.reasoning.drools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;



/**
 * This class contains methods for writing .drl files at the initial state. 
 * 
 * @author Phani
 *
 */
public class DroolsPrinter {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");
    
    private static final String CONFIGRULE = "rule " + "\"Config rule\" " 
            + "\n agenda-group " + "\"Group Config\""
            + "\ndialect " + "\"mvel" + "\""
            + "\nno-loop true" 
            + "\nlock-on-active true" 
            + "\n\t"
            + "when" + "\n\t\t";
             
    private static final String IMPORTARRAYS = "import java.util.Arrays;";
    private static final String IMPORT_ARRAYLIST = "import java.util.ArrayList;";
    private static final String IMPORT_LIST = "import java.util.List;";
    private static final String IMPORT_SET = "import java.util.Set;";
    private File outputFile = null;
    private PrintWriter pw = null;
   
    

    /**
     * Method to create and IVML project.<br/> 
     * @param projName Name of the project.
     */
    
    public void openProject(String projName) {

//        String path = System.getProperty("user.dir") + File.separator;
//        outputFile = new File(path + projName + ".drl");

        
        try {
            outputFile = File.createTempFile(projName, ".clp");
            outputFile.deleteOnExit();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
       
        
        try {
            pw = new PrintWriter(outputFile);
            String packageName = this.getClass().getPackage().getName();
            pw.write("package " + packageName);
            pw.write("\n");
            pw.write("// Project - " + projName + "\n");
            pw.write(IMPORT_LIST + "\n");
            pw.write(IMPORT_SET + "\n");
            pw.write(IMPORTARRAYS + "\n");
            pw.write(IMPORT_ARRAYLIST + "\n");
            pw.println();
            pw.checkError();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
       
        
        
    }
    
    /**
     * Method to create and IVML project.<br/> 
     * @param  stringToAppend String to write
     * @throws Exception
     */
    public void append(String stringToAppend) {
        String content = stringToAppend;
        pw.append(content);
        pw.println();
        pw.println();
        pw.checkError();
       
    }
    
    /**
     * Method to write the initial configuration.<br/> 
     * @param  configValues Map containing the initial configuration.
     * @param configValues2 Map containing the initial configuration (partial compound values).
     * @throws Exception
     */
    public void addConfig(Map<String, String> configValues, Map<String, String> configValues2) {
        String projects = "";
        pw.print(CONFIGRULE);
        String modi = "";
        Iterator<String> itr = configValues.keySet().iterator();
        List<String> objectsAdded = new ArrayList<String>();
        while (itr.hasNext()) {
            String k = itr.next();
            String value = "";
            value = configValues.get(k);
            int projectNr = 0;
            if (DroolsVisitor.getDroolsClasseMap().get(k) != null) {
                projectNr = DroolsVisitor.getDroolsClasseMap().get(k) / DroolsVisitor.THRESHOLD;
                String tempString = "P" + projectNr + " : " + "Project" + projectNr + "()\n";
                if (!projects.contains(tempString)) {
                    projects += tempString;
                }
                modi += "\t\tmodify(P" + projectNr + ")" + "{" + k + " = " + value 
                        + "};\n";
                objectsAdded.add("P" + projectNr + "." + k);
            }
        }
        pw.print("P : Project()\n");
        pw.print(projects + "\n\t" + "then" + "\n");
        Iterator<String> itr2 = configValues2.keySet().iterator();
        if (configValues2.size() != 0) {
            pw.print(" \n ");
        }
        String dListTemp = "\n";
        String modifications = "";
        while (itr2.hasNext()) {
            String k = itr2.next();
            int in = k.indexOf(".");
            String pN = k.substring(0, in);
            String nK = k.substring(in + 1, k.length());
            //Writing modify(PNr){expression involving the the variable}
            modifications += "\n\t\tmodify(" + pN + "){";
            modifications += k + " = " + configValues2.get(k);
            if (!k.startsWith("##")) {
                dListTemp += "dList.add(\"" + nK + "\");\n";
            }
            modifications += "};\n"; 
            modifications = modifications.replace("##", "");
        }
        String dList = DroolsVisitor.getDList();
        pw.print(dListTemp + "\n");
        pw.print(dList + "\n");
        pw.print("modify(P){Proj_drools = \"blah\"};\n\t");
        pw.print(modi);
        pw.print(modifications);
        pw.checkError();
       
    }
    
    /**
     * Method to add facts to the Drools knowledge base.
     * @param facts List containing the facts.
     */
    public void addFacts(List<String> facts) {
        logger.info("adding facts? " + facts.size());
        for (int i = 0; i < facts.size(); i++) {
            String temp = facts.get(i);
            int classNumber = DroolsVisitor.getDroolsClasseMap().get(temp) / DroolsVisitor.THRESHOLD;
            String fact = "\t\tinsertLogical(" + "P" + classNumber + "." + facts.get(i) + ")";
            pw.print(fact + "\n");
        }
        pw.print("\n end \n\n");
        facts.removeAll(facts);
        pw.checkError();
    }

    /**
     * Getter for the path of the .drl file.
     * @return Path of the file.
     * @throws IOException Throws exception if the file is not found.
     */
    public String getFilePath() throws IOException {
        return outputFile.getCanonicalPath();
        
    }
    
    /**
     * Close printing.
     */
    public void close() {
        if (null != pw) {
            pw.close();
        }
    }
    
}
