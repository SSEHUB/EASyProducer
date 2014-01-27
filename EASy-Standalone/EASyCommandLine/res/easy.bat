@echo off
IF "%1"=="debug" (
  java -jar EASyCommand.jar %2 %3 %4 %5 %6 %7 %8 %9
) ELSE (
  IF "%1"=="help" (
    TYPE Readme.txt
  ) ELSE (
    java -Dde.uni_hildesheim.sse.easy.logging.level=WARN -jar EASyCommand.jar %1 %2 %3 %4 %5 %6 %7 %8 %9
  )
)