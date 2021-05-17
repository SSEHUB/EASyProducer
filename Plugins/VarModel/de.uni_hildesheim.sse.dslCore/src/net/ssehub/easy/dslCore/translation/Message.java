package net.ssehub.easy.dslCore.translation;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.LineAndColumn;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import net.ssehub.easy.basics.messages.Status;

/**
 * Implements a message issues by the model translator (in order to provide
 * feedback on multiple issues at once).
 * 
 * @author Holger Eichelberger
 */
public class Message extends net.ssehub.easy.basics.messages.Message {
    // this inner class is just here due to OSGi exports - should be in
    // translation

    /**
     * Defines the code used for messages which can be ignored.
     */
    public static final int CODE_IGNORE = 0;
    
    /**
     * Stores the ECore element causing the error.
     */
    private EObject cause;

    /**
     * Stores the (sub-)feature of {@link #cause}.
     */
    private EStructuralFeature causingFeature;

    /**
     * A code representing the message.
     * 
     * @see #CODE_IGNORE
     */
    private int code;

    /**
     * Creates a message object.
     * 
     * @param message
     *            the message text
     * @param status
     *            the message status
     * @param cause
     *            the ECore element causing the message
     * @param causingFeature
     *            the feature within <code>cause</code>
     * @param code
     *            a numerical code representing the message (see {@link #CODE_IGNORE})
     */
    public Message(String message, Status status, EObject cause,
            EStructuralFeature causingFeature, int code) {
        super(message, status);
        this.cause = cause;
        this.code = code;
        this.causingFeature = causingFeature;
    }

    /**
     * Returns the cause of the message (in terms of the causing ECore element).
     * 
     * @return the cause of the message
     */
    public EObject getCause() {
        return cause;
    }

    /**
     * Returns the causing feature (within {@link #getCause()}).
     * 
     * @return the causing feature
     */
    public EStructuralFeature getCausingFeature() {
        return causingFeature;
    }

    /**
     * Returns a code for the message.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Returns whether this message can be ignored.
     * 
     * @return <code>true</code> if it can be ignored, <code>false</code> else
     */
    public boolean ignore() {
        return 0 == code;
    }
    
    @Override
    public String getDetailedDescription() {
        String result = super.getDetailedDescription();
        IssueLocation iLoc = getLocationData(cause, causingFeature, 0);
        if (null != iLoc) {
            result += iLoc;
        }
        return result;
    }
    
    // code adapted from org.eclipse.xtext.diagnostics.AbstractDiagnostic.getLine() and 
    // org.eclipse.xtext.validation.DiagnosticConverterImpl.getLocationData(Diagnostic)
    // as functions are not accessible
    
    /**
     * Represents an issue location.
     * 
     * @author adapted from xText as calculation is not accessible
     */
    protected static class IssueLocation {
        
        /**
         * 1-based line number.
         */
        protected int lineNumber;

        /**
         * 1-based column.
         */
        protected int column;

        /**
         * 1-based line number end.
         */
        protected int lineNumberEnd;

        /**
         * 1-based column end.
         */
        protected int columnEnd;

        /**
         * 0-based offset.
         */
        protected int offset;
        protected int length;
        
        private String location;
        private String details;

        /**
         * Creates an issue location.
         */
        protected IssueLocation() {
        }

        @Override
        public String toString() {
            String result = "";
            if (lineNumber >= 0) {
                result += " in line " + lineNumber + ":" + column + " - " + lineNumberEnd + ":" + columnEnd;
            }
            if (null != location) {
                if (result.length() > 0) {
                    result += " ";
                } else {
                    result = " ";
                }
                result += "in " + location;
            }
            if (null != details) {
                if (result.length() > 0) {
                    result += " ";
                } else {
                    result = " ";
                }
                result += details;
            }
            return result;
        }
    }

    /**
     * Returns the issue location for the given {@code node}.
     * 
     * @param node the node to return the location for
     * @return the issue location
     */
    protected IssueLocation getLocationForNode(INode node) {
        ITextRegionWithLineInformation nodeRegion = node.getTextRegionWithLineInformation();
        int offset = nodeRegion.getOffset();
        int length = nodeRegion.getLength();
        return getLocationForNode(node, offset, length);
    }

    /**
     * Computes the {@link IssueLocation} for the given offset and length in the given node.
     * 
     * @param node the node 
     * @param offset the text offset of the node
     * @param length the text length of the node
     * @return the issue location
     */
    protected IssueLocation getLocationForNode(INode node, int offset, int length) {
        IssueLocation result = new IssueLocation();
        result.offset = offset;
        result.length = length;
        
        LineAndColumn lineAndColumnStart = NodeModelUtils.getLineAndColumn(node, offset);
        result.lineNumber = lineAndColumnStart.getLine();
        result.column = lineAndColumnStart.getColumn();
        
        LineAndColumn lineAndColumnEnd = NodeModelUtils.getLineAndColumn(node, offset + length);
        result.lineNumberEnd = lineAndColumnEnd.getLine();
        result.columnEnd = lineAndColumnEnd.getColumn();
        
        EObject eObject = node.getSemanticElement();
        if (null != eObject && null != eObject.eResource()) {
            URI uri = EcoreUtil.getURI(eObject);
            if (null != uri) {
                result.location = uri.toString(); 
            }
        }
        return result;
    }

    /**
     * Returns the location for a given cause {@code obj}, {@code structuralFeatue} and index of the node 
     * within {@code obj}.
     * 
     * @param obj the object to look into
     * @param structuralFeature the structural feature within {@code obj}
     * @param index the node index within {@code obj}, usually {@code 0}
     * @return the location, may be the beginning of a document if the parse nodes cannot be found (may be <b>null</b>)
     */
    protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
        IssueLocation result = null;
        INode parserNode = NodeModelUtils.getNode(obj);
        if (parserNode != null) {
            if (structuralFeature != null) {
                List<INode> nodes = NodeModelUtils.findNodesForFeature(obj, structuralFeature);
                if (index < 0) { // insignificant index
                    index = 0;
                }
                if (nodes.size() > index) {
                    parserNode = nodes.get(index);
                }
            }
            result = getLocationForNode(parserNode);
        } else if (obj.eContainer() != null) {
            EObject container = obj.eContainer();
            EStructuralFeature containingFeature = obj.eContainingFeature();
            result = getLocationData(container, containingFeature,
                containingFeature.isMany() ? ((EList<?>) container.eGet(containingFeature)).indexOf(obj)
                    : ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
        } else {
            if (obj.eContents().size() > 0) {
                EObject cont = obj.eContents().get(0);
                result = new IssueLocation();
                result.lineNumber = -1;
                
                result.location = fieldToString(cont, "eStorage");
                result.details = fieldToString(cont, "name");
            }
        }
        return result;
    }

    /**
     * Tries to obtain the value of the field {@code field} from {@code obj} as a String.
     * 
     * @param obj the object to query
     * @param field the name of the field to query
     * @return the value of the field as String, may be <b>null</b> if {@code field} does not exist.
     * @see #fieldToString(Object, Class, String)
     */
    private static String fieldToString(Object obj, String field) {
        return fieldToString(obj, obj.getClass(), field);
    }

    /**
     * Tries to obtain the value of the field {@code field} from {@code obj} as a String.
     * 
     * @param obj the object to query
     * @param cls the class of {@code obj} to use (immediate or parent)
     * @param field the name of the field to query
     * @return the value of the field as String, may be <b>null</b> if {@code field} does not exist.
     */
    private static String fieldToString(Object obj, Class<?> cls, String field) {
        String result = null;
        try {
            Field f = cls.getDeclaredField(field);
            f.setAccessible(true);
            Object val = f.get(obj);
            if (null != val) {
                result = val.toString();
            }
        } catch (NoSuchFieldException e) {
            if (cls.getSuperclass() != null) {
                result = fieldToString(obj, cls.getSuperclass(), field);
            }
            // just ignore
        } catch (IllegalAccessException e) {
            // just ignore                        
        }
        return result;
    }

}
