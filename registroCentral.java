import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegistroCentral {

    private List<Cliente> clientes;
    private List<Sucursal> sucursales;
    private HashMap<Integer, Envio> envios;

    public RegistroCentral() {

        clientes = new ArrayList<>();
        sucursales = new ArrayList<>();
        envios = new HashMap<>();
    }

    // CLIENTES

    public void registrarCliente(Cliente cliente) {

        Cliente existente =
                buscarClienteSecuencial(
                        Integer.parseInt(cliente.getDni()));

        if (existente == null) {
            clientes.add(cliente);
        } else {
            System.out.println(
                    "Ya existe un cliente con DNI "
                            + cliente.getDni());
        }
    }

    public void listarClientes() {

        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
    }

    public Cliente buscarClienteSecuencial(int dni) {

        for (Cliente cliente : clientes) {

            if (Integer.parseInt(cliente.getDni()) == dni) {
                return cliente;
            }
        }

        System.out.println(
                "No existe un cliente con DNI "
                        + dni);

        return null;
    }

    // SUCURSALES

    public void registrarSucursal(Sucursal sucursal) {

        if (!sucursales.contains(sucursal)) {
            sucursales.add(sucursal);
        }
    }

    // ENVIOS

    public void registrarEnvio(Envio envio) {

        if (envios.containsKey(envio.getId())) {

            System.out.println(
                    "Ya existe un envío con código "
                            + envio.getId());

        } else {

            envios.put(
                    envio.getId(),
                    envio
            );
        }
    }

    public Envio buscarEnvio(int codigo) {

        Envio envio = envios.get(codigo);

        if (envio == null) {

            System.out.println(
                    "No existe un envío con código "
                            + codigo);
        }

        return envio;
    }
}