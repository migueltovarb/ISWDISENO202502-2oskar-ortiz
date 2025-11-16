@echo off
REM =========================================
REM SCRIPT PARA EJECUTAR MEDICITAS
REM =========================================

echo.
echo ========================================
echo  🏥 MediCitas - Sistema de Citas Medicas
echo ========================================
echo.

REM Configurar variables
set MEDICITAS_DIR=%~dp0
set MAVEN_HOME=C:\Users\Admin\maven
set PATH=%MAVEN_HOME%\bin;%PATH%

REM Verificar si Maven está disponible
echo [*] Verificando Maven...
mvn -v
if errorlevel 1 (
    echo [ERROR] Maven no encontrado. Por favor instala Maven.
    pause
    exit /b 1
)

REM Compilar el proyecto
echo.
echo [*] Compilando proyecto MediCitas...
cd /d "%MEDICITAS_DIR%"
call mvn clean install -DskipTests
if errorlevel 1 (
    echo [ERROR] Error al compilar el proyecto.
    pause
    exit /b 1
)

echo.
echo [✓] Compilación exitosa!
echo.
echo ========================================
echo  🚀 Iniciando MediCitas...
echo ========================================
echo.

REM Iniciar la aplicación
call mvn spring-boot:run

pause
