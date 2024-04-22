package net.ssehub.easy.varModel.varModel.testSupport;

import java.io.StringWriter;
import java.lang.reflect.Constructor;

import org.junit.Assert;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;
import net.ssehub.easy.varModel.validation.ValidationMessage;

/**
 * General utilities for writing test cases, using a {@link Project} as basement for testing.
 * 
 * @author El-Sharkawy
 *
 */
public class ProjectTestUtilities {
    
    /**
     * Specification whether the project should be printed out inside the {@link #validateProject(Project)} method.
     * <ul>
     * <li>{@code true}: Project will be printed out.</li>
     * <li>{@code false}: Default run, without printing out the project.</li>
     * </ul>
     */
    private static final boolean DEBUG = false;

    /**
     * Tests whether a project can be used for testing and aborts the whole test execution
     * if the project is not convinced for testing.
     * This method should be applied to projects, which are used inside a test method.
     * This method should be run before the test starts.
     * @param project A project which shall be used inside a test case.
     */
    public static void validateProject(Project project) {
        validateProject(project, DEBUG);
    }
    
    /**
     * Tests whether a project can be used for testing and aborts the whole test execution
     * if the project is not convinced for testing.
     * This method should be applied to projects, which are used inside a test method.
     * This method should be run before the test starts.
     * @param project A project which shall be used inside a test case.
     * @param debug If {@code true} The IVML code of the project will be printed to the console for debugging.
     */
    public static void validateProject(Project project, boolean debug) {
        // Test whether project is sufficient for testing
        if (debug) {
            StringWriter sWriter = new StringWriter();
            IVMLWriter iWriter = new IVMLWriter(sWriter);
            project.accept(iWriter);
            System.out.println(sWriter);
        }
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        if (validator.getErrorCount() > 0) {
            StringBuffer errorMsg = new StringBuffer("Error: Project contains errors:");
            for (int i = 0; i < validator.getMessageCount(); i++) {
                ValidationMessage msg = validator.getMessage(i);
                Status status = msg.getStatus();
                String description = msg.getDescription();
                Object cause = msg.getCause();
                String elemName = cause instanceof IModelElement ? ((IModelElement) cause).getName() : cause.toString();
                
                errorMsg.append("\n");
                errorMsg.append(status.name());
                errorMsg.append(" for element\"");
                errorMsg.append(elemName);
                errorMsg.append("\": ");
                errorMsg.append(description);
            }
            Assert.fail(errorMsg.toString());
        }
    }
    
    /**
     * Creates a custom {@link IDatatype} and adds it to
     * the {@code project} for testing.
     * This method works only for {@link IDatatype} with a constructor with the following parameters:
     * <ul>
     * <li>name : {@link String}</li>
     * <li>basis datatype : {@link IDatatype}</li>
     * <li>parent (project) : {@link IModelElement} or {@link ModelElement}</li>
     * </ul>
     * @param typeClass A custom {@link IDatatype} which shall be created.
     * @param project The parent of the new custom {@link IDatatype}.
     * @return The newly create custom {@link IDatatype}, which will not be <b>null</b>.
     */
    public static IDatatype createCustomDataType(Class<? extends IDatatype> typeClass, Project project) {
        IDatatype type = null;
        Constructor<? extends IDatatype> constructor = null;
        try {
            constructor = typeClass.getConstructor(String.class, IDatatype.class, ModelElement.class);
        } catch (NoSuchMethodException e1) {
            try {
                constructor = typeClass.getConstructor(String.class, IDatatype.class, IModelElement.class);
            } catch (NoSuchMethodException e) {
                Assert.fail(e.getMessage());
            } catch (SecurityException e) {
                Assert.fail(e.getMessage());
            }
        } catch (SecurityException e1) {
            Assert.fail(e1.getMessage());
        }
        try {
            type = constructor.newInstance(typeClass.getSimpleName(), IntegerType.TYPE, project);
            project.add((ContainableModelElement) type);
        } catch (SecurityException e) {
            Assert.fail(e.getMessage());
        } catch (ReflectiveOperationException e) {
            Assert.fail(e.getMessage());
        } catch (IllegalArgumentException e) {
            Assert.fail(e.getMessage());
        }
        Assert.assertNotNull(type);
        return type;
    }
    
    /**
     * Creates a variable for all {@link IDatatype}s and adds it to the given {@link Project}.
     * This can be used if all {@link DecisionVariableDeclaration} or
     * {@link net.ssehub.easy.varModel.confModel.IDecisionVariable}s shall be tested,
     * whether they have the same behavior.
     * These variables will <b>not</b> have a (default) value.
     * @param project A new {@link Project} where the {@link DecisionVariableDeclaration}s, created in this method,
     *      shall be added to.
     * @return The number of created {@link DecisionVariableDeclaration}s, should be used for testing,
     *      whether all {@link DecisionVariableDeclaration}s have been tested.
     */
    public static int createInstancesForAllDatatypes(Project project) {
        int nOfVariables = 0;
        
        // Basis types
        createVar(IntegerType.TYPE, project);
        nOfVariables++;
        createVar(RealType.TYPE, project);
        nOfVariables++;
        createVar(StringType.TYPE, project);
        nOfVariables++;
        createVar(BooleanType.TYPE, project);
        nOfVariables++;
        
        // Custom types
        createCustomDataType(DerivedDatatype.class, project);
        Enum enumType = new Enum("Enum", project, "A", "B");
        project.add(enumType);
        createVar(enumType, project);
        nOfVariables++;
        OrderedEnum oEnumType = new OrderedEnum("OrderedEnum", project);
        oEnumType.add(new EnumLiteral("C", 5, oEnumType));
        project.add(oEnumType);
        createVar(oEnumType, project);
        nOfVariables++;
        createCustomDataType(Sequence.class, project);
        createCustomDataType(Set.class, project);
        Compound cType = new Compound("Compound", project);
        project.add(cType);
        createVar(cType, project);
        nOfVariables++;
        createCustomDataType(Reference.class, project);
        
        return nOfVariables;
    }
    
    /**
     * Creates a variable and adds it to the project.
     * 
     * @param type The type of the variable to create.
     * @param project The Project where the variable shall be added to.
     */
    private static void createVar(IDatatype type, Project project) {
        DecisionVariableDeclaration var = new DecisionVariableDeclaration(type.getName() + "Var", type, project);
        Assert.assertNotNull("Error: Variable of type " + type.getName() + " could not be created.", var);
        project.add(var);
    }
}
