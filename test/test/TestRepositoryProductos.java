
package test;

import java.util.ArrayList;
import java.util.List;
import tienda.connectors.Connector;
import tienda.entities.Producto;
import tienda.enums.Disponible;
import tienda.interfaces_repositories.I_ProductoRepository;
import tienda.interfaces_repositories.ProductoRepository;


public class TestRepositoryProductos {
    public static void main(String[] args) {
        I_ProductoRepository rp =new ProductoRepository(Connector.getConnection());
        Producto r1 =new Producto
        (1096, "Rosa roja", 120, 90, "url", Disponible.SI);
        
        rp.save(r1);
       
        
//        System.out.println("*******r1***********");
        System.out.println(r1);
        
//        Producto r11 =new Producto(1022, "Rosa negra", 200, 120, "url",Disponible.SI);
//         System.out.println("*******r2***********");
//        
//       
//        rp.save(r11);
////        System.out.println(r11);
//        
//        Producto r3 =new Producto(1003, "Rosa blanca", 180, 120, "url",Disponible.SI);
//        rp.save(r3); 
////         System.out.println("*******r1***********");
//        System.out.println(r3);
////        
//         System.out.println("*******save(nuevo)***********");
//        
//        rp.save(new Producto(1201, "Corazon de rosas rojas", 200, 120,"","Corazon de rosas rojas", "url",Disponible.SI));
//        
//        System.out.println("*********todos*****************");
//        
//        rp.getAll().forEach(System.out::println);
//        rp.remove(r3);
//        System.out.println("*********rem");
//        rp.getAll().forEach(System.out::println);
//        System.out.println("*******rojas************");
//        rp.getLikeNombre("rosa").forEach(System.out::println);
//        
//         System.out.println("*******todoslike************");
        

    
     
//      rp.getLikeColor("roja").forEach(System.out::println);

//         rp.getAll().forEach(System.out::println);
       
//      rp.orderByPrecioDes().forEach(System.out::println);
//        System.out.println("******as");
//        rp.orderByPrecioAs().forEach(System.out::println);
//        System.out.println("***********ventas");
//        rp.orderByVentas().forEach(System.out::println);

//    
    
//        System.out.println(r3);
//      
                
                
                
                
                
                
                
                
                
    }
    
}
