// this is an excerpt of the related SVNControl class just that compiling works
package tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Tools {

    /**
     * Centers a given component relative to the screen.
     * 
     * @param component the component to be centered
     * 
     * @since 1.50
     */
    public static final void center(Component component) {
        center(component, null);
    }
    
    /**
     * Centers a given component relative to a given component.
     * 
     * @param component the component to be centered
     * @param relativeTo an optional component to center with 
     *     respect to (<b>null</b> if the entire screen should
     *     be considered)
     * 
     * @since 1.50
     */
    public static final void center(Component component, Component relativeTo) {
        Dimension windowSize = component.getSize();
        Dimension relativeSize;
        int x0;
        int y0;
        if (null == relativeTo) {
            x0 = 0;
            y0 = 0;
            relativeSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        } else {
            Point pos = relativeTo.getLocationOnScreen();
            x0 = pos.x;
            y0 = pos.y;
            relativeSize = relativeTo.getSize();
        }
        int x = (int) (relativeSize.getWidth() - windowSize.getWidth()) / 2;
        int y = (int) (relativeSize.getHeight() - windowSize.getHeight()) / 2;
        component.setLocation(x0 + x, y0 + y);
    }
    
}
