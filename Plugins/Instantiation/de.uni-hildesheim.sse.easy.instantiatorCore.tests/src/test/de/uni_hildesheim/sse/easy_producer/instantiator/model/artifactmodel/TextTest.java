package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactmodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import junit.framework.Assert;

import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Tests for the textual representation of an artifact.
 * 
 * @author kroeher
 *
 */
public class TextTest extends AbstractTest {

    private File testFile = new File(determineTestDataDir().getAbsolutePath() + "/TextTestFile.txt");
    private File emptyTestFile = new File(determineTestDataDir().getAbsolutePath() + "/EmptyTextTestFile.txt");
    private String textString = getFileContent(testFile);
    
    /**
     * Creates a new empty textual representation.
     * 
     * @param modifiable <code>True</code> if the text should be modifiable, <code>false</code> otherwise
     * @return an empty textual representation.
     */
    private Text createEmptyText(boolean modifiable) {
        return new Text(modifiable);
    }
    
    /**
     * Creates a new textual representation based on a string.
     * 
     * @param useEmptyString  <code>True</code> if the text should be based on an empty string,
     *     <code>false</code> otherwise
     * @param modifiable <code>True</code> if the text should be modifiable, <code>false</code> otherwise
     * @return a textual representation of a string.
     */
    private Text createStringText(boolean useEmptyString, boolean modifiable) {
        Text newText = null;
        try {
            if (useEmptyString) {
                newText = new Text("", modifiable);    
            } else {
                newText = new Text(textString, modifiable);
            }
        } catch (ArtifactException e) {
            e.printStackTrace();
        }
        return newText;
    }
    
    /**
     * Creates a new textual representation based on a file.
     * 
     * @param useEmptyFile <code>True</code> if the text should be based on an empty file, <code>false</code> otherwise
     * @param modifiable <code>True</code> if the text should be modifiable, <code>false</code> otherwise
     * @return a textual representation of a file.
     */
    private Text createFileText(boolean useEmptyFile, boolean modifiable) {
        Text newText = null;
        try {
            if (useEmptyFile) {
                newText = new Text(emptyTestFile, modifiable);    
            } else {
                newText = new Text(testFile, modifiable);
            }
            
        } catch (ArtifactException e) {
            e.printStackTrace();
        }
        return newText;
    }
    
    /**
     * Tests whether a text is empty.
     */
    @Test
    public void testIsEmpty() {
        Assert.assertTrue("empty, modifiable text is not empty", createEmptyText(true).isEmpty());
        Assert.assertTrue("empty, not modifiable text is not empty", createEmptyText(false).isEmpty());
        
        Assert.assertTrue("modifiable text based on empty string is not empty", createStringText(true, true).isEmpty());
        Assert.assertFalse("modifiable text based on string is empty", createStringText(false, true).isEmpty());
        Assert.assertTrue("not modifiable text based on empty string is not empty",
                createStringText(true, false).isEmpty());
        Assert.assertFalse("not modifiable text based on string is empty", createStringText(false, false).isEmpty());
        
        Assert.assertTrue("modifiable text based on empty file is not empty", createFileText(true, true).isEmpty());
        Assert.assertFalse("modifiable text based on file is empty", createFileText(false, true).isEmpty());
        Assert.assertTrue("not modifiable text based on empty file is not empty",
                createFileText(true, false).isEmpty());
        Assert.assertFalse("not modifiable text based on file is empty", createFileText(false, false).isEmpty());
    }
    
    /**
     * Tests substitutions in textual representations.
     */
    @Test
    public void testSubstitute() {
        String regex = "can .* provide";
        String replacement = "must provide";
        Assert.assertFalse("successful substitution of empty, modifiable text",
                substitute(createEmptyText(true), regex, replacement));
        Assert.assertFalse("successful substitution of empty, not modifiable text",
                substitute(createEmptyText(false), regex, replacement));
        
        Assert.assertFalse("successful substitution of modifiable text based on empty string",
                substitute(createStringText(true, true), regex, replacement));
        Assert.assertTrue("substitution of modifiable text based on string not successful",
                substitute(createStringText(false, true), regex, replacement));
        Assert.assertFalse("successful substitution of not modifiable text based on empty string",
                substitute(createStringText(true, false), regex, replacement));
        Assert.assertFalse("successful substitution of not modifiable text based on string",
                substitute(createStringText(false, false), regex, replacement));
        
        Assert.assertFalse("successful substitution of modifiable text based on empty file",
                substitute(createFileText(true, true), regex, replacement));
        Assert.assertTrue("substitution of modifiable text based on file not successful",
                substitute(createFileText(false, true), regex, replacement));
        Assert.assertFalse("successful substitution of not modifiable text based on empty file",
                substitute(createFileText(true, false), regex, replacement));
        Assert.assertFalse("successful substitution of not modifiable text based on file",
                substitute(createFileText(false, false), regex, replacement));
    }
    
    /**
     * Substitutes all occurrences of <code>search</code> by <code>replacement</code> in the given
     * text.
     * 
     * @param testObject the text in which <code>search</code> must be substituted
     * @param search the regular expression
     * @param replacement the replacement-string
     * @return <code>True</code> if the substitution is successful, <code>false</code> otherwise
     */
    private boolean substitute(Text testObject, String search, String replacement) {
        boolean success = false;
        try {
            Text resultText = testObject.substitute(search, replacement);
            success = !containsRegex(resultText, search) && resultText.getText().contains(replacement);
        } catch (ArtifactException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    /**
     * Returns whether the given textual representation contains a match for the given <code>regex</code>.
     * 
     * @param text the text to be checked
     * @param regex the regular expression to be matched
     * @return <code>true</code> if this textual representation contains a match for <code>regex</code>, 
     *   <code>false</code> else
     */
    private boolean containsRegex(Text text, String regex) {
        boolean containtsRegex = false;
        Pattern pattern = null;
        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            // If this exception is thrown, then input is not a (valid) regular expression
            pattern = null;
        }
        if (pattern != null) {
            Matcher matcher = pattern.matcher(text.getText());
            if (matcher != null) {
                containtsRegex = matcher.find(); 
            }
        }
        return containtsRegex;
    }
    
    /**
     * Tests matching of regular expression and textual representation.
     */
    @Test
    public void testMatches() {
        String regexForString = ".{265}";
        String regexForFile = ".{273}";
        try {
            Assert.assertFalse("successful match in empty, modifiable text",
                    createEmptyText(true).matches(regexForString));
            Assert.assertFalse("successful match in empty, not modifiable text",
                    createEmptyText(false).matches(regexForString));
            
            Assert.assertFalse("successful match in modifiable text based on empty string",
                    createStringText(true, true).matches(regexForString));
            Assert.assertTrue("no match in modifiable text based on string",
                    createStringText(false, true).matches(regexForString));
            Assert.assertFalse("successful match in not modifiable text based on empty string",
                    createStringText(true, false).matches(regexForString));
            Assert.assertTrue("no match in not modifiable text based on string",
                    createStringText(false, false).matches(regexForString));
            
            Assert.assertFalse("successful match in modifiable text based on empty file",
                    createFileText(true, true).matches(regexForFile));
            Assert.assertTrue("no match in modifiable text based on file",
                    createFileText(false, true).matches(regexForFile));
            Assert.assertFalse("successful match in not modifiable text based on empty file",
                    createFileText(true, false).matches(regexForFile));
            Assert.assertTrue("no match in not modifiable text based on file",
                    createFileText(false, false).matches(regexForFile));            
        } catch (ArtifactException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the deletion of the first occurrence of a sub-string
     * of a textual representation of an artifact that matches a
     * specific regular expression.
     */
    @Test
    public void testRemoveRegex() {
        String regex = "can .* provide";
        String removedString = "can be used to provide";
        try {
            Text artifactText = new Text(testFile, true);
            Assert.assertNotNull("text must exist", artifactText);
            artifactText.removeAll(regex);
            Assert.assertFalse(artifactText.getText().contains(removedString));
        } catch (ArtifactException e) {
            e.printStackTrace();
        }
    }
    
    /** 
     * Reads a file and returns the content as string.
     * 
     * @param file the file to be read
     * @return the content of the file as string
     */
    private String getFileContent(File file) {
        String fileContent = null;
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            StringBuilder strBuilder = new StringBuilder();
            String line = buffReader.readLine();
            while (line != null) {
                strBuilder.append(line);
                strBuilder.append("\n");
                line = buffReader.readLine();
            }
            fileContent = strBuilder.toString();
            // Clean-up
            buffReader.close();
            buffReader = null;
            strBuilder = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
