package tienda.interfaces_repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tienda.entities.Producto;

public interface I_ProductoRepository {

    void save(Producto producto);

    void remove(Producto producto);

    void update(Producto producto);

    List<Producto> getAll();

    default Stream<Producto> getStream() {
        return getAll().stream();
    }

    default Producto getById(int id) {
        return getStream().filter(p -> p.getId() == id).
                findAny().orElse(new Producto());
    }

    default Producto getByCodigo(int cod_productos) {
        return getStream()
                .filter(p -> p.getCod_productos() == cod_productos)
                .findAny().orElse(new Producto());
    }

    default List<Producto> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<>();
        }
        return getStream()
                .filter(p -> p.getNombre()
                .toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Producto> getLikeColor(String color) {
        if (color == null) {
            return new ArrayList<>();
        }
        
//        FILTER()
//        for p in getStream()
//            if (p->)
//                r.add (p)
        return getStream()
                .filter(p -> p.getDescripcion() != null && p.getDescripcion().toLowerCase().contains(color.toLowerCase()))
                .collect(Collectors.toList());

    }

    default List<Producto> getLikeOcacion(String ocasion) {
        if (ocasion == null) {
            return new ArrayList<>();
        }

        return getStream()
                .filter(p -> p.getDescripcion()
                .toLowerCase().contains(ocasion.toLowerCase()))
                .collect(Collectors.toList());

    }

    default List<Producto> orderByPrecioDes() {
        return getStream()
                .sorted(Comparator
                        .comparingDouble(Producto::getPrecio)
                         .reversed())
                .collect(Collectors.toList());
    }

    default List<Producto> orderByPrecioAs() {
        return getStream()
                .sorted(Comparator
                        .comparingDouble(Producto::getPrecio))
                       
                .collect(Collectors.toList());
    }

    default List<Producto> orderByVentas() {

        return getStream()
                .sorted(Comparator
                        .comparingInt(Producto::getVentas)
                        .reversed())
                .collect(Collectors.toList());
    }

    default void ActualizarVisitas(Producto producto) {
        int visitas = producto.getVisitas();
        visitas++;
        producto.setVisitas(visitas);
      
    }
    
    default void ActualizarVentas(Producto producto) {
        int ventas = producto.getVentas();
        ventas++;
        producto.setVentas(ventas);
      
    }

}
