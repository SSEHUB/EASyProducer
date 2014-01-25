/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uni_hildesheim.sse;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.*;

/**
 * Class responsible for reading & writing IVML specifications.<br/>
 * @author Phani S
 * @since 02.05.2012
 */
public class IVML {

    private Project proj = new Project();
    private String projName;
    
    private boolean projCreated = false;
    private File outputFile = null;

    private List<CompositeCompound> compoundList = new ArrayList<CompositeCompound>();

    /**
     * Method to identify if a project is created.<br/>
     * @return projCreated returns <b>true</b> if created.<br/> 
     * 
     */
    public boolean projCreate() {
        return projCreated;
    }
    
    /*public void getprojectname() {

        // System.out.println("project is " + proj.getprojectName());
    }*/

    /**
     * Method to create and IVML project.<br/> 
     * 
     */
    public void openProject() {
        boolean pC;
        try {
            projName = proj.getprojectName();
            String ftW = projName + ".ivml";
            FileWriter fstream = new FileWriter(ftW);
            BufferedWriter out = new BufferedWriter(fstream);
           
            out.write("Project " + projName);
            out.write("  ");
            out.write("{");

            out.write(" \n");
            pC = true;
            out.close();
            System.out.println("Created the file " + ftW);
            this.projCreated = pC;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        writeIVML();
        
    }

   /* public void writeTest() {

        try {
            // projName = proj.getprojectName();
            String ftW = projName + ".txt";
            FileWriter fstream = new FileWriter(ftW, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("hi");
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }*/

    /**
     * Private method accessed after opening the project and writing inner IVML constituents.<br/> 
     * 
     */
    private void writeIVML() {

        try {
            // projName = proj.getprojectName();
            String ftW = projName + ".ivml";
            FileWriter fstream = new FileWriter(ftW, true);
            BufferedWriter out = new BufferedWriter(fstream);
            if (proj.hasIntAttributes() ) {
              //Currently NONE
                System.out.print(" "); 
            } else {
                System.out.print(" ");
            }

            this.compoundList = proj.getCompoundList();

            for (int i = compoundList.size() - 1; i >= 0; i--) {
                out.write("Compound ");
                out.write("_" + compoundList.get(i).getName());
                out.write(" { ");
                out.write("\n");

                if (compoundList.get(i).getCompoundList().size() > 0) {
                    for (int j = 0; j < compoundList.get(i).getCompoundList().size(); j++) {
                        
                        out.write("\t");

                        Leaf l = new Leaf("x", Datatype.String, "v");
                        if (compoundList.get(i).getCompoundList().get(j).getClass().equals(l.getClass())) {
                            Leaf lf = (Leaf) compoundList.get(i).getCompoundList().get(j);

                            String type = lf.getType().toString();
                            String name = lf.getName();
                            String attribute = (String) lf.getAttributeVal();

                            out.write(type + " " + name + " = " + "\"" + attribute + "\"");
                            out.write(" ; " + "\n");
                        } else {
                           
                            out.write("_" + compoundList.get(i).getCompoundList().get(j).getName());
                            out.write(" " + compoundList.get(i).getCompoundList().get(j).getName());
                            out.write(" ;");
                            out.write("\n");
                        }

                    }
                    out.write("\t");
                    out.write(" }" + "\n");

                    out.write("\n");
                    out.write("\n");
                }
            }

            out.write("\n");
            out.write("}");
            out.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
