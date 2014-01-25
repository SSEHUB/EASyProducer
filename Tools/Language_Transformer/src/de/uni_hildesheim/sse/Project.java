/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uni_hildesheim.sse;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Project class, provides a medium for setting and getting attributes, compounds etc..<br/>
 * 
 * @author Phani S
 * @since 07.05.2012
 */
public class Project {

    private String projectName;
    private int subProjectsNumber;
    private String[] subProjectNames = new String [10];

    private String outPutFormat;

    //private String filename;
    //private File file;

    private String intAttribute;
    private String strAttribute;
    
    private List<String> intList = new ArrayList<String>();
    private List<String> strList = new ArrayList<String>();

    private List<CompositeCompound> cList = new ArrayList<CompositeCompound>();

    

    /*public Project() {
    }*/

    /**
     * Method to set the project name.<br/>
     * @param pName 
     */
    public void setProjectName(String pName) {
        this.projectName = pName;
    }

    /**
     * Method to get the project name.<br/>
     * @return projectName 
     */
    public String getprojectName() {
        return projectName;
    }

    /**
     * Method to set the sub-project name.<br/>
     * @param subName 
     */
    public void setSubProject(String subName) {
        this.subProjectNames[subProjectsNumber] = subName;
        subProjectsNumber++;
    }

    /**
     * Method to get the number of sub-projects.<br/>
     * @return subProjectNumber 
     */
    public int getProjectsNumber() {
        return subProjectsNumber;
    }

    /**
     * Method to know if there are any sub-projects.<br/>
     * @return hasSubProjects returns <b>true</b> if sub-projects exist  
     */
    public boolean hasSubProjects() {
        
        boolean hasSubProjects;
        if (subProjectsNumber == 0) {
            hasSubProjects = false;
        } else {
            hasSubProjects = true;
        }

        return hasSubProjects;
    }

    /**
     * Method to set the integer attributes. Attribute name is passed and added to a list<br/>
     * @param name name of the Integer attribute 
     */
    public void setIntegerAttributes(String name) {
        this.intAttribute = name;
        intList.add(intAttribute);

    }

    /**
     * Method to set the string attributes. Attribute name is passed and added to a list<br/>
     * @param name name of the String attribute 
     */
    public void setStringAttributes(String name) {
        this.strAttribute = name;

        strList.add(strAttribute);

    }

    /**
     * Method to know if there are any Integer attributes.<br/>
     * @return returns <b>true</b> if integer attributes exist  
     */
    public boolean hasIntAttributes() {
        return (intList != null);
    }

    /**
     * Method to know if there are any String attributes.<br/>
     * @return returns <b>true</b> if String attributes exist  
     */
    public boolean hasStrAttribues() {
        return (strList != null);
    }

    /**
     * Method to retrieve Integer attributes.<br/>
     * @return intList  
     */
    
    public List<String> getIntAttributes() {
        return intList;
    }

    /**
     * Method to retrieve String attributes.<br/>
     * @return strList  
     */
    public List<String> getStrAttributes() {
        return strList;
    }

    /**
     * Method to get the list of Compounds from the file being read.<br/>
     * @param cc  
     */
    public void passCompound(List<CompositeCompound> cc) {
        this.cList = cc;
        //System.out.println("size of the passed roots " + cList.size());
    }

    /**
     * Method to pass the list of Compounds.<br/>
     * @return cList  
     */
    public List<CompositeCompound> getCompoundList() {
        return cList;
    }

    /**
     * Method to instantiate writing the output file.<br/>
     * @param fTrans  
     */
    public void instantiateProject(String fTrans) {
        this.outPutFormat = fTrans;

        if (outPutFormat.equalsIgnoreCase("ivml")) {
            IVML ivml = new IVML();
            //Project project = Project.this;
            //System.out.println("project name here is also? " + projectName);
            //ivml.testIVML(project);
            ivml.openProject();

        }
    }

}
