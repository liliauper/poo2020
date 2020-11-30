package tienda.interfaces_repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entities.Usuario;
import tienda.enums.TipoUsuario;
import tienda.interfaces_repositories.I_UsuarioRepository;

public class UsuarioRepository implements I_UsuarioRepository {

    private final Connection con;

    public UsuarioRepository(Connection con) {
        this.con = con;
    }
    
    

    @Override
    public void save(Usuario usuario) {

        if (usuario == null) {
            return;
        }

        String s = "insert into usuarios (nombre, apellido, mail,contrasenia,tipoUsuario) values(?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(
                s,
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getMail());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getTipoUsuario().toString());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId(rs.getInt(1));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void remove(Usuario usuario) {
        if (usuario == null) {
            return;
        }

        try (PreparedStatement ps = con.prepareStatement("delete from usuarios where id=?")) {
            ps.setInt(1, usuario.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Usuario usuario) {
        if (usuario == null) {
            return;
        }
        String s = "update usuarios set nombre=?, apellido=?, mail=?, contrasenia=?,tipoUsuario=? where id =?";

        try (PreparedStatement ps = con.prepareStatement(s)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getMail());
            ps.setString(4, usuario.getContrasenia());
            ps.setString(5, usuario.getTipoUsuario().toString());
            ps.setInt(6, usuario.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList();
        try (ResultSet rs = con.createStatement()
                .executeQuery("select*from usuarios")) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("mail"),
                        rs.getString("contrasenia"),
                        TipoUsuario.valueOf(rs.getString("tipoUsuario"))
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
    

}
