/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 * A visitor which determines the (recursive) base type of a given
 * type. In particular, the topmost base type of a derived type is
 * determined.
 * 
 * @author Holger Eichelberger
 */
public class BaseTypeVisitor implements IDatatypeVisitor {

    private static final List<BaseTypeVisitor> POOL = new ArrayList<BaseTypeVisitor>(); 

    private IDatatype type;

    /**
     * Prevents initialization from outside.
     */
    private BaseTypeVisitor() {
    }
    
    /**
     * Defines the initial value of the base type (also used for resetting and reuse).
     * 
     * @param type the initial base type
     */
    private void setType(IDatatype type) {
        this.type = type;
    }
    
    /**
     * Returns the inferred base type.
     * 
     * @return the base type
     */
    private IDatatype getType() {
        return type;
    }
    
    /**
     * Obtains an instance from the pool.
     * 
     * @param type the type to be analyzed
     * @return the instance, to be released by {@link #releaseInstance(BaseTypeVisitor)}
     */
    private static final synchronized BaseTypeVisitor getInstance(IDatatype type) {
        BaseTypeVisitor result;
        if (POOL.size() > 0) {
            result = POOL.remove(0);
        } else {
            result = new BaseTypeVisitor();
        }
        result.setType(type);
        return result;
    }

    /**
     * Releases an instance to the pool.
     * 
     * @param visitor the instance to be released
     */
    private static final synchronized void releaseInstance(BaseTypeVisitor visitor) {
        visitor.setType(null);
        POOL.add(visitor);
    }
    
    /**
     * Returns the base type of <code>type</code>.
     * 
     * @param type the type the base type shall be determined
     * @return <code>type</code> or the base type
     */
    public static final synchronized IDatatype getBaseType(IDatatype type) {
        BaseTypeVisitor visitor = getInstance(type);
        type.accept(visitor);
        IDatatype result = visitor.getType();
        releaseInstance(visitor);
        return result;
    }
    
    @Override
    public void visitDatatype(IDatatype datatype) {
        type = datatype;
    }

    @Override
    public void visitAnyType(AnyType datatype) {
        type = datatype;
    }

    @Override
    public void visitMetaType(MetaType datatype) {
        type = datatype;
    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        // defer changing this.type to other methods
        // shall terminate due to semantics of IVML
        datatype.getBasisType().accept(this);
    }

    @Override
    public void visitSet(Set set) {
        this.type = set;
    }

    @Override
    public void visitSequence(Sequence sequence) {
        this.type = sequence;
    }

    @Override
    public void visitReference(Reference reference) {
        this.type = reference;
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        this.type = type;
    }

    @Override
    public void visitStringType(StringType type) {
        this.type = type;
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
        this.type = type;
    }
    
    @Override
    public void visitIntegerType(IntegerType type) {
        this.type = type;
    }

    @Override
    public void visitRealType(RealType type) {
        this.type = type;
    }

    @Override
    public void visitCompoundType(Compound compound) {
        type = compound;
    }

    @Override
    public void visitEnumType(Enum enumType) {
        type = enumType;
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        type = enumType;
    }

    @Override
    public void visitVersionType(VersionType type) {
        this.type = type;
    }

}
