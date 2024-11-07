import militar.misiones.OperacionesMilitares;


public class SoldadoRaso extends Rango implements OperacionesMilitares {
    public SoldadoRaso(final int nivel, String nombre, String id, String rango) {
        super(nivel, nombre, id, rango);
    }

    @Override
    public void realizarAccion() {
        System.out.println("ACCION QUE REALIZE EL SOLDADO RASO");
        System.out.println("El soldado Raso entrena muy duro a diario");
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("\nMision asignada: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("\nESTADO DEL SOLDADO RASO");
        System.out.println("Soldado Raso en activo.\n");
    }
}
