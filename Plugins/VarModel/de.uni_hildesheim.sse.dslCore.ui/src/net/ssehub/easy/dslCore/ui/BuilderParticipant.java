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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Arrays;

public class BuilderParticipant extends org.eclipse.xtext.builder.BuilderParticipant {

    @Override
    protected List<IResourceDescription.Delta> getRelevantDeltas(IBuildContext context) {
        List<IResourceDescription.Delta> result = super.getRelevantDeltas(context);
        result.removeIf(d -> exclude(d.getUri()));
        return result;
    }
    
    private boolean exclude(URI uri) {
        String[] segments = uri.segments();
        return Arrays.contains(segments, "target") || Arrays.contains(segments, "bin");
    }

    @Override
    protected boolean shouldGenerate(Resource resource, IBuildContext context) {
        return !exclude(resource.getURI()) && super.shouldGenerate(resource, context);
    }

}
