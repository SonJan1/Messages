@echo off
if "%1"=="single" (
    mvn compile exec:java -Dexec.mainClass="com.example.singleprocess.MainSingleProcess"
) else if "%1"=="multi" (
    mvn compile exec:java -Dexec.mainClass="com.example.multiprocess.MainMultiProcess"
) else (
    echo Usage: run.bat [single|multi]
)