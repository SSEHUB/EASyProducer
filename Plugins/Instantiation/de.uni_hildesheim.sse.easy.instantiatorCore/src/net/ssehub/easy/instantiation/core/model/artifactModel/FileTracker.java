/*
 * Copyright 2009-2026 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Simple, initial support for incremental instantiations. Keeps track on existing, created 
 * and deleted files and cleans up at the end, if enabled. Default global excludes are {@code target, bin}.
 * The file tracker mechanism is active if {@code easy.vil.incremental} is set to "true".
 * 
 * @author Holger Eichelberger
 */
public class FileTracker {

    /**
     * File states.
     * 
     * @author Holger Eichelberger
     */
    private enum State {
        INITIAL, // from *
        PREPARED, // !INITIAL
        CHANGED, // from DELETED
        DELETED; // from PREPARED, CHANGED
    }

    /**
     * Defines a path matcher.
     * 
     * @author Holger Eichelberger
     */
    public abstract static class PathMatcher {
        
        private boolean inclusion;

        /**
         * Creates an instance and marks it for inclusion/exclusion.
         * 
         * @param inclusion whether it shell be applied for inclusion or exclusion
         */
        protected PathMatcher(boolean inclusion) {
            this.inclusion = inclusion;
        }
        
        /**
         * Whether {@code path} matches this matcher.
         * 
         * @param path the path to check
         * @return {@code true} for match, {@code false} else
         */
        public abstract boolean matches(Path path);
        
        /**
         * Instantiates the matcher for the specific {@code base} if needed.
         * 
         * @param base the base path
         * @return the instantiated matcher or <b>this</b>
         */
        public PathMatcher instantiate(Path base) {
            return this;
        }
        
        /**
         * Returns whether this matcher is for inclusion.
         * 
         * @return whether this matcher shell be applied for inclusion or exclusion
         */
        public boolean isInclusion() {
            return inclusion;
        }
        
    }
    
    /**
     * Implements a specific matcher for the beginning of a path, i.e., a prefix match.
     * 
     * @author Holger Eichelberger
     */
    public static class StartsWithPathMatcher extends PathMatcher {
        
        private Path base;
        private String subPath;

        /**
         * Creates a matcher instance.
         * 
         * @param subPath the (generic) prefix sub-path to match
         * @param inclusion whether it shell be applied for inclusion or exclusion
         */
        public StartsWithPathMatcher(String subPath, boolean inclusion) {
            super(inclusion);
            this.subPath = subPath;
            this.base = Path.of(this.subPath);
        }
        
        /**
         * Creates a matcher instance.
         * 
         * @param base the instantiated base path to match
         * @param inclusion whether it shell be applied for inclusion or exclusion
         */
        public StartsWithPathMatcher(Path base, boolean inclusion) {
            super(inclusion);
            this.subPath = "";
            this.base = base;
        }
        
        @Override
        public boolean matches(Path path) {
            return path.startsWith(base);
        }
        
        @Override
        public PathMatcher instantiate(Path base) {
            return new StartsWithPathMatcher(base.resolve(subPath), isInclusion());
        }
        
    }

    /**
     * Implements a specific matcher for path containment, i.e., an infix match.
     * 
     * @author Holger Eichelberger
     */
    public static class ContainsPathMatcher extends PathMatcher {

        private String subPath;

        /**
         * Creates a matcher instance.
         * 
         * @param subPath the (generic) prefix sub-path to match
         * @param inclusion whether it shell be applied for inclusion or exclusion
         */
        public ContainsPathMatcher(String subPath, boolean inclusion) {
            super(inclusion);
            this.subPath = subPath.replace('/', File.separatorChar);
        }

        @Override
        public boolean matches(Path path) {
            return path.toString().contains(subPath);
        }
        
        // no instantiation

    }

    private static boolean enabled = Boolean.valueOf(System.getProperty("easy.vil.incremental", "false"));
    private static List<PathMatcher> matchers = new ArrayList<>();
    private File base;
    private Path basePath;
    private Map<Path, State> fileStatus = new HashMap<>();
    private List<PathMatcher> pathMatchers = new ArrayList<>();

    static {
        matchers.add(new StartsWithPathMatcher("gen", true)); // -> oktoflow
        matchers.add(new StartsWithPathMatcher("target", false));
        matchers.add(new StartsWithPathMatcher("bin", false));
        matchers.add(new ContainsPathMatcher("/target/", false)); // -> oktoflow
    }
    
    /**
     * Creates a file tracker.
     * 
     * @param base the base directory to create the tracker for.
     */
    FileTracker(File base) {
        this.basePath = base.toPath().normalize();
        this.base = basePath.toFile();
        pathMatchers = instantiatePaths(this.basePath, matchers, null);
        reset();
    }
    
    /**
     * Returns if we are in {@code current} state, whether we are allowed to assign {@code next} as the next state.
     * 
     * @param current the current state
     * @param next the next state
     * @return {@code true} if assignable, {@code false} else
     */
    private static final boolean assignable(State current, State next) {
        boolean result;
        switch (current) {
        case INITIAL:
            result = true; // from all
            break;
        case PREPARED:
            result = next != State.INITIAL;
            break;
        case CHANGED:
            result = next == State.DELETED;
            break;
        case DELETED:
            result = next == State.PREPARED || next == State.CHANGED; // changed for now...
            break;
        default:
            result = false;
            break;
        }
        return result;
    }
    
    /**
     * Resets this tracker.
     */
    public void reset() {
        fileStatus.clear();
        update(base, State.CHANGED, false); // will not be removed during commit anyway
    }

    /**
     * Instantiates the given matchers.
     * 
     * @param base the base path to use for instantiation
     * @param toInstantiate the matchers to instantiate
     * @param selector optional path matcher selector, may be <b>null</b>
     * @return the instantiated matchers, may be the same as {@code toInstantiate} if there is nothing to instantiate
     */
    private List<PathMatcher> instantiatePaths(Path base, List<PathMatcher> toInstantiate, 
        Predicate<PathMatcher> selector) {
        List<PathMatcher> result = new ArrayList<>();
        for (PathMatcher e : toInstantiate) {
            if (null == selector || selector.test(e)) {
                result.add(e.instantiate(base));
            }
        }
        return result;
    }
    
    /**
     * Enables/disables the file tracker.
     * 
     * @param en {@code true} if enabled, {@code false} else
     */
    public static void setEnabled(boolean en) {
        enabled = en;
    }
    
    /**
     * Whether the file tracker is enabled.
     * 
     * @return {@code true} if enabled, {@code false} else
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Adds default path matchers. The actual default matchers are 
     * instantiated and added to the new instance when a {@link FileTracker} is created and considered during 
     * {@link #commit(Path)}.
     * 
     * @param ms the matchers to add, <b>null</b> instances are ignored
     */
    public static void addMatchers(PathMatcher... ms) {
        for (PathMatcher m : ms) {
            if (null != m) {
                matchers.add(m);
            }
        }
    }

    /**
     * Clears the default matchers.
     */
    public static void clearMatchers() {
        matchers.clear();
    }
    
    /**
     * Scans {@code file} and it subdirectories.
     * 
     * @param file the file
     */
    public void scan(File file) {
        file = FileUtils.resolve(file);
        if (file != null) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (null != files) {
                    for (File f : files) {
                        scan(f);
                    }
                }
            }
            Path filePath = file.toPath();
            if (!fileStatus.containsKey(filePath) && !isExcluded(filePath)) {
                fileStatus.put(filePath, State.INITIAL);
            }
        }
    }

    /**
     * Returns whether a specified {@code path} is excluded.
     * 
     * @param path the path to analyze
     * @return {@code true} of {@code path} is excluded, {@code false} if {@code path} is not excluded
     */
    private boolean isExcluded(Path path) {
        return isExcluded(path, pathMatchers);
    }

    /**
     * Returns whether a specified {@code path} is excluded.
     * 
     * @param path the path to analyze
     * @param matchers the matchers to instantiate
     * @return {@code true} of {@code path} is excluded, {@code false} if {@code path} is not excluded
     */
    private boolean isExcluded(Path path, List<PathMatcher> matchers) {
        for (int m = 0; m < matchers.size(); m++) {
            PathMatcher matcher = matchers.get(m);
            if (matcher.isInclusion() && matcher.matches(path)) {
                return false;
            }
        }
        for (int m = 0; m < matchers.size(); m++) {
            PathMatcher matcher = matchers.get(m);
            if (!matcher.isInclusion() && matcher.matches(path)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Updates the status of {@code file} and its parent dirs.
     * 
     * @param file the file
     * @param state the new state
     * @param withParents include or exclude parent dirs
     * @return {@code true} if a file was modified, {@code false} else
     */
    private boolean update(File file, State state, boolean withParents) {
        boolean updated = false;
        if (null != file) {
            Path filePath = file.toPath();
            if (filePath.startsWith(filePath) && !isExcluded(filePath) && filePath.startsWith(basePath)) {
                State oldState = fileStatus.get(filePath);
                if (null == oldState || (oldState != state && assignable(oldState, state))) {
                    fileStatus.put(filePath, state);
                    updated = true;
                    if (withParents) {
                        update(file.getParentFile(), state, true);
                    }
                }
            }
        }
        return updated;
    }

    /**
     * Registers a file for being considered to be processed.
     * 
     * @param file the file
     */
    public void register(File file) {
        if (enabled) {
            update(file, State.INITIAL, true);
        }
    }

    /**
     * Notifies that a file is being prepared to be processed (without further checking the artifact model).
     * 
     * @param file the file
     */
    public void prepare(File file) {
        if (enabled) {
            update(file, State.PREPARED, true);
        }
    }
    
    /**
     * Notifies that a file was touched.
     * 
     * @param file the file
     */
    public void touch(File file) {
        if (enabled) {
            update(file, State.CHANGED, true);
        }
    }
    
    /**
     * Returns the base.
     * 
     * @return the base
     */
    public File getBase() {
        return base;
    }

    /**
     * Internal file tracker operation.
     * 
     * @author Holger Eichelberger
     */
    private interface FileTrackerOperation {

        /**
         * Executes a file tracker operation with one or optionally two files.
         * 
         * @param tracker the tracker instance
         * @param file the first file
         * @param file2 the second file (may be <b>null</b>)
         */
        public void execute(FileTracker tracker, File file, File file2);
    }

    /**
     * Executes a file tracker operation with one path parameter.
     * 
     * @param path the path
     * @param op the operation
     */
    private static void execute(net.ssehub.easy.instantiation.core.model.artifactModel.Path path, 
        FileTrackerOperation op) {
        execute(path, null, op);
    }

    /**
     * Executes a file tracker operation with two path parameters.
     * 
     * @param path the path
     * @param path2 the second path, may be <b>null</b>
     * @param op the operation
     */
    private static void execute(net.ssehub.easy.instantiation.core.model.artifactModel.Path path, 
        net.ssehub.easy.instantiation.core.model.artifactModel.Path path2, FileTrackerOperation op) {
        if (enabled) {
            ArtifactModel model = path.getArtifactModel();
            if (null != model) {
                FileTracker tracker = model.getFileTracker();
                File file2 = path2 != null ? new File(tracker.getBase(), path2.getPath()) : null;
                op.execute(tracker, new File(tracker.getBase(), path.getPath()), file2);
            }
        }
    }

    /**
     * Registers the file/folder in the specified path. Uses the artifact model 
     * of {@code path} to identify the file tracker instance.
     * 
     * @param path the file/folder path
     */
    public static void register(net.ssehub.easy.instantiation.core.model.artifactModel.Path path) {
        execute(path, (t, f, o) -> t.register(f));
    }

    /**
     * Prepares the file/folder in the specified path. Uses the artifact model 
     * of {@code path} to identify the file tracker instance. 
     * 
     * @param path the file/folder path
     */
    public static void prepare(net.ssehub.easy.instantiation.core.model.artifactModel.Path path) {
        execute(path, (t, f, o) -> t.prepare(f));
    }
    
    /**
     * Indicates that the specified file/folder in the specified path was renamed. Uses the artifact model 
     * of {@code from} to identify the file tracker instance.
     * 
     * @param from the original file/folder path
     * @param to the new file/folder path
     */
    public static void rename(net.ssehub.easy.instantiation.core.model.artifactModel.Path from, 
        net.ssehub.easy.instantiation.core.model.artifactModel.Path to) {
        execute(from, (t, f1, f2) -> t.rename(f1, f2));
    }
    
    /**
     * Indicates that the file/folder in the specified path was deleted. Uses the artifact model 
     * of {@code path} to identify the file tracker instance.
     * 
     * @param path the file/folder path
     */
    public static void deleted(net.ssehub.easy.instantiation.core.model.artifactModel.Path path) {
        execute(path, (t, f, o) -> t.delete(f));
    }

    /**
     * Indicates that the file/folder in the specified path was stored. Uses the artifact model 
     * of {@code path} to identify the file tracker instance.
     * 
     * @param path the file/folder path
     */
    public static void stored(net.ssehub.easy.instantiation.core.model.artifactModel.Path path) {
        execute(path, (t, f, o) -> t.touch(f));
    }
    
    /**
     * Commits the file/folder in the specified path. Uses the artifact model 
     * of {@code path} to identify the file tracker instance.
     * 
     * @param path the file/folder path, may be <b>null</b> to use the base path of the file tracker
     */
    public static void commit(net.ssehub.easy.instantiation.core.model.artifactModel.Path path) {
        execute(path, (t, f, o) -> t.commit(f));
    }
    
    /**
     * Notifies that {@code from} was renamed to {@code to}.
     * 
     * @param from the original file/folder
     * @param to the original file/folder
     */
    public void rename(File from, File to) {
        State state = fileStatus.get(from.toPath().normalize());
        delete(from);
        update(to, state, true);
    }

    /**
     * Notifies that a file was deleted.
     * 
     * @param file the file
     */
    public void delete(File file) {
        if (enabled) {
            update(file, State.DELETED, false);
        }
    }

    /**
     * Commits the changes in {@link #base}, may delete {@link State#INITIAL} but so far untouched files.
     */
    public void commit() {
        commit(base);
    }

    /**
     * Commits the changes, may delete {@link State#INITIAL} but so far untouched files.
     * 
     * @param base commits the changed files in path, potentially deleting untouched files
     */
    public void commit(File base) {
        commit(base.toPath());
    }

    /**
     * Commits the changes, may delete {@link State#INITIAL} but so far untouched files.
     * 
     * @param base commits the changed files in path, potentially deleting untouched files
     */
    public void commit(Path base) {
        if (enabled && fileStatus.size() > 1) { // more than base???
            if (base == null) {
                base = this.basePath;
            }
            File baseFile = base.toFile();
            if (baseFile.isFile()) {
                baseFile = baseFile.getParentFile();
                base = baseFile.toPath();
            }
            List<PathMatcher> commitMatchers = instantiatePaths(base, matchers, m -> !m.isInclusion());
            List<File> dirs = new ArrayList<>();
            Map<File, Integer> dirPathLen = new HashMap<>();
            for (Map.Entry<Path, State> ent : fileStatus.entrySet()) {
                Path p = ent.getKey();
                State s = ent.getValue();
                if (State.INITIAL == s && p.startsWith(base) && !isExcluded(p, commitMatchers)) {
                    File f = p.toFile();
                    if (f.isFile()) {
                        f.delete();
                        //System.out.println("FT-DEL-F " + f+" "+s);
                    } else if (f.isDirectory()) {
                        if (!dirs.equals(baseFile)) {
                            dirs.add(f);
                            dirPathLen.put(f, f.getPath().length());
                        }
                    }
                }
            }
            Collections.sort(dirs, (d1, d2) -> -Long.compare(dirPathLen.get(d1), dirPathLen.get(d2)));
            for (File d : dirs) {
                org.apache.commons.io.FileUtils.deleteQuietly(d);
                // System.out.println("FT-DEL-D " + d+" "+fileStatus.get(d.toPath()));
            }
            if (base.equals(this.basePath)) {
                reset();
            }
        }
    }
    
}
