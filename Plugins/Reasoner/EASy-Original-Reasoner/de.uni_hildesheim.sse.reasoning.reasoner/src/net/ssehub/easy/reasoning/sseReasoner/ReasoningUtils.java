/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElements;
import net.ssehub.easy.reasoning.sseReasoner.model.CopyVisitor;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Operation;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Utility methods for reasoning/constraint resolution. Introduced to clean up
 * {@link Resolver}.
 * 
 * @author Holger Eichelberger
 */
class ReasoningUtils {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(ReasoningUtils.class, Descriptor.BUNDLE_NAME);

    /**
     * Infers the type of <code>cst</code> using <code>dflt</code> as fallback.
     * 
     * @param cst the expression to infer the type for
     * @param dflt the default
     * @return the type of the expression or <code>dflt</code> in case of failures
     */
    static IDatatype inferTypeSafe(ConstraintSyntaxTree cst, IDatatype dflt) {
        IDatatype result = dflt;
        try {
            result = cst.inferDatatype();
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // should not occur, ok to log
        }
        return result;
    }

    /**
     * Creates a type value.
     * 
     * @param type the datatype
     * @return the constant value 
     * @throws ValueDoesNotMatchTypeException if the value cannot be created
     */
    static Value createTypeValue(IDatatype type) throws ValueDoesNotMatchTypeException {
        return ValueFactory.createValue(MetaType.TYPE, type);
    }

    /**
     * Creates a type value constraint tree node.
     * 
     * @param type the datatype
     * @return the constant value constraint tree node
     * @throws ValueDoesNotMatchTypeException if the value cannot be created
     */
    static ConstraintSyntaxTree createTypeValueConstant(IDatatype type) throws ValueDoesNotMatchTypeException {
        return new ConstantValue(createTypeValue(type));
    }

    /**
     * Creates a type value constraint tree node and logs occurring exceptions.
     * 
     * @param type the datatype
     * @return the constant value constraint tree node
     */
    static ConstraintSyntaxTree createTypeValueConstantSafe(IDatatype type) {
        ConstraintSyntaxTree result = null;
        try {
            result = createTypeValueConstant(type);
        } catch (ValueDoesNotMatchTypeException e) {
            LOGGER.exception(e); // should not occur, ok to log
        }
        return result;
    }

    /**
     * Creates a type cast ("asType" operation, if needed) from the type of <code>exp</code> to <code>targetType</code> 
     * applied to <code>exp</code>.
     * 
     * @param exp the expression to apply the type cast operation to 
     * @param targetType the target type
     * @return the resulting expression
     */
    static ConstraintSyntaxTree createAsTypeCast(ConstraintSyntaxTree exp, IDatatype targetType) {
        return createAsTypeCast(exp, null, targetType);
    }

    /**
     * Creates a type cast ("asType" operation, if needed) from <code>sourceType</code> to <code>targetType</code> 
     * applied to <code>exp</code>.
     * 
     * @param exp the expression to apply the type cast operation to 
     * @param sourceType the source type
     * @param targetType the target type
     * @return the resulting expression
     */
    static ConstraintSyntaxTree createAsTypeCast(ConstraintSyntaxTree exp, IDatatype sourceType, IDatatype targetType) {
        ConstraintSyntaxTree res = exp;
        try {
            if (null == sourceType) {
                sourceType = exp.inferDatatype();
            }
            if (!TypeQueries.sameTypes(sourceType, targetType) && !TypeQueries.isAnyType(targetType)) {
                res = new OCLFeatureCall(res, OclKeyWords.AS_TYPE, createTypeValueConstant(targetType));
            }
        } catch (CSTSemanticException e) {
            LOGGER.exception(e); // should not occur, ok to log
        } catch (ValueDoesNotMatchTypeException e) {
            LOGGER.exception(e); // should not occur, ok to log
        }
        return res;
    }

    /**
     * Method for using {@link CopyVisitor} for constraint transformation.
     * 
     * @param cst Constraint to be transformed.
     * @param selfEx an expression representing <i>self</i> (ignored if <b>null</b>).
     * @param mappingCA a mapping from old variable declarations to new compound access declarations,
     *   existing variable declarations are taken over if no mapping is given, may be <b>null</b>
     *   in case of no mapping at all
     * @return Transformed constraint.
     */
    static ConstraintSyntaxTree copyCST(ConstraintSyntaxTree cst, ConstraintSyntaxTree selfEx, 
        Map<AbstractVariable, CompoundAccess> mappingCA) {
        CopyVisitor visitor = new CopyVisitor(null, mappingCA);
        if (selfEx != null) {
            visitor.setSelf(selfEx);            
        }
        cst.accept(visitor);
        cst = visitor.getResult();
        inferTypeSafe(cst, null);
        return cst;
    }

    /**
     * Method for printing all problem points.
     * 
     * @param problemVariables the variables to print
     */
    static void printProblemPoints(Set<IDecisionVariable> problemVariables) {
        if (problemVariables.size() > 0) {
            LOGGER.info("Problem points: ");
            for (IDecisionVariable problem : problemVariables) {
                LOGGER.info(problem + "; ");
            }                 
        }
    }

    /**
     * Method for displaying all variable attributes.
     * @param variable variable
     * @return String of all attributes of the variable.
     */
    static String toStringAttributes(IDecisionVariable variable) {
        String attributes = "Attributes: ";
        for (int i = 0; i < variable.getAttributesCount(); i++) {
            attributes = attributes 
                    + variable.getAttribute(i).toString() + " : " 
                    + variable.getAttribute(i).getState() + " : " 
                    + variable.getAttribute(i).getValue() + "; "; 
        }
        return attributes;
    }
    
    /**
     * Method for printing info about {@link IDecisionVariable}.
     * @param variable Variable to be printed out.
     */
    static void printModelElement(IDecisionVariable variable) {
        if (variable.getState() != null) {
            LOGGER.debug(variable.getDeclaration() 
                + " : "
                + variable.getState().toString()
                + " : " 
                + variable.getValue()
                + " | "
                + toStringAttributes(variable));
            if (variable.getNestedElementsCount() > 0) {
                for (int i = 0; i < variable.getNestedElementsCount(); i++) {
                    printModelElement(variable.getNestedElement(i));
                }
            }            
        }
    }

    /**
     * Turns a constraint into a string.
     * 
     * @param constraint the constraint
     * @return the representing string
     */
    static String toIvmlString(Constraint constraint) {
        return toIvmlString(constraint.getConsSyntax());
    }
    
    /**
     * Turns a constraint syntax tree into a string.
     * 
     * @param cst may be <b>null</b>, print "-" then
     * @return the string representation
     */
    static String toIvmlString(ConstraintSyntaxTree cst) {
        return null == cst ? "-" : StringProvider.toIvmlString(cst);
    }

    /**
     * Method for printing all variables, their states and values.
     * @param config Configuration to work with.
     * @param comment Comment for printing.
     */
    static void printModelElements(Configuration config, String comment) {
        LOGGER.debug("-------------------");
        LOGGER.debug(comment);
        for (IDecisionVariable variable : config) {
            printModelElement(variable); 
        }     
    }

    /**
     * Method for printing constraints that are taken into account for reasoning.
     * @param constraints Constraints from the project. 
     */
    static void printConstraints(Collection<Constraint> constraints) {
        LOGGER.debug("-------------------");
        LOGGER.debug("--Constraints:");
        for (Constraint c : constraints) {
            LOGGER.debug(StringProvider.toIvmlString(c.getConsSyntax()) + " : " + c.getTopLevelParent());
        }        
    }
    
    /**
     * Method for displaying failed constraints and assignments.
     * 
     * @param failedElements the failed elements
     */
    static void printFailedElements(FailedElements failedElements) {
        if (failedElements.hasProblems()) {
            if (failedElements.problemConstraintCount() > 0) {
                Iterator<Constraint> failedConstraints = failedElements.getProblemConstraints();
                while (failedConstraints.hasNext()) {
                    Constraint failedRule = failedConstraints.next();
                    LOGGER.debug("Failed constraint: " + toIvmlString(failedRule));
                }
            }
            if (failedElements.problemVariabletCount() > 0) {
                Iterator<AbstractVariable> failedVariables = failedElements.getProblemVariables();
                while (failedVariables.hasNext()) {
                    AbstractVariable failedVariable = failedVariables.next();
                    LOGGER.debug("Failed variable: " + failedVariable);
                } 
            }           
        } 
    }


    /**
     * Identifies the types contained in <code>variable</code>.
     * 
     * @param variable the variable to analyze for contained types
     * @param containedType an additional type that must be part of the result (ignored if <b>null</b>)
     * @return the contained types
     */
    static Set<IDatatype> identifyContainedTypes(IDecisionVariable variable, IDatatype containedType) {
        // this is still static typing based on the actual value, but if the value is changed, the constraints shall 
        // be re-collected anyway
        // unclear, shall this be recursive?
        Set<IDatatype> result = new HashSet<IDatatype>();
        if (null != containedType) {
            result.add(containedType);
        }
        if (null != variable.getValue()) {
            for (int n = 0; n < variable.getNestedElementsCount(); n++) {
                IDecisionVariable nested = variable.getNestedElement(n);
                if (null != nested) {
                    Value val = nested.getValue();
                    if (null != val) {
                        result.add(val.getType());
                    }
                }
            }
        } // fallback to default value if not given
        return result;
    }

    /**
     * Creates a container operation call ("shortcut").
     * 
     * @param container the container to operate on
     * @param op the operation
     * @param iterEx the iterator expression
     * @param decl the declarators
     * @return the created call
     */
    static ContainerOperationCall createContainerCall(ConstraintSyntaxTree container, Operation op, 
        ConstraintSyntaxTree iterEx, DecisionVariableDeclaration... decl) {
        return new ContainerOperationCall(container, op.getName(), iterEx, decl);
    }

    /**
     * Returns whether <code>decl</code> is an overridden slot.
     * 
     * @param decl the declaration of the slot to search for
     * @return <code>true</code> if overridden, <code>false</code> else
     */
    static boolean isOverriddenSlot(AbstractVariable decl) {
        boolean overridden = false;
        IModelElement iter = decl.getParent(); 
        // find declaring compound
        while (null != iter && !(iter instanceof Compound)) {
            iter = iter.getParent();
        }
        if (iter instanceof Compound) {
            overridden = countSlots((Compound) iter, decl.getName(), true) > 1;
        }
        return overridden;
    }
    
    /**
     * Counts the number of slots with given <code>name</code> in the refines hierarchy 
     * of <code>cmp</code>.
     * 
     * @param cmp the compound to start searching
     * @param name the name of the slot to search for
     * @param stopGreater1 stop searching if we have more than one matching slot
     * @return the number of slots
     */
    static int countSlots(Compound cmp, String name, boolean stopGreater1) {
        int result = 0;
        if (null != cmp.getElement(name)) {
            result++;
        }
        for (int r = 0; r < cmp.getRefinesCount(); r++) {
            result += countSlots(cmp.getRefines(r), name, stopGreater1);
            if (stopGreater1 && result > 1) {
                break;
            }
        }
        return result;
    }

    /**
     * Returns whether <code>type</code> is a type-nested collection.
     * 
     * @param type the type
     * @return <code>true</code> for a nested collection, <code>false else</code>
     */
    static boolean isNestedCollection(IDatatype type) {
        return TypeQueries.isContainer(type) 
            && 1 == type.getGenericTypeCount() 
            && isNestedCollection(type.getGenericType(0));
    }

    /**
     * Returns the used types if <code>cst</code> is a constant container value.
     * 
     * @param <D> the the to filter for
     * @param cst the expression
     * @param filter the type class to filter for
     * @return the set of used types, may be empty or <b>null</b> for none
     */
    static <D extends IDatatype> Set<D> getUsedTypes(ConstraintSyntaxTree cst, Class<D> filter) {
        Set<D> result = null;
        if (cst instanceof ConstantValue) {
            result = new HashSet<D>();
            getUsedTypes(((ConstantValue) cst).getConstantValue(), filter, result);
        }
        return result;
    }

    /**
     * Returns the used types if <code>value</code> is a container value.
     * 
     * @param <D> the the to filter for
     * @param val the value
     * @param filter the type class to filter for
     * @param result the result set to be modified as a side effect
     * @return the set of used types, may be empty or <b>null</b> for none
     */
    private static <D extends IDatatype> boolean getUsedTypes(Value val, Class<D> filter, Set<D> result) {
        boolean done = false;
        if (val instanceof ContainerValue) {
            ContainerValue cVal = (ContainerValue) val;
            for (int v = 0; v < cVal.getElementSize(); v++) {
                Value tmp = cVal.getElement(v);
                if (!getUsedTypes(tmp, filter, result)) {
                    IDatatype tType = tmp.getType();
                    if (filter.isInstance(tType)) {
                        result.add(filter.cast(tType));
                    }
                }
            }
            done = true;
        }
        return done;
    }

    /**
     * Creates a default constraint.
     * 
     * @param cst the constraint expression
     * @param parent the parent
     * @return the created constraint
     * @throws CSTSemanticException in case that the creation fails
     */
    static Constraint createDefaultConstraint(ConstraintSyntaxTree cst, IModelElement parent) 
        throws CSTSemanticException {
        Constraint constraint = new Constraint(parent);
        constraint.makeDefaultConstraint();
        cst.inferDatatype(); 
        constraint.setConsSyntax(cst);
        return constraint;
    }

}
