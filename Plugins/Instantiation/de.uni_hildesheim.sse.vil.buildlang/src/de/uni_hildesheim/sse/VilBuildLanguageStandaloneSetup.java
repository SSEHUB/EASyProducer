
package de.uni_hildesheim.sse;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class VilBuildLanguageStandaloneSetup extends VilBuildLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new VilBuildLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

