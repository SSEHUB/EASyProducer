package net.ssehub.easy.reasoning.drools2.translation;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.drools2.DroolsReasonerDescriptor;
import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.reasoning.drools2.translation.ModelTranslator;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Tests the {@link ModelTranslator}.
 * @author El-Sharkawy
 *
 */
public class ModelTranslatorTest extends AbstractTransformationTest {
    
    private static final EASyLogger LOGGER =
        EASyLoggerFactory.INSTANCE.getLogger(ModelTranslatorTest.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    /**
     * Tests whether a simple project can be translated.
     * This method creates a project with one constraint in the form of "intA greater than 2" and translates it into
     * drools specific code.
     * @throws ValueDoesNotMatchTypeException Should not occur, otherwise there is an error inside the
     *     {@link net.ssehub.easy.varModel.model.values.ValueFactory}
     * @throws CSTSemanticException Should not occur, otherwise there is an error inside the
     *     {@link Constraint#setConsSyntax(de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree)) method.
     * @throws ConfigurationException Should not occur, otherwise there is an error inside the
     *     {@link IDecisionVariable#setValue(Value, de.uni_hildesheim.sse.model.confModel.IAssignmentState))) method.
     */
    @Test
    public void testSimpleConstraintTranslation()
        throws ValueDoesNotMatchTypeException, CSTSemanticException, ConfigurationException {
        
        String decisionName = "intA";
        int number = 2;
        Object[] result = createModelWithSimpleConstraint(decisionName, number);
        ReasonerModel rModel = (ReasonerModel) result[0];
        StringWriter sWriter = new StringWriter();
        ModelTranslator translator = new ModelTranslator(rModel, sWriter, rModel.getProject().getName(),
                ReasoningOperation.VALIDATION);
        
        Assert.assertFalse(translator.hasErrors());
        String translatedModel = sWriter.toString();
        String translatedConstraint = decisionName + ".getValue() > " + number;
        LOGGER.debug("\n" + translatedModel);
        Assert.assertTrue(translatedModel.contains(translatedConstraint));
    }
    
    /**
     * Tests whether compounds are translated correctly.
     * This test does not consider nested compounds, constraints, and attribute assignments.
     */
    @Test
    public void testCompoundTranslation() {
        Project project = new Project("a_project");
        Compound cmpType = new Compound("CType", project);
        DecisionVariableDeclaration nestVar1 = new DecisionVariableDeclaration("nestedVar1", IntegerType.TYPE, cmpType);
        DecisionVariableDeclaration nestVar2 = new DecisionVariableDeclaration("nestedVar2", IntegerType.TYPE, cmpType);
        cmpType.add(nestVar1);
        cmpType.add(nestVar2);
        project.add(cmpType);
        DecisionVariableDeclaration cmp1 = new DecisionVariableDeclaration("cmp1", cmpType, project);
        DecisionVariableDeclaration cmp2 = new DecisionVariableDeclaration("cmp2", cmpType, project);
        project.add(cmp1);
        project.add(cmp2);
        checkProject(project);
        
        Configuration config = new Configuration(project);
        ReasonerModel model = new ReasonerModel(config, null);
        StringWriter sWriter = new StringWriter();
        ModelTranslator translator = new ModelTranslator(model, sWriter, model.getProject().getName(),
                ReasoningOperation.VALIDATION);
        
        Assert.assertFalse(translator.hasErrors());
        String translatedModel = sWriter.toString();
        LOGGER.debug("\n" + translatedModel);
    }

}
