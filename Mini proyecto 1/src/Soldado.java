public class Soldado {
    String nombre;
    String id;
    String rango;
    
    public Soldado(String nombre, String id, String rango) {
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    void mostrarInformacion(){
        System.out.println("El nombre del soldado es: "+nombre);
        System.out.println("El id del soldado es: "+id);
        System.out.println("El rango del soldado es: "+rango);
    }
}
