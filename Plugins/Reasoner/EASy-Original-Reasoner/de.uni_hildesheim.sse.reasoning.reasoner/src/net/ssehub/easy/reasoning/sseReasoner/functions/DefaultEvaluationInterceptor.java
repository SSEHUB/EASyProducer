/*
 * Copyright 2009-2021 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationAccessor;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationContext;
import net.ssehub.easy.varModel.cstEvaluation.IEvaluationInterceptor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Supports the special constraint evaluation of default values, in particular interactions with default value 
 * constraints and initial assignments of compound values. For such a batch of related default value constraints, the 
 * reasoner collects them along with the initial assignment constraint (incremental default value assignment does not 
 * work with the config model as the assignment state immediately flips from DEFAULT to ASSIGNED leading to accidental 
 * overrides of default and initial values). Thus, such an evaluation interceptor is set before evaluating the related 
 * default value constraints, collects all assigned (nested) values in a secondary data structure. When finally 
 * ({@link #markFinal()}) the  initial assignment constraint is evaluated, first the initial values (except for 
 * Java-null values which occur per 
 * default for undefined slots in IVML values) overwrite the collected default values where needed and, second, before 
 * setting the (original) value, the composed/collected initial value is determined and supersedes the (original) value,
 * i.e., performing an in-place correction of the incomplete initial value.  
 * 
 * Currently, IVML containers are not supported.
 *  
 * @author Holger Eichelberger
 */
public class DefaultEvaluationInterceptor implements IEvaluationInterceptor, IValueParent {

    private IValueEntry value;
    private boolean isLast = false;
    
    @Override
    public Value getValue(IDecisionVariable var) {
        Value result = null;
        if (null != var) {
            result = getValue(var, value, null, this);
        }
        return result;
    }

    @Override
    public boolean setValue(IDecisionVariable var, Value val, boolean asAssignment, EvaluationAccessor acc) {
        boolean successful = false;
        if (null != var) {
            EvaluationContext context = acc.getContext();
            if (isLast) {
                // prevent accidental endless recursion, shall be this, but...
                IEvaluationInterceptor interceptor = context.setEvaluationInterceptor(null);
                acc.setValue(getValue(var, value, val, this), asAssignment);
                context.setEvaluationInterceptor(interceptor);
            } else {
                // resolve var, also the very first time when slots is empty
                IValueEntry e = resolve(var, true, this.value, this);
                e.setValue(val, var.getDeclaration().getType());
            }
        }
        return successful;
    }
    
    /**
     * Clears this instance for reuse.
     */
    public void clear() {
        isLast = false;
        value = null;
    }
    
    /**
     * Marks the collected values to be final to take over/supersede the collected value to be obtained via 
     * {@link #getValue(IDecisionVariable, IValueEntry, Value, IValueParent)} in 
     * {@link #setValue(IDecisionVariable, Value, boolean, EvaluationAccessor)}.
     */
    public void markFinal() {
        isLast = true;
    }

    /**
     * Creates an entry dependent on the value type.
     * 
     * @param parent the parent value instance in the secondary structure, initially on top-level an instance 
     *     of {@link DefaultEvaluationInterceptor}.
     * @param slot the slot/variable to fill with {@code value}
     * @param value the value of {@code} slot, may be a basic or a complex value
     * @param type used to determine the type of value entry to create, used as backup if {@code value} does not carry 
     *     an own, potentially specialized value type
     * @return the created value entry
     * 
     * @see IValueEntry#setValue(Value, IDatatype)
     * @see IValueEntry#putEntry(String, IValueEntry)
     */
    static IValueEntry createEntry(IValueParent parent, String slot, Value value, IDatatype type) {
        IValueEntry result;
        if (TypeQueries.isCompound(DerivedDatatype.resolveToBasis(type))) {
            result = new ValueMap();
        } else {
            result = new ValueEntry();
        } // we may need here also a ValueList/Set for collections
        result.setValue(value, type);
        parent.putEntry(slot, result);
        return result;
    }

    /**
     * Resolves the nested path to {@code var} starting from its top-most decision variable in order to obtain
     * the respective, corresponding value entry in the secondary data structure.
     * 
     * @param var the variable to resolve
     * @param createIfMissing create value instances in the secondary data structure if they are missing 
     *     ({@code true} for setter, {@code false} for getter)
     * @param top the top-level value entry to hook into
     * @param topParent the parent of the top-level value entry, needed to register a new top-level value entry if 
     *   none was {@link #createEntry(IValueParent, String, Value, IDatatype) created} so far 
     * @return the resolved value entry, may be <b>null</b> if none is known and {@code createIfMissing} is 
     *   {@code false}
     */
    private static IValueEntry resolve(IDecisionVariable var, boolean createIfMissing, IValueEntry top, 
        IValueParent topParent) {
        IValueEntry result;
        AbstractVariable decl = var.getDeclaration();
        if (var.getParent() instanceof IDecisionVariable) {
            IValueEntry parEntry = resolve((IDecisionVariable) var.getParent(), createIfMissing, top, topParent);
            if (null != parEntry) {
                result = parEntry.getEntry(decl.getName());
                if (null == result) {
                    result = createEntry(parEntry, decl.getName(), var.getValue(), decl.getType());
                }
            } else {
                result = null;
            }
        } else {
            if (null == top) {
                top = createEntry(topParent, decl.getName(), var.getValue(), decl.getType());
            }
            result = top;
            if (null == top.getType()) {
                top.setValue(var.getValue(), var.getDeclaration().getType());
            }
        }
        return result;
    }
    
    static Value getValue(IDecisionVariable var, IValueEntry top, Value val, IValueParent topParent) {
        Value result;
        IValueEntry entry = resolve(var, false, top, topParent);
        if (null != entry) {
            if (null != val) {
                entry.setValue(val, var.getDeclaration().getType());
            }
            result = entry.getValue();
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public void putEntry(String name, IValueEntry entry) {
        value = entry;
    }

}

/**
 * An instance that holds value entries, in particular the the top-level value entry.
 * 
 * @author Holger Eichelberger
 */
interface IValueParent {
    
    /**
     * Puts a given value entry with its (slot) name.
     * 
     * @param name the name (may be ignored on top-level)
     * @param entry the entry
     */
    public void putEntry(String name, IValueEntry entry);
    
}

/**
 * Represents a value entry (may be single or complex) also being a {@link IValueParent}.
 * 
 * @author Holger Eichelberger
 */
interface IValueEntry extends IValueParent {

    /**
     * Returns the value of the entry.
     * 
     * @return the value
     */
    public Value getValue();
    
    /**
     * Returns the data (most-specific, dynamic) type of the entry.
     * 
     * @return the data type
     */
    public IDatatype getType();
    
    /**
     * Returns a sub-entry.
     * 
     * @param name the name/slot of the sub-entry
     * @return the sub-entry, may be <b>null</b> if the entry does not exist
     */
    public IValueEntry getEntry(String name);
    
    /**
     * Changes the value of this entry.
     * 
     * @param value the value (may be a complex value, e.g., in case of compounds)
     * @param type the (most-specific, dynamic) type of this entry
     */
    public void setValue(Value value, IDatatype type);
    
}

/**
 * Implements a value entry for basic/primitive values. Currently, this type also applies to collections.
 * 
 * @author Holger Eichelberger
 */
class ValueEntry implements IValueEntry {
    
    private Value value;
    private IDatatype type;
    
    @Override
    public Value getValue() {
        return value;
    }
    
    @Override
    public IDatatype getType() {
        return type;
    }

    @Override
    public IValueEntry getEntry(String name) {
        return null;
    }

    @Override
    public void putEntry(String name, IValueEntry entry) {
    }

    @Override
    public void setValue(Value value, IDatatype type) {
        if (null == value || value == NullValue.INSTANCE) {
            this.type = type;
        } else {
            this.type = value.getType();
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry: " + (null != value ? value.toString() : null);
    }

}

/**
 * Implements a value entry for complex values with named sub-entries (compounds).
 * 
 * @author Holger Eichelberger
 */
class ValueMap implements IValueEntry {
    
    private IDatatype type;        
    private Map<String, IValueEntry> slots = new HashMap<String, IValueEntry>();
    
    @Override
    public IDatatype getType() {
        return type;
    }

    @Override
    public Value getValue() {
        List<Object> tmp = new ArrayList<Object>();
        tmp.add(CompoundValue.SPECIAL_SLOT_NAME_TYPE);
        tmp.add(getType().getName());
        for (Map.Entry<String, IValueEntry> e : slots.entrySet()) {
            tmp.add(e.getKey());
            tmp.add(e.getValue().getValue());
        }
        try {
            return ValueFactory.createValue(getType(), tmp.toArray());
        } catch (ValueDoesNotMatchTypeException e) {
            // shall not occur
            getLogger().error("getValue: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public IValueEntry getEntry(String name) {
        return slots.get(name);
    }

    @Override
    public void putEntry(String name, IValueEntry entry) {
        slots.put(name,  entry);
    }

    @Override
    public void setValue(Value value, IDatatype type) {
        if (null == value || value == NullValue.INSTANCE) {
            this.type = type;
        } else {
            this.type = value.getType();
        }
        if (value instanceof CompoundValue) {
            CompoundValue cValue = (CompoundValue) value;
            for (String slot : cValue.getSlotNames()) {
                Value slotValue = cValue.getNestedValue(slot);
                if (null != slotValue) { // default value if not given, ignore here
                    IValueEntry entry = getEntry(slot);
                    if (null == entry) {
                        entry = DefaultEvaluationInterceptor.createEntry(this, slot, slotValue, slotValue.getType());
                    } else { // value overrides already existing default
                        entry.setValue(slotValue, slotValue.getType());
                    }
                }
            }
        } else if (value != NullValue.INSTANCE) { // don't complain about any, always compatible
            getLogger().error("setValue: value shall be CompoundValue, not " 
                + (null == value ? null : value.getType()));
        }
    }

    @Override
    public String toString() {
        return "Map: " + slots.toString();
    }

    /**
     * Returns the actual EASy logger for this (containing) class.
     * 
     * @return the logger instance
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(DefaultEvaluationInterceptor.class, Descriptor.BUNDLE_NAME);
    }

}
