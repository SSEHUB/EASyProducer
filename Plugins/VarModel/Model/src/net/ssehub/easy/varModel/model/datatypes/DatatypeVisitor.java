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
 * Implements a default visitor where contained types are surrounded
 * by their containing types.
 * 
 * @author Holger Eichelberger
 */
public abstract class DatatypeVisitor implements IDatatypeVisitor {

    private String setPrefix;
    private String sequencePrefix;
    private String refPrefix;
    private String open;
    private String close;

    /**
     * Collects results.
     */
    private StringBuilder builder = new StringBuilder();
    
    /**
     * Stores whether qualified names shall be collected.
     */
    private QualifiedNameMode qualifiedNameMode;

    /**
     * Constructs a surrounding visitor (which particularly handles set, sequence and refs).
     * 
     * @param setPrefix the prefix for sets
     * @param sequencePrefix the prefix for sequences
     * @param refPrefix the prefix for references
     */
    protected DatatypeVisitor(String setPrefix, String sequencePrefix, String refPrefix) {
        this(setPrefix, sequencePrefix, refPrefix, "(", ")");
    }

    /**
     * Constructs a surrounding visitor (which particularly handles set, sequence and refs).
     * 
     * @param setPrefix the prefix for sets
     * @param sequencePrefix the prefix for sequences
     * @param refPrefix the prefix for references
     * @param open the string to be appended after a prefix and before the contained type
     * @param close the string to be appended after the contained type
     */
    protected DatatypeVisitor(String setPrefix, String sequencePrefix, String refPrefix, String open, String close) {
        this.setPrefix = setPrefix;
        this.sequencePrefix = sequencePrefix;
        this.refPrefix = refPrefix;
        this.open = open;
        this.close = close;
    }

    /**
     * Appends the given string to the result.
     * 
     * @param text the string to be appended
     */
    protected void append(String text) {
        builder.append(text);
    }
    
    /**
     * Returns the result.
     * 
     * @return the result
     */
    public String getResult() {
        return builder.toString();
    }

    /**
     * Returns the mode to be applied when collecting names.
     * 
     * @return the collection mode
     */
    public QualifiedNameMode getQualifiedNameMode() {
        return qualifiedNameMode;
    }
    
    /**
     * Switches the mode for considering names. 
     * 
     * @param qualifiedNameMode the new mode
     */
    public void setQualifiedNameMode(QualifiedNameMode qualifiedNameMode) {
        this.qualifiedNameMode = qualifiedNameMode;
    }
    
    /**
     * Clears the result.
     */
    public void clear() {
        builder = new StringBuilder();
        //builder.delete(0, builder.length());
    }

    @Override
    public void visitDatatype(IDatatype datatype) {
        switch (getQualifiedNameMode()) {
        case QUALIFIED:
            append(datatype.getQualifiedName());
            break;
        case UNIQUE:
            append(datatype.getUniqueName());
            break;
        case UNQUALIFIED:
            append(datatype.getName());
            break;
        default:
            break;
        }
    }

    @Override
    public void visitSet(Set set) {
        constructSurrounded(setPrefix, set.getContainedType());
    }

    @Override
    public void visitSequence(Sequence sequence) {
        constructSurrounded(sequencePrefix, sequence.getContainedType());
    }

    @Override
    public void visitReference(Reference ref) {
        constructReferenceName(ref.getType());
    }
    
    /**
     * Constructs a reference name from the given contained <code>type</code>.
     * 
     * @param type the contained type
     */
    public void constructReferenceName(IDatatype type) {
        constructSurrounded(refPrefix, type);
    }

    /**
     * Constructs a surrounded datatype, i.e. 
     * the <code><i>prefix</i>(</code><i>type-visited</i><code><i>)</i></code>.
     * 
     * @param prefix the prefix to be used
     * @param type the (contained) type to be visited
     */
    protected void constructSurrounded(String prefix, IDatatype type) {
        append(prefix);
        append(open);
        if (null != type) {
            type.accept(this);
        }
        append(close);
    }

    @Override
    public void visitBooleanType(BooleanType type) {
        visitDatatype(type);        
    }

    @Override
    public void visitConstraintType(ConstraintType type) {
        visitDatatype(type);
    }
    
    @Override
    public void visitAnyType(AnyType type) {
        visitDatatype(type);        
    }

    @Override
    public void visitMetaType(MetaType type) {
        visitDatatype(type);        
    }
    
    @Override
    public void visitStringType(StringType type) {
        visitDatatype(type);        
    }

    @Override
    public void visitIntegerType(IntegerType type) {
        visitDatatype(type);        
    }

    @Override
    public void visitRealType(RealType type) {
        visitDatatype(type);        
    }
    
    /**
     * Returns the textual representation of this type.
     * @param type the type to be represented
     * @return the textual representation
     */
    public String getType(IDatatype type) {
        type.accept(this);
        return getResult();
    }

    @Override
    public void visitCompoundType(Compound compound) {
        visitDatatype(compound);        
    }

    @Override
    public void visitEnumType(Enum enumType) {
        visitDatatype(enumType);        
    }

    @Override
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitDatatype(enumType);        
    }

    @Override
    public void visitDerivedType(DerivedDatatype datatype) {
        visitDatatype(datatype);
    }
    
    @Override
    public void visitVersionType(VersionType type) {
        visitDatatype(type);        
    }

}