Be careful. The aspectjtools.jar contains a lot of overlapping/contradicting dependencies, 
e.g., eclipse core parts. If listed in manifest before EASy bundles, which may require more recent
versions, some EASy-parts such as tests may fail.