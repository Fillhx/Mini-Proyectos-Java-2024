public class Coronel extends Rango implements OperacionesMilitares{
    String estrategia;

    public Coronel(final int nivel, String nombre, String id, String rango, String estrategia) {
        super(nivel, nombre, id, rango);
        this.estrategia = estrategia;
    }

    @Override
    public void realizarAccion(){
        System.out.println("ACCION QUE REALIZE EL CORONEL");
        System.out.println("Coordina y asigna operaciones importantes al Capitan\n");
    }

    public String getEstrategia() {
        return estrategia;
    }

    @Override
    public void asignarMision(String mision) {
        System.out.println("\nMision asignada al Capitan: "+ mision);
    }

    @Override
    public void reportarEstado() {
        System.out.println("\nESTADO DEL CORONEL");
        System.out.println("Coronel en activo.\n");
     
    }


}
