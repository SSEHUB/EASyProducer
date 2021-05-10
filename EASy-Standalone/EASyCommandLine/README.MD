**Command line support for EASy-Producer**

This part encapsulates EASy-Producer functionality into high-level commands and, in particular, two ANT tasks.

Example:

    <path id="easyTaskDef.lib" >
        <fileset dir="dist">
            <include name="*.jar" />
        </fileset>
    </path>
                
        
    <!-- run the full VIL build -->
    <property name="projectFolder" location="."/>
    <taskdef resource="EASyTasks.properties" classpathref="easyTaskDef.lib"/>
    <!-- Alternative 1: basic task, based on folder setup, more flexibility -->    
    <easyPlain source="${projectFolder}" target="${projectFolder}" projectName="QM" verbose="true"/>
    <!-- Alternative 2: requires EASy-Folder and .EASyConfig -->
    <easy source="${projectFolder}" target="${projectFolder}" projectName="QM"/>
    
Here the assumption is that the Jar libraries of EASy-Producer (e.g., through the Standalone jars or the Maven 
dependencies) are available in the `dist` folder.