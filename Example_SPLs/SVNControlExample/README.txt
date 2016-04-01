This is the simplified SVNControl example (without component exchange).

This project is not a full project rather than the set of changes needed to turn the SVNControl 
application on Tigris (http://svncontrol.tigris.org/svn/svncontrol/trunk/SVNControl) into an EASy
product line with binding-time meta variablity [SchmidEichelberger08].

- Checkout the SVNControl project from Tigris.
- Overwrite the properties file in the SVNControl project by the one taken from the change set project. Adjust the svnHome 
  so that it points to a local SVN repository (with auth and access file on parent level).
- Overwrite the startClient.bat and startServer.bat of the SVNControl project by those in the change set project (for Linux, 
  respective scripts must be created).
- Copy the two libraries from the change set lib folder into the SVNControl lib folder.
- Add the decVarTool-library to the Project classpath.
- In gui.ScheduleTab add
  - import de.uni_hildesheim.sse.variability.runtime.annotations.Component;
  - and on class level 
    @Component (boundTo = "OPT_SCHEDULES", packageAlways = false, 
        replaceThis = false)
- In gui.HooksTab add     
  - import de.uni_hildesheim.sse.variability.runtime.annotations.Component;
  - and on class level
    @Component(boundTo = "OPT_HOOKS", packageAlways = false, 
        replaceThis = false)
- Disable checkstyle as generated parts do not fully comply to checkstyle rules.

- Copy the EASy folder from this change set project into the SVNControl project.
- Enable the EASy-Producer VIL classpath argument provider if required (Window|Preferences|EASy-Producer).
- Turn the SVNControl project into an EASy product line project (Project context menu|Configure|Add EASy-Producer nature).
