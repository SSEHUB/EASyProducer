package de.uni_hildesheim.sse.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

import de.uni_hildesheim.sse.vil.expressions.validation.ExpressionDslJavaValidator;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractVilBuildLanguageJavaValidator extends ExpressionDslJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(de.uni_hildesheim.sse.vilBuildLanguage.VilBuildLanguagePackage.eINSTANCE);
		return result;
	}

}
