#!/bin/bash

# Configuración de las carpetas
BIN_DIR="bin"

# Solicitar el nombre completo de la clase principal
echo "Ingresa el nombre completo de la clase principal (por ejemplo, 'com.miapp.Main'):"
read CLASE_PRINCIPAL
clear

# Ejecutar el programa con opciones de renderización de fuentes y escalabilidad
echo "Ejecutando '$CLASE_PRINCIPAL' desde '$BIN_DIR'..."
echo "***************************************************"
echo "***************************************************"
echo "                                                   "
java -Dawt.useSystemAAFontSettings=on -Dswing.aatext=true -Dsun.java2d.uiScale=1 -cp "$BIN_DIR" "$CLASE_PRINCIPAL"

echo "                                                   "
echo "***************************************************"
echo "***************************************************"
echo "                                                   "
# Verificar si la ejecución fue exitosa
if [ $? -eq 0 ]; then
    echo "Ejecución completada con éxito."
else
    echo "Error durante la ejecución."
    exit 1
fi
