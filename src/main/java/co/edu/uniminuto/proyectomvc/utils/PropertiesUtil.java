package co.edu.uniminuto.proyectomvc.utils;

import co.edu.uniminuto.proyectomvc.models.exceptions.ApplicationException;



import co.edu.uniminuto.proyectomvc.mensajes.MensajesView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesUtil {

    //private static final String path = "C:\\HOME SYSTEM\\chatSocket\\ClientChatGUI\\configuracion.properties";
    private static final String path = "configuracion.properties";

    public static Properties get() throws ApplicationException {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(path)));
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, "SE CARGARON LAS CONFIGURACIONES CORRECTAMENTE");

        } catch (FileNotFoundException e) {
            Logger.getLogger(PropertiesUtil.class.getName()).log(Level.SEVERE, "Connection get()", e);
            throw new ApplicationException(MensajesView.ERROR_CARGANDO_PROPERTIES, e.getMessage(),e.getCause() );
        } catch (IOException e) {
             throw new ApplicationException(MensajesView.ERROR_CARGANDO_PROPERTIES, e.getMessage(),e.getCause() );
        }
        return properties;

    }

}
