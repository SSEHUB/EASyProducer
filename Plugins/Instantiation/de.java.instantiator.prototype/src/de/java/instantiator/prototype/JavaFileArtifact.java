package de.java.instantiator.prototype;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//import org.eclipse.jdt.core.dom.AST;
//import org.eclipse.jdt.core.dom.ASTParser;
//import org.eclipse.jdt.core.dom.ASTVisitor;
//import org.eclipse.jdt.core.dom.Annotation;
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.Expression;
//import org.eclipse.jdt.core.dom.FieldDeclaration;
//import org.eclipse.jdt.core.dom.Modifier;
//import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
//import org.eclipse.jdt.core.dom.StringLiteral;
//
//import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
//import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
//
///**
// * Old Method to change the modifier of an attribute. Can be deleted once the new method is implemented.
// * 
// * @author Sass
// *
// */
//public class JavaFileArtifact {
//
//    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(JavaFileArtifact.class, "");
//
//    private File srcFile;
//
//    private File destFile;
//
//    private String annotation;
//
//    private String annotationValue;
//
//    /**
//     * Default Constructor.
//     * 
//     * @param srcFile
//     * @param destFile
//     * @param annotation
//     * @param annotationValue
//     */
//    public JavaFileArtifact(File srcFile, File destFile, String annotation, String annotationValue) {
//        this.srcFile = srcFile;
//        this.destFile = destFile;
//        this.annotation = annotation;
//        this.annotationValue = annotationValue;
//    }
//
//    public void start() {
//        parse(readFileToString(srcFile));
//    }
//
//    /**
//     * use ASTParse to parse string
//     * 
//     * @param str The String that should be parsed.
//     */
//    private void parse(String str) {
//        ASTParser parser = ASTParser.newParser(AST.JLS3);
//        parser.setSource(str.toCharArray());
//        parser.setKind(ASTParser.K_COMPILATION_UNIT);
//        // Create AST
//        final CompilationUnit unitNode = (CompilationUnit) parser.createAST(null);
//        unitNode.recordModifications();
//        // Visit all variable declarations
//        unitNode.accept(new ASTVisitor() {
//            @SuppressWarnings({ "unchecked", "rawtypes" })
//            @Override
//            public boolean visit(FieldDeclaration node) {
//                List modifiers = node.modifiers();
//                for (Object modifier : modifiers) {
//                    if (modifier instanceof SingleMemberAnnotation) {
//                        // Get annotation name and value
//                        String annoName = ((Annotation) modifier).getTypeName().toString();
//                        Expression annoValue = ((SingleMemberAnnotation) modifier).getValue();
//                        String value = annoValue.toString();
//                        if (annoValue instanceof StringLiteral) {
//                            value = value.substring(1, value.length() - 1);
//                        }
//                        // Edit modifier
//                        if (annoName.equals(annotation) && value.equals(annotationValue)) {
//                            modifiers.add(node.getAST().newModifier(Modifier.ModifierKeyword.FINAL_KEYWORD));
//                            modifiers.add(node.getAST().newModifier(Modifier.ModifierKeyword.STATIC_KEYWORD));
//                        }
//                    }
//                }
//                return false;
//            }
//        });
//        printStringToFile(unitNode, destFile);
//    }
//
//    /**
//     * Prints a CompilationUnit to file.
//     * 
//     * @param unitNode
//     *            The CompilationUnit that should be saved.
//     * @param dest
//     *            The destination file path.
//     */
//    private void printStringToFile(CompilationUnit unitNode, File dest) {
//        BufferedWriter writer = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(dest));
//            writer.write(unitNode.toString());
//
//        } catch (IOException e) {
//            logger.exception(e);
//        } finally {
//            try {
//                if (writer != null)
//                    writer.close();
//            } catch (IOException e) {
//                logger.exception(e);
//            }
//        }
//    }
//
//    /**
//     * Reads a file to String.
//     * 
//     * @param filePath
//     *            The file path as String.
//     * @return File as String.
//     * @throws IOException
//     */
//    private String readFileToString(File filePath) {
//        StringBuilder fileData = new StringBuilder(1000);
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(filePath));
//            char[] buf = new char[10];
//            int numRead = 0;
//            while ((numRead = reader.read(buf)) != -1) {
//                String readData = String.valueOf(buf, 0, numRead);
//                fileData.append(readData);
//                buf = new char[1024];
//            }
//            reader.close();
//        } catch (FileNotFoundException fnf) {
//            logger.exception(fnf);
//        } catch (IOException ioe) {
//            logger.exception(ioe);
//        }
//        return fileData.toString();
//    }
//
//    @Override
//    public String toString() {
//        return srcFile + " " + destFile + " " + annotation + " " + annotationValue;
//    }
//}
