import java.util.LinkedList;
import java.util.Queue;

public class Sucursal {

    private String nombre;
    private String ciudad;

    private Queue<Envio> colaDespacho;

    public Sucursal(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.colaDespacho = new LinkedList<>();
    }

    public void procesarEnvio(Envio envio) {
        System.out.println("Sucursal " + nombre +
                " (" + ciudad + ") procesando envío ID: " +
                envio.getId());

        envio.registrarPasoSucursal(this);
    }

    public void recibirEnvio(Envio envio) {

        colaDespacho.offer(envio);

        System.out.println(
                "Envío " + envio.getId() +
                " agregado a la cola de " + nombre);
    }

    public void despachar(int cantidad) {

        if (colaDespacho.isEmpty()) {
            System.out.println("No hay envíos para despachar.");
            return;
        }

        int enviados = 0;

        while (!colaDespacho.isEmpty() &&
                enviados < cantidad) {

            Envio envio = colaDespacho.poll();

            System.out.println(
                    "Despachando envío " +
                    envio.getId());

            enviados++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }
}