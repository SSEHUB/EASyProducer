package de.uni_hildesheim.sse.buildLanguageTranslation;

import org.eclipse.emf.ecore.EObject;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Resolver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleDescriptor;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Stores (temporary) information about the relation of an ECore and an Rule 
 * model instance.
 * 
 * @param <D> the Ecore language declaration type
 * @param <R> the model rule type
 * 
 * @author Holger Eichelberger
 */
public class RuleInfo <D extends EObject, R extends Rule> {
    
    private D ruleDecl;
    private R rule;
    private RuleDescriptor descriptor;

    /**
     * Creates an information object.
     * 
     * @param ruleDecl the VTL rule declaration from ECore
     * @param rule the related rule model instance
     * @param descriptor the descriptor used to build up <code>rule</code> for registering the variables lateron 
     */
    public RuleInfo(D ruleDecl, R rule, RuleDescriptor descriptor) {
        this.ruleDecl = ruleDecl;
        this.rule = rule;
        this.descriptor = descriptor;
    }
    
    /**
     * Returns the VTL rule declaration from ECore.
     * 
     * @return the VTL rule declaration
     */
    public D getRuleDeclaration() {
        return ruleDecl;
    }
    
    /**
     * Returns the related VIL rule model instance.
     * 
     * @return the rule instance
     */
    public R getRule() {
        return rule;
    }
    
    /**
     * Registers the LHS/RHS variables in <code>resolver</code> if applicable.
     * 
     * @param resolver the resolver instance
     * @throws VilException in case that resolving one of the expressions fails
     * @see RuleDescriptor#registerVariables(Resolver)
     */
    public void registerVariables(Resolver resolver) throws VilException {
        for (int p = 0; p < rule.getParameterCount(); p++) {
            resolver.add(rule.getParameter(p));
        }
        descriptor.registerVariables(resolver);
        rule.setDescriptorInformation(descriptor);
    }
    
}
