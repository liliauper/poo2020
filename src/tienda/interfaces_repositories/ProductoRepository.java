package tienda.interfaces_repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entities.Producto;
import tienda.enums.Disponible;

public class ProductoRepository implements I_ProductoRepository {

    private final Connection con;

    public ProductoRepository(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Producto producto) {
        if (producto == null)  return;
        
        try (PreparedStatement ps = con.prepareStatement(
                "insert into productos (cod_productos,nombre,precio,"
                        + "cantidad,imagen, descripcion, detalles,"
                        + "disponible) values (?,?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setInt(1, producto.getCod_productos());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getImagen());
            ps.setString(6, producto.getDescripcion());
            ps.setString(7, producto.getDetalles());
            ps.setString(8, producto.getDisponible().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Producto producto) {

        if (producto == null) return;
        
        try (PreparedStatement ps = con.prepareStatement("delete from productos where id=?")) {
            ps.setInt(1, producto.getId());
            ps.execute();
        
    }   catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Producto producto) {
        if (producto == null) {
            return;
        }

        String s = "update productos set cod_productos=?,nombre=?, precio=?, cantidad=?, imagen=?, descripcion=?, detalles=?,disponible=? where id=?";

        try (PreparedStatement ps = con.prepareStatement(s)) {
            ps.setInt(1, producto.getCod_productos());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getPrecio());
            ps.setInt(4, producto.getCantidad());
            ps.setString(5, producto.getImagen());
            ps.setString(6, producto.getDescripcion());
            ps.setString(7, producto.getDetalles());
            ps.setString(8, producto.getDisponible().toString());
            ps.setInt(9, producto.getId());
            ps.execute();
       
    }   catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public List<Producto> getAll() {
        List<Producto> lista = new ArrayList();
        try (ResultSet rs = con.createStatement().executeQuery("select*from productos")) {
            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getInt("cod_productos"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("imagen"),
                        rs.getString("descripcion"),
                        rs.getString("detalles"),
                        Disponible.valueOf(rs.getString("disponible")),
                        rs.getInt("visitas"),
                        rs.getInt("ventas")));
                    
            }

        } catch (SQLException ex) { 
            Logger.getLogger(ProductoRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
