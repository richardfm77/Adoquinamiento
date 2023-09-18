# Adoquinamiento
Algoritmo que resuelve el problema del adoquinamiento en un tablero cuadriculado,
adoquinado con bloques en forma de *L*.

Desarrollado con *_JAVA_*.

## Pre requisitos.
**_El progarma hace uso de MAVEN 3.8.6 como empaquetador._**

* Linux.
```sh
  https://maven.apache.org/download.cgi
```
1. Abrir una terminal y ubicarse dentro del directorio programa1.
```sh
   cd programa1/
```

2. Compilar.
```sh
   mvn compile
```

## Ejecutar programa.

* Instalación del archivo **.jar**.
```sh
   mvn install
```

* Ejecución del programa.
```sh
   java -jar target/proyecto1 [k]
```

Donde *[k]* es un enetero positivo.

## Notas:

* EL programa eligé el adoquin albitrario de forma aleatoria, y es
  representado con el caracter *#* (**_Gato_**).
* Los bloques de L son representados conlos siuiguinetes caracteres: *-*, *|* y
  se puede visualizar como una *L*  de la siuiente manera:
##
|   
|-
##
*_Cosiderando todas sus rotaciones_*

* Recomendable ejuctar el programa con el parámetro *7*, para poder visualizar el patron bonito que forma :).
  
  
