/*
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractIvmlValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(de.uni_hildesheim.sse.ivml.IvmlPackage.eINSTANCE);
		return result;
	}
}
