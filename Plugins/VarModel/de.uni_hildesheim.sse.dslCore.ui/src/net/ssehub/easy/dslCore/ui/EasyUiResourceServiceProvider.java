/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.ui;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider;

import com.google.inject.Inject;

import net.ssehub.easy.dslCore.validation.ValidationUtils;

/**
 * Resource service provider extending the default one from Xtext which does not seem to exclude src/target.
 * 
 * @author Holger Eichelberger
 */
public class EasyUiResourceServiceProvider extends DefaultResourceUIServiceProvider {

    /**
     * Creates a provider based on a delegate.
     * 
     * @param delegate the delegate
     */
    @Inject
    public EasyUiResourceServiceProvider(IResourceServiceProvider delegate) {
        super(delegate);
    }

    @Override
    public boolean canHandle(URI uri) {
        return !ValidationUtils.excludeBinTarget(uri) && ValidationUtils.isInPath(uri) && super.canHandle(uri);
    }

    @Override
    public boolean canHandle(URI uri, IStorage storage) {
        return !ValidationUtils.excludeBinTarget(uri) && ValidationUtils.isInPath(uri) && super.canHandle(uri, storage);
    }
    
    @Override
    public boolean canBuild(URI uri, IStorage storage) {
        return !ValidationUtils.excludeBinTarget(uri) && ValidationUtils.isInPath(uri) && super.canBuild(uri, storage);
    }

    @Override
    public boolean isSource(URI uri) {
        return !ValidationUtils.excludeBinTarget(uri) && ValidationUtils.isInPath(uri) && super.isSource(uri);
    }

}
