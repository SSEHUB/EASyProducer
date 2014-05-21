package de.uni_hildesheim.sse.dslCore.test;

/**
 * A helper class for string comparisons.
 * 
 * @author Holger Eichelberger
 */
class StringWithPosition {
    private char[] string;
    private int pos;

    /**
     * Creates a new instance.
     * 
     * @param string the string to be stored
     */
    public StringWithPosition(String string) {
        this.string = string.toCharArray();
        this.pos = 0;
    }
    
    /**
     * Returns the actual position.
     * 
     * @return the actual position
     */
    public int pos() {
        return pos;
    }
    
    /**
     * Returns the character at the actual position.
     * 
     * @return the character at the actual position
     * @throws IndexOutOfBoundsException in case that the position is invalid
     */
    public char at() {
        return string[pos];
    }
    
    /**
     * Returns whether the actual position is in range.
     * 
     * @return <code>true</code> if the actual position is in range, <code>false</code> else
     */
    public boolean inRange() {
        return pos < string.length;
    }
    
    /**
     * Increments the actual position by 1.
     */
    public void inc() {
        pos++;
    }

    /**
     * Increments the actual position by <code>inc</code>.
     * 
     * @param inc the increment
     */
    public void inc(int inc) {
        pos += inc;
    }

    /**
     * Returns whether the actual position including the increment <code>inc</code> is in range.
     * 
     * @param inc the increment
     * @return <code>true</code> if the specified position is in range, <code>false</code> else
     */
    public boolean inRange(int inc) {
        return pos + inc >= 0 && pos + inc < string.length;
    }

    /**
     * Returns the character at the actual position including the increment <code>inc</code>.
     * 
     * @param inc the increment
     * @return the character at the actual position
     * @throws IndexOutOfBoundsException in case that the specified position is invalid
     */
    public char at(int inc) {
        return string[pos + inc];
    }
    
    /**
     * Consumes the line end starting at the current position.
     */
    public void consumeLineEnd() {
        while (pos < string.length && isLineEnd()) {
            pos++;
        }
    }

    /**
     * Consumes the line until the line end starting at the current position.
     */
    public void consumeLineUntilEnd() {
        while (pos < string.length && !isLineEnd()) {
            pos++;
        }
    }

    /**
     * Consumes the line including the line end starting at the current position.
     */
    public void consumeLine() {
        consumeLineUntilEnd();
        consumeLineEnd();
    }

    
    /**
     * Returns whether the actual character is a line end character.
     * 
     * @return <code>true</code> if it is a line end character, <code>false</code> else
     */
    private boolean isLineEnd() {
        return string[pos] == '\n' || string[pos] == '\r';
    }

}
