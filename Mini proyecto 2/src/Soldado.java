public class Soldado {
    String nombre;
    String rango;
    String id;
    String mision;
    int nivel;

    public Soldado(String nombre, String rango, String id) {
        this.nombre = nombre;
        this.rango = rango;
        this.id = id;
        this.mision = "Sin misión asignada";
        this.nivel = determinarNivelInicial(rango);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRango() {
        return rango;
    }

    public String getId() {
        return id;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int determinarNivelInicial(String rango) {
        switch (rango) {
            case "General":
                return 5;
            case "Capitán":
                return 4;
            case "Teniente":
                return 3;
            case "Soldado Raso":
                return 2;
            default:
                return 1;
        }
    }

    // Reducir nivel y degradar rango si es necesario
    public boolean reducirNivel() {
        nivel--;
        if (nivel <= 0) {
            return false; // Indica que el soldado debe ser eliminado
        }

        // Degradar rango si el nivel baja
        if (nivel == 4) {
            rango = "Capitán";
        } else if (nivel == 3) {
            rango = "Teniente";
        } else if (nivel == 2) {
            rango = "Soldado Raso";
        }
        return true;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Rango: " + rango + ", ID: " + id + ", Nivel: " + nivel + ", Misión: " + mision;
    }
}