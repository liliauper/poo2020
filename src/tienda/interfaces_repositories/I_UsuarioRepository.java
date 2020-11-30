
package tienda.interfaces_repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tienda.entities.Usuario;


public interface I_UsuarioRepository {
    void save(Usuario usuario);

    void remove(Usuario usuario);

    void update(Usuario usuario);
    
    
     List<Usuario> getAll();

    default Stream<Usuario> getStream() {
        return getAll().stream();
    }

    default Usuario getById(int id) {
        return getStream().filter(u -> u.getId() == id).
                findAny().orElse(new Usuario());
    }
    default Usuario getByMail(String mail) {
        return getStream().filter(u -> u.getMail().equals(mail)).
                findAny().orElse(new Usuario());
    }
     default List<Usuario> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(u -> u.getApellido()
                .toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    
}
