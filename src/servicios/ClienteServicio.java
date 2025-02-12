package servicios;
import entidades.Cliente;
import persistencia.ClienteDAO;
public class ClienteServicio {
    private ClienteDAO cd;
    public ClienteServicio() {
        this.cd = new ClienteDAO();
    }
    public Cliente crearNuevoCliente(int codigoC, String nombre, String nombreContacto, String apellidoContacto,
        String telefono, String fax, String ciudad, String region, String pais, String codigoPostal,
        int idEmpleado, double limiteCredito) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesNyA(nombreContacto, apellidoContacto);
        Cliente cliente = new Cliente(codigoC, nombre, nombreContacto, apellidoContacto, telefono, fax, ciudad, region,
            pais, codigoPostal, idEmpleado, limiteCredito);
        cd.guardarCliente(cliente);
        return cliente;
    }
    public void validacionesNyA(String nombreContacto, String apellidoContacto) throws Exception {
        if (nombreContacto == null) {
            throw new Exception("El nombre del contacto no puede ser nulo.");
        }
        if (apellidoContacto == null) {
            throw new Exception("El apellido del contacto no puede ser nulo.");
        }

    }
    public Cliente buscarClientePorCodigoServ(int codigo) throws Exception {
        //Validación
        validacionCodigo(codigo);
        //llamo al metodo en el dao
        Cliente cliente = cd.buscarClientePorCodigo(codigo);
        validacionCliente(cliente);
        return cliente;
    }

    public void validacionCodigo(int codigo) throws Exception{
        if (codigo <=0){
            throw new Exception("El numero debe ser mayor a 0");
        }
    }
    public void validacionCliente (Cliente cliente) throws Exception {
        if (cliente == null){
            throw new Exception("No existe cliente con el código");
        }
    }     
}