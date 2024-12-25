package net.ssehub.easy.instantiation.python;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeAlternative;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeArtifact;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeAssert;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeAssign;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeBlock;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeClass;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeConstructorCall;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeDecorator;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeDelete;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeDocComment;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeElement;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeEnum;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeExpr;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeFnCall;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeForLoop;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeFunction;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeGlobal;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeImport;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeImportScope;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeLambdaExpr;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeMatch;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeNonLocal;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeParamSpec;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeRaise;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeSingleLineComment;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeStmt;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeText;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeTryBlock;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeTypeAlias;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeWhileLoop;
import net.ssehub.easy.instantiation.python.codeArtifacts.PythonCodeWith;

/**
 * Registers the Python additions to VIL.
 * 
 * @author Kevin Schaperjahn
 */
public class Registration implements IRegistration {
    private static boolean registered = false;

    /**
     * Registers the Python artifacts and instantiators (without component context).
     */
    public static final void register() {
        if (!registered) {
            registered = true;

            TypeRegistry.DEFAULT.register(PythonCodeDocComment.class);
            TypeRegistry.DEFAULT.register(PythonCodeArtifact.class);
            TypeRegistry.DEFAULT.register(PythonCodeElement.class);
            TypeRegistry.DEFAULT.register(PythonCodeFunction.class);
            TypeRegistry.DEFAULT.register(PythonCodeDecorator.class);
            TypeRegistry.DEFAULT.register(PythonCodeParamSpec.class);
            TypeRegistry.DEFAULT.register(PythonCodeBlock.class);
            TypeRegistry.DEFAULT.register(PythonCodeExpr.class);
            TypeRegistry.DEFAULT.register(PythonCodeStmt.class);
            TypeRegistry.DEFAULT.register(PythonCodeText.class);
            TypeRegistry.DEFAULT.register(PythonCodeClass.class);
            TypeRegistry.DEFAULT.register(PythonCodeEnum.class);
            TypeRegistry.DEFAULT.register(PythonCodeImport.class);
            TypeRegistry.DEFAULT.register(PythonCodeAssign.class);
            TypeRegistry.DEFAULT.register(PythonCodeWhileLoop.class);
            TypeRegistry.DEFAULT.register(PythonCodeForLoop.class);
            TypeRegistry.DEFAULT.register(PythonCodeAlternative.class);
            TypeRegistry.DEFAULT.register(PythonCodeFnCall.class);
            TypeRegistry.DEFAULT.register(PythonCodeConstructorCall.class);
            TypeRegistry.DEFAULT.register(PythonCodeLambdaExpr.class);
            TypeRegistry.DEFAULT.register(PythonCodeSingleLineComment.class);
            TypeRegistry.DEFAULT.register(PythonCodeGlobal.class);
            TypeRegistry.DEFAULT.register(PythonCodeNonLocal.class);
            TypeRegistry.DEFAULT.register(PythonCodeDelete.class);
            TypeRegistry.DEFAULT.register(PythonCodeMatch.class);
            TypeRegistry.DEFAULT.register(PythonCodeTryBlock.class);
            TypeRegistry.DEFAULT.register(PythonCodeRaise.class);
            TypeRegistry.DEFAULT.register(PythonCodeAssert.class);
            TypeRegistry.DEFAULT.register(PythonCodeWith.class);
            TypeRegistry.DEFAULT.register(PythonCodeTypeAlias.class);

            TypeRegistry.DEFAULT.register(PythonCodeImportScope.class);
        }
    }

    /**
     * OSGi method to activate plugin.
     * 
     * @param context the component context.
     */
    protected void activate(ComponentContext context) {
        register();
    }

    /**
     * OSGi method to to de-activate plugin.
     * 
     * @param context the component context.
     */
    protected void deactivate(ComponentContext context) {
    }
    
}
