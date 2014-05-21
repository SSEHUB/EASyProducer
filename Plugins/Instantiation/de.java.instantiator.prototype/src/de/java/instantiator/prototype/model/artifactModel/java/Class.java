package de.java.instantiator.prototype.model.artifactModel.java;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

import de.java.instantiator.prototype.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Represents a Java class.
 * 
 * @author Holger Eichelberger
 */
public class Class extends FragmentArtifact {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(Class.class, Bundle.ID);

    private ICompilationUnit compilationUnit;
    
    private CompilationUnit astRoot;

    private String className;

    /**
     * Default Constructor.
     * 
     * @param compilationUnit The ICompilationUnit of the class
     */
    public Class(ICompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        this.className = getClassName();
        this.astRoot = parse(compilationUnit);
        // start record of the modifications
        astRoot.recordModifications();
    }

    @Override
    public void delete() throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getName() throws ArtifactException {
        return className;
    }

    @Override
    public void rename(String name) throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }

    /**
     * Returns the annotations of this class.
     * 
     * @return the annotations
     */
    @OperationMeta(returnGenerics = Annotation.class)
    public Set<Annotation> annotations() {
        return new ArraySet<Annotation>(null, Annotation.class);
    }

    /**
     * Returns the methods of this class.
     * 
     * @return the methods
     */
    @OperationMeta(returnGenerics = Method.class)
    public Set<Method> methods() {
        final List<Method> list = new ArrayList<Method>();
        astRoot.accept(new ASTVisitor() {
            @Override
            public boolean visit(MethodDeclaration node) {
//                String attributeName = "";
//                Object object = node.fragments().get(0);
//                if (object instanceof VariableDeclarationFragment) {
//                    attributeName = ((VariableDeclarationFragment) object).getName().toString();
//                }
                Method method = new Method(node);
                list.add(method);
                return false;
            }
        });
        return new ArraySet<Method>(list.toArray(new Method[list.size()]), Method.class);
    }
    
    /**
     * Returns the inner classes of this class.
     * 
     * @return Set with inner classes
     */
    //TODO NICHT FERTIG! GIBT NIX ZURÜCK
    public Set<Class> innerClasses() {
        final List<Class> list = new ArrayList<Class>();
        astRoot.accept(new ASTVisitor() {
            public boolean visit(TypeDeclaration typeDeclaration) {
                // The below code is used to check if it is not a top-level class
                if (!typeDeclaration.isPackageMemberTypeDeclaration()) {
                    // Get more details from the type declaration.
                    System.out.println(typeDeclaration);
                    System.out.println("----------------");
//                    Class clazz = new Class(typeDeclaration);
                } 
                return true;
            }
        });
        return new ArraySet<Class>(list.toArray(new Class[list.size()]), Class.class);
        
    }

    /**
     * Returns the attributes of this class.
     * 
     * @return the attributes
     */
    @OperationMeta(returnGenerics = Attribute.class)
    public Set<Attribute> attributes() {
        final List<Attribute> list = new ArrayList<Attribute>();
        astRoot.accept(new ASTVisitor() {
            @Override
            public boolean visit(FieldDeclaration node) {
                String attributeName = "";
                Object object = node.fragments().get(0);
                if (object instanceof VariableDeclarationFragment) {
                    attributeName = ((VariableDeclarationFragment) object).getName().toString();
                }
                Attribute attribute = new Attribute(node, attributeName);
                list.add(attribute);
                return false;
            }
        });
        return new ArraySet<Attribute>(list.toArray(new Attribute[list.size()]), Attribute.class);
    }

    /**
     * Returns the class name.
     * 
     * @return The class name as string.
     */
    private String getClassName() {
        className = compilationUnit.getElementName();
        return className;
    }

    /**
     * Parses the ICompilationUnit and returns the AST of it.
     * 
     * @param unit The ICompilationUnit that should be parsed
     * @return The AST of the ICompilationUnit
     */
    private static CompilationUnit parse(ICompilationUnit unit) {
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(unit);
        parser.setResolveBindings(true);
        return (CompilationUnit) parser.createAST(null); // parse
    }

    @Override
    /**
     * Adds all changes to the ICompilationUnit of the class.
     */
    public void update() throws ArtifactException {
        ICompilationUnit cu = compilationUnit;
        String source;
        try {
            source = cu.getSource();
            Document document = new Document(source);
            // computation of the text edits
            TextEdit edits = astRoot.rewrite(document, cu.getJavaProject().getOptions(true));
            
            // computation of the new source code
            edits.apply(document);
            String newSource = document.get();
            logger.debug("Applying changes to '" + className + "'...");
            // update of the compilation unit
            cu.getBuffer().setContents(newSource);
        } catch (JavaModelException e) {
            logger.exception(e);
        } catch (MalformedTreeException e) {
            logger.exception(e);
        } catch (BadLocationException e) {
            logger.exception(e);
        }
    }
}
