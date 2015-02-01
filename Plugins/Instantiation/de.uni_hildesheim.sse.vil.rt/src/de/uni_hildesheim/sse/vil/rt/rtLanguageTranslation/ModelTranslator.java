package de.uni_hildesheim.sse.vil.rt.rtLanguageTranslation;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Imports;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.vil.expressions.ResourceRegistry;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.ExpressionDslPackage;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;

/**
 * Implements the translation from the DSL to the adaptation language model in the instantiator core.
 * 
 * @author Holger Eichelberger
 */
public class ModelTranslator extends de.uni_hildesheim.sse.buildLanguageTranslation.AbstractModelTranslator {

    /**
     * Creates a model translator.
     */
    public ModelTranslator() {
        super(new ExpressionTranslator(), new Resolver(new TypeRegistry(TypeRegistry.DEFAULT)));
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
        // TODO implement and unify with VIL
        return new Script(script.getName());
    }
    
}
