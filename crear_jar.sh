#!/bin/bash

# Configuración de las carpetas
SRC_DIR="src"
BIN_DIR="bin"

# Mensajes
MSG_BIENVENIDA="Bienvenido al script de creación de JAR"
MSG_CLASE_PRINCIPAL="Ingresa el nombre completo de la clase principal (presiona Enter para usar 'Main'):"
MSG_NOMBRE_JAR="Ingresa el nombre de la aplicación (presiona Enter para usar el nombre de la clase principal):"
MSG_COMPILACION_EXITOSA="Compilación exitosa. Archivos .class generados en '$BIN_DIR'."
MSG_ERROR_COMPILACION="Error durante la compilación."
MSG_CREACION_JAR_EXITOSA="JAR '%s' creado correctamente."
MSG_ERROR_CREACION_JAR="Error al crear el JAR."

# Colores
COLOR_VERDE="\033[0;32m"
COLOR_ROJO="\033[0;31m"
COLOR_NORMAL="\033[0m"

# Solicitar el nombre completo de la clase principal
echo -e "$COLOR_VERDE$MSG_BIENVENIDA$COLOR_NORMAL"
echo -e "$COLOR_VERDE$MSG_CLASE_PRINCIPAL$COLOR_NORMAL"
read CLASE_PRINCIPAL

# Usar "Main" por defecto si no se ingresó nada
CLASE_PRINCIPAL=${CLASE_PRINCIPAL:-Main}

# Solicitar el nombre de la aplicación (JAR)
echo -e "$COLOR_VERDE$MSG_NOMBRE_JAR$COLOR_NORMAL"
read JAR_NAME

# Si no se ingresó un nombre, usar el nombre de la clase principal
JAR_NAME=${JAR_NAME:-$CLASE_PRINCIPAL}.jar

clear

# Crear el directorio bin si no existe
if [ ! -d "$BIN_DIR" ]; then
    mkdir -p "$BIN_DIR"
    echo -e "$COLOR_VERDEDirectorio '$BIN_DIR' creado.$COLOR_NORMAL"
fi

# Compilar los archivos .java
echo -e "$COLOR_VERDECompilando archivos Java desde '$SRC_DIR' a '$BIN_DIR'...$COLOR_NORMAL"
javac -d "$BIN_DIR" $(find "$SRC_DIR" -name "*.java")

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo -e "$COLOR_VERDE$MSG_COMPILACION_EXITOSA$COLOR_NORMAL"
else
    echo -e "$COLOR_ROJO$MSG_ERROR_COMPILACION$COLOR_NORMAL"
    exit 1
fi

# Crear el archivo MANIFEST.MF
MANIFEST_DIR="$BIN_DIR/META-INF"
MANIFEST_FILE="$MANIFEST_DIR/MANIFEST.MF"
mkdir -p "$MANIFEST_DIR"

echo -e "$COLOR_VERDECreando archivo '$MANIFEST_FILE'...$COLOR_NORMAL"
echo "Manifest-Version: 1.0" > "$MANIFEST_FILE"
echo "Main-Class: $CLASE_PRINCIPAL" >> "$MANIFEST_FILE"
echo -e "$COLOR_VERDEArchivo '$MANIFEST_FILE' creado.$COLOR_NORMAL"

# Crear el JAR
echo -e "$COLOR_VERDECreando JAR '$JAR_NAME'...$COLOR_NORMAL"
(cd "$BIN_DIR" && jar cvfm "../$JAR_NAME" "META-INF/MANIFEST.MF" .)

# Verificar si el JAR se creó correctamente
if [ -f "$JAR_NAME" ]; then
    printf "$COLOR_VERDE$MSG_CREACION_JAR_EXITOSA$COLOR_NORMAL\n" "$JAR_NAME"
else
    echo -e "$COLOR_ROJO$MSG_ERROR_CREACION_JAR$COLOR_NORMAL"
    exit 1
fi
