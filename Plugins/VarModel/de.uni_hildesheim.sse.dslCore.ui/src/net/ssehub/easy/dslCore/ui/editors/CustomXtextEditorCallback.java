package net.ssehub.easy.dslCore.ui.editors;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Injector;

/**
 * Implements a custom CompoundXtextEditorCallback which can be registered to a
 * XtextEditor in oder to react on key events.
 * 
 * In particular, this class is designed to enable the "Jump-to-definition" feature
 * if the key F3 is pressed. However, other custom key bindings can be defined here
 * as wells.
 * 
 * @author kroeher
 *
 */
public class CustomXtextEditorCallback extends CompoundXtextEditorCallback {

    private CommonXtextEditor xtextEditor;
    private IXtextDocument editorDocument;

    /**
     * The constructor of a custom CompoundXtextEditorCallback.
     * 
     * @param injector the Injector-instance of the language the editor
     * support, e.g. from the IvmlActivator-instance 
     */
    public CustomXtextEditorCallback(Injector injector) {
        super(injector);
    }

    @Override
    public void afterCreatePartControl(XtextEditor editor) {
        super.afterCreatePartControl(editor);
        addKeyListener(editor);
        xtextEditor = (CommonXtextEditor) editor;
        editorDocument = editor.getDocument();
    }

    /**
     * Sets up this CompoundXtextEditorCallback by creating a new KeyListener
     * which will be add to the text widget of the given XtextEditor.
     * 
     * @param editor the XtextEditor to which the KeyListener should be added
     */
    private void addKeyListener(XtextEditor editor) {
        StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyReleased(KeyEvent event) {
                // keyCode of F3-key
                if (event.keyCode == 16777228) {
                    gotoElementDefinition();
                }
            }

            @Override
            public void keyPressed(KeyEvent event) {}
        };
        textWidget.addKeyListener(keyListener);
    }

    /**
     * This method is called if F3-key is released.
     * It identifies the selected language element, tries to find the corresponding
     * definition of this element and, if found, sets the focus of the cursor to
     * that definition.
     */
    private void gotoElementDefinition() {
        String selectedElement = getSelectedElementByOffset();
        //System.out.println("Selected Element: " + selectedElement);
        
//        if (!xtextEditor.setCursorToDefinition(selectedElement)) {
//            /*
//             * Achtung: Wenn die Selection nicht leer ist (also ein Teil-String markiert ist),
//             * muss das noch nicht zwinged ein richtiger Identifier sein.
//             * 
//             * D.h., wenn getSelectedElementBySelection einen String zurück gibt, mit diesem
//             * String aber keine Definition gefunden werden konnte, muss zwingend noch mal mit
//             * getSelectedElementByOffset gesucht werden, um auszuschließen, dass die Markierung
//             * des Benutzers (die Selection) nur einfach unvollständig war.
//             * 
//             * Beispiel: Integer myInt; <-- markiert wird aber nur "yInt", dann ist auch die
//             * Selection nur "yInt", was zu keinem Sprung der Definition führt
//             */
//            selectedElement = getSelectedElementByOffset();
//            //System.out.println("Selected Element (second try): " + selectedElement);
//            xtextEditor.setCursorToDefinition(selectedElement);
//        }
    }
    
    /**
     * Sets the focus of the cursor in the given editor to the definition of the selected
     * element in the given document.
     * 
     * @param selectedElement the selected element for which the definition has to be found in
     * order to set the focus of the cursor to that definition
     * @param xtextDocument the document in which the definition has to be found
     * @param documentEditor the editor in which the focus of the editor has to be set
     * @return <code>true</code> if setting the focus of the editor was successful.
     * <code>False</code> otherwise.
     */
    private boolean setCursorToDefinition(String selectedElement, IXtextDocument xtextDocument,
            XtextEditor documentEditor) {
        boolean setCursorSuccessfully = false;
        if (selectedElement != null && !selectedElement.isEmpty() && xtextDocument != null) {
            int indexOfElementDefinition = xtextDocument.get().indexOf(selectedElement);
            if (indexOfElementDefinition >= 0) {
                documentEditor.setHighlightRange(indexOfElementDefinition, 1, true);
                setCursorSuccessfully = true;
            }
        }
        return setCursorSuccessfully;
    }
    
    /**
     * Returns the name of the selected element in the editor as String by calling
     * getSelectedElementBySelection.
     * 
     * If no element is selected, the name of the element around the current position of
     * the cursor will be returned by calling getSelectedElementByOffset.
     * 
     * @return the name of the selected element in the editor or the element around the
     * current position of the cursor. May be <code>null</code>.
     */
    private String getSelectedElement() {
        /*
         * TODO Discard getSelectedElementbySelection because in case that a selection
         * is not complete (e.g. if the user marks only a part of the desired text),
         * this could lead to jumps to a wrong definition if this definition matches
         * the partial selection. This is not how it is expected.
         */
        String selectedElement = getSelectedElementBySelection();
        if (selectedElement == null || selectedElement.isEmpty()) {
            selectedElement = getSelectedElementByOffset();
        }
        return selectedElement;
    }
    
    /**
     * Returns the name of the selected element in the editor as String.
     * 
     * 
     * @return the name of the selected element in the editor. May be <code>null</code>.
     */
    private String getSelectedElementBySelection() {
        String selectedElement = null;
        if (selectionAvailable()) {
            ITextSelection textSelection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
            String selectedText = textSelection.getText();
            if (selectedText != null && !selectedText.isEmpty()) {
                selectedElement = selectedText;
            }
        }
        return selectedElement;
    }
    
    /**
     * Returns the name of the element around the current position of the cursor in the
     * document (defined by the offset of the current text-selection) of the XtextEditor.
     * 
     * @return the name of the element around the current position of the cursor or <code>null</code>
     * if no element could be found.
     */
    private String getSelectedElementByOffset() {
        String selectedElement = null;
        if (selectionAvailable() && editorDocument != null) {
            ITextSelection textSelection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
            // In case that no text is selected, find the text around the current cursor position
            int selectionTextOffset = textSelection.getOffset();

            // The document of the editor in which the desired element is located
            String editorDocumentContent = editorDocument.get();

            // Find start position of the language element at the current cursor position
            int startPos = selectionTextOffset;
            boolean delimiterFound = false;
            while (startPos >= 0 && !delimiterFound) {
                if (isValidElementCharacter(editorDocumentContent.charAt(startPos))) {
                    startPos--;
                } else {
                    delimiterFound = true;
                }
            }
            
            // Find end position of the language element at the current cursor position
            int endPos = selectionTextOffset;
            delimiterFound = false;
            while (endPos < editorDocumentContent.length() && !delimiterFound) {
                if (isValidElementCharacter(editorDocumentContent.charAt(endPos))) {
                    endPos++;
                } else {
                    delimiterFound = true;
                }
            }
            selectedElement = editorDocumentContent.substring(startPos + 1, endPos);
        }
        return selectedElement;
    }
    
    /**
     * Checks whether a given character is a valid character in the sense of its usage as part of
     * a name of an IVML/VIL/VTL element.
     * 
     * @param elementNameChar the character that has the be checked for validity
     * @return <code>true</code> if the character is alphabetic, a digit, or an underscore.
     * <code>False</code> otherwise.
     */
    private boolean isValidElementCharacter(char elementNameChar) {
        boolean isValid = false;
        if (Character.isAlphabetic(elementNameChar)
                || Character.isDigit(elementNameChar)
                || elementNameChar == '_') {
            isValid = true;
        }
        return isValid;
    }
    
    /**
     * Checks whether an ISelection-instance is available.
     * 
     * However, the availability of such an instance does not mean that a specific
     * part of the text in the editor is selected. It just ensures that an instance
     * for checking such a selection is available and, thus, should prevent from
     * producing NPEs.  
     * 
     * @return <code>true</code> if an ISelection-instance is available. <code>False</code> otherwise.
     */
    private boolean selectionAvailable() {
        return xtextEditor != null
                && xtextEditor.getSelectionProvider() != null
                && xtextEditor.getSelectionProvider().getSelection() != null;
    }

}