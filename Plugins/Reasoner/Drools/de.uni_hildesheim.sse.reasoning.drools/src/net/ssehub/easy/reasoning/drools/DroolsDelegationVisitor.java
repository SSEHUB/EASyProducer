package net.ssehub.easy.reasoning.drools;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.datatypes.Compound;

/**
 * Class to perform writing drools contents to file.
 * @author saripalli
 *
 */
class DroolsDelegationVisitor {
    
    private EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");
    
    /**
     * Method that generates a rule for the freeze block.
     * @param freeze free block.
     * @param ruleCount rule number.
     * @param importedProjectName imported project name.
     * @return returns the rule for the freeze block.
     */
    public String getRuleForFreezeBlock(FreezeBlock freeze, int ruleCount, String importedProjectName) {
        StringBuffer sbuffer = new StringBuffer();

        
        sbuffer.append("rule " + "\"" + ruleCount + "\"" + "\n");
        sbuffer.append("agenda-group " + "\"" + "Group 0" + importedProjectName + "\"" + "\n");
        sbuffer.append("lock-on-active true" + "\n");
        sbuffer.append("no-loop true" + "\n");
        sbuffer.append("dialect " + "\"" + "mvel" + "\"" + "\n");
        sbuffer.append("\n" + "when" + "\n" + "P0 : Project0()" + "\n" + "then");
        
        for (int i = 0; i < freeze.getFreezableCount(); i++) {
            if (freeze.getFreezable(i).getType() instanceof Compound) {
                String frozenVarname = freeze.getFreezable(i).getName();
                Compound compound = (Compound) freeze.getFreezable(i).getType();
                for (int j = 0; j < compound.getElementCount(); j++) {
                    String fListToAdd = "\nfList.add(" + "\"" 
                            + frozenVarname + "." + compound.getElement(j).getName() + "\"" + ");";
                    sbuffer.append(fListToAdd);
                }
            }
                
            sbuffer.append("\n" + "fList.add(" + "\"" + freeze.getFreezable(i).getName() + "\"" + ");");
            sbuffer.append("modify(P0){};");
        }
        sbuffer.append("\n" + "end");
        return sbuffer.toString();
    }
    
    /**
     * Method to write the project class.
     * @param dPrinter printer object.
     * @param decisionVariables list containing decision variables (names).
     */
    public void addProjectClass(DroolsPrinter dPrinter, List<String> decisionVariables) {
        
        String toPrint = "declare Project" + "\n"  + DroolsVisitor.TYPESAFE + "\n\t";
        toPrint += "Proj_drools : String \n";
        String newPrint = "";
        newPrint += "declare Project0" + "\n"  + DroolsVisitor.TYPESAFE + "\n\t";
        logger.info("TOTAL ELEMENTS in the PROJECT " + decisionVariables.size());
        for (int i = 0; i < decisionVariables.size(); i++) {
            int qo1 = i / DroolsVisitor.THRESHOLD;
            int qo2 = (i - 1) / DroolsVisitor.THRESHOLD;
            if (qo1 != qo2) {
                newPrint += "end\n";
                newPrint += "declare Project" + qo1 + "\n"  + DroolsVisitor.TYPESAFE + "\n";
            } 
            newPrint += "\t" + decisionVariables.get(i);
        }
        newPrint += "end\n\n";
        
        toPrint += "\n";
        toPrint += "end\n";
        dPrinter.append(toPrint);
        dPrinter.append(newPrint);
    }
    
    /**
     * Adding globals, initial functions in Drools.
     * @param name name of the project.
     * @param dPrinter printer object.
     */
    public void addDroolsGlobals(String name, DroolsPrinter dPrinter) {
        dPrinter.openProject(name);
        String functionImports = "import function net.ssehub.easy.reasoning.drools.functions.IVMLFunctions.*\n";
        dPrinter.append(functionImports);
        String isDefinedFunction = "function boolean isDefined(Object o) { \n"
                    + "\t" + "return o != null;"
                    + "\t\t" + "\n}";
        dPrinter.append("\n" + isDefinedFunction);
        String tempFunc = "function boolean rTrue(java.util.ArrayList dList) { \n"
                + "\t" + "System.out.println(\"dlist... is \" + dList);\n"
                + "\t" + "return true;"
                + "\t\t" + "\n}";
        dPrinter.append("\n" + tempFunc);
        String cList = "global java.util.ArrayList cList";
        dPrinter.append(cList);
        String aList = "global java.util.ArrayList aList";
        dPrinter.append(aList);
        String dList = "global java.util.ArrayList dList";
        dPrinter.append(dList);
        String vList = "global java.util.ArrayList vList";
        dPrinter.append(vList);
        String fList = "global java.util.ArrayList fList";
        dPrinter.append(fList);
        
        
        String impliesFunction = "function boolean implies(boolean a, boolean b) { \n"
                + "return (!a || b);" + "\n }";
        dPrinter.append(impliesFunction);
        
        String definedFunction = "function boolean ivmlDef(java.util.ArrayList dList, String s) { \n"
                + "return dList.contains(s);" + "\n }";
        dPrinter.append(definedFunction);
    }
    
    /**
     * Method to add rules to Drools.
     * @param dPrinter Printer object.
     * @param assgnConstraints List containing assignment rules.
     * @param hardConstraints List containing constraint chekcing rules.
     */
    public void addRules(DroolsPrinter dPrinter, List<String> assgnConstraints, List<String>hardConstraints) {
        int total = 0;
        
        for (int i = assgnConstraints.size() - 1; i >= 0; i--) {
            if (!assgnConstraints.get(i).equals("")) {
                dPrinter.append(assgnConstraints.get(i));
                total++;
            }
        }
        
        for (int i = 0; i < hardConstraints.size(); i++) {
            if (!hardConstraints.get(i).equals("")) {
                dPrinter.append(hardConstraints.get(i));
                total++;
            }
        }
        
        logger.info("Total Drools Rules " + total);
    }

}
