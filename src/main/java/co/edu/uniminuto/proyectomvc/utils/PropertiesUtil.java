package co.edu.uniminuto.proyectomvc.utils;

import co.edu.uniminuto.proyectomvc.exceptions.ApplicationException;



import co.edu.uniminuto.proyectomvc.mensajes.MensajesView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {

    //private static final String path = "C:\\HOME SYSTEM\\chatSocket\\ClientChatGUI\\configuracion.properties";
    private static final String path = "configuracion.properties";

    public static Properties get() throws ApplicationException {

        Properties properties = new Properties();
        try {
            InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/configuracion.properties");
             properties.load(inputStream);
            
            //properties.load(new FileInputStream(new File(path)));
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, "SE CARGARON LAS CONFIGURACIONES CORRECTAMENTE");

        } catch (FileNotFoundException e) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, "Connection get()", e);
            throw new ApplicationException(MensajesView.ERROR_CARGANDO_PROPERTIES, e.getMessage(),e.getCause() );
        } catch (IOException e) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, "Connection get()", e);
             throw new ApplicationException(MensajesView.ERROR_CARGANDO_PROPERTIES, e.getMessage(),e.getCause() );
        }
        return properties;

    }

}
