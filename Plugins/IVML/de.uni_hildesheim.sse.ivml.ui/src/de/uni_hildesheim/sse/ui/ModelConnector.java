package de.uni_hildesheim.sse.ui;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.filter.ConstraintSeparator;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * This class is used to get information out of the variability model that cannot
 * be accessed via the ECore model directly. This connector is required to display
 * information in the outline view appropriately.
 * 
 * @author kroeher
 *
 */
public class ModelConnector{
	
	//private String id = "ModelConnector: ";
	private de.uni_hildesheim.sse.ivml.Project ivmlProject = null;
	private static final String CONSTRAINT_ENDING = " ...";
	
	/**
	 * The constructor of the model connector.
	 */
	public ModelConnector () {}
	
	/**
	 * Add the IVML (Ecore) project to the connector, which is required
	 * to get (and load) to corresponding variability model project.
	 * 
	 * @param iProject The IVML project for which information should be retrieved
	 */
	public void addIvmlProject (de.uni_hildesheim.sse.ivml.Project iProject) {
		ivmlProject = iProject;
	}
	
	/**
	 * Returns the set of evaluation block elements of an evaluation expression. The
	 * evaluation expression is identified by the number of its occurrence in the IVML file.
	 * More precise, if the elements of the second evaluation expression shall be returned, add
	 * "2" as a parameter to this method. 
	 * @param evalNum The number of the evaluation expression for which the elements should be returned.
	 * @return A String array including all evaluation block elements or null if no element is included.
	 */
	public String[] getEvaluationBlocksElements (int evalNum) {
		int evalBlockCount = 1;
		String result[] = null;
		String tmpConstraintString;
		Project varModelProject = getVarModelProject();

		if (varModelProject != null) {
			int projectElementCount = varModelProject.getElementCount();
			int evaluationBlockElementsCount = 0;
			
			for (int i=0; i<projectElementCount; i ++) {
				if (varModelProject.getElement(i).getClass().toString().equals("class de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock")) {
					if (evalNum == evalBlockCount) {
						PartialEvaluationBlock peb = (PartialEvaluationBlock) varModelProject.getElement(i);
						evaluationBlockElementsCount = peb.getEvaluableCount();
						result = new String[evaluationBlockElementsCount];
								
						for (int j=0; j<evaluationBlockElementsCount; j++) {
							tmpConstraintString = StringProvider.toIvmlString(peb.getEvaluable(j));
							result[j] = beautifyConstraintString(tmpConstraintString);
						}
					}
					evalBlockCount++;
				}
			}	
		}
	
		return result;
	}
	
	private String beautifyConstraintString(String constraint) {
		String beautifiedConstraint = "";
		CharSequence constraintSubString;
		
		if (constraint.length() > 21) {
			constraintSubString = constraint.subSequence(0, 20);
			beautifiedConstraint = constraintSubString.toString();
			beautifiedConstraint += CONSTRAINT_ENDING;
		} else {
			constraintSubString = constraint.subSequence(0, constraint.indexOf(";"));
			beautifiedConstraint = constraintSubString.toString();
		}
		
		return beautifiedConstraint;
	}
	
	public String getConstraint(int numOfConstraint) {
		String constraintString = null;
		Project varModelProject = getVarModelProject();
		ConstraintSeparator constrSeparator = null;
		
		if (varModelProject != null) {
			constrSeparator = new ConstraintSeparator(varModelProject);
			
			List <Constraint> constrList = constrSeparator.getNormalConstraints();
			
			try {
			    constraintString = StringProvider.toIvmlString(constrList.get(numOfConstraint).getConsSyntax());
			} catch (IndexOutOfBoundsException e) {
			    constraintString = null;
			}
		}
		
		return constraintString;
	}
	
	public String getTypeDefRestriction (String typeName) {
		String typeDefRestrictionString = "";
		Constraint typeDefRestriction = null;
		Project varModelProject = getVarModelProject();
		
		int elementCounter = varModelProject.getElementCount();
		
		for (int i=0; i<elementCounter; i++) {
			if (varModelProject.getElement(i).getName() != null
					&& varModelProject.getElement(i).getName().equals(typeName)) {
				
				DerivedDatatype typeDef = (DerivedDatatype) varModelProject.getElement(i);
				
				typeDefRestriction = typeDef.getConstraint(0);
				
				if (typeDefRestriction != null) {
					typeDefRestrictionString = StringProvider.toIvmlString(typeDefRestriction.getConsSyntax());
				}
			}
		}
		
		return typeDefRestrictionString;
	}
	
	
	/**
	 * This method returns the project of the variability model based on the added IVML model project.
	 * If the project is currently not loaded, it will load the project as well.
	 * @return the variability model project.
	 */
	private Project getVarModelProject () {
		Project varModelProject = null;
		String ivmlProjectVersion = null;
		URI projectURI = null;
		
		if (null != ivmlProject && null != ivmlProject.eResource() && null != ivmlProject.eResource().getURI()) {
    		try {
    		    projectURI = ModelUtility.toNetUri(ivmlProject.eResource().getURI());
    		} catch (URISyntaxException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
    		if (ivmlProject.getVersion() != null) {
    			ivmlProjectVersion = ivmlProject.getVersion().getVersion();
    		}
    		
    		if (projectURI != null) {
    			try {
    				varModelProject = VarModel.INSTANCE.availableModels().getModel(ivmlProject.getName(),
    						ivmlProjectVersion, projectURI);
    			} catch (VersionFormatException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
		}
		/*
		 *  Project not loaded yet, i.e., when the file is opened
		 *  when eclipse starts and someone will only use the outline
		 *  Then, load the project here.
		 */
		if (varModelProject == null) {
			/*
			Version version = null;
			
			if (ivmlProject.getVersion() != null) {
				try {
					version = new Version(ivmlProject.getVersion().getVersion());
				} catch (StringFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			ProjectInfo info = new ProjectInfo(ivmlProject.getName(), version, null, projectURI, null);
			
			try {
				VarModel.INSTANCE.load(info);
			} catch (VarModelException e) {
				// TODO Auto-generated catch block
				System.err.println("VarModel exception:");
				e.printStackTrace();
			} */
			/*
			 * VarModel kennt das projectInfo über URI schon!!!
			 *  
			 */
			//VarModel.INSTANCE.load(new ProjectInfo(projectURI));
			/*
			Version varModelProjectVersion;

			for (ProjectInfo pi : VarModel.INSTANCE.getProjectInfo(projectURI)) {
				varModelProjectVersion = new Version(ivmlProject.getVersion().getVersion());
				
				if (pi.getName().equals(ivmlProject.getName())
						&& pi.getVersion().equals(ivmlProject.getVersion())) {
						
				}
			}

			//VarModel.INSTANCE.load();
			 * 
			 */
			System.err.println("Outline - ModeConnector: The model is not loaded, yet. Type something in the IVML file and save.");
		}

		return varModelProject;
	}
}