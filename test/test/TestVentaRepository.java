
package test;

import tienda.connectors.Connector;
import tienda.entities.Venta;
import tienda.interfaces_repositories.I_VentaRepository;
import tienda.interfaces_repositories.VentaRepository;

public class TestVentaRepository {
    public static void main(String[] args) {
        
        I_VentaRepository ventasRep = new VentaRepository(Connector.getConnection());
//        Venta venta1= new Venta();
        
    }
    
}
