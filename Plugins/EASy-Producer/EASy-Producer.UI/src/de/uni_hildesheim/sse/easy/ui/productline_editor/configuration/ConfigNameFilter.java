package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;

/**
 * Shows only variable where its name matches to a given regular expression.
 * @author El-Sharkawy
 *
 */
public class ConfigNameFilter extends AbstractConfigurationFilter {
    private Pattern namePattern;
    
    /**
     * Sole constructor for this name filter.
     * @param name A regular expression, only variables matching to this regular expressions will be displayed.
     * @throws PatternSyntaxException If the expression's syntax is invalid
     */
    ConfigNameFilter(String name) throws PatternSyntaxException {
        // Compile the pattern only once
        this.namePattern = Pattern.compile(name);
    }
    
    @Override
    protected boolean checkVariable(GUIVariable variable) {
        Matcher matcher = namePattern.matcher(variable.getName());
        boolean nameMatches = matcher.matches();
        /*
         * OK, if this variable should be displayed, otherwise check if nested variables should be
         * displayed. In this case, also this variable must be displayed.
         */
        for (int i = 0; i < variable.getNestedElementsCount() && !nameMatches; i++) {
            GUIVariable nestedVariable = variable.getNestedElement(i);
            if (null != nestedVariable) {
                nameMatches = checkVariable(variable.getNestedElement(i));
            }
        }
        
        return nameMatches;
    }
}
