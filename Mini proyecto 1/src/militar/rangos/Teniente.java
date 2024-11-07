import militar.misiones.OperacionesMilitares;


public class Teniente extends Rango implements OperacionesMilitares {
    public String unidad;

    public Teniente(final int nivel, String nombre, String id, String rango, String unidad) {
        super(nivel, nombre, id, rango);
        this.unidad = unidad;
    }

    @Override
    public void realizarAccion() {
        System.out.println("ACCION QUE REALIZE EL TENIENTE");
        System.out.println("El teniente les asigna el entretenimiento a los soldados rasos");
    }

    public String getUnidad() {
        return unidad;
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("\nMision asignada a los soldados rasos: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("\nESTADO DEL TENIENTE");
        System.out.println("Teniente en activo.\n");
    }
}
