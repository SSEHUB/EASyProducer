package core;

public class Configuration {

	// File location
	public static final String FOLDER_PATH = "C:/Sizonenko/ReasoningOutput/";
	public static final String FILE_NAME = "TestModel";
	public static final String FILE_EXTENSION = ".ivml";
	
	// Variable count	
	public static final int VARIABLES = 10;
	
	// Basic variable weight %
	public static final int BASIC = 100;
	
	public static final int BOOLEAN = 40;
	public static final int INTEGER = 20;
	public static final int REAL = 20;
	public static final int ENUM = 10;
	public static final int STRING = 10;
	public static final int ATTRIBUTE = 0;
	public static final int CONSTRAINT = 0;
	
	// Derived variable weight %
	public static final int DERIVED = 0;
	
	public static final int SEQUENCEOF = 20;
	public static final int SETOF = 20;
	public static final int TYPEDEF = 0;
	public static final int COMPOUND = 60;
	public static final int REFINES = 0;
	public static final int REFTO = 0;	
	
	// Compound configuration
	public static final int COMPOUND_VATIABLES = 10;
	public static final boolean HAS_CONSTRAINTS = false;
	
	// Constraint count
	public static final int CONSTRAINTS = 20;
	
	// Assignment / Expression weight %
	public static final int ASSIGNMENTS = 50;
	public static final int EXPRESSIONS = 50;
	
	// Expression construction weight %
	public static final int VARIABLE = 40;
	public static final int CONSTANT = 40;
	public static final int EXPRESSION = 20;
	
	
	// Expression operations weight %
	
	// Boolean algebra operations
	public static final int BOOL_ALGEBRA = 20;
	
	public static final int AND = 40;
	public static final int OR = 40;
	public static final int XOR = 20;
	public static final int NOT = 0;
	
	// Equality operations
	public static final int EQUALITY = 40;
	
	public static final int EQUALS = 80;
	public static final int NOT_EQUALS = 20;
	
	// Arithmetic counting operations
	public static final int ARITHMETIC = 10;
	
	public static final int ADDITION = 40;
	public static final int SUBSTRACTION = 40;
	public static final int MULTIPLICATION = 10;
	public static final int DIVISION = 10;
	
	// Arithmetic comparison operations
	public static final int ARITHMETIC_COMPARE = 10;
	
	public static final int GREATER = 40;
	public static final int LESSER = 40;
	public static final int GREATEROREQUALS = 10;
	public static final int LESSEROREQUALS = 10;
	
	// Implies operation
	public static final int IMPLIES = 20;
}
