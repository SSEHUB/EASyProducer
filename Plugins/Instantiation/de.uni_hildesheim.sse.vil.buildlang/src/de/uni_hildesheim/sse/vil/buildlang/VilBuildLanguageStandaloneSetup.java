/*
 * generated by Xtext 2.34.0
 */
package de.uni_hildesheim.sse.vil.buildlang;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class VilBuildLanguageStandaloneSetup extends VilBuildLanguageStandaloneSetupGenerated {

	public static void doSetup() {
		new VilBuildLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
