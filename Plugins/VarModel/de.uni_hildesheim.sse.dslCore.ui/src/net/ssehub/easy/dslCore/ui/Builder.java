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

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.MarkerUpdaterImpl;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.ui.markers.IMarkerContributor;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.tasks.TaskMarkerCreator;
import org.eclipse.xtext.ui.tasks.TaskMarkerTypeProvider;
import org.eclipse.xtext.ui.validation.IResourceUIValidatorExtension;
import org.eclipse.xtext.ui.validation.MarkerEraser;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.CheckMode;

import com.google.inject.Inject;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.dslCore.BundleId;
import net.ssehub.easy.dslCore.ModelUtility;
import net.ssehub.easy.dslCore.validation.ValidationUtils;
import net.ssehub.easy.dslCore.validation.ValidationUtils.ValidationMode;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A simplified version of the XtextBuilder, just focusing on markers. The XtextBuilder collides with our 
 * implementation as it hangs in so far non-predictable manner when Reconcieler creates exceptions. However, the 
 * XtextBuilder is also not customizable to just focus on the markers. Although the underlying implementation is used,
 * potentially with a differently/standalone configured injector, markers now show up when created but (sometimes) are
 * not deleted when resolved. Better than a hanging Eclipse.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("restriction")
public class Builder extends IncrementalProjectBuilder {

    public static final Logger LOG = Logger.getLogger(MarkerUpdaterImpl.class);
    public static final String BUILDER_ID = "de.uni_hildesheim.sse.EASy-Producer.Builderr";
    private static final int MONITOR_CHUNK_SIZE_CLEAN = 50;
    /** Duplicate of ExternalFoldersManager.EXTERNAL_PROJECT_NAME for avoiding any dependency on that (internal) API. */
    private static final String EXTERNAL_PROJECT_NAME = ".org.eclipse.jdt.core.external.folders";

    
    @Override
    protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
        updateMarkers(monitor);
        return null;
    }
    
    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        updateMarkers(monitor);
    }
    
    private class ResourceWorkUnit {

        private ModelUtility<?, ?> utility;
        private Resource resource;
        private boolean deleted;
        private boolean updated;
        
        private ResourceWorkUnit(ModelUtility<?, ?> utility, Resource resource, boolean deleted, boolean updated) {
            this.utility = utility;
            this.resource = resource;
            this.deleted = deleted;
            this.updated = updated;
        }
        
        private <T> T getInstance(Class<T> cls) {
            return utility.getInjector().getInstance(cls);            
        }
        
        private boolean considerUpdated() {
            return updated || (!updated && !deleted); // second, full build
        }
    }
    
    protected boolean isOpened(IResourceDelta delta) {
        return delta.getResource() instanceof IProject 
            && (delta.getFlags() & IResourceDelta.OPEN) != 0
            && ((IProject) delta.getResource()).isOpen();
    }
    
    protected boolean isHandled(IResourceDelta delta) {
        return true;
    }

    protected boolean isHandled(IFolder folder) {
        return true;
    }

    protected URI getUri(IResourceDelta delta) {
        IResource resource = delta.getResource();
        return URI.createURI(resource.getLocationURI().toString()); // simplified, otherwise no comparison possible
    }
    
    /**
     * Creates a visitor that is used to traverse the information that is obtained from {@link #getDelta(IProject)}. It
     * accumulates its findings in the given <code>toBeBuilt</code>.
     * 
     * @param toBeBuilt storage for files to be built
     * @param progress the progress monitor
     * @return the visitor
     */
    protected IResourceDeltaVisitor createDeltaVisitor(ToBeBuilt toBeBuilt, final SubMonitor progress) {
        IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
            @Override
            public boolean visit(IResourceDelta delta) throws CoreException {
                if (progress.isCanceled()) {
                    throw new OperationCanceledException();
                }
                if (delta.getResource() instanceof IProject) {
                    return true;
                }
                if (delta.getResource() instanceof IStorage) {
                    if (delta.getKind() == IResourceDelta.REMOVED) {
                        if (!isHandled(delta)) {
                            return true;
                        }
                        URI uri = getUri(delta);
                        if (uri != null) {
                            toBeBuilt.getToBeDeleted().add(uri);
                        }
                        return true;
                    } else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
                        if (!isHandled(delta)) {
                            return true;
                        }
                        URI uri = getUri(delta);
                        if (uri != null) {
                            toBeBuilt.getToBeUpdated().add(uri);
                        }
                        return true;
                    }
                } else if (delta.getResource() instanceof IFolder) {
                    return isHandled((IFolder) delta.getResource());
                }
                return true;
            }
        };
        return visitor;
    }
    
    private void updateMarkers(IProgressMonitor monitor) {
        SubMonitor subMonitor = SubMonitor.convert(monitor, "Updating markers", 2);
        subMonitor.subTask("Updating resources");
        IProject project = getProject();
        IResourceDelta delta = getDelta(project);
        ToBeBuilt toBeBuilt;
        if (delta == null || isOpened(delta)) {
            toBeBuilt = null;
        } else {
            toBeBuilt = new ToBeBuilt();
            IResourceDeltaVisitor visitor = createDeltaVisitor(toBeBuilt, subMonitor);
            try {
                delta.accept(visitor);
            } catch (CoreException e) {
                e.printStackTrace(); // preliminary
            }
        }
        
        subMonitor.subTask("Collecting work units");
        List<ResourceWorkUnit> workUnits = new LinkedList<>();
        for (ModelUtility<?, ?> utility : ModelUtility.instances()) {
            try {
                for (Resource resource : utility.getResourceSet().getResources()) {
                    URI uri = resource.getURI();
                    boolean add = false;
                    boolean deleted = false;
                    boolean updated = false;
                    if (null == toBeBuilt) {
                        add = true;
                    } else if (toBeBuilt.getToBeDeleted().contains(uri)) {
                        deleted = true;
                    } else if (toBeBuilt.getToBeUpdated().contains(uri)) {
                        updated = true;
                    }
                    if (add || deleted || updated) {
                        workUnits.add(new ResourceWorkUnit(utility, resource, deleted, updated));
                    }
                }
            } catch (ConcurrentModificationException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), BundleId.ID).warn("Concurrent modification in xText "
                    + "resource set. Cannot obtain resources, cannot update markers.");
            }
        }

        subMonitor.setWorkRemaining(workUnits.size() / MONITOR_CHUNK_SIZE_CLEAN + 1);
        subMonitor.subTask("Validating resources");

        int doneCount = 0;
        for (ResourceWorkUnit unit: workUnits) {
            subMonitor.subTask("Validating resources (" + doneCount + "/" + workUnits.size() + "):" 
                + unit.resource.getURI());
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            IResourceServiceProvider serviceProvider = unit.getInstance(IResourceServiceProvider.class);
            IResourceDescription resourceDescription = serviceProvider.getResourceDescriptionManager()
                .getResourceDescription(unit.resource);        
            IResourceDescription.Delta resourceDelta = new DefaultResourceDescriptionDelta(resourceDescription, null);
            updateMarkers(resourceDelta, unit.resource.getResourceSet(), subMonitor, unit);
            doneCount++;
            if (doneCount % MONITOR_CHUNK_SIZE_CLEAN == 0) {
                subMonitor.worked(1);
            }
        }
        subMonitor.subTask("Completed");
        subMonitor.setWorkRemaining(0);
    }

    public class TaskMarkerContributor implements IMarkerContributor {

        private static final Logger LOG = Logger.getLogger(TaskMarkerContributor.class);

        @Inject
        private TaskMarkerCreator markerCreator;

        @Inject
        private ITaskFinder taskFinder;

        @Inject
        private TaskMarkerTypeProvider typeProvider;
        
        private TaskMarkerContributor(ResourceWorkUnit unit) {
            markerCreator = unit.getInstance(TaskMarkerCreator.class);
            taskFinder = unit.getInstance(ITaskFinder.class);
            typeProvider = unit.getInstance(TaskMarkerTypeProvider.class);
        }

        @Override
        public void updateMarkers(IFile file, Resource resource, IProgressMonitor monitor) {
            try {
                List<Task> tasks = taskFinder.findTasks(resource);
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                deleteMarkers(file, monitor);
                createTaskMarkers(file, tasks, monitor);
            } catch (CoreException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        protected void createTaskMarkers(IFile file, List<Task> tasks, IProgressMonitor monitor) throws CoreException {
            for (Task task : tasks) {
                markerCreator.createMarker(task, file, typeProvider.getMarkerType(task));
            }
        }

        @Override
        public void deleteMarkers(IFile file, IProgressMonitor monitor) {
            try {
                file.deleteMarkers(TaskMarkerTypeProvider.XTEXT_TASK_TYPE, true, IResource.DEPTH_ZERO);
            } catch (CoreException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    public void updateMarkers(Delta delta, /* @Nullable */ ResourceSet resourceSet, IProgressMonitor monitor, 
        ResourceWorkUnit unit) throws OperationCanceledException {
        URI uri = delta.getUri();
        IResourceServiceProvider.Registry resourceServiceProviderRegistry = unit.getInstance(
            IResourceServiceProvider.Registry.class); 
        IResourceUIValidatorExtension validatorExtension = getResourceUIValidatorExtension(
            resourceServiceProviderRegistry, uri);
        IMarkerContributor markerContributor = new TaskMarkerContributor(unit);
        CheckMode checkMode = CheckMode.NORMAL_ONLY; // prevent fast checks, double markers we may not get rid off
        Storage2UriMapperImpl mapper = new Storage2UriMapperImpl();
        mapper.setUriValidator(unit.getInstance(UriValidator.class));
        for (Pair<IStorage, IProject> pair : mapper.getStorages(uri)) {
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            if (pair.getFirst() instanceof IFile) {
                IFile file = (IFile) pair.getFirst();

                if (EXTERNAL_PROJECT_NAME.equals(file.getProject().getName())) {
                    // if the file is found via the source attachment of a
                    // classpath entry, which happens
                    // in case of running a test IDE with bundles from the
                    // workspace of the development IDE
                    // (the workspace bundles' bin folder is linked to the
                    // classpath of bundles in the test IDE),
                    // skip the marker processing of that file, as the user
                    // can't react on any markers anyway.
                    continue;
                }
                
                if (delta.getNew() != null || unit.considerUpdated()) {
                    if (resourceSet == null) {
                        throw new IllegalArgumentException("resourceSet may not be null for changed resources.");
                    }
                    deleteAllMarkersCheckValidator(file); // a bit harsh, but we do not get rid of xText markers
                    Resource resource = resourceSet.getResource(uri, true);
                    if (validatorExtension != null) {
                        validatorExtension.updateValidationMarkers(file, resource, checkMode, monitor);
                    }
                    if (markerContributor != null) {
                        markerContributor.updateMarkers(file, resource, monitor);
                    }
                } else {
                    deleteAllMarkersCheckValidator(file); // a bit harsh, but we do not get rid of xText markers
                    if (validatorExtension != null) {
                        validatorExtension.deleteValidationMarkers(file, checkMode, monitor);
                    } else {
                        deleteAllValidationMarker(file, checkMode, monitor);
                    }
                    if (markerContributor != null) {
                        markerContributor.deleteMarkers(file, monitor);
                    } else {
                        deleteAllContributedMarkers(file, monitor);
                    }
                }
                
                if (ValidationUtils.ValidationMode.EASY_BUILDER == ValidationUtils.getValidationMode()) {
                    unit.utility.validate(unit.resource, r -> MessageUtils.processMessagesQuiet(file, r));
                }
                
            }
        }
    }
    
    private void deleteAllMarkersCheckValidator(IFile file) {
        if (ValidationUtils.getValidationMode() == ValidationMode.VALIDATOR) {
            deleteAllMarkers(file);
        }
    }    
    
    private void deleteAllMarkers(IFile file) {
        try {
            file.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
        } catch (CoreException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void deleteAllValidationMarker(IFile file, CheckMode checkMode, IProgressMonitor monitor) {
        MarkerEraser markerEraser = new MarkerEraser();
        markerEraser.deleteValidationMarkers(file, checkMode, monitor);
    }
    
    private void deleteAllContributedMarkers(IFile file, IProgressMonitor monitor) {
        try {
            file.deleteMarkers(IMarkerContributor.MARKER_TYPE, true, IResource.DEPTH_ZERO);
        } catch (CoreException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    protected IResourceUIValidatorExtension getResourceUIValidatorExtension(
        IResourceServiceProvider.Registry resourceServiceProviderRegistry, URI uri) {
        IResourceServiceProvider provider = resourceServiceProviderRegistry.getResourceServiceProvider(uri);
        if (provider != null) {
            return provider.get(IResourceUIValidatorExtension.class);
        }
        return null;
    }

}
