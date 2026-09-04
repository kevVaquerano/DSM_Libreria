@echo off
setlocal enabledelayedexpansion
set "PATH=%LOCALAPPDATA%\Programs\kotlinc\bin;%PATH%"

set "FILES="
for %%f in (*.kt) do (
    set "FILES=!FILES! %%f"
)

echo Compilando BookMaster UDB...
call kotlinc %FILES% -include-runtime -d App.jar
if %ERRORLEVEL% EQU 0 (
    echo Iniciando programa...
    echo.
    java -jar App.jar
) else (
    echo.
    echo Ocurrio un error al compilar.
    pause
)
