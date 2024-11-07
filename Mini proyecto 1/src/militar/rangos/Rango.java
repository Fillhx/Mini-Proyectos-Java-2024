public abstract class Rango extends Soldado {
    public int nivel;

    public Rango(int nivel, String nombre, String id, String rango) {
        this.nivel = nivel;
        Rango.nombre = nombre;
        Rango.id = id;
        Rango.rango = rango;
    }

    public abstract void realizarAccion();

    public int getNivel() {
        return nivel;
    }

    public void mostrarInformacion() {
        System.out.print("Nombre del soldado: " + nombre + "\nEL id del soldado es: " + id + "\nEl rango del soldado es: " + rango + "\nEl nivel del soldado es: " + nivel);
    }
}
