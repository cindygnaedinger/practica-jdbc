import entidades.Cliente;
// import entidades.Oficina;
import persistencia.ClienteDAO;
// import persistencia.OficinaDAO;
import servicios.ClienteServicio;

public class App {
    public static void main(String[] args) {
        // try {
        //     OficinaDAO oficinaDAO = new OficinaDAO();

        //     Oficina oficina = new Oficina(
        //         "OF001", 
        //         "Córdoba", 
        //         "Argentina", 
        //         "Centro", 
        //         "5000", 
        //         "543516525451"
        //     );

        //     oficinaDAO.guardarOficina(oficina);
        //     System.out.println("Oficina guardada correctamente.");

        //     System.out.println("Listado de oficinas:");
        //     oficinaDAO.listarTodasLasOficinas().forEach(System.out::println);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Error: " + e.getMessage());
        // }
        // try{
        //     ClienteDAO clienteDAO = new ClienteDAO();
        //     Cliente cliente = new Cliente(
        //         236,
        //         "Juan Perez",
        //         "Cindy",
        //         "Gnaedinger",
        //         "5462495874",
        //         "9568748",
        //         "Córdoba",
        //         "Centro",
        //         "Argentina",
        //         "5000",
        //         9, 
        //         1000.00
        //     );
        //     clienteDAO.guardarCliente(cliente);
        //     System.out.println("Cliente guardado correctamente.");

        //     System.out.println("Listado de clientes:");
        //     clienteDAO.listarTodosLosClientes().forEach(System.out::println);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Error: " + e.getMessage());
        // } 
        try {
            ClienteServicio clienteServicio = new ClienteServicio();
            Cliente nuevoCliente = clienteServicio.crearNuevoCliente(
                30, "Empresa X", "Juan", "Pérez", "123456789",
                "987654321", "Ciudad A", "Región B", "País C",
                "45678", 1, 5000.00
            );
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// SELECT CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME, REFERENCED_TABLE_NAME, REFERENCED_COLUMN_NAME
// FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
// WHERE TABLE_NAME = 'detalle_pedido'
//   AND COLUMN_NAME = 'id_producto'
//   AND REFERENCED_TABLE_NAME IS NOT NULL;
// ----------------------------
  
// ALTER TABLE detalle_pedido DROP FOREIGN KEY detalle_pedido_ibfk_2;

// ALTER TABLE detalle_pedido
// ADD CONSTRAINT fk_detalle_pedido_producto
// FOREIGN KEY (id_producto)
// REFERENCES producto (id_producto)
// ON DELETE CASCADE;