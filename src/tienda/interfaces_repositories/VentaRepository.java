package tienda.interfaces_repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entities.Venta;
import tienda.enums.Entrega;
import tienda.enums.Estado;

public class VentaRepository implements I_VentaRepository {

    private final Connection con;

    public VentaRepository(Connection con) {
        this.con = con;
    }

    @Override
    public void save(Venta venta) {
        if (venta == null) {
            return;
        }
        String s = "insert into ventas(id_clientes, id_usuarios,fecha_venta, importe, estado, entrega,dir_entrega )"
                + "values(?,?,current_date(),?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(
                s,
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setInt(1, venta.getId_cliente());
            ps.setInt(2, venta.getId_usuario());
//            ps.setDate(3,(LocalDate.now()));
            ps.setFloat(3, venta.getImporte());
            ps.setString(4, venta.getEstado().toString());
            ps.setString(5, venta.getEntrega().toString());
            ps.setString(6, venta.getDir_entrega());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Los datos de las ventas no se eliminan, agignamos estado=3, 
    // que quen DB es cancelado
    @Override
    public void remove(Venta venta) {
        if (venta == null) {
            return;
        }

        try (PreparedStatement ps = con.prepareStatement("update ventas set estado= 3 where id =?")) {
            ps.setInt(1, venta.getId());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ProductoRepository.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Venta venta) {
        if (venta == null) {
            return;
        }
        String s = "update ventas set estado=?, entrega=?,dir_entrega=? where id =?";

        try (PreparedStatement ps = con.prepareStatement(s)) {

            ps.setString(1, venta.getEstado().toString());
            ps.setString(2, venta.getEntrega().toString());
            ps.setString(3, venta.getDir_entrega());

            ps.setInt(4, venta.getId());
            ps.execute();

//            int year = venta.getFecha_venta().getYear();
//            int month = venta.getFecha_venta().getMonthValue();
//            int day = venta.getFecha_venta().getDayOfYear();
//            java.sql.Date date = new java.sql.Date(year, month, day);
//            ps.setDate(3, date);
        } catch (SQLException ex) {
            Logger.getLogger(VentaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venta> getAll() {
        List<Venta> ventas = new ArrayList();
        try (ResultSet rs = con.createStatement()
                .executeQuery("select*from ventas")) {
            while (rs.next()) {
                ventas.add(new Venta(
                        rs.getInt("id"),
                        rs.getInt("id_clientes"),
                        rs.getInt("id_usuarios"),
                        rs.getDate(("fecha_venta")),
                        rs.getFloat("importe"),
                        Estado.valueOf(rs.getString("estado")),
                        Entrega.valueOf(rs.getString("entrega")),
                        rs.getString("dir_entrega")
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(VentaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ventas;
    }

}
