package de.uni_hildesheim.sse.utils;

/**
 * Static utility functions regarding the environment of EASy.
 * @author El-Sharkawy
 *
 */
public class Environment {
    
    /**
     * Should avoid instances of this class.
     */
    private Environment() {}
    
    /**
     * Checks whether EASy runs inside of Eclipse.
     * @return <tt>true</tt> if EASy runs inside of Eclipse, <tt>false</tt> otherwise.
     */
    public static boolean runsInEclipse() {
        // this is just a heuristic, pde.launch is required to state that RCP apps are no eclipse
        return (null != System.getProperty("eclipse.product", null)
            || null != System.getProperty("eclipse.home.location", null)) 
            && null != System.getProperty("eclipse.pde.launch");
    }

}
