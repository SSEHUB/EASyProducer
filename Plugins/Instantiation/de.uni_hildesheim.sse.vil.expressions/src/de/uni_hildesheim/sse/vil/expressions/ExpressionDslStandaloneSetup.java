
package de.uni_hildesheim.sse.vil.expressions;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExpressionDslStandaloneSetup extends ExpressionDslStandaloneSetupGenerated{

	public static void doSetup() {
		new ExpressionDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

