
package de.uni_hildesheim.sse.vil.templatelang;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TemplateLangStandaloneSetup extends TemplateLangStandaloneSetupGenerated{

	public static void doSetup() {
		new TemplateLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

