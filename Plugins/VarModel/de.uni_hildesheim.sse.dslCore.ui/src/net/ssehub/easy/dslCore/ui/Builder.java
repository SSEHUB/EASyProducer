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
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
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
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.BundleId;
import net.ssehub.easy.dslCore.ModelUtility;
import net.ssehub.easy.dslCore.ui.Activator.ModelReloader;
import net.ssehub.easy.dslCore.validation.ValidationUtils;
import net.ssehub.easy.dslCore.validation.ValidationUtils.ValidationMode;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import static net.ssehub.easy.dslCore.validation.ValidationUtils.excludeBinTarget;
import static net.ssehub.easy.dslCore.validation.ValidationUtils.isInPath;

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

    public static final EASyLogger LOG = EASyLoggerFactory.INSTANCE.getLogger(Builder.class, BundleId.ID);
    public static final String BUILDER_ID = "de.uni_hildesheim.sse.EASy-Producer.Builderr";
    private static final int MONITOR_CHUNK_SIZE_CLEAN = 50;
    /** Duplicate of ExternalFoldersManager.EXTERNAL_PROJECT_NAME for avoiding any dependency on that (internal) API. */
    private static final String EXTERNAL_PROJECT_NAME = ".org.eclipse.jdt.core.external.folders";

    private boolean isEnabled(Map<String, String> args, String key, boolean dflt) {
        boolean enabled = dflt;
        String tmp = System.getProperty(key);
        if (tmp != null) {
            enabled |= Boolean.valueOf(tmp);
        }
        if (args != null && args.containsKey(key)) {
            enabled |= Boolean.valueOf(args.get(key));
        }
        QualifiedName qn = new QualifiedName("net.ssehub.easy", key);
        try {
            String value = getProject().getPersistentProperty(qn);
            if (null != value) {
                enabled |= Boolean.valueOf(value);
            }
        } catch (CoreException e) {
            ILog.get().info("Cannot load persistent property for " + key + ":" + e.getMessage());
        }
        return enabled;
    }
    
    @Override
    protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
        boolean execute = true;
        if (kind == FULL_BUILD) {
            execute = isEnabled(args, "easy.builder.full", true);
        } else if (kind == INCREMENTAL_BUILD || kind == AUTO_BUILD) {
            execute = isEnabled(args, "easy.builder.incremental", true);
        }
        if (execute) {
            updateMarkers(monitor);
        }
        return null;
    }
    
    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
        updateMarkers(monitor);
    }
    
    /**
     * Extended set of URIs to be built.
     * 
     * @author Holger Eichelberger
     */
    private static class ToBeBuilt extends org.eclipse.xtext.builder.impl.ToBeBuilt {
        
        private boolean hasAdded = false;
        private boolean hasDeleted = false;

        /**
         * Adds an URI that shall be updated.
         * 
         * @param uri the URI
         * @param added {@code true} if the URI is new/added, {@code false} if the contents in {@code uri} was changed
         */
        private void addToBeUpdated(URI uri, boolean added) {
            getToBeUpdated().add(uri);
            if (added) {
                hasAdded = true;
            }
        }

        /**
         * Adds an URI that shall be deleted.
         * 
         * @param uri the URI
         */
        private void addToBeDeleted(URI uri) {
            getToBeDeleted().add(uri);
            hasDeleted = true;
        }
        
        /**
         * Whether the set of URIs contains added contents.
         * 
         * @return {@code true} for added, {@code false} for no added
         */
        private boolean hasAdded() {
            return hasAdded;
        }

        /**
         * Whether the set of URIs contains deleted contents.
         * 
         * @return {@code true} for deleted, {@code false} for no deleted
         */
        private boolean hasDeleted() {
            return hasDeleted;
        }


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
        
        private IResourceDescription.Delta getResourceDelta() {
            IResourceServiceProvider serviceProvider = getInstance(IResourceServiceProvider.class);
            IResourceDescription resourceDescription = serviceProvider.getResourceDescriptionManager()
                .getResourceDescription(resource);        
            return new DefaultResourceDescriptionDelta(resourceDescription, null);
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
                    return getProject().equals(delta.getResource());
                }
                if (delta.getResource() instanceof IStorage) {
                    IStorage storage = (IStorage) delta.getResource();
                    if (storage instanceof IResource) {
                        if (!isInCurrentProject((IResource) storage)) {
                            return false;
                        }
                    }
                    if (delta.getKind() == IResourceDelta.REMOVED) {
                        if (!isHandled(delta)) {
                            return true;
                        }
                        URI uri = getUri(delta);
                        if (uri != null) {
                            toBeBuilt.addToBeDeleted(uri);
                        }
                        return true;
                    } else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
                        if (!isHandled(delta)) {
                            return true;
                        }
                        URI uri = getUri(delta);
                        if (uri != null) {
                            toBeBuilt.addToBeUpdated(uri, delta.getKind() == IResourceDelta.ADDED);
                        }
                        return true;
                    }
                } else if (delta.getResource() instanceof IFolder) {
                    IFolder folder = (IFolder) delta.getResource();
                    if (isInCurrentProject(folder)) {
                        return isHandled(folder);
                    } else {
                        return false;
                    }
                } else if (delta.getResource() instanceof IResource) {
                    return isInCurrentProject((IResource) delta.getResource());

                }
                return true;
            }
        };
        return visitor;
    }
    
    private boolean isInCurrentProject(IResource resource) {
        return resource.getProject().equals(getProject());
    }

    private boolean updateAnyway(boolean involvesIvml, URI uri) {
        return involvesIvml && !"ivml".equals(uri.fileExtension()); // may be
    }
    
    /**
     * Returns whether a set of URIs contains at least one of the given extensions.
     * 
     * @param uris the URIs
     * @param extension the extension(s)
     * @return {@code true} if at least one of the {@code uris} has at least one of the specified extensions
     */
    private boolean containsExtension(Set<URI> uris, String... extension) {
        return uris.stream()
            .anyMatch(u-> {
                String uExt = u.fileExtension(); // may be null
                boolean found = false;
                for (int e = 0; !found && e < extension.length; e++) {
                    found |= extension[e].equals(uExt);
                }
                return found;
            });
    }

    private boolean involvesExtension(ToBeBuilt toBeBuilt, String... extension) {
        return null != toBeBuilt && (containsExtension(toBeBuilt.getToBeUpdated(), extension));
    }

    private boolean containesAddedOrDeleted(ToBeBuilt toBeBuilt) {
        return null != toBeBuilt && (toBeBuilt.hasAdded() || toBeBuilt.hasDeleted());
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
        boolean involvesIvml = involvesExtension(toBeBuilt, "ivml");
        boolean involvesVil = involvesExtension(toBeBuilt, "vil");
        subMonitor.subTask("Collecting work units");
        long now = System.currentTimeMillis();
        List<ResourceWorkUnit> workUnits = collectWorkUnits(toBeBuilt, involvesIvml, now);
        ModelReloader reloader = Activator.getModelReloader();
        if ((involvesIvml || involvesVil || containesAddedOrDeleted(toBeBuilt)) && reloader != null) {
            // this is currently a bit coarse grained; may be we can reduce it to IVML -> all, VIL -> VIL+VTL
            ILog.get().info(">> End EASy-Build: model reload");
            subMonitor.setWorkRemaining(1);
            subMonitor.subTask("Reload model");
            reloader.reload(project);
            ILog.get().info("<< End EASy-Build: model reload");
        } else {
            subMonitor.setWorkRemaining(workUnits.size() / MONITOR_CHUNK_SIZE_CLEAN + 1);
            subMonitor.subTask("Validating resources");
            int doneCount = 0;
            ILog.get().info(">> Start EASy-Build");            
            for (ResourceWorkUnit unit: workUnits) {
                URI uri = unit.resource.getURI();
                ILog.get().info(" UNIT " + uri);                
                subMonitor.subTask("Validating resources (" + doneCount + "/" + workUnits.size() + "): " + uri);
                if (monitor.isCanceled()) {
                    throw new OperationCanceledException();
                }
                if (enableUpdate(unit.utility, uri, now)) { // may change during update
                    updateMarkers(unit.getResourceDelta(), unit.resource.getResourceSet(), subMonitor, unit);
                }
                doneCount++;
                if (doneCount % MONITOR_CHUNK_SIZE_CLEAN == 0) {
                    subMonitor.worked(1);
                }
            }
            ILog.get().info(">> End EASy-Build");            
        }
        subMonitor.subTask("Completed");
        subMonitor.setWorkRemaining(0);
        subMonitor.done();
    }
    
    private List<ResourceWorkUnit> collectWorkUnits(ToBeBuilt toBeBuilt, boolean involvesIvml, long now) {
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
                    } else if (toBeBuilt.getToBeUpdated().contains(uri) || updateAnyway(involvesIvml, uri)) {
                        updated = true;
                    }
                    if (add || deleted || updated) {
                        if (!excludeBinTarget(uri) && isInPath(uri) && enableUpdate(utility, uri, now)) {
                            workUnits.add(new ResourceWorkUnit(utility, resource, deleted, updated));
                        }
                    }
                }
            } catch (ConcurrentModificationException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), BundleId.ID).warn("Concurrent modification in xText "
                    + "resource set. Cannot obtain resources, cannot update markers.");
            }
        }
        return workUnits;
    }
    
    private boolean enableUpdate(ModelUtility<?, ?> utility, URI uri, long timestamp) {
        boolean result = true;
        ModelInfo<?> info = utility.getInfo(uri);
        if (null != info) {
            if (info.getResolved() != null) {
                result = info.getResolved().getLastModification() < timestamp;
            }
        }
        return result;
    }

    public class TaskMarkerContributor implements IMarkerContributor {

        public static final EASyLogger LOG = EASyLoggerFactory.INSTANCE.getLogger(TaskMarkerContributor.class, 
            BundleId.ID);

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
                LOG.error(e.getMessage());
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
                LOG.error(e.getMessage());
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
                    LOG.info("Validating " + uri);                    
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
            LOG.error(e.getMessage());
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
            LOG.error(e.getMessage());
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
