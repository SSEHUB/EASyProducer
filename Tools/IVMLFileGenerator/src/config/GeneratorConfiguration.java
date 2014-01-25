package config;


public class GeneratorConfiguration {
	
	public static final GeneratorConfiguration INSTANCE = new GeneratorConfiguration();
	
	/*
	 * This switch is used to define random values for each
	 * generated decision variable. Currently, no reasoner
	 * supports model checking, thus, this is true by default. 
	 */
	private boolean isConfiguration = true;
	
	private int complexityLevel = 1;
	private boolean useBooleanElements = false;
	private boolean useIntElements = false;
	private boolean useRealElements = false;
	private boolean useStringElements = false;
	private boolean useEnumElements = false;
	private boolean useContainerElements = false;
	private boolean useCompoundElements = false;
	
	private String boolVariableName = "bool_";
	private String intVariableName = "int_";
	private String realVariableName = "real_";
	private String stringVariableName = "string_";
	private String enumVariableName = "enum_";
	private String setVariableName = "set_";
	private String sequenceVariableName = "sequence_";
	private String compoundVariableName = "compound_";
	
	private int boolVarNum = 0;
	private int intVarNum = 0;
	private int intVarBounds = 10; 
	private int realVarNum = 0;
	private int realValMultiplicator = 10;
	private int stringVarNum = 0;
	private int enumVarNum = 0;
	private int containerVarNum = 0;
	private int compoundVarNum = 0;
	private int derivedVarNum = 0;
	
	private int logicalConstraintNum = 0;
	private int arithmeticConstraintNum = 0;
	private int containerConstraintNum = 0;
	private int compoundConstraintNum = 0;
	
	//Singleton!
	private GeneratorConfiguration(){}
	
	/**
	 * This method returns the multiplicator for real value
	 * generation. This is required as the method for random
	 * values will produce, for example, 0.2356. In order to
	 * generate more realistic real values, the random values
	 * are adjusted in terms of: 0.2356 * realValMultiplicator
	 * @return the multiplicator for real values
	 */
	public int getRealValMultiplicator() {
		return realValMultiplicator;
	}
	
	/**
	 * This method sets the multiplicator for real value
	 * generation. This is required as the method for random
	 * values will produce, for example, 0.2356. In order to
	 * generate more realistic real values, the random values
	 * are adjusted in terms of: 0.2356 * realValMultiplicator
	 * @param multiplicator the desired multiplicator for real values
	 */
	public void setRealValMultiplicator(int multiplicator) {
		this.realValMultiplicator = multiplicator;
	}
	
	/**
	 * This method returns the boundary for the integer
	 * variable values to be assigned to the variables.
	 * The value is interpreted as the upper bound (exclusive).
	 * By default, the value is 10.
	 * @return the boundary of the integer variable values
	 */
	public int getIntVarBounds() {
		return intVarBounds;
	}
	
	/**
	 * This method sets the boundary for the integer
	 * variable values to be assigned to the variables.
	 * The value is interpreted as the upper bound (exclusive).
	 * @param bound the desired boundary of the integer variable values
	 */
	public void setIntVarBounds(int bound) {
		this.intVarBounds = bound;
	}
	
	/**
	 * This method returns the specified complexity level
	 * of the constraints to be generated (1 = simple, ..., 3 = complex).
	 * @return the complexity level
	 */
	public int getComplexityLevel() {
		return complexityLevel;
	}
	
	/**
	 * This method sets the complexity level of the constraints
	 * to be generated (1= simple, ..., 3 = complex)
	 * @param complexity the desired complexity level
	 */
	public void setComplexityLevel(int complexity) {
		this.complexityLevel = complexity;
	}
	
	/**
	 * This method returns whether a model (decision variables
	 * without value assignments) or a configuration (decision
	 * variables with value assignments) should be generated. 
	 * @return returns true if the project should be a
	 * configuration, meaning that each decision variable will
	 * be assigned with random value. Otherwise - if no assignment
	 * is allowed - this method return false.
	 */
	public boolean getIsConfiguration() {
		return isConfiguration;
	}
	
	/**
	 * This method sets the status whether a model (decision
	 * variables without value assignments) or a configuration
	 * (decision variables with value assignments) should be
	 * generated.
	 * @param isConfig true if the project should be a
	 * configuration, meaning that each decision variable will
	 * be assigned with random value. Otherwise false (if no
	 * assignment is allowed).
	 */
	public void setIsConfiguration(boolean isConfig) {
		this.isConfiguration = isConfig;
	}
	
	/**
	 * This method returns the initial name of a Boolean
	 * decision variable. By default, this is "bool_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "bool_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a Boolean decision variable
	 */
	public String getBoolVariableName() {
		return boolVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * Boolean decision variables.
	 * @param boolVarName the new basic name for Boolean decision variable generation
	 */
	public void setBoolVariableName(String boolVarName) {
		this.boolVariableName = boolVarName;
	}
	
	/**
	 * This method returns the initial name of an integer
	 * decision variable. By default, this is "int_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "int_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for an integer decision variable
	 */
	public String getIntVariableName() {
		return intVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * integer decision variables.
	 * @param intVarName the new basic name for integer decision variable generation
	 */
	public void setIntVariableName(String intVarName) {
		this.intVariableName = intVarName;
	}
	
	/**
	 * This method returns the initial name of a real
	 * decision variable. By default, this is "real_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "real_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a real decision variable
	 */
	public String getRealVariableName() {
		return realVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * real decision variables.
	 * @param realVarName the new basic name for real decision variable generation
	 */
	public void setRealVariableName(String realVarName) {
		this.realVariableName = realVarName;
	}
	
	/**
	 * This method returns the initial name of a string
	 * decision variable. By default, this is "string_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "string_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a string decision variable
	 */
	public String getStringVariableName() {
		return stringVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * string decision variables.
	 * @param stringVarName the new basic name for string decision variable generation
	 */
	public void setStringVariableName(String stringVarName) {
		this.stringVariableName = stringVarName;
	}
	
	/**
	 * This method returns the initial name of an enumeration
	 * decision variable. By default, this is "enum_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "enum_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a enumeration decision variable
	 */
	public String getEnumVariableName() {
		return enumVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * enumeration decision variables.
	 * @param enumVarName the new basic name for enumeration decision variable generation
	 */
	public void setEnumVariableName(String enumVarName) {
		this.enumVariableName = enumVarName;
	}
	
	/**
	 * This method returns the initial name of a set
	 * decision variable. By default, this is "set_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "set_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a set decision variable
	 */
	public String getSetVariableName() {
		return setVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * set decision variables.
	 * @param setVarName the new basic name for set decision variable generation
	 */
	public void setSetVariableName(String setVarName) {
		this.setVariableName = setVarName;
	}
	
	/**
	 * This method returns the initial name of a sequence
	 * decision variable. By default, this is "sequence_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "sequence_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a sequence decision variable
	 */
	public String getSequenceVariableName() {
		return sequenceVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * sequence decision variables.
	 * @param setVarName the new basic name for sequence decision variable generation
	 */
	public void setSequenceVariableName(String sequenceVarName) {
		this.sequenceVariableName = sequenceVarName;
	}
	
	/**
	 * This method returns the initial name of a compound
	 * decision variable. By default, this is "compound_" while
	 * a number is appended in the course of the variable
	 * generation process, i.e. "compound_12" if it is the 12th
	 * decision variable generated for the same project
	 * @return the basic name for a compound decision variable
	 */
	public String getCompoundVariableName() {
		return compoundVariableName;
	}
	
	/**
	 * This method sets a new (custom) basic name for
	 * compound decision variables.
	 * @param setVarName the new basic name for compound decision variable generation
	 */
	public void setCompoundVariableName(String compoundVarName) {
		this.compoundVariableName = compoundVarName;
	}
	
	/*
	 * The following getter and setter methods are auto-generated.
	 * TODO JavaDoc has to be written for the below methods.
	 */
	public boolean getUseBooleanElements() {
		return useBooleanElements;
	}
	
	public void setUseBooleanElements(boolean useBooleanElements) {
		this.useBooleanElements = useBooleanElements;
	}
	
	public boolean getUseIntElements() {
		return useIntElements;
	}
	
	public void setUseIntElements(boolean useIntElements) {
		this.useIntElements = useIntElements;
	}
	
	public boolean getUseRealElements() {
		return useRealElements;
	}
	
	public void setUseRealElements(boolean useRealElements) {
		this.useRealElements = useRealElements;
	}
	
	public boolean getUseStringElements() {
		return useStringElements;
	}
	
	public void setUseStringElements(boolean useStringElements) {
		this.useStringElements = useStringElements;
	}
	
	public boolean getUseEnumElements() {
		return useEnumElements;
	}
	
	public void setUseEnumElements(boolean useEnumElements) {
		this.useEnumElements = useEnumElements;
	}
	
	public boolean getUseContainerElements() {
		return useContainerElements;
	}
	
	public void setUseContainerElements(boolean useContainerElements) {
		this.useContainerElements = useContainerElements;
	}
	
	public boolean getUseCompoundElements() {
		return useCompoundElements;
	}
	
	public void setUseCompoundElements(boolean useCompoundElements) {
		this.useCompoundElements = useCompoundElements;
	}
	
	public int getBoolVarNum() {
		return boolVarNum;
	}
	
	public void setBoolVarNum(int boolVarNum) {
		this.boolVarNum = boolVarNum;
	}
	
	public int getIntVarNum() {
		return intVarNum;
	}
	
	public void setIntVarNum(int intVarNum) {
		this.intVarNum = intVarNum;
	}
	
	public int getRealVarNum() {
		return realVarNum;
	}
	
	public void setRealVarNum(int realVarNum) {
		this.realVarNum = realVarNum;
	}
	
	public int getStringVarNum() {
		return stringVarNum;
	}
	
	public void setStringVarNum(int stringVarNum) {
		this.stringVarNum = stringVarNum;
	}
	
	public int getEnumVarNum() {
		return enumVarNum;
	}
	
	public void setEnumVarNum(int enumVarNum) {
		this.enumVarNum = enumVarNum;
	}
	
	public int getContainerVarNum() {
		return containerVarNum;
	}
	
	public void setContainerVarNum(int containerVarNum) {
		this.containerVarNum = containerVarNum;
	}
	
	public int getCompoundVarNum() {
		return compoundVarNum;
	}
	
	public void setCompoundVarNum(int compoundVarNum) {
		this.compoundVarNum = compoundVarNum;
	}
	
	public int getDerivedVarNum() {
		return derivedVarNum;
	}
	
	public void setDerivedVarNum(int derivedVarNum) {
		this.derivedVarNum = derivedVarNum;
	}
	
	public int getLogicalConstraintNum() {
		return logicalConstraintNum;
	}
	
	public void setLogicalConstraintNum(int logicalConstraintNum) {
		this.logicalConstraintNum = logicalConstraintNum;
	}
	
	public int getArithmeticConstraintNum() {
		return arithmeticConstraintNum;
	}
	
	public void setArithmeticConstraintNum(int arithmeticConstraintNum) {
		this.arithmeticConstraintNum = arithmeticConstraintNum;
	}
	
	public int getContainerConstraintNum() {
		return containerConstraintNum;
	}
	
	public void setContainerConstraintNum(int containerConstraintNum) {
		this.containerConstraintNum = containerConstraintNum;
	}
	
	public int getCompoundConstraintNum() {
		return compoundConstraintNum;
	}
	
	public void setCompoundConstraintNum(int compoundConstraintNum) {
		this.compoundConstraintNum = compoundConstraintNum;
	}
}
