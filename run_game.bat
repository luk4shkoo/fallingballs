@echo off
echo Compiling game...
javac -d bin src/game/*.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)
echo Starting game...
java -cp bin game.Main
pause 