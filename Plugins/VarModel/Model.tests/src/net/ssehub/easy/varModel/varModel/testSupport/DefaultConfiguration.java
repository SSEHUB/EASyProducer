package net.ssehub.easy.varModel.varModel.testSupport;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.confModel.AllFreezeSelector;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * Provides a default configured IVML configuration for testing. The related model contains all
 * basic types including boolean, real, integer, string and enum, as well as a compound and a 
 * related sequence.
 * 
 * @author Holger Eichelberger
 */
public class DefaultConfiguration {
    
    private Project impProject;
    private Project project;
    private Configuration configuration;
    
    // individual variables for impProject
    private DecisionVariableDeclaration iInt;
    // compound type
    private net.ssehub.easy.varModel.model.datatypes.Enum enm;
    private Compound comp;
    private Sequence seq;
    // individual variables for project (pc -> pComp)
    private DecisionVariableDeclaration pInt;
    private DecisionVariableDeclaration pString;
    private DecisionVariableDeclaration pReal;
    private DecisionVariableDeclaration pBoolean;
    private DecisionVariableDeclaration pBooleanUF;
    private DecisionVariableDeclaration pEnum;
    private DecisionVariableDeclaration pComp;
    private DecisionVariableDeclaration pcInt;
    private DecisionVariableDeclaration pcString;
    private DecisionVariableDeclaration pCompSeq;

    /**
     * Prevents external creation.
     */
    private DefaultConfiguration() {
    }
    
    /**
     * Creates the actual configuration instance.
     * 
     * @return the configuration instance (may be <b>null</b>) if the configuration failed for some reason
     */
    private Configuration createConfiguration() {
        try {
            createImportProject();
            createProject();
            IvmlValidationVisitor validationVisitor = new IvmlValidationVisitor();
            project.accept(validationVisitor);
            if (0 == validationVisitor.getErrorCount()) {
                configure();
            } else {
                configuration = null;
            }
        } catch (ModelManagementException e) {
            e.printStackTrace();
            configuration = null;
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
            configuration = null;
        } catch (ConfigurationException e) {
            e.printStackTrace();
            configuration = null;
        }
        return configuration;
    }

    /**
     * Creates the project to be imported.
     */
    private void createImportProject() {
        impProject = new Project("import");
        impProject.setVersion(new Version(0, 9));
        iInt = new DecisionVariableDeclaration("iInt", IntegerType.TYPE, impProject);
        impProject.add(iInt);
    }
    
    /**
     * Creates the main project.
     * 
     * @throws ModelManagementException in case of "resolving" the imported project fails
     */
    private void createProject() throws ModelManagementException {
        project = new Project("test");
        project.setVersion(new Version(1, 0));
        ProjectImport imp = new ProjectImport("imported", null);
        imp.setResolved(impProject);
        project.addImport(imp);

        project.attribute(new net.ssehub.easy.varModel.model.Attribute("bindingTime", 
            IntegerType.TYPE, project, project)); // just to simplify the process
        
        pInt = new DecisionVariableDeclaration("pInt", IntegerType.TYPE, project);
        project.add(pInt);
        pString = new DecisionVariableDeclaration("pString", StringType.TYPE, project);
        project.add(pString);
        pReal = new DecisionVariableDeclaration("pReal", RealType.TYPE, project);
        project.add(pReal);
        pBoolean = new DecisionVariableDeclaration("pBoolean", BooleanType.TYPE, project);
        project.add(pBoolean);
        pBooleanUF = new DecisionVariableDeclaration("pBooleanUnfrozen", BooleanType.TYPE, project);
        project.add(pBooleanUF);
        enm = new net.ssehub.easy.varModel.model.datatypes.Enum("pEnumeration", impProject, 
            "val1", "val2", "val3");
        impProject.add(enm);
        pEnum = new DecisionVariableDeclaration("pEnum", enm, project);
        project.add(pEnum);
        
        comp = new Compound("pCompound", project);
        pcInt = new DecisionVariableDeclaration("pcInt", IntegerType.TYPE, comp);
        comp.add(pcInt);
        pcString = new DecisionVariableDeclaration("pcString", StringType.TYPE, comp);
        comp.add(pcString);
        project.add(comp);
        pComp = new DecisionVariableDeclaration("pComp", comp, project);
        project.add(pComp);
        seq = new Sequence("pCompoundSequence", comp, project);
        pCompSeq = new DecisionVariableDeclaration("pCompSeq", seq, project);
        project.add(pCompSeq);
    }
    
    /**
     * Configures the entire project.
     * 
     * @throws ConfigurationException in case of further type mismatches during configuration
     * @throws ValueDoesNotMatchTypeException if the value cannot be assigned due to type mismatch
     */
    private void configure() throws ConfigurationException, ValueDoesNotMatchTypeException {
        configuration = new Configuration(project);
        configure(iInt, -1);
        configure(pInt, 0);
        configure(pString, "Hello");
        configure(pReal, "1.23");
        configure(pBoolean, true);
        configure(pBooleanUF, true, false); // not frozen!
        configure(pEnum, "val2");
        Object[] pCompValues1 = {"pcInt", createValue(pcInt, 10), "pcString", createValue(pcString, "inst1")};
        Value pCompVal1 = ValueFactory.createValue(comp, pCompValues1);
        Object[] pCompValues2 = {"pcInt", createValue(pcInt, 11), "pcString", createValue(pcString, "inst2")};
        Value pCompVal2 = ValueFactory.createValue(comp, pCompValues2);
        configure(pComp, pCompVal1);
        Object[] pCompSeqValues = {pCompVal1, pCompVal2};
        configure(pCompSeq, pCompSeqValues);
    }        

    /**
     * Creates a default IVML configuration for testing.
     * 
     * @return a default configuration
     */
    public static final Configuration createDefaultConfiguration() {
        return new DefaultConfiguration().createConfiguration();
    }

    /**
     * Configures <code>var</code> in <code>config</code> with <code>value</code> and freezes <code>var</code>.
     * 
     * @param var the variable (in <code>config</code>)
     * @param value the actual value
     * @throws ValueDoesNotMatchTypeException if the value cannot be assigned due to type mismatch
     * @throws ConfigurationException in case of further type mismatches during configuration
     */
    private void configure(DecisionVariableDeclaration var, Object value) 
        throws ValueDoesNotMatchTypeException, ConfigurationException {
        configure(var, value, true);
    }

    /**
     * Configures <code>var</code> in <code>config</code> with <code>value</code> with given assignment 
     * <code>state</code>.
     * 
     * @param var the variable (in <code>config</code>)
     * @param value the actual value
     * @param freeze freeze the variable?
     * @throws ValueDoesNotMatchTypeException if the value cannot be assigned due to type mismatch
     * @throws ConfigurationException in case of further type mismatches during configuration
     */
    private void configure(DecisionVariableDeclaration var, Object value, 
        boolean freeze) throws ValueDoesNotMatchTypeException, ConfigurationException {
        IDecisionVariable decVar = configuration.getDecision(var);
        decVar.setValue(createValue(var, value), AssignmentState.ASSIGNED);
        for (int a = 0; a < decVar.getAttributesCount(); a++) {
            IDecisionVariable attr = decVar.getAttribute(a);
            if (attr.getDeclaration().getName().equals("bindingTime")) {
                attr.setValue(ValueFactory.createValue(IntegerType.TYPE, 100), AssignmentState.FROZEN);
            }
        }
        if (freeze) {
            decVar.freeze(AllFreezeSelector.INSTANCE);
        }
    }

    /**
     * Creates a type-compliant value for the given decision variable <code>var</code>.
     * 
     * @param var the variable
     * @param value the actual value
     * @return the resulting value instance
     * @throws ValueDoesNotMatchTypeException if the value cannot be created due to type mismatch
     */
    private static Value createValue(DecisionVariableDeclaration var, Object value) 
        throws ValueDoesNotMatchTypeException {
        Value result;
        if (value.getClass().isArray()) {
            result = ValueFactory.createValue(var.getType(), (Object[]) value);
        } else {
            result = ValueFactory.createValue(var.getType(), value);
        }
        return result;
    }

}
