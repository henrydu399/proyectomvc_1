
package co.edu.uniminuto.proyectomvc.models;

import co.edu.uniminuto.proyectomvc.controllers.GestorClienteController;
import co.edu.uniminuto.proyectomvc.controllers.MensajeController;
import co.edu.uniminuto.proyectomvc.controllers.PrincipalController;
import co.edu.uniminuto.proyectomvc.utils.PropertiesUtil;
import java.util.List;
import java.util.Properties;



public class PrincipalModel implements Runnable{
    
    private List<Cliente> listaClientes;
    private List<Empleado> listaEmpleados;
    
    private PrincipalController principalController;
    private GestorClienteController gestorClienteController;
    private MensajeController mensajeController;
    
    
    private Properties properties;

    /**
     * Carga todos los componentes de la aplicacion, es importante el orden
    */
    public PrincipalModel() {
        
          // CARGAMOS LOS PROPERTIES
        this.properties = PropertiesUtil.get();
        
        this.gestorClienteController = new GestorClienteController(this);  
        this.principalController = new PrincipalController(this);
        
    }
    
    
    
    
    public void cargarClientes(){
        
    }
    
    public void  adicionarCliente(){
        
    }

    
    
    @Override
    public void run() {
       principalController.show();
        
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public GestorClienteController getGestorClienteController() {
        return gestorClienteController;
    }

    public Properties getProperties() {
        return properties;
    }
    
    
    
    
    
}
