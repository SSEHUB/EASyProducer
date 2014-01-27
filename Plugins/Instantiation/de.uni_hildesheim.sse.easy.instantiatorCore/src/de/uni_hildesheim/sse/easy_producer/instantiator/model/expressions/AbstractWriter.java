package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * An abstract class for writing an object model as a textual output.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractWriter {

    private StringBuilder actualIndentation = new StringBuilder();
    private char whitespace = ' ';
    private String indentation = "    ";
    private PrintWriter out;

    /**
     * Creates a build language writer.
     * 
     * @param out the writer to write the elements to
     */
    public AbstractWriter(Writer out) {
        this.out = new PrintWriter(out);
    }
    
    /**
     * Returns the underlying writer.
     * 
     * @return the underlying writer
     */
    protected Writer getOut() {
        return out;
    }

    /**
     * Prints a string.
     * 
     * @param string the string to be printed
     */
    protected void print(String string) {
        out.print(string);
    }

    /**
     * Prints a string with trailing newline.
     * 
     * @param string the string to be printed
     */
    protected void println(String string) {
        out.println(string);
    }

    /**
     * Prints a character.
     * 
     * @param ch the character to be printed
     */
    protected void print(char ch) {
        out.print(ch);
    }

    /**
     * Prints a character with trailing newline.
     * 
     * @param ch the character to be printed
     */
    protected void println(char ch) {
        out.print(ch);
    }

    /**
     * Prints an integer.
     * 
     * @param value the integer
     */
    protected void print(int value) {
        out.print(value);
    }

    /**
     * Prints an integer with trailing newline.
     * 
     * @param value the integer
     */
    protected void println(int value) {
        out.println(value);
    }

    /**
     * Prints an object.
     * 
     * @param object the object to be printed
     */
    protected void print(Object object) {
        out.print(object);
    }

    /**
     * Prints an object with trailing newline.
     * 
     * @param object the object to be printed
     */
    protected void println(Object object) {
        out.println(object);
    }
    
    /**
     * Prints a newline.
     */
    protected void println() {
        out.println();
    }

    /**
     * Prints the indentation.
     */
    protected final void printIndentation() {
        out.print(actualIndentation);
    }

    /**
     * Prints a whitespace character.
     */
    protected final void printWhitespace() {
        out.print(whitespace);
    }
    
    /**
     * Flushes the writer. Should be used if there aren't any more elements to read.
     * 
     * @throws IOException If an I/O error occurs
     */
    public final void flush() throws IOException {
        out.flush();
    }

    /**
     * Defines an indentation step.
     * 
     * @param indentation the indentation step
     */
    public void setIndentation(String indentation) {
        assert null != indentation;
        this.indentation = indentation;
    }
    
    /**
     * Increases the current indentation step.
     */
    protected void increaseIndentation() {
        actualIndentation.append(indentation);
    }
    
    /**
     * Decreases the current indentation step.
     */
    protected void decreaseIndentation() {
        actualIndentation.delete(0, indentation.length());
    }

}
