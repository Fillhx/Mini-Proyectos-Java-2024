package Modelo;

// Definición de la clase Soldado, que representa a un soldado con atributos básicos como nombre, rango, ID, misión y nivel.
public class Soldado {
    // Nombre del soldado.
    private String nombre;

    // Rango del soldado (ejemplo: General, Capitán, etc.).
    private String rango;

    // Identificador único del soldado. Es final porque no debe cambiar después de ser asignado.
    private final String id;

    // Misión asignada al soldado. Por defecto, se inicializa como "Sin misión asignada".
    private String mision;

    // Nivel del soldado, que varía según su rango.
    int nivel;

    // Constructor principal que inicializa todos los atributos de un soldado.
    public Soldado(String nombre, String rango, String id) {
        this.nombre = nombre; // Asigna el nombre.
        this.rango = rango;   // Asigna el rango.
        this.id = id;         // Asigna el identificador único.
        this.mision = "Sin misión asignada"; // Misión predeterminada.
        this.nivel = determinarNivelInicial(rango); // Determina el nivel inicial basado en el rango.
    }

    // Constructor predeterminado que crea un soldado con un ID inválido (-1).
    // Útil para retornar un objeto nulo en búsquedas fallidas.
    public Soldado() {
        this.id = "-1"; // ID inválido como valor predeterminado.
    }

    // Getter para obtener el nombre del soldado.
    public String getNombre() {
        return nombre;
    }

    // Getter para obtener el rango del soldado.
    public String getRango() {
        return rango;
    }

    // Getter para obtener el identificador único del soldado.
    public String getId() {
        return id;
    }

    // Setter para asignar o actualizar la misión del soldado.
    public void setMision(String mision) {
        this.mision = mision;
    }

    // Método para determinar el nivel inicial del soldado según su rango.
    // Se asignan valores numéricos más altos a rangos más importantes.
    public int determinarNivelInicial(String rango) {
        switch (rango) {
            case "General":
                return 5; // Nivel máximo.
            case "Capitán":
                return 4;
            case "Teniente":
                return 3;
            case "Soldado Raso":
                return 2; // Nivel básico.
            default:
                return 1; // Nivel mínimo para rangos no especificados.
        }
    }

    // Método que reduce el nivel del soldado y degrada su rango si es necesario.
    public boolean reducirNivel() {
        nivel--; // Disminuye el nivel.
        if (nivel <= 0) {
            return false; // Retorna false si el nivel es menor o igual a 0 (soldado debe ser eliminado).
        }

        // Actualiza el rango según el nivel restante.
        if (nivel == 4) {
            rango = "Capitán";
        } else if (nivel == 3) {
            rango = "Teniente";
        } else if (nivel == 2) {
            rango = "Soldado Raso";
        }
        return true; // Retorna true si el soldado sigue activo.
    }

    // Getter para obtener el nivel actual del soldado.
    public int getNivel() {
        return nivel;
    }

    // Sobrescribe el método toString para proporcionar una representación legible del objeto Soldado.
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Rango: " + rango + ", ID: " + id + ", Nivel: " + nivel + ", Misión: " + mision;
    }
}