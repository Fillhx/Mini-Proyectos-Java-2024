## SPANISH

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

| Nombre                   | Codigo       |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jhorman Alexis Botero    | 2359573      |                  |


## ENGLISH

# Java Mini-Projects 2024
# Military Rank System in Java

This Java program allows a user to enter their personal information (name and ID) and select a military rank. Depending on the rank, the program requests additional information and performs a specific action related to the selected rank.

## Project Structure

The program is structured with a main class, `App`, which prompts the user for data and processes it based on their rank. The available ranks are:
- Private
- Lieutenant
- Captain
- Colonel

Each rank has a corresponding class that inherits from a base class (like `Rank`). Interface functions are also implemented, enabling multiple inheritance in the classes. Each class implements a specific behavior in the `performAction()` method.

## Prerequisites

To run this program, make sure you have:
- **Java** installed on your system (version 8 or higher).

## Usage

1. When the program is run, the user is prompted to enter their **name** and **ID**.
2. Then, the user selects their **military rank** from the following options:
    - Private
    - Lieutenant
    - Captain
    - Colonel

3. Depending on the selected rank, additional data is requested:
   - **Private**: No additional information is requested.
   - **Lieutenant**: The **unit** to which they belong is requested.
   - **Captain**: The **number of soldiers under their command** is requested.
   - **Colonel**: The **colonel's strategy** is requested.

4. After entering the information, the program executes a specific action according to the rank.

## Team

Universidad del Valle 2024

| Full Name                | Code         |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jhorman Alexis Botero    | 2359573      |                  |
