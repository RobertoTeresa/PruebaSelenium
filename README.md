# DIARIO AS - APPIUM (MOVILIDAD)

## [Resultado de la última ejecución](https://hiberus-prisa-qa-devops.github.io/qa-as-appium/)

Enlace para acceder a los reportes que ha generado Allure. Por defecto, se visualiza el reporte de la ultima ejecución lanzada. Para poder comprobar las ejecuciones anteriores pulsar sobre cualquier pico del gráfico que aparece en el lado derecho del reporte. 
Configuración: Guardar los últimos 10 reportes.

## Descripción

Este repositorio contiene un proyecto Appium para automatizar los casos de uso de Diario AS en movilidad. ¿Qué es Appium? Appium es una herramienta open-source de control de calidad para automatizar y ejecutar pruebas funcionales y de regresión sobre una aplicación. Para más información consultar la documentación de Confluence.

Los casos han sido solicitados por el equipo de PRISA y se están lanzando sobre la aplicacion de AS en produccion. El plan de pruebas con todos los casos y sus respectivos casos se pueden encontrar documentados en Confluence.
Tambien se pueden consultar los casos dentro de los archivos Cucumber ubicados en la siguiente ruta del proyecto:

```
src/test/resources/features/
```

## Documentación

- [Plan de pruebas de TestLink en Confluence](https://confluence.t-prisa.com/display/QADEVOPS/4.6.3.1.1.+AS)
- [Glosario de términos en Confluence](https://confluence.t-prisa.com/pages/viewpage.action?pageId=123149100)

## Workflow

El proyecto corre sobre un sistema operativo `macos-latest` y la batería de pruebas se lanza sobre un dispositivo Android. La ejecucion genera los siguientes reportes

- Allure: Genera un reporte web de alto nivel y trazabilidad, lo almacena en un artefacto y lo despliega en una página de Github. 
- HTML de ExtentReports: Genera un simple archivo .html y lo almacena en un artefacto. 
- PDF de ExtentReports: Genera un archivo .pdf y lo almacena en un artefacto. 
- Grabacion de la ejecucion: Genera un archivo de video de cada caso y lo almacena en un artefacto.


## Ruta de los artefactos

Para poder comprobar los artefactos generados durante el workflow hay que acceder a la propia ejecución. Para ello podemos seguir los siguientes pasos:

1. Acceder a la pestaña de `Actions`
2. En el menú de la izquierda seleccionar el workflow `Appium Android`
3. Seleccionar la ejecución deseada
4. Bajar hasta el fondo de la página al apartado `Artifacts`
5. Pulsar sobre el artefacto deseado 
6. Una vez descargado, descomprimir el archivo .zip

## Tecnologías utilizadas

- Herramienta: Appium
- IDE: IntelIJ
- Compilación: Maven
- Lenguaje: Java
- Framework: TestNG
- BDD: Cucumber 7
- Reporte: Allure & ExtentReports


## Comando para ejecutar Appium

```sh
mvn clean test
```

- Especificando una etiqueta de cucumber para ejecutar solo ciertos casos (portada, articulo, publicidad, AUT-1)

```sh
mvn clean test -Dcucumber.filter.tags='@<etiqueta>'
```
#   P r u e b a S e l e n i u m  
 