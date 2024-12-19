## SPANISH
# Gestión de Soldados Militares (Versión Mejorada MVC)

### Descripción
Este proyecto es una mejora de un sistema anterior de gestión de soldados militares. La mejora principal consiste en implementar la arquitectura **Modelo-Vista-Controlador (MVC)** para separar las responsabilidades del código y proporcionar una interfaz gráfica de usuario (GUI) junto con la opción de interactuar a través de la consola.

---

### Funcionalidades Principales
- **Gestión de soldados y batallones**:
  - Crear, asignar y gestionar soldados.
  - Gestionar batallones militares.
- **Opciones de interfaz**:
  - **Vista gráfica (GUI)**: Interactúa con el sistema a través de ventanas.
  - **Vista consola**: Utiliza comandos y texto para interactuar.

---

### Estructura del Proyecto
1. **`Controlador`**: Lógica que conecta el modelo con las vistas.
   - Archivo principal: `Controlador.java`.

2. **`Modelo`**: Clases que representan la lógica y los datos del sistema.
   - `Batallon.java`: Gestión de batallones.
   - `Soldado.java`: Información y operaciones relacionadas con soldados.

3. **`VistaConsola`**: Interfaz basada en texto.
   - `VistaConsola.java`: Permite interactuar con el sistema mediante comandos en la terminal.

4. **`VistaGUI`**: Interfaz gráfica.
   - `AsignarMision.java`: Asigna misiones a los soldados.
   - `CrearUsuario.java`: Permite crear nuevos usuarios.
   - `Patrullar.java`: Gestiona las patrullas militares.
   - `Saludar.java`: Interacción básica.
   - `VentanaPrincipal.java`: Pantalla principal de la aplicación.

---

### Requisitos Previos
- **Java**: Versión 8 o superior.
- **IDE recomendado**: IntelliJ IDEA, Eclipse, o cualquier otro compatible con proyectos Java.
- Dependencias adicionales: Ninguna (proyecto independiente).

## Equipo de Trabajo

Universidad Del Valle 2024

| Nombre                   | Codigo       |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jorman Alexis Botero     | 2359573      |                  |
| Laura Sofia Rivera       | 2380712      |                  |



## ENGLISH
# Military Soldiers Management (Improved Version with MVC)

### Description
This project is an improvement of a previous system for managing military soldiers. The main enhancement consists of implementing the **Model-View-Controller (MVC)** architecture to separate code responsibilities and provide a graphical user interface (GUI) alongside a console-based interaction option.

---

### Main Features
- **Soldiers and battalions management**:
  - Create, assign, and manage soldiers.
  - Manage military battalions.
- **Interface options**:
  - **Graphical Interface (GUI)**: Interact with the system through windows.
  - **Console Interface**: Use text-based commands for interaction.

---

### Project Structure
1. **`Controller`**: Handles the logic connecting the model and views.
   - Main file: `Controlador.java`.

2. **`Model`**: Classes representing the system's logic and data.
   - `Batallon.java`: Manages battalions.
   - `Soldado.java`: Handles soldiers' information and operations.

3. **`ConsoleView`**: Text-based interface.
   - `VistaConsola.java`: Allows interaction with the system via terminal commands.

4. **`GUIView`**: Graphical interface.
   - `AsignarMision.java`: Assign missions to soldiers.
   - `CrearUsuario.java`: Create new users.
   - `Patrullar.java`: Manage military patrols.
   - `Saludar.java`: Basic interaction.
   - `VentanaPrincipal.java`: The main application window.

---

### Prerequisites
- **Java**: Version 8 or higher.
- **Recommended IDE**: IntelliJ IDEA, Eclipse, or any IDE compatible with Java projects.
- Additional dependencies: None (standalone project).

---

Universidad del Valle 2024

| Name                     | Code         |                  |
|--------------------------|--------------|------------------|
| Gustavo Restrepo Muñoz   | 2380618      |                  |
| Jhon Sebastian Londoño   | 2359589      |                  |
| Jorman Alexis Botero     | 2359573      |                  |
| Laura Sofia Rivera       | 2380712      |                  |

