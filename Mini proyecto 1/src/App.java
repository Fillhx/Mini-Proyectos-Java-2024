import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su Id: ");
        String id = scanner.nextLine();
        boolean validacionCorrecta = false;
        Rango rangoObjeto = null;

        do{
            System.out.println("Cual es tu rango?\nSoldado Raso\nTeniente\nCapitan\nCoronel ");
            String rango = scanner.nextLine().toUpperCase();
            switch (rango.toUpperCase()) {

                case "SOLDADO RASO":
                    rangoObjeto = new SoldadoRaso(1,nombre, id, rango );
                    validacionCorrecta = true;
                    break;

                case "TENIENTE":
                System.out.println("Ingrese la unidad del teniente: ");
                String unidad = scanner.nextLine();
                rangoObjeto = new Teniente(2, nombre, id, rango, unidad);
                validacionCorrecta = true;
                break;

                case "CAPITAN":
                System.out.println("Ingrese la cantidad de soldados bajo su mando: ");
                int soldadosBajoSuMando = scanner.nextInt();
                rangoObjeto = new Capitan( 3, nombre, id, rango, soldadosBajoSuMando);
                validacionCorrecta = true;
                break;

                case "CORONEL":
                System.out.println("Ingrese la estrategia del coronel: ");
                String estrategia = scanner.nextLine();
                rangoObjeto = new Coronel(4, nombre, id, rango, estrategia);
                validacionCorrecta = true;
                break;

                default:
                System.out.println("Ingrese un rango correcto");
                break;
            }

        } while (!validacionCorrecta);
        
        if(rangoObjeto != null){
            System.out.println("*********************************************************");
            rangoObjeto.realizarAccion();
        
        }

        scanner.close();
    }
}
