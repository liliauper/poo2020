
package test;

import tienda.connectors.Connector;
import tienda.entities.Cliente;

import tienda.interfaces_repositories.I_ClienteRepository;
import tienda.interfaces_repositories.ClienteRepository;

public class TestClienteRepository {
    public static void main(String[] args) {
        I_ClienteRepository clienteRep =new ClienteRepository(Connector.getConnection());
        
//        Cliente cliente1=new Cliente("Juan","Perez","77700000",
//                "Argentina","CABA","Moreno 123","1444",
//                "77777777","xxx@gmail.com","14-11--1999",
//                "xxxxxx");
//        clienteRep.save(cliente1);
//        System.out.println(cliente1);
////        
//        Cliente cliente2=new Cliente("Juan","Lopez","23500000",
//                "Argentina","Lanus","Alsina 123","2020",
//                "77777777","kkk@gmail.com","14-11--1999",
//               "xxxxxx");
//        
//        Cliente cliente3=new Cliente("Jorge","Lazcano","333300000",
//                "Argentina","Lanus","Alsina 123","2020",
//                "77777777","kkk@gmail.com","14-11--1999",
//              "xxxxxx");
//        clienteRep.save(cliente3);
//        System.out.println(cliente3);
//        
//        clienteRep.getAll().forEach(System.out::println);
//        clienteRep.remove(cliente2);
//        
//        clienteRep.getAll().forEach(System.out::println);
        
//        Cliente cliente7=new Cliente("Ivan","Lazcano","883300000",
//                "Argentina","Lanus","Alsina 123","2020",
//                "77777777","kkk@gmail.com","14-11--1999",
//                Usuario_registrado.NO,"xxxxxx");
//        clienteRep.save(cliente7);
//        
      
        Cliente c=clienteRep.getById(7);
        System.out.println(c);
        Cliente cl=clienteRep.getByDni_cuit("333300000");
        System.out.println(cl);
        clienteRep.getLikeApellido("lazcano").
                forEach(System.out::println);
        
        
    }
    
}
