import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su Id: ");
        String id = scanner.nextLine();
        System.out.println("Ingrese su Rango: ");
        String rango = scanner.nextLine();
        scanner.close();
    }
}
