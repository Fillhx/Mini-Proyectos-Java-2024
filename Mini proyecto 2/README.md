## SPANISH
# Sistema de Gestión de Soldados - Java

Este programa en Java permite gestionar una lista de soldados y realizar diversas acciones sobre ellos, como saludarlos, asignarles misiones, patrullar, y más. La interfaz gráfica permite agregar soldados, ver sus detalles, y ejecutar acciones específicas basadas en su selección.

## Funcionalidades

1. *Agregar Soldados*: Permite agregar nuevos soldados a la lista, solicitando su nombre e ID.
2. *Acciones sobre Soldados*: Una vez agregados los soldados, se pueden realizar varias acciones:
   - *Saludar*: Saluda a los soldados seleccionados y muestra un mensaje personalizado.
   - *Regañar*: Regaña a los soldados seleccionados y reduce su nivel.
   - *Patrullar*: Asigna la acción de patrullar a los soldados seleccionados.
   - *Mostrar Información*: Muestra los detalles de los soldados registrados.

## Estructura del Proyecto

El proyecto está estructurado en varias clases que permiten gestionar y visualizar la información de los soldados, así como ejecutar las diferentes acciones. La clase principal es App, que gestiona la interfaz gráfica y la interacción del usuario. Otras clases implementan acciones específicas, como Saludar, AsignarMision, Patrullar, etc.

### Clases principales:
- *App.java*: Clase principal que gestiona la interfaz gráfica, las acciones de los botones y el almacenamiento de los soldados.
- *Soldado.java*: Clase que define el objeto Soldado, con sus atributos como nombre, ID, y nivel. Incluye métodos para regañar al soldado y reducir su nivel.
- *Saludar.java*: Clase que gestiona la acción de saludar a los soldados y muestra un mensaje en la interfaz gráfica.
- *Patrullar.java*: Clase que asigna la acción de patrullar a los soldados seleccionados.

## Requisitos Previos

Para ejecutar este programa, asegúrate de tener:
- *Java* instalado en tu sistema (versión 8 o superior).
- *IDE* de tu preferencia para compilar y ejecutar el código (por ejemplo, IntelliJ IDEA, Eclipse, NetBeans).

## Equipo de Trabajo

Universidad Del Valle 2024

| Nombre                   | Codigo       |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jorman Alexis Botero     | 2359573      |                  |
| Laura Sofia Rivera       | 2380712      |                  |



## ENGLISH

# Military Rank Management System - Java

This Java program allows a user to input their personal information (name and ID) and select a military rank. Depending on the selected rank, the program requests additional information and performs a specific action related to the chosen rank.

## Features

1. *Add Soldiers*: Allows the user to add new soldiers to the list by entering their name and ID.
2. *Actions on Soldiers*: After adding soldiers, several actions can be performed on them:
   - *Greet*: Greets the selected soldiers and displays a personalized message.
   - *Reprimand*: Reprimands the selected soldiers and reduces their level.
   - *Patrol*: Assigns the selected soldiers to patrol.
   - *Show Information*: Displays the details of the registered soldiers.

## Project Structure

The project is structured in several classes that manage and display soldier information, as well as execute different actions. The main class is App, which handles the graphical interface and user interaction. Other classes implement specific actions such as Saludar, AsignarMision, Patrullar, etc.

### Main Classes:
- *App.java*: Main class that manages the graphical interface, button actions, and soldier storage.
- *Soldado.java*: Class defining the Soldado object, with attributes such as name, ID, and level. Includes methods to reprimand the soldier and reduce their level.
- *Saludar.java*: Class managing the greet action for the soldiers and displaying a message in the graphical interface.
- *Patrullar.java*: Class assigning the patrol action to the selected soldiers.

## Prerequisites

To run this program, make sure you have:
- *Java* installed on your system (version 8 or higher).
- *IDE* of your choice for compiling and running the code (e.g., IntelliJ IDEA, Eclipse, NetBeans).

| Name                     | Code         |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jorman Alexis Botero     | 2359573      |                  |
| Laura Sofia Rivera       | 2380712      |                  |
