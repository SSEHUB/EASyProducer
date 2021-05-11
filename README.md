EASyProducer
============

EASy-Producer is a Product Line Engineering toolset, initially developed by the Software Systems Engineering group at the University of Hildesheim. EASy-Producer was already successfully tested in industrial environments.

Release History
---------------
Please see [release history](http://htmlpreview.github.io/?https://github.com/SSEHUB/EASyProducer/blob/master/EASyBuildProperties/changelog.html "release history") for details.

Documentation
-------------
The documentation can be found at the [EASy-Producer update site](http://projects.sse.uni-hildesheim.de/easy/ "EASy-Producer update site") as well as part of the Eclipse Help plugin available for installation.

Installation
-------------
EASy-Producer can be installed from the [official update site](http://projects.sse.uni-hildesheim.de/easy/ "EASy-Producer update site") hosted at the University of Hildesheim, Germany. 

We also provide a snapshot of the most recent developments in terms of a [nightly update site](https://projects.sse.uni-hildesheim.de/eclipse/update-sites/easy_nightly/ "EASy-Producer nightly update site") also hosted at the University of Hildesheim, Germany. However, currently this update site is not up to date due to problems running the required Eclipse tasks in our Continuous Integration Environment.

From there (but also [doc](/doc/ "doc")) previews of the upcoming documentation can be obtained. Please note that Eclipse Help plugin of the nightly version contains the same documentation as the latest release.

Support for Eclipse/JDK
-----------------------
Since Spring 2021, EASy-Producer is compatible with Eclipse 2021-03 (4.19.0)/JDK 13. This requires that the UI layer of EASy-Producer must be compiled with JDK 11, while the lower layers can still be compiled with JDK 8 (for standalone use as library/via Maven).

Moreover, since Eclipse 4.9, a different bundle for Descriptive Services is required, which does not exist on older Eclipse version. For now, we decided to include both, the old and the new bundle, as optional as suggested by some Eclipse page, i.e., as long as this does not clash with product installation, at least the lower EASy-Producer layers shall still work with Eclipse 4.5 and JDK 8, Eclipse 4.7 and JDK 11. However, the UI requires JDK 11 and at least xText 2.21.


Running EASy-Producer/tests within Eclipse
------------------------------------------
We experienced some difficulties creating launch configurations since Eclipse 4.7. As a result, we provide a collection of Eclipse launch configurations in the "launching" folder. Please note that a JDK must be installed and available as installed JRE in Eclipse. See also the readme file there and the source code setup/plugins section below for required plugins. 

Source code setup/plugins
-------------------------
Please install the Eclipse Checkstyle plugin. The configurations are compatible with Checkstyle 8.35. Setup a global checkstyle configuration named "SSE Checkstyle Configuration" as a project local configuration pointing to the checkstyle file in the project "EASy-Producer.Eclipse".

Please install also xText 2.25 (at least xText 2.12). 

Build Status
------------------
| Component | Status |
|---|---|
| Features | ![Build Status of Features](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_Features) |
| Nightly-UpdateSite | ![Build Status of Nightly-UpdateSite](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_NightlyUpdateSite) |
| EASy-Producer | ![Build Status of EASy-Producer](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_EASy-Producer) |
| Instantiation | ![Build Status of Instantiation](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_Instantiation) |
| SSE-Reasoner | ![Build Status of SSE-Reasoner](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_SSEreasoner) |
| Reasoner Core | ![Build Status of Reasoner Core](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_ReasonerCore) |
| IVML-Parser | ![Build Status of IVML-Parser](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_IVML) |
| Variability Model | ![Build Status of Variability Model](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_VarModel) |
| Standalone | ![Build Status of Standalone](http://jenkins-2.sse.uni-hildesheim.de/buildStatus/icon?job=EASy_Standalone) |
