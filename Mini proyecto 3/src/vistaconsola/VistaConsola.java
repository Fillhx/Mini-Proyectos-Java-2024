package vistaconsola;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.Soldado;

public class VistaConsola {
    private Scanner console;
    private String[] misionesGeneral;
    private String[] misionesCapitan;
    private String[] misionesTeniente;
    private String[] misionesSoldadoRaso;

    /**
     * Constructor de la clase VistaConsola.
     * Inicializa los recursos necesarios, incluyendo las misiones asignadas a cada rango militar.
     */
    public VistaConsola() {
        this.console = new Scanner(System.in);
        // Misiones específicas asignadas al rango General.
        this.misionesGeneral = new String[] {
                "Planificar una estrategia avanzada",
                "Liderar una reunión de comandantes",
                "Revisar las fuerzas enemigas"
        };

        // Misiones específicas asignadas al rango Capitán.
        this.misionesCapitan = new String[] {
                "Supervisar la logística del equipo",
                "Coordinar las operaciones de los tenientes",
                "Ejecutar un ataque sorpresa"
        };

        // Misiones específicas asignadas al rango Teniente.
        this.misionesTeniente = new String[] {
                "Liderar una escuadra de entrenamiento",
                "Patrullar la zona asignada",
                "Preparar a las tropas para un ejercicio nocturno"
        };

        // Misiones específicas asignadas al rango Soldado Raso.
        this.misionesSoldadoRaso = new String[] {
                "Realizar patrullas de seguridad",
                "Limpiar el campo de batalla",
                "Revisar el equipo de los soldados"
        };
    }

    /**
     * Muestra el menú principal al usuario y gestiona su interacción para seleccionar una opción válida.
     *
     * @return la opción seleccionada por el usuario.
     */
    public int mostrarMenuPrincipal() {
        String opcionUsuario;
        int opcionMenu = 0;
        do {
            System.out.println("\n---------------MENU PRINCIPAL----------------\n" +
                    "\n1. Agregar soldado.\n" +
                    "2. Asignar una mision.\n" +
                    "3. Mostrar informacion.\n" +
                    "4. Regañar.\n" +
                    "5. Saludar.\n" +
                    "6. Patrullar.\n" +
                    "7. Reiniciar.\n" +
                    "8. Salir del programa.\n" +
                    "Ingrese una Opcion:");
            opcionUsuario = console.nextLine();
            if (esNumeroEntero(opcionUsuario)) {
                opcionMenu = Integer.parseInt(opcionUsuario);
                if (opcionMenu < 1 || opcionMenu > 8) {
                    System.out.println("Valor ingresado no valido.\n");
                }
            } else {
                System.out.println("Valor ingresado no valido.\n");
            }
        } while (!esNumeroEntero(opcionUsuario) || (opcionMenu < 1 || opcionMenu > 8));
        return opcionMenu;
    }

    /**
     * Solicita al usuario un valor de texto mediante un mensaje y lo devuelve.
     *
     * @param mensaje el mensaje que se muestra al usuario.
     * @return el texto ingresado por el usuario.
     */
    public String obtenerValorString(String mensaje) {
        System.out.println(mensaje);
        return console.nextLine();
    }

    /**
     * Solicita al usuario seleccionar el rango de un soldado y lo valida.
     *
     * @return el rango seleccionado en formato de texto.
     */
    public String obtenerRangoSoldado() {
        System.out.println("Ingrese el rango del soldado:\n" +
                "1. Capitán\n" +
                "2. Teniente\n" +
                "3. General\n" +
                "4. Soldado raso\n");
        String rangoSoldado = console.nextLine();
        if (esNumeroEntero(rangoSoldado)) {
            switch (rangoSoldado) {
                case "1":
                    return "Capitán";
                case "2":
                    return "Teniente";
                case "3":
                    return "General";
                case "4":
                    return "Soldado raso";
                default:
                    return obtenerRangoSoldado();
            }
        } else {
            System.out.println("Valor ingresado no valido.\n");
            return obtenerRangoSoldado();
        }
    }


    /**
     * Solicita y valida el ID único de un soldado, asegurándose de que no esté repetido.
     *
     * @param soldados Lista de soldados existentes para verificar duplicados.
     * @return El ID válido del nuevo soldado.
     */
    public String obtenerIdSoldado(ArrayList<Soldado> soldados) {
        System.out.println("Ingrese el id del soldado:");
        String idSoldado = console.nextLine();
        if (esNumeroEntero(idSoldado)) {
            for (Soldado data : soldados) {
                if (data.getId().equals(idSoldado)) {
                    System.out.println("El id del soldado ya está registrado");
                    return obtenerIdSoldado(soldados);
                }
            }
        } else {
            System.out.println("Valor ingresado no valido, debe ser un numero entero.\n");
            return obtenerIdSoldado(soldados);
        }
        return idSoldado;
    }

    /**
     * Muestra un mensaje genérico en la consola.
     *
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra la lista de soldados registrados en el sistema.
     * Si la lista está vacía, informa al usuario.
     *
     * @param soldados Lista de soldados a mostrar.
     */
    public void mostrarSoldados(ArrayList<Soldado> soldados) {
        if (soldados.isEmpty()) {
            System.out.println("No hay soldados registrados.\n");
        } else {
            for (int i = 0; i < soldados.size(); i++) {
                System.out.println((i + 1) + ". " + soldados.get(i));
            }
        }
    }

    /**
     * Permite al usuario seleccionar un soldado de la lista mediante su número en el listado.
     * Valida la entrada y maneja casos de error como valores fuera de rango o no numéricos.
     *
     * @param soldados Lista de soldados entre los cuales se hará la selección.
     * @param mensaje  Mensaje que se muestra al usuario para indicar el propósito de la selección.
     * @return El índice del soldado seleccionado, o -1 si no hay soldados registrados.
     */
    public int seleccionarSoldado(ArrayList<Soldado> soldados, String mensaje) {
        System.out.println(mensaje);
        System.out.println("Seleccione uno de los siguientes soldados (Ingrese el número que aparece al comienzo de cada fila):");
        if (soldados.isEmpty()) {
            System.out.println("No hay soldados registrados.\n");
            return -1;
        } else {
            mostrarSoldados(soldados);
            System.out.println("Ingrese el número de soldado");
            String numeroSoldado = console.nextLine();
            if (esNumeroEntero(numeroSoldado)) {
                int numeroSoldadoEntero = Integer.parseInt(numeroSoldado);
                if (numeroSoldadoEntero < 1 || numeroSoldadoEntero > soldados.size()) {
                    System.out.println("Numero de soldado no existente.\n");
                    return seleccionarSoldado(soldados, mensaje);
                } else {
                    return numeroSoldadoEntero - 1;
                }
            } else {
                System.out.println("Valor ingresado no valido.\n");
                return seleccionarSoldado(soldados, mensaje);
            }
        }
    }

    /**
     * Este método obtiene una misión específica para un soldado según su rango.
     * Permite elegir una misión de una lista predefinida de misiones para cada rango militar
     * (General, Capitán, Teniente, Soldado Raso). Además, incluye una opción para que el
     * soldado rechace la misión, lo que implica una consecuencia (desobediencia).
     *
     * @param rangoSoldado El rango del soldado que solicita la misión.
     * @return La misión asignada al soldado, o un mensaje indicando que desobedeció la orden.
     */
    public String obtenerMision(String rangoSoldado){
        String numeroMision;
        switch (rangoSoldado) {
            case "General":
                for (int i = 0; i < misionesGeneral.length; i++) {
                    System.out.println((i + 1) + ". " + misionesGeneral[i]);
                    if (i == misionesGeneral.length - 1) {
                        System.out.println((i + 2) + ". Rechazar");
                    }
                }
                System.out.println("Ingrese el numero de mision a asignar:");
                numeroMision = console.nextLine();
                if (esNumeroEntero(numeroMision)) {
                    int numeroMisionEntero = Integer.parseInt(numeroMision);
                    if(numeroMisionEntero < 1 || numeroMisionEntero > misionesGeneral.length + 1){
                        System.out.println("Numero de mision no existente.\n");
                        return obtenerMision(rangoSoldado);
                    }
                    if (numeroMisionEntero == misionesGeneral.length + 1){
                        System.out.println("¡El soldado ha desobedecido la orden! Su rango ha sido reducido.");
                        return "Desobedeció la misión.";
                    }
                    return misionesGeneral[numeroMisionEntero - 1];
                }else {
                    System.out.println("Valor ingresado no valido.\n");
                    return obtenerMision(rangoSoldado);
                }
            case "Capitán":
                for (int i = 0; i < misionesCapitan.length; i++) {
                    System.out.println((i + 1) + ". " + misionesCapitan[i]);
                    if (i == misionesGeneral.length - 1) {
                        System.out.println((i + 2) + ". Rechazar");
                    }
                }
                System.out.println("Ingrese el numero de mision a asignar:");
                numeroMision = console.nextLine();
                if (esNumeroEntero(numeroMision)) {
                    int numeroMisionEntero = Integer.parseInt(numeroMision);
                    if(numeroMisionEntero < 1 || numeroMisionEntero > misionesCapitan.length + 1){
                        System.out.println("Numero de mision no existente.\n");
                        return obtenerMision(rangoSoldado);
                    }
                    if (numeroMisionEntero == misionesCapitan.length + 1){
                        System.out.println("¡El soldado ha desobedecido la orden! Su rango ha sido reducido.");
                        return "Desobedeció la misión.";
                    }
                    return misionesCapitan[numeroMisionEntero - 1];
                }else {
                    System.out.println("Valor ingresado no valido.\n");
                    return obtenerMision(rangoSoldado);
                }
            case "Teniente":
                for (int i = 0; i < misionesTeniente.length; i++) {
                    System.out.println((i + 1) + ". " + misionesTeniente[i]);
                    if (i == misionesGeneral.length - 1) {
                        System.out.println((i + 2) + ". Rechazar");
                    }
                }
                System.out.println("Ingrese el numero de mision a asignar:");
                numeroMision = console.nextLine();
                if (esNumeroEntero(numeroMision)) {
                    int numeroMisionEntero = Integer.parseInt(numeroMision);
                    if(numeroMisionEntero < 1 || numeroMisionEntero > misionesTeniente.length + 1){
                        System.out.println("Numero de mision no existente.\n");
                        return obtenerMision(rangoSoldado);
                    }
                    if (numeroMisionEntero == misionesTeniente.length + 1){
                        System.out.println("¡El soldado ha desobedecido la orden! Su rango ha sido reducido.");
                        return "Desobedeció la misión.";
                    }
                    return misionesTeniente[numeroMisionEntero - 1];
                }else {
                    System.out.println("Valor ingresado no valido.\n");
                    return obtenerMision(rangoSoldado);
                }
            case "Soldado Raso":
                for (int i = 0; i < misionesSoldadoRaso.length; i++) {
                    System.out.println((i + 1) + ". " + misionesSoldadoRaso[i]);
                    if (i == misionesGeneral.length - 1) {
                        System.out.println((i + 2) + ". Rechazar");
                    }
                }
                System.out.println("Ingrese el numero de mision a asignar:");
                numeroMision = console.nextLine();
                if (esNumeroEntero(numeroMision)) {
                    int numeroMisionEntero = Integer.parseInt(numeroMision);
                    if(numeroMisionEntero < 1 || numeroMisionEntero > misionesSoldadoRaso.length + 1){
                        System.out.println("Numero de mision no existente.\n");
                        return obtenerMision(rangoSoldado);
                    }
                    if (numeroMisionEntero == misionesSoldadoRaso.length + 1){
                        System.out.println("¡El soldado ha desobedecido la orden! Su rango ha sido reducido.");
                        return "Desobedeció la misión.";
                    }
                    return misionesSoldadoRaso[numeroMisionEntero - 1];
                }else {
                    System.out.println("Valor ingresado no valido.\n");
                    return obtenerMision(rangoSoldado);
                }
        }
        return "";
    }

    /**
     * Este método permite regañar a un soldado, lo que reduce su nivel de desempeño.
     * Si el nivel del soldado llega a 0, se considera eliminado del batallón.
     *
     * @param soldado El objeto Soldado que será regañado.
     * @return El soldado eliminado si su nivel llega a 0, o un nuevo soldado vacío si no.
     */
    public Soldado reganiarSoldado(Soldado soldado) {
        boolean sigueActivo = soldado.reducirNivel();
        if (!sigueActivo) {
            // Notifica que el soldado ha sido eliminado.
            System.out.println("El soldado " + soldado.getNombre() + " ha sido eliminado (nivel 0).\n");
            return soldado;
        } else {
            // Notifica que el soldado ha sido regañado, indicando su nuevo nivel.
            System.out.println("El soldado " + soldado.getNombre() + " ha sido regañado. Nivel actual: " + soldado.getNivel() + ".\n");
            return new Soldado();
        }
    }

    /**
     * Este método permite saludar a un soldado según su nombre.
     * Muestra un mensaje diferente dependiendo de la longitud del nombre.
     *
     * @param nombreSoldado El nombre del soldado a saludar.
     */
    public void saludarSoldado(String nombreSoldado) {
        if (nombreSoldado.length() > 10) {
            // Muestra un mensaje especial si el nombre es muy largo.
            System.out.println("que nombre tan largoooo, hola " + nombreSoldado);
        } else {
            // Saludo normal para nombres cortos o de longitud aceptable.
            System.out.println("hola " + nombreSoldado);
        }
    }

    /**
     * Este método permite asignar una patrulla a un soldado, especificando la forma de la patrulla
     * y la zona donde se llevará a cabo. Los datos son introducidos por el usuario y se devuelve
     * una cadena con la información de la patrulla.
     *
     * @return Una descripción en texto de la patrulla, incluyendo la forma y la zona especificadas.
     */
    public String ponerPatrullarSoldado() {
        // Solicita al usuario que introduzca la forma de la patrulla.
        System.out.println("Ingrese la forma de la patrulla:");
        String formaPatrulla = console.nextLine();

        // Solicita al usuario que introduzca la zona de la patrulla.
        System.out.println("Ingrese la zona de la patrulla:");
        String zonaPatrulla = console.nextLine();

        // Devuelve una descripción de la patrulla.
        return "Patrullar - Forma: " + formaPatrulla + ", Zona: " + zonaPatrulla;
    }

    /**
     * Este método verifica si una cadena de texto representa un número entero positivo.
     * Se utiliza para validar entradas del usuario cuando se espera un valor numérico.
     *
     * @param textNumber La cadena de texto que se desea verificar.
     * @return `true` si la cadena es un número entero positivo, `false` en caso contrario.
     */
    private boolean esNumeroEntero(String textNumber) {
        // Utiliza una expresión regular para determinar si la cadena contiene solo dígitos.
        return textNumber.matches("^[0-9]+$") ? true : false;
    }
}
