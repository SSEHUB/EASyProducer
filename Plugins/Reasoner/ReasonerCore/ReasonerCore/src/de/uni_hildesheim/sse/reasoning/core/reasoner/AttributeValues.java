package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IAttributableElement;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;

/**
 * Stores attributes and their assigned values as an additional
 * information to be considered while reasoning. Multiple values
 * are possible in order to reflect a history of assigned values, e.g.
 * due to multiple instantiations over several binding times. Value
 * assignments made in this object are considered as an additional 
 * information and do no not directly change an existing configuration.<br/>
 * 
 * Please note that persistent loading mechanisms may not have direct
 * access to a model in order to properly resolve a persisted set
 * of {@link AttributeValues}. However, this is indirectly supported
 * by this class by support for storing values ({@link #toString(Value)}),
 * support for storing strings read from a persistent storage 
 * ({@link #addUnresolved(String, List)} and by finally resolving the
 * values in the context of a given model ({@link #resolveUsing(Project, boolean)}.
 * 
 * @author Holger Eichelberger
 */
public class AttributeValues {
    
    private Map<Attribute, List<Value>> valueAssignments 
        = new HashMap<Attribute, List<Value>>();

    private Map<String, List<String>> unresolvedAssignments;
    
    /**
     * Creates a new set of attribute values.
     */
    public AttributeValues() {
    }

    /**
     * Adds a <code>value</code> for a given attribute.
     * 
     * @param attribute the attribute to assign the <code>value</code> for
     * @param value the value to assign
     * @param index the index of the value to be returned
     * @throws IndexOutOfBoundsException in case that <code>index&lt;0 
     *   || index&gt;={@link #getAttributeValuesCount(Attribute)}</code> with 
     *   called same <code>attribute</code> (!)
     * @throws AttributeException in case that value cannot be assigned to attribute
     */
    public void setValue(Attribute attribute, Value value, int index) throws AttributeException {
        List<Value> values = valueAssignments.get(attribute);
        if (null == values) {
            throw new AttributeException("attribute does not exist in this value set");
        }
        if (!attribute.getType().isAssignableFrom(value.getType())) {
            throw new AttributeException("given value does not match the type of the attribute");
        }
        values.set(index, value);
    }
    
    /**
     * Adds a <code>value</code> for a given attribute.
     * 
     * @param attribute the attribute to assign the <code>value</code> for
     * @param value the value to assign
     * @throws AttributeException in case that value cannot be assigned to attribute
     */
    public void addValue(Attribute attribute, Value value) throws AttributeException {
        List<Value> values = valueAssignments.get(attribute);
        if (null == values) {
            values = new ArrayList<Value>();
            valueAssignments.put(attribute, values);
        }
        if (!values.contains(value)) {
            if (null == value || attribute.getType().isAssignableFrom(value.getType())) {
                values.add(value);
            } else {
                throw new AttributeException("given value does not match the type of the attribute");
            }
        }
    }
    
    /**
     * Remove a given <code>value</code> from the value assignment of
     * <code>attribute</code>.
     *  
     * @param attribute the attribute to remove the value from
     * @param value the value to be removed
     */
    public void removeValue(Attribute attribute, Value value) {
        List<Value> values = valueAssignments.get(attribute);
        if (null != values) {
            values.remove(value);
        }
    }
    
    /**
     * Returns the number of attributes for which value assignments are
     * stored in this instance.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return valueAssignments.size();
    }
    
    /**
     * Returns all attributes for which value assignments are stored.
     * 
     * @return all attributes as an iterator
     */
    public Iterator<Attribute> getAttributes() {
        return valueAssignments.keySet().iterator();
    }
    
    /**
     * Returns all attributes for which value assignments are stored.
     * 
     * @return all attributes as a list
     */
    public List<Attribute> getAttributesAsList() {
        ArrayList<Attribute> result = new ArrayList<Attribute>(valueAssignments.size());
        result.addAll(valueAssignments.keySet());
        return result;
    }
    
    /**
     * Returns all attributes for which value assignments are stored.
     * 
     * @return all attributes as a set
     */
    public Set<Attribute> getAttributesAsSet() {
        HashSet<Attribute> result = new HashSet<Attribute>(valueAssignments.size());
        result.addAll(valueAssignments.keySet());
        return result;
    }
    
    /**
     * Returns the number of values assigned to <code>attribute</code>.
     * 
     * @param attribute the attribute to return the number of values for
     * @return the number of assigned values, <code>-1</code> if 
     *   <b>attribute</b> does not exist
     */
    public int getAttributeValuesCount(Attribute attribute) {
        int result;
        List<Value> values = valueAssignments.get(attribute);
        if (null != values) {
            result = values.size();
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * Returns the specific value assigned to <code>attribute</code>.
     * 
     * @param attribute the attribute to return the number of values for
     * @param index the index of the value to be returned
     * @return the assigned value, <b>null</b> if <code>attribute</code> 
     *   does not exist
     * @throws IndexOutOfBoundsException in case that <code>index&lt;0 
     *   || index&gt;={@link #getAttributeValuesCount(Attribute)}</code> with 
     *   called same <code>attribute</code> (!)
     */
    public Value getAttributeValue(Attribute attribute, int index) {
        Value result;
        List<Value> values = valueAssignments.get(attribute);
        if (null != values) {
            result = values.get(index);
        } else {
            result = null;
        }
        return result;        
    }
    
    /**
     * Returns whether there is an assignment of <code>value</code> to <code>attribute</code>.
     * 
     * @param attribute the attribute to check (we use the more common type to avoid superfluous 
     *   type casts in the caller)
     * @param value the value to check for within <code>attribute</code>
     * @return <code>true</code> if value is set for <code>attribute</code>, <code>false</code> else
     */
    public boolean hasValue(AbstractVariable attribute, Value value) {
        boolean result = false;
        List<Value> values = valueAssignments.get(attribute);
        if (null != values) {
            result = values.contains(value);
        } 
        return result;
    }
    
    /**
     * Deletes all value assignments.
     */
    public void clear() {
        valueAssignments.clear();
    }
    
    /**
     * Returns whether there are value assignments.
     * 
     * @return <code>true</code> if there are no value assignments, <code>false</code> else
     */
    public boolean isEmpty() {
        return valueAssignments.isEmpty();
    }
    
    /**
     * Returns whether there are value assignments in <code>values</code>.
     * 
     * @param values the value assignments instance to be tested
     * @return <code>true</code> if there are no value assignments 
     *   (or <code>values == <b>null</b></code>, <code>false</code> else
     */
    public static boolean isEmpty(AttributeValues values) {
        return null == values || values.isEmpty();
    }
    
    /**
     * Transfers all value assignments from <code>source</code> to <code>target</code>.
     * 
     * @param target the target of the transfer (value assignments may be modified)
     * @param source the attribute where to take the assginments from
     */
    public void setValues(Attribute target, Attribute source) {
        List<Value> sourceValues = valueAssignments.get(source);
        List<Value> targetValues = valueAssignments.get(target);
        if (null == targetValues) {
            if (null != sourceValues) {
                targetValues = new ArrayList<Value>();
                targetValues.addAll(sourceValues);
                valueAssignments.put(target, targetValues);
            } // else nothing to do
        } else {
            if (null == sourceValues) {
                valueAssignments.remove(target);
            } else {
                targetValues.clear();
                targetValues.addAll(sourceValues);
            }
        }
    }
    
    /**
     * Returns whether the given <code>attribute</code> is contained in this value set.
     * 
     * @param attribute the attribute to search for
     * @return <code>true</code> if it is contained, <code>false</code> else
     */
    public boolean contains(Attribute attribute) {
        return valueAssignments.containsKey(attribute);
    }
    
    /**
     * Returns a textual description of this object.
     * 
     * @return a textual description
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        Iterator<Map.Entry<Attribute, List<Value>>> iter = valueAssignments.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Attribute, List<Value>> entry = iter.next();
            result.append(entry.getKey().getName());
            result.append("={");
            if (null != entry.getValue()) {
                Iterator<Value> valIter = entry.getValue().iterator();
                while (valIter.hasNext()) {
                    result.append(valIter.next());
                    if (valIter.hasNext()) {
                        result.append(", ");
                    }
                }
            }
            result.append("}");
            if (iter.hasNext()) {
                result.append("\n");
            }
        }
        return result.toString();
    }
    
    /**
     * Resolve unresolved attributes in <code>project</code>. In case that
     * resolution works properly, {@link #valueAssignments} will be changed
     * and {@link #unresolvedAssignments} will be set to <b>null</b>.
     * 
     * @param project the project used to resolve unresolved
     *   attributes added by {@link #addUnresolved(String, List)}
     * @param clear clear the contents of this instance before resolving
     * @throws AttributeException in case that the resolution fails and
     *   this instance was not changed
     */
    public void resolveUsing(Project project, boolean clear) throws AttributeException {
        if (null != unresolvedAssignments) {
            ResolutionVisitor vis = new ResolutionVisitor();
            project.accept(vis);
            String errors = vis.getErrors();
            // although the new code fulfills the test, unsure whether this was intended in that way
            /*Map<Attribute, List<Value>> assignments = new HashMap<Attribute, List<Value>>();
            StringBuilder errors = new StringBuilder();
            for (Map.Entry<String, List<String>> entry : unresolvedAssignments.entrySet()) {
                try {
                    Attribute attr = (Attribute) ModelQuery.findElementByName(project, entry.getKey(), Attribute.class);
                    if (null != attr) {
                        List<Value> valList = new ArrayList<Value>();
                        for (String value : entry.getValue()) {
                            try {
                                valList.add(ValueFactory.createValue(attr.getType(), value));
                            } catch (ValueDoesNotMatchTypeException e) {
                                appendError(errors, e.getMessage());
                            }
                        }
                        assignments.put(attr, valList);
                    } else {
                        appendError(errors, "attribute '" + entry.getKey() + "' not found");
                    }
                } catch (ModelQueryException e) {
                    appendError(errors, e.getMessage());
                }
            }*/
            if (0 == errors.length()) {
                if (clear) {
                    valueAssignments = vis.getAssignments();
                } else {
                    valueAssignments.putAll(vis.getAssignments());
                }
                unresolvedAssignments = null;
            } else {
                throw new AttributeException(errors);
            }
        }
    }

    /**
     * A visitor for resolving attribute values.
     * 
     * @author Holger Eichelberger
     */
    private class ResolutionVisitor implements IModelVisitor {

        private Map<Attribute, List<Value>> assignments = new HashMap<Attribute, List<Value>>();
        private StringBuilder errors = new StringBuilder();
        
        /**
         * Returns the actual assignments.
         * 
         * @return the actual assignments
         */
        public Map<Attribute, List<Value>> getAssignments() {
            return assignments;
        }
        
        /**
         * Returns the errors occurred while assignment.
         * 
         * @return the errors
         */
        public String getErrors() {
            return errors.toString();
        }
        
        @Override
        public void visitEnum(Enum eenum) {
        }

        @Override
        public void visitOrderedEnum(OrderedEnum eenum) {
        }

        @Override
        public void visitCompound(Compound compound) {
            for (int e = 0; e < compound.getDeclarationCount(); e++) {
                compound.getDeclaration(e).accept(this);
            }
        }

        @Override
        public void visitDerivedDatatype(DerivedDatatype datatype) {
        }

        @Override
        public void visitEnumLiteral(EnumLiteral literal) {
        }

        @Override
        public void visitReference(Reference reference) {
        }

        @Override
        public void visitSequence(Sequence sequence) {
        }

        @Override
        public void visitSet(de.uni_hildesheim.sse.model.varModel.datatypes.Set set) {
        }

        @Override
        public void visitProject(Project project) {
            resolve(project);
            for (int e = 0; e < project.getElementCount(); e++) {
                project.getElement(e).accept(this);
            }
        }

        @Override
        public void visitProjectImport(ProjectImport pImport) {
        }

        @Override
        public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
            resolve(decl);
        }

        @Override
        public void visitAttribute(Attribute attribute) {
        }

        @Override
        public void visitConstraint(Constraint constraint) {
        }

        @Override
        public void visitFreezeBlock(FreezeBlock freeze) {
        }

        @Override
        public void visitOperationDefinition(OperationDefinition opdef) {
        }

        @Override
        public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        }

        @Override
        public void visitProjectInterface(ProjectInterface iface) {
        }

        @Override
        public void visitComment(Comment comment) {
        }

        @Override
        public void visitAttributeAssignment(AttributeAssignment assignment) {
            for (int e = 0; e < assignment.getElementCount(); e++) {
                assignment.getElement(e).accept(this);
            }
        }

        /**
         * Resolves an attributable element.
         * 
         * @param elt the element to be resolved
         */
        private void resolve(IAttributableElement elt) {
            for (Map.Entry<String, List<String>> entry : unresolvedAssignments.entrySet()) {
                Attribute attr = elt.getAttribute(entry.getKey());
                if (null != attr) {
                    List<Value> valList = new ArrayList<Value>();
                    for (String value : entry.getValue()) {
                        try {
                            valList.add(ValueFactory.createValue(attr.getType(), value));
                        } catch (ValueDoesNotMatchTypeException e) {
                            appendError(errors, e.getMessage());
                        }
                    }
                    assignments.put(attr, valList);
                } else {
                    appendError(errors, "attribute '" + entry.getKey() + "' not found");
                }
            }
        }

    }

    
    /**
     * Appends <code>text</code> to <code>builder</code>.
     * 
     * @param builder the builder to append to
     * @param text the text to be appended
     */
    private static void appendError(StringBuilder builder, String text) {
        if (builder.length() > 0) {
            builder.append(", ");
        }
        builder.append(text);
    }
    
    /**
     * Adds unresolved attributes and values. This method is intended
     * if attribute values are about to be stored in a configuration
     * file, read back from a mechanism which does not have access to
     * the variability model and are then later resolved using 
     * {@link #resolveUsing(Project, boolean)}.
     * 
     * @param attribute the name of the attribute
     * @param values the individual values
     */
    public void addUnresolved(String attribute, List<String> values) {
        if (null == unresolvedAssignments) {
            unresolvedAssignments = new HashMap<String, List<String>>();
        }
        int size = values.size();
        ArrayList<String> valuesCopy = new ArrayList<String>(size);
        for (int v = 0; v < size; v++) {
            valuesCopy.add(values.get(v));
        }
        unresolvedAssignments.put(attribute, valuesCopy);
    }
    
    /**
     * Turns a <code>value</code> into a string. Do not directly print a
     * Value.
     * 
     * @param value the value to be converted
     * @return the textual representation
     */
    public static String toString(Value value) {
        // may require an own visitor here in future...
        String result = StringProvider.toIvmlString(value);
        if (value instanceof EnumValue) {
            // cut qualified IVML name as this is not recognized by the ValueFactory
            int pos = result.lastIndexOf('.');
            if (pos > 0) {
                result = result.substring(pos + 1);
            }
        }
        return result;
    }
    
}
