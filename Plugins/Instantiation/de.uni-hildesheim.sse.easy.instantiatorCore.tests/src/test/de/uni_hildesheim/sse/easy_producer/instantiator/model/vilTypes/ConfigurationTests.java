package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Utils;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.varModel.testSupport.DefaultConfiguration;

/**
 * Performs tests on the configuration wrapper.
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTests {

    /**
     * Tests the configuration wrapper.
     */
    @Test
    public void testConfiguration() {
        de.uni_hildesheim.sse.model.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
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
    private void compare(Configuration configuration, de.uni_hildesheim.sse.model.confModel.Configuration cfg, 
        IVariableSelector selector) {
        Map<String, IDecisionVariable> reference = new HashMap<String, IDecisionVariable>();
        put(cfg.getProject(), reference, cfg, selector);
        Iterator<DecisionVariable> iter = configuration.variables().iterator();
        while (iter.hasNext()) {
            DecisionVariable var = iter.next();
            IDecisionVariable decVar = reference.get(var.getQualifiedName());
            Assert.assertNotNull(decVar);
            reference.remove(var.getQualifiedName());
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
        de.uni_hildesheim.sse.model.confModel.Configuration cfg, IVariableSelector selector) {
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

}
