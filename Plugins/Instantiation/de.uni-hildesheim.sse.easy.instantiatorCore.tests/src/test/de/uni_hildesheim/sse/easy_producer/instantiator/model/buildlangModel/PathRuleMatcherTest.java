package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch.AbstractPathRuleMatchExpression;

/**
 * Tests the path rule matcher in {@link AbstractPathRuleMatchExpression}.
 * 
 * @author Holger Eichelberger
 */
public class PathRuleMatcherTest extends AbstractTest {
    
    /**
     * Tests whether described exceptions from replacements actually happen.
     */
    @Test
    public void testNoReplacement() {
        // no pattern
        Assert.assertEquals("", 
            AbstractPathRuleMatchExpression.replace("", "*.java", "test.java"));
        Assert.assertEquals("abba", 
            AbstractPathRuleMatchExpression.replace("abba", "*.java", "test.java"));
        // no match on rhs
        Assert.assertEquals("", 
            AbstractPathRuleMatchExpression.replace("", "*.java", "test.class"));
        Assert.assertEquals("abba", 
            AbstractPathRuleMatchExpression.replace("abba", "*.java", "test.class"));
    }

    /**
     * Tests whether described replacements actually happen.
     */
    @Test
    public void testMultiCharReplacements() {
        Assert.assertEquals("test.class", 
            AbstractPathRuleMatchExpression.replace("*.class", "*.java", "test.java"));
        Assert.assertEquals("src/test.class", 
            AbstractPathRuleMatchExpression.replace("src/*.class", "src/*.java", "src/test.java"));
        Assert.assertEquals("bin/test.class", 
            AbstractPathRuleMatchExpression.replace("bin/*.class", "src/*.java", "src/test.java"));
        Assert.assertEquals("bin/abba.class", 
            AbstractPathRuleMatchExpression.replace("bin/a*.class", "src/a*.java", "src/abba.java"));
        Assert.assertEquals("bin/aabba.java.tmp", 
            AbstractPathRuleMatchExpression.replace("bin/a*.tmp", "src/*", "src/abba.java"));
    }

    /**
     * Tests whether described replacements actually happen.
     */
    @Test
    public void testPathReplacements() {
        Assert.assertEquals("bin/test/test.class", 
            AbstractPathRuleMatchExpression.replace("bin/**/*.class", "src/**/*.java", "src/test/test.java"));
        Assert.assertEquals("bin/test/test/test.class", 
            AbstractPathRuleMatchExpression.replace("bin/**/*.class", "src/**/*.java", "src/test/test/test.java"));
        Assert.assertEquals("bin/test/test/test1.class", 
            AbstractPathRuleMatchExpression.replace("bin/**/test1.class", "src/**/test.java", 
                "src/test/test/test.java"));
        // ** may collapse to ""
        Assert.assertEquals("resources/Fahrstuhl.gif", 
            AbstractPathRuleMatchExpression.replace("resources/**/*", "resources/**/*", "resources/Fahrstuhl.gif"));
        Assert.assertEquals("bin/test.class", 
            AbstractPathRuleMatchExpression.replace("bin/**/*.class", "src/**/*.java", "src/test.java"));
    }

    /**
     * Tests whether single character replacements actually happen.
     */
    @Test
    public void testSingleReplacements() {
        Assert.assertEquals("src/s.class", 
            AbstractPathRuleMatchExpression.replace("src/?.class", "src/te?t.java", "src/test.java"));
    }

    /**
     * Tests a single overlap from two sides (by exchanging pattern parameters).
     * 
     * @param leftPattern the first pattern to match (LHS)
     * @param rightPattern the right pattern to match (RHS)
     * @param expected the expected result for both tests
     */
    private static void testOverlap(String leftPattern, String rightPattern, boolean expected) {
        Assert.assertEquals(AbstractPathRuleMatchExpression.overlaps(leftPattern, rightPattern), expected);
        Assert.assertEquals(AbstractPathRuleMatchExpression.overlaps(rightPattern, leftPattern), expected);
    }
    
    /**
     * Tests the overlap detection algorithm with at least one empty input string.
     */
    @Test
    public void testOverlapsEmpty() {
        // provided is LHS - required is RHS
        // test without pattern
        testOverlap("", "", false);
        testOverlap("", "bin/test.class", false);

        // test with single char pattern
        testOverlap("", "?", false);
        testOverlap("", "b?n/test.class", false);

        // test with multiple char pattern
        testOverlap("", "*", false);
        testOverlap("", "b*n/test.class", false);
        testOverlap("bin/test.*", "", false);

        // test with deep tree pattern
        testOverlap("", "**", false);
        testOverlap("", "bin/**/test.class", false);
    }

    /**
     * Tests the overlap detection algorithm with direct matches and mismatches, i.e., without patterns.
     */
    @Test
    public void testOverlapsDirectMatch() {
        // provided is LHS - required is RHS
        testOverlap("bin/test.class", "bin/test.class", true);
        // one char mismatches -> fail
        testOverlap("ain/test.class", "bin/test.class", false);
        testOverlap("bin/test.class", "bin/test.clast", false);
    }

    /**
     * Tests the overlap detection algorithm with single char matches and mismatches.
     */
    @Test
    public void testOverlapsSingleMatch() {
        // one single char match
        testOverlap("?in/test.class", "bin/test.class", true);
        testOverlap("bin/?est.class", "bin/test.class", true);
        testOverlap("bin/test.clas?", "bin/test.class", true);

        testOverlap("?an/test.class", "bin/test.class", false);
        testOverlap("bin/?est.class", "bin/ttst.class", false);
        testOverlap("bin/test.clas?", "bin/test.clats", false);
        testOverlap("bin/test.classi", "bin/test.clas?", false);

        // two single char matches on left side

        testOverlap("?in/?est.class", "bin/test.class", true);
        testOverlap("bin/?est.?lass", "bin/test.class", true);
        testOverlap("?in/test.clas?", "bin/test.class", true);

        // one single char match on both sides

        testOverlap("?in/test.class", "?in/test.class", true);
        testOverlap("bin/?est.class", "bin/?est.class", true);
        testOverlap("bin/test.clas?", "bin/test.clas?", true);
        testOverlap("b?n/test.class", "bo?/test.class", true);

        // two single char matches on both sides

        testOverlap("b?n/test.clas?", "b?n/test.clas?", true);
        testOverlap("b?n/test.clas?", "bo?/tes?.clas?", true);
    }

    /**
     * Tests the overlap detection algorithm with multiple char matches and mismatches.
     */
    public void testOverlapsMultiMatch() {
        // single multi, no further pattern 
        testOverlap("bin/test.class", "bin/*.class", true);
        
        // double multi, no further pattern 
        testOverlap("bin/test.class", "*/*.class", true);

        // double multi and single character match
        testOverlap("bin/test.clas?", "*/*.class", true);

        // overlapping multi-single
        testOverlap("bi?/test.class", "*/*.class", true);
        testOverlap("bi?/tes?.clas?", "*/*.clas?", true);
        
        // overlapping multi-multi
        testOverlap("*/*.class", "*/*.class", true);
        testOverlap("*/*.class", "*bin/*.class", true);
        testOverlap("*/*.class", "*bin/tes*.class", true);
        testOverlap("*/*.class", "*/*.*", true);
        
        // mismatch?
        testOverlap("*/*.clast", "bin/test.class", false);
        testOverlap("*t/*.clast", "bin/test.class", false);
        testOverlap("*/*.class", "*bin/tes*.clast", false);
    }

    /**
     * Tests the overlap detection algorithm with deep tree matches and mismatches.
     */
    public void testOverlapsDeepMatch() {
        // one deep path
        testOverlap("**/test.class", "bin/test.class", true);
        testOverlap("**/test.class", "bin/bin/test.class", true);
        
        // ANT adds ** to end if end is /
        testOverlap("bin/", "bin/test.class", true);
        testOverlap("**/", "bin/test.class", true);
        
        // deep paths on both sides
        testOverlap("**/test.class", "bin/**/test.class", true);
        testOverlap("**/test.class", "bin/**/test/test.class", true);
        testOverlap("**/test/test.class", "bin/**/test/test.class", true);
        
        // deep path and single character
        testOverlap("**/test.class", "bin/test.cla?s", true);
        testOverlap("**/tes?.class", "bin/test.cla?s", true);
        testOverlap("**/tes?.class", "bin/**/test.cla?s", true);
        
        // deep path and multi characters
        testOverlap("**/*.class", "bin/test.class", true);
        testOverlap("**/*.class", "bin/bla.class", true);
        testOverlap("**/*.class", "bin/*.class", true);
        
        // two deep paths
        testOverlap("**/*.class", "**/bla.class", true);
        testOverlap("**/*.class", "**/*.class", true);
        testOverlap("**/*.class", "**/*.*", true);
        testOverlap("**/*.*", "**/*.*", true);
        testOverlap("**/*.c*", "**/*.cl*", true);
       
        // multi deep paths
        testOverlap("**/bin/**/*.class", "bin/bin/bin/test.class", true);
        testOverlap("**/bin/**/*.class", "**/test.class", true);
        testOverlap("**/**/*.class", "bin/bin/test.class", true);
        
        // mismatch
        testOverlap("**/bin/", "bin/test.class", false);
        testOverlap("**/test.clast", "bin/bin/test.class", false);        
        testOverlap("**/test/test.class", "bin/**/tast/test.class", false);
        testOverlap("**/test/test.class", "bin/test.cla?s", false);
        testOverlap("**/*.class", "**/bla.clast", false);
        testOverlap("**/**/*.class", "bin/test.class", false);
        testOverlap("**/bin/**/*.class", "bin/ban/bin/test.class", false);
    }

    /**
     * Some further patterns for the overlap detection algorithm (originating from previous
     * tests.
     */
    @Test
    public void testOverlapsFurtherCases() {
        // same pattern shall match
        testOverlap("bin/**/*.class", "bin/**/*.class", true);
        // left side is sub pattern of right side... ok
        testOverlap("bin/basics/**/*.class", "bin/**/*.class", true);
        // endings wrong - fail
        testOverlap("bin/basics/**/*.java", "bin/**/*.class", false);
        // more provided than required - but end of path not matching - ok
        testOverlap("bin/basics/**/*", "bin/**/*.class", true);
        // more provided than required - fine
        testOverlap("bin/basics/**/*.*", "bin/**/*.class", true);
        // provided is more specific than required (catch all) - fine
        testOverlap("bin/basics/**/.class", "bin/**/*", true);
        // provision is more generic then required - fine, let's try
        testOverlap("bin/**/*.class", "bin/basics/**/*.class", true);
        // file paths are provided but files required - ok
        testOverlap("bin/basics/**", "bin/**/*", true);
        // file may be the same - ok
        testOverlap("bin/basics/a*.java", "bin/**/a*.java", true);
        // ** catches up
        testOverlap("bin/basics/**", "bin/**/*", true);
        // ** shortcut according to ANT conventions
        testOverlap("bin/basics/", "bin/**/*", true);
    }
    
    /**
     * For debugging.
     */
    @Ignore
    @Test
    public void testDebug() {
        // file names differ - fail
        Assert.assertFalse(AbstractPathRuleMatchExpression.overlaps("bin/basics/a*.java", "bin/**/b*.java"));
    }

}
