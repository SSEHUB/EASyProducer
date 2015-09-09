package de.uni_hildesheim.sse.easy.java.mocks;
//
//import java.io.File;
//
//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.runtime.IPath;
//import org.eclipse.core.runtime.Path;
//
///**
// * Experimental.
// * @author Aike Sass
// *
// */
//abstract class AbstractResourceMock {
//    private File file;
//    
//    /**
//     * Constructor.
//     * @param file file
//     */
//    AbstractResourceMock(File file) {
//        this.file = file;
//    }
//    
//    /**
//     * .
//     * @return file
//     */
//    File getJavaFile() {
//        return file;
//    }
//
//    /**
//     * Resolves the full path.
//     * @return path
//     */
//    public IPath getFullPath() {
//        return new Path(file.getAbsolutePath());
//    }
//    
//    /**
//     * Gets an IFile.
//     * @param name name of the file
//     * @return new FileMock
//     */
//    public IFile getFile(String name) {
//        File destFile = new File(file, name);
//        return new FileMock(destFile);
//    }
//}
