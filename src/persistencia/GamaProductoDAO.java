package persistencia;
import java.util.ArrayList;
import java.util.List;

import entidades.GamaProducto;

public class GamaProductoDAO extends DAO {

    public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
        connectarDataBase();
        if (gamaProducto == null) {
            throw new Exception("La gama de productos no puede ser nula");
        }
        String sql = "INSERT INTO gama_producto (gama,descripcion_texto,descripcion_html,imagen) VALUES ('"

                + gamaProducto.getGama() + "', '"
                + gamaProducto.getDescripcionTexto() + "', '"
                + gamaProducto.getDescripcionHTML() + "', '"
                + gamaProducto.getImagen() + "')";

        insertarModificarEliminarDataBase(sql);
        
        System.out.println("Gama de producto agregada exitosamente!");
        desconectarDataBase();
    }

    public List<GamaProducto> listarTodasLasGamaProducto() throws Exception {
        connectarDataBase();
        String sql = "SELECT * FROM gama_producto";
        consultarDataBase(sql);
        List<GamaProducto> gamas = new ArrayList<>();
        while (resultSet.next()) {
            GamaProducto gamaProducto = new GamaProducto();
            gamaProducto.setIdGama(resultSet.getInt("id_gama"));
            gamaProducto.setGama(resultSet.getString("gama"));
            gamaProducto.setDescripcionTexto(resultSet.getString("descripcion_texto"));
            gamaProducto.setDescripcionHTML(resultSet.getString("descripcion_html"));
            gamaProducto.setImagen(resultSet.getString("imagen"));
            gamas.add(gamaProducto);
        }
        desconectarDataBase();
        return gamas;
        
    }

    public void eliminarGamaProductoPorId(int id) throws Exception {
        connectarDataBase();
        String sql = "DELETE FROM gama_producto WHERE id_gama = " + id;
        insertarModificarEliminarDataBase(sql);

        System.out.println("Gama de producto eliminado exitosamente!");
        desconectarDataBase();
    }
}

