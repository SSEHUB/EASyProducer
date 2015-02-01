package de.uni_hildesheim.sse.buildLanguageTranslation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.LoadProperties;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage;

/**
 * Implements the translation from the DSL to the build model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends AbstractModelTranslator {

    /**
     * Creates a model translator.
     */
    public ModelTranslator() {
        super();
    }

    /**
     * Creates a build model from a given implementation unit. This is the
     * top-level entry method.
     * 
     * @param unit the language unit to be translated
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @return the corresponding build model
     */
    public List<Script> createModel(ImplementationUnit unit, URI uri, boolean registerSuccessful) {
        ResourceRegistry.register(unit.eResource(), getResolver().getTypeRegistry());
        List<Script> result = new ArrayList<Script>();
        if (null != unit.getScripts()) {
            HashSet<String> names = new HashSet<String>();
            Imports imports = null;
            try {
                imports = processImports(unit.getImports(), unit.getRequires());
            } catch (TranslatorException e) {
                error(e);
            }
            for (de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script : unit.getScripts()) {
                String name = script.getName();
                if (!names.contains(name)) {
                    try {
                        result.add(createScript(script, uri, registerSuccessful, unit.getScripts(), imports));
                        names.add(name);
                    } catch (TranslatorException e) {
                        error(e);
                    }
                } else {
                    error("script '" + name + "' occurs multiple times in the same file", script,
                        ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME, ErrorCodes.NAME_CLASH);
                }
            }
        }
        return result;
    }
    
    /**
     * Creates a script instance from an EMF instance.
     * 
     * @param script the EMF instance to work on
     * @param uri the URI of the project to resolve (in order to find the
     *        closest project, may be <b>null</b>)
     * @param registerSuccessful successfully created models shall be registered
     * @param inProgress the scripts currently being translated
     * @param imports the global imports
     * @return the created script
     * @throws TranslatorException in case that a problem occurred
     */
    private Script createScript(de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit script, URI uri, 
        boolean registerSuccessful, List<de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit> inProgress, 
        Imports imports) throws TranslatorException {
        int errorCount = getErrorCount();
        Advice[] advices = processAdvices(script.getAdvices(), uri);
        VariableDeclaration[] param = resolveParameters(script.getParam());
        ModelImport<Script> parent = null;
        if (null != script.getParent()) {
            parent = getExtensionImport(script.getParent().getName(), imports, script.getParent(), 
                VilBuildLanguagePackage.Literals.SCRIPT_PARENT_DECL__NAME);
        }
        ScriptDescriptor desc = new ScriptDescriptor(param, advices, imports);
        Resolver resolver = getResolver();
        Script result = new Script(script.getName(), parent, desc, resolver.getTypeRegistry());
        resolver.pushModel(result);
        if (null != script.getVersion()) {
            try {
                result.setVersion(new Version(script.getVersion().getVersion()));
            } catch (VersionFormatException e) {
                error(e.getMessage(), script, ExpressionDslPackage.Literals.LANGUAGE_UNIT__VERSION, 
                    ErrorCodes.FORMAT_ERROR);
            }
        }
        if (null != script.getLoadProperties()) {
            for (de.uni_hildesheim.sse.vilBuildLanguage.LoadProperties prop : script.getLoadProperties()) {
                result.addLoadProperties(new LoadProperties(ExpressionTranslator.convertString(prop.getPath())));
            }
        }
        resolveImports(script, ExpressionDslPackage.Literals.LANGUAGE_UNIT__IMPORTS, result, uri, inProgress);
        resolver.enumerateImports(result);
        if (null != script.getContents()) {
            if (null != script.getContents().getElements()) {
                List<de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration> decls = select(
                    script.getContents().getElements(), de.uni_hildesheim.sse.vil.expressions.expressionDsl.VariableDeclaration.class);
                // process variable declarations first
                processVariableDeclarations(decls, result);
                // then rules
                processRules(script, result);
            }
        }
        checkConstants(result, script);
        resolver.popModel();
        if (registerSuccessful && errorCount == getErrorCount()) {
            // required if models in the same file refer to each other
            BuildModel.INSTANCE.updateModel(result, uri, BuildLangModelUtility.INSTANCE);
        }
        return result;
    }

}
