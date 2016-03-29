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

/**
 * A specific visitor for building type identities.
 * 
 * @author Holger Eichelberger
 */
public interface IDatatypeVisitor {
       
    /**
     * Is called by an arbitrary data type.
     * 
     * @param datatype the data type.
     */
    public void visitDatatype(IDatatype datatype);

    /**
     * Is called by an AnyType.
     * 
     * @param datatype the data type.
     */
    public void visitAnyType(AnyType datatype);


    /**
     * Is called by a MetaType.
     * 
     * @param datatype the data type.
     */
    public void visitMetaType(MetaType datatype);

    /**
     * Is called by an <code>DerivedDatatype</code> data type.
     * 
     * @param datatype the data type.
     */
    public void visitDerivedType(DerivedDatatype datatype);
    
    /**
     * Is called by a set data type.
     * 
     * @param set the set instance
     */
    public void visitSet(Set set);

    /**
     * Is called by a sequence datatype.
     * 
     * @param sequence the sequence instance
     */
    public void visitSequence(Sequence sequence);

    /**
     * Is called by a reference data type.
     * 
     * @param reference the references instance
     */
    public void visitReference(Reference reference);
    
    /**
     * Visiting method for visiting a <code>BooleanType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitBooleanType(BooleanType type);

    /**
     * Visiting method for visiting a <code>StringType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitStringType(StringType type);

    /**
     * Visiting method for visiting a <code>ConstraintType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitConstraintType(ConstraintType type);
    
    /**
     * Visiting method for visiting a <code>IntegerType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitIntegerType(IntegerType type);

    /**
     * Visiting method for visiting a <code>VersionType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitVersionType(VersionType type);
    
    /**
     * Visiting method for visiting a <code>RealType</code>.
     * @param type The <code>IDatatype</code> which should be visited.
     */
    public void visitRealType(RealType type);

    /**
     * Visiting method for visiting a <code>Compound</code>.
     * @param compound The <code>Compound</code> which should be visited.
     */
    public void visitCompoundType(Compound compound);
    /**
     * Visiting method for visiting a <code>Enum</code>.
     * @param enumType The <code>Enum</code> which should be visited.
     */
    public void visitEnumType(Enum enumType);
    /**
     * Visiting method for visiting a <code>OrderredEnum</code>.
     * @param enumType The <code>Enum</code> which should be visited.
     */
    public void visitOrderedEnumType(OrderedEnum enumType);
    
}
