package core;

import java.util.ArrayList;
import java.util.List;

public class Distribution {
	
	public static List<Integer> variableDist = new ArrayList<Integer>();
	
	public static List <Integer> basicVariablesDist = new ArrayList<Integer>();
	
	public static List <Integer> derivedVariablesDist = new ArrayList<Integer>();
	
	public static List <Integer> constraintsDist = new ArrayList<Integer>();
	
	public static List <Integer> expressionDist = new ArrayList<Integer>();
	
	public static List <Integer> operationsDist = new ArrayList<Integer>();
	
	public static List <Integer> boolAlgebraOperationsDist = new ArrayList<Integer>();
	
	public static List <Integer> equalityOperationsDist = new ArrayList<Integer>();
	
	public static List <Integer> aritCountOperationsDist = new ArrayList<Integer>();
	
	public static List <Integer> aritCompOperationsDist = new ArrayList<Integer>();
	
	public static void distributeProportions() {
		distributeComplexity();
		distributeBasic();
		distributeDerived();
		distributeConstraints();
		distributeExpression();
		distributeOperations();
		distributeBoolAlgebraOperations();
		distributeEqualityOperations();
		distributeAritCountOperations();
		distributeAritCompOperations();
	}
		
	private static void distributeComplexity() {
		// Basic variables range 100 >= var >= 100-Configuration.BASIC 
		variableDist.add(0, 100 - Configuration.BASIC);
		// Derived variables range 100-Configuration.BASIC >= var >= 100-Configuration.DERIVED 
		variableDist.add(1, variableDist.get(0) - Configuration.DERIVED);
	}
	
	private static void distributeBasic() {
		basicVariablesDist.add(0, 100 - Configuration.BOOLEAN);
		basicVariablesDist.add(1, basicVariablesDist.get(0) - Configuration.INTEGER);
		basicVariablesDist.add(2, basicVariablesDist.get(1) - Configuration.REAL);
		basicVariablesDist.add(3, basicVariablesDist.get(2) - Configuration.ENUM);
		basicVariablesDist.add(4, basicVariablesDist.get(3) - Configuration.STRING);
		basicVariablesDist.add(5, basicVariablesDist.get(4) - Configuration.ATTRIBUTE);	
		basicVariablesDist.add(6, basicVariablesDist.get(5) - Configuration.CONSTRAINT);
	}
	
	private static void distributeDerived() {
		derivedVariablesDist.add(0, 100 - Configuration.SEQUENCEOF);
		derivedVariablesDist.add(1, derivedVariablesDist.get(0) - Configuration.SETOF);
		derivedVariablesDist.add(2, derivedVariablesDist.get(1) - Configuration.TYPEDEF);
		derivedVariablesDist.add(3, derivedVariablesDist.get(2) - Configuration.COMPOUND);
		derivedVariablesDist.add(4, derivedVariablesDist.get(3) - Configuration.REFINES);
		derivedVariablesDist.add(5, derivedVariablesDist.get(4) - Configuration.REFTO);		
	}
	
	private static void distributeConstraints() {
		constraintsDist.add(0, 100 - Configuration.ASSIGNMENTS);
		constraintsDist.add(1, constraintsDist.get(0) - Configuration.EXPRESSIONS);
	}
	
	private static void distributeExpression() {
		expressionDist.add(0, 100 - Configuration.VARIABLE);
		expressionDist.add(1, expressionDist.get(0) - Configuration.CONSTANT);
		expressionDist.add(2, expressionDist.get(1) - Configuration.EXPRESSION);		
	}
	
	private static void distributeOperations() {
		operationsDist.add(0, 100 - Configuration.BOOL_ALGEBRA);
		operationsDist.add(1, operationsDist.get(0) - Configuration.EQUALITY);
		operationsDist.add(2, operationsDist.get(1) - Configuration.ARITHMETIC);
		operationsDist.add(3, operationsDist.get(2) - Configuration.ARITHMETIC_COMPARE);
		operationsDist.add(4, operationsDist.get(3) - Configuration.IMPLIES);
	}
	
	private static void distributeBoolAlgebraOperations() {
		boolAlgebraOperationsDist.add(0, 100 - Configuration.AND);
		boolAlgebraOperationsDist.add(1, boolAlgebraOperationsDist.get(0) - Configuration.OR);
		boolAlgebraOperationsDist.add(2, boolAlgebraOperationsDist.get(1) - Configuration.XOR);
		boolAlgebraOperationsDist.add(3, boolAlgebraOperationsDist.get(2) - Configuration.NOT);
	}
	
	private static void distributeEqualityOperations() {
		equalityOperationsDist.add(0, 100 - Configuration.EQUALS);
		equalityOperationsDist.add(1, equalityOperationsDist.get(0) - Configuration.NOT_EQUALS);
		
	}
	
	private static void distributeAritCountOperations() {
		aritCountOperationsDist.add(0, 100 - Configuration.ADDITION);
		aritCountOperationsDist.add(1, aritCountOperationsDist.get(0) - Configuration.SUBSTRACTION);
		aritCountOperationsDist.add(2, aritCountOperationsDist.get(1) - Configuration.MULTIPLICATION);
		aritCountOperationsDist.add(3, aritCountOperationsDist.get(2) - Configuration.DIVISION);
	}
	
	private static void distributeAritCompOperations() {
		aritCompOperationsDist.add(0, 100 - Configuration.GREATER);
		aritCompOperationsDist.add(1, aritCompOperationsDist.get(0) - Configuration.LESSER);
		aritCompOperationsDist.add(2, aritCompOperationsDist.get(1) - Configuration.GREATEROREQUALS);
		aritCompOperationsDist.add(3, aritCompOperationsDist.get(2) - Configuration.LESSEROREQUALS);
	}

}
