EASyProducer
============

EASy-Producer is a Product Line Engineering toolset, developed by the Software Systems Engineering group at the University of Hildesheim. EASy-Producer combines a rather powerful variability modeling language with an approach for automated variability instantiation that can employ model-based techniques. 

EASy-Producer is available in different forms, including an integration into the Eclipse IDE, but also as individual, headless components that can easily be integrated through Maven.

EASy-Producer was already successfully applied and tested in various industrial environments such as logistics or embedded systems production. One recent field of application is IoT/Industry 4.0.

Documentation
-------------

The documentation of the actual release version of EASY-Producer consists of

* Information on how to install and use EASy can be found in the [EASy Producer User Guide](http://projects.sse.uni-hildesheim.de/easy/docs-git/docRelease/user_guide.pdf).
* The [language specification of IVML](http://projects.sse.uni-hildesheim.de/easy/docs-git/docRelease/ivml_spec.pdf), the Integrated Variability Modeling Language of EASy-Producer.
* The [language specification of VIL](http://projects.sse.uni-hildesheim.de/easy/docs-git/docRelease/vil_spec.pdf), the Variability Instantiation Language use to automatically instantiate variability in various forms. This specification also includes VTL, the variability template/artifact language. As VIL is an extensible language and may be customized towards the artifacts to be instantiated, there is a separate guide on the default optional [VIL language extensions](http://projects.sse.uni-hildesheim.de/easy/docs-git/docRelease/VIL%20Extensions.pdf)
* EASy also provides extension points for the integration of custom reasoners and instantiators. A step-by-step instruction on how to extend EASy with your custom functionalities can be found in the [EASy Producer Developers Guide](http://projects.sse.uni-hildesheim.de/easy/docs-git/docRelease/developers_guide.pdf).

The documentation can also be found in the Eclipse Help plugin available for installation.

Using EASy-Producer
-------------

**Eclipse Plugin with IDE integration**

Besides the core components such as the languages mentioned above, EASy-Producer consists of an user interface integrated with the Eclipse IDE. Since Spring 2021, EASy-Producer is compatible with Eclipse 2021-03 (4.19.0)/JDK 13. EASy-Producer can be installed from the [official update site](http://projects.sse.uni-hildesheim.de/easy/ "EASy-Producer update site") hosted at the University of Hildesheim, Germany. 

Installing EASy-Producer in recent Eclipse environments requires that the UI layer of EASy-Producer must be compiled with JDK 11.

We also provide a snapshot of the most recent developments in terms of a [nightly update site](https://projects.sse.uni-hildesheim.de/eclipse/update-sites/easy_nightly/ "EASy-Producer nightly update site") also hosted at the University of Hildesheim, Germany. From there (but also [doc](/doc/ "doc")) previews of the upcoming documentation can be obtained. Please note that Eclipse Help plugin of the nightly version contains the same documentation as the latest release.

**Headless component library**

The core components such as the languages mentioned above can also be used stand alone or integrated into other systems (as done in recent or finished projects). Released versions of the EASy-Producer components can be found on Maven central, nightly versions in the SSE Maven repository. As long as supported by the Eclipse components deployed to Maven central, the EASy-Producer core components just require JDK 8.

If you are interested in using EASy-Producer as a component library, please refer to the developers guide.

Source code setup/plugins
-------------------------

If you want to work with the code, please install first the Eclipse Checkstyle plugin as well as xText 2.25 (at least xText 2.12). The EASy-Producer code base ships with Checkstyle configurations that are compatible with Checkstyle 8.35. Setup a global checkstyle configuration named "SSE Checkstyle Configuration" as a project local configuration pointing to the checkstyle file in the project "EASy-Producer.Eclipse". 

Having EASy-Producer available as sourc code, you can also execute EASy-Producer as an Eclipse runtime instance from within Eclipse. However, we experienced some difficulties creating launch configurations since Eclipse 4.7. As a result, we provide a collection of Eclipse launch configurations in the "launching" folder. Please note that a JDK must be installed and available as installed JRE in Eclipse, i.e., a JRE is not sufficient. 

Ongoing development
-------------------

EASy-Producer is developing over time. Please see [release history](http://htmlpreview.github.io/?https://github.com/SSEHUB/EASyProducer/blob/master/doc/changelog.html "release history") for the release/change history.

To keep the documentation up to date with recent developments, we provide the documents mentioned above in an updated form in github.

* EASy-Producer [user guide](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/user_guide.pdf)
* [IVML language specification](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/IVML%20Language%20Spec.pdf)
* [VIL language specification](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/VIL%20Language%20Spec.pdf) and [VIL language extensions](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/VIL%20Extensions.pdf)
* [EASy-Producer developers guide](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/developers_guide.pdf)
* [Experimental rt-VIL language specification](http://projects.sse.uni-hildesheim.de/easy/docs-git/docPreview/rt-VIL%20Language%20Spec.pdf)

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
