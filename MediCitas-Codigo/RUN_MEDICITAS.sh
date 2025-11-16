#!/bin/bash

# =========================================
# Script para ejecutar MediCitas en Linux/Mac
# =========================================

echo ""
echo "========================================"
echo "  🏥 MediCitas - Sistema de Citas Médicas"
echo "========================================"
echo ""

# Configurar variables
MEDICITAS_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MAVEN_HOME="${MAVEN_HOME:-$HOME/maven}"
export PATH="$MAVEN_HOME/bin:$PATH"

# Verificar si Maven está disponible
echo "[*] Verificando Maven..."
if ! command -v mvn &> /dev/null; then
    echo "[ERROR] Maven no encontrado. Por favor instala Maven."
    exit 1
fi

mvn -v

# Compilar el proyecto
echo ""
echo "[*] Compilando proyecto MediCitas..."
cd "$MEDICITAS_DIR"
mvn clean install -DskipTests
if [ $? -ne 0 ]; then
    echo "[ERROR] Error al compilar el proyecto."
    exit 1
fi

echo ""
echo "[✓] Compilación exitosa!"
echo ""
echo "========================================"
echo "  🚀 Iniciando MediCitas..."
echo "========================================"
echo ""

# Iniciar la aplicación
mvn spring-boot:run

