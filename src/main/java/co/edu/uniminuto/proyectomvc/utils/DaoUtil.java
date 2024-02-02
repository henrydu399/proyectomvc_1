/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uniminuto.proyectomvc.utils;

import co.edu.uniminuto.proyectomvc.daos.PersonaDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henry
 */
public class DaoUtil {

    public static void closeAll(Statement s, ResultSet rs) {

        try {
            if (Objects.nonNull(rs)) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (Objects.nonNull(s)) {
                s.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(PersonaDao.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }
    
    
    public static void commit(Connection con){
        try {
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   

}
