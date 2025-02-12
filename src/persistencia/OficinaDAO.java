package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidades.Oficina;

public class OficinaDAO extends DAO {

    public void guardarOficina(Oficina oficina) throws Exception {
        if (oficina == null) {
            throw new Exception("La oficina no puede ser nula.");
        }

        String sql = "INSERT INTO oficina (codigo_oficina, ciudad, país, region, codigo_postal, telefono) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connectarDataBase(); // Conectar a la base de datos
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, oficina.getCodigoOficina());
            preparedStatement.setString(2, oficina.getCiudad());
            preparedStatement.setString(3, oficina.getPais());
            preparedStatement.setString(4, oficina.getRegion());
            preparedStatement.setString(5, oficina.getCodigoPostal());
            preparedStatement.setString(6, oficina.getTelefono());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarDataBase();
        }
    }

    public List<Oficina> listarTodasLasOficinas() throws Exception {
        List<Oficina> oficinas = new ArrayList<>();
        String sql = "SELECT codigo_oficina, ciudad, país, region, codigo_postal, telefono FROM oficina";

        try {
            resultSet = consultarDataBase(sql); 

            while (resultSet.next()) {
                Oficina oficina = new Oficina();
                oficina.setCodigoOficina(resultSet.getString("codigo_oficina"));
                oficina.setCiudad(resultSet.getString("ciudad"));
                oficina.setPais(resultSet.getString("país"));
                oficina.setRegion(resultSet.getString("region"));
                oficina.setCodigoPostal(resultSet.getString("codigo_postal"));
                oficina.setTelefono(resultSet.getString("telefono"));

                oficinas.add(oficina);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            desconectarDataBase();
        }

        return oficinas;
    }
}