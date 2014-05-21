package de.java.instantiator.prototype;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.PackageFragment;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import de.java.instantiator.prototype.model.artifactModel.java.Attribute;
import de.java.instantiator.prototype.model.artifactModel.java.Class;
import de.java.instantiator.prototype.model.artifactModel.java.DefaultJavaFileArtifactCreator;
import de.java.instantiator.prototype.model.artifactModel.java.JavaFileArtifact;
import de.java.instantiator.prototype.model.artifactModel.java.Method;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * EditorPage for changing attributes modifier.
 * 
 * @author Sass
 * 
 */
public class EditorPage extends AbstractEASyEditorPage implements SelectionListener {

    private static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(EditorPage.class, Bundle.ID);

    /**
     * Default Constructor.
     * 
     * @param plp
     *            The ProductLineProject
     * @param parent
     *            The Composite
     */
    public EditorPage(ProductLineProject plp, Composite parent) {
        super(plp, "Instantiator", parent);
        Button constantButton = new Button(getContentPane(), SWT.NONE);
        constantButton.setText("Make attributes constant");
        constantButton.addSelectionListener(this);
        Button variableButton = new Button(getContentPane(), SWT.NONE);
        variableButton.setText("Make attributes variable");
        variableButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                IProject project = root.getProject("PL_Test");
                IJavaProject javaProject = JavaCore.create(project);
                IType lwType;
                try {
                    lwType = javaProject.findType("Main");
                    ICompilationUnit lwCompilationUnit = lwType.getCompilationUnit();
                    Class clazz = new Class(lwCompilationUnit);
                    Set<Attribute> set = clazz.attributes();
                    for (Attribute attribute : set) {
                        attribute.makeVariable();
                    }
                    clazz.update();
                } catch (JavaModelException e1) {
                    logger.exception(e1);
                } catch (ArtifactException e1) {
                    logger.exception(e1);
                }
            }
        });
        Button methodButton = new Button(getContentPane(), SWT.NONE);
        methodButton.setText("Get Methods");
        methodButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                IProject[] project = root.getProjects();
                for (IProject iProject : project) {
                    IJavaProject javaProject = JavaCore.create(iProject);
                    try {
                        IPackageFragment[] packages = javaProject.getPackageFragments();
                        for (IPackageFragment iPackageFragment : packages) {
                            /* 
                             * We will only look at the package from the source folder 
                             * K_BINARY would include also included JARS, e.g. rt.jar 
                             */
                            if (iPackageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
                                ICompilationUnit[] units = iPackageFragment.getCompilationUnits();
                                for (ICompilationUnit iCompilationUnit : units) {
                                    File file = iCompilationUnit.getPath().toFile();
                                    DefaultJavaFileArtifactCreator creator = new DefaultJavaFileArtifactCreator();
                                    JavaFileArtifact javaFileArtefact;
                                    try {
                                        javaFileArtefact = (JavaFileArtifact) creator.createArtifactInstance(file, null);
                                        Set<Class> classes = javaFileArtefact.classes();
                                        for (Class class1 : classes) {
                                            Set<Method> set = class1.methods();
                                            for (Method method : set) {
                                                System.out.println(method.getName());
                                            }
                                        }
                                    } catch (ArtifactException e) {
                                        logger.exception(e);
                                    }
                                }
                            }
                        }
                    } catch (JavaModelException e) {
                        logger.exception(e);
                    }
                }
                
//                IJavaProject javaProject = JavaCore.create(project);
//                IType lwType;
//                try {
//                    lwType = javaProject.findType("Main");
//                    System.out.println(lwType.getPath());
//                    ICompilationUnit lwCompilationUnit = lwType.getCompilationUnit();
//                    Class clazz = new Class(lwCompilationUnit);
//                    Set<Method> set = clazz.methods();
//                    for (Method method : set) {
//                        method.rename("test");
//                    }
//                    clazz.update();
//                } catch (JavaModelException e1) {
//                    logger.exception(e1);
//                } catch (ArtifactException e) {
//                    logger.exception(e);
//                }
            }
        });
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getPageText() {
        // TODO Auto-generated method stub
        return "Change modifier";
    }

    @Override
    protected void pageActivated() {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public void widgetSelected(SelectionEvent event) {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject("PL_Test");
        IJavaProject javaProject = JavaCore.create(project);
        IType lwType;
        try {
            lwType = javaProject.findType("Main");
            ICompilationUnit lwCompilationUnit = lwType.getCompilationUnit();
            Class clazz = new Class(lwCompilationUnit);
            Set<Attribute> set = clazz.attributes();
            for (Attribute attribute : set) {
                attribute.makeConstant();
                if (attribute.getName().equals("delete")) {
                    attribute.setValue(9);
//                    attribute.rename("delete");
//                    attribute.delete();
                }
            }
            clazz.update();
        } catch (JavaModelException e1) {
            logger.exception(e1);
        } catch (ArtifactException e1) {
            logger.exception(e1);
        }
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent event) {
        // TODO Auto-generated method stub
    }

}
