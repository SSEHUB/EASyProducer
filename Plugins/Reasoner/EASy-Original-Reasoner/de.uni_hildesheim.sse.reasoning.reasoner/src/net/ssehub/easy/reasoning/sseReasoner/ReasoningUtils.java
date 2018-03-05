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
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.reasoning.sseReasoner.functions.FailedElements;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
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

    /**
     * A set pool for instances of <code>Set<Compound></code>.
     */
    public static final Pool<Set<Compound>> SET_COMPOUND_POOL = new Pool<Set<Compound>>(
        new IPoolManager<Set<Compound>>() {

            @Override
            public Set<Compound> create() {
                return new HashSet<Compound>();
            }

            @Override
            public void clear(Set<Compound> instance) {
                instance.clear();
            }
        }
    );
    
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
     * Returns whether <code>type</code> is a type-nested container.
     * 
     * @param type the type
     * @return <code>true</code> for a nested collection, <code>false else</code>
     */
    static boolean isNestedContainer(IDatatype type) {
        return TypeQueries.isContainer(type) 
            && 1 == type.getGenericTypeCount() 
            && TypeQueries.isContainer(type.getGenericType(0));
    }
    
    /**
     * Returns the relevant value for reasoning.
     * 
     * @param decl the declaration
     * @param var the decision variable
     * @param incremental are we in incremental mode
     * @return the value, may be <b>null</b>
     */
    static Value getRelevantValue(AbstractVariable decl, IDecisionVariable var, boolean incremental) {
        Value val = null;
        if (null != var.getValue()) {
            val = var.getValue();
        } else if (!incremental) {
            ConstraintSyntaxTree dflt = decl.getDefaultValue();
            if (dflt instanceof ConstantValue) {
                val = ((ConstantValue) dflt).getConstantValue();
            } // else initialization, we need two rounds
        }
        return val;
    }

    /**
     * Returns the relevant value for reasoning.
     * 
     * @param <D> the value type
     * @param decl the declaration
     * @param var the decision variable
     * @param incremental are we in incremental mode
     * @param filter in case that only a value of the specific type shall be returned
     * @return the value, may be <b>null</b>
     */
    static <D extends Value> D getRelevantValue(AbstractVariable decl, IDecisionVariable var, boolean incremental, 
        Class<D> filter) {
        D result;
        Value val = getRelevantValue(decl, var, incremental);
        if (filter.isInstance(val)) {
            result = filter.cast(val);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the used types if <code>value</code> is a container value.
     * 
     * @param <D> the the to filter for
     * @param val the value
     * @param result the result set to be modified as a side effect
     * @return <code>true</code> if <code>val</code> is a container value, <code>false</code> else
     */
    static <D extends IDatatype> boolean getUsedCompoundTypes(Value val, Set<Compound> result) {
        boolean done = false;
        if (val instanceof ContainerValue) {
            ContainerValue cVal = (ContainerValue) val;
            for (int v = 0; v < cVal.getElementSize(); v++) {
                Value tmp = cVal.getElement(v);
                if (!getUsedCompoundTypes(tmp, result)) {
                    IDatatype tType = DerivedDatatype.resolveToBasis(tmp.getType());
                    if (tType instanceof Compound) {
                        result.add((Compound) tType);
                    }
                }
            }
            done = true;
        }
        return done;
    }
    
    /**
     * Purges all refined compounds mentioned in <code>compounds</code>.
     * 
     * @param compounds the compounds to purge
     * @param result the purged compounds (to be modified as a side effect) 
     */
    static void purgeRefines(Set<Compound> compounds, Set<Compound> result) {
        result.addAll(compounds);
        for (Compound c : compounds) {
            purgeRefines(c, result);
        }
    }
    
    /**
     * Purges all refined compounds of <code>comp</code> from <code>result</code>.
     * 
     * @param comp the compound to purge the refined ones for
     * @param result modified as a side effect
     */
    private static void purgeRefines(Compound comp, Set<Compound> result) {
        for (int r = 0; r < comp.getRefinesCount(); r++) {
            Compound ref = comp.getRefines(r);
            result.remove(ref);
            purgeRefines(ref, result);
        }
    }

    /**
     * Adds all elements from <code>source</code> to <code>target</code>.
     * 
     * @param <T> the target type
     * @param <S> the source type, a subtype of <code>&lt;T&gt;</code>
     * @param target the target collection
     * @param source the source array (may be <b>null</b>, then nothing happens)
     */
    static <T, S extends T> void addAll(Collection<T> target, S[] source) {
        if (source != null) {
            for (int s = 0, n = source.length; s < n; s++) {
                target.add(source[s]);                    
            }
        }
    }
    
    /**
     * Returns the deepest contained type, i.e., for a nested container the deeply nested (base) type.
     * 
     * @param cnt the container type
     * @return the deeply nested type
     */
    static IDatatype getDeepestContainedType(Container cnt) {
        IDatatype result = cnt.getContainedType();
        if (result instanceof Container) {
            result = getDeepestContainedType((Container) result);
        }
        return result;
    }

}
