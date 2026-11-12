Be careful. The velocity-1.7-dep.jar contains a lot of overlapping/contradicting dependencies, 
e.g., Apache commons. If listed in manifest before EASy bundles, which may require more recent
versions, some EASy-parts such as tests may fail.