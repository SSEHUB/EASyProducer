/*
 * FIXME SE: This leads jenkins to crash and does not work probably.
 * Therefore I deleted this part.
 * Currently unused. Indented to open the IVML editor in the EASy pages. Does not work.
 */
//package de.uni_hildesheim.sse.ivml.filetype;
//
//import org.eclipse.swt.widgets.Composite;
//import org.osgi.service.component.ComponentContext;
//
//import de.uni_hildesheim.sse.easy.ui.core.contributions.ExternalEditor;
//
///**
// * Links the xText UI editor to EASy.
// * 
// * @author Holger Eichelberger
// */
//public class EditorPlugin extends ExternalEditor {
//
//    /**
//     * Creates an instance (public constructor required by OSGI-DS.
//     */
//    public EditorPlugin() {
//    }
//
//    /**
//     * Private method to activate plugin.
//     * @param context Context.
//     */
//    protected void activate(ComponentContext context) {
//        // this is not the official way of using DS but the official way is instable
//        register(this);
//    }
//    
//    /**
//     * Private method to to de-activate plugin.
//     * @param context Context.
//     */
//    protected void deactivate(ComponentContext context) {
//        unregister(this);
//    }
//
//    @Override
//    protected boolean embedEditorImpl(java.net.URI uri, Composite parent) {
//        boolean done = false;
//        if (providesEditorForImpl(uri)) {
//            de.uni_hildesheim.sse.ui.embed.EditorUtils.embedIvmlEditor(uri, parent);
//            done = true;
//        }
//        return done;
//    }
//    
//    @Override
//    protected boolean providesEditorForImpl(java.net.URI uri) {
//        return false; // disabled for now
//        //return null != uri && uri.toString().endsWith(".ivml");
//    }
//
//}
