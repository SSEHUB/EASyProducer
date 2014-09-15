package de.uni_hildesheim.sse.buildLanguageTranslation;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Resolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.vilBuildLanguage.RuleDeclaration;

/**
 * Stores (temporary) information about the relation of an ECore and an Rule 
 * model instance.
 * 
 * @author Holger Eichelberger
 */
class RuleInfo {
    
    private RuleDeclaration ruleDecl;
    private Rule rule;
    private RuleDescriptor descriptor;

    /**
     * Creates an information object.
     * 
     * @param ruleDecl the VTL rule declaration from ECore
     * @param rule the related rule model instance
     * @param descriptor the descriptor used to build up <code>rule</code> for registering the variables lateron 
     */
    public RuleInfo(RuleDeclaration ruleDecl, Rule rule, RuleDescriptor descriptor) {
        this.ruleDecl = ruleDecl;
        this.rule = rule;
        this.descriptor = descriptor;
    }
    
    /**
     * Returns the VTL rule declaration from ECore.
     * 
     * @return the VTL rule declaration
     */
    public RuleDeclaration getRuleDeclaration() {
        return ruleDecl;
    }
    
    /**
     * Returns the related VIL rule model instance.
     * 
     * @return the rule instance
     */
    public Rule getRule() {
        return rule;
    }
    
    /**
     * Registers the LHS/RHS variables in <code>resolver</code> if applicable.
     * 
     * @param resolver the resolver instance
     * @throws ExpressionException in case that resolving one of the expressions fails
     * @see RuleDescriptor#registerVariables(Resolver)
     */
    public void registerVariables(Resolver resolver) throws ExpressionException {
        for (int p = 0; p < rule.getParameterCount(); p++) {
            resolver.add(rule.getParameter(p));
        }
        descriptor.registerVariables(resolver);
        rule.setDescriptorInformation(descriptor);
    }
    
}
