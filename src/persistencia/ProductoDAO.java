package persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.miproject.entidades.Producto;

public class ProductoDAO extends DAO {
    public void guardarProducto(Producto producto) throws Exception {
        if (producto == null) {
            throw new Exception("producto no puede ser nulo");
        }
        String sql = "INSERT INTO producto (codigo_producto,nombre,id_gama,dimensiones,proveedor,descripcion,cantidad_en_stock,precio_venta,precio_proveedor) VALUES ('"
                + producto.getCodigoProducto() + "', '"
                + producto.getNombre() + "', '"
                + producto.getIdGama() + "', '"
                + producto.getDimensiones() + "', '"
                + producto.getProveedor() + "', '"
                + producto.getDescripcion() + "', '"
                + producto.getCantidadEnStock() + "', '"
                + producto.getPrecioVenta() + "', '"
                + producto.getPrecioProveedor() + "')";
        insertarModificarEliminarDataBase(sql);
    }

    public List<Producto> listarTodosLosProductos() throws Exception {
        String sql = "SELECT codigo_producto codigoProducto,nombre,id_gama idGama,dimensiones,proveedor,descripcion,cantidad_en_stock cantidadEnStock,precio_venta precioVenta,precio_proveedor precioProveedor FROM producto";
        consultarDataBase(sql);
        List<Producto> productos = new ArrayList<>();
        while (resultSet.next()) {
            Producto producto = new Producto();
            producto.setCodigoProducto(resultSet.getString("codigoProducto"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setIdGama(resultSet.getInt("idGama"));
            producto.setDimensiones(resultSet.getString("dimensiones"));
            producto.setProveedor(resultSet.getString("proveedor"));
            producto.setDescripcion(resultSet.getString("descripcion"));
            producto.setCantidadEnStock(resultSet.getInt("cantidadEnStock"));
            producto.setPrecioVenta(resultSet.getDouble("precioVenta"));
            producto.setPrecioProveedor(resultSet.getDouble("precioProveedor"));
            productos.add(producto);
        }
        return productos;
    }
    public void eliminarProductoPorId(int id) throws Exception {
        String sql = "DELETE FROM producto WHERE id_producto = " + id;
        insertarModificarEliminarDataBase(sql);
    }
}

