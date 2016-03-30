/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.easy_producer.instantiator.xvcl;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IRegistration;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Registers and calls the XVCL instantiatior from VIL.
 * @author El-Sharkawy
 *
 */
@Instantiator("xvcl")
public class XVCLInstantiator implements IVilType, IRegistration {

    private static boolean registered = false;
    
    /**
     * Registers the Java artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            registered = true;
            TypeRegistry.DEFAULT.register(XVCLInstantiator.class);
        }
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        register();
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
    }

    
    /**
     * Instantiates the given XVCL specification file via VIL.
     * @param specification The stating point for instantiation with XVCL.
     * @throws ArtifactException If XVCL detects any errors, while parsing the specification.
     */
    public static void xvcl(FileArtifact specification) throws VilException {
        XvclTransformatorEngine instantiator = new XvclTransformatorEngine();
        try {
            instantiator.instantiate(specification);
        } finally {
            instantiator = null;
            System.gc();
        }
    }

}
