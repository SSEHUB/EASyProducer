package net.ssehub.easy.producer.ui.productline_editor.configuration;

/**
 * This enumeration should classify the different columns.
 * @author El-Sharkawy
 *
 */
enum ColumnType {
    /**
     * Column for adding (empty) elements to a container.
     */
    EXTEND,
    /**
     * Column for showing the name of the current variable.
     */
    NAME,
    /**
     * Column for showing the value of the current variable.
     */
    VALUE,
    
    /**
     * Column for showing the comment of the current variable.
     */
    COMMENT,
    
    /**
     * Column capable of freezing the current variable.
     */
    FREEZE,
    
    /**
     * Column for removing elements of a container.
     */
    REMOVE,
    
    /**
     * Column for displaying error messages.
     */
    ERROR,
    
    /**
     * Further cells, not handled by this super class.
     */
    ELSE;
}
