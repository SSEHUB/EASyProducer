package de.uni_hildesheim.sse.easy.java.artifacts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import de.uni_hildesheim.sse.easy.java.JavaSettings;
import de.uni_hildesheim.sse.easy.java.JavaSettingsInitializer;
import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.JavaUtilities;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactCreator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents a Java source code file artifact.
 * 
 * @author Holger Eichelberger, Sass
 */
@ArtifactCreator(DefaultJavaFileArtifactCreator.class)
public class JavaFileArtifact extends FileArtifact implements IJavaParent {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaFileArtifact.class, Bundle.ID);

    private File file;

    private CompilationUnit unitNode;
    private List<JavaClass> classList;

    private boolean changed = false;

    /**
     * Creates a new class file artifact.
     * 
     * @param file
     *            the file to read the artifact contents from
     * @param model
     *            the artifact model to create this folder artifact within
     */
    JavaFileArtifact(File file, ArtifactModel model) {
        super(file, model);
        this.file = file;
        // parse lazy on request
    }

    /**
     * Returns the annotation value.
     * 
     * @param annotation
     *            the name of the annotation type
     * @param field
     *            the field to be returned
     * @return the field or <b>null</b> if not found
     */
    @Invisible
    public String annotationValue(String annotation, String field) {
        return ""; // TODO implement, if done, remove @Invisible annotation
    }

    /**
     * Return whether one of the classes, the methods or attributes has this
     * annotation.
     * 
     * @param annotation
     *            the (qualified) name of the annotation
     * @param field
     *            the name of the annotation field (if <b>null</b> or empty the
     *            {@link JavaAnnotation#DEFAULT_FIELD default name "value"} is
     *            used
     * @param value
     *            the name of the annotation value
     * @return <code>true</code> if this annotation is present,
     *         <code>false</code> else
     */
    public boolean hasAnnotation(String annotation, String field, String value) {
        Set<JavaClass> classes = this.classes();
        boolean hasAnnotation = false;
        if (null == field || 0 == field.length()) {
            field = JavaAnnotation.DEFAULT_FIELD;
        }
        // TODO efficiency: directly rely on classList and cached structures in
        // JavaAttribute and JavaMethod
        for (JavaClass javaClass : classes) {
            // Check the classes
            hasAnnotation = checkAnnotation(annotation, field, value, hasAnnotation, javaClass.annotations());
            if (hasAnnotation) {
                break;
            }

            // Check attributes
            Set<JavaAttribute> attributes = javaClass.attributes();
            for (JavaAttribute javaAttribute : attributes) {
                Set<JavaAnnotation> attributeAnnotations = javaAttribute.annotations();
                hasAnnotation = checkAnnotation(annotation, field, value, hasAnnotation, attributeAnnotations);
                if (hasAnnotation) {
                    break;
                }
            }
            // Check methods
            Set<JavaMethod> methods = javaClass.methods();
            for (JavaMethod javaMethod : methods) {
                Set<JavaAnnotation> methodAnnotation = javaMethod.annotations();
                hasAnnotation = checkAnnotation(annotation, field, value, hasAnnotation, methodAnnotation);
                if (hasAnnotation) {
                    break;
                }
            }
        }
        return hasAnnotation;
    }

    /**
     * Checks if a Set of JavaAnnotations contains a specific annotation.
     * 
     * @param annotation
     *            The annotation name
     * @param field
     *            the name of the field
     * @param value
     *            The annotation value
     * @param hasAnnotation
     *            indicates if annotation is present
     * @param annotations
     *            Set with JavaAnnotations
     * @return hasAnnotation true of false
     */
    private boolean checkAnnotation(String annotation, String field, String value, boolean hasAnnotation,
            Set<JavaAnnotation> annotations) {
        String simpleName = JavaAnnotation.toSimpleName(annotation); // as we do
                                                                     // not
                                                                     // resolve,
                                                                     // we must
                                                                     // be lazy
        for (JavaAnnotation javaAnnotation : annotations) {
            try {
                if ((javaAnnotation.getQualifiedName().equals(annotation)
                        || javaAnnotation.getName().equals(simpleName))
                        && javaAnnotation.getAnnotationValue(field).equals(value)) {
                    hasAnnotation = true;
                    break;
                }
            } catch (VilException e) {
                logger.exception(e);
            }
        }
        return hasAnnotation;
    }

    @Override
    public void artifactChanged(Object cause) throws VilException {
        super.artifactChanged(cause);
        if (cause instanceof Text && null != getText()) {
            initialize(getText().getText().toCharArray());
        } else {
            initialize();
        }
        changed = false;
    }

    @Override
    public void store() throws VilException {
        // store changes in the representation if there are some, store tree
        // afterwards
        // both changes shall not overlap...
        super.store();
        if (changed) {
            // Check if file exists
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    logger.exception(e);
                }
            }
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                String code = unitNode.toString();
                Map<String, String> options = new HashMap<String, String>();
                options.put(DefaultCodeFormatterConstants.FORMATTER_INSERT_SPACE_BEFORE_ASSIGNMENT_OPERATOR, 
                    JavaCore.INSERT);
                options.put(DefaultCodeFormatterConstants.FORMATTER_INSERT_SPACE_AFTER_ASSIGNMENT_OPERATOR, 
                    JavaCore.INSERT);
                options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7);
                options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
                options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
                options.put(DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR, JavaCore.SPACE);
                CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(options);
                TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, code, 0, code.length(), 0,
                        System.getProperty("line.separator"));
                IDocument doc = new Document(code);
                try {
                    if (null != textEdit) {
                        textEdit.apply(doc);
                    }
                } catch (MalformedTreeException e) {
                    throw new VilException(e, VilException.ID_ARTIFACT_INTERNAL);
                } catch (BadLocationException e) {
                    throw new VilException(e, VilException.ID_ARTIFACT_INTERNAL);
                }
                // Save output
                try {
                    writer.write(doc.get());
                } catch (IOException e) {
                    throw new VilException(e, VilException.ID_ARTIFACT_INTERNAL);
                }
            } catch (IOException e) {
                throw new VilException(e, VilException.ID_IO);
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    throw new VilException(e, VilException.ID_IO);
                }
            }
            changed = false;
        }
    }

    /**
     * Returns the classes of this java file.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = JavaClass.class)
    public Set<JavaClass> classes() {
        if (null == classList) {
            initialize();
        }
        return new ArraySet<JavaClass>(classList.toArray(new JavaClass[classList.size()]), JavaClass.class);
    }

    /**
     * Returns the specified classes of this java file.
     * 
     * @param name
     *            the name of the class
     * @return the specified class or <b>null</b>
     */
    public JavaClass getClassByName(String name) {
        JavaClass result = null;
        if (null == classList) {
            initialize();
        }

        for (int c = 0; null == result && c < classList.size(); c++) {
            JavaClass cls = classList.get(c);
            try {
                if (cls.getName().equals(name)) {
                    result = cls;
                }
            } catch (VilException e) {
                logger.exception(e);
            }
        }
        return result;
    }

    /**
     * Returns the default class of this Java File artifact, i.e., the class
     * corresponding to the name of this artifact.
     * 
     * @return the default class or <b>null</b> if there is none
     */
    public JavaClass getDefaultClass() {
        JavaClass result;
        try {
            String name = getName();
            if (name.endsWith(".java")) {
                name = name.substring(0, name.length() - 5);
            }
            result = getClassByName(name);
        } catch (VilException e) {
            logger.exception(e);
            result = null;
        }
        return result;
    }

    /**
     * Initializes the parse tree / classes from {@link #file}.
     */
    private void initialize() {
        initialize(readFileToString(file).toCharArray());
    }

    /**
     * Initializes the parse tree / classes.
     * 
     * @param data
     *            the data to initialize from (source code as characters)
     */
    private void initialize(char[] data) {
        // TODO separate inner classes
        classList = new ArrayList<JavaClass>();
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        parser.setSource(data);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        // Set options to resolve bindings
        parser.setBindingsRecovery(true);
        parser.setResolveBindings(true);
        Hashtable<String, String> options = JavaCore.getOptions();
        options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
        parser.setCompilerOptions(options);
        String unitName = FilenameUtils.getBaseName(file.getName());
        parser.setUnitName(unitName);
        String[] classpath = JavaUtilities.JRE_CLASS_PATH;
        String sourcePath;
        boolean isClasspathFromScript = false;
        if (null != getArtifactModel()) {
            Object classPathFromScript = getArtifactModel().getSettings(JavaSettings.CLASSPATH);
            if (null != classPathFromScript) {
                isClasspathFromScript = true;
                sourcePath = JavaSettingsInitializer.determineClasspath(classPathFromScript);
            } else {
                // if no classpath is given via VIL
                sourcePath = JavaSettingsInitializer.determineClasspath(null);
            }
        } else {
            sourcePath = JavaSettingsInitializer.determineClasspath(null);
        }
        // WORKAROUND! FIX IT!
        if (sourcePath.contains("//")) {
            sourcePath = sourcePath.replaceAll("//", "/");
        }
        String[] sources = {sourcePath};
//        String[] newClasspath = new String[classpath.length + sources.length];
//        System.arraycopy(classpath, 0, newClasspath, 0, classpath.length);
//        System.arraycopy(sources, 0, newClasspath, classpath.length - 1, sources.length);
//        logger.warn("CLASSPATH: " + Arrays.toString(sources));
//        logger.warn("NEW CLASSPATH: " + Arrays.toString(newClasspath));
        parser.setEnvironment(classpath, sources, new String[] {"UTF-8" }, true);
        // Create AST
        unitNode = (CompilationUnit) parser.createAST(null);
        // Check for problems but only if the classpath was set via VIL
        if (isClasspathFromScript) {
            IProblem[] problems = unitNode.getProblems();
            if (problems != null && problems.length > 0) {
                logger.warn("Got " + problems.length + " problems compiling the source file: " 
                    + file.getAbsolutePath());
                for (IProblem problem : problems) {
                    logger.warn(problem.getMessage());
                }
            }
        }
        unitNode.accept(new ASTVisitor() {
            public boolean visit(TypeDeclaration typeDeclaration) {
                // The below code is used to check if it is not a top-level
                // class
                if (typeDeclaration.isPackageMemberTypeDeclaration()) {
                    classList.add(new JavaClass(typeDeclaration, JavaFileArtifact.this));
                }
                return true;
            }
        });
        unitNode.recordModifications();
    }
    
    /**
     * Reads a file to String.
     * 
     * @param filePath
     *            The file path as String.
     * @return File as String.
     */
    @Invisible
    public static String readFileToString(File filePath) {
        // TODO check whether this can be replaced by related apache.commons
        // method
        StringBuilder fileData = new StringBuilder(1000);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            char[] buf = new char[10];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
            reader.close();
        } catch (FileNotFoundException fnf) {
            logger.exception(fnf);
        } catch (IOException ioe) {
            logger.exception(ioe);
        }
        return fileData.toString();
    }

    @Override
    public void notifyChildChanged(FragmentArtifact child) {
        changed = true;
    }

    @Override
    public void deleteChild(FragmentArtifact child) throws VilException {
        // implement if substructures are stored / cached
    }

    /**
     * Returns all imports.
     * 
     * @return all imports
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(returnGenerics = JavaImport.class)
    public Set<JavaImport> imports() {
        if (null == unitNode) {
            initialize();
        }
        List<JavaImport> imports = new ArrayList<JavaImport>();
        List<ImportDeclaration> unitNodeImports = unitNode.imports();
        for (ImportDeclaration importDeclaration : unitNodeImports) {
            JavaImport javaImport = new JavaImport(importDeclaration, JavaFileArtifact.this);
            imports.add(javaImport);
        }
        return new ArraySet<JavaImport>(imports.toArray(new JavaImport[imports.size()]), JavaImport.class);
    }

    /**
     * Returns the package declaration.
     * 
     * @return {@link JavaPackage} representing the package declaration
     */
    public JavaPackage javaPackage() {
        if (null == unitNode) {
            initialize();
        }
        JavaPackage javaPackage = new JavaPackage(unitNode.getPackage(), JavaFileArtifact.this);
        return javaPackage;
    }

    /**
     * Returns all qualified names.
     * 
     * @return all qualified names.
     */
    public Set<JavaQualifiedName> qualifiedNames() {
        if (null == classList) {
            initialize();
        }
        List<JavaQualifiedName> qualifiedNames = new ArrayList<JavaQualifiedName>();
        for (JavaClass javaClass : classList) {
            for (JavaQualifiedName javaQualifiedName : javaClass.qualifiedNames()) {
                qualifiedNames.add(javaQualifiedName);
            }
        }
        return new ArraySet<JavaQualifiedName>(qualifiedNames.toArray(new JavaQualifiedName[qualifiedNames.size()]),
                JavaQualifiedName.class);
    }

    /**
     * Renames all (qualified) package names, imports and packages in this Java
     * artifact from <code>oldName</code> to <code>newName</code>. Nothing
     * happens, if <code>oldName</code> cannot be found. However, the caller is
     * responsible for potential name clashes due to the execution of this
     * operation.
     * 
     * @param oldName
     *            the old package name
     * @param newName
     *            the new package name
     */
    public void modifyNamespace(String oldName, String newName) {
        try {
            renameImports(oldName, newName);
            renameQualifiedNames(oldName, newName);
            renamePackages(oldName, newName);
            store();
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Renames all (qualified) package names, imports and packages in this Java
     * artifact as stated by <code>nameMapping</code>. Nothing happens, if
     * <code>oldName</code> cannot be found. However, the caller is responsible
     * for potential name clashes due to the execution of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new package names (key = old, value = new)
     */
    public void modifiyNamespace(Map<String, String> nameMapping) {
        try {
            renameImports(nameMapping);
            renameQualifiedNames(nameMapping);
            renamePackages(nameMapping);
            store();
        } catch (VilException e) {
            logger.exception(e);
        }
    }

    /**
     * Renames all (qualified) package names in this Java artifact from
     * <code>oldName</code> to <code>newName</code>. Nothing happens, if
     * <code>oldName</code> cannot be found. However, the caller is responsible
     * for potential name clashes due to the execution of this operation.
     * 
     * @param oldName
     *            the old package name
     * @param newName
     *            the new package name
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renamePackages(String oldName, String newName) throws VilException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renamePackages(tmp);
    }

    /**
     * Renames all (qualified) package names in this Java artifact as stated by
     * <code>nameMapping</code>. Nothing happens, if package names cannot be
     * found. However, the caller is responsible for potential name clashes due
     * to the execution of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new package names (key = old, value = new)
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renamePackages(Map<String, String> nameMapping) throws VilException {
        JavaPackage javaPackage = this.javaPackage();
        String path = javaPackage.getName();
        for (Map.Entry<String, String> entry : nameMapping.entrySet()) {
            javaPackage.rename(path.replace(entry.getKey(), entry.getValue()));
        }
    }

    /**
     * Renames all imports in this Java artifact from <code>oldName</code> to
     * <code>newName</code>. Nothing happens, if <code>oldName</code> cannot be
     * found. However, the caller is responsible for potential name clashes due
     * to the execution of this operation.
     * 
     * @param oldName
     *            the old import name
     * @param newName
     *            the new import name
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renameImports(String oldName, String newName) throws VilException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renameImports(tmp);
    }

    /**
     * Renames all imports in this Java artifact as stated by
     * <code>nameMapping</code>. Nothing happens, if package names cannot be
     * found. However, the caller is responsible for potential name clashes due
     * to the execution of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new import names (key = old, value = new)
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renameImports(Map<String, String> nameMapping) throws VilException {
        Set<JavaImport> imports = this.imports();
        for (Map.Entry<String, String> entry : nameMapping.entrySet()) {
            for (JavaImport javaImport : imports) {
                if (javaImport.getName().contains(entry.getKey())) {
                    javaImport.rename(javaImport.getName().replace(entry.getKey(), entry.getValue()));
                }
            }
        }
    }

    /**
     * Renames all qualified names in this Java artifact from
     * <code>oldName</code> to <code>newName</code>. Nothing happens, if
     * <code>oldName</code> cannot be found. However, the caller is responsible
     * for potential name clashes due to the execution of this operation.
     * 
     * @param oldName
     *            the old qualified name
     * @param newName
     *            the new qualified name
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renameQualifiedNames(String oldName, String newName) throws VilException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renameQualifiedNames(tmp);
    }

    /**
     * Renames all qualified names in this Java artifact as stated by
     * <code>nameMapping</code>. Nothing happens, if package names cannot be
     * found. However, the caller is responsible for potential name clashes due
     * to the execution of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new qualified names (key = old, value = new)
     * @throws VilException
     *             in case that the operation cannot be executed due to syntax
     *             or I/O problems
     */
    public void renameQualifiedNames(Map<String, String> nameMapping) throws VilException {
        Set<JavaClass> classes = this.classes();
        for (JavaClass javaClass : classes) {
            Set<JavaQualifiedName> qualifiedNames = javaClass.qualifiedNames();
            for (Map.Entry<String, String> entry : nameMapping.entrySet()) {
                for (JavaQualifiedName javaQualifiedName : qualifiedNames) {
                    javaQualifiedName.rename(javaQualifiedName.getName().replace(entry.getKey(), entry.getValue()));
                }
            }
        }
    }

    /**
     * Conversion operation.
     * 
     * @param val
     *            the value to be converted
     * @return the converted value or null
     */
    @Invisible
    @Conversion
    public static JavaFileArtifact convert(IFileSystemArtifact val) {
        JavaFileArtifact convertedValue = null;
        if (val instanceof JavaFileArtifact) {
            convertedValue = (JavaFileArtifact) val;
        }
        return convertedValue;
    }

    /**
     * Conversion operation.
     * 
     * @param val
     *            the value to be converted
     * @return the converted value
     * @throws VilException
     *             in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static JavaFileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return convert(path);
    }

    /**
     * Conversion operation.
     * 
     * @param path
     *            the path to be converted
     * @return the converted value
     * @throws VilException
     *             in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static JavaFileArtifact convert(Path path) throws VilException {
        return ArtifactFactory.createArtifact(JavaFileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }

}
