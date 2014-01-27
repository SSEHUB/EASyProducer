package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactChangedListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * The textual representation of an artifact (if there is any). Please note that
 * this class is not an artifact by itself rather then a specific representation 
 * of an artifact.
 * 
 * @author Holger Eichelberger
 */
public class Text extends AbstractArtifactRepresentation implements IArtifactChangedListener, IStringValueProvider {

    public static final Text CONSTANT_EMPTY = new Text(false);
    
    private String text;
    private File file;

    /**
     * Creates a new empty textual representation.
     * 
     * @param modifiable whether this representation shall be modifiable
     */
    public Text(boolean modifiable) {
        super(modifiable);
        text = "";
    }

    /**
     * Creates a new textual representation from <code>file</code>.
     * 
     * @param file the file to be considered as input
     * @param modifiable whether this representation shall be modifiable
     * 
     * @throws ArtifactException in case that reading fails for some reason
     */
    public Text(File file, boolean modifiable) throws ArtifactException {
        super(modifiable);
        this.file = file;
        updateContents();
    }

    /**
     * Creates a new textual representation from <code>text</code>.
     * 
     * @param text the text to be considered as input
     * @param modifiable whether this representation shall be modifiable
     * 
     * @throws ArtifactException in case that reading fails for some reason
     */
    public Text(String text, boolean modifiable) throws ArtifactException {
        super(modifiable);
        this.text = text;
    }

    @Override
    public void updateContents() throws ArtifactException {
        if (null != file && file.exists()) {           
            try {
                text = FileUtils.readFileToString(file);
            } catch (IOException e) {
                throw new ArtifactException(e, ArtifactException.ID_IO);
            }
        } else {
            text = "";
        }
    }
    
    @Override
    public boolean isEmpty() {
        return text.isEmpty();
    }
    
    /**
     * Substitutes all parts matching the regular expression <code>regex</code> by 
     * <code>replacement</code>.
     * 
     * @param regex the regular expression to search for
     * @param replacement the replacement
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text substitute(String regex, String replacement) throws ArtifactException {
        if (isModifiable()) {
            text = text.replaceAll(regex, replacement);
            triggerArtifactChanged();
        }
        return this;
    }
    
    /**
     * Returns whether this textual representation matches the given <code>regex</code>.
     * 
     * @param regex the regular expression to be matched
     * @return <code>true</code> if <code>regex</code> matches this textual representation, 
     *   <code>false</code> else
     * @throws ArtifactException if the pattern is invalid
     */
    public boolean matches(String regex) throws ArtifactException {
        try {
            Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
            return pattern.matcher(text).matches();
        } catch (PatternSyntaxException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_INVALID_PATTERN);
        }
    }

    /**
     * Replaces all occurrences of <code>search</code> by <code>replacement</code>.
     * 
     * @param search the string to search for
     * @param replacement the replacement string
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text replace(String search, String replacement) throws ArtifactException {
        if (isModifiable()) {
            text = text.replace(search, replacement);
            triggerArtifactChanged();
        }
        return this;
    }

    /**
     * Appends the given text.
     * 
     * @param text the text to be appended
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text append(String text) throws ArtifactException {
        if (isModifiable()) {
            this.text = this.text + text;
            triggerArtifactChanged();
        }
        return this;
    }

    /**
     * Prepends the given text.
     * 
     * @param text the text to be prepended
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text prepend(String text) throws ArtifactException {
        if (isModifiable()) {
            this.text = text + this.text;
            triggerArtifactChanged();
        }
        return this;
    }

    /**
     * Appends the textual representation of another artifact.
     * 
     * @param text the text to be appended
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text append(Text text) throws ArtifactException {
        if (isModifiable()) {
            this.text = this.text + text.text;
            triggerArtifactChanged();
        }
        return this;
    }

    /**
     * Prepends the textual representation of another artifact.
     * 
     * @param text the text to be prepended
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text prepend(Text text) throws ArtifactException {
        if (isModifiable()) {
            this.text = text.text + this.text;
            triggerArtifactChanged();
        }
        return this;
    }

    /**
     * Inserts the textual representation of another artifact at
     * the given <code>index</code>.
     * 
     * @param index the index in <b>this</b>
     * @param insertion the text to be inserted
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text insert(int index, Text insertion) throws ArtifactException {
        return insert(index, insertion.text);
    }
    
    /**
     * Inserts the given <code>string</code> at the given <code>index</code>.
     * 
     * @param index the index in <b>this</b>
     * @param insertion the string to be inserted
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException in case that listener updates fail
     */
    public Text insert(int index, String insertion) throws ArtifactException {
        if (isModifiable() && index <= this.text.length()) {
            String before = this.text.substring(0, index);
            String after = this.text.substring(index, this.text.length());
            this.text = before + insertion + after;
            triggerArtifactChanged();
        }
        return this;
    }
    
    /**
     * Returns the index of the first occurrence of the
     * given textual representation of another artifact.
     * 
     * @param search the textual representation of another artifact
     * @return the index of <code>search</code> in <b>this</b>, or <b>-1</b> if the
     * text does not occur
     */
    public int indexOf(Text search) {
        return indexOf(search.text);
    }
    
    /**
     * Returns the index of the first occurrence of the
     * given <code>string</code>.
     * 
     * @param search the string to be searched for
     * @return the index of <code>search</code> in <b>this</b>, or <b>-1</b> if the
     * string does not occur
     */
    public int indexOf(String search) {
        int index = this.text.indexOf(search);
        //Check whether search is a regular expression.
        if (index == -1) {
            index = indexOfRegex(search);
        }
        return index;
    }
    
    /**
     * Returns the index of the first match of the
     * given regular expression.
     * 
     * @param regex the regular expression to search for 
     * @return the index of <code>regex</code> in <b>this</b>, or <b>-1</b> if no
     * match was found
     */
    private int indexOfRegex(String regex) {
        int index = -1;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            // If this exception is thrown, then input is not a (valid) regular expression
            pattern = null;
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text);
            if (matcher != null && matcher.find()) {
                index = matcher.start();
            }
        }
        return index;
    }
    
    /**
     * Returns the index of the first occurrence of the
     * given textual representation of another artifact,
     * starting the search at the specified index.
     * 
     * @param search the textual representation of another artifact
     * @param fromIndex the index to start the search from 
     * @return the index of <code>search</code> in <b>this</b>, or <b>-1</b> if the
     * text does not occur
     */
    public int indexOf(Text search, int fromIndex) {
        return indexOf(search.text, fromIndex);
    }
    
    /**
     * Returns the index of the first occurrence of the
     * given string, starting the search at the specified index.
     * 
     * @param search the string to be searched for
     * @param fromIndex the index to start the search from
     * @return the index of <code>search</code> in <b>this</b>, or <b>-1</b> if the
     * string does not occur
     */
    public int indexOf(String search, int fromIndex) {
        int index = this.text.indexOf(search, fromIndex);
        //Check whether search is a regular expression.
        if (index == -1) {
            index = indexOfRegex(search, fromIndex);
        }
        return index;
    }
    
    /**
     * Returns the index of the first match of the
     * given regular expression, starting the search at the specified index.
     * 
     * @param regex the regular expression to search for 
     * @param fromIndex the index to start the search from
     * @return the index of <code>regex</code> in <b>this</b>, or <b>-1</b> if no
     * match was found
     */
    private int indexOfRegex(String regex, int fromIndex) {
        int index = -1;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            // If this exception is thrown, then input is not a (valid) regular expression
            pattern = null;
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text);
            if (matcher != null && matcher.find(fromIndex)) {
                index = matcher.start();
            }
        }
        return index;
    }
    
    /**
     * Removes the the first occurrence of the given textual
     * representation of another artifact in <b>this</b>.
     * 
     * @param part the textual representation of another artifact to be removed
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException ArtifactException in case that listener updates fail
     */
    public Text remove(Text part) throws ArtifactException {
        return remove(part.text);
    }
    
    /**
     * Removes the the first occurrence of the given string in <b>this</b>.
     * 
     * @param part the string to be removed
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException ArtifactException in case that listener updates fail
     */
    public Text remove(String part) throws ArtifactException {
        if (isModifiable()) {
            if (this.text.contains(part)) {
                String before = this.text.substring(0, this.indexOf(part));
                String after = this.text.substring(this.indexOf(part) + part.length(), this.text.length());
                this.text = before + after;
            } else {
                // Check whether part is a regular expression.
                removeRegex(part);
            }
            triggerArtifactChanged();
        }
        return this;
    }
    
    /**
     * Removes the first string in <b>this</b> that matches the given
     * regular expression.
     * 
     * @param regex the regular expression with which a match shall be found
     */
    private void removeRegex(String regex) {
        int regexMatchLength = getRegexMatchLength(regex);
        if (regexMatchLength > 0) {
            String before = this.text.substring(0, this.indexOf(regex));
            String after = this.text.substring(this.indexOf(regex) + regexMatchLength, this.text.length());
            this.text = before + after;
        }
    }
    
    /**
     * Calculates the length of the first string in the text
     * that matches the given regular expression.
     * 
     * @param regex the regular expression with which a match shall be found
     * @return the length of the match in the text, or <b>-1</b> if no match
     * was found.
     */
    private int getRegexMatchLength(String regex) {
        int regexMatchLength = -1;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            // If this exception is thrown, then input is not a (valid) regular expression
            pattern = null;
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text);
            if (matcher != null && matcher.find()) {
                regexMatchLength = matcher.end() - matcher.start();
            }
        }
        return regexMatchLength;
    }
    
    /**
     * Removes all occurrences of the given textual
     * representation of another artifact in <b>this</b>.
     * 
     * @param part the textual representation of another artifact to be removed
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException ArtifactException in case that listener updates fail
     */
    public Text removeAll(Text part) throws ArtifactException {
        return removeAll(part.text);
    }
    
    /**
     * Removes all occurrences of the given string in <b>this</b>.
     * 
     * @param part the string to be removed
     * @return <b>this</b> (for concatenated operations)
     * @throws ArtifactException ArtifactException in case that listener updates fail
     */
    public Text removeAll(String part) throws ArtifactException {
        Text result = this;
        if (isModifiable()) {
            while (this.text.contains(part) || containsRegex(part)) {
                result = remove(part);
            }
        }
        return result;
    }
    
    /**
     * Returns whether this textual representation contains a match for the given <code>regex</code>.
     * 
     * @param regex the regular expression to be matched
     * @return <code>true</code> if this textual representation contains a match for <code>regex</code>, 
     *   <code>false</code> else
     */
    private boolean containsRegex(String regex) {
        boolean containtsRegex = false;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            // If this exception is thrown, then input is not a (valid) regular expression
            pattern = null;
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text);
            if (matcher != null) {
                containtsRegex = matcher.find(); 
            }
        }
        return containtsRegex;
    }
    
    /**
     * Returns the actual text.
     * 
     * @return the actual text
     */
    @Invisible
    public String getText() {
        return text;
    }

    @Override
    public void artifactChanged(Object cause) throws ArtifactException {
        updateContents();
    }
    
    /**
     * Changes the entire text of this artifact.
     * 
     * @param text the text to be changed
     */
    @Invisible
    public void setText(String text) {
        this.text = text;
        try {
            triggerArtifactChanged();
        } catch (ArtifactException e) {
            // unsure
        }
    }
    
    /**
     * Writes the data to the given output stream.
     * 
     * @param out the target output stream
     * @throws IOException in case of I/O problems
     */
    @Invisible
    public void write(Writer out) throws IOException {
        out.append(text);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "<text>";
    }
    
    // no automated conversion to string here as the string is disconnected from the
    // underlying artifact and may lead to confusion

}
