import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // =====================================================
        // REGISTRO CENTRAL
        // =====================================================

        RegistroCentral registro = new RegistroCentral();

        // =====================================================
        // 1. CREAR CLIENTES
        // =====================================================

        Cliente cliente1 = new Cliente("35123456", "Juan Pérez");
        Cliente cliente2 = new Cliente("28987654", "María Gómez");

        registro.registrarCliente(cliente1);
        registro.registrarCliente(cliente2);

        // =====================================================
        // 2. CREAR SUCURSALES
        // =====================================================

        Sucursal sucursalViedma =
                new Sucursal("Sucursal Viedma", "Viedma");

        Sucursal sucursalBahia =
                new Sucursal("Sucursal Bahía Blanca", "Bahía Blanca");

        Sucursal sucursalBsAs =
                new Sucursal("Sucursal Buenos Aires", "Buenos Aires");

        registro.registrarSucursal(sucursalViedma);
        registro.registrarSucursal(sucursalBahia);
        registro.registrarSucursal(sucursalBsAs);

        // =====================================================
        // 3. CREAR PAQUETES
        // =====================================================

        Paquete p1 = new Paquete(1, "Ropa");
        Paquete p2 = new Paquete(2, "Electrónicos");
        Paquete p3 = new Paquete(3, "Libros");

        // =====================================================
        // 4. CREAR ENVÍOS
        // =====================================================

        Envio envio1 = new EnvioEstandar(101);
        envio1.agregarPaquete(p1);
        cliente1.agregarEnvio(envio1);

        Envio envio2 = new EnvioExpress(102);
        envio2.agregarPaquete(p2);
        cliente1.agregarEnvio(envio2);

        Envio envio3 = new EnvioInternacional(103);
        envio3.agregarPaquete(p1);
        envio3.agregarPaquete(p3);
        cliente2.agregarEnvio(envio3);

        registro.registrarEnvio(envio1);
        registro.registrarEnvio(envio2);
        registro.registrarEnvio(envio3);

        // =====================================================
        // 5. SIMULAR RECORRIDO POR SUCURSALES
        // =====================================================

        sucursalViedma.procesarEnvio(envio1);
        sucursalBahia.procesarEnvio(envio1);

        sucursalViedma.procesarEnvio(envio3);
        sucursalBahia.procesarEnvio(envio3);
        sucursalBsAs.procesarEnvio(envio3);

        // =====================================================
        // PRUEBA HASHMAP
        // =====================================================

        System.out.println("\n=== BUSQUEDA DE ENVIO ===");

        Envio encontrado = registro.buscarEnvio(102);

        if (encontrado != null) {
            encontrado.mostrarEnvio();
        }

        // =====================================================
        // PRUEBA BUSQUEDA SECUENCIAL
        // =====================================================

        System.out.println("\n=== BUSQUEDA DE CLIENTE ===");

        Cliente clienteBuscado =
                registro.buscarClienteSecuencial(35123456);

        if (clienteBuscado != null) {
            clienteBuscado.mostrarCliente();
        }

        // =====================================================
        // PRUEBA COLA FIFO
        // =====================================================

        System.out.println("\n=== COLA DE DESPACHO ===");

        sucursalViedma.recibirEnvio(envio1);
        sucursalViedma.recibirEnvio(envio2);
        sucursalViedma.recibirEnvio(envio3);

        sucursalViedma.despachar(2);

        // =====================================================
        // 6. JORNADA DE PROCESAMIENTO
        // =====================================================

        List<Envio> jornada = new ArrayList<>();

        jornada.add(envio1);
        jornada.add(envio2);
        jornada.add(envio3);

        System.out.println(
                "\n=== INICIO DE JORNADA Y PROCESAMIENTO ===");

        for (Envio e : jornada) {

            e.calcularCosto();
            e.iniciarEnvio();
            e.mostrarEnvio();
        }

        // =====================================================
        // FINALIZAR JORNADA
        // =====================================================

        System.out.println(
                "\n--- FINALIZANDO LA JORNADA ---");

        for (Envio e : jornada) {

            e.finalizarEnvio();
            e.mostrarEnvio();
        }

        // =====================================================
        // LISTADO DE CLIENTES
        // =====================================================

        System.out.println(
                "\n=== LISTADO DE CLIENTES ===");

        registro.listarClientes();

        // =====================================================
        // RESUMEN
        // =====================================================

        System.out.println(
                "\n=== RESUMEN DE CLIENTES ===");

        cliente1.mostrarCliente();
        cliente2.mostrarCliente();
    }
}