
import militar.misiones.OperacionesMilitares;


public class Capitan extends Rango implements OperacionesMilitares {
    int soldadosBajoSuMando;

    public Capitan(final int nivel, String nombre, String id, String rango, int soldadosBajoSuMando) {
        super(nivel, nombre, id, rango);
        this.soldadosBajoSuMando = soldadosBajoSuMando;
    }

    @Override
    public void realizarAccion() {
        System.out.println("ACCION QUE REALIZE EL CAPITAN");
        System.out.println("Ordena estrategias y misiones al teniente");
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("\nMision asignada al teniente: " + mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("\nESTADO DEL CAPITAN");
        System.out.println("Capitan en activo.\n");
    }

    public int getSoldadosBajoSuMando() {
        return soldadosBajoSuMando;
    }
}


