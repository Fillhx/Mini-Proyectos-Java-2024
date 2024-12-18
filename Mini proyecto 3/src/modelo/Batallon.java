package Modelo;

import java.util.ArrayList;

public class Batallon {
    // Lista para almacenar los objetos Soldado
    private ArrayList<Soldado> datosdesoldados;

    public Batallon(){
        this.datosdesoldados = new ArrayList<>();
    }

    // Método para obtener la lista completa de soldados
    public ArrayList<Soldado> getDatosdesoldados() {
        return datosdesoldados;
    }

    public void agregarSoldado(Soldado soldado) {
        this.datosdesoldados.add(soldado);
    }

    // Método para buscar un soldado por su ID
    public Soldado buscarSoldadoPorID(String soldadoID) {
        // Recorre la lista de soldados
        for (Soldado soldado : datosdesoldados) {
            // Si encuentra un soldado con el ID especificado, lo devuelve
            if (soldado.getId().equals(soldadoID)) {
                return soldado;
            }
        }
        // Si no encuentra el soldado, devuelve un objeto Soldado vacío
        return new Soldado();
    }

    // Método para buscar un soldado por su nombre
    public Soldado buscarSoldadoPorNombre(String nombreSoldado) {
        // Recorre la lista de soldados
        for (Soldado soldado : datosdesoldados) {
            // Si encuentra un soldado con el nombre especificado, lo devuelve
            if (soldado.getNombre().equals(nombreSoldado)) {
                return soldado;
            }
        }
        // Si no encuentra el soldado, devuelve un objeto Soldado vacío
        return new Soldado();
    }

    // Método para asignar una misión a un soldado
    public void asignarMision(String soldadoID, String mision) {
        // Recorre la lista de soldados
        for (Soldado soldado : datosdesoldados) {
            // Si encuentra un soldado con el ID especificado
            if (soldado.getId().equals(soldadoID)) {
                // Verifica si la misión es de tipo "Desobedeció la misión."
                if (mision.equals("Desobedeció la misión.")) {
                    // Si es así, reduce el nivel del soldado
                    soldado.reducirNivel();
                }
                // Asigna la misión al soldado
                soldado.setMision(mision);
            }
        }
    }
}
