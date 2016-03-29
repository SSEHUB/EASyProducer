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
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script.ScriptDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;
import de.uni_hildesheim.sse.vilBuildLanguage.LanguageUnit;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;

/**
 * Implements the translation from the DSL to the build model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends AbstractModelTranslator<Script, LanguageUnit> {

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
    public List<Script> createModel(ImplementationUnit unit, URI uri, boolean registerSuccessful, 
        ImportResolver<Script> impResolver) {
        ResourceRegistry.register(unit.eResource(), getResolver().getTypeRegistry());
        List<Script> result = new ArrayList<Script>();
        if (null != unit.getScripts()) {
            HashSet<String> names = new HashSet<String>();
            Imports<Script> imports = null;
            try {
                imports = processImports(unit.getImports(), unit.getRequires());
            } catch (TranslatorException e) {
                error(e);
            }
            for (LanguageUnit script : unit.getScripts()) {
                String name = script.getName();
                if (!names.contains(name)) {
                    try {
                        result.add(createScript(script, uri, registerSuccessful, unit.getScripts(), imports, 
                            impResolver));
                        names.add(name);
                    } catch (TranslatorException e) {
                        error(e);
                    }
                } else {
                    error("script '" + name + "' occurs multiple times in the same file", script,
                        ExpressionDslPackage.Literals.LANGUAGE_UNIT__NAME, ErrorCodes.NAME_CLASH);
                }
            }
            getExpressionTranslator().enactIvmlWarnings();
        }
        return result;
    }
    
    /**
     * Creates a script instance.
     * 
     * @param name Name of the project.
     * @param parent the super script to inherit from (as a script import, may be <b>null</b>, shall be member of 
     *     <code>imports</code> or also <b>null</b>)
     * @param descriptor the descriptor carrying parameters, advices and imports (may be <b>null</b>)
     * @param registry the responsible type registry 
     */
    @Override
    protected Script createScript(String name, ModelImport<Script> parent, ScriptDescriptor<Script> descriptor, 
        TypeRegistry registry) {
        return new Script(name, parent, descriptor, registry);
    }
    
    @Override
    protected ModelManagement<Script> getManagementInstance() {
        return BuildModel.INSTANCE;
    }
    
    @Override
    protected IModelLoader<Script> getModelLoader() {
        return BuildLangModelUtility.INSTANCE;
    }

}
