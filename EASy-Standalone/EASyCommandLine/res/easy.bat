@echo off
IF "%1"=="debug" (
  java -Dde.uni_hildesheim.sse.easy.logging.level=DEBUG -jar EASyCommandLine.jar %2 %3 %4 %5 %6 %7 %8 %9
) ELSE (
  IF "%1"=="help" (
    TYPE Readme.txt
  ) ELSE (
    java -Dde.uni_hildesheim.sse.easy.logging.level=WARN -jar EASyCommandLine.jar %1 %2 %3 %4 %5 %6 %7 %8 %9
  )
)