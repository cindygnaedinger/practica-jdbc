package persistencia;
import entidades.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO extends DAO {
    
    public void insertarEmpleado(Empleado empleado) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO empleado (codigo_empleado, nombre, apellido, extension, email, id_oficina, id_jefe, puesto) VALUES ("
                   + empleado.getCodigo_empleado() + ", '"
                   + empleado.getNombre() + "', '"
                   + empleado.getApellido() + "', '"
                   + empleado.getExtension() + "', '"
                   + empleado.getEmail() + "', "
                   + empleado.getId_oficina() + ", "
                   + empleado.getId_jefe() + ", '"
                   + empleado.getPuesto() + "')";
        insertarModificarEliminarDataBase(sql);
    } 

    public Empleado buscarEmpleadoPorId(int idEmpleado) throws SQLException, ClassNotFoundException {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE id_empleado = " + idEmpleado;
        consultarDataBase(sql);

        if (resultSet.next()) {
            empleado = new Empleado();
            empleado.setCodigo_empleado(resultSet.getInt("codigo_empleado"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellido(resultSet.getString("apellido"));
            empleado.setExtension(resultSet.getString("extension"));
            empleado.setEmail(resultSet.getString("email"));
            empleado.setId_oficina(resultSet.getInt("id_oficina"));
            empleado.setId_jefe(resultSet.getInt("id_jefe"));
            empleado.setPuesto(resultSet.getString("puesto"));
        }
        desconectarDataBase();
        return empleado;
    }

    public List<Empleado> listarEmpleados() throws SQLException, ClassNotFoundException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";
        consultarDataBase(sql);
        while (resultSet.next()) {
            Empleado empleado = new Empleado();
            empleado.setCodigo_empleado(resultSet.getInt("codigo_empleado"));
            empleado.setNombre(resultSet.getString("nombre"));
            empleado.setApellido(resultSet.getString("apellido"));
            empleado.setExtension(resultSet.getString("extension"));
            empleado.setEmail(resultSet.getString("email"));
            empleado.setId_oficina(resultSet.getInt("id_oficina"));
            empleado.setId_jefe(resultSet.getInt("id_jefe"));
            empleado.setPuesto(resultSet.getString("puesto"));
            lista.add(empleado);
        }
        desconectarDataBase();
        return lista;
    }

    public void actualizarEmpleado(Empleado empleado) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE empleado SET codigo_empleado = " + empleado.getCodigo_empleado()
                   + ", nombre = '" + empleado.getNombre()
                   + "', apellido = '" + empleado.getApellido()
                   + "', extension = '" + empleado.getExtension()
                   + "', email = '" + empleado.getEmail()
                   + "', id_oficina = " + empleado.getId_oficina()
                   + ", id_jefe = " + empleado.getId_jefe()
                   + ", puesto = '" + empleado.getPuesto()
                   + "' WHERE id_empleado = " + empleado.getId_empleado();
        insertarModificarEliminarDataBase(sql);
    }

    public void eliminarEmpleado(int idEmpleado) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM empleado WHERE id_empleado = " + idEmpleado;
        insertarModificarEliminarDataBase(sql);
    }
}
