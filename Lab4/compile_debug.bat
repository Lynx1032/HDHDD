@echo off

:start

cls

set /p file_name= Type the java file name to compile and debug: 

javac %file_name%.java
java %file_name%.java

set /p k_choice= Compile another file (y/n) (default: n): 

IF "%k_choice%"=="" (
	set k_choice = "n"
	)
	
IF "%k_choice%"=="y" (
	GOTO start
	)

pause