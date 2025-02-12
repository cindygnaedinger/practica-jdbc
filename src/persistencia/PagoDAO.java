package persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Pago;

import java.sql.Date;

public class PagoDAO extends DAO {

    public void insertarPago(Pago pago) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO pago (id_cliente, forma_pago, id_transaccion, fecha_pago, total) VALUES ("
                   + pago.getId_cliente() + ", '"
                   + pago.getForma_pago() + "', '"
                   + pago.getId_transaccion() + "', '"
                   + Date.valueOf(pago.getFecha_pago()) + "', "
                   + pago.getTotal() + ")";
        insertarModificarEliminarDataBase(sql);
    }

    public Pago buscarPagoPorId(int idPago) throws SQLException, ClassNotFoundException {
        Pago pago = null;
        String sql = "SELECT * FROM pago WHERE id_pago = " + idPago;
        consultarDataBase(sql);
        if (resultSet != null && resultSet.next()) {
            pago = new Pago();
            pago.setId_cliente(resultSet.getInt("id_cliente"));
            pago.setForma_pago(resultSet.getString("forma_pago"));
            pago.setId_transaccion(resultSet.getString("id_transaccion"));
            pago.setFecha_pago(resultSet.getDate("fecha_pago").toLocalDate());
            pago.setTotal(resultSet.getDouble("total"));
        }
        desconectarDataBase();
        return pago;
    }

    public List<Pago> listarPagos() throws SQLException, ClassNotFoundException {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago";
        consultarDataBase(sql);
        while (resultSet != null && resultSet.next()) {
            Pago pago = new Pago();
            pago.setId_cliente(resultSet.getInt("id_cliente"));
            pago.setForma_pago(resultSet.getString("forma_pago"));
            pago.setId_transaccion(resultSet.getString("id_transaccion"));
            pago.setFecha_pago(resultSet.getDate("fecha_pago").toLocalDate());
            pago.setTotal(resultSet.getDouble("total"));
            lista.add(pago);
        }
        desconectarDataBase();
        return lista;
    }

    public void actualizarPago(Pago pago) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE pago SET id_cliente = " + pago.getId_cliente()
                   + ", forma_pago = '" + pago.getForma_pago()
                   + "', id_transaccion = '" + pago.getId_transaccion()
                   + "', fecha_pago = '" + Date.valueOf(pago.getFecha_pago())
                   + "', total = " + pago.getTotal()
                   + " WHERE id_pago = " + pago.getId_pago();
        insertarModificarEliminarDataBase(sql);
    }

    public void eliminarPago(int idPago) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM pago WHERE id_pago = " + idPago;
        insertarModificarEliminarDataBase(sql);
    }
}

