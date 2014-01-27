package de.uni_hildesheim.sse.model.varModel.datatypes;


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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitSet(Set set) {
        constructSurrounded(setPrefix, set.getContainedType());
    }

    /**
     * {@inheritDoc}
     */
    public void visitSequence(Sequence sequence) {
        constructSurrounded(sequencePrefix, sequence.getContainedType());
    }

    /**
     * {@inheritDoc}
     */
    public void visitReference(Reference ref) {
        constructSurrounded(refPrefix, ref.getType());
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
        type.accept(this);
        append(close);
    }

    /**
     * {@inheritDoc}
     */
    public void visitBooleanType(BooleanType type) {
        visitDatatype(type);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstraintType(ConstraintType type) {
        visitDatatype(type);
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAnyType(AnyType type) {
        visitDatatype(type);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitMetaType(MetaType type) {
        visitDatatype(type);        
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitStringType(StringType type) {
        visitDatatype(type);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitIntegerType(IntegerType type) {
        visitDatatype(type);        
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitCompoundType(Compound compound) {
        visitDatatype(compound);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitEnumType(Enum enumType) {
        visitDatatype(enumType);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitOrderedEnumType(OrderedEnum enumType) {
        visitDatatype(enumType);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitDerivedType(DerivedDatatype datatype) {
        visitDatatype(datatype);
    }

}