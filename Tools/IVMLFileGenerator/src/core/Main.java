package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import config.GeneratorConfiguration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.IVMLWriter;

public class Main {
	
	/*
	 *  Define the path and the file name (including IVML file extension)
	 *  where the generated file shall be stored.
	 */
	private static String path = "/Users/Phani/Documents/Uni-Work/Reasoning_Stats/DroolsModels/";
	private static String fileName = "IVML_gen";
	private static String fileExtension = ".ivml";
	
	// Define the name of the IVML project to be generated.
	private static String projectName = "Project_gen";
	
	// Define the number of models to be generated (results in the specified number of files)
	private static int numberOfModels = 10;
	
	/*
	 * Define the complexity level (1-3) of the constraints to be generated.
	 * "1" produces simple constraints for each type of elements, while "3"
	 * will produce the most complex constraints provided by the generator.
	 * 
	 * For more information read the Excel-sheet in this Java project.
	 */
	private static int complexityLevel = 3;
	
	// Define if Boolean variables shall be generated.
	private static boolean useBooleanElements = true;
	// Define the number of Boolean variables to be generated.
	private static final int booleanVariableNum = 400;
	/*
	 *  Define the number of logical constraints to be generated.
	 *  Please note, that these logical constraints are exclusive for Boolean
	 *  variables. Complex arithmetic constraints will also be produced
	 *  by relating two or more constraints by logical operators. However, this
	 *  will be done automatically and not on the basis of this switch(the number
	 *  defined the following variable).
	 */
	private static int booleanConstraintNum = 400;
	
	// Define if integer variables shall be generated.
	private static boolean useIntegerElements = true;
	// Define the number of integer variables to be generated.
	private static int intVariableNum = 300;
	// Define the upper bound of the integer variable values (exclusive).
	private static int intVarBound = 20;
	
	// Define if real variables shall be generated.
	private static boolean useRealElements = true;
	// Define the number of real variables to be generated.
	private static int realVariableNum = 300;
	/*
	 * Define the multiplicator for real values to be assigned to the generated
	 * real variables. This is required as the method for random values will
	 * produce, for example, 0.2356. In order to generate more realistic real
	 * values, the random values are adjusted in terms of:
	 * 0.2356 * realValMultiplicator - in this example: 2.356
	 */
	private static int realValMultiplicator = 10;
	
	/*
	 *  !!IMPORTANT!!
	 *  The number of arithmetic constraints will be used for generating
	 *  constraints among integer and real variables. In case that both
	 *  types of elements are enables for generation it will produce:
	 *  arithmeticConstraintNum * 2
	 */
	private static int arithmeticConstraintNum = 300;
	
	/**
	 * The main method of the IVML File Generator.
	 * It first sets the generator configuration based on the values
	 * defined above, start the generator, and writes the file based
	 * on the generated IVML project.
	 * 
	 * @param args NOT USED!
	 */
	public static void main (String[] args) {
		System.out.print("Setting Generator Configuration...");
		setGeneratorConfiguration();
		System.out.println(" Finished!");
		
		System.out.print("Start Generator...");
		IVMLGenerator iGen = new IVMLGenerator();
		
		for (int i=0; i<numberOfModels; i++) {
			Project generatedProject = iGen.generate(projectName);
			System.out.println(" Finished! - Model " + i);
			
			System.out.print("Start IVML File Writer...");
			String filePathAndName = path + fileName + i + fileExtension;
	        File file = new File(filePathAndName);
	        if (file.exists()) {
	            file.delete();
	        }
	   
	        FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(file);
				IVMLWriter iWriter = new IVMLWriter(fileWriter);
		        generatedProject.accept(iWriter);
		        fileWriter.flush();
		        fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(" Finished!");
	}
	
	/**
	 * This method sets the generator configuration accordingly to the
	 * values defined for the variables above.
	 */
	private static void setGeneratorConfiguration() {
		GeneratorConfiguration.INSTANCE.setComplexityLevel(complexityLevel);
		
		GeneratorConfiguration.INSTANCE.setUseBooleanElements(useBooleanElements);
		GeneratorConfiguration.INSTANCE.setBoolVarNum(booleanVariableNum);
		GeneratorConfiguration.INSTANCE.setLogicalConstraintNum(booleanConstraintNum);
		
		GeneratorConfiguration.INSTANCE.setUseIntElements(useIntegerElements);
		GeneratorConfiguration.INSTANCE.setIntVarNum(intVariableNum);
		GeneratorConfiguration.INSTANCE.setIntVarBounds(intVarBound);
		
		GeneratorConfiguration.INSTANCE.setUseRealElements(useRealElements);
		GeneratorConfiguration.INSTANCE.setRealVarNum(realVariableNum);
		GeneratorConfiguration.INSTANCE.setRealValMultiplicator(realValMultiplicator);
		
		// Note: this will set the number of constraints for both integer and real variables!
		GeneratorConfiguration.INSTANCE.setArithmeticConstraintNum(arithmeticConstraintNum);
		
	}
	
}
