public class Soldado {
    
    protected static String nombre;
    public static String id;
    protected static String rango;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Soldado.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        Soldado.id = id;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        Soldado.rango = rango;
    }

    public void mostrarInformacion() {
        System.out.println("El nombre del soldado es: " + nombre);
        System.out.println("El id del soldado es: " + id);
        System.out.println("El rango del soldado es: " + rango);
    }
}
