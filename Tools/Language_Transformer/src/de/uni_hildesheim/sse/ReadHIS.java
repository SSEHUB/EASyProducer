/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uni_hildesheim.sse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Class responsible for reading HIS spec.<br/>
 * & define Compound and leaf structure<br/>
 * @author Phani S
 * @since 02.05.2012
 */
public class ReadHIS {

    private String fName, fMod, fTrans;
    private File file;
    private int roots;

    private List<String> stList = new ArrayList<String>();
    private List<String []> stListAr = new ArrayList<String []>();
    private List<CompositeCompound> cmList = new ArrayList<CompositeCompound>();
    private List<Leaf> leafList = new ArrayList<Leaf>();

    private Visit vis = new Visit();

    /**
     * Class Constructor.<br/>
     * @param filename name of the file
     * @param modSpec native spec
     * @param transSpec output format
     * @param filePassed File
     */
    public ReadHIS(String filename, String modSpec, String transSpec, File filePassed) {
        this.fName = filename;
        this.fMod = modSpec;
        this.fTrans = transSpec;
        this.file = filePassed;
    }

    /**
     * Method returns the number of roots added, used mainly for testing.<br/>
     * @return root compounds.
     */
    public int getRootsNumber() {

        return roots;
    }

    /**
     * Method for reading the HIS files.<br/>
     */
    public void readSpec() {
    
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file.getAbsolutePath());
            doc.getDocumentElement().normalize();

            Element rootElement =  doc.getDocumentElement();
  
            NodeList nodes = rootElement.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Project pro = new Project();
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    String pName = null;
                    
                    NamedNodeMap map = ((Element) node).getAttributes();
                    
                    if (map.getLength() > 0) {
                        Node node1 = map.item(0);

                        pName = node1.getNodeValue();
                         
                        pro.setProjectName(pName);
                              
                    }
                    NodeList subNode = node.getChildNodes();

                    for (int j = 0; j < subNode.getLength(); j++) {
                        Node innerNode = subNode.item(j);
                        if (innerNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            String tagname2 = ((Element) innerNode).getTagName();
                     
                            Element xname = (Element) innerNode;
                            NodeList nameElement = xname.getElementsByTagName("name");

                            Element fstNmElmnt = (Element) nameElement.item(0);

                            NodeList fstNm = fstNmElmnt.getChildNodes();

                            String comP = ((Node) fstNm.item(0)).getNodeValue();
           
                            String attributeValue = " ";
               
                            stList.add(comP);


                            if (tagname2.equals("defaultValue")) {

                                Element xname1 = (Element) innerNode;

                                if (xname1.getElementsByTagName("value") != null) {
                                             
                                    System.out.print(" "); 

                                }
                                        

                                NodeList nameElement1 = xname1.getElementsByTagName("value");

                                Element fstNmElmnt1 = (Element) nameElement1.item(0);
                                         

                                if ((Element) nameElement1.item(0) != null) {
                                    System.out.println("");
                                }
                                         

                                if (fstNmElmnt1.getChildNodes() != null) {
                                    System.out.println("");
                                } else {
                                    System.out.println("");
                                }

                                if ((((Node) fstNmElmnt1.getChildNodes().item(0))) != null) {

                                    NodeList fstNm1 = fstNmElmnt1.getChildNodes();
                                       
                                    attributeValue = (((Node) fstNm1.item(0)).getNodeValue()).toString(); 

                                } else {

                                    attributeValue = " ";
                                }

                                String delim = "[.]";

                                stListAr.add(comP.split(delim)); 
                                int leafLength = comP.split(delim).length;
                                String leafName = comP.split(delim)[leafLength - 1];
                                leafList.add(new Leaf(leafName, Datatype.String, attributeValue));
                                       
                                     
                            } else {
                                Element xname1 = (Element) innerNode;
                                NodeList nameElement1 = xname1.getElementsByTagName("expression");

                                Element fstNmElmnt1 = (Element) nameElement1.item(0);
                                NodeList fstNm1 = fstNmElmnt1.getChildNodes();
                                attributeValue = ((Node) fstNm1.item(0)).getNodeValue();

                                String delim = "[.]";

                                stListAr.add(comP.split(delim));

                                int leafLength = comP.split(delim).length;

                                String leafName = comP.split(delim)[leafLength - 1];
                                     
                                leafList.add(new Leaf(leafName, Datatype.String, attributeValue));
                            }
    

                        }

                    }
                        

                    this.addRoots();     
                    this.addCompounds();
                    this.linkCompounds();
                    this.linkLeaves();
                    pro.passCompound(cmList);
               
                    pro.instantiateProject(fTrans);

                }
              

            }
              

        } catch (Exception e) {

            e.printStackTrace();

        }
  
    }

    /**
     * Private Method for adding the root compounds.<br/>
     * @return roots number of roots.
     */
    
    private int addRoots() {
        cmList.add(new CompositeCompound(stListAr.get(0)[0]));
        vis.addCompoundName(stListAr.get(0)[0]);
        for (int r = 1; r < stListAr.size(); r++) {
            String namE = stListAr.get(r)[0];
            if (vis.compoundNameAdded(namE)) {
                System.out.print("");
            } else {
                vis.addCompoundName(namE);
                cmList.add(new CompositeCompound(namE));
            }
            
        }
        this.roots = cmList.size();
        //added roots
        return roots;
    }

    /**
     * Private Method for adding compounds.<br/>
     */
    private void addCompounds() {
        for (int rr = 0; rr < stListAr.size(); rr++) {
            for (int t = 1; t < stListAr.get(rr).length - 1; t++) {
   
                String namE = stListAr.get(rr)[t];
                      
                if (vis.compoundNameAdded(namE)) {
                    System.out.print(" "); 
                } else {
                    vis.addCompoundName(namE);
                    cmList.add(new CompositeCompound(namE));
                }
                      
 
            }
        }
    }

    /**
     * Private Method for linking compounds.<br/>
     */
    private void linkCompounds() {
        for (int rr = 0; rr < stListAr.size(); rr++) {
            for (int t = 1; t < stListAr.get(rr).length - 1; t++) {
                for (int a = 0; a < cmList.size(); a++) {
                    if ((cmList.get(a).getName()).equals(stListAr.get(rr)[t - 1])) { 
                        CompositeCompound compOne = cmList.get(a);           
                        String nameOne =  stListAr.get(rr)[t];
                        if (vis.containsCompound(compOne, nameOne)) {
                            System.out.print(" "); 
                        } else {
                            compOne.add(new CompositeCompound(nameOne));
                        }
                    }
                }
            }
        }
    }

    /**
     * Private Method for linking leaves to their respective compounds.<br/>
     */
    private void linkLeaves() {
        for (int rr = 0; rr < stListAr.size(); rr++) {
            for (int a = 0; a < cmList.size(); a++) {
                int stLn = stListAr.get(rr).length;
                String tempName = stListAr.get(rr)[stLn - 2];
            
                if (cmList.get(a).getName().equals(tempName)) {
                    if (vis.containsLeaf(cmList.get(a), leafList.get(rr))) {
                        System.out.print(" "); 
                    } else {
                        cmList.get(a).add(leafList.get(rr)); 
                    }                                                    
                }
            }               
        }
    }    
}
