/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ContainerVariable;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cstEvaluation.FreezeEvaluator;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Copies specified variable values, i.e., single variables to a single variable or a compatible container or a 
 * container to a container. In case of a container as source, the first value will be copied. 
 * May create further variables in case of target reference types. Actually, this functionality might be done by
 * a more generic VIL function, but for now a simpler (internal) implementation is sufficient.
 * 
 * @author Holger Eichelberger
 */
public class VariableValueCopier {
    
    private Map<IDatatype, Map<String, CopySpec>> specs = new HashMap<IDatatype, Map<String, CopySpec>>();
    private String namePrefix;
    private int count;
    private IAssignmentState newState;
    private IAssignmentListener listener;

    /**
     * An interface providing information to create freeze blocks for new variables.
     * @author Holger Eichelberger
     *
     */
    public interface IFreezeProvider {
        
        /**
         * The name of the freeze variable.
         * 
         * @return the name
         */
        public String getFreezeVariableName();
        
        /**
         * Creates the freeze-but expression.
         * 
         * @param freezeIter the freeze iterator variable (of type {@link FreezeVariableType})
         * @return the but-expression
         * @throws CSTSemanticException in case that the but-expression was not constructed correctly
         * @throws ValueDoesNotMatchTypeException in case that creating values fails
         */
        public ConstraintSyntaxTree createButExpression(DecisionVariableDeclaration freezeIter) 
            throws CSTSemanticException, ValueDoesNotMatchTypeException;
        
    }

    /**
     * Optional listener interface to generically track primary value assignments.
     * 
     * @author Holger Eichelberger
     */
    public interface IAssignmentListener {

        /**
         * Notifies about assigned values.
         * 
         * @param target the target variable
         * @param value the new value
         * @param added whether value is being added to a collection or set as the single absolute value
         */
        public void notifyAssigned(IDecisionVariable target, Value value, boolean added);
        
        /**
         * Notifies the listener about a new variable created for a given origin variable. A 
         * {@link #notifyAssigned(IDecisionVariable, Value, boolean)} shall follow.
         * 
         * @param origin the origin variable
         * @param target the new variable
         */
        public void notifyCreated(IDecisionVariable origin, IDecisionVariable target);
        
    }
    
    /**
     * A default freeze provider for but-expressions based on attributes of type enum.
     * 
     * @author Holger Eichelberger
     */
    public static class EnumAttributeFreezeProvider implements IFreezeProvider {

        private String name;
        private String operation;
        private Attribute annotation;
        private EnumLiteral literal;
        
        /**
         * Creates a but-freeze provider for expressions of the form <i><code>name</code> | 
         *     <code>name</code>.<code>annotation</code> == <code>literal</code></i>
         *     
         * @param name the name of the freeze variable
         * @param annotation the annotation on <code>name</code> (providing annotation name and type)
         * @param literal the literal to test for
         */
        public EnumAttributeFreezeProvider(String name, Attribute annotation, EnumLiteral literal) {
            this(name, annotation, OclKeyWords.EQUALS, literal);
        }

        /**
         * Creates a but-freeze provider for expressions of the form <i><code>name</code> | 
         *     <code>name</code>.<code>annotation</code> <code>operation</code> <code>literal</code></i>
         *     
         * @param name the name of the freeze variable
         * @param annotation the annotation on <code>name</code> (providing annotation name and type)
         * @param operation the operation to be applied
         * @param literal the literal to test for
         */
        public EnumAttributeFreezeProvider(String name, Attribute annotation, String operation, EnumLiteral literal) {
            this.name = name;
            this.operation = operation;
            this.annotation = annotation;
            this.literal = literal;
        }

        @Override
        public String getFreezeVariableName() {
            return name;
        }
        
        /**
         * Finds a declaration for the attribute <code>name</code> in <code>prj</code> or it's imports.
         * 
         * @param prj the project to search for
         * @param name the name of the attribute
         * @param done the already processed projects (cycle detection)
         * @return the found attribute (may be <b>null</b>)
         */
        private Attribute findAttribute(Project prj, String name, Set<Project> done) {
            Attribute result = null;
            if (!done.contains(prj)) {
                done.add(prj);
                result = prj.getAttribute(name);
                for (int i = 0; null == result && i < prj.getImportsCount(); i++) {
                    Project p = prj.getImport(i).getResolved();
                    if (null != p) {
                        result = findAttribute(p, name, done);
                    }
                }
            }
            return result;
        }

        @Override
        public ConstraintSyntaxTree createButExpression(DecisionVariableDeclaration freezeIter) 
            throws CSTSemanticException, ValueDoesNotMatchTypeException {
            ConstraintSyntaxTree selector = null;
            FreezeVariableType iterType = (FreezeVariableType) freezeIter.getType();
            IModelElement par = iterType.getTopLevelParent();
            String annotationName = annotation.getName();
            Attribute attr;
            if (annotation.getParent() == par) {
                attr = annotation;
            } else {
                attr = iterType.getAttribute(annotation.getName());
            }
            while (null == attr && par instanceof Project) {
                attr = findAttribute((Project) par, annotationName, new HashSet<Project>());
            }
            if (null != attr) {
                Variable iterEx = new AttributeVariable(new Variable(freezeIter), attr);
                selector = new OCLFeatureCall(iterEx, operation, 
                    new ConstantValue(ValueFactory.createValue(annotation.getType(), literal)));
            } else {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).error("cannot create freeze selector as "
                    + "annotation " + annotationName + " cannot be found");
            }
            return selector;
        }
        
    }
    
    /**
     * Defines a copy specification.
     * 
     * @author Holger Eichelberger
     */
    public static class CopySpec {
        
        private Compound type;
        private String sourceVariableName;
        private IFreezeProvider freezeProvider;
        private String[] targetVariableNames;
        
        /**
         * Creates a copy specification.
         * 
         * @param type the source type (may be <b>null</b> then the spec is ignored)
         * @param sourceVariableName the source variable name, may be given in compound access style for 
         *   nested variables (may be <b>null</b> then the spec is ignored)
         * @param targetVariableNames the target variable names, may be given in compound access style for 
         *   nested variables; the first one receives the copy, the other one references to the copy if they are
         *   reference variables (may be <b>null</b> then the spec is ignored)
         */
        public CopySpec(Compound type, String sourceVariableName, String... targetVariableNames) {
            this(type, sourceVariableName, null, targetVariableNames);
        }

        /**
         * Creates a copy specification.
         * 
         * @param type the source type (may be <b>null</b> then the spec is ignored)
         * @param sourceVariableName the source variable name, may be given in compound access style for 
         *   nested variables (may be <b>null</b> then the spec is ignored)
         * @param freezeProvider describes how new variables shall be frozen (may be <b>null</b> for no freezing)
         * @param targetVariableNames the target variable names, may be given in compound access style for 
         *   nested variables; the first one receives the copy, the other one references to the copy if they are
         *   reference variables (may be <b>null</b> then the spec is ignored)
         */
        public CopySpec(Compound type, String sourceVariableName, IFreezeProvider freezeProvider, 
            String... targetVariableNames) {
            this.type = type;
            this.sourceVariableName = sourceVariableName;
            this.freezeProvider = freezeProvider;
            this.targetVariableNames = targetVariableNames;
        }

        /**
         * Returns the source type.
         * 
         * @return the source type
         */
        public Compound getType() {
            return type;
        }
        
        /**
         * Returns the source variable name.
         * 
         * @return the source variable name, may be given in compound access style for nested variables
         */
        public String getSourceVariableName() {
            return sourceVariableName;
        }
        
        /**
         * The freeze provider.
         * 
         * @return the freeze provider, may be <b>null</b> for no freezing
         */
        public IFreezeProvider getFreezeProvider() {
            return freezeProvider;
        }

        /**
         * Returns the target variable names.
         * 
         * @return the target variable names, may be given in compound access style for nested variables
         */
        public String[] getTargetVariableNames() {
            return targetVariableNames;
        }
        
        /**
         * Returns whether this instance is valid.
         * 
         * @return <code>true</code> for valid, <code>false</code> else
         */
        public boolean isValid() {
            return null != type && null != sourceVariableName && null != targetVariableNames;
        }
    }

    /**
     * Creates an instance for copying with state {@link AssignmentState#ASSIGNED}.
     *  
     * @param namePrefix the name prefix for new variables.
     * @param copySpecs the copy specifications to take into account, individual specs may be <b>null</b> but will 
     *     be ignored then 
     */
    public VariableValueCopier(String namePrefix, CopySpec... copySpecs) {
        this(namePrefix, AssignmentState.ASSIGNED, copySpecs);
    }
    
    /**
     * Creates an instance with given assignment state.
     *  
     * @param namePrefix the name prefix for new variables.
     * @param newState the state to use (if <b>null</b>, {@link AssignmentState#ASSIGNED} is used)
     * @param copySpecs the copy specifications to take into account
     */
    public VariableValueCopier(String namePrefix, IAssignmentState newState, CopySpec... copySpecs) {
        this.namePrefix = namePrefix;
        this.newState = null == newState ? AssignmentState.ASSIGNED : newState;
        for (int c = 0; c < copySpecs.length; c++) {
            CopySpec spec = copySpecs[c];
            if (null != spec) {
                if (spec.isValid()) {
                    Map<String, CopySpec> map = specs.get(spec.getType());
                    if (null == map) {
                        map = new HashMap<String, CopySpec>();
                        specs.put(spec.getType(), map);
                    }
                    map.put(spec.getSourceVariableName(), spec);
                } else {
                    getLogger().warn("no type/source/target given for spec " + c + ". Ignoring.");
                }
            } else {
                getLogger().warn("no type/source/target given for spec " + c + ". Ignoring.");
            }
        }
    }
    
    /**
     * Defines the assignment listener.
     * 
     * @param listener the listener (may be <b>null</b> to disable notifications)
     */
    public void setAssignmentListener(IAssignmentListener listener) {
        this.listener = listener;
    }
    
    /**
     * Returns the logger of this class.
     * 
     * @return the logger
     */
    protected EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
    }
    
    /**
     * Processes a configuration according to the copy specifications.
     * 
     * @param config the configuration to process
     * @throws ConfigurationException in case that the configuration is not possible 
     * @throws ValueDoesNotMatchTypeException in case that value types do not match
     * @throws CSTSemanticException in case that expressions such as freeze-buts are not correctly constructed
     */
    public void process(Configuration config) throws ConfigurationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException {
        Iterator<IDecisionVariable> iter = config.iterator();
        List<IDecisionVariable> tmp = new ArrayList<IDecisionVariable>(config.getDecisionCount());
        while (iter.hasNext()) { // concurrent modification
            tmp.add(iter.next());
        }
        for (int t = 0; t < tmp.size(); t++) {
            IDecisionVariable srcVar = tmp.get(t);
            Map<String, CopySpec> fieldSpecs = specs.get(srcVar.getDeclaration().getType());
            if (null != fieldSpecs) {
                process(srcVar, srcVar, "", fieldSpecs, new HashSet<IDecisionVariable>());
            }
        }
    }
        
    /**
     * Processes a decision variable.
     * 
     * @param variable the variable to process
     * @param base the base variable where processing initially started
     * @param prefix the prefix access name processed so far
     * @param fieldSpecs the field specifications for <code>base</code>
     * @param done already processed variables - avoiding cycles
     * @throws ConfigurationException in case that the configuration is not possible 
     * @throws ValueDoesNotMatchTypeException in case that value types do not match
     * @throws CSTSemanticException in case that expressions such as freeze-buts are not correctly constructed
     */
    private void process(IDecisionVariable variable, IDecisionVariable base, String prefix, 
        Map<String, CopySpec> fieldSpecs, Set<IDecisionVariable> done) 
        throws ConfigurationException, ValueDoesNotMatchTypeException, CSTSemanticException {
        if (!done.contains(variable)) {
            done.add(variable);
            for (int n = 0; n < variable.getNestedElementsCount(); n++) {
                IDecisionVariable nested = variable.getNestedElement(n);
                String name = nested.getDeclaration().getName();
                if (prefix.length() > 0) {
                    name = prefix + IvmlKeyWords.COMPOUND_ACCESS + name;
                }
                CopySpec spec = fieldSpecs.get(name);
                if (null != spec) {
                    String[] names = spec.getTargetVariableNames();
                    if (names.length >= 1) {
                        IDecisionVariable target = findVariable(base, names[0]);
                        if (null != target) {
                            Value value = copy(nested, target, spec.getFreezeProvider());
                            handleFurther(base, names, value);
                        }
                    }
                }
                process(Configuration.dereference(nested), base, name, fieldSpecs, done);
            }
        }
    }

    /**
     * Assigns <code>value</code> to the further variables on <code>base</code> given in <code>names</code> at index
     * positions larger than 0.
     * 
     * @param base the base variable
     * @param names the further variable names to initialize
     * @param value the value to use for initialization
     * @throws ConfigurationException in case that the configuration is not possible
     */
    private void handleFurther(IDecisionVariable base, String[] names, Value value) throws ConfigurationException {
        // value is reference?
        IDatatype valueType = value.getType();
        if (Reference.TYPE.isAssignableFrom(valueType)) { // prerequisite
            valueType = Reference.dereference(valueType);
            for (int t = 1; t < names.length; t++) {
                IDecisionVariable further = findVariable(base, names[t]);
                if (null != further && Reference.TYPE.isAssignableFrom(further.getDeclaration().getType())) {
                    // value is value, further is value -> assign
                    // value is collection, further is value -> assign first
                    if (Container.TYPE.isAssignableFrom(valueType)) {
                        ContainerValue cValue = (ContainerValue) value;
                        if (cValue.getElementSize() > 0) {
                            further.setValue(cValue.getElement(0), newState);
                        }
                    } else {
                        further.setValue(value, newState);
                    }
                }
            }
        }
    }
    
    /**
     * Finds a variable via its (qualified access) name.
     * 
     * @param base the base variable to search on
     * @param qname the variable name to search for
     * @return the resulting variable or <b>null</b> if there is none
     */
    public static IDecisionVariable findVariable(IDecisionVariable base, String qname) {
        int pos = qname.indexOf(IvmlKeyWords.COMPOUND_ACCESS);
        String searchName;
        String restName;
        if (pos > 0) {
            searchName = qname.substring(0, pos);
            restName = qname.substring(pos + 1); // char
        } else {
            searchName = qname;
            restName = null;
        }
        IDecisionVariable result = null;
        for (int n = 0; null == result && n < base.getNestedElementsCount(); n++) {
            IDecisionVariable nested = base.getNestedElement(n);
            if (nested.getDeclaration().getName().equals(searchName)) {
                result = nested;
            }
        }
        if (null != result && null != restName) {
            result = findVariable(result, restName);
        }
        return result;
    }
    
    /**
     * Copies the value of <code>source</code> variable to target <code>variable</code>.
     * 
     * @param source the source variable to copy from
     * @param target the target variable to copy to
     * @param freezeProvider optional freeze provider to be applied to new variables (may be <b>null</b> for no 
     *     freezing)
     * @return the first value set (may be <b>null</b>)
     * @throws ConfigurationException in case that the configuration is not possible 
     * @throws ValueDoesNotMatchTypeException in case that value types do not match
     * @throws CSTSemanticException in case that expressions such as freeze-buts are not correctly constructed
     */
    private Value copy(IDecisionVariable source, IDecisionVariable target, IFreezeProvider freezeProvider) 
        throws ConfigurationException, ValueDoesNotMatchTypeException, CSTSemanticException {
        Value result = null;
        source = Configuration.dereference(source);
        target = Configuration.dereference(target);
        IDatatype sourceType = source.getDeclaration().getType();
        IDatatype targetType = target.getDeclaration().getType();
        if (Container.TYPE.isAssignableFrom(sourceType)) {
            if (Container.TYPE.isAssignableFrom(targetType)) {
                ContainerVariable cVar = ensureContainerVariable((ContainerVariable) target);
                for (int n = 0; n < source.getNestedElementsCount(); n++) {
                    IDecisionVariable nestedVar = cVar.addNestedElement();
                    result = keepFirst(result, 
                        copySingleVariable(source.getNestedElement(n), nestedVar, freezeProvider, true));
                }
            } else {
                ContainerVariable sVar = (ContainerVariable) source;
                if (sVar.getNestedElementsCount() > 0) {
                    result = keepFirst(result, 
                        copySingleVariable(sVar.getNestedElement(0), target, freezeProvider, false));
                }
            }
        } else {
            if (Container.TYPE.isAssignableFrom(targetType)) {
                ContainerVariable cVar = ensureContainerVariable((ContainerVariable) target);
                IDecisionVariable tgt = cVar.addNestedElement();
                result = keepFirst(result, copySingleVariable(source, tgt, freezeProvider, true));
            } else {
                result = keepFirst(result, copySingleVariable(source, target, freezeProvider, false));
            }
        }
        return result;
    }
    
    /**
     * Keeps the first value of <code>actual</code> and <code>newValue</code>.
     * 
     * @param actual the actual value
     * @param newValue the new value
     * @return <code>actual</code> if <code>actual</code> was previously <b>null</b>, <code>newValue</code> else
     */
    private static Value keepFirst(Value actual, Value newValue) {
        return null == actual ? newValue : actual;
    }
    
    /**
     * Ensures that the given container variable is configured and empty.
     * 
     * @param target the variable
     * @return <code>target</code>
     * @throws ConfigurationException in case that the configuration is not possible 
     * @throws ValueDoesNotMatchTypeException in case that value types do not match
     */
    private ContainerVariable ensureContainerVariable(ContainerVariable target) 
        throws ConfigurationException, ValueDoesNotMatchTypeException {
        if (AssignmentState.UNDEFINED == target.getState()) {
            target.setValue(ValueFactory.createValue(target.getDeclaration().getType(), ValueFactory.EMPTY), newState);
        }
        return target;
    }

    /**
     * Copies a single variable from <code>source</code> to target and ensures in case of a reference
     * target that a respective variable is created.
     * 
     * @param source the source variable
     * @param target the target variable (may be a nested variable, e.g., of a collection)
     * @param freezeProvider optional freeze provider to be applied to new variables (may be <b>null</b> for no 
     *     freezing)
     * @param adding whether the value is being added to a collection or just set
     * @return the actual value set
     * @throws ConfigurationException in case that the configuration is not possible 
     * @throws ValueDoesNotMatchTypeException in case that value types do not match
     * @throws CSTSemanticException in case that expressions such as freeze-buts are not correctly constructed
     */
    private Value copySingleVariable(IDecisionVariable source, IDecisionVariable target, IFreezeProvider freezeProvider,
        boolean adding) throws ConfigurationException, ValueDoesNotMatchTypeException, CSTSemanticException {
        Value result;
        source = Configuration.dereference(source);
        Value value = source.getValue().clone();
        IDatatype targetType = target.getDeclaration().getType(); 
        if (Reference.TYPE.isAssignableFrom(targetType)) {
            Configuration cfg = source.getConfiguration();
            Project prj = cfg.getProject();
            IModelElement topParent = source.getDeclaration().getTopLevelParent(); // create as close as possible to src
            if (topParent instanceof Project) {
                prj = (Project) topParent;
            }
            DecisionVariableDeclaration decl = new DecisionVariableDeclaration(namePrefix + "_" 
                + source.getDeclaration().getName() + "_" + count++, source.getDeclaration().getType(), prj);
            prj.add(decl);
            IDecisionVariable var = cfg.createDecision(decl);
            if (null != var) {
                notifyCreated(source, var);
                var.setValue(value, newState);
                if (null != freezeProvider) {
                    IFreezable[] freezables = new IFreezable[1];
                    freezables[0] = decl;
                    FreezeVariableType iterType = new FreezeVariableType(freezables, prj);
                    DecisionVariableDeclaration freezeIter 
                        = new DecisionVariableDeclaration(freezeProvider.getFreezeVariableName(), iterType, prj);
                    ConstraintSyntaxTree selector = freezeProvider.createButExpression(freezeIter);
                    selector.inferDatatype();
                    FreezeBlock freeze = new FreezeBlock(freezables, freezeIter, selector, prj);
                    prj.add(freeze);
                    
                    FreezeEvaluator evaluator = new FreezeEvaluator(cfg);
                    evaluator.setFreeze(freeze);
                    var.freeze(evaluator);
                }
                result = ValueFactory.createValue(targetType, decl);
                target.setValue(result, newState);
                notifyAssigned(target, result, adding);
            } else {
                IModelElement parent = decl.getParent();
                String parentType = null != parent ? decl.getParent().getClass().getSimpleName() : "<no type>";
                getLogger().error("Cannot create variable instance for " + decl.getName() + " of "
                    + source.getDeclaration().getName() + " with:"
                    + "\n - Parent = " + parent + "(" + parentType + ")"
                    + "\n - Existing instance (should be null): " + cfg.getDecision(decl));
                result = null;
            }
        } else {
            target.setValue(value, newState);
            notifyAssigned(target, value, adding);
            result = value;
        }
        return result;
    }
    
    /**
     * Notifies about assigned values.
     * 
     * @param target the target variable
     * @param value the new value
     * @param added whether value is being added to a collection or set as the single absolute value
     */
    private void notifyAssigned(IDecisionVariable target, Value value, boolean added) {
        if (null != listener) {
            listener.notifyAssigned(target, value, added);
        }
    }
    
    /**
     * Notifies the listener about a new variable created for a given origin variable. A 
     * {@link #notifyAssigned(IDecisionVariable, Value, boolean)} shall follow.
     * 
     * @param origin the origin variable
     * @param target the new variable
     */
    private void notifyCreated(IDecisionVariable origin, IDecisionVariable target) {
        if (null != listener) {
            listener.notifyCreated(origin, target);
        }
    }

}
