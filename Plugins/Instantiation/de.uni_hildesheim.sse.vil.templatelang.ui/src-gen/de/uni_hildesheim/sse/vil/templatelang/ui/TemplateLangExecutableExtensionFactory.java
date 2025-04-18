/*
 * generated by Xtext 2.35.0
 */
package de.uni_hildesheim.sse.vil.templatelang.ui;

import com.google.inject.Injector;
import de.uni_hildesheim.sse.vil.templatelang.ui.internal.TemplatelangActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class TemplateLangExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(TemplatelangActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		TemplatelangActivator activator = TemplatelangActivator.getInstance();
		return activator != null ? activator.getInjector(TemplatelangActivator.DE_UNI_HILDESHEIM_SSE_VIL_TEMPLATELANG_TEMPLATELANG) : null;
	}

}
