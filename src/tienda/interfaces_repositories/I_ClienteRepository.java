package tienda.interfaces_repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tienda.entities.Cliente;

public interface I_ClienteRepository {

    void save(Cliente cliente);

    void remove(Cliente cliente);

    void update(Cliente cliente);
    
    
     List<Cliente> getAll();

    default Stream<Cliente> getStream() {
        return getAll().stream();
    }

    default Cliente getById(int id) {
        return getStream().filter(c -> c.getId() == id).
                findAny().orElse(new Cliente());
    }
    
    default Cliente getByDni_cuit(String dni_cuit){
        return getStream().filter(c->c.getDni_cuit()
                .toLowerCase().contains(dni_cuit))
                .findAny().orElse(new Cliente());
    
    
    }

    default List<Cliente> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(p -> p.getApellido()
                .toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

}
