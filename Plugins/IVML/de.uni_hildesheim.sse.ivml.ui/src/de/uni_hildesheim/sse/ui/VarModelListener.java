package de.uni_hildesheim.sse.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;
import de.uni_hildesheim.sse.utils.modelManagement.IModelReloadListener;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * A <code>de.uni_hildesheim.sse.model.varModel.Project</code> listener, which
 * receives notifications about changes of the variability model and then forces
 * an update of the <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance that
 * is used to edit the corresponding document in which the variability model is defined.
 * 
 * <b>Note</b> that receiving a change notification will also trigger updates of other running editors
 * via the <code>de.uni_hildesheim.sse.dslcore.ui.editors.ModelChangeNotifier</code>.  
 * 
 * @author kroeher
 *
 */
public class VarModelListener extends AbstractModelChangeListener implements IModelReloadListener<Project>, IModelListener<Project>{
	
	/**
	 * Constructs a variability model listener that updates a registered
	 * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the underlying
	 * <code>de.uni_hildesheim.sse.model.varModel.Project</code> instance, which is edited
	 * in the registered editor, changes.
	 */
	public VarModelListener() {
		isListening = false;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void notifyReplaced(Project oldModel, Project newModel) {
		//System.out.println("[VarModelListener] Notify replaced: " + this);
		updateRegisteredEditor();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyReloadFailed(Project model) {
		//System.out.println("[VarModelListener] Notify reload failed: " + this);
		updateRegisteredEditor();
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void unregister() {
		if (xtextEditor != null && underlyingModel != null) {
			if (underlyingModel instanceof Project) {
				Project varModel = (Project) underlyingModel;
				VarModel.INSTANCE.events().removeModelListener(varModel, this);
				VarModel.INSTANCE.events().removeModelReloadListener(varModel, this);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */	
	@Override
	protected boolean registerToUnderlyingModel(IModel underlyingModel) {
		boolean registerSuccessful = false;
		if (underlyingModel != null) {			
			Project varModel = (Project) underlyingModel;
			VarModel.INSTANCE.events().addModelListener(varModel, this);
			VarModel.INSTANCE.events().addReloadListener(varModel, this);
			registerSuccessful = true;
			//System.out.println("[VarModelListener] Registration successful: " + this);
		}
		return registerSuccessful;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
		IModel variabilityModel = null;
		ModelInfo<Project> projectModelInfo = VarModel.INSTANCE.availableModels().getInfo(modelFileUri);
		if (projectModelInfo != null && projectModelInfo.getResolved() != null) {
			variabilityModel = projectModelInfo.getResolved();
			//System.out.println("[VarModelListener] VarModel found: " + variabilityModel);
		} else {
			//System.out.println("[VarModelListener] Model not resolved!");
			if (xtextDocument != null && forceBuild) {
				//System.out.println("[VarModelListener] Build variability model!");
				buildModel(xtextDocument);
				// Do not force the build a second time!
				variabilityModel = getUnderlyingModel(modelFileUri, false);
			} /*else {
				System.out.println("[VarModelListener] IVML document is null or no build forced!");
			}*/
		}
		return variabilityModel;
	}
	
	/**
	 * Parses the <code>de.uni_hildesheim.sse.ivml.VariabilityUnit</code> which is defined in
	 * the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
	 * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance.
	 * 
	 * <b>Important:</b> Use this method if and only if the desired
	 * <code>de.uni_hildesheim.sse.model.varModel.Project</code> instance is not available
	 * via <code>VarModel.INSTANCE.availableModels()</code>.
	 * 
	 * <b>Note:</b> The code of this method is copied from <code>de.uni_hildesheim.sse.ui.XtextEditor.onSave()</code>.
	 * 
	 * @param doc the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
	 * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance
	 */
	private void buildModel(IXtextDocument doc) {
		if (doc != null) {
			doc.readOnly(new IUnitOfWork<VariabilityUnit, XtextResource>() {
				public VariabilityUnit exec(XtextResource resource) {
					VariabilityUnit root = (VariabilityUnit) resource.getContents().get(0);
					EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
					try {
						BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic(root);
						java.net.URI uri = null;
						if (null != resource.getURI()) {
							try {
								uri = ModelUtility.toNetUri(resource.getURI());
							} catch (URISyntaxException e) {
								logger.error("error translating '" + resource.getURI() + "' while saving:" 
										+ e.getMessage());
							}
						}
						TranslationResult<Project> result = ModelUtility.INSTANCE.createVarModel(root, uri, true);
						if (0 == result.getMessageCount()) {
							ByteArrayOutputStream out = new ByteArrayOutputStream();
							PrintWriter pOut = new PrintWriter(out);
							ModelUtility.INSTANCE.print(result, pOut, true, false);
							logger.info(out.toString());
						} else {
							ValidationUtils.processMessages(result, diagnostic);
						}
					} catch (Exception e) {
						logger.error("while saving IVML:" + e.getMessage());
					}
					return root;
				}
			});			
		}
	}
}
