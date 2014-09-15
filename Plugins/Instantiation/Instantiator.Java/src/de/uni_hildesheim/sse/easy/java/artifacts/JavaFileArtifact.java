package de.uni_hildesheim.sse.easy.java.artifacts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactCreator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
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
     * Return whether one of the classes, the methods or attributes has this annotation.
     * 
     * @param annotation
     *            the (qualified) name of the annotation
     * @param field
     *            the name of the annotation field (if <b>null</b> or empty the {@link JavaAnnotation#DEFAULT_FIELD
     *            default name "value"} is used
     * @param value
     *            the name of the annotation value
     * @return <code>true</code> if this annotation is present, <code>false</code> else
     */
    public boolean hasAnnotation(String annotation, String field, String value) {
        Set<JavaClass> classes = this.classes();
        boolean hasAnnotation = false;
        if (null == field || 0 == field.length()) {
            field = JavaAnnotation.DEFAULT_FIELD;
        }
        // TODO efficiency: directly rely on classList and cached structures in JavaAttribute and JavaMethod
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
        String simpleName = JavaAnnotation.toSimpleName(annotation); // as we do not resolve, we must be lazy
        for (JavaAnnotation javaAnnotation : annotations) {
            try {
                if ((javaAnnotation.getQualifiedName().equals(annotation) || javaAnnotation.getName()
                        .equals(simpleName)) && javaAnnotation.getAnnotationValue(field).equals(value)) {
                    hasAnnotation = true;
                    break;
                }
            } catch (ArtifactException e) {
                logger.exception(e);
            }
        }
        return hasAnnotation;
    }

    @Override
    public void artifactChanged(Object cause) throws ArtifactException {
        super.artifactChanged(cause);
        if (cause instanceof Text && null != getText()) {
            initialize(getText().getText().toCharArray());
        } else {
            initialize();
        }
        changed = false;
    }

    @Override
    public void store() throws ArtifactException {
        // store changes in the representation if there are some, store tree afterwards
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
                CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
                TextEdit textEdit = codeFormatter.format(CodeFormatter.K_UNKNOWN, code, 0, code.length(), 0, null);
                IDocument doc = new Document(code);
                try {
                    textEdit.apply(doc);
                } catch (MalformedTreeException e) {
                    throw new ArtifactException(e, ArtifactException.ID_ARTIFACT_INTERNAL);
                } catch (BadLocationException e) {
                    throw new ArtifactException(e, ArtifactException.ID_ARTIFACT_INTERNAL);
                }
                // Save output
                try {
                    writer.write(doc.get());
                } catch (IOException e) {
                    throw new ArtifactException(e, ArtifactException.ID_ARTIFACT_INTERNAL);
                }
            } catch (IOException e) {
                throw new ArtifactException(e, ArtifactException.ID_IO);
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    throw new ArtifactException(e, ArtifactException.ID_IO);
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
        // TODO seperate inner classes
        classList = new ArrayList<JavaClass>();
        ASTParser parser = ASTParser.newParser(AST.JLS4);
        parser.setSource(data);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        // Create AST
        unitNode = (CompilationUnit) parser.createAST(null);
        unitNode.accept(new ASTVisitor() {
            public boolean visit(TypeDeclaration typeDeclaration) {
                // The below code is used to check if it is not a top-level class
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
        // TODO check whether this can be replaced by related apache.commons method
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
    public void deleteChild(FragmentArtifact child) throws ArtifactException {
        // implement if substructures are stored / cached
    }

    /**
     * Returns all imports.
     * 
     * @return all imports
     */
    @SuppressWarnings("unchecked")
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
     * Renames all (qualified) package names, imports and packages in this Java artifact from <code>oldName</code> to
     * <code>newName</code>. Nothing happens, if <code>oldName</code> cannot be found. However, the caller is
     * responsible for potential name clashes due to the execution of this operation.
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
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }

    /**
     * Renames all (qualified) package names, imports and packages in this Java artifact as stated by
     * <code>nameMapping</code>. Nothing happens, if <code>oldName</code> cannot be found. However, the caller is
     * responsible for potential name clashes due to the execution of this operation.
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
        } catch (ArtifactException e) {
            logger.exception(e);
        }
    }

    /**
     * Renames all (qualified) package names in this Java artifact from <code>oldName</code> to <code>newName</code>.
     * Nothing happens, if <code>oldName</code> cannot be found. However, the caller is responsible for potential name
     * clashes due to the execution of this operation.
     * 
     * @param oldName
     *            the old package name
     * @param newName
     *            the new package name
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renamePackages(String oldName, String newName) throws ArtifactException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renamePackages(tmp);
    }

    /**
     * Renames all (qualified) package names in this Java artifact as stated by <code>nameMapping</code>. Nothing
     * happens, if package names cannot be found. However, the caller is responsible for potential name clashes due to
     * the execution of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new package names (key = old, value = new)
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renamePackages(Map<String, String> nameMapping) throws ArtifactException {
        JavaPackage javaPackage = this.javaPackage();
        String path = javaPackage.getName();
        for (Map.Entry<String, String> entry : nameMapping.entrySet()) {
            javaPackage.rename(path.replace(entry.getKey(), entry.getValue()));
        }
    }

    /**
     * Renames all imports in this Java artifact from <code>oldName</code> to <code>newName</code>. Nothing happens, if
     * <code>oldName</code> cannot be found. However, the caller is responsible for potential name clashes due to the
     * execution of this operation.
     * 
     * @param oldName
     *            the old import name
     * @param newName
     *            the new import name
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renameImports(String oldName, String newName) throws ArtifactException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renameImports(tmp);
    }

    /**
     * Renames all imports in this Java artifact as stated by <code>nameMapping</code>. Nothing happens, if package
     * names cannot be found. However, the caller is responsible for potential name clashes due to the execution of this
     * operation.
     * 
     * @param nameMapping
     *            pairs of old and new import names (key = old, value = new)
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renameImports(Map<String, String> nameMapping) throws ArtifactException {
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
     * Renames all qualified names in this Java artifact from <code>oldName</code> to <code>newName</code>. Nothing
     * happens, if <code>oldName</code> cannot be found. However, the caller is responsible for potential name clashes
     * due to the execution of this operation.
     * 
     * @param oldName
     *            the old qualified name
     * @param newName
     *            the new qualified name
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renameQualifiedNames(String oldName, String newName) throws ArtifactException {
        Map<String, String> tmp = new HashMap<String, String>();
        tmp.put(oldName, newName);
        renameQualifiedNames(tmp);
    }

    /**
     * Renames all qualified names in this Java artifact as stated by <code>nameMapping</code>. Nothing happens, if
     * package names cannot be found. However, the caller is responsible for potential name clashes due to the execution
     * of this operation.
     * 
     * @param nameMapping
     *            pairs of old and new qualified names (key = old, value = new)
     * @throws ArtifactException
     *             in case that the operation cannot be executed due to syntax or I/O problems
     */
    public void renameQualifiedNames(Map<String, String> nameMapping) throws ArtifactException {
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
     * @param val the value to be converted
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
}
