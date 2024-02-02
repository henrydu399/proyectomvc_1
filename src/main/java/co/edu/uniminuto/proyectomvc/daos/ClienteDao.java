/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.daos;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.models.Cliente;
import co.edu.uniminuto.proyectomvc.models.Persona;
import co.edu.uniminuto.proyectomvc.utils.DaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author henry
 */
public class ClienteDao extends Dao implements IDao<Cliente> {

    private final String SQLGETALL = "SELECT * FROM CLIENTES C JOIN PERSONAS  P ON (C.CLIENTE_CEDULA = P.PERSONA_CEDULA );";

    private final String SQLSAVE = "INSERT INTO proyectomvc.CLIENTES (CLIENTE_CEDULA,CLIENTE_TELEFONO)" + "VALUES (?,?)";

    private final String SQLFIND = "SELECT * FROM CLIENTES C JOIN PERSONAS  P ON (C.CLIENTE_CEDULA = P.PERSONA_CEDULA ) WHERE 1 = 1";
    
    private final String SQLDELETE = "DELETE FROM CLIENTES WHERE  CLIENTE_CEDULA = ? AND  CLIENTE_TELEFONO = ?";
    
     private final String SQLEDITH = "  UPDATE proyectomvc.CLIENTES "
            + "	SET PERSONA_NOMBRE=?   ,   PERSONA_EDAD = ? "
            + "	WHERE PERSONA_CEDULA= ?  ";

    private final String COLUMN_PERSONA_NOMBRE = "PERSONA_NOMBRE";
    private final String COLUMN_PERSONA_CEDULA = "PERSONA_CEDULA";
    private final String COLUMN_PERSONA_EDAD = "PERSONA_EDAD";

    private final String COLUMN_CLIENTE_CEDULA = "CLIENTE_CEDULA";
    private final String COLUMN_CLIENTE_TELEFONO = "CLIENTE_TELEFONO";

    public ClienteDao(Connection con) {
        super(con);

    }

    @Override
    public List<Cliente> getAll() throws ApplicationException {
        List<Cliente> list = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            stmt = super.con.createStatement();
            rs = stmt.executeQuery(this.SQLGETALL);
            if (rs.isBeforeFirst()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Cliente p = new Cliente(
                            rs.getString(COLUMN_CLIENTE_TELEFONO),
                            rs.getString(COLUMN_PERSONA_NOMBRE),
                            rs.getString(COLUMN_PERSONA_CEDULA),
                            rs.getInt(COLUMN_PERSONA_EDAD)
                    );
                    list.add(p);
                }
            }

            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ApplicationException("Error consultando los clientes ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }
    }

    @Override
    public void save(Cliente u) throws ApplicationException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.prepareStatement(this.SQLSAVE);
            stmt.setString(1, u.getCedula());
            stmt.setString(2, u.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ApplicationException("Error guardando el cliente ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }

    }

    @Override
    public void edith(Cliente p) throws ApplicationException {
        return;
    }

    @Override
    public Cliente find(Cliente p) throws ApplicationException {
        List<Cliente> list = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.createStatement();
            StringBuffer query = new StringBuffer(SQLFIND);

            if (Objects.nonNull(p.getCedula()) && !p.getCedula().isEmpty()) {
                query.append("  AND ( C.CLIENTE_CEDULA = '"+ p.getCedula()+"'");
            }

            if (Objects.nonNull(p.getTelefono()) && !p.getTelefono().isEmpty()) {
                query.append("  OR C.CLIENTE_TELEFONO =  '"+p.getTelefono() + "'");
            }

            if (Objects.nonNull(p.getNombre()) && !p.getNombre().isEmpty()) {
                query.append("  OR P.PERSONA_NOMBRE =  '"+p.getNombre() + "' )");
            }
            
            System.out.print(query.toString());

            rs = stmt.executeQuery(query.toString());
           
            if (rs.isBeforeFirst()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Cliente c = new Cliente(
                            rs.getString(COLUMN_CLIENTE_TELEFONO),
                            rs.getString(COLUMN_PERSONA_NOMBRE),
                            rs.getString(COLUMN_PERSONA_CEDULA),
                            rs.getInt(COLUMN_PERSONA_EDAD)
                    );
                    return c;
                }
            }

            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ApplicationException("Error consultando los clientes ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }

    }

    @Override
    public List<Cliente> findAll(Cliente p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Cliente u) throws ApplicationException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.prepareStatement(this.SQLDELETE);
            stmt.setString(1, u.getCedula());
            stmt.setString(2, u.getTelefono());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ApplicationException("Error eliminado  el cliente ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }
    }

    @Override
    public void desactivate(Cliente usuario) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Connection getCon() {
        return con;
    }

}
