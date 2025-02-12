package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteDAO extends DAO {
    public void guardarCliente(Cliente cliente) throws Exception {
        if(cliente == null) {
            throw new Exception("El cliente no puede ser nulo");
        }

        String sql = "INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, país, codigo_postal, id_empleado, limite_credito) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            connectarDataBase();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getCodigoCliente());
            preparedStatement.setString(2, cliente.getNombreCliente());
            preparedStatement.setString(3, cliente.getNombreContacto());
            preparedStatement.setString(4, cliente.getApellidoContacto());
            preparedStatement.setString(5, cliente.getTelefono());
            preparedStatement.setString(6, cliente.getFax());
            preparedStatement.setString(7, cliente.getCiudad());
            preparedStatement.setString(8, cliente.getRegion());
            preparedStatement.setString(9, cliente.getPais());
            preparedStatement.setString(10, cliente.getCodigoPostal());
            preparedStatement.setInt(11, cliente.getIdEmpleado());
            preparedStatement.setDouble(12, cliente.getLimiteCredito());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    public List<Cliente> listarTodosLosClientes() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, país, codigo_postal, id_empleado, limite_credito FROM cliente";

        try {
            resultSet = consultarDataBase(sql);

            while(resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(resultSet.getInt("codigo_cliente"));
                cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
                cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
                cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setFax(resultSet.getString("fax"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setRegion(resultSet.getString("region"));
                cliente.setPais(resultSet.getString("país"));
                cliente.setCodigoPostal(resultSet.getString("codigo_postal"));
                cliente.setIdEmpleado(resultSet.getInt("id_empleado"));
                cliente.setLimiteCredito(resultSet.getDouble("limite_credito"));

                clientes.add(cliente);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase();
        }

        return clientes;
    }
}
