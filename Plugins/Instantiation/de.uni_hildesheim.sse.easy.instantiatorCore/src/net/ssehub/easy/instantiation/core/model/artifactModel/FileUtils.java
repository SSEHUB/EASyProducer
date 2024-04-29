package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Some file helper methods.
 * 
 * @author Holger Eichelberger
 */
public class FileUtils {

    /**
     * Prevents external instantiations (utility class).
     */
    private FileUtils() {
    }
    
    /**
     * Deletes the given file and handles the exceptions / return values in the
     * sense of VIL. 
     * 
     * @param file the file to be deleted
     * @throws VilException in case that anything goes seriously wrong
     */
    static void delete(File file) throws VilException {
        if (file.exists()) {
            try {
                if (FileUtils.isDirectory(file)) {
                    try {
                        org.apache.commons.io.FileUtils.deleteDirectory(file);
                    } catch (IOException e) {
                        throw new VilException(e.getMessage(), VilException.ID_IO);
                    }
                } else {
                    if (!file.delete()) {
                        throw new VilException("cannot delete " + file.getAbsolutePath(), 
                            VilException.ID_IO);
                    }
                }
            } catch (SecurityException e) {
                throw new VilException(e, VilException.ID_SECURITY);
            }
        } // exception ??
    }
    
    /**
     * Renames the given file and handles the exceptions / return values in the
     * sense of VIL. 
     * 
     * @param file the file to be renamed
     * @param newFile the new file name
     * @throws VilException in case that anything goes seriously wrong
     */
    static void rename(File file, File newFile) throws VilException {
        try {
            file.renameTo(newFile);
        } catch (SecurityException e) {
            throw new VilException(e, VilException.ID_SECURITY);
        }
    }

    /**
     * Renames the given file and handles the exceptions / return values in the
     * sense of VIL. 
     * 
     * @param file the file to be renamed
     * @param name the new name
     * @throws VilException in case that anything goes seriously wrong
     */
    static void rename(File file, String name) throws VilException {
        rename(file, new File(name));
    }

    /**
     * Moves <code>source</code> to <code>target</code>.
     * 
     * @param source the source file system artifact
     * @param target the target file system artifact
     * @return the created or touched artifacts
     * @throws VilException in case of serious (I/O) errors
     */
    static List<IFileSystemArtifact> move(IFileSystemArtifact source, IFileSystemArtifact target) 
        throws VilException {
        return copyOrMove(source, target, true);
    }

    /**
     * Copy or move from the <code>source</code> path to the <code>target</code> artifact.
     * 
     * @param source the source path
     * @param target the target artifact
     * @param move move or copy
     * @return the created or touched artifacts
     * @throws VilException in case that file system operations or artifact model operations fail
     */
    static Set<IFileSystemArtifact> copyOrMove(Path source, IFileSystemArtifact target, boolean move) 
        throws VilException {
        List<IFileSystemArtifact> result = new ArrayList<IFileSystemArtifact>();
        Path tp = target.getPath();
        File tf = tp.getAbsolutePath();
        if (!tf.exists() && FileUtils.isDirectory(tf)) {
            tf.mkdirs();
        }
        ArtifactModel tm = tp.getArtifactModel();
        Set<FileArtifact> artifacts = source.selectAll();
        if (artifacts.size() == 0 && hasFiles(source.getAbsolutePath())) {
            // usually a folder external to source/target
            List<FileArtifact> arts = new ArrayList<FileArtifact>();
            ScanResult<FileArtifact> res = new ScanResult<FileArtifact>(arts);
            scan(source.getAbsolutePath(), null, 0L, res, FileArtifact.class);
            artifacts = new ListSet<FileArtifact>(arts, FileArtifact.class);
        }
        for (FileArtifact f : artifacts) {
            Path sp = f.getPath();
            File destinationFile = determineDestination(source, f, tf);
            ArtifactModel sm;
            if (move) {
                sm = sp.getArtifactModel();
            } else {
                sm = null;
            }
            FileUtils.copyOrMove(sp.getAbsolutePath(), destinationFile, sm, tm, result);
        }
        return new ListSet<IFileSystemArtifact>(result, IFileSystemArtifact.class);
    }
    
    /**
     * Returns whether {@code file} exists or is a directory and contains files.
     * 
     * @param file the file to check
     * @return {@code true} if there are files in {@code file}
     */
    public static boolean hasFiles(File file) {
        boolean result = false;
        if (file.isFile()) {
            result = file.exists();
        } else if (file.isDirectory()) {
            File[] dir = file.listFiles();
            result = dir != null && dir.length > 0;
        }
        return result;
    }

    /**
     * Copy or move from <code>source</code> to <code>target</code> considering each as directories 
     * or files. This method informs the involved artifact models appropriately.
     * 
     * @param source the source to copy from
     * @param target the target to copy to
     * @param move move or copy
     * @return the created or touched artifacts
     * @throws VilException in case that file system operations or artifact model operations fail
     */
    private static List<IFileSystemArtifact> copyOrMove(IFileSystemArtifact source, IFileSystemArtifact target, 
        boolean move) throws VilException {
        List<IFileSystemArtifact> result = new ArrayList<IFileSystemArtifact>();
        Path sp = source.getPath();
        Path tp = target.getPath();
        if (!sp.isPattern() && !tp.isPattern()) {
            File sf = sp.getAbsolutePath(); 
            File tf = tp.getAbsolutePath();
            if (!tf.exists() && FileUtils.isDirectory(tf)) {
                tf.mkdirs();
            }
            ArtifactModel sm;
            if (move) {
                sm = sp.getArtifactModel();
            } else {
                sm = null;
            }
            copyOrMove(sf, tf, sm, tp.getArtifactModel(), result);
        }
        return result;
    }
    
    /**
     * Copy or move from <code>source</code> to <code>target</code> considering each as directories 
     * or files. This method informs the involved artifact models appropriately.
     * 
     * @param source the source to copy from
     * @param target the target to copy to
     * @param sourceModel the source artifact model (may be <b>null</b> for copy, non-null for move operation)
     * @param targetModel the target artifact model
     * @param artifacts the created or touched artifacts (may be <b>null</b> then resulting artifacts will not be 
     *     collected)
     * @throws VilException in case that file system operations or artifact model operations fail
     */
    private static void copyOrMove(File source, File target, ArtifactModel sourceModel, ArtifactModel targetModel, 
        List<IFileSystemArtifact> artifacts) throws VilException {
        if (source.isDirectory()) {
            if (target.isFile()) {
                target = target.getParentFile();
            }
            File[] files = source.listFiles();
            if (null != files) {
                for (File f: files) {
                    if (f.isDirectory()) {
                        target = new File(target, f.getName());
                        target.mkdir();
                    }
                    copyOrMove(f, target, sourceModel, targetModel, artifacts);
                }
            }
        } else {
            boolean move = (null != sourceModel);
            if (move) {
                sourceModel.delete(source);
            }
            try {
                if (target.isDirectory()) {
                    if (move) {
                        org.apache.commons.io.FileUtils.moveFileToDirectory(source, target, true);
                    } else {
                        org.apache.commons.io.FileUtils.copyFileToDirectory(source, target, false);
                    }
                    target = new File(target, source.getName());
                } else {
                    if (move) {
                        org.apache.commons.io.FileUtils.moveFile(source, target);
                    } else {
                        org.apache.commons.io.FileUtils.copyFile(source, target, false);
                    }
                }
            } catch (IOException e) {
                throw new VilException(e, VilException.ID_IO);
            }
            IFileSystemArtifact artifact = ArtifactFactory.createArtifact(IFileSystemArtifact.class, 
                target, targetModel);
            if (null != artifacts) {
                artifacts.add(artifact);
            }
            
        }
    }

    /**
     * Copies <code>source</code> to <code>target</code>.
     * 
     * @param source the source file system artifact
     * @param target the target file system artifact
     * @return the created or touched artifacts
     * @throws VilException in case of serious (I/O) errors
     */
    static List<IFileSystemArtifact> copy(IFileSystemArtifact source, IFileSystemArtifact target) 
        throws VilException {
        return copyOrMove(source, target, false);
    }
    
    /**
     * A heuristic whether the given <code>path</code> is a file.
     * 
     * @param path the path to be considered
     * @return <code>true</code> if <code>path</code> is considered to be a file, <code>false</code> else
     */
    public static boolean isFile(String path) {
        boolean isFile = true;
        path = FilenameUtils.normalize(path, true);
        int lastSepPos = path.lastIndexOf('/'); // normalized
        if (lastSepPos == path.length() - 1) {
            isFile = false;
        } else {
            int lastDotPos = path.lastIndexOf('.');
            isFile = (lastDotPos >= 0 && lastDotPos > lastSepPos);
        }
        return isFile;
    }
    
    /**
     * Returns whether <code>file</code> is a file regardless whether it exists or not.
     * 
     * @param file the file to be considered
     * @return <code>true</code> if <code>file</code> is considered to be a file, <code>false</code> else
     */
    public static boolean isFile(File file) {
        boolean isFile;
        if (!file.exists()) {
            isFile = isFile(file.getAbsolutePath());
        } else {
            isFile = file.isFile();
        }
        return isFile;
    }

    /**
     * Returns whether <code>file</code> is a directory regardless whether it exists or not.
     * 
     * @param file the file to be considered
     * @return <code>true</code> if <code>file</code> is considered to be a directory, <code>false</code> else
     */
    public static boolean isDirectory(File file) {
        boolean isDirectory;
        if (!file.exists()) {
            isDirectory = !isFile(file.getAbsolutePath());
        } else {
            isDirectory = file.isDirectory();
        }
        return isDirectory;
    }
    
    /**
     * Represents the result of a {@link FileUtils#scan(File, ArtifactModel, long, ScanResult, Class)} execution.
     * 
     * @param <T> the actual type of artifacts to be produced by {@link FileUtils#scan(File, ArtifactModel, long, 
     *    ScanResult, Class)}
     * 
     * @author Holger Eichelberger
     */
    public static class ScanResult <T extends IArtifact> {
        private List<T> result;
        private List<VilException> errors;

        /**
         * Creates a new scan result with a list to put the created artifacts into.
         * 
         * @param result the list to store the created artifacts (may be <b>null</b>)
         */
        public ScanResult(List<T> result) {
            this(result, new ArrayList<VilException>());
        }

        /**
         * Creates a new scan result with a list to put the created artifacts into and a list for errors.
         * 
         * @param result the list to store the created artifacts (may be <b>null</b>)
         * @param errors the list to store the caused exceptions into (may be <b>null</b>)
         */
        public ScanResult(List<T> result, List<VilException> errors) {
            this.result = result;
            this.errors = errors;
        }
        
        /**
         * Default handling of collected errors. If errors occurred, put them into a 
         * combined {@link VilException}.
         * 
         * @throws VilException thrown if errors were collected
         */
        public void checkForException() throws VilException {
            if (null != errors && !errors.isEmpty()) {
                throw new VilException(errors);
            }
        }
        
    }

    /**
     * Scans {@code location} for new files.
     * 
     * @param <T> the actual type of artifacts to be produced
     * 
     * @param location the location to scan
     * @param model the artifact model to generate new artifacts into if needed
     * @param timestamp the timestamp all returned artifacts must be newer (use {@link PathUtils#normalizedTime()})
     * @param result the resulting artifacts and errors (to be modified as a side effect, may be <b>null</b>)
     * @param type the artifact type to be produced (may be <b>null</b> for any restriction)
     */
    public static <T extends IArtifact> void scan(File location, ArtifactModel model, long timestamp, 
        ScanResult<T> result, Class<T> type) {
        if (null != location) {
            if (location.isDirectory()) {
                File[] files = location.listFiles();
                if (null != files) {
                    for (int f = 0; f < files.length; f++) {
                        scan(files[f], model, timestamp, result, type);
                    }
                }
            } else {
                if (PathUtils.normalizeTime(location) >= timestamp) {
                    try {
                        T artifact = ArtifactFactory.createArtifact(type, location, model);
                        if (null != result && null != result.result) {
                            result.result.add(artifact);
                        }
                    } catch (VilException e) {
                        if (null != result && null != result.errors) {
                            result.errors.add(e);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Returns a File representing the system temporary directory.
     * 
     * @return the system temporary directory. 
     */
    public static File getTempDirectory() {
        return org.apache.commons.io.FileUtils.getTempDirectory();
    }
    
    /**
     * Determines the destination of an artifact, which shall be copied/moved from a given source path (e.g. a pattern)
     * to a given target (folder). Considers sub folder structures, will not consider constant parts at the beginning of
     * a pattern. For instance:<br/>
     * 
     * Elements of <code>"src/foo/**&#47;/bar/*.java"</code> will be copied to
     * <code>"targetFile/**&#47;/bar/*.java"</code>
     * 
     * <br/>
     * Part of the {@link #copyOrMove(Path, IFileSystemArtifact, boolean)} method.
     * @param sourcePath The sourcepath, containing the sourceArtefact (may be a pattern). Must not be <b>null</b>.
     * @param sourceArtefakt An artifact inside the given sourcePath. Must not be <b>null</b>
     * @param targetFile The destination, should be a folder. Must not be <b>null</b>
     * @return The destination of the the file to be copied/moved.
     */
    private static File determineDestination(Path sourcePath, FileArtifact sourceArtefakt, File targetFile) {
        String srcFile = sourceArtefakt.getPath().getPath();
        String relativeFile = sourcePath.getArtifactModel().makeRelative(srcFile);
        String relativeDir = sourcePath.getArtifactModel().makeRelative(sourcePath.getAbsolutePath());
        String[] segmentsDir = relativeDir.split("/");
        String[] segmentsFile = relativeFile.split("/");
        
        // Determine constant part of the pattern
        boolean constantPart = true;
        int variableSegment = 0;
        for (int i = 0, end = Math.min(segmentsDir.length, segmentsFile.length); i < end && constantPart; i++) {
            if (segmentsDir[i].equals(segmentsFile[i])) {
                variableSegment++;
            } else {
                constantPart = false;
            }
        }
        
        // Determine sub structure inside pattern, which shall be retained
        StringBuffer variablePart = new StringBuffer();
        for (int i = variableSegment; i < segmentsFile.length; i++) {
            variablePart.append(segmentsFile[i]);
            variablePart.append("/");
        }
        
        return new File(targetFile, variablePart.toString());
    }

    
}
