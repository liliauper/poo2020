package tienda.interfaces_repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entities.Cliente;

/**
 *
 * @author lilia
 */
public class ClienteRepository implements I_ClienteRepository {

    private final Connection con;

    public ClienteRepository(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Cliente cliente) {
        if (cliente == null) {
            return;
        }
        try (PreparedStatement ps = con.prepareStatement(
                "Insert into clientes (nombre, apellido, dni_cuit,"
                + "pais, provincia, direccion,"
                + "telefono, mail,fechaNacimiento, "
                + "contrasenia) values(?,?,?,?,?,?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni_cuit());
            ps.setString(4, cliente.getPais());
            ps.setString(5, cliente.getProvincia());
            ps.setString(6, cliente.getDireccion());
         
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getMail());
            ps.setString(9, cliente.getFechaNacimiento());

            ps.setString(10, cliente.getContrasenia());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Cliente cliente) {
         if (cliente == null) return;
        
        try (PreparedStatement ps = con.prepareStatement("delete from clientes where id=?")) {
            ps.setInt(1, cliente.getId());
            ps.execute();
        
    }   catch (SQLException ex) { 
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void update(Cliente cliente) {
        
        if(cliente==null)return;
        String s = "update clientes set nombre=?, apellido=?, dni_cuit=?,"
                + "pais=?,provincia=?,direccion=?,"
                + "telefono=?, mail=?,fechaNacimiento=?,"
                + "contrasenia=? where id=?";
        try(PreparedStatement ps = con.prepareStatement(s)){
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni_cuit());
            ps.setString(4, cliente.getPais());
            ps.setString(5, cliente.getProvincia());
            ps.setString(6, cliente.getDireccion());
          
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getMail());
            ps.setString(9, cliente.getFechaNacimiento());
           
            ps.setString(10, cliente.getContrasenia());
            ps.setInt(11, cliente.getId());
            ps.execute();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> lista = new ArrayList();
        try (ResultSet rs = con.createStatement().executeQuery("select*from clientes")) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni_cuit"),
                        rs.getString("pais"),
                        rs.getString("provincia"),
                        rs.getString("direccion"),
                      
                        rs.getString("telefono"),
                        rs.getString("mail"),
                        rs.getString("fechaNacimiento"),
                       
                        rs.getString("contrasenia")));

            }

        } catch (SQLException ex) { 
            Logger.getLogger(ClienteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;

    }

}
