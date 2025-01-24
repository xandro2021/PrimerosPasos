#!/bin/bash

# Configuración de las carpetas
SRC_DIR="src"
BIN_DIR="bin"

# Crear el directorio bin si no existe
if [ ! -d "$BIN_DIR" ]; then
    mkdir -p "$BIN_DIR"
    echo "Directorio '$BIN_DIR' creado."
fi

# Compilar los archivos .java
echo "Compilando archivos Java desde '$SRC_DIR' a '$BIN_DIR'..."
javac -d "$BIN_DIR" $(find "$SRC_DIR" -name "*.java")

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "Compilación exitosa. Archivos .class generados en '$BIN_DIR'."
else
    echo "Error durante la compilación."
    exit 1
fi
