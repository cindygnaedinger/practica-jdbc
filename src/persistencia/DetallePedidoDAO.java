package persistencia;
import java.util.ArrayList;
import java.util.List;
import entidades.DetallePedido;

public class DetallePedidoDAO extends DAO {

    public void guardarDetallePedido(DetallePedido detallePedido) throws Exception {
        if (detallePedido == null) {
            throw new Exception("El detalle del pedido no puede ser nulo");
        }
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unidad, numero_linea) VALUES ('"
                + detallePedido.getIdPedido() + "', '"
                + detallePedido.getIdProducto() + "', '"
                + detallePedido.getCantidad() + "', '"
                + detallePedido.getPrecioUnidad() + "', '"
                + detallePedido.getNumero_linea() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<DetallePedido> listarTodosLosDetalleDePedidos() throws Exception {
        String sql = "SELECT * FROM detalle_pedido";
        consultarDataBase(sql);
        List<DetallePedido> detallesDePedidos = new ArrayList<>();
        while (resultSet.next()) {
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setIdDetallePedido(resultSet.getInt("id_detalle_pedido"));
            detallePedido.setIdPedido(resultSet.getInt("id_pedido"));
            detallePedido.setIdProducto(resultSet.getInt("id_producto"));
            detallePedido.setCantidad(resultSet.getInt("cantidad"));
            detallePedido.setPrecioUnidad(resultSet.getDouble("precio_unidad"));
            detallePedido.setNumero_linea(resultSet.getShort("numero_linea"));
            detallesDePedidos.add(detallePedido);
        }
        return detallesDePedidos;
    }

    public void eliminarDetallePedidoPorId(int id) throws Exception {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle_pedido = " + id;
        insertarModificarEliminarDataBase(sql);
        }

}

