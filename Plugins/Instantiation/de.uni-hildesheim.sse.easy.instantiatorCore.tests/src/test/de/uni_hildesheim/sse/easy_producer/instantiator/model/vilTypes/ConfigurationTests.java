package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.AbstractIvmlVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.NoVariableFilter;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Utils;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.varModel.testSupport.DefaultConfiguration;

/**
 * Performs tests on the configuration wrapper.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTests extends AbstractTest {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    /**
     * Derives the sub-test dir.
     * 
     * @return the sub-test dir
     */
    private static final File cfgTestDataDir() {
        return new File(determineTestDataDir(), "ivml");        
    }
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
        AbstractTest.startUp();
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(cfgTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        try {
            VarModel.INSTANCE.locations().removeLocation(cfgTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace(System.err);
            Assert.assertTrue(false); // shall not happen
        }
    }
    
    /**
     * Tests the configuration wrapper.
     */
    @Test
    public void testConfiguration() {
        net.ssehub.easy.varModel.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
        Assert.assertNotNull("creating default IVML configuration failed", cfg);
        Configuration configuration = new Configuration(cfg);
        Assert.assertNotNull(configuration);
        Project project = cfg.getProject();
        Assert.assertNotNull(project);
        Assert.assertEquals(configuration.getName(), cfg.getName());
        Assert.assertEquals(configuration.getQualifiedName(), project.getQualifiedName());
        Assert.assertEquals(configuration.getType(), project.getType().getName());
        Assert.assertEquals(configuration.getQualifiedType(), project.getType().getQualifiedName());
        TestVisitor visitor = new TestVisitor(cfg, configuration);
        project.accept(visitor);

        try {
            compare(configuration.selectByName("pInt"), cfg, new NameSelector("pInt"));
            compare(configuration.selectByName("p.*"), cfg, new NamePatternSelector("p.*"));
            compare(configuration.selectByName("sse.*"), cfg, new NamePatternSelector("sse.*"));
    
            compare(configuration.selectByType("Boolean"), cfg, new TypeSelector("Boolean"));
            compare(configuration.selectByType("Int.*"), cfg, new TypePatternSelector("Int.*"));
            compare(configuration.selectByType("SSE.*"), cfg, new TypePatternSelector("SSE.*"));
    
            compare(configuration.selectByAttribute("bindingTime"), cfg, new AttributeSelector("bindingTime"));
            compare(configuration.selectByAttribute("bind.*"), cfg, new AttributePatternSelector("bind.*"));
            compare(configuration.selectByAttribute("bla.*"), cfg, new AttributePatternSelector("bla.*"));
    
            // emulate external call
            IvmlElement bindingTime = Utils.getAttributeDeclaration(configuration, "noAttribute");
            Assert.assertNull(bindingTime); // just a x-check
            bindingTime = Utils.getAttributeDeclaration(configuration, "bindingTime");
            Assert.assertNotNull(bindingTime);
            compare(configuration.selectByAttribute(bindingTime.getQualifiedName(), 1), cfg, 
                new AttributeSelector("bindingTime", 1));
            compare(configuration.selectByAttribute(bindingTime.getQualifiedName(), 100), cfg, 
                new AttributeSelector("bindingTime", 100));
            Assert.assertEquals(configuration.selectByAttribute(
                bindingTime.getQualifiedName(), null).variables().size(), 0);
            // the case that the element was not resolved
            Assert.assertEquals(configuration.selectByAttribute(null, 100).variables().size(), 0);
        } catch (VilException e) {
            Assert.fail("unexpected exception " + e.getMessage());
        }
    }
    
    /**
     * Generically tests the variables in <code>configuration</code> against selected variables in <code>cfg</code>.
     * 
     * @param configuration the configuration to be tested
     * @param cfg an IVML configuration providing the actual data
     * @param selector the selector determining the variables to be considered
     */
    private void compare(Configuration configuration, net.ssehub.easy.varModel.confModel.Configuration cfg, 
        IVariableSelector selector) {
        Map<String, IDecisionVariable> reference = new HashMap<String, IDecisionVariable>();
        put(cfg.getProject(), reference, cfg, selector);
        Iterator<DecisionVariable> iter = configuration.variables().iterator();
        while (iter.hasNext()) {
            DecisionVariable var = iter.next();
            IDecisionVariable decVar = reference.get(var.getQualifiedName());
            if (null != decVar) {
                reference.remove(var.getQualifiedName());
            }
        }
        Assert.assertTrue("reference not empty: " + reference, reference.isEmpty());
    }

    /**
     * Puts the variables of project into <code>data</code> if they comply with <code>selector</code>.
     * 
     * @param project the project to be iterated over
     * @param data the data to be modified as a side effect (fqn-instance mapping)
     * @param cfg the underlying IVML configuration
     * @param selector the selector instance
     */
    private void put(Project project, Map<String, IDecisionVariable> data, 
        net.ssehub.easy.varModel.confModel.Configuration cfg, IVariableSelector selector) {
        for (int i = 0; i < project.getImportsCount(); i++) {
            ProjectImport imp = project.getImport(i);
            if (null != imp.getResolved()) {
                put(imp.getResolved(), data, cfg, selector);
            }
        }
        for (int e = 0; e < project.getElementCount(); e++) {
            ContainableModelElement elt = project.getElement(e);
            if (elt instanceof AbstractVariable) {
                IDecisionVariable var = cfg.getDecision((AbstractVariable) elt);
                if (null != var && AssignmentState.FROZEN == var.getState() && selector.select(var)) {
                    data.put(var.getDeclaration().getQualifiedName(), var);
                }
            }
        }
    }
    
    /**
     * Returns a testing IVML configuration instance for the given <code>modelName</code>.
     * 
     * @param modelName the model name
     * @return the configuration
     */
    private static net.ssehub.easy.varModel.confModel.Configuration getConfiguration(String modelName) {
        net.ssehub.easy.varModel.confModel.Configuration config = null;
        List<ModelInfo<net.ssehub.easy.varModel.model.Project>> info = 
            VarModel.INSTANCE.availableModels().getModelInfo(modelName);
        Assert.assertTrue(info.size() > 0);
        try {
            config = new net.ssehub.easy.varModel.confModel.Configuration(VarModel.INSTANCE.load(info.get(0)));
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        return config;
    }
    
    /**
     * Creates a runtime VIL configuration wrapper.
     * 
     * @param cfg the configuration to test
     * @return the configuration wrapper instance
     */
    private static Configuration getRuntimeConfiguration(net.ssehub.easy.varModel.confModel.Configuration cfg) {
        return new Configuration(cfg, NoVariableFilter.INSTANCE);
    }

    /**
     * Asserts an empty change configuration on a non-runtime VIL configuration wrapper.
     * 
     * @param cfg the configuration to test
     */
    private static void assertChangeEmpty(net.ssehub.easy.varModel.confModel.Configuration cfg) {
        assertChangeEmpty(new Configuration(cfg));
    }
    
    /**
     * Asserts an empty change configuration.
     * 
     * @param cfg the configuration to test
     */
    private static void assertChangeEmpty(Configuration cfg) {
        Assert.assertEquals(0, cfg.selectChanged().variables().size());
        Assert.assertEquals(0, cfg.selectChangedWithContext().variables().size());
    }

    /**
     * Tests a simple changed configuration.
     */
    @Test
    public void testSelectChanged1unchanged() {
        net.ssehub.easy.varModel.confModel.Configuration ivml = getConfiguration("context1");
        assertChangeEmpty(ivml); // non-rt cfg has empty changes
        
        Configuration baseCfg = getRuntimeConfiguration(ivml);
        DecisionVariable var = baseCfg.getByName("i2");
        var.setValue(var.getValue()); // effectively the same value - shall not cause a change
        
        assertChangeEmpty(baseCfg);
    }

    /**
     * Tests a simple changed configuration.
     */
    @Test
    public void testSelectChanged1() {
        net.ssehub.easy.varModel.confModel.Configuration ivml = getConfiguration("context1");
        assertChangeEmpty(ivml); // non-rt cfg has empty changes
        
        Configuration baseCfg = getRuntimeConfiguration(ivml);
        DecisionVariable var = baseCfg.getByName("i2");
        Object varValue = var.getValue();
        Assert.assertEquals(var.getOriginalValue(), varValue);
        var.setValue(2); // cause a change
        
        Configuration cfg = baseCfg.selectChanged();
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("i1"));
        Assert.assertNotNull(cfg.getByName("i2"));
        
        cfg = baseCfg.selectChangedWithContext();
        // no real context, shall be the same as selectChanged
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("i1"));
        Assert.assertNotNull(cfg.getByName("i2"));
        
        Assert.assertEquals(var.getOriginalValue(), varValue);
    }

    /**
     * Tests a simple changed compound configuration.
     */
    @Test
    public void testSelectChanged2() {
        net.ssehub.easy.varModel.confModel.Configuration ivml = getConfiguration("context2");
        assertChangeEmpty(ivml); // non-rt cfg has empty changes
        
        Configuration baseCfg = getRuntimeConfiguration(ivml);
        Object origValue = setCompoundVar(baseCfg, "cmp", "i2", 2); // cause a change
        
        Configuration cfg = baseCfg.selectChanged();
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("j"));
        Assert.assertNotNull(cfg.getByName("cmp"));
        Assert.assertNull(getCompoundVar(cfg, "cmp", "i1"));
        Assert.assertNotNull(getCompoundVar(cfg, "cmp", "i2"));
        
        cfg = baseCfg.selectChangedWithContext();
        Assert.assertNull(cfg.getByName("j"));
        Assert.assertNotNull(cfg.getByName("cmp"));
        Assert.assertNotNull(getCompoundVar(cfg, "cmp", "i1")); // in context
        Assert.assertNotNull(getCompoundVar(cfg, "cmp", "i2"));

        Assert.assertEquals(origValue, getCompoundVar(cfg, "cmp", "i2").getOriginalValue());
    }

    /**
     * Tests a simple changed compound sequence configuration.
     */
    @Test
    public void testSelectChanged3() {
        net.ssehub.easy.varModel.confModel.Configuration ivml = getConfiguration("context3");
        assertChangeEmpty(ivml); // non-rt cfg has empty changes
        
        Configuration baseCfg = getRuntimeConfiguration(ivml);
        DecisionVariable seq = baseCfg.getByName("cmpSeq");
        Assert.assertNotNull(seq);
        Sequence<DecisionVariable> vars = seq.variables();
        Assert.assertEquals(2, vars.size());
        vars.at(0).getByName("i2").setValue(2); // cause a change
        
        Configuration cfg = baseCfg.selectChanged();
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("j"));
        seq = cfg.getByName("cmpSeq");
        Assert.assertNotNull(seq);
        vars = seq.variables();
        Assert.assertEquals(1, vars.size());
        Assert.assertNull(vars.at(0).getByName("i1"));
        Assert.assertNotNull(vars.at(0).getByName("i2"));
        
        cfg = baseCfg.selectChangedWithContext();
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("j"));
        seq = cfg.getByName("cmpSeq");
        assertAssignable(net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE, seq);
        Assert.assertNotNull(seq);
        vars = seq.variables();
        Assert.assertEquals(1, vars.size());
        DecisionVariable elt = vars.at(0);
        assertAssignable(Compound.TYPE, elt);
        Assert.assertNotNull(elt.getByName("i1")); // in context
        Assert.assertNotNull(elt.getByName("i2"));
    }

    /**
     * Returns the variable of a compound slot.
     * 
     * @param cfg the configuration
     * @param name the name of the top-level variable
     * @param slot the slot name
     * @return the variable
     */
    private DecisionVariable getCompoundVar(Configuration cfg, String name, String slot) {
        DecisionVariable var = cfg.getByName(name);
        return null == var ? null : var.getByName(slot);
    }
    
    /**
     * Changes the value of a compound slot.
     * 
     * @param cfg the configuration
     * @param name the name of the top-level variable
     * @param slot the slot name
     * @param value the new value
     * @return the value before
     */
    private Object setCompoundVar(Configuration cfg, String name, String slot, Object value) {
        DecisionVariable var = getCompoundVar(cfg, name, slot);
        Object result = var.getValue();
        var.setValue(value);
        return result;
    }
    
    /**
     * Tests a simple changed compound reference configuration.
     */
    @Test
    public void testSelectChanged4() {
        net.ssehub.easy.varModel.confModel.Configuration ivml = getConfiguration("context4");
        assertChangeEmpty(ivml); // non-rt cfg has empty changes
        
        Configuration baseCfg = getRuntimeConfiguration(ivml);
        Object origValue = setCompoundVar(baseCfg, "cmp1", "i2", 2); // cause a change
        
        Configuration cfg = baseCfg.selectChanged();
        Assert.assertEquals(1, cfg.variables().size());
        Assert.assertNull(cfg.getByName("j"));
        Assert.assertNull(cfg.getByName("cmpSeq"));
        Assert.assertNotNull(cfg.getByName("cmp1"));
        Assert.assertNull(cfg.getByName("cmp2"));
        Assert.assertNull(getCompoundVar(cfg, "cmp1", "i1"));
        Assert.assertNotNull(getCompoundVar(cfg, "cmp1", "i2"));
        
        cfg = baseCfg.selectChangedWithContext();
        Assert.assertEquals(2, cfg.variables().size());
        Assert.assertNull(cfg.getByName("j"));
        Assert.assertNull(cfg.getByName("cmp2"));
        Assert.assertNotNull(cfg.getByName("cmp1"));
        Assert.assertNotNull(getCompoundVar(cfg, "cmp1", "i1")); // in context
        Assert.assertNotNull(getCompoundVar(cfg, "cmp1", "i2")); 
        DecisionVariable seq = cfg.getByName("cmpSeq");
        assertAssignable(net.ssehub.easy.varModel.model.datatypes.Sequence.TYPE, seq);
        Assert.assertNotNull(seq);
        Sequence<DecisionVariable> vars = seq.variables();
        Assert.assertEquals(1, vars.size());
        DecisionVariable elt = vars.at(0);
        assertAssignable(Reference.TYPE, elt);
        Assert.assertNotNull(vars.at(0).getByName("i1"));
        Assert.assertNotNull(vars.at(0).getByName("i2"));
        
        Assert.assertEquals(origValue, getCompoundVar(baseCfg, "cmp1", "i2").getOriginalValue());
    }
    
    /**
     * Asserts that the type of <code>var</code> is assignable to <code>type</code>.
     * 
     * @param type the type defining the required base type
     * @param var the variable to check
     */
    private static void assertAssignable(IDatatype type, AbstractIvmlVariable var) {
        Assert.assertTrue(type.isAssignableFrom(var.getVariable().getDeclaration().getType()));
    }

    /**
     * Prints a sequence and its values (debugging).
     *  
     * @param seq the sequence
     */
    private void println(Sequence<DecisionVariable> seq) {
        System.out.print("{");
        for (int i = 0; i < seq.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            DecisionVariable dv = seq.at(i);
            System.out.print(dv.getName() + " (" + dv.getQualifiedName() + ") = " + dv.getValue());
        }
        System.out.println("}");
    }
    
    /**
     * Prints a configuration and its values (debugging).
     *  
     * @param cfg the configuration
     */
    @SuppressWarnings("unused")
    private void println(Configuration cfg) {
        Sequence<DecisionVariable> seq = cfg.variables();
        System.out.print("cfg " + cfg.getName() + " = ");
        println(seq);
    }

}
