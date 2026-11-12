import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String dni;
    private String nombre;
    private List<Envio> envios;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.envios = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        if (!envios.contains(envio)) {
            envios.add(envio);
            envio.setCliente(this);
        }
    }

    public void mostrarCliente() {
        System.out.println("Cliente: " + nombre + " (DNI: " + dni + ")");
        System.out.println("Envíos realizados: " + envios.size());
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public List<Envio> getEnvios() {
        return envios;
    }
}