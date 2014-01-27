package de.uni_hildesheim.sse.vil.templatelang.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import de.uni_hildesheim.sse.vil.expressions.validation.ExpressionDslJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractTemplateLangJavaValidator extends ExpressionDslJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(de.uni_hildesheim.sse.vil.templatelang.templateLang.TemplateLangPackage.eINSTANCE);
		return result;
	}

}
