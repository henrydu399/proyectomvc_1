
package co.edu.uniminuto.proyectomvc.config;


import co.edu.uniminuto.proyectomvc.enums.PropertiesEnum;
import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;
import co.edu.uniminuto.proyectomvc.mensajes.MensajesView;
import co.edu.uniminuto.proyectomvc.utils.PropertiesUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionCofig {
    
    private static String host;
    private static String port;
    private static String databaseName;
    private static String user;
    private static String password;
    private static String driverNameDb;

    
    public static void Cofig(Properties p) {
        driverNameDb = p.getProperty(PropertiesEnum.driverNameDb.name());
        host = p.getProperty(PropertiesEnum.hostnameDb.name());
        port = p.getProperty(PropertiesEnum.portDb.name());
        databaseName = p.getProperty(PropertiesEnum.databaseName.name());
        user = p.getProperty(PropertiesEnum.userDb.name());
        password = p.getProperty(PropertiesEnum.PasswordDb.name());
    }
    
   
    
    public static Connection get(Properties p) throws ApplicationException{
        Cofig(p);
        
        
        Connection conn = null;
            try {
                conn = DriverManager.getConnection(driverNameDb+ host +":"+port+"/"+databaseName, user,password );
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {   
            Logger.getLogger(ConexionCofig.class.getName()).log(Level.SEVERE, "Connection get()", e);
            throw  new ApplicationException(MensajesView.ERROR_CONECTANDO_BASE_DATOS,e.getMessage(),e.getCause());           
        } catch (Exception e) {
             Logger.getLogger(ConexionCofig.class.getName()).log(Level.SEVERE, "Connection get()", e);
        }
        return conn;
    }
    
}
