/*
 * generated by Xtext
 */
package de.uni_hildesheim.sse.vil.rt.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.vil.rt.ui.internal.RtVilActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class RtVilExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return RtVilActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return RtVilActivator.getInstance().getInjector(RtVilActivator.DE_UNI_HILDESHEIM_SSE_VIL_RT_RTVIL);
	}
	
}
