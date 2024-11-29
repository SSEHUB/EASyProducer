package net.ssehub.easy.instantiation.java;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.dslCore.DefaultLib;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.SettingsInitializerRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.java.artifacts.ClassFileArtifact;
import net.ssehub.easy.instantiation.java.artifacts.JavaAnnotation;
import net.ssehub.easy.instantiation.java.artifacts.JavaAssignment;
import net.ssehub.easy.instantiation.java.artifacts.JavaAttribute;
import net.ssehub.easy.instantiation.java.artifacts.JavaCall;
import net.ssehub.easy.instantiation.java.artifacts.JavaClass;
import net.ssehub.easy.instantiation.java.artifacts.JavaFileArtifact;
import net.ssehub.easy.instantiation.java.artifacts.JavaImport;
import net.ssehub.easy.instantiation.java.artifacts.JavaMethod;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeAlternative;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeAnnotation;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeAnonymousClass;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeArtifact;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeAssignment;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeAttribute;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeBlock;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeBlockInterface;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeCallElement;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeCastExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeConstructorCall;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeDoLoop;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeElement;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeEnum;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeEnum.JavaCodeEnumConstant;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeExpressionStatement;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeForLoop;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeImport;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeImportScope;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeInitializer;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeJavadocComment;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeLambdaExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeMethod;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeMethodCall;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeParameterSpecification;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodePostfixExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeQualifiableElement;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeReturn;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeStatement;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeStringExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeSwitch;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeVisibility;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeWhileLoop;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeTryBlock;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeTypeSpecification;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeVariableDeclaration;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeVariableExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeSynchronizedBlock;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeTernaryExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeTextExpression;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeThrow;
import net.ssehub.easy.instantiation.java.instantiators.CocktailInstantiator;
import net.ssehub.easy.instantiation.java.instantiators.Jar;
import net.ssehub.easy.instantiation.java.instantiators.Javac;
import net.ssehub.easy.instantiation.java.instantiators.Unjar;

/**
 * Registers the Java additions to VIL.
 * 
 * @author Holger Eichelberger
 */
public class Registration implements IRegistration {

    private static boolean registered = false;
    private static boolean plainRegistered = false;

    /**
     * Registers the Java artifacts and instantiators (without component context).
     */
    public static final void register() {
        register(null);
    }
    
    /**
     * Registers the Java artifacts and instantiators.
     * 
     * @param context the component context.
     */
    public static final void register(ComponentContext context) {
        TypeRegistry.considerDeferredRegistration(() -> {
            if (!registered) {
                registered = true;
                TypeRegistry.DEFAULT.register(Javac.class);
                TypeRegistry.DEFAULT.register(Jar.class);
                TypeRegistry.DEFAULT.register(Unjar.class);

                TypeRegistry.DEFAULT.register(CocktailInstantiator.class);

                // JDT, causes too early access to workspace
                TypeRegistry.DEFAULT.register(ClassFileArtifact.class);
                TypeRegistry.DEFAULT.register(JavaFileArtifact.class);
                TypeRegistry.DEFAULT.register(JavaClass.class);
                TypeRegistry.DEFAULT.register(JavaMethod.class);
                TypeRegistry.DEFAULT.register(JavaAttribute.class);
                TypeRegistry.DEFAULT.register(JavaAnnotation.class);
                TypeRegistry.DEFAULT.register(JavaCall.class);
                TypeRegistry.DEFAULT.register(JavaAssignment.class);
                SettingsInitializerRegistry.register(new JavaSettingsInitializer());
                TypeRegistry.DEFAULT.register(JavaSettings.class);
                TypeRegistry.DEFAULT.register(JavaImport.class);
            }
        });
        
        // plain Java
        if (!plainRegistered) {
            plainRegistered = true;
            registerJavaCodeTypes();
            DefaultLib.appendDefaultLibURLQuietly(Registration.class.getClassLoader(), 
                Bundle.ID, context, "Instantiator.Java");
        }
    }

    /**
     * Registers the Java code (artifact) types.
     */
    private static void registerJavaCodeTypes() {
        TypeRegistry.DEFAULT.register(JavaCodeTypeSpecification.class);
        TypeRegistry.DEFAULT.register(JavaCodeCallElement.class);
        TypeRegistry.DEFAULT.register(JavaCodeElement.class);
        TypeRegistry.DEFAULT.register(JavaCodeStatement.class);
        TypeRegistry.DEFAULT.register(JavaCodeExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeImportScope.class);
        TypeRegistry.DEFAULT.register(JavaCodeVisibility.class);
        TypeRegistry.DEFAULT.register(JavaCodeAnnotation.class);
        TypeRegistry.DEFAULT.register(JavaCodeJavadocComment.class);
        TypeRegistry.DEFAULT.register(JavaCodeArtifact.class);
        TypeRegistry.DEFAULT.register(JavaCodeClass.class);
        TypeRegistry.DEFAULT.register(JavaCodeEnum.class);
        TypeRegistry.DEFAULT.register(JavaCodeEnumConstant.class);
        TypeRegistry.DEFAULT.register(JavaCodeReturn.class);
        TypeRegistry.DEFAULT.register(JavaCodeAttribute.class);
        TypeRegistry.DEFAULT.register(JavaCodeBlockInterface.class);
        TypeRegistry.DEFAULT.register(JavaCodeBlock.class);
        TypeRegistry.DEFAULT.register(JavaCodeInitializer.class);
        TypeRegistry.DEFAULT.register(JavaCodeDoLoop.class);
        TypeRegistry.DEFAULT.register(JavaCodeWhileLoop.class);
        TypeRegistry.DEFAULT.register(JavaCodeForLoop.class);
        TypeRegistry.DEFAULT.register(JavaCodeAlternative.class);
        TypeRegistry.DEFAULT.register(JavaCodeThrow.class);
        TypeRegistry.DEFAULT.register(JavaCodeSwitch.class);
        TypeRegistry.DEFAULT.register(JavaCodeTryBlock.JavaCodeCatchBlock.class);
        TypeRegistry.DEFAULT.register(JavaCodeTryBlock.class);
        TypeRegistry.DEFAULT.register(JavaCodeSynchronizedBlock.class);
        TypeRegistry.DEFAULT.register(JavaCodeAssignment.class);
        TypeRegistry.DEFAULT.register(JavaCodeImport.class);
        TypeRegistry.DEFAULT.register(JavaCodeMethod.class);
        TypeRegistry.DEFAULT.register(JavaCodeQualifiableElement.class);
        TypeRegistry.DEFAULT.register(JavaCodeMethodCall.class);
        TypeRegistry.DEFAULT.register(JavaCodeConstructorCall.class);
        TypeRegistry.DEFAULT.register(JavaCodeAnonymousClass.class);
        TypeRegistry.DEFAULT.register(JavaCodeVariableDeclaration.class);
        TypeRegistry.DEFAULT.register(JavaCodeParameterSpecification.class);
        TypeRegistry.DEFAULT.register(JavaCodeLambdaExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeTextExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeStringExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeVariableExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeTernaryExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeCastExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodePostfixExpression.class);
        TypeRegistry.DEFAULT.register(JavaCodeExpressionStatement.class);
    }
    
    /**
     * OSGi method to activate plugin.
     * 
     * @param context the component context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register(context);
    }

    /**
     * OSGi method to to de-activate plugin.
     * 
     * @param context the component context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
    }

}
