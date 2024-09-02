EASyProducer
============

EASy-Producer is a Product Line Engineering toolset, developed by the Software Systems Engineering group at the University of Hildesheim. EASy-Producer combines a rather powerful variability modeling language with an approach for automated variability instantiation that can employ model-based techniques. 

EASy-Producer is available in different forms, including an integration into the Eclipse IDE, but also as individual, headless components that can easily be integrated through Maven.

EASy-Producer was already successfully applied and tested in various industrial environments such as logistics or embedded systems production. One recent field of application is IoT/Industry 4.0.

News
-------------

June 2024: EASy-Producer is on Eclipse 2024-06 and JDK 21, pre-built PDEs ship with embedded JRE.

As we did not publish a full release for a longer term, we refer here to the nightly builds and their documentation.

Documentation
-------------

The documentation of the actual release version of EASY-Producer consists of

* Information on how to install and use EASy can be found in the [EASy Producer User Guide](https://github.com/SSEHUB/EASyProducer/tree/master/doc/web/docPreview/user_guide.pdf).
* The [language specification of IVML](https://github.com/SSEHUB/EASyProducer/blob/master/doc/web/docPreview/IVML%20Language%20Spec.pdf), the Integrated Variability Modeling Language of EASy-Producer.
* The [language specification of VIL](https://github.com/SSEHUB/EASyProducer/blob/master/doc/web/docPreview/VIL%20Extensions.pdf), the Variability Instantiation Language use to automatically instantiate variability in various forms. This specification also includes VTL, the variability template/artifact language. As VIL is an extensible language and may be customized towards the artifacts to be instantiated, there is a separate guide on the default optional [VIL language extensions](https://github.com/SSEHUB/EASyProducer/blob/master/doc/web/docPreview/VIL%20Extensions.pdf)
* EASy also provides extension points for the integration of custom reasoners and instantiators. A step-by-step instruction on how to extend EASy with your custom functionalities can be found in the [EASy Producer Developers Guide](https://github.com/SSEHUB/EASyProducer/blob/master/doc/web/docPreview/developers_guide.pdf).

The documentation can also be found in the Eclipse Help plugin available for installation.

Using EASy-Producer
-------------

**Eclipse Plugin with IDE integration**

Besides the core components such as the languages mentioned above, EASy-Producer consists of an user interface integrated with the Eclipse IDE. Since Spring 2021, EASy-Producer is compatible with Eclipse 2024-03 (4.31.0)/JDK 17. EASy-Producer can be installed from the [nightly update site](http://projects.sse.uni-hildesheim.de/eclipse/update-sites/easy_nightly/ "EASy-Producer nightly update site") hosted at the University of Hildesheim, Germany. 

We also provide a snapshot installation of the most recent developments in terms of [nightly pre-packaged Eclipse installations](http://projects.sse.uni-hildesheim.de/eclipse/easy-nightly "EASy-Producer nightly pre-packaged installations") also hosted at the University of Hildesheim, German

**Headless component library**

The core components such as the languages mentioned above can also be used stand alone or integrated into other systems (as done in recent or finished projects). Released versions of the EASy-Producer components can be found on Maven central, nightly versions in the SSE Maven repository. As long as supported by the Eclipse components deployed to Maven central, the EASy-Producer core components just require JDK 17.

If you are interested in using EASy-Producer as a component library, please refer to the developers guide.

Source code setup/plugins
-------------------------

If you want to work with the code, please install first the Eclipse Checkstyle plugin as well as xText 2.34. The EASy-Producer code base ships with Checkstyle configurations that are compatible with Checkstyle 8.35. Setup a global checkstyle configuration named "SSE Checkstyle Configuration" as a project local configuration pointing to the checkstyle file in the project "EASy-Producer.Eclipse". 

Having EASy-Producer available as source code, you can also execute EASy-Producer as an Eclipse runtime instance from within Eclipse. We also provide an Eclipse launch configurations in the "launching" folder along with required dropins. Please note that a JDK must be installed and available as installed JRE in Eclipse, i.e., a JRE is not sufficient. 

Ongoing development
-------------------

EASy-Producer is developing over time. Please see [release history](http://htmlpreview.github.io/?https://github.com/SSEHUB/EASyProducer/blob/master/doc/changelog.html "release history") for the release/change history.

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
