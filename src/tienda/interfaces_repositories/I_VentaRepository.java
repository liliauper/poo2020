
package tienda.interfaces_repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tienda.entities.Venta;

public interface I_VentaRepository {
    void save(Venta venta);

    void remove(Venta venta);

    void update(Venta venta);
    
    
     List<Venta> getAll();

    default Stream<Venta> getStream() {
        return getAll().stream();
    }

    default Venta getById(int id) {
        return getStream().filter(c -> c.getId() == id).
                findAny().orElse(new Venta());
    }
    default List<Venta> getByIdCliente(int id_cliente) {
         if (id_cliente == 0) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(v -> v.getId_cliente() == id_cliente)
                .collect(Collectors.toList());
    }
   default List<Venta> getByIdUsuario(int id_usuario) {
       if (id_usuario == 0) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(v -> v.getId_usuario()== id_usuario)
                .collect(Collectors.toList());
    }
}
