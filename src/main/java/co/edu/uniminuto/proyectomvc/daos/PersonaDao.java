package co.edu.uniminuto.proyectomvc.daos;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henry
 */
public class PersonaDao extends Dao implements IDao<Persona> {

    private final String SQLGETALL = "SELECT * FROM PERSONAS";

    private final String SQLSAVE = "INSERT INTO proyectomvc.PERSONAS (PERSONA_NOMBRE,PERSONA_CEDULA,PERSONA_EDAD)"
            + "VALUES (?,?,?)";

    private final String SQLEDITH = "  UPDATE proyectomvc.PERSONAS"
            + "	SET PERSONA_NOMBRE=?   ,   PERSONA_EDAD = ? "
            + "	WHERE PERSONA_CEDULA= ?  ";
    
    private final String SQLDELETE = " DELETE FROM proyectomvc.PERSONAS " +
                                    "	WHERE PERSONA_CEDULA=?";
    
    
    

    //nombres de columnas
    private final String COLUMN_PERSONA_NOMBRE = "PERSONA_NOMBRE";
    private final String COLUMN_PERSONA_CEDULA = "PERSONA_CEDULA";
    private final String COLUMN_PERSONA_EDAD = "PERSONA_EDAD";

    public PersonaDao(Connection con) {
        super(con);
    }

    @Override
    public List<Persona> getAll() throws ApplicationException {
        List<Persona> list = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            stmt = super.con.createStatement();
            rs = stmt.executeQuery(this.SQLGETALL);
            if (rs.isBeforeFirst()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Persona p = new Persona(
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
            throw new ApplicationException("ERROR GUARDANDO LA PERSONA ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }
    }

    @Override
    public void save(Persona u) throws ApplicationException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.prepareStatement(this.SQLSAVE);
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getCedula());
            stmt.setInt(3, u.getEdad());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ApplicationException("ERROR GUARDANDO PERSONAS ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }

    }

    @Override
    public void edith(Persona u) throws ApplicationException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.prepareStatement(this.SQLEDITH);
            stmt.setString(1, u.getNombre());
            stmt.setInt(2, u.getEdad());
            stmt.setString(3, u.getCedula());

            stmt.executeUpdate();
            super.con.commit();
        } catch (SQLException ex) {
            DaoUtil.rollback(super.con);
            ex.printStackTrace();
            throw new ApplicationException("ERROR EDITANDO PERSONAS ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }
    }

    @Override
    public Persona find(Persona p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Persona> findAll(Persona p) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Persona u) throws ApplicationException {
             PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.con.prepareStatement(this.SQLDELETE);
            stmt.setString(1, u.getCedula());
            stmt.executeUpdate();
            super.con.commit();
        } catch (SQLException ex) {
            DaoUtil.rollback(super.con);
            ex.printStackTrace();
            throw new ApplicationException("ERROR ELIMINANDO PERSONAS ", ex.getMessage(), ex.getCause());
        } finally {
            DaoUtil.closeAll(stmt, rs);
        }
        
        
    }

    @Override
    public void desactivate(Persona usuario) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Connection getCon() {
        return con;
    }

}
