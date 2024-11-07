# Mini-Proyectos-Java-2024
# Sistema de Rango Militar en Java

Este programa en Java permite a un usuario ingresar su información personal (nombre e ID) y seleccionar un rango militar. Dependiendo del rango, el programa solicita información adicional y realiza una acción específica relacionada con el rango seleccionado.

## Estructura del Proyecto

El programa se estructura con una clase principal `App` que solicita los datos al usuario y los procesa en base a su rango. Los rangos disponibles son:
- Soldado Raso
- Teniente
- Capitán
- Coronel

Cada rango tiene una clase correspondiente que hereda de una clase base (como `Rango`). Además, se implementan funciones de interfaz, generando así una herencia múltiple en las clases. Cada clase implementa un comportamiento específico en el método `realizarAccion()`.

## Requisitos Previos

Para ejecutar este programa, asegúrate de tener:
- **Java** instalado en tu sistema (versión 8 o superior).

## Uso

1. Cuando se ejecuta el programa, se solicita al usuario que ingrese su **nombre** e **ID**.
2. Luego, el usuario debe seleccionar su **rango militar** de entre las opciones:
    - Soldado Raso
    - Teniente
    - Capitán
    - Coronel

3. Dependiendo del rango seleccionado, se solicitarán datos :
   - **Soldado Raso**: No se solicita información adicional.
   - **Teniente**: Se solicita ingresar la **unidad** a la que pertenece.
   - **Capitán**: Se solicita ingresar la **cantidad de soldados bajo su mando**.
   - **Coronel**: Se solicita ingresar la **estrategia** del coronel.

4. Tras ingresar la información, el programa ejecuta una acción específica según el rango.

## Equipo de Trabajo

Universidad Del Valle 2024

|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jhorman Alexis Botero    | 2359573      |                  |


ccc